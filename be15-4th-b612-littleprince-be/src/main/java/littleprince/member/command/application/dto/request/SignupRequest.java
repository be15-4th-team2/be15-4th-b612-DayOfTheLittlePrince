package littleprince.member.command.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import littleprince.member.annotation.ValidEmail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@AllArgsConstructor
@Builder
public class SignupRequest {

    @ValidEmail
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String confirmPassword;
}
