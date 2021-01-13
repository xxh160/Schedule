package schedule.models.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import schedule.utils.exceptions.NoSuchEnumException;

/**
 * @author hwd
 * @date 2021-01-10 1:08 PM
 **/
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CourseFeature {
    Immovable(0),
    Movable(1),
    Inescapable(2),
    Escapable(3);

    @JsonProperty("id")
    private final int id;
    @JsonIgnore
    public static final int validNum = 2;

    CourseFeature(int id) {
        this.id = id;
    }

    @JsonCreator
    public static CourseFeature findById(@JsonProperty("id") int id) throws NoSuchEnumException {
        if (id < 0 || id > CourseFeature.validNum * 2 - 1) throw new NoSuchEnumException("no such course feature");
        return CourseFeature.values()[id];
    }

}
