package com.github.cybertronframework.spring.validation.exceptions;

import com.github.cybertronframework.spring.validation.model.Violation;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;

/**
 * @author dunght1
 * @version 1.0
 * @since Oct 26, 2020
 */
@Getter
public class ManualValidationException extends RuntimeException {

  private List<Violation> errorDetails;

  public ManualValidationException(List<Violation> errorDetails) {
    super(errorDetails.stream()
                      .map(Violation::toString)
                      .collect(Collectors.joining(", ")));
    this.errorDetails = errorDetails;
  }

  public ManualValidationException(Violation errorDetail) {
    super(errorDetail.toString());
    this.errorDetails = Collections.singletonList(errorDetail);
  }

}
