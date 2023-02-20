package com.example.jwtpractice.controller;

import com.example.jwtpractice.entity.NZMember;
import com.example.jwtpractice.service.NZMemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NZMemberController {

    private final NZMemberService nzMemberService;

    public NZMemberController(NZMemberService nzMemberService) {
        this.nzMemberService = nzMemberService;
    }

    @PostMapping("/addMember")
    public NZMember addMember(@RequestBody NZMember nzMember){
        return nzMemberService.saveMember(nzMember);
    }

    @GetMapping("/")
    public String Home(){
        return "Hello Hujur";
    }
}
