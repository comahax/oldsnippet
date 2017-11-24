package com.sunrise.boss.common.exception.dao;

/**
 * <p>Title: 非法主键</p>
 * <p>Description: 即主键对应的记录不存在或无效</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sunrise Tech Ltd. </p>
 * @author sunrise
 * @version 1.0
 */
public class InvalidIdException
    extends Exception {
    public InvalidIdException() {
        super();
    }

    public InvalidIdException(String message) {
        super(message);
    }
}
