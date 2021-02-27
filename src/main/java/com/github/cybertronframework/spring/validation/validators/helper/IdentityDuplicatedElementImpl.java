package com.github.cybertronframework.spring.validation.validators.helper;

import java.util.function.Function;
import lombok.Data;

/**
 * @author dunght1
 * @version 1.0
 * @since Oct 19, 2020
 */
@Data
public class IdentityDuplicatedElementImpl implements IdentityDuplicatedElement<Object> {

  @Override
  public Function<Object, ?> indentity() {
    return Function.identity();
  }
}
