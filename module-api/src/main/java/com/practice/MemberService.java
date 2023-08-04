package com.practice;

import com.practice.domain.Member;
import com.practice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 1명 조회
     */
    public Member findOne(Long id) {
        return memberRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    /**
     * 회원 전체 조회
     */
    public List<Member> findAll() {
        return memberRepository.findAll();
    }


    /**
     * 회원 1명 삭제
     */
    public Long deleteOne(Long id) {
        Member findMember = memberRepository.findById(id).orElseThrow(RuntimeException::new);
        memberRepository.delete(findMember);
        return findMember.getId();
    }


    /**
     * 회원 저장
     */
    public Long save(Member member) {
        return memberRepository.save(member).getId();
    }
}
