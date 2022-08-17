package com.soloproject.Join.member;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Page<Member> findAllByCompanyTypeAndLocation(long companyType, long companyLocation, Pageable pageable);

}
