package com.example.jwtpractice.controller;

import com.example.jwtpractice.entity.NZMember;
import com.example.jwtpractice.service.NZMemberService;
import com.example.jwtpractice.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
public class NZMemberController {

    private final NZMemberService nzMemberService;
    private final TokenService tokenService;
    private static final Logger LOG = LoggerFactory.getLogger(NZMemberController.class);

    public NZMemberController(NZMemberService nzMemberService, TokenService tokenService) {
        this.nzMemberService = nzMemberService;
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    public String token(Authentication authentication){
        LOG.debug("Token requested for user: '{}'", authentication.getName());
        String token = tokenService.generateToken(authentication);
        LOG.debug("Token granted {}", token);
        return token;
    }

    @PostMapping("/addMember")
    public NZMember addMember(@RequestBody NZMember nzMember){
        return nzMemberService.saveMember(nzMember);
    }

    @GetMapping("/")
    public String Home(Principal principal){
        return "Hello welcome to nujaira's world "+ principal.getName();
    }
}
