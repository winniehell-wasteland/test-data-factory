package com.github.winniehell.testdatafactory.factory;

import org.apache.commons.collections4.Factory;

/**
 * {@link Factory} for test data of a specific type.
 *
 * @param <T> type of test data created by this factory
 */
public interface TestDataFactory<T> extends Factory<T> {

    /**
     * Modifies factory to build test data with given parameter.
     *
     * @param parameter dummy parameter to be passed to test data
     * @return {@code this}
     * @throws UnsupportedOperationException if test data does not support the dummy parameter
     */
    TestDataFactory<? extends T> withParameter(String parameter) throws UnsupportedOperationException;
}
