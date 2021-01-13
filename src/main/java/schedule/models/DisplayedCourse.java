package schedule.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Data;
import schedule.models.enums.CourseFeature;
import schedule.models.prototype.Course;
import schedule.models.prototype.Session;
import schedule.utils.exceptions.IllegalCourseException;

import java.util.ArrayList;

/**
 * @author hwd
 * @date 2021-01-10 2:57 PM
 **/
@Data
public class DisplayedCourse {
    public static int curId = 0;

    private int id;
    private ArrayList<CourseFeature> features;
    private StringProperty place;
    private StringProperty name;

    public DisplayedCourse(Course cur, Session curSession) throws IllegalCourseException {
        this.id = ++DisplayedCourse.curId;
        this.features = cur.getFeatures();
        this.name = new SimpleStringProperty(cur.getName());
        this.place = new SimpleStringProperty(curSession.getPlace());
        if (this.features.size() != CourseFeature.validNum)
            throw new IllegalCourseException();
        int index0 = this.features.get(0).getId();
        int index1 = this.features.get(1).getId();
        if (index0 + index1 == 1 || index0 + index1 == 5) throw new IllegalCourseException();
    }
}