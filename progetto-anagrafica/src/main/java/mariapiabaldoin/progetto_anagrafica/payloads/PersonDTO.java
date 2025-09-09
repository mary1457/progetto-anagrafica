package mariapiabaldoin.progetto_anagrafica.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record PersonDTO(
        @NotEmpty(message = "Il codice fiscale è obbligatorio!")
        @Size(min = 11, max = 16, message = "Il codice fiscale deve avere tra 11 e 16 caratteri!")
        String codiceFiscale,

        @NotEmpty(message = "Il nome è obbligatorio!")
        @Size(min = 2, max = 40, message = "Il nome deve essere compreso tra 2 e 40 caratteri!")
        String nome,

        @NotEmpty(message = "Il cognome è obbligatorio!")
        @Size(min = 2, max = 40, message = "Il cognome deve essere compreso tra 2 e 40 caratteri!")
        String cognome,

        Long addressId // id dell’indirizzo a cui associare la persona
) {
}
