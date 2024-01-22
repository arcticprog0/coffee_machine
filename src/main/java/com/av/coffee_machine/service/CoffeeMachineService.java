package com.av.coffee_machine.service;

import com.av.coffee_machine.dto.CoffeeMachineDto;
import com.av.coffee_machine.mapper.CoffeeMachineMapper;
import com.av.coffee_machine.repository.CoffeeMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CoffeeMachineService")
public class CoffeeMachineService {

    @Autowired
    private CoffeeMachineRepository coffeeMachineRepository;

    @Autowired
    private CoffeeMachineMapper coffeeMachineMapper;

    public CoffeeMachineDto getCoffeeMachine(Long id){
        /*
        return coffeeMachineRepository.findById(id)
                .orElse(null);
         */
        return coffeeMachineMapper.toDto(coffeeMachineRepository.findById(id).orElse(null));
    }

    public List<CoffeeMachineDto> getAllCoffeeMachines(){
        /*
        return coffeeMachineRepository.findAll();
        */
        return  coffeeMachineMapper.mapList(coffeeMachineRepository.getAll(), CoffeeMachineDto.class);
    }

    public CoffeeMachineDto addCoffeeMachine(CoffeeMachineDto coffeeMachineDto){
        /*
        return coffeeMachineRepository.save(coffeeMachineDto);
         */
        return coffeeMachineMapper.toDto(coffeeMachineRepository.save(coffeeMachineMapper.toEntity(coffeeMachineDto)));
    }


    public CoffeeMachineDto deleteCoffeeMachine(Long id){
        /*
        CoffeeMachineEntity coffeeMachine = getCoffeeMachine(id);
        if(coffeeMachine == null) {
            return null;
        }

       coffeeMachineRepository.delete(coffeeMachine);
       return coffeeMachine;
       */

        CoffeeMachineDto coffeeMachineDto = getCoffeeMachine(id);
        if(coffeeMachineDto == null) {
            return null;
        }

        coffeeMachineRepository.delete(coffeeMachineMapper.toEntity(coffeeMachineDto));
        return coffeeMachineDto;
    }
}
