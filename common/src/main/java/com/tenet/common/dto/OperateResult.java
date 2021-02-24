package com.tenet.common.dto;

import com.tenet.common.entity.BaseEntity;
import com.tenet.common.enums.ResultTypeEnum;
import lombok.Data;

/**
 * 请求返回数据封装类
 *
 * @author Madison
 * @since 2021/2/22
 */
@Data
public class OperateResult extends BaseEntity {

    private Integer code;
    private String message;
    private Object data;
    private String exception;

    private OperateResult() {
    }

    private OperateResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private OperateResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private OperateResult(Integer code, String message, Object data, String exception) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.exception = exception;
    }

    public OperateResult success() {
        return new OperateResult(
                ResultTypeEnum.SUCCESS.getCode(),
                ResultTypeEnum.SUCCESS.getMessage()
        );
    }

    public OperateResult success(Object data) {
        return new OperateResult(
                ResultTypeEnum.SUCCESS.getCode(),
                ResultTypeEnum.SUCCESS.getMessage(),
                data
        );
    }

    public OperateResult fail() {
        return new OperateResult(
                ResultTypeEnum.FAIL.getCode(),
                ResultTypeEnum.FAIL.getMessage()
        );
    }

    public OperateResult fail(String message) {
        return new OperateResult(
                ResultTypeEnum.FAIL.getCode(),
                message
        );
    }

    public OperateResult exception() {
        return new OperateResult(
                ResultTypeEnum.EXCEPTION.getCode(),
                ResultTypeEnum.EXCEPTION.getMessage()
        );
    }

    public OperateResult apiException(String exception) {
        return new OperateResult(
                ResultTypeEnum.EXCEPTION.getCode(),
                ResultTypeEnum.EXCEPTION.getMessage(),
                null,
                exception
        );
    }

}
