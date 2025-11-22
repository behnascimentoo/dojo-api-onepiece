package com.dojo.api_onepiece.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Pirate")
public class Pirate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    @Column
    private final String name;

    @Enumerated(EnumType.STRING)
    @Column
    private RacePirate race;

    @Enumerated(EnumType.STRING)
    @Column
    private CrewPirate crewPirate;

    @Enumerated(EnumType.STRING)
    @Column
    private StatusPirate status;

}
