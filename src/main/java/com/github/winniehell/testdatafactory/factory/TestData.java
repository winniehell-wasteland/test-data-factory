package com.github.winniehell.testdatafactory.factory;

import org.apache.commons.lang3.Validate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Helper class for creating test data using a {@link #registerFactory(Class) registered} {@link
 * TestDataFactory}.
 *
 * @author winniehell
 */
public final class TestData {

    private static final Map<Class<?>, Class<? extends TestDataFactory<?>>> testDataFactories = new HashMap<>();

    static {
        TestData.registerFactory(AClassFactory.class);
        TestData.registerFactory(BClassFactory.class);
    }

    /**
     * Registers a {@link TestDataFactory} to be used by {@link #forClass(Class)}.
     *
     * @param factoryClass {@link TestDataFactory} class
     */
    private static void registerFactory(final Class<? extends TestDataFactory<?>> factoryClass) {
        try {
            final TestDataFactory<?> dummyInstance = factoryClass.newInstance();
            final Set<Class> supportedClasses = dummyInstance.getSupportedClasses();

            for (final Class<?> classUnderTest : supportedClasses) {
                Validate.isTrue(!testDataFactories.containsKey(classUnderTest),
                        "There is already a factory registered for " + classUnderTest);
                testDataFactories.put(classUnderTest, factoryClass);
            }
        } catch (final Exception e) {
            System.err.println("Could not register factory " + factoryClass + "! " + e.getMessage());
        }
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

            final Class<? extends TestDataFactory<?>> factoryClass = testDataFactories.get(classUnderTest);

            return (TestDataFactory<? extends T>) factoryClass.newInstance();
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
