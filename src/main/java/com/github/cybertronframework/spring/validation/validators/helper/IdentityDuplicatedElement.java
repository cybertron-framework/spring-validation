package com.github.cybertronframework.spring.validation.validators.helper;

import java.util.function.Function;

/**
 * @author dunght1
 * @version 1.0
 * @since Oct 19, 2020
 */
public interface IdentityDuplicatedElement<T> {

  Function<T, ?> indentity();
}
