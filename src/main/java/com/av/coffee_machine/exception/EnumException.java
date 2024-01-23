package com.av.coffee_machine.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum EnumException {

    COFFEE_MACHINE_NOT_FOUND("Кофемашина c id: %s не найдена."),
    COFFEE_MACHINES_NOT_FOUND("Кофемашины не найдены."),
    MIN_COFFEE_LEVEL("Минимальный уровень кофе!"),
    MIN_WATER_LEVEL("Минимальный уровень воды!"),
    MAX_DIRTY_WATER_LEVEL("Необходимо очистить грязную воду!"),
    RESOURCE_FINISHED_COFFEE_MACHINE("Ресурс кофемашины исчерпан.Отремонтируйте ее!"),
    WATER_LEVEL_LIMIT_COFFEE_MACHINE("Уровень воды должен быть в диапазоне от 0 до 100."),
    COFFEE_LEVEL_LIMIT_COFFEE_MACHINE("Уровень кофе должен быть в диапазоне от 0 до 100.");

    private final String message;
    private final HttpStatus httpStatus;

    EnumException(String message){
        this(message, HttpStatus.NOT_FOUND);
    }

    public String toString(){
        return message;
    }

    public String getFormattedMessage(Object... args) {
        return String.format(message, args);
    }
}
