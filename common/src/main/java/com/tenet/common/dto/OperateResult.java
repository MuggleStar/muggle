package com.tenet.common.dto;

import com.tenet.common.entity.BaseEntity;
import com.tenet.common.enums.ResultTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 请求返回数据封装类
 *
 * @author Madison
 * @since 2021/2/22
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OperateResult<T> extends BaseEntity {

    private Integer code;
    private String message;
    private T data;
    private String exception;

    private OperateResult() {
    }

    public OperateResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public OperateResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public OperateResult(Integer code, String message, String exception) {
        this.code = code;
        this.message = message;
        this.exception = exception;
    }

    public OperateResult(Integer code, String message, T data, String exception) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.exception = exception;
    }

    public static <T> OperateResult<T> success() {
        return new OperateResult<>(
                ResultTypeEnum.SUCCESS.getCode(),
                ResultTypeEnum.SUCCESS.getMessage()
        );
    }

    public static <T> OperateResult<T> success(T data) {
        return new OperateResult<>(
                ResultTypeEnum.SUCCESS.getCode(),
                ResultTypeEnum.SUCCESS.getMessage(),
                data
        );
    }

    public static <T> OperateResult<T> fail() {
        return new OperateResult<>(
                ResultTypeEnum.FAIL.getCode(),
                ResultTypeEnum.FAIL.getMessage()
        );
    }

    public static <T> OperateResult<T> fail(String message) {
        return new OperateResult<>(
                ResultTypeEnum.FAIL.getCode(),
                message
        );
    }

    public static <T> OperateResult<T> exception() {
        return new OperateResult<>(
                ResultTypeEnum.EXCEPTION.getCode(),
                ResultTypeEnum.EXCEPTION.getMessage()
        );
    }

    public static <T> OperateResult<T> apiException(String exception) {
        return new OperateResult<>(
                ResultTypeEnum.EXCEPTION.getCode(),
                ResultTypeEnum.EXCEPTION.getMessage(),
                exception
        );
    }

}
