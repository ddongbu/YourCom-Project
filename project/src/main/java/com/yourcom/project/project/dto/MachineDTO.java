package com.yourcom.project.project.dto;

import com.yourcom.project.project.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MachineDTO {
    private Long id;
    private String cpu;
    private String ram;
    private String ssd;
    private String mainboard;
    private String gpu;
    private String power;


}
