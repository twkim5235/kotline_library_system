package com.library.src.member.application

import com.library.src.member.application.model.JoinCommand
import com.library.src.member.application.model.JoinResponse
import com.library.src.member.domain.Member
import com.library.src.member.domain.MemberRepository
import org.springframework.stereotype.Service

@Service
class JoinMemberService(
    private val memberRepository: MemberRepository
) {
    fun joinMember(cmd: JoinCommand): JoinResponse {
        val member = Member(
            memberId = cmd.memberId,
            password = cmd.password,
            name = cmd.name,
            email = cmd.email,
            grade = cmd.grade,
            studentId = cmd.studentId
        )

        val saveMember: Member = memberRepository.save(member)

        return JoinResponse(
            memberId = saveMember.memberId,
            name = saveMember.name,
            grade = saveMember.grade,
            studentId = saveMember.studentId
        )
    }
}