package com.fiap.Tech_Challenge_I.adapter.factory;

import com.fiap.Tech_Challenge_I.adapter.response.ApiResponse;

import java.util.List;

public class ApiResponseFactory {

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, "Operação bem-sucedida", data);
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(true, message, data);
    }

    public static ApiResponse<Void> success(String message) {
        return new ApiResponse<>(true, message, null);
    }

    public static ApiResponse<Void> error(String message) {
        return new ApiResponse<>(false, message, null);
    }

    public static <T> ApiResponse<T> error(String message, T data) {
        return new ApiResponse<>(false, message, data);
    }
}