package chapter04.bankapp_dependencies.event;

import lombok.Setter;

import java.util.Properties;

public class DatabaseEventSender implements EventSender {
    @Setter private Properties databaseProperties;

    @Override
    public void sendEvent(Event e) {

    }
}
