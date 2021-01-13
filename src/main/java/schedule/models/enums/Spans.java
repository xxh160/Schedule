package schedule.models.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import schedule.utils.exceptions.NoSuchEnumException;

/**
 * @author hwd
 * @date 2021-01-10 2:05 PM
 **/
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Spans {
    Two(2),
    Three(3);

    @JsonProperty("id")
    private final int id;

    Spans(int id) {
        this.id = id;
    }

    @JsonCreator
    public static Spans findById(@JsonProperty("id") int id) throws NoSuchEnumException {
        if (id < 2 || id > 3) throw new NoSuchEnumException("no such Span");
        return Spans.values()[id - 2];
    }

}
