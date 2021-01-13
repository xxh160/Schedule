package schedule.services.impl.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import schedule.models.Schedule;
import schedule.utils.exceptions.IllegalJsonException;
import schedule.utils.exceptions.IllegalScheduleException;

/**
 * @author hwd
 * @date 2021-01-13 3:25 PM
 **/
public class ScheduleFactory extends Factory<Schedule> {
    private static ScheduleFactory one;
    private static int curId = 0;

    private ScheduleFactory() {
    }

    public static ScheduleFactory getInstance() {
        if (one == null) one = new ScheduleFactory();
        return one;
    }

    @Override
    public Schedule build(String json) throws IllegalJsonException {
        try {
            Schedule res = this.objectMapper.readValue(json, Schedule.class);
            res.setId(++curId);
            this.map.put(res.getId(), res);
            return res;
        } catch (JsonProcessingException e) {
            throw new IllegalJsonException();
        }
    }

    public Schedule getExistScheduleById(int id) throws IllegalScheduleException {
        if (!this.map.containsKey(id)) throw new IllegalScheduleException();
        return this.map.get(id);
    }
}
