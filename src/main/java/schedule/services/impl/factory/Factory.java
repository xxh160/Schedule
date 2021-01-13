package schedule.services.impl.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import schedule.utils.exceptions.IllegalJsonException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hwd
 * @date 2021-01-10 3:05 PM
 **/
public abstract class Factory<T> {
    protected Map<Integer, T> map;
    protected ObjectMapper objectMapper;

    protected Factory() {
        this.map = new HashMap<>();
        this.objectMapper = new ObjectMapper();
    }

    protected Pair<T, Integer> getByMapWithId(String json) throws IllegalJsonException {
        int id;
        try {
            id = objectMapper.readTree(json).get("id").asInt();
            if (this.map.containsKey(id)) return new ImmutablePair<>(this.map.get(id), id);
        } catch (JsonProcessingException | NullPointerException e) {
            throw new IllegalJsonException();
        }
        return new ImmutablePair<>(null, id);
    }

    public abstract T build(String json) throws IllegalJsonException;
}
