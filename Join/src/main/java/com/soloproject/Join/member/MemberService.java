package com.soloproject.Join.member;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.OptionalDataException;
import java.util.Optional;


@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final Pageable pageable;

    public MemberService(MemberRepository memberRepository, Pageable pageable){
        this.memberRepository = memberRepository;
        this.pageable = pageable;
    }
    public Page<Member> findMembers(int page, int size) {
        return memberRepository.findAll(PageRequest.of(page, size,
                Sort.by("memberId").descending()));
    }

    @Transactional(readOnly = true)
    public Page<Member> findFilteredMember(int companyType, int companyLocation) {
        Optional<Member> optionalMember = Optional.ofNullable(null);
        return memberRepository.findAllByCompanyTypeAndLocation(companyType, companyLocation, pageable);
    }

}
