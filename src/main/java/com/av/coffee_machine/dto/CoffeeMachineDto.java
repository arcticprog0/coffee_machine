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
@Schema(description = "Модель кофемашины")
public class CoffeeMachineDto {

    @Schema(description = "Id записи в БД")
    private Long id;

    @Schema(description = "Наименование", example = "Кофемашина №1")
    private String name;

    @Schema(description = "Уровень воды в кофемашине", example = "30")
    private Integer waterLevel;

    @Schema(description = "Уровень кофе в кофемашине", example = "30")
    private Integer coffeeLevel;

    @Schema(description = "Уровень грязной воды в кофемашине", example = "0")
    private Integer dirtyWaterLevel;

    @Schema(description = "Текущий ресурс машины (измеряется в кружках кофе)", example = "0")
    private Integer currentResource;

    @Schema(description = "Предельный ресурс кофемашины", example = "10")
    private Integer resourceLimit;
}
