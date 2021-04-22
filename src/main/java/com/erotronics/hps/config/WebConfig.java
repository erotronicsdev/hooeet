package com.erotronics.hps.config;

import com.erotronics.hps.converter.StringToEmployeeConverter;
import com.erotronics.hps.converter.StringToFullSongConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToFullSongConverter());
        registry.addConverter(new StringToEmployeeConverter());
    }
}
