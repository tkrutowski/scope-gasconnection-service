package net.focik.scopework.scopegasconnection.domain.exceptions;

import net.focik.scopework.exceptions.ObjectDoesNotExistException;

public class ScopeGasConnectionDoesNotExistException extends ObjectDoesNotExistException {
    public ScopeGasConnectionDoesNotExistException(Integer id) {
        super("ScopeGasConnection with id = " + id + " does not exist");
    }

}
