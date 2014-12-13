package com.github.winniehell.testdatafactory.dummy;

/**
 * Dummy class with optional parameter.
 *
 * @author winniehell
 */
public class AClass {
    /**
     * Dummy parameter.
     */
    private final String parameter;

    public AClass(final String parameter) {
        this.parameter = parameter;
    }

    public AClass() {
        this("default");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " with parameter = '" + this.parameter + "'";
    }

}
