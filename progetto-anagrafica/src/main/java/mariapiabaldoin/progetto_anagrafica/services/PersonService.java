package mariapiabaldoin.progetto_anagrafica.services;

import mariapiabaldoin.progetto_anagrafica.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;


}
