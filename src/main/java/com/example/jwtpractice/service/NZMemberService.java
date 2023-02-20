package com.example.jwtpractice.service;

import com.example.jwtpractice.entity.NZMember;
import com.example.jwtpractice.repository.NZMemberRepo;
import org.springframework.stereotype.Service;

@Service
public class NZMemberService {

    private final NZMemberRepo nzMemberRepo;

    public NZMemberService(NZMemberRepo nzMemberRepo) {
        this.nzMemberRepo = nzMemberRepo;
    }

    public NZMember saveMember(NZMember nzMember){
        return nzMemberRepo.save(nzMember);
    }
}
