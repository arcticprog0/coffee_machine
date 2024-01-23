package com.av.coffee_machine.controller;

import com.av.coffee_machine.dto.CoffeeMachineDto;
import com.av.coffee_machine.service.CoffeeMachineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content)
    })
    @ResponseBody
    public CoffeeMachineDto getCoffeeMachine(@PathVariable("id") Long id){
        log.debug("getCoffeeMachine id={}", id);
        return coffeeMachineService.getCoffeeMachine(id);
    }

    @Operation(summary = "Получить все кофемашины")
    @GetMapping
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content)
    })
    @ResponseBody
    public List<CoffeeMachineDto> getAllCoffeeMachines(){
        log.debug("getAllCoffeeMachines");
        return coffeeMachineService.getAllCoffeeMachines();
    }

    @Operation(summary = "Добавить кофемашину")
    @PostMapping
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content)
    })
    @ResponseBody
    public CoffeeMachineDto addCoffeeMachine(@RequestBody CoffeeMachineDto coffeeMachine){
        log.debug("addCoffeeMachine");
        return coffeeMachineService.addCoffeeMachine(coffeeMachine);
    }

    @Operation(summary = "Обновить кофемашину")
    @PutMapping
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content)
    })
    @ResponseBody
    public CoffeeMachineDto updateCoffeeMachine(@RequestBody CoffeeMachineDto coffeeMachine){
        log.debug("updateCoffeeMachine");
        return coffeeMachineService.addCoffeeMachine(coffeeMachine);
    }

    @Operation(summary = "Приготовить кофе")
    @PutMapping(path = "/action/make-coffee/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content)
    })
    @ResponseBody
    public CoffeeMachineDto updateCoffeeMachineMakeCoffee(@PathVariable("id") Long id){
        log.debug("updateCoffeeMachineMakeCoffee id={}", id);
        return coffeeMachineService.makeCoffee(id);
    }

    @Operation(summary = "Почистить кофемашину")
    @PutMapping(path = "/action/clear-machine/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content)
    })
    @ResponseBody
    public CoffeeMachineDto updateCoffeeMachineClear(@PathVariable("id") Long id){
        log.debug("updateCoffeeMachineClear id={}", id);
        return coffeeMachineService.clearCoffeeMachine(id);
    }

    @Operation(summary = "Отремонтировать кофемашину")
    @PutMapping(path = "/action/repair-machine/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content)
    })
    @ResponseBody
    public CoffeeMachineDto updateCoffeeMachineRepair(@PathVariable("id") Long id){
        log.debug("updateCoffeeMachineRepair id={}", id);
        return coffeeMachineService.repairCoffeeMachine(id);
    }


    @Operation(summary = "Удалить кофемашину")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content)
    })
    @DeleteMapping(path = "/{id}")
    @ResponseBody
    public CoffeeMachineDto deleteCoffeeMachine(@PathVariable("id") Long id){
        log.debug("deleteCoffeeMachine id={}", id);
        return coffeeMachineService.deleteCoffeeMachine(id);
    }
}
