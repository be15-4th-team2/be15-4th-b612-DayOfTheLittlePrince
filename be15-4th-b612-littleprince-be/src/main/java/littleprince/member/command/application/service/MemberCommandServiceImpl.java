package littleprince.member.command.application.service;


import littleprince.common.exception.BusinessException;
import littleprince.member.command.aggregate.domain.MemberDTO;
import littleprince.member.command.application.dto.request.SignupRequest;
import littleprince.member.command.mapper.MemberCommandMapper;
import littleprince.member.exception.MemberErrorCode;
import littleprince.member.query.dto.FindMemberDTO;
import littleprince.member.query.mapper.MemberQueryMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberQueryMapper memberQueryMapper;
    private final MemberCommandMapper memberCommandMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void signup(SignupRequest request) {

        /* 비밀번호와 비밀번호 확인 일치 확인 */
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new BusinessException(MemberErrorCode.PASSWORD_MISMATCH);
        }

        /* 1. DB에서 email 중복 확인 */
        Optional<FindMemberDTO> foundMember = memberQueryMapper.findMemberByEmail(request.getEmail());

        /* 중복인 경우 에러 응답*/
        if (foundMember.isPresent()) {
            throw new BusinessException(MemberErrorCode.DUPLICATE_EMAIL_EXISTS);
        }

        String encryptPassword = passwordEncoder.encode(request.getPassword());

        MemberDTO member = MemberDTO.builder()
                .email(request.getEmail())
                .password(encryptPassword)
                .build();

        /* 2. 회원 가입 완료 */
        memberCommandMapper.insertMember(member);
    }
}
