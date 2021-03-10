package com.tenet.common.enums;

/**
 * 返回结果枚举
 *
 * @author Madison
 * @since 2021/2/24
 */
public enum ResultTypeEnum {

    SUCCESS(200,"成功"),
    NO_RESULT(204,"结果为空"),
    FAIL(401,"失败"),
    EXCEPTION(501,"失败，请联系管理员！"),
    ;

    private Integer code;
    private String message;

    ResultTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
