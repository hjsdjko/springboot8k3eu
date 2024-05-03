package com.dao;

import com.entity.DingdanzhuizongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DingdanzhuizongVO;
import com.entity.view.DingdanzhuizongView;


/**
 * 订单追踪
 * 
 * @author 
 * @email 
 * @date 2022-04-01 12:56:25
 */
public interface DingdanzhuizongDao extends BaseMapper<DingdanzhuizongEntity> {
	
	List<DingdanzhuizongVO> selectListVO(@Param("ew") Wrapper<DingdanzhuizongEntity> wrapper);
	
	DingdanzhuizongVO selectVO(@Param("ew") Wrapper<DingdanzhuizongEntity> wrapper);
	
	List<DingdanzhuizongView> selectListView(@Param("ew") Wrapper<DingdanzhuizongEntity> wrapper);

	List<DingdanzhuizongView> selectListView(Pagination page,@Param("ew") Wrapper<DingdanzhuizongEntity> wrapper);
	
	DingdanzhuizongView selectView(@Param("ew") Wrapper<DingdanzhuizongEntity> wrapper);
	

}
