package com.av.coffee_machine.mapper;

import com.av.coffee_machine.dto.CoffeeMachineDto;
import com.av.coffee_machine.entity.CoffeeMachineEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CoffeeMachineMapper {
    @Autowired
    private ModelMapper modelMapper;

    public CoffeeMachineEntity toEntity(CoffeeMachineDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, CoffeeMachineEntity.class);
    }

    public CoffeeMachineDto toDto(CoffeeMachineEntity entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, CoffeeMachineDto.class);
    }
    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}
