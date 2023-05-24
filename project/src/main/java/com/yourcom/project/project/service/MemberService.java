package com.yourcom.project.project.service;

import com.yourcom.project.project.dto.MemberDTO;
import com.yourcom.project.project.entity.MemberEntity;
import com.yourcom.project.project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(MemberDTO memberDTO) {
        //1.dto-> entity 변환
        //2. repository의 join 메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        String encodedPassword = passwordEncoder.encode(memberEntity.getMemberPassword());
        memberEntity.setMemberPassword(encodedPassword);
        memberRepository.save(memberEntity);
        //JPA에서 주는 SAVE메서드 무조건
    }


    public MemberDTO login(MemberDTO memberDto) {
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDto.getMemberEmail());
        if (byMemberEmail.isPresent()) {
            // there are query results
            MemberEntity memberEntity = byMemberEmail.get();
            if (passwordEncoder.matches(memberDto.getMemberPassword(), memberEntity.getMemberPassword())) {
                // match password
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            } else {
                // password mismatch
                return null;
            }
        } else {
            // no search result
            return null;
        }
    }
}

