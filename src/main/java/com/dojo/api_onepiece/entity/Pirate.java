package com.dojo.api_onepiece.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Pirate")
public class Pirate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) //função não-nula no banco
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RacePirate race;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CrewPirate crewPirate;

    @Enumerated(EnumType.STRING)
    @Column
    private StatusPirate status;

}
