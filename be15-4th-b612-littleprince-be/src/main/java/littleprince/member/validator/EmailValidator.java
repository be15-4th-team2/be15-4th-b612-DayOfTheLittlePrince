package littleprince.member.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import littleprince.member.annotation.ValidEmail;

import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    /* OWASP 참고
     * https://owasp.org/www-community/OWASP_Validation_Regex_Repository */
    private static final Pattern EMAIL_REGEX =
            Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$");

    /* 검증 패턴
     * 이메일 시작 알파벳,숫자, _+&*- 중 하나 이상
     * 아이디가 .으로 구분 될 수도 있음
     * @ 반드시 포함
     * . 1개 이상 포함 (naver.com)
     * com 부분 2글자 이상 */
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return email != null && EMAIL_REGEX.matcher(email).matches();
    }
}
