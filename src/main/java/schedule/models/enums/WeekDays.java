package schedule.models.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import schedule.utils.exceptions.NoSuchEnumException;

/**
 * @author hwd
 * @date 2021-01-10 1:55 PM
 **/
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum WeekDays {
    Monday(0),
    Tuesday(1),
    Wednesday(2),
    Thursday(3),
    Friday(4),
    Saturday(5),
    Sunday(6);

    @JsonProperty("id")
    private final int id;

    WeekDays(int id) {
        this.id = id;
    }

    @JsonCreator
    public static WeekDays findById(@JsonProperty("id") int id) throws NoSuchEnumException {
        if (id < 0 || id > 6) throw new NoSuchEnumException("no such weekday");
        return WeekDays.values()[id];
    }
}
