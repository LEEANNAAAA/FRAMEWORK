package kr.ac.kopo.bbs;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("bbsService")
public class BbsServiceImpl implements BbsService{
	
	@Resource
	private BbsDao bbsDao;

	@Override
	public List<BbsVo> selectBbsList() {
		return bbsDao.selectBbsList();
	}

	@Override
	public BbsVo selectBbs(int bbsNo) {
		return bbsDao.selectBbs(bbsNo);
	}

	@Override
	public int insertBbs(BbsVo vo) {
		return bbsDao.insertBbs(vo);
	}

	@Override
	public int updateBbs(BbsVo vo) {
		return bbsDao.updateBbs(vo);
	}

	@Override
	public int deleteBbs(int bbsNo) {
		return bbsDao.deleteBbs(bbsNo);
	}

}
