package schedule.services.impl.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.tuple.Pair;
import schedule.models.enums.Weeks;
import schedule.utils.exceptions.IllegalJsonException;

/**
 * @author hwd
 * @date 2021-01-10 5:50 PM
 **/

public class WeeksFactory extends Factory<Weeks> {
    private static WeeksFactory one;

    private WeeksFactory() {
    }

    public static Factory<Weeks> getInstance() {
        if (one != null) return one;
        one = new WeeksFactory();
        return one;
    }

    public static void reset() {
        one = null;
    }

    @Override
    public Weeks build(String json) throws IllegalJsonException {
        Pair<Weeks, Integer> res = this.getByMapWithId(json);
        if (res.getLeft() != null) return res.getLeft();
        try {
            int id = res.getRight();
            Weeks instance = this.objectMapper.readValue(json, Weeks.class);
            this.map.put(id, instance);
            return instance;
        } catch (JsonProcessingException e) {
            throw new IllegalJsonException();
        }
    }
}
