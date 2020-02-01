package com.weather.region.config;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.weather.region.annotations.DTOConverter;
import com.weather.region.converters.ConverterFacade;
import com.weather.region.converters.IConverter;

@Component
@Configuration
public class ConvertersPostProcessor implements BeanPostProcessor {

    @Autowired
    ConverterFacade converterFactory;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        Class clazz = bean.getClass();
        if (clazz.isAnnotationPresent(DTOConverter.class)){
            DTOConverter converter = (DTOConverter) clazz.getAnnotation(DTOConverter.class);
            Class destination = converter.destination();
            converterFactory.addConverter((IConverter) bean, destination);
        }
        return bean;
    }
}
