package com.github.winniehell.testdatafactory.dummy;

import com.github.winniehell.testdatafactory.factory.TestData;
import com.github.winniehell.testdatafactory.factory.TestDataFactoryException;
import org.junit.Assert;
import org.junit.Test;

public class TestAClass {
    @Test
    public void toStringTest() throws TestDataFactoryException {
        final AClass a = TestData
                .forClass(AClass.class)
                .create();

        Assert.assertEquals(a.toString(), AClass.class.getSimpleName());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void toStringWithParameterTest() throws TestDataFactoryException {
        TestData.forClass(AClass.class)
                .withParameter("foo")
                .create();
    }
}
