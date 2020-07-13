package kr.ac.kopo.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

//<mybatis-spring:scan>에 의해서 자동으로 마이바티스 구현체를 생성해야하는
//인터페이스임을 표시하기 위해서 @Mapper 애노테이션 사용
@Mapper
public interface MemberDao {

	List<MemberVo> selectMemberList();

	MemberVo selectMember(String memId);

	int insertMember(MemberVo vo);

	int updateMember(MemberVo vo);

	int deleteMember(String memId);

	MemberVo selectLoginMember(MemberVo memberVo);

}