package littleprince.member.fixture;

import littleprince.member.command.application.dto.request.SignupRequest;

public class SignupRequestFixture {

    public static SignupRequest validRequest() {
        return new SignupRequest("test@example.com", "1234", "1234");
    }

    public static SignupRequest passwordMismatchRequest() {
        return new SignupRequest("test@example.com", "1234", "5678");
    }

    public static SignupRequest duplicateEmailRequest() {
        return new SignupRequest("duplicate@example.com", "1234", "1234");
    }
}