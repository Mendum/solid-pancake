package org.acme.consumer;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;

import com.google.gson.Gson;
import io.quarkus.logging.Log;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.acme.controller.HistoryResource;
import org.acme.models.History;
import org.acme.service.HistoryService;
import org.acme.service.HttpService;

/**
 * A bean consuming prices from the JMS queue.
 */
@ApplicationScoped
public class VinjetaConsumer implements Runnable {

    @Inject
    ConnectionFactory connectionFactory;

    @Inject
    HistoryService historyService;

    private final ExecutorService scheduler = Executors.newSingleThreadExecutor();

    private volatile String vinjetaIdentifikator;

    public String getIdentifikator() {
        return vinjetaIdentifikator;
    }

    void onStart(@Observes StartupEvent ev) {
        scheduler.submit(this);
    }

    void onStop(@Observes ShutdownEvent ev) {
        scheduler.shutdown();
    }

    @Override
    public void run() {
        try (JMSContext context = connectionFactory.createContext(JMSContext.AUTO_ACKNOWLEDGE)) {
            JMSConsumer consumer = context.createConsumer(context.createQueue("vinjetaQueue"));
            Gson gson = new Gson();
            while (true) {
                Message message = consumer.receive();
                if (message == null) return;
                vinjetaIdentifikator = message.getBody(String.class);

                Log.info("Checking validity of vinjeta with identifikator: " + vinjetaIdentifikator);

                HttpService httpService = new HttpService();
                Boolean validity = httpService.createHttpRequestCheckIdentifikator(vinjetaIdentifikator);

                Log.info("Vinjeta => " + vinjetaIdentifikator + " is: " + validity);

                History newHistory = new History(
                        "temp",
                        LocalDateTime.now().toString(),
                        vinjetaIdentifikator,
                        validity
                );

                historyService.add(newHistory);

                Log.info("Added new history: " + newHistory.toString());
                //context.createProducer().send(context.createQueue("zgodovina"), veljavnost);
            }
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}