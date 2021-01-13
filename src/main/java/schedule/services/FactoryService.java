package schedule.services;

import schedule.models.Schedule;
import schedule.models.enums.*;
import schedule.models.prototype.Course;
import schedule.models.prototype.Session;
import schedule.utils.exceptions.IllegalCourseException;
import schedule.utils.exceptions.IllegalJsonException;
import schedule.utils.exceptions.IllegalScheduleException;
import schedule.utils.exceptions.NoSuchEnumException;

/**
 * @author hwd
 * @date 2021-01-10 5:10 PM
 **/
public interface FactoryService {

    CourseFeature getCourseFeature(String json) throws IllegalJsonException;

    CourseFeature getCourseFeature(int id) throws NoSuchEnumException;

    LessonTimes getLessonTimes(String json) throws IllegalJsonException;

    LessonTimes getLessonTimes(int id) throws NoSuchEnumException;

    Spans getSpans(String json) throws IllegalJsonException;

    Spans getSpans(int id) throws NoSuchEnumException;

    WeekDays getWeekDays(String json) throws IllegalJsonException;

    WeekDays getWeekDays(int id) throws NoSuchEnumException;

    Weeks getWeeks(String json) throws IllegalJsonException;

    Weeks getWeeks(int id) throws NoSuchEnumException;

    Course getCourse(String json) throws IllegalJsonException;

    Course getCourse(int id) throws IllegalCourseException;

    Session getSession(String json) throws IllegalJsonException;

    Schedule getSchedule(String json) throws IllegalJsonException;

    Schedule getSchedule(int id) throws IllegalScheduleException;
}
