package com.av.coffee_machine.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeMachineDto {

    @Schema(description = "Id записи в БД")
    private Long id;

    @Schema(description = "Наименование", example = "Кофемашина №1")
    private String name;
}
