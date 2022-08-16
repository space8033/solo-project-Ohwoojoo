package com.soloproject.Join.member;

import com.soloproject.Join.exception.BusinessLogicException;
import com.soloproject.Join.exception.ExceptionCode;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final ApplicationEventPublisher publisher;

    public MemberService(MemberRepository memberRepository, ApplicationEventPublisher publisher){
        this.memberRepository = memberRepository;
        this.publisher = publisher;
    }
    public Page<Member> findMembers(int page, int size) {
        return memberRepository.findAll(PageRequest.of(page, size,
                Sort.by("memberId").descending()));
    }

    @Transactional(readOnly = true)
    public Member findMember(long companyType, long companyLocation) {
        return findVerifiedMember(companyType, companyLocation);
    }

    @Transactional(readOnly = true)
    public Member findVerifiedMember(long companyType, long companyLocation) {
        Optional<Member> optionalMembers =
                memberRepository.equals(companyType)
        Member findMember =
                optionalMembers.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        return findMember;
    }
}
