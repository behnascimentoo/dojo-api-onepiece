package com.dojo.api_onepiece.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Mission")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private DangerLevel dangerLevel;

    @Column
    @Enumerated(EnumType.STRING)
    private TypeOfMission typeMission;

    @Column
    @Enumerated(EnumType.STRING)
    private StatusMission statusMission;

}
