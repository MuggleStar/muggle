package com.tenet.common.utils;

import com.tenet.common.exception.TenetException;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Map;

/**
 * @author Madison
 * @since 2021/2/28
 */
public class AssertUtil {

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            error(message);
        }
    }

    public static void isNotTrue(boolean expression, String message) {
        isTrue(!expression, message);
    }

    public static void isNull(Object object, String message) {
        if (object != null) {
            error(message);
        }
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            error(message);
        }
    }


    public static void isEmpty(Object[] array, String message) {
        if (!ArrayUtils.isEmpty(array)) {
            error(message);
        }
    }

    public static void notEmpty(Object[] array, String message) {
        if (ArrayUtils.isEmpty(array)) {
            error(message);
        }
    }


    public static void isEmpty(Collection<Object> collection, String message) {
        if (!CollectionUtils.isEmpty(collection)) {
            error(message);
        }
    }

    public static void notEmpty(Collection<Object> collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            error(message);
        }
    }

    public static void isEmpty(String str, String message) {
        if (!StringUtils.isEmpty(str)) {
            error(message);
        }
    }

    public static void notEmpty(String str, String message) {
        if (StringUtils.isEmpty(str)) {
            error(message);
        }
    }

    public static void isBlank(String str, String message) {
        if (!StringUtils.isBlank(str)) {
            error(message);
        }
    }

    public static void notBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            error(message);
        }
    }

    public static void error(String message) {
        throw new TenetException(message);
    }
}
