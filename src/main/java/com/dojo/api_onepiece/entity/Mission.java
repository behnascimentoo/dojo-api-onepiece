package com.dojo.api_onepiece.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_mission")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private DangerLevel dangerLevel;

    @Column
    @Enumerated(EnumType.STRING)
    private TypeOfMission typeMission;

    @Column()
    @Enumerated(EnumType.STRING)
    private StatusMission statusMission;

    @OneToOne
    @JoinColumn(name = "pirate_id")
    private Pirate pirate;
}
