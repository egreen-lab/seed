package org.egreen.seed.impl.config.externder;

import javassist.bytecode.annotation.*;

import java.util.List;

/**
 * Created by dewmal on 4/1/15.
 */
public class PropertiesMemberValueVisitor
        implements MemberValueVisitor {

    private final List<String> properties;

    public PropertiesMemberValueVisitor(List<String> properties) {
        this.properties = properties;
    }

    @Override
    public void visitArrayMemberValue(ArrayMemberValue value) {
        MemberValue[] values = value.getValue();
        for (MemberValue memberValue : values) {
            memberValue.accept(this);
        }
    }

    @Override
    public void visitStringMemberValue(StringMemberValue value) {
        String propertyValue = value.getValue();
        getProperties().add(propertyValue);
    }

    @Override
    public void visitAnnotationMemberValue(AnnotationMemberValue value) {
    }

    @Override
    public void visitBooleanMemberValue(BooleanMemberValue value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitByteMemberValue(ByteMemberValue value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitCharMemberValue(CharMemberValue value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitClassMemberValue(ClassMemberValue value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitDoubleMemberValue(DoubleMemberValue value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitEnumMemberValue(EnumMemberValue value) {
    }

    @Override
    public void visitFloatMemberValue(FloatMemberValue value) {
    }

    @Override
    public void visitIntegerMemberValue(IntegerMemberValue value) {
    }

    @Override
    public void visitLongMemberValue(LongMemberValue value) {
    }

    @Override
    public void visitShortMemberValue(ShortMemberValue value) {
    }

    public List<String> getProperties() {
        return properties;
    }
}
