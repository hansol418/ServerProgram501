package com.busanit501.samplejsp501.member.dto;

import java.time.LocalDate;

public class MemberDTO {
    // 인스턴스 멤버.
    private Long memberNo;
    private String memberTitle;
    private LocalDate dueDate;

    public Long getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Long memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberTitle() {
        return memberTitle;
    }

    public void setMemberTitle(String memberTitle) {
        this.memberTitle = memberTitle;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberNo=" + memberNo +
                ", memberTitle='" + memberTitle + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}







