package com.github.winniehell.testdatafactory.dummy;

import com.github.winniehell.testdatafactory.factory.TestData;
import com.github.winniehell.testdatafactory.factory.TestDataFactoryException;
import org.junit.Assert;
import org.junit.Test;

public class TestBClass {
    @Test
    public void toStringTest() throws TestDataFactoryException {
        final BClass b = TestData
                .forClass(BClass.class)
                .create();

        Assert.assertEquals(BClass.class.getSimpleName() + " with parameter = 'default'", b.toString());
    }

    @Test
    public void toStringWithParameterTest() throws TestDataFactoryException {
        final String parameter = "foo";

        final BClass b = TestData
                .forClass(BClass.class)
                .withParameter(parameter)
                .create();

        Assert.assertEquals(BClass.class.getSimpleName() + " with parameter = '" + parameter + "'", b.toString());
    }
}
