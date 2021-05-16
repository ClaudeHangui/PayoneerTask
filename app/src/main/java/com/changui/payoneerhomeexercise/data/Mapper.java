package com.changui.payoneerhomeexercise.data;

/**
 * Mapper interface which converts data model (input I) to UI model (output O)
 * @param <I>
 * @param <O>
 */
public interface Mapper<I, O> {
    O mapToUI(I input);
}
