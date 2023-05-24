package com.yourcom.project.project.entity;

import com.yourcom.project.project.dto.MemberDTO;

import lombok.CustomLog;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY는 마리아디비
    private Long id;
    @Column
    private String memberPassword;

    @Column(unique= true)
    private String memberEmail;

    @Column
    private String memberName;
    @Column
    private String role;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getID());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setRole(memberDTO.getRole());
        return memberEntity;
    }

}
