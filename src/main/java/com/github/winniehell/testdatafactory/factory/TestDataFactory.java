package com.github.winniehell.testdatafactory.factory;

import org.apache.commons.collections4.Factory;

import java.util.Set;

/**
 * {@link Factory} for test data of a specific type.
 *
 * @param <T> type of test data created by this factory
 */
public interface TestDataFactory<T> extends Factory<T> {

    /**
     * All parameters which may be passed to {@link TestDataFactory#with(Parameter, Object) factories}.
     */
    enum Parameter {
        /**
         * First dummy parameter.
         */
        PARAM_A,
        /**
         * Second dummy parameter.
         */
        PARAM_B
    }

    /**
     * Modifies factory to build test data with given parameter.
     *
     * @param parameter {@link Parameter} to be passed to test data
     * @param value parameter value
     * @return {@code this}
     * @throws IllegalArgumentException if test data does not support the given parameter
     */
    TestDataFactory<? extends T> with(Parameter parameter, Object value) throws IllegalArgumentException;

    Set<Class> getSupportedClasses();
}
