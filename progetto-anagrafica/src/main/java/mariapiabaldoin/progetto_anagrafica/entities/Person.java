package mariapiabaldoin.progetto_anagrafica.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    private String codiceFiscale; // chiave primaria

    private String nome;
    private String cognome;

    // Ogni persona ha un solo indirizzo (ManyToOne unidirezionale)
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;


    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Person{" +
                "codiceFiscale='" + codiceFiscale + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", addressId=" + (address != null ? address.getId() : null) +
                '}';
    }
}
