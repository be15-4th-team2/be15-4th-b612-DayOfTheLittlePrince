package littleprince.member.exception;

import littleprince.common.exception.ErrorCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public enum MemberErrorCode implements ErrorCode {
    // member 오류
    /* 각 도메인마다 ERROR CODE 작성 */
    INVALID_LOGIN_REQUEST("10001", "아이디 또는 비밀번호가 잘못되었습니다.", HttpStatus.UNAUTHORIZED),
    DUPLICATE_EMAIL_EXISTS("10005", "이미 가입된 이메일입니다.", HttpStatus.BAD_REQUEST),
    PASSWORD_MISMATCH("10013","비밀번호가 동일하지 않습니다", HttpStatus.BAD_REQUEST);

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;
}