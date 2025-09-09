package mariapiabaldoin.progetto_anagrafica.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String via;
    private int numeroCivico;
    private String citta;
    private String provincia;
    private String nazione;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public int getNumeroCivico() {
        return numeroCivico;
    }

    public void setNumeroCivico(int numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }


    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", via='" + via + '\'' +
                ", numeroCivico=" + numeroCivico +
                ", citta='" + citta + '\'' +
                ", provincia='" + provincia + '\'' +
                ", nazione='" + nazione + '\'' +
                '}';
    }
}
