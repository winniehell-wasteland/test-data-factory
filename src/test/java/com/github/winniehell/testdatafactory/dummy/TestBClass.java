package com.github.winniehell.testdatafactory.dummy;

import com.github.winniehell.testdatafactory.factory.TestData;
import com.github.winniehell.testdatafactory.factory.TestDataFactoryException;
import org.junit.Assert;
import org.junit.Test;

import static com.github.winniehell.testdatafactory.factory.TestDataFactory.Parameter.PARAM_A;
import static com.github.winniehell.testdatafactory.factory.TestDataFactory.Parameter.PARAM_B;

public class TestBClass {
    @Test(expected = NullPointerException.class)
    public void withoutParameterTest() throws TestDataFactoryException {
        TestData.forClass(BClass.class)
                .create();
    }

    @Test
    public void withParameterTest() throws TestDataFactoryException {
        final String parameter = "foo";
        final BClass b = TestData
                .forClass(BClass.class)
                .with(PARAM_B, parameter)
                .create();

        Assert.assertEquals(BClass.class.getSimpleName() + " with parameter = '" + parameter + "'", b.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void withWrongParameterTest() throws TestDataFactoryException {
        TestData.forClass(BClass.class)
                .with(PARAM_A, null)
                .create();
    }
}
