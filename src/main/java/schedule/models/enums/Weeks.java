package schedule.models.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import schedule.utils.exceptions.NoSuchEnumException;

/**
 * @author hwd
 * @date 2021-01-10 2:31 PM
 **/
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Weeks {
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
    Thirteen(12),
    Fourteen(13),
    Fifteen(14),
    Sixteen(15),
    Seventeen(16);

    private final int id;

    Weeks(int id) {
        this.id = id;
    }

    @JsonCreator
    public static Weeks findById(@JsonProperty("id") int id) throws NoSuchEnumException {
        if (id < 0 || id > 16) throw new NoSuchEnumException("no such week");
        return Weeks.values()[id];
    }

}
