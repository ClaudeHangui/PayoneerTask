package com.changui.payoneerhomeexercise.domain;

/**
 * Created by Claude Hangui on 21/02/2018.
 * Coin Afrique
 * claude.hangui@gmail.com.
 */

import io.reactivex.Scheduler;

/**
 * Provides various threading schedulers.
 */
public interface SchedulersFacade
{
   Scheduler provideUIThread();
   Scheduler provideIO();
   Scheduler provideComputation();
}
