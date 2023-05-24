package com.yourcom.project.project.controller;

import com.yourcom.project.project.dto.OAuthAttributes;
import com.yourcom.project.project.service.CustomOAuth2UserService;
import com.yourcom.project.project.service.UserPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class MypageController {
    private final UserPageService userPageService;
    private final CustomOAuth2UserService customOAuth2UserService;


}
