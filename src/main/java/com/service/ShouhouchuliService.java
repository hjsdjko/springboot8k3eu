package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShouhouchuliEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShouhouchuliVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShouhouchuliView;


/**
 * 售后处理
 *
 * @author 
 * @email 
 * @date 2022-04-01 12:56:25
 */
public interface ShouhouchuliService extends IService<ShouhouchuliEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShouhouchuliVO> selectListVO(Wrapper<ShouhouchuliEntity> wrapper);
   	
   	ShouhouchuliVO selectVO(@Param("ew") Wrapper<ShouhouchuliEntity> wrapper);
   	
   	List<ShouhouchuliView> selectListView(Wrapper<ShouhouchuliEntity> wrapper);
   	
   	ShouhouchuliView selectView(@Param("ew") Wrapper<ShouhouchuliEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShouhouchuliEntity> wrapper);
   	

}

