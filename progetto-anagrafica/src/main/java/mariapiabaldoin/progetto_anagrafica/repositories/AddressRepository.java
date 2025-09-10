package mariapiabaldoin.progetto_anagrafica.repositories;


import mariapiabaldoin.progetto_anagrafica.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query("SELECT a FROM Address a " +
            "WHERE LOWER(a.via) = LOWER(:via) " +
            "AND a.numeroCivico = :numeroCivico " +
            "AND LOWER(a.citta) = LOWER(:citta) " +
            "AND LOWER(a.provincia) = LOWER(:provincia) " +
            "AND LOWER(a.nazione) = LOWER(:nazione)")
    Optional<Address> findExistingAddress(
            @Param("via") String via,
            @Param("numeroCivico") int numeroCivico,
            @Param("citta") String citta,
            @Param("provincia") String provincia,
            @Param("nazione") String nazione
    );

}
