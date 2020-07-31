package kr.ac.kopo.reply;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyDao {
	public int insert(ReplyVo vo);
	public List<ReplyVo> selectList(int bbsNo); //게시글 번호를 주면서 관련 댓글리스트를 가져와라
	
}
