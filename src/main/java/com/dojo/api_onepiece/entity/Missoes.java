package com.dojo.api_onepiece.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Missoes {

    private final Long id;
    private DangerLevel dangerLevel;
    private TipoMissao tipoMissao;
    private StatusMissao statusMissao;

}
