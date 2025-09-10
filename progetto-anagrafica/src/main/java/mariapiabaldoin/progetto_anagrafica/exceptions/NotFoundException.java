package mariapiabaldoin.progetto_anagrafica.exceptions;


public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}