package kr.ac.kopo.member;

import java.util.List;

import kr.ac.kopo.comm.PageInfo;
import kr.ac.kopo.comm.SearchInfo;

public interface MemberService {

	List<MemberVo> selectMemberList(SearchInfo info);

	MemberVo selectMember(String memId);

	int insertMember(MemberVo vo);

	int updateMember(MemberVo vo);

	int deleteMember(String memId);

	MemberVo selectLoginMember(MemberVo memberVo);

	int selectCount(SearchInfo info);

}