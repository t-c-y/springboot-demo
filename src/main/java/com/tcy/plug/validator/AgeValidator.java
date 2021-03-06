package com.tcy.plug.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author tongchengyu
 */
public class AgeValidator implements ConstraintValidator<Age, Integer> {

    private Age age;
    private Integer max;
    private Integer min;

    @Override
    public void initialize(Age age) {
        this.age = age;
        this.max = age.max();
        this.min = age.min();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return integer > min && integer < max;
    }
}
