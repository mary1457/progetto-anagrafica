package mariapiabaldoin.progetto_anagrafica.services;

import mariapiabaldoin.progetto_anagrafica.entities.Address;
import mariapiabaldoin.progetto_anagrafica.entities.Person;
import mariapiabaldoin.progetto_anagrafica.exceptions.BadRequestException;
import mariapiabaldoin.progetto_anagrafica.exceptions.NotFoundException;
import mariapiabaldoin.progetto_anagrafica.payloads.PersonDTO;
import mariapiabaldoin.progetto_anagrafica.repositories.AddressRepository;
import mariapiabaldoin.progetto_anagrafica.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    public Person savePerson(PersonDTO body) {
        // Controllo se la persona esiste già
        this.personRepository.findById(body.codiceFiscale())
                .ifPresent(person -> {
                    throw new BadRequestException("La persona con codice fiscale " + body.codiceFiscale() + " esiste già!");
                });

        Address address = body.address();


        Address addressToUse = this.addressRepository.findExistingAddress(
                address.getVia(),
                address.getNumeroCivico(),
                address.getCitta(),
                address.getProvincia(),
                address.getNazione()
        ).orElseGet(() -> this.addressRepository.save(address));


        Person newPerson = new Person();
        newPerson.setCodiceFiscale(body.codiceFiscale());
        newPerson.setNome(body.nome());
        newPerson.setCognome(body.cognome());
        newPerson.setAddress(addressToUse);


        this.personRepository.save(newPerson);

        return newPerson;
    }


    public Page<Person> findAll(int page, int size, String sortBy) {
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.personRepository.findAll(pageable);
    }


    public Person findByCodiceFiscale(String codiceFiscale) {
        return this.personRepository.findById(codiceFiscale)
                .orElseThrow(() -> new NotFoundException("Persona con codice fiscale " + codiceFiscale + " non trovata!"));
    }


    public Person updatePerson(String codiceFiscale, PersonDTO body) {
        Person found = this.findByCodiceFiscale(codiceFiscale);


        Address address = body.address();
        Address addressToUse = this.addressRepository.findExistingAddress(
                address.getVia(),
                address.getNumeroCivico(),
                address.getCitta(),
                address.getProvincia(),
                address.getNazione()
        ).orElseGet(() -> this.addressRepository.save(address));


        found.setNome(body.nome());
        found.setCognome(body.cognome());
        found.setAddress(addressToUse);

        return this.personRepository.save(found);
    }


    public void deletePerson(String codiceFiscale) {
        Person found = this.findByCodiceFiscale(codiceFiscale);
        this.personRepository.delete(found);
    }

}
