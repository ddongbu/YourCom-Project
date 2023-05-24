package com.yourcom.project.project.dto;

import com.yourcom.project.project.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDTO {
    private Long ID;
    private String memberPassword;
    private String memberEmail;
    private String memberName;
    private String role;
    private String provider;
    private String providerId;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setID(memberEntity.getId());
        memberDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());
        memberDTO.setMemberName(memberEntity.getMemberName());
        memberDTO.setRole(memberEntity.getRole());
        return memberDTO;
    }

}
