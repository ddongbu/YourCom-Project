package com.yourcom.project.project.controller;

import com.yourcom.project.project.dto.MemberDTO;
import com.yourcom.project.project.entity.MemberEntity;
import com.yourcom.project.project.entity.Users;
import com.yourcom.project.project.repository.MemberRepository;
import com.yourcom.project.project.service.CustomOAuth2UserService;
import com.yourcom.project.project.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;
import java.security.Principal;


@Controller
@RequiredArgsConstructor
public class MemberController {
    private CustomOAuth2UserService customOAuth2UserService;
    private  final MemberService memberService;
    //회원가입

    //로그아웃 (시큐리티에서 정확하게 처리 완료)
    @GetMapping("/session/logout")
    public String logout(){
        return "/Main";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "/login";
    }
    //로그인처리
    @PostMapping("/loginProc")
    public String loginForm(@ModelAttribute MemberDTO memberDto, HttpSession session, Model model,Authentication authentication,
                            @AuthenticationPrincipal OAuth2User oauth) {
        MemberDTO loginResult = memberService.login(memberDto);
        //일반 로그인
        if (loginResult != null) {
            //login 성공
            session.setAttribute("loginName", loginResult.getMemberName());
            return "/AfterMain";
            //소셜로그인
        } else if (oauth != null) {

            return "/AfterMain";
        } else {
            //login 실패
            model.addAttribute("errorMessage", "비밀번호가 틀렸습니다. 다시 확인 해주세요");
            return "login";
        }
    }

    @GetMapping("/social/AfterMain")
    public String socialloginForm(@AuthenticationPrincipal OAuth2User oauth,HttpSession session,OAuth2AuthenticationToken oauthToken) {
        System.out.println("OAuth2User:" + oauth.getAttributes());
        OAuth2User oauthUser = oauthToken.getPrincipal();
        session.setAttribute("loginName2", oauthUser.getAttribute("name"));
        session.setAttribute("loginName3", oauthUser.getAttribute("properties"));
        return"/AfterMain";
    }
    @GetMapping("/join")
    public String joinForm(@ModelAttribute MemberEntity memberEntity){

        return "join";
    }
    @PostMapping("/join")
    public String save(@ModelAttribute MemberDTO memberDTO) {

        System.out.println("BoardController.join");
        System.out.println("memberDTO = " + memberDTO);
        memberDTO.setRole("GUEST");
        memberService.save(memberDTO);

        return "AfterMain";
    }
}
