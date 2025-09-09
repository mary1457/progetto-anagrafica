package mariapiabaldoin.progetto_anagrafica.payloads;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AddressDTO(
        @NotBlank(message = "La via è obbligatoria!")
        @Size(min = 2, max = 100, message = "La via deve avere tra 2 e 100 caratteri!")
        String via,

        @Min(value = 1, message = "Il numero civico deve essere maggiore di 0")
        int numeroCivico,

        @NotBlank(message = "La città è obbligatoria!")
        @Size(min = 2, max = 60, message = "La città deve avere tra 2 e 60 caratteri!")
        String citta,

        @NotBlank(message = "La provincia è obbligatoria!")
        @Size(min = 2, max = 40, message = "La provincia deve avere tra 2 e 40 caratteri!")
        String provincia,

        @NotBlank(message = "La nazione è obbligatoria!")
        @Size(min = 2, max = 60, message = "La nazione deve avere tra 2 e 60 caratteri!")
        String nazione
) {
}
