package schedule.services.impl.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.tuple.Pair;
import schedule.models.enums.CourseFeature;
import schedule.utils.exceptions.IllegalJsonException;

/**
 * @author hwd
 * @date 2021-01-10 4:38 PM
 **/
public class CourseFeatureFactory extends Factory<CourseFeature> {
    private static CourseFeatureFactory one = null;

    private CourseFeatureFactory() {
        super();
    }

    public static Factory<CourseFeature> getInstance() {
        if (one != null) return one;
        one = new CourseFeatureFactory();
        return one;
    }

    public static void reset() {
        one = null;
    }

    @Override
    public CourseFeature build(String json) throws IllegalJsonException {
        Pair<CourseFeature, Integer> res = this.getByMapWithId(json);
        if (res.getLeft() != null) return res.getLeft();
        try {
            int id = res.getRight();
            CourseFeature instance = this.objectMapper.readValue(json, CourseFeature.class);
            this.map.put(id, instance);
            return instance;
        } catch (JsonProcessingException e) {
            throw new IllegalJsonException();
        }
    }
}
