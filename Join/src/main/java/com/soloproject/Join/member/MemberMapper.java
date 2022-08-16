package com.soloproject.Join.member;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {
    MemberDto.response memberToMemberResponse(Member member);
    List<MemberDto.response> membersToMemberResponses(List<Member> members);
}
