package chapter04.bankapp_dependencies.event;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public class FixedDepositCreatedEvent implements Event {
    @Getter @Setter private Map<String, Object> eventData;

    @Override
    public String getEventType() {
        return "FixedDepositCreatedEvent";
    }

}
