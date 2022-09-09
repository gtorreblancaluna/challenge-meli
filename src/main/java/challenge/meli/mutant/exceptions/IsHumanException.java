package challenge.meli.mutant.exceptions;

import org.springframework.http.HttpStatus;

public class IsHumanException extends BusinessException{
    
	private static final long serialVersionUID = 5803731977896357530L;
	
	private transient Throwable cause;
    private transient String message = "DNA is human";

    public IsHumanException() {
        super();
    }

    public IsHumanException(final String message) {
        this.message = message;
    }

    public IsHumanException(final String message, final Throwable cause) {
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
    
    public HttpStatus getHttpStatus () {
    	return HttpStatus.FORBIDDEN;
    }
    
}
