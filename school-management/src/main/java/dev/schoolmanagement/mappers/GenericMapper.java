package dev.schoolmanagement.mappers;

public interface GenericMapper <T, E>{
    T mapToEntity(E DTO);
    E mapToDTO(T entity);
}
