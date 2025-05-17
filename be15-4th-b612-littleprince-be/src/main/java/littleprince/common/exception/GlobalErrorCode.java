package littleprince.common.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public enum GlobalErrorCode implements ErrorCode{

    // 그 외 기타 오류
    VALIDATION_ERROR("50000", "입력 값 검증 오류입니다.", HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER_ERROR("50001", "내부 서버 오류 입니다.", HttpStatus.INTERNAL_SERVER_ERROR),
    UNAUTHORIZED_REQUEST("50002", "유효하지 않은 요청입니다.", HttpStatus.UNAUTHORIZED),
    ACCESS_TOKEN_EXPIRED("11001", "Access Token이 만료되었습니다.", HttpStatus.UNAUTHORIZED),   // 401
    REFRESH_TOKEN_EXPIRED("11002", "Refresh Token이 만료되었습니다.", HttpStatus.UNAUTHORIZED), // 401
    INVALID_TOKEN("11003", "토큰이 유효하지 않습니다.", HttpStatus.BAD_REQUEST),
    ACCESS_DENIED("10003", "해당 페이지에 대한 조회 권한이 없습니다.", HttpStatus.FORBIDDEN); // 400

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;
}