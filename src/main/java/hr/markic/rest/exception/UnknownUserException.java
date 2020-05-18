package hr.markic.rest.exception;

public class UnknownUserException extends Exception {

    private final Long id;

    public UnknownUserException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
