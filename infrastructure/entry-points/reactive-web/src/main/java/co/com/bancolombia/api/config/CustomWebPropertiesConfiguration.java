package co.com.bancolombia.api.config;

import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomWebPropertiesConfiguration {

    @Bean
    public WebProperties.Resources customWebResources() {
        WebProperties.Resources resources = new WebProperties.Resources();
        return resources;
    }
}
