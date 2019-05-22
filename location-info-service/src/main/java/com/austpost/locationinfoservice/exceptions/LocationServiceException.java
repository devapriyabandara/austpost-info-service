/*
    This class implemented to handle Location Service related custom exceptions

 */
package com.austpost.locationinfoservice.exceptions;

public class LocationServiceException extends RuntimeException {

    private static final long serielVersionUID = 5776681206288518465L;

    public LocationServiceException(String message){
            super(message);
    }

}
