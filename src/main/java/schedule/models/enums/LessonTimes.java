package schedule.models.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import schedule.utils.exceptions.NoSuchEnumException;

/**
 * @author hwd
 * @date 2021-01-10 2:01 PM
 **/
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum LessonTimes {
    One(0),
    Two(1),
    Three(2),
    Four(3),
    Five(4),
    Six(5),
    Seven(6),
    Eight(7),
    Nine(8),
    Ten(9),
    Eleven(10),
    Twelve(11),
    Thirteen(12);

    @JsonProperty("id")
    private final int id;

    LessonTimes(int id) {
        this.id = id;
    }

    @JsonCreator
    public static LessonTimes findById(@JsonProperty("id") int id) throws NoSuchEnumException {
        if (id < 0 || id > 12) throw new NoSuchEnumException("no such lesson time");
        return LessonTimes.values()[id];
    }

}

