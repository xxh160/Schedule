package schedule.models.prototype;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import schedule.models.enums.CourseFeature;

import java.util.ArrayList;

/**
 * @author hwd
 * @date 2021-01-07 5:27 PM
 **/
@Data
public class Course {
    @JsonIgnore
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("sessions")
    private ArrayList<Session> sessions;
    @JsonProperty("features")
    private ArrayList<CourseFeature> features;

    @JsonCreator
    public Course(@JsonProperty("name") String name,
                  @JsonProperty("sessions") ArrayList<Session> sessions,
                  @JsonProperty("features") ArrayList<CourseFeature> features) {
        this.id = -1;
        this.name = name;
        this.sessions = sessions;
        this.features = features;
    }
}
