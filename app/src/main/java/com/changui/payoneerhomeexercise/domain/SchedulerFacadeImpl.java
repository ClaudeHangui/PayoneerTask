package com.changui.payoneerhomeexercise.domain;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
public class SchedulerFacadeImpl implements SchedulersFacade {

    public SchedulerFacadeImpl() { }

    @Override
    public Scheduler provideUIThread() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler provideIO() {
        return Schedulers.io();
    }

    @Override
    public Scheduler provideComputation() {
        return Schedulers.computation();
    }
}
