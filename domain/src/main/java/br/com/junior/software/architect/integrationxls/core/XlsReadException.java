package br.com.junior.software.architect.integrationxls.core;

import java.io.IOException;

public class XlsReadException extends RuntimeException{
    public XlsReadException(IOException exception) {
        super(exception);
    }
}
