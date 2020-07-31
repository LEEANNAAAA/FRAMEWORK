package kr.ac.kopo.bbs;

import java.io.File;
import java.util.List;

public interface BbsService{
	
	List<BbsVo> selectBbsList();

	BbsVo selectBbs(int bbsNo);

	int insertBbs(BbsVo vo);

	int updateBbs(BbsVo vo);

	int deleteBbs(int bbsNo);

	AttachVo selectAttach(int attNo);

	File getAttachFile(AttachVo vo);

}