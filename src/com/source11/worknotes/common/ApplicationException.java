package com.source11.worknotes.common;

import org.apache.commons.lang.exception.NestableException;

/**
 * 应用程序异常基础类，不直接使用
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 */
public abstract class ApplicationException extends NestableException {

    public ApplicationException(Throwable cause) {
        super(cause);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(String message) {
        super(message);
    }

}
