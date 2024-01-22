package com.av.coffee_machine.controller;

import com.av.coffee_machine.entity.CoffeeMachineEntity;
import com.av.coffee_machine.service.CoffeeMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("coffeemachines")
public class CoffeeMachineController {

    @Autowired
    private CoffeeMachineService coffeeMachineService;

    @GetMapping(path = "/{id}")
    @ResponseBody
    public CoffeeMachineEntity get(@PathVariable("id") Long id){

        return coffeeMachineService.getCoffeeMachine(id);
    }
}
