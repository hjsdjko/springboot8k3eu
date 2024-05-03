package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZaixianjiaoliuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZaixianjiaoliuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZaixianjiaoliuView;


/**
 * 在线交流
 *
 * @author 
 * @email 
 * @date 2022-04-01 12:56:25
 */
public interface ZaixianjiaoliuService extends IService<ZaixianjiaoliuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZaixianjiaoliuVO> selectListVO(Wrapper<ZaixianjiaoliuEntity> wrapper);
   	
   	ZaixianjiaoliuVO selectVO(@Param("ew") Wrapper<ZaixianjiaoliuEntity> wrapper);
   	
   	List<ZaixianjiaoliuView> selectListView(Wrapper<ZaixianjiaoliuEntity> wrapper);
   	
   	ZaixianjiaoliuView selectView(@Param("ew") Wrapper<ZaixianjiaoliuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZaixianjiaoliuEntity> wrapper);
   	

}

