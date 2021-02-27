package com.github.cybertronframework.spring.validation.validators;

import com.github.cybertronframework.spring.validation.constraints.NotDuplicatedElement;
import com.github.cybertronframework.spring.validation.validators.helper.IdentityDuplicatedElement;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;

/**
 * @author dunght1
 * @version 1.0
 * @since Oct 23, 2020
 */
public class NotDuplicatedElementValidator implements ConstraintValidator<NotDuplicatedElement, Collection> {

  IdentityDuplicatedElement identityDuplicatedElement;

  @SneakyThrows
  @Override
  public void initialize(NotDuplicatedElement constraintAnnotation) {
    identityDuplicatedElement = constraintAnnotation.indentity().newInstance();
  }

  @Override
  public boolean isValid(Collection collection, ConstraintValidatorContext constraintValidatorContext) {

    return duplicateElements(collection, identityDuplicatedElement.indentity());
  }

  public <T> boolean duplicateElements(Collection<T> collection, Function<T, ?> indentity) {
    if (collection != null && !collection.stream().anyMatch(x -> indentity.apply(x) == null) &&
        collection.stream()
                  .collect(Collectors.groupingBy(indentity, Collectors.counting()))
                  .entrySet().stream()
                  .anyMatch(m -> m.getValue() > 1)
    ) {
      return false;
    }
    return true;
  }
}
