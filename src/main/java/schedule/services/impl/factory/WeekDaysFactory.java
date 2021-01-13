package schedule.services.impl.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.tuple.Pair;
import schedule.models.enums.WeekDays;
import schedule.utils.exceptions.IllegalJsonException;

/**
 * @author hwd
 * @date 2021-01-10 5:49 PM
 **/
public class WeekDaysFactory extends Factory<WeekDays> {
    private static WeekDaysFactory one;

    private WeekDaysFactory() {
    }

    public static Factory<WeekDays> getInstance() {
        if (one != null) return one;
        one = new WeekDaysFactory();
        return one;
    }

    public static void reset() {
        one = null;
    }

    @Override
    public WeekDays build(String json) throws IllegalJsonException {
        Pair<WeekDays, Integer> res = this.getByMapWithId(json);
        if (res.getLeft() != null) return res.getLeft();
        try {
            int id = res.getRight();
            WeekDays instance = this.objectMapper.readValue(json, WeekDays.class);
            this.map.put(id, instance);
            return instance;
        } catch (JsonProcessingException e) {
            throw new IllegalJsonException();
        }
    }
}
