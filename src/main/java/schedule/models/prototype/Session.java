package schedule.models.prototype;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import schedule.models.enums.LessonTimes;
import schedule.models.enums.Spans;
import schedule.models.enums.WeekDays;
import schedule.models.enums.Weeks;

import java.util.ArrayList;

/**
 * @author hwd
 * @date 2021-01-10 1:28 PM
 **/
@Data
public class Session {
    @JsonProperty("span")
    private Spans span;
    @JsonProperty("begin")
    private LessonTimes begin;
    @JsonProperty("day")
    private WeekDays day;
    @JsonProperty("place")
    private String place;
    @JsonProperty("weeks")
    private ArrayList<Weeks> weeks;

    @JsonCreator
    public Session(
            @JsonProperty("span") Spans span,
            @JsonProperty("begin") LessonTimes begin,
            @JsonProperty("day") WeekDays day,
            @JsonProperty("place") String place,
            @JsonProperty("weeks") ArrayList<Weeks> weeks) {
        this.span = span;
        this.begin = begin;
        this.day = day;
        this.place = place;
        this.weeks = weeks;
    }
}


