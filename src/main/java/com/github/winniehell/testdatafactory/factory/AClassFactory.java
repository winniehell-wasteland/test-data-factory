package com.github.winniehell.testdatafactory.factory;

import com.github.winniehell.testdatafactory.dummy.AClass;
import org.apache.commons.lang3.Validate;

import java.util.Collections;
import java.util.Set;

import static com.github.winniehell.testdatafactory.factory.TestDataFactory.Parameter.PARAM_A;

/**
 * {@link TestDataFactory Factory} for {@link AClass dummy class with optional parameter}.
 *
 * @author winniehell
 */
class AClassFactory implements TestDataFactory<AClass> {

    private String parameter;

    @Override
    public AClass create() {
        if (parameter == null) {
            return new AClass();
        } else {
            return new AClass(this.parameter);
        }
    }

    @Override
    public TestDataFactory<AClass> with(final Parameter parameter, final Object value) throws IllegalArgumentException {
        Validate.isTrue(PARAM_A.equals(parameter), "Unsupported parameter!");
        Validate.isTrue(this.parameter == null, "Parameter " + PARAM_A + " already set!");
        this.parameter = (String) value;
        return this;
    }

    @Override
    public Set<Class> getSupportedClasses() {
        return Collections.singleton((Class) AClass.class);
    }
}
