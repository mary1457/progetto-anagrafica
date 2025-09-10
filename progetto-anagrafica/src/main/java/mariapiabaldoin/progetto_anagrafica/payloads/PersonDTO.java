package mariapiabaldoin.progetto_anagrafica.payloads;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import mariapiabaldoin.progetto_anagrafica.entities.Address;


public record PersonDTO(

        @NotBlank(message = "Il codice fiscale è obbligatorio!")
        @Pattern(
                regexp = "^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$",
                message = "Formato codice fiscale non valido!"
        )
        String codiceFiscale,

        @NotBlank(message = "Il nome è obbligatorio!")
        @Size(min = 2, max = 40, message = "Il nome deve essere compreso tra 2 e 40 caratteri!")
        String nome,

        @NotBlank(message = "Il cognome è obbligatorio!")
        @Size(min = 2, max = 40, message = "Il cognome deve essere compreso tra 2 e 40 caratteri!")
        String cognome,

        @NotNull(message = "L'indirizzo è obbligatorio!")
        @Valid
        Address address
) {
}
