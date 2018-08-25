package com.jie.helloservice.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

/**
 * Object utils
 */
public class ObjectUtils {

    private static Logger logger = LoggerFactory.getLogger(ObjectUtils.class);

    /**
     * Copy the property values of the given source bean into the given target bean,
     * ignoring the given "ignoreProperties".
     * <p>Note: The source and target classes do not have to match or even be derived
     * from each other, as long as the properties match. Any bean properties that the
     * source bean exposes but the target bean does not will silently be ignored.
     *
     * @param source           the source object
     * @param clz              the class of target
     * @param ignoreProperties array of property names to ignore
     */
    public static <R, T> R copy(T source, Class<R> clz, String... ignoreProperties) {
        if (source == null) {
            return null;
        }
        try {
            R result = clz.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(source, result, ignoreProperties);
            return result;
        } catch (ReflectiveOperationException e) {
            logger.error("Failed to copy properties from source:{} to target class:{}", source, clz, e);
        }
        return null;
    }

    public static void copy(Object source, Object target, String... ignoreProperties) {
        BeanUtils.copyProperties(source, target, ignoreProperties);
    }
}
