package mariapiabaldoin.progetto_anagrafica.services;

import mariapiabaldoin.progetto_anagrafica.entities.Address;
import mariapiabaldoin.progetto_anagrafica.entities.Person;
import mariapiabaldoin.progetto_anagrafica.exceptions.BadRequestException;
import mariapiabaldoin.progetto_anagrafica.payloads.PersonDTO;
import mariapiabaldoin.progetto_anagrafica.repositories.AddressRepository;
import mariapiabaldoin.progetto_anagrafica.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    public Person savePerson(PersonDTO body) throws Exception {
        // Controllo se la persona esiste già
        this.personRepository.findById(body.codiceFiscale())
                .ifPresent(person -> {
                    throw new BadRequestException("La persona con codice fiscale " + body.codiceFiscale() + " esiste già!");
                });

        Address addressDTO = body.address();

        // Usa la query ottimizzata per trovare un indirizzo già esistente
        Address addressToUse = this.addressRepository.findExistingAddress(
                addressDTO.getVia(),
                addressDTO.getNumeroCivico(),
                addressDTO.getCitta(),
                addressDTO.getProvincia(),
                addressDTO.getNazione()
        ).orElseGet(() -> this.addressRepository.save(addressDTO));

        // Creazione nuova persona
        Person newPerson = new Person();
        newPerson.setCodiceFiscale(body.codiceFiscale());
        newPerson.setNome(body.nome());
        newPerson.setCognome(body.cognome());
        newPerson.setAddress(addressToUse);

        // Salvataggio persona
        this.personRepository.save(newPerson);

        return newPerson;
    }


}
