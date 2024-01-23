package com.av.coffee_machine.service;

import com.av.coffee_machine.dto.CoffeeMachineDto;
import com.av.coffee_machine.entity.CoffeeMachineEntity;
import com.av.coffee_machine.exception.EnumException;
import com.av.coffee_machine.exception.ExpectedException;
import com.av.coffee_machine.mapper.CoffeeMachineMapper;
import com.av.coffee_machine.repository.CoffeeMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<CoffeeMachineEntity> coffeeMachine = coffeeMachineRepository.findById(id);
        if(coffeeMachine.isEmpty()){
            throw new ExpectedException(404, EnumException.COFFEE_MACHINE_NOT_FOUND.getFormattedMessage(id));
        }

        return coffeeMachineMapper.toDto(coffeeMachineRepository.findById(id).orElse(null));
    }

    public List<CoffeeMachineDto> getAllCoffeeMachines(){
        List<CoffeeMachineEntity> coffeeMachines = coffeeMachineRepository.getAll();
        if(coffeeMachines.isEmpty()){
            throw new ExpectedException(EnumException.COFFEE_MACHINES_NOT_FOUND);
        }
        return  coffeeMachineMapper.mapList(coffeeMachines, CoffeeMachineDto.class);
    }

    public CoffeeMachineDto addCoffeeMachine(CoffeeMachineDto coffeeMachineDto){

        if (coffeeMachineDto.getWaterLevel() > 100 || coffeeMachineDto.getWaterLevel() < 0) {
            throw new ExpectedException(EnumException.WATER_LEVEL_LIMIT_COFFEE_MACHINE);
        }
        if (coffeeMachineDto.getCoffeeLevel() > 100 || coffeeMachineDto.getCoffeeLevel() < 0) {
            throw new ExpectedException(EnumException.COFFEE_LEVEL_LIMIT_COFFEE_MACHINE);
        }

        return coffeeMachineMapper.toDto(coffeeMachineRepository.save(coffeeMachineMapper.toEntity(coffeeMachineDto)));
    }

    public CoffeeMachineDto makeCoffee(Long id){
        CoffeeMachineEntity coffeeMachineEntity = coffeeMachineMapper.toEntity(getCoffeeMachine(id));

        if (coffeeMachineEntity.getCoffeeLevel() <= 5) {
            throw new ExpectedException(EnumException.MIN_COFFEE_LEVEL);
        }
        if (coffeeMachineEntity.getWaterLevel() <= 10) {
            throw new ExpectedException(EnumException.MIN_WATER_LEVEL);
        }
        if (coffeeMachineEntity.getDirtyWaterLevel() >= 30) {
            throw new ExpectedException(EnumException.MAX_DIRTY_WATER_LEVEL);
        }
        if(coffeeMachineEntity.getCurrentResource() == coffeeMachineEntity.getResourceLimit()) {
            throw new ExpectedException(EnumException.RESOURCE_FINISHED_COFFEE_MACHINE);
        }

        coffeeMachineEntity.makeCoffee();
        return coffeeMachineMapper.toDto(coffeeMachineRepository.save(coffeeMachineEntity));
    }

    public CoffeeMachineDto clearCoffeeMachine(Long id){
        CoffeeMachineEntity coffeeMachineEntity = coffeeMachineMapper.toEntity(getCoffeeMachine(id));
        coffeeMachineEntity.clearCoffeeMachine();

        return coffeeMachineMapper.toDto(coffeeMachineRepository.save(coffeeMachineEntity));
    }

    public CoffeeMachineDto repairCoffeeMachine(Long id){
        CoffeeMachineEntity coffeeMachineEntity = coffeeMachineMapper.toEntity(getCoffeeMachine(id));
        coffeeMachineEntity.repairCoffeeMachine();

        return coffeeMachineMapper.toDto(coffeeMachineRepository.save(coffeeMachineEntity));
    }


    public CoffeeMachineDto deleteCoffeeMachine(Long id){
        CoffeeMachineDto coffeeMachineDto = getCoffeeMachine(id);
        if(coffeeMachineDto == null) {
            return null;
        }

        coffeeMachineRepository.delete(coffeeMachineMapper.toEntity(coffeeMachineDto));
        return coffeeMachineDto;
    }
}
