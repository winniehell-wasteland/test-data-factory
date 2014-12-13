package com.github.winniehell.testdatafactory.factory;

import com.github.winniehell.testdatafactory.dummy.AClass;
import com.github.winniehell.testdatafactory.dummy.BClass;
import org.apache.commons.lang3.Validate;

import java.util.HashMap;
import java.util.Map;

/**
 * Helper class for creating test data using a {@link #registerFactory(Class, TestDataFactory) registered}
 * {@link TestDataFactory}.
 *
 * @author winniehell
 */
public final class TestData {
    private static final Map<Class<?>, TestDataFactory<?>> testDataFactories = new HashMap<>();

    static {
        TestData.registerFactory(AClass.class, new AClassFactory());
        TestData.registerFactory(BClass.class, new BClassFactory());
    }

    /**
     * Registers a {@link TestDataFactory} for a given class under test.
     *
     * @param classUnderTest {@link Class} to register the factory for
     * @param factory {@link TestDataFactory} instance which is used for creating new factories by {@link #forClass(Class)}.
     * @param <T> type of created test data
     */
    private static <T> void registerFactory(final Class<T> classUnderTest, final TestDataFactory<? extends T> factory) {
        testDataFactories.put(classUnderTest, factory);
    }

    /**
     * Looks up the {@link TestDataFactory factory} to create given type of test data.
     *
     * @param classUnderTest class of test data to create
     * @param <T> type of test data to create
     * @return a new instance of the factory registered for the test data class
     * @throws TestDataFactoryException if instantiating the {@link TestDataFactory factory} failed
     */
    @SuppressWarnings("unchecked")
    public static <T> TestDataFactory<? extends T> forClass(final Class<T> classUnderTest) throws TestDataFactoryException {
        try {
            Validate.isTrue(testDataFactories.containsKey(classUnderTest), "Unknown class under test!");

            final TestDataFactory<?> factory = testDataFactories.get(classUnderTest);

            // clone factory to loose state of stateful factories
            return (TestDataFactory<? extends T>) factory.getClass().newInstance();
        } catch (final Exception e) {
            throw new TestDataFactoryException(e);
        }
    }

    /**
     * Only static members.
     */
    private TestData() {

    }

}
