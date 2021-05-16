package com.changui.payoneerhomeexercise;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.executor.TaskExecutor;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;


public class InstantExecutorExtension implements BeforeEachCallback, AfterEachCallback  {
    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        ArchTaskExecutor.getInstance().setDelegate((TaskExecutor)null);
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        ArchTaskExecutor.getInstance().setDelegate((TaskExecutor)(new TaskExecutor() {
            public void executeOnDiskIO(@NotNull Runnable runnable) {
                runnable.run();
            }

            public void postToMainThread(@NotNull Runnable runnable) {
                runnable.run();
            }

            public boolean isMainThread() {
                return true;
            }
        }));
    }
}
