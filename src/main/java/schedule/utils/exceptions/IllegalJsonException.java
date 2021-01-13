package schedule.utils.exceptions;

/**
 * @author hwd
 * @date 2021-01-10 4:42 PM
 **/
public class IllegalJsonException extends RuntimeException {

    public IllegalJsonException() {
        super("illegal json file");
    }
}
