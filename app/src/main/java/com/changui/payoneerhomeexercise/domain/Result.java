package com.changui.payoneerhomeexercise.domain;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import static com.changui.payoneerhomeexercise.domain.States.ERROR;
import static com.changui.payoneerhomeexercise.domain.States.LOADING;
import static com.changui.payoneerhomeexercise.domain.States.SUCCESS;

public class Result<T> {
    @NonNull
    public final States status;
    @Nullable
    public final Failure message;
    @Nullable
    public final T data;

    public Result(@NonNull States status, @Nullable T data, @Nullable Failure message) {
        this.status = status;
        this.message = message;
        this.data = data;
    }


    public static <T> Result<T> success(@Nullable T data) {
        return new Result<>(SUCCESS, data, null);
    }

    public static <T> Result<T> error(Failure msg, @Nullable T data) {
        return new Result<>(ERROR, data, msg);
    }

    public static <T> Result<T> loading(@Nullable T data) {
        return new Result<>(LOADING, data, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Result<?> resource = (Result<?>) o;

        if (status != resource.status) {
            return false;
        }
        if (message != null ? !message.equals(resource.message) : resource.message != null) {
            return false;
        }
        return data != null ? data.equals(resource.data) : resource.data == null;
    }

    @Override
    public int hashCode() {
        int result = status.hashCode();
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
