package com.soloproject.Join.mock;

import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.request.ParameterDescriptor;

import java.util.Arrays;
import java.util.List;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;

public interface MemberControllerTestHelper extends ControllerTestHelper{
    String MEMBER_URL = "/v1/members";
    String RESOURCE_URI = "/3/1";

    default String getUrl() {
        return MEMBER_URL;
    }

    default String getURI() {
        return MEMBER_URL + RESOURCE_URI;
    }

    default List<ParameterDescriptor> getMemberRequestPathParameterDescriptor() {
        return Arrays.asList(parameterWithName("member-id").description("회원 식별자 ID"));
    }

    default List<FieldDescriptor> getDefaultMemberResponseDescriptors(DataResponseType dataResponseType) {
        String parentPath = getDataParentPath(dataResponseType);
        return List.of(
                fieldWithPath(parentPath.concat("memberId")).type(JsonFieldType.NUMBER).description("회원 식별자"),
                fieldWithPath(parentPath.concat("name")).type(JsonFieldType.STRING).description("이름"),
                fieldWithPath(parentPath.concat("password")).type(JsonFieldType.STRING).description("비밀번호"),
                fieldWithPath(parentPath.concat("sex")).type(JsonFieldType.STRING).description("성별"),
                fieldWithPath(parentPath.concat("companyName")).type(JsonFieldType.STRING).description("회사이름"),
                fieldWithPath(parentPath.concat("companyType")).type(JsonFieldType.NUMBER).description("회사타입"),
                fieldWithPath(parentPath.concat("companyLocation")).type(JsonFieldType.NUMBER).description("회사위치")
        );
    }
}
