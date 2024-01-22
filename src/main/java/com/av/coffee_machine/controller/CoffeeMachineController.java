package com.av.coffee_machine.controller;

import com.av.coffee_machine.dto.CoffeeMachineDto;
import com.av.coffee_machine.service.CoffeeMachineService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("coffeemachines")
@Slf4j
public class CoffeeMachineController {

    @Autowired
    @Qualifier("CoffeeMachineService")
    private CoffeeMachineService coffeeMachineService;

    @Operation(summary = "Получить кофемашину по id")
    @GetMapping(path = "/{id}")
    @ResponseBody
    public CoffeeMachineDto getCoffeeMachine(@PathVariable("id") Long id){
        log.debug("getCoffeeMachine id={}", id);
        return coffeeMachineService.getCoffeeMachine(id);
    }

    @Operation(summary = "Получить все кофемашины")
    @GetMapping
    @ResponseBody
    public List<CoffeeMachineDto> getAllCoffeeMachines(){
        log.debug("getAllCoffeeMachines");
        return coffeeMachineService.getAllCoffeeMachines();
    }

    @Operation(summary = "Добавить кофемашину")
    @PostMapping
    @ResponseBody
    public CoffeeMachineDto addCoffeeMachine(@RequestBody CoffeeMachineDto coffeeMachine){
        log.debug("addCoffeeMachine");
        return coffeeMachineService.addCoffeeMachine(coffeeMachine);
    }

    @Operation(summary = "Обновить кофемашину")
    @PutMapping
    @ResponseBody
    public CoffeeMachineDto updateCoffeeMachine(@RequestBody CoffeeMachineDto coffeeMachine){
        log.debug("updateCoffeeMachine");
        return coffeeMachineService.addCoffeeMachine(coffeeMachine);
    }

    @Operation(summary = "Удалить кофемашину")
    @DeleteMapping(path = "/{id}")
    @ResponseBody
    public CoffeeMachineDto deleteCoffeeMachine(@PathVariable("id") Long id){
        log.debug("deleteCoffeeMachine id={}", id);
        return coffeeMachineService.deleteCoffeeMachine(id);
    }
}
