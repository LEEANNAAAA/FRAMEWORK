package kr.ac.kopo.bbs;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BbsDao {
	
	List<BbsVo> selectBbsList();

	BbsVo selectBbs(int bbsNo);

	int insertBbs(BbsVo vo);

	int updateBbs(BbsVo vo);

	int deleteBbs(int bbsNo);

}