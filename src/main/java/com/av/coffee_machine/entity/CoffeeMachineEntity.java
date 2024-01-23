package com.av.coffee_machine.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "public", name = "coffee_machines")
public class CoffeeMachineEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer waterLevel;
    @Column(nullable = false)
    private Integer coffeeLevel;
    @Column(nullable = false)
    private Integer dirtyWaterLevel;
    @Column(nullable = false)
    private Integer currentResource;

    @Column(nullable = false)
    private Integer resourceLimit;

    public void makeCoffee()
    {
        currentResource++;
        coffeeLevel -= 5;
        waterLevel -= 10;
        dirtyWaterLevel += 5;
    }

    public void clearCoffeeMachine()
    {
        dirtyWaterLevel = 0;
    }

    public void repairCoffeeMachine()
    {
        currentResource = 0;
    }
}
