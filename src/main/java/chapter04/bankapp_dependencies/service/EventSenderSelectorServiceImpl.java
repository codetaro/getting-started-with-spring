package chapter04.bankapp_dependencies.service;

import chapter04.bankapp_dependencies.Constants;
import org.springframework.core.io.ClassPathResource;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class EventSenderSelectorServiceImpl {

    public EventSenderSelectorServiceImpl(String configFile) throws Exception {
        ClassPathResource resource = new ClassPathResource(configFile);
        OutputStream outStream = new FileOutputStream(resource.getFile());

        Properties properties = new Properties();
        properties.setProperty(Constants.EVENT_SENDER_CLASS_PROPERTY,
                "chapter04.bankapp_dependencies.event.DatabaseEventSender");
        properties.store(outStream, null);
        properties.list(System.out);
        outStream.flush();
        outStream.close();
    }
}
