/*
package org.c7worker;

import jakarta.annotation.PostConstruct;
import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ServiceTaskWorkers implements ExternalTaskHandler {

    private static final Logger log = LoggerFactory.getLogger(ServiceTaskWorkers.class);
    private ExternalTaskClient client;

    @PostConstruct
    public void init() {
        client = ExternalTaskClient.create()
                .baseUrl("http://localhost:8080/engine-rest")
                .asyncResponseTimeout(10000)
                .build();

        client.subscribe("task-nr-1")
                .lockDuration(1000)
                .handler(this)
                .open();
    }

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        ServiceTaskWorkers.log.info("Task empfangen! Ich arbeite jetzt...");

        // Task abschließen
        externalTaskService.complete(externalTask);
        ServiceTaskWorkers.log.info("Task fertig!");
    }
}*/
