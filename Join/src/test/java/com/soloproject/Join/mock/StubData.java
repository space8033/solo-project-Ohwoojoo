package com.soloproject.Join.mock;

import com.soloproject.Join.dto.MultiResponseDto;
import com.soloproject.Join.member.Member;
import com.soloproject.Join.member.MemberDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;

import java.util.List;
import java.util.Map;

public class StubData {
    private static Map<HttpMethod, Object> stubRequestBody;

    public static class MockMember{
        public static List<MemberDto.response> getMultiResponseBody() {
            return List.of(
                    new MemberDto.response(1L, "김코딩", "s4goodbye!", "M", "프로젝트 스테이츠", 005, 001),
                    new MemberDto.response(2L, "이코딩", "s5goodbye!", "W", "프로젝트 스테이크", 003, 001),
                    new MemberDto.response(3L, "박코딩", "s6goodbye!", "W", "프로젝트 스테이크", 003, 003)
            );
        }

        public static Page<Member> getMultiResultMember() {
            Member member1= new Member( "김코딩", "s4goodbye!", "M", "프로젝트 스테이츠", 005, 001);
            Member member2= new Member( "이코딩", "s5goodbye!", "W", "프로젝트 스테이크", 003, 001);
            Member member3= new Member( "박코딩", "s6goodbye!", "W", "프로젝트 스테이크", 003, 003);

            return new PageImpl<>(List.of(member1, member2, member3), PageRequest.of(0,10,Sort.by("memberId").descending()),2);
        }
    }
}
