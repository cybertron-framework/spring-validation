package com.github.cybertronframework.spring.validation.exceptions;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * @author dunght1
 * @version 1.0
 * @since Oct 26, 2020
 */
public class CValidationException extends ConstraintViolationException {

  private final String propertyPathPrefix;

  public CValidationException(String message, Set<? extends ConstraintViolation<?>> constraintViolations, String propertyPathPrefix) {
    super(message, constraintViolations);
    this.propertyPathPrefix = propertyPathPrefix;
  }

  public CValidationException(Set<? extends ConstraintViolation<?>> constraintViolations, String propertyPathPrefix) {
    super(constraintViolations);
    this.propertyPathPrefix = propertyPathPrefix;
  }

  public CValidationException(Set<? extends ConstraintViolation<?>> constraintViolations) {
    super(constraintViolations);
    propertyPathPrefix = null;
  }

  public String getPropertyPathPrefix() {
    return propertyPathPrefix;
  }
}
