package com.dao;

import com.entity.ZaixianhuifuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZaixianhuifuVO;
import com.entity.view.ZaixianhuifuView;


/**
 * 在线回复
 * 
 * @author 
 * @email 
 * @date 2022-04-01 12:56:25
 */
public interface ZaixianhuifuDao extends BaseMapper<ZaixianhuifuEntity> {
	
	List<ZaixianhuifuVO> selectListVO(@Param("ew") Wrapper<ZaixianhuifuEntity> wrapper);
	
	ZaixianhuifuVO selectVO(@Param("ew") Wrapper<ZaixianhuifuEntity> wrapper);
	
	List<ZaixianhuifuView> selectListView(@Param("ew") Wrapper<ZaixianhuifuEntity> wrapper);

	List<ZaixianhuifuView> selectListView(Pagination page,@Param("ew") Wrapper<ZaixianhuifuEntity> wrapper);
	
	ZaixianhuifuView selectView(@Param("ew") Wrapper<ZaixianhuifuEntity> wrapper);
	

}
