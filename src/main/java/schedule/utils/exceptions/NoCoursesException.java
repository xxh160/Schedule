package schedule.utils.exceptions;

/**
 * @author hwd
 * @date 2021-01-10 1:50 PM
 **/
public class NoCoursesException extends RuntimeException {

    public NoCoursesException() {
        super("no courses yet");
    }
}
