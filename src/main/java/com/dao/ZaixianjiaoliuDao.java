package com.dao;

import com.entity.ZaixianjiaoliuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZaixianjiaoliuVO;
import com.entity.view.ZaixianjiaoliuView;


/**
 * 在线交流
 * 
 * @author 
 * @email 
 * @date 2022-04-01 12:56:25
 */
public interface ZaixianjiaoliuDao extends BaseMapper<ZaixianjiaoliuEntity> {
	
	List<ZaixianjiaoliuVO> selectListVO(@Param("ew") Wrapper<ZaixianjiaoliuEntity> wrapper);
	
	ZaixianjiaoliuVO selectVO(@Param("ew") Wrapper<ZaixianjiaoliuEntity> wrapper);
	
	List<ZaixianjiaoliuView> selectListView(@Param("ew") Wrapper<ZaixianjiaoliuEntity> wrapper);

	List<ZaixianjiaoliuView> selectListView(Pagination page,@Param("ew") Wrapper<ZaixianjiaoliuEntity> wrapper);
	
	ZaixianjiaoliuView selectView(@Param("ew") Wrapper<ZaixianjiaoliuEntity> wrapper);
	

}
