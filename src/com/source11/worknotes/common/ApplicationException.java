package com.source11.worknotes.common;

import org.apache.commons.lang.exception.NestableException;

/**
 * Ӧ�ó����쳣�����࣬��ֱ��ʹ��
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
