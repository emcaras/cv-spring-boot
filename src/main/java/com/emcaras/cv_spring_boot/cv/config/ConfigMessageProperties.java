package com.emcaras.cv_spring_boot.cv.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath*:message.properties")
})
public class ConfigMessageProperties {
}
