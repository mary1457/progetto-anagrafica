package mariapiabaldoin.progetto_anagrafica.repositories;


import mariapiabaldoin.progetto_anagrafica.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {


}
