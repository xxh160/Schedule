package schedule.services.impl.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.tuple.Pair;
import schedule.models.enums.Spans;
import schedule.utils.exceptions.IllegalJsonException;

/**
 * @author hwd
 * @date 2021-01-10 5:48 PM
 **/
public class SpansFactory extends Factory<Spans> {
    private static SpansFactory one;

    private SpansFactory() {
    }

    public static Factory<Spans> getInstance() {
        if (one != null) return one;
        one = new SpansFactory();
        return one;
    }

    public static void reset() {
        one = null;
    }

    @Override
    public Spans build(String json) throws IllegalJsonException {
        Pair<Spans, Integer> res = this.getByMapWithId(json);
        if (res.getLeft() != null) return res.getLeft();
        try {
            int id = res.getRight();
            Spans instance = this.objectMapper.readValue(json, Spans.class);
            this.map.put(id, instance);
            return instance;
        } catch (JsonProcessingException e) {
            throw new IllegalJsonException();
        }
    }
}
