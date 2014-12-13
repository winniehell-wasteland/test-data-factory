package com.github.winniehell.testdatafactory.dummy;

/**
 * Dummy class with parameter.
 *
 * @author winniehell
 */
public class BClass {
    /**
     * Dummy parameter.
     */
    private final String parameter;

    @SuppressWarnings("javadoc")
    public BClass(final String parameter) {
        this.parameter = parameter;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " with parameter = '" + this.parameter + "'";
    }

}
