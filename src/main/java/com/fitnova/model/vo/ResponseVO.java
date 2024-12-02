package com.fitnova.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A generic response object for standardizing API responses.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVO<T> {
    private int code; // HTTP status code or application-specific code
    private String message; // Response message
    private T data; // Response data

    /**
     * Success response without data.
     *
     * @param message Success message.
     * @return A success ResponseVO.
     */
    public static <T> ResponseVO<T> success(String message) {
        return new ResponseVO<>(200, message, null);
    }

    /**
     * Success response with data.
     *
     * @param data Response data.
     * @param message Success message.
     * @return A success ResponseVO.
     */
    public static <T> ResponseVO<T> success(String message, T data) {
        return new ResponseVO<>(200, message, data);
    }

    /**
     * Error response without data.
     *
     * @param code Error code.
     * @param message Error message.
     * @return An error ResponseVO.
     */
    public static <T> ResponseVO<T> error(int code, String message) {
        return new ResponseVO<>(code, message, null);
    }

    /**
     * Error response with data.
     *
     * @param code Error code.
     * @param message Error message.
     * @param data Additional data for the error.
     * @return An error ResponseVO.
     */
    public static <T> ResponseVO<T> error(int code, String message, T data) {
        return new ResponseVO<>(code, message, data);
    }

    /**
     * Error response with only a message.
     *
     * @param message Error message.
     * @return An error ResponseVO with a default error code.
     */
    public static <T> ResponseVO<T> error(String message) {
        return new ResponseVO<>(400, message, null); // Default error code set to 400
    }
}
