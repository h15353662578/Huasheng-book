package com.hs.config;

import lombok.AllArgsConstructor;

/**
 * @author Huasheng
 * @Date 2021/04/13/10:07
 * @Description
 */
@AllArgsConstructor
public enum ResultCode implements ICode{

    SUCCESS(200, "操作成功"),

    ERROR(500, "操作失败"),

    VALIDATE_FAILED(400, "参数检验失败"),

    UNAUTHORIZED(401, "未经授权"),

    FORBIDDEN(403, "没有权限"),

    BUSINESS_ERROR(590, "业务异常");

    private long code;

    private String message;

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
