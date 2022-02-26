package net.focik.scopework.scopegasconnection.domain.exceptions;

import net.focik.scopework.exceptions.ObjectDoesNotExistException;

public class ScopeGasMainDoesNotExistException extends ObjectDoesNotExistException {
    public ScopeGasMainDoesNotExistException(Integer id) {
        super("ScopeGasConnection with id = " + id + " does not exist");
    }
}
