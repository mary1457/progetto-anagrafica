package mariapiabaldoin.progetto_anagrafica.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La via è obbligatoria")
    private String via;

    @Min(value = 1, message = "Il numero civico deve essere maggiore di 0")
    private int numeroCivico;

    @NotBlank(message = "La città è obbligatoria")
    private String citta;

    @NotBlank(message = "La provincia è obbligatoria")
    private String provincia;

    @NotBlank(message = "La nazione è obbligatoria")
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
