package net.focik.scopegasconnectionservice.domain.exceptions;

public class ScopeGasConnectionDoesNotExistException extends ObjectDoesNotExistException {
    public ScopeGasConnectionDoesNotExistException(Integer id) {
        super("ScopeGasConnection with id = " + id + " does not exist");
    }

}
