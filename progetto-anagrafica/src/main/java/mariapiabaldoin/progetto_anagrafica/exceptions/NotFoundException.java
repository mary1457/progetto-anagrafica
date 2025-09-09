package mariapiabaldoin.progetto_anagrafica.exceptions;


public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("The record with ID " + id + " was not found");
    }

    public NotFoundException(String message) {
        super(message);
    }
}