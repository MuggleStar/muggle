package com.tenet.common.exception;

import lombok.Data;

/**
 * 业务异常
 *
 * @author Madison
 * @since 2021/2/22
 */
@Data
public class TenetException extends RuntimeException {

    private String message;

}
