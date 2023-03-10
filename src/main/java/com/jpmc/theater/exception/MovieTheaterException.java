package com.jpmc.theater.exception;

/**
 * The type Movie theater exception.
 */
public class MovieTheaterException extends RuntimeException{
    private static final long serialVersionUID = 7718828512143293558L;
    private final int code;

    /**
     * Instantiates a new Movie theater exception.
     *
     * @param message the message
     * @param cause   the cause
     * @param args    the args
     */
    public MovieTheaterException(final String message, final Throwable cause, final Object... args){

        this(400,message,cause,args);
    }

    /**
     * Instantiates a new Movie theater exception.
     *
     * @param code the code
     */
    public MovieTheaterException(int code) {
        this.code = code;
    }

    /**
     * Instantiates a new Movie theater exception.
     *
     * @param message the message
     * @param cause   the cause
     * @param code    the code
     */
    public MovieTheaterException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    /**
     * Instantiates a new Movie theater exception.
     *
     * @param message the message
     * @param code    the code
     */
    public MovieTheaterException(String message, int code) {
        super(message);
        this.code = code;
    }

    /**
     * Instantiates a new Movie theater exception.
     *
     * @param message the message
     * @param args    the args
     */
    public MovieTheaterException(String message, final Object... args) {
        this(400,message,args);

    }

    /**
     * Instantiates a new Movie theater exception.
     *
     * @param cause the cause
     * @param code  the code
     */
    public MovieTheaterException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    /**
     * Instantiates a new Movie theater exception.
     *
     * @param code    the code
     * @param message the message
     * @param args    the args
     */
    public MovieTheaterException(final int code, final String message, final Object... args){
        super(String.format(message,args));
        this.code = code;
    }

    /**
     * Instantiates a new Movie theater exception.
     *
     * @param code    the code
     * @param message the message
     * @param cause   the cause
     * @param args    the args
     */
    public MovieTheaterException(final int code, final String message,final Throwable cause, final Object... args){
        super(String.format(message,args),cause);
        this.code = code;
    }

    /**
     * Instantiates a new Movie theater exception.
     *
     * @param code    the code
     * @param message the message
     * @param cause   the cause
     */
    public MovieTheaterException(final int code, final String message,final Throwable cause){
        super(message,cause);
        this.code = code;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public int getCode() {
        return this.code;
    }
}
