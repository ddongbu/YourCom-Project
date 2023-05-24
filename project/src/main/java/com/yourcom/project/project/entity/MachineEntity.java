package com.yourcom.project.project.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MachineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY는 마리아디비
    private Integer id;
    @Column
    private String cpu;
    @Column
    private String gpu;
    @Column
    private String mainboard;
    @Column
    private String power;
    @Column
    private String ram;
    @Column
    private String ssd;


}
