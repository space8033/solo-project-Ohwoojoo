package com.soloproject.Join.member;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-17T14:06:17+0900",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 11.0.15 (Azul Systems, Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public List<MemberDto.response> membersToMemberResponses(List<Member> members) {
        if ( members == null ) {
            return null;
        }

        List<MemberDto.response> list = new ArrayList<MemberDto.response>( members.size() );
        for ( Member member : members ) {
            list.add( memberToresponse( member ) );
        }

        return list;
    }

    protected MemberDto.response memberToresponse(Member member) {
        if ( member == null ) {
            return null;
        }

        long memberId = 0L;
        String name = null;
        String password = null;
        String sex = null;
        String companyName = null;
        int companyType = 0;
        int companyLocation = 0;

        if ( member.getMemberId() != null ) {
            memberId = member.getMemberId();
        }
        name = member.getName();
        password = member.getPassword();
        sex = member.getSex();
        companyName = member.getCompanyName();
        companyType = member.getCompanyType();
        companyLocation = member.getCompanyLocation();

        MemberDto.response response = new MemberDto.response( memberId, name, password, sex, companyName, companyType, companyLocation );

        return response;
    }
}
