package com.changui.payoneerhomeexercise.domain;


public interface BaseFailureFactory {
    Failure produce(Throwable exception);
}
