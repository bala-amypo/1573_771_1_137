package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

import java.net.BindException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DemoApplication.class);

        // First try with configured port (9001)
        app.addListeners(new PortFallbackListener());

        app.run(args);
    }

    /**
     * If port 9001 is already in use, retry on a random free port.
     */
    static class PortFallbackListener implements ApplicationListener<ApplicationFailedEvent> {

        private static boolean retried = false;

        @Override
        public void onApplicationEvent(ApplicationFailedEvent event) {
            Throwable ex = event.getException();

            while (ex != null) {
                if (ex instanceof BindException && !retried) {
                    retried = true;

                    System.err.println("⚠️ Port 9001 in use. Restarting on a free port...");

                    SpringApplication retryApp =
                            new SpringApplication(DemoApplication.class);

                    Map<String, Object> props = new HashMap<>();
                    props.put("server.port", "0"); // fallback only
                    retryApp.setDefaultProperties(props);

                    retryApp.run();
                    return;
                }
                ex = ex.getCause();
            }
        }
    }
}
