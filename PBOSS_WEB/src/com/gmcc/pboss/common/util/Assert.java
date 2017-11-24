package com.gmcc.pboss.common.util;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import com.gmcc.pboss.common.exception.AssertConditionException;

public final class Assert extends org.springframework.util.Assert {

	public static void isBlank(String text, int errorCode, String message) {
		if (!StringUtils.isBlank(text)) {
			throw new AssertConditionException(errorCode, message);
		}
	}

	public static void notBlank(String text, int errorCode, String message) {
		if (StringUtils.isBlank(text)) {
			throw new AssertConditionException(errorCode, message);
		}
	}

	public static void isTrue(boolean expression, int errorCode, String message) {
		if (!expression) {
			throw new AssertConditionException(errorCode, message);
		}
	}

	public static void notEmpty(Map map, int errorCode, String message) {
		if (CollectionUtils.isEmpty(map)) {
			throw new AssertConditionException(errorCode, message);
		}
	}

	public static void notNull(Object object, int errorCode, String message) {
		if (object == null) {
			throw new AssertConditionException(errorCode, message);
		}
	}

	public static void isMobile(String mobileNumber, int errorCode, String message) {
		if (!CommonUtil.isChinaMobile(mobileNumber)) {
			throw new AssertConditionException(errorCode, message);
		}
	}

}
