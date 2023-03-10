package com.jpmc.theater.exception;

public class MovieTheaterException extends RuntimeException{
    private static final long serialVersionUID = 7718828512143293558L;
    private final int code;

    public MovieTheaterException(final String message, final Throwable cause, final Object... args){

        this(400,message,cause,args);
    }
    public MovieTheaterException(int code) {
        this.code = code;
    }

    public MovieTheaterException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public MovieTheaterException(String message, int code) {
        super(message);
        this.code = code;
    }

    public MovieTheaterException(String message, final Object... args) {
        this(400,message,args);

    }

    public MovieTheaterException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public MovieTheaterException(final int code, final String message, final Object... args){
        super(String.format(message,args));
        this.code = code;
    }
    public MovieTheaterException(final int code, final String message,final Throwable cause, final Object... args){
        super(String.format(message,args),cause);
        this.code = code;
    }

    public MovieTheaterException(final int code, final String message,final Throwable cause){
        super(message,cause);
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
