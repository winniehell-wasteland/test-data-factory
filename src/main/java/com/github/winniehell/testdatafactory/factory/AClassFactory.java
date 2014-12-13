package com.github.winniehell.testdatafactory.factory;

import com.github.winniehell.testdatafactory.dummy.AClass;

/**
 * {@link TestDataFactory Factory} for {@link AClass dummy class without parameter}.
 *
 * @author winniehell
 */
class AClassFactory implements TestDataFactory<AClass> {

    @Override
    public AClass create() {
        return new AClass();
    }

    @Override
    public TestDataFactory<AClass> withParameter(final String parameter) throws UnsupportedOperationException {
        throw new UnsupportedOperationException(AClass.class + " has no parameter!");
    }
}
