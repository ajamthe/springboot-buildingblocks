package com.stacksimplify.restservices.config;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.lang.Nullable;
import io.micrometer.dynatrace.DynatraceConfig;
import io.micrometer.dynatrace.DynatraceMeterRegistry;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MonitoringConfig {
    private static String MY_TOKEN = "blah";
    private static String MY_DYNATRACE_URI = "https://blahs.live.dynatrace.com";
    private static String MY_DEVICE_ID = "sample";

    DynatraceConfig dynatraceConfig = new DynatraceConfig() {
        @Override
        public String apiToken() {
            return MY_TOKEN;
        }

        @Override
        public String uri() {
            return MY_DYNATRACE_URI;
        }

        @Override
        public String deviceId() {
            return MY_DEVICE_ID;
        }

        @Override
        @Nullable
        public String get(String k) {
            return null;
        }
    };
    MeterRegistry registry = new DynatraceMeterRegistry(dynatraceConfig, Clock.SYSTEM);
}
