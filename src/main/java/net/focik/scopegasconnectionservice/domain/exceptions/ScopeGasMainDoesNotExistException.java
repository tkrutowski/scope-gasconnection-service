package net.focik.scopegasconnectionservice.domain.exceptions;

public class ScopeGasMainDoesNotExistException extends ObjectDoesNotExistException{
    public ScopeGasMainDoesNotExistException(Integer id) {
        super("ScopeGasConnection with id = " + id + " does not exist");
    }
}
