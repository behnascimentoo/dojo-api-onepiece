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
@Table(name = "tb_pirate")
public class Pirate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) //função não-nula no banco
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RacePirate race;

    @Column(nullable = false)
    private String crewPirate;

    @Enumerated(EnumType.STRING)
    @Column
    private StatusPirate status;

}
