package com.soloproject.Join.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberDto {
    @AllArgsConstructor
    @Getter
    public static class response {
        private long memberId;
        private String name;
        private String password;
        private String sex;
        private String companyName;
        private int companyType;
        private int companyLocation;
    }
}
