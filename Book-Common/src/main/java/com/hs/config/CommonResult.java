package com.hs.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Huasheng
 * @Date 2021/04/13/10:06
 * @Description
 */
@Data
@NoArgsConstructor
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    public CommonResult(long code, String message,T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     * @param data 获取的数据
     */
    public static <T> CommonResult<T> success(T data) {
        return commonResult(ResultCode.SUCCESS , data);
    }
    /**
     * 成功返回结果
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> CommonResult<T> success(String message , T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }
    /**
     * 失败返回结果
     */
    public static <T> CommonResult<T> error() {
        return commonResult(ResultCode.ERROR , null);
    }
    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> CommonResult<T> error(String message) {
        return new CommonResult<T>(ResultCode.ERROR.getCode(), message, null);
    }
    /**
     * 参数验证失败返回结果
     */
    public static <T> CommonResult<T> validateFailed() {
        return commonResult(ResultCode.VALIDATE_FAILED , null);
    }
    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }
    /**
     * 未登录返回结果
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return commonResult(ResultCode.UNAUTHORIZED , data);
    }
    /**
     * 未授权返回结果
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return commonResult(ResultCode.FORBIDDEN , data);
    }
    /**
     * 业务异常返回结果
     * @param message 提示信息
     */
    public static <T> CommonResult<T> bizError(String message) {
        return new CommonResult<T>(ResultCode.BUSINESS_ERROR.getCode(), message, null);
    }

    /**
     * 通用返回结果方法
     * @param iCode
     * @return
     */
    private static <T> CommonResult<T> commonResult(ICode iCode , T data) {
        return new CommonResult<T>(iCode.getCode(), iCode.getMessage(), data);
    }
}
