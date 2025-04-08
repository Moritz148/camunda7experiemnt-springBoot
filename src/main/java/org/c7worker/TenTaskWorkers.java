package org.c7worker;

import jakarta.annotation.PostConstruct;
import org.camunda.bpm.client.ExternalTaskClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class TenTaskWorkers {
    private static final Logger log = LoggerFactory.getLogger(TenTaskWorkers.class);

    @Autowired
    private ConfigurableApplicationContext context;


    private final AtomicInteger counter = new AtomicInteger();


    @PostConstruct
    public void registerWorkers() {
        ExternalTaskClient client = ExternalTaskClient.create()
//                .baseUrl("http://camunda7:8080/engine-rest/engine")
                .baseUrl("http://camunda7:8080/engine-rest")
                .asyncResponseTimeout(5000)
                .build();



        for (int i = 1; i <= 10; i++) {
            String topic = "task-nr-" + i;
            client.subscribe(topic)
                    .lockDuration(1000)
                    .handler((externalTask, externalTaskService) -> {
                        //System.out.println("Worker für Topic " + topic + " hat einen Task erhalten.");
                        TenTaskWorkers.log.info("Worker für Topic " + topic + " hat einen Task erhalten.");
                        externalTaskService.complete(externalTask);
                        int currentCount = counter.incrementAndGet();
                        TenTaskWorkers.log.info("Task fertig");
                        // Wenn der Counter 100 erreicht, die Anwendung stoppen
                        if (currentCount == 100) {
                           log.info("Counter erreicht 100. Die Anwendung wird beendet.");
                           System.exit(0);  // Anwendung komplett beenden
                        }

                    })
                    .open();
            }
        }
   }

