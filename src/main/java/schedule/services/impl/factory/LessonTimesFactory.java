package schedule.services.impl.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.tuple.Pair;
import schedule.models.enums.LessonTimes;
import schedule.utils.exceptions.IllegalJsonException;

/**
 * @author hwd
 * @date 2021-01-10 5:25 PM
 **/
public class LessonTimesFactory extends Factory<LessonTimes> {
    private static LessonTimesFactory one = null;

    private LessonTimesFactory() {
    }

    public static Factory<LessonTimes> getInstance() {
        if (one != null) return one;
        one = new LessonTimesFactory();
        return one;
    }

    public static void reset() {
        one = null;
    }

    @Override
    public LessonTimes build(String json) throws IllegalJsonException {
        Pair<LessonTimes, Integer> res = this.getByMapWithId(json);
        if (res.getLeft() != null) return res.getLeft();
        try {
            int id = res.getRight();
            LessonTimes instance = this.objectMapper.readValue(json, LessonTimes.class);
            this.map.put(id, instance);
            return instance;
        } catch (JsonProcessingException e) {
            throw new IllegalJsonException();
        }
    }
}
