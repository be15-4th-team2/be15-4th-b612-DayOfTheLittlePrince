package littleprince.member.query.dto;

import lombok.Data;

@Data
public class FindMemberDTO {
    private Long memberId;
    private String email;
}
