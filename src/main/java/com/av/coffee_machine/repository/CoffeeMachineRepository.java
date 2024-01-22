package com.av.coffee_machine.repository;

import com.av.coffee_machine.entity.CoffeeMachineEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoffeeMachineRepository extends CrudRepository<CoffeeMachineEntity, Long> {

    @Query("select c from CoffeeMachineEntity c ")
    List<CoffeeMachineEntity> getAll();

}
