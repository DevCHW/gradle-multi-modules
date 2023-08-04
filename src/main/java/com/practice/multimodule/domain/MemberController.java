package com.practice.multimodule.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원 1명 조회
     */
    @GetMapping("/{id}")
    public BaseResponse<Member> read(@PathVariable Long id) {
        Member data = memberService.findOne(id);
        return new BaseResponse<>(data);
    }

    /**
     * 회원 전체 조회
     */
    @GetMapping
    public BaseResponse<List<Member>> readAll() {
        List<Member> data = memberService.findAll();
        return new BaseResponse<>(data);

    }

    /**
     * 회원 1명 삭제
     */
    @DeleteMapping("/{id}")
    public BaseResponse<Long> remove(@PathVariable Long id) {
        Long deletedId = memberService.deleteOne(id);
        return new BaseResponse<>(deletedId);
    }

    /**
     * 회원 저장
     */
//    @PostMapping("/{id}")
//    public BaseResponse<Long> signUp(@RequestBody PostMemberRequest request) {
//
//    }

    /**
     * 회원 수정
     */
//    @PatchMapping("/{id}")
//    public BaseResponse<Long> update(@RequestBody PatchMemberRequest request) {
//
//    }
}

