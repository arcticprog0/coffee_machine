package com.av.coffee_machine.service;

import com.av.coffee_machine.entity.CoffeeMachineEntity;
import com.av.coffee_machine.repository.CoffeeMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeeMachineService {

    @Autowired
    private CoffeeMachineRepository coffeeMachineRepository;

    public CoffeeMachineEntity getCoffeeMachine(Long id){
        return coffeeMachineRepository.findById(id)
                .orElse(null);
    }
}
