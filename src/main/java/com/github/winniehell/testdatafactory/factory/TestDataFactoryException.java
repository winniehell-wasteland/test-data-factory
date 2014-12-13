package com.github.winniehell.testdatafactory.factory;

/**
 * {@link Exception} for anything that does not work during {@link TestDataFactory} instantiation.
 *
 * @author winniehell
 * @see TestData
 */
public class TestDataFactoryException extends Exception {

    /**
     * Wraps an internal {@link Exception}.
     *
     * @param cause internal {@link Exception}
     */
    public TestDataFactoryException(final Throwable cause) {
        super(cause);
    }

}
