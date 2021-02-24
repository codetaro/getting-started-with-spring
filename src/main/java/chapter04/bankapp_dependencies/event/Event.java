package chapter04.bankapp_dependencies.event;

import java.util.Map;

public interface Event {
    String getEventType();
    void setEventData(Map<String, Object> eventData);
    Map<String, Object> getEventData();
}
