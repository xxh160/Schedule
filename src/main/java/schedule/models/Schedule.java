package schedule.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import schedule.models.enums.LessonTimes;
import schedule.models.enums.Spans;
import schedule.models.enums.WeekDays;
import schedule.models.enums.Weeks;
import schedule.models.prototype.Course;
import schedule.models.prototype.Session;
import schedule.utils.exceptions.IllegalCourseException;

import java.util.ArrayList;

/**
 * @author hwd
 * @date 2021-01-07 5:27 PM
 **/
@Data
public class Schedule {
    public static final int weekNum = 17;
    public static final int lessonNum = 13;
    public static final int weekdayNum = 7;

    @JsonIgnore
    private int id;
    @JsonProperty("courses")
    private ArrayList<Course> courses;
    @JsonIgnore
    private ArrayList<DisplayedCourse[][]> grids;

    @JsonCreator
    public Schedule(@JsonProperty("courses") ArrayList<Course> courses) throws IllegalCourseException {
        this.id = -1;
        this.courses = courses;
        this.grids = new ArrayList<>(Schedule.weekNum);
        for (int i = 0; i < Schedule.weekNum; ++i)
            this.grids.add(new DisplayedCourse[Schedule.lessonNum][Schedule.weekdayNum]);
        this.render();
    }

    private void render() throws IllegalCourseException {
        if (this.courses == null) return;
        for (Course cur : this.courses) {
            for (Session curSession : cur.getSessions()) {
                Spans span = curSession.getSpan();
                LessonTimes begin = curSession.getBegin();
                WeekDays day = curSession.getDay();
                if (begin.getId() + span.getId() > Schedule.lessonNum) throw new IllegalCourseException();
                for (int i = 0; i < span.getId(); ++i)
                    for (Weeks week : curSession.getWeeks())
                        this.grids.get(week.getId())[begin.getId() + i][day.getId()]
                                = new DisplayedCourse(cur, curSession);
            }
        }
    }
}
