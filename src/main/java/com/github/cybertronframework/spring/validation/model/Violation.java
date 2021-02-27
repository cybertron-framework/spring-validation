package com.github.cybertronframework.spring.validation.model;

import javax.validation.ConstraintViolation;
import lombok.Getter;

/**
 * @author dunght1
 * @version 1.0
 * @since Feb 03, 2021
 */
@Getter
public class Violation {

  private final String propertyPath;
  private final String message;
  private final Object invalidValue;

  public Violation(ConstraintViolation<?> constraintViolation) {
    this.propertyPath = constraintViolation.getPropertyPath().toString();
    this.message = constraintViolation.getMessage();
    this.invalidValue = constraintViolation.getInvalidValue();
  }

  public Violation(String propertyPath, String message, Object invalidValue) {
    this.propertyPath = propertyPath;
    this.message = message;
    this.invalidValue = invalidValue;
  }

  public String getPropertyPath() {
    return propertyPath;
  }

  @Override
  public String toString() {
    return String.format("%s: %s", getPropertyPath(), message);
  }
}
