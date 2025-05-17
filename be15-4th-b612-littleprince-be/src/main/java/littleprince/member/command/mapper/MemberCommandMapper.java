package littleprince.member.command.mapper;

import littleprince.member.command.aggregate.domain.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberCommandMapper {
    void insertMember(MemberDTO member);
}
