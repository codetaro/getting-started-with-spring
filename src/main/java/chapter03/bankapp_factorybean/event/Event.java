package chapter03.bankapp_factorybean.event;

import java.util.Map;

public interface Event {
    String getEventType();
    void setEventData(Map<String, Object> eventData);
    Map<String, Object> getEventData();
}
