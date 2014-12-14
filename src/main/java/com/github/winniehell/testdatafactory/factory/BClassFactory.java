package com.github.winniehell.testdatafactory.factory;

import com.github.winniehell.testdatafactory.dummy.BClass;
import org.apache.commons.lang3.Validate;

import java.util.Collections;
import java.util.Set;

import static com.github.winniehell.testdatafactory.factory.TestDataFactory.Parameter.PARAM_B;

/**
 * {@link TestDataFactory Factory} for {@link BClass dummy class with mandatory parameter}.
 *
 * @author winniehell
 */
class BClassFactory implements TestDataFactory<BClass> {

    private String parameter;

    @Override
    public BClass create() {
        Validate.notNull(this.parameter, "Parameter " + PARAM_B + " not set!");
        return new BClass(this.parameter);
    }

    @Override
    public TestDataFactory<? extends BClass> with(final Parameter parameter, final Object value) throws IllegalArgumentException {
        Validate.isTrue(PARAM_B.equals(parameter), "Unsupported parameter!");
        Validate.isTrue(this.parameter == null, "Parameter " + PARAM_B + " already set!");
        this.parameter = (String) value;
        return this;
    }

    @Override
    public Set<Class> getSupportedClasses() {
        return Collections.singleton((Class) BClass.class);
    }
}
