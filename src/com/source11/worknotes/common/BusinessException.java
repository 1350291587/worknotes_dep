package com.source11.worknotes.common;

/**
 * 应用程序异常类,用于业务层
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 */
public class BusinessException extends ApplicationException {
    /**
     * Constructs an Exception with a detailed message.
     *
     * @param message The message associated with the exception.
     */
    public BusinessException(final String message) {
        super(message);
    }

    /**
     * Constructs an Exception with a detailed message and detailed cause.
     *
     * @param message The message associated with the exception.
     * @param cause   the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public BusinessException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs an Exception with a detailed cause.
     *
     * @param cause the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public BusinessException(final Throwable cause) {
        super(cause);
    }
}