package mariapiabaldoin.progetto_anagrafica.repositories;


import mariapiabaldoin.progetto_anagrafica.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {

    // Ricerca per codice fiscale
    Optional<Person> findByCodiceFiscale(String codiceFiscale);

    // Verifica se esiste una persona con codice fiscale
    boolean existsByCodiceFiscale(String codiceFiscale);
}
