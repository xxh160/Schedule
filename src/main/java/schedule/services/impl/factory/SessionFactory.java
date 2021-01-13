package schedule.services.impl.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import schedule.models.prototype.Session;
import schedule.utils.exceptions.IllegalJsonException;

/**
 * @author hwd
 * @date 2021-01-10 9:17 PM
 **/
public class SessionFactory extends Factory<Session> {
    public static SessionFactory one;

    private SessionFactory() {
    }

    public static SessionFactory getInstance() {
        if (one == null) one = new SessionFactory();
        return one;
    }

    public static void reset() {
        one = null;
    }

    @Override
    public Session build(String json) throws IllegalJsonException {
        try {
            return this.objectMapper.readValue(json, Session.class);
        } catch (JsonProcessingException e) {
            throw new IllegalJsonException();
        }
    }
}
