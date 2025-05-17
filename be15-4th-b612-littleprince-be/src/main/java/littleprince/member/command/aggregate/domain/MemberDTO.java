package littleprince.member.command.aggregate.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private Long memberId;
    private String email;
    private String password;
    private String isDeleted;
    private Integer exp;
    private Integer level;
    private String planetName;
    private String isNotificationEnabled;
    private String isBgmEnabled;
}