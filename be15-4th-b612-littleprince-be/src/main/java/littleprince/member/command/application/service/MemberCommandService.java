package littleprince.member.command.application.service;


import jakarta.validation.Valid;
import littleprince.member.command.application.dto.request.SignupRequest;

public interface MemberCommandService {
    void signup(@Valid SignupRequest request);
}
