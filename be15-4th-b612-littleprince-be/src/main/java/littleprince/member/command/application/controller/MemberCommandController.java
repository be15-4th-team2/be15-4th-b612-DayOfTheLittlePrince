package littleprince.member.command.application.controller;

import jakarta.validation.Valid;
import littleprince.common.dto.ApiResponse;
import littleprince.member.command.application.dto.request.SignupRequest;
import littleprince.member.command.application.service.MemberCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberCommandController {
    private final MemberCommandService memberCommandService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<Void>> signup(
            @RequestBody @Valid SignupRequest request
    ){
        memberCommandService.signup(request);
        return ResponseEntity.ok(ApiResponse.success(null));
    }
}
