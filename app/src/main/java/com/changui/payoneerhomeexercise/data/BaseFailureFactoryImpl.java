package com.changui.payoneerhomeexercise.data;

import androidx.annotation.Nullable;

import com.changui.payoneerhomeexercise.domain.BaseFailureFactory;
import com.changui.payoneerhomeexercise.domain.Failure;
import java.io.IOException;
import java.net.HttpURLConnection;
import retrofit2.HttpException;
import retrofit2.Response;

public class BaseFailureFactoryImpl implements BaseFailureFactory {
    public BaseFailureFactoryImpl() {
    }

    @Override
    public Failure produce(Throwable exception) {
        if (exception instanceof IOException)
            return Failure.NetworkError;
        else if (exception instanceof HttpException) {
            Response<?> response = ((HttpException) exception).response();
            return handleHttpCode(response);
        }
        else return Failure.UnknownError;
    }

    public Failure handleHttpCode(@Nullable Response<?> response) {
        if (response == null)
            return Failure.UnknownError;
        switch (response.code()) {
            case HttpURLConnection.HTTP_BAD_REQUEST: return Failure.BadRequestError;
            case HttpURLConnection.HTTP_UNAUTHORIZED: return Failure.UnauthorisedError;
            case HttpURLConnection.HTTP_FORBIDDEN: return Failure.ForbiddenError;
            case HttpURLConnection.HTTP_NOT_FOUND: return Failure.NotFoundError;
            case HttpURLConnection.HTTP_INTERNAL_ERROR: return Failure.ServerError;
            case HttpURLConnection.HTTP_BAD_GATEWAY: return Failure.GatewayError;
            default: return Failure.UnknownError;
        }
    }
}
