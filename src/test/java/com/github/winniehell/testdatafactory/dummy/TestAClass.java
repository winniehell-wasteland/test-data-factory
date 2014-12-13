package com.github.winniehell.testdatafactory.dummy;

import com.github.winniehell.testdatafactory.factory.TestData;
import com.github.winniehell.testdatafactory.factory.TestDataFactoryException;
import org.junit.Assert;
import org.junit.Test;

import static com.github.winniehell.testdatafactory.factory.TestDataFactory.Parameter.PARAM_A;
import static com.github.winniehell.testdatafactory.factory.TestDataFactory.Parameter.PARAM_B;

public class TestAClass {
    @Test
    public void withoutParameterTest() throws TestDataFactoryException {
        final AClass a = TestData
                .forClass(AClass.class)
                .create();

        Assert.assertEquals(AClass.class.getSimpleName() + " with parameter = 'default'", a.toString());
    }

    @Test
    public void withParameterTest() throws TestDataFactoryException {
        final String parameter = "foo";
        final AClass a = TestData
                .forClass(AClass.class)
                .with(PARAM_A, parameter)
                .create();

        Assert.assertEquals(AClass.class.getSimpleName() + " with parameter = '" + parameter + "'", a.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void withWrongParameterTest() throws TestDataFactoryException {
        TestData.forClass(AClass.class)
                .with(PARAM_B, null)
                .create();
    }
}
