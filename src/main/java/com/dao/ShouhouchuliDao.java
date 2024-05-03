package com.dao;

import com.entity.ShouhouchuliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShouhouchuliVO;
import com.entity.view.ShouhouchuliView;


/**
 * 售后处理
 * 
 * @author 
 * @email 
 * @date 2022-04-01 12:56:25
 */
public interface ShouhouchuliDao extends BaseMapper<ShouhouchuliEntity> {
	
	List<ShouhouchuliVO> selectListVO(@Param("ew") Wrapper<ShouhouchuliEntity> wrapper);
	
	ShouhouchuliVO selectVO(@Param("ew") Wrapper<ShouhouchuliEntity> wrapper);
	
	List<ShouhouchuliView> selectListView(@Param("ew") Wrapper<ShouhouchuliEntity> wrapper);

	List<ShouhouchuliView> selectListView(Pagination page,@Param("ew") Wrapper<ShouhouchuliEntity> wrapper);
	
	ShouhouchuliView selectView(@Param("ew") Wrapper<ShouhouchuliEntity> wrapper);
	

}
