package schedule.services.impl;

import schedule.models.Schedule;
import schedule.models.enums.*;
import schedule.models.prototype.Course;
import schedule.models.prototype.Session;
import schedule.services.FactoryService;
import schedule.services.impl.factory.*;
import schedule.utils.exceptions.IllegalCourseException;
import schedule.utils.exceptions.IllegalJsonException;
import schedule.utils.exceptions.IllegalScheduleException;
import schedule.utils.exceptions.NoSuchEnumException;

/**
 * @author hwd
 * @date 2021-01-10 5:20 PM
 **/
public class FactoryServiceImpl implements FactoryService {

    @Override
    public CourseFeature getCourseFeature(String json) throws IllegalJsonException {
        Factory<CourseFeature> factory = CourseFeatureFactory.getInstance();
        return factory.build(json);
    }

    @Override
    public CourseFeature getCourseFeature(int id) throws NoSuchEnumException {
        return CourseFeature.findById(id);
    }

    @Override
    public LessonTimes getLessonTimes(String json) throws IllegalJsonException {
        Factory<LessonTimes> factory = LessonTimesFactory.getInstance();
        return factory.build(json);
    }

    @Override
    public LessonTimes getLessonTimes(int id) throws NoSuchEnumException {
        return LessonTimes.findById(id);
    }

    @Override
    public Spans getSpans(String json) throws IllegalJsonException {
        Factory<Spans> factory = SpansFactory.getInstance();
        return factory.build(json);
    }

    @Override
    public Spans getSpans(int id) throws NoSuchEnumException {
        return Spans.findById(id);
    }

    @Override
    public WeekDays getWeekDays(String json) throws IllegalJsonException {
        Factory<WeekDays> factory = WeekDaysFactory.getInstance();
        return factory.build(json);
    }

    @Override
    public WeekDays getWeekDays(int id) throws NoSuchEnumException {
        return WeekDays.findById(id);
    }

    @Override
    public Weeks getWeeks(String json) throws IllegalJsonException {
        Factory<Weeks> factory = WeeksFactory.getInstance();
        return factory.build(json);
    }

    @Override
    public Weeks getWeeks(int id) throws NoSuchEnumException {
        return Weeks.findById(id);
    }

    @Override
    public Course getCourse(String json) throws IllegalJsonException {
        Factory<Course> factory = CourseFactory.getInstance();
        return factory.build(json);
    }

    @Override
    public Course getCourse(int id) throws IllegalCourseException {
        CourseFactory factory = CourseFactory.getInstance();
        return factory.getExistCourseById(id);
    }

    @Override
    public Session getSession(String json) throws IllegalJsonException {
        Factory<Session> factory = SessionFactory.getInstance();
        return factory.build(json);
    }

    @Override
    public Schedule getSchedule(String json) throws IllegalJsonException {
        Factory<Schedule> factory = ScheduleFactory.getInstance();
        return factory.build(json);
    }

    @Override
    public Schedule getSchedule(int id) throws IllegalScheduleException {
        ScheduleFactory factory = ScheduleFactory.getInstance();
        return factory.getExistScheduleById(id);
    }
}
