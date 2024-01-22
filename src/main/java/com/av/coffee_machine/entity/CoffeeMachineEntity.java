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

    private String name;
}
