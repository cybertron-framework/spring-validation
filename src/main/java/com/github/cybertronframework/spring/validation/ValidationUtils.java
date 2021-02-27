package com.github.cybertronframework.spring.validation;

import com.github.cybertronframework.spring.validation.exceptions.CValidationException;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.util.StringUtils;

/**
 * @author dunght1
 * @version 1.0
 * @since Oct 23, 2020
 */
public class ValidationUtils {

  static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  public static <T> void validate(T object, Class<?>... groupClass) {
    Set<ConstraintViolation<T>> violations = validator.validate(object, groupClass);

    if (!violations.isEmpty()) {
      throw new CValidationException(violations);
    }
  }

  public static <T> void validate(String propertyPathPrefix, T object, Class<?>... groupClass) {
    if (object != null) {
      Set<ConstraintViolation<T>> violations = validator.validate(object, groupClass);

      if (!violations.isEmpty()) {
        propertyPathPrefix = StringUtils.hasText(propertyPathPrefix) ? propertyPathPrefix + "." : propertyPathPrefix;
        throw new CValidationException(violations, propertyPathPrefix);
      }
    }
  }
}
