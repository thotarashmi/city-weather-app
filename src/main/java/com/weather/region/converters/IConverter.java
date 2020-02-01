package com.weather.region.converters;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface IConverter <E, D> {
    E convertToEntity(D dto);
    E convertToEntity(D dto, Map<String, Object> parameters);
    List<E> convertToEntity(Collection<D> dto);
    List<E> convertToEntity(Collection<D> dto, Map<String, Object> parameters);
    D convertToDTO(E entity);
    D convertToDTO(E entity, Map<String, Object> parameters);
    List<D> convertToDTO(Collection<E> entity);
    List<D> convertToDTO(Collection<E> entity, Map<String, Object> parameters);
    void mergeIntoEntity(D dto, E entity);
}
