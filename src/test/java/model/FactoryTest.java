package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import schedule.models.Schedule;
import schedule.models.enums.*;
import schedule.models.prototype.Course;
import schedule.models.prototype.Session;
import schedule.services.impl.factory.CourseFeatureFactory;
import schedule.utils.exceptions.IllegalJsonException;

import java.util.ArrayList;

import static org.junit.Assert.fail;

/**
 * @author hwd
 * @date 2021-01-10 3:26 PM
 **/
public class FactoryTest {
    private ObjectMapper objectMapper;

    @Before
    public void prepare() {
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void courseFeatureTest() {
        CourseFeature test = CourseFeature.Inescapable;
        try {
            String json = this.objectMapper.writeValueAsString(test);
            System.out.println(json);
            CourseFeature back = this.objectMapper.readValue(json, CourseFeature.class);
            System.out.println(back);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            CourseFeature res = CourseFeatureFactory.getInstance().build("{\"id\":3}");
            System.out.println(res);
        } catch (IllegalJsonException e) {
            fail("build failed");
        }
    }

    @Test
    public void spansTest() {
        Spans test = Spans.Two;
        try {
            String json = this.objectMapper.writeValueAsString(test);
            System.out.println(json);
            Spans back = this.objectMapper.readValue(json, Spans.class);
            System.out.println(back);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void weekDaysTest() {
        WeekDays test = WeekDays.Friday;
        try {
            String json = this.objectMapper.writeValueAsString(test);
            System.out.println(json);
            WeekDays back = this.objectMapper.readValue(json, WeekDays.class);
            System.out.println(back);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sessionTest() {
        ArrayList<Weeks> tmp = new ArrayList<>();
        tmp.add(Weeks.One);
        tmp.add(Weeks.Two);
        Session session = new Session(Spans.Three, LessonTimes.One, WeekDays.Monday, "a", tmp);
        try {
            String json = this.objectMapper.writeValueAsString(session);
            System.out.println(json);
            Session test = this.objectMapper.readValue(json, Session.class);
            System.out.println(test);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void courseTest() {
        ArrayList<Weeks> weeks = new ArrayList<>();
        weeks.add(Weeks.One);
        weeks.add(Weeks.Two);
        Session session = new Session(Spans.Three, LessonTimes.One, WeekDays.Monday, "a", weeks);
        ArrayList<Session> sessions = new ArrayList<>();
        sessions.add(session);
        ArrayList<CourseFeature> courseFeatures = new ArrayList<>();
        courseFeatures.add(CourseFeature.Escapable);
        courseFeatures.add(CourseFeature.Immovable);
        Course course = new Course("b", sessions, courseFeatures);
        course.setId(1);
        try {
            String json = this.objectMapper.writeValueAsString(course);
            System.out.println(json);
            Course test = this.objectMapper.readValue(json, Course.class);
            System.out.println(test);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void scheduleTest() {
        ArrayList<Weeks> weeks = new ArrayList<>();
        weeks.add(Weeks.One);
        weeks.add(Weeks.Two);
        Session session = new Session(Spans.Three, LessonTimes.One, WeekDays.Monday, "a", weeks);
        ArrayList<Session> sessions = new ArrayList<>();
        sessions.add(session);
        ArrayList<CourseFeature> courseFeatures = new ArrayList<>();
        courseFeatures.add(CourseFeature.Escapable);
        courseFeatures.add(CourseFeature.Immovable);
        Course course = new Course("b", sessions, courseFeatures);
        course.setId(1);
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(course);
        Schedule schedule = new Schedule(courses);
        try {
            String json = this.objectMapper.writeValueAsString(schedule);
            System.out.println(json);
            Schedule test = this.objectMapper.readValue(json, Schedule.class);
            test.setId(2);
            System.out.println(test);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
