package alpha.org.alphawallet.rate;

/**
 * Created by kaali on 7/5/17.
 */
public class RequestAlphaRateException extends Exception {
    public RequestAlphaRateException(String message) {
        super(message);
    }

    public RequestAlphaRateException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestAlphaRateException(Exception e) {
        super(e);
    }
}
