package schedule.services.impl.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import schedule.models.prototype.Course;
import schedule.utils.exceptions.IllegalCourseException;
import schedule.utils.exceptions.IllegalJsonException;

/**
 * @author hwd
 * @date 2021-01-10 8:10 PM
 **/
public class CourseFactory extends Factory<Course> {
    private static CourseFactory one;
    private static int curId = 0;

    private CourseFactory() {
    }

    public static CourseFactory getInstance() {
        if (one == null) one = new CourseFactory();
        return one;
    }

    public static void reset() {
        one = null;
    }

    @Override
    public Course build(String json) throws IllegalJsonException {
        try {
            Course res = this.objectMapper.readValue(json, Course.class);
            res.setId(++curId);
            this.map.put(res.getId(), res);
            return res;
        } catch (JsonProcessingException e) {
            throw new IllegalJsonException();
        }
    }

    public Course getExistCourseById(int id) throws IllegalCourseException {
        if (!this.map.containsKey(id)) throw new IllegalCourseException();
        return this.map.get(id);
    }
}
