package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DingdanzhuizongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DingdanzhuizongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DingdanzhuizongView;


/**
 * 订单追踪
 *
 * @author 
 * @email 
 * @date 2022-04-01 12:56:25
 */
public interface DingdanzhuizongService extends IService<DingdanzhuizongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DingdanzhuizongVO> selectListVO(Wrapper<DingdanzhuizongEntity> wrapper);
   	
   	DingdanzhuizongVO selectVO(@Param("ew") Wrapper<DingdanzhuizongEntity> wrapper);
   	
   	List<DingdanzhuizongView> selectListView(Wrapper<DingdanzhuizongEntity> wrapper);
   	
   	DingdanzhuizongView selectView(@Param("ew") Wrapper<DingdanzhuizongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DingdanzhuizongEntity> wrapper);
   	

}

