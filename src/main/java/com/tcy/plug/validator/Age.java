package com.tcy.plug.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author tongchengyu
 */
@Constraint(validatedBy = {AgeValidator.class})
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Age {
    String message() default "年龄是非法的，最大值是{max}岁";
    int max() default 100;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
