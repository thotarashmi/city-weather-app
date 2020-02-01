package com.weather.region.converters;


import org.springframework.stereotype.Component;

import com.weather.region.exceptions.ConverterNotFoundException;

import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ConverterFacade {

    // Key = dto object
    private Map<Class, IConverter> converters = new HashMap<>();

    public void addConverter(IConverter converter, Class clazz) {
        converters.put(clazz, converter);
    }

    private IConverter getConverter(Class clazz) {
        return converters.get(clazz);
    }

    public <D, E> D convertToDTO(E entity, Class<D> clazz) {
        IConverter converter = getConverter(clazz);
        converterChecker(converter);
        D obj = (D) converter.convertToDTO(entity);
        return obj;
    }

    public <D, E> List<D> convertToDTO(Collection<E> entity, Class<D> clazz) {
        IConverter converter = getConverter(clazz);
        converterChecker(converter);
        List<D> obj = (List<D>) converter.convertToDTO(entity);
        return obj;
    }

    public <D, E> D convertToDTO(E entity, Class<D> clazz, Map<String, Object> parameters) {
        IConverter converter = getConverter(clazz);
        converterChecker(converter);
        D obj = (D) converter.convertToDTO(entity, parameters);
        return obj;
    }

    public <D, E> List<D> convertToDTO(Collection<E> entity, Class<D> clazz, Map<String, Object> parameters) {
        IConverter converter = getConverter(clazz);
        converterChecker(converter);
        List<D> obj = (List<D>) converter.convertToDTO(entity, parameters);
        return obj;
    }

    public <D, E> List<E> convertToEntity(Collection<D> dto) {
        if (dto != null && !dto.isEmpty()) {
            D next = dto.iterator().next();
            IConverter converter = getConverter(next.getClass());
            converterChecker(converter);
            List<E> obj = (List<E>) converter.convertToEntity(dto);
            return obj;
        }
        return Collections.emptyList();
    }

    public <D, E> E convertToEntity(D dto) {
        if (dto != null){
            IConverter converter = getConverter(dto.getClass());
            converterChecker(converter);
            E obj = (E) converter.convertToEntity(dto);
            return obj;
        }

        return null;
    }

    public <D, E> void mergeIntoEntity(D dto, E entity) {
        if (dto != null && entity != null){
            IConverter converter = getConverter(dto.getClass());
            converterChecker(converter);
            converter.mergeIntoEntity(dto, entity);
        }
    }

    private void converterChecker(IConverter converter) {
        if (converter == null) {
            throw new ConverterNotFoundException();
        }
    }

}
