package kr.ac.kopo.member;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

//이 객체를 서비스 역할을 하는 객체로서 memberService 라는 이름으로 스프링에 등록
@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	//3계층을 만들어야 하므로 서블릿은 서비스를 쓰고, 서비스가 dao를 사용하게 됨. dao는 daobatis를 사용
	@Resource(name="memberDao")
	private MemberDao memberDao;
	
////싱글톤(Singleton)패턴 : 애플리케이션 전체에서 객체(인스턴스)를 1개만 만들어서(new) 여러곳에서 함께 사용
//	private MemberServiceImpl() { }	//외부에서 인스턴스 생성 금지
//	private static MemberService memberService = new MemberServiceImpl();	//하나 만들고
//	public static MemberService getInstance() {	//누가 요청하면 return값으로 줌
//		return memberService;
//	}
	
	@Override
	public List<MemberVo> selectMemberList() {
//		List<MemberVo> list = memberDao.selectMemberList();
//		return list; //두 줄을 한줄로!
		return memberDao.selectMemberList();
	}

	@Override
	public MemberVo selectMember(String memId) {
		return memberDao.selectMember(memId);
	}

	@Override
	public int insertMember(MemberVo vo) {
		return memberDao.insertMember(vo);
	}

	@Override
	public int updateMember(MemberVo vo) {
		return memberDao.updateMember(vo);
	}

	@Override
	public int deleteMember(String memId) {
		return memberDao.deleteMember(memId);
	}

	@Override
	public MemberVo selectLoginMember(MemberVo memberVo) {
		return memberDao.selectLoginMember(memberVo);
	}
	
}
