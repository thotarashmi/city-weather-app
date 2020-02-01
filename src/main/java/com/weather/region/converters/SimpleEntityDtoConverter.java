package com.weather.region.converters	;


import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class  SimpleEntityDtoConverter<E, D> implements IConverter<E, D> {

    private Class<E> entityType;
    private Class<D> dtoType;

    @Autowired
    protected ModelMapper modelMapper;

    public SimpleEntityDtoConverter(Class<E> entityType, Class<D> dtoType) {
        this.entityType = entityType;
        this.dtoType = dtoType;
    }

    @PostConstruct
    public void configure() {
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
    }

    public E convertToEntity(D dto) {
        if (dto == null) {
            return null;
        }
        return modelMapper.map(dto, entityType);
    }

    public E convertToEntity(D dto, Map<String, Object> parameters) {
        return convertToEntity(dto);
    }

    public List<E> convertToEntity(Collection<D> dto) {
        List<E> result = new ArrayList<>();
        if (dto != null) {
            for (D d : dto) {
                result.add(convertToEntity(d));
            }
        }
        return result;
    }

    public List<E> convertToEntity(Collection<D> dto, Map<String, Object> parameters) {
        List<E> result = new ArrayList<>();
        if (dto != null) {
            for (D d : dto) {
                result.add(convertToEntity(d, parameters));
            }
        }
        return result;
    }

    public D convertToDTO(E entity) {
        if (entity == null) {
            return null;
        }
        return modelMapper.map(entity, dtoType);
    }

    public D convertToDTO(E entity, Map<String, Object> parameters) {
        return convertToDTO(entity);
    }

    public final List<D> convertToDTO(Collection<E> entity) {
        List<D> result = new ArrayList<>();
        if (entity != null) {
            for (E e : entity) {
                result.add(convertToDTO(e));
            }
        }
        return result;
    }

    public List<D> convertToDTO(Collection<E> entity, Map<String, Object> parameters) {
        List<D> result = new ArrayList<>();
        if (entity != null) {
            for (E e : entity) {
                result.add(convertToDTO(e, parameters));
            }
        }
        return result;
    }

    public void mergeIntoEntity(D dto, E entity) {
        modelMapper.map(dto, entity);
    }

}



