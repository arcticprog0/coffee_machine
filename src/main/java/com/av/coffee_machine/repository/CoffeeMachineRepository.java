package com.av.coffee_machine.repository;

import com.av.coffee_machine.entity.CoffeeMachineEntity;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeMachineRepository extends CrudRepository<CoffeeMachineEntity, Long> {
}
