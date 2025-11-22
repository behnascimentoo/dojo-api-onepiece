package com.dojo.api_onepiece.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Entity
public class Pirata {

    private final Long id;
    private final String nome;
    private RacaPirata raca;
    private TripulacaoPirata tripulacao;
    private StatusPirata status;

}
