package com.github.winniehell.testdatafactory.factory;

import com.github.winniehell.testdatafactory.dummy.BClass;

/**
 * {@link TestDataFactory Factory} for {@link BClass dummy class with parameter}.
 *
 * @author winniehell
 */
class BClassFactory implements TestDataFactory<BClass> {

    private String parameter;

    @Override
    public BClass create() {
        if(this.parameter == null) {
            return new BClass("default");
        }
        else {
            return new BClass(this.parameter);
        }
    }

    @Override
    public TestDataFactory<BClass> withParameter(final String parameter) {
        this.parameter = parameter;
        return this;
    }
}
