package challenge.meli.mutant.exceptions;

public class DataOriginException extends Exception{
    
	private static final long serialVersionUID = 5803731977896357530L;
	
	private transient Throwable cause;
    private transient String message;
    private Integer httpCodeResponse = 503;

    public DataOriginException() {
        super();
    }

    public DataOriginException(final String message) {
        this.message = message;
    }

    public DataOriginException(final String message, final Throwable cause) {
        this.message = message;
        this.cause = cause;
    }

    @Override
    public Throwable getCause() {
        return this.cause;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
    
    public Integer getHttpCodeResponse () {
    	return this.httpCodeResponse;
    }
}
