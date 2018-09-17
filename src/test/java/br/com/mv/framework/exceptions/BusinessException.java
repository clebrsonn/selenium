package br.com.mv.framework.exceptions;

public class BusinessException extends Exception {

    /**
     * Represents the message exception error code.
     */
    private String errorCode;

    /**
     * @param message A mensagem de excecao a ser apresentada.
     */
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable t) {
        super(message, t);
    }

    /**
     * @param message   The message to be shown
     * @param errorCode The error code that represents the exception.
     */
    public BusinessException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }


}
