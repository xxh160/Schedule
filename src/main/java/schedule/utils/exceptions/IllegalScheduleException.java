package schedule.utils.exceptions;

/**
 * @author hwd
 * @date 2021-01-13 3:35 PM
 **/
public class IllegalScheduleException extends RuntimeException {
    public IllegalScheduleException() {
        super("illegal schedule");
    }
}
