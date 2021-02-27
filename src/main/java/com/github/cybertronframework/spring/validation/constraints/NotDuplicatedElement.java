package com.github.cybertronframework.spring.validation.constraints;

import com.github.cybertronframework.spring.validation.validators.NotDuplicatedElementValidator;
import com.github.cybertronframework.spring.validation.validators.helper.IdentityDuplicatedElement;
import com.github.cybertronframework.spring.validation.validators.helper.IdentityDuplicatedElementImpl;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Kiểm tra trùng lặp dữ liệu trong một mảng
 *
 * @author dunght1
 * @version 1.0
 * @since Oct 19, 2020
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(NotDuplicatedElement.List.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Constraint(
    validatedBy = NotDuplicatedElementValidator.class
)
public @interface NotDuplicatedElement {

  /**
   * Class định nghĩa phương thức xác định key của mỗi phần tử để thực hiện kiểm tra trùng lặp dữ liệu trong danh sách
   */
  Class<? extends IdentityDuplicatedElement> indentity() default IdentityDuplicatedElementImpl.class;

  Class<?>[] groups() default {};

  String message() default "{NotDuplicatedElement.message}";

  Class<? extends Payload>[] payload() default {};


  @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
  @Retention(RetentionPolicy.RUNTIME)
  @Documented
  public @interface List {

    NotDuplicatedElement[] value();
  }
}
