package kr.ac.kopo.bbs;

import java.util.List;

public interface BbsService{
	
	List<BbsVo> selectBbsList();

	BbsVo selectBbs(int bbsNo);

	int insertBbs(BbsVo vo);

	int updateBbs(BbsVo vo);

	int deleteBbs(int bbsNo);

}