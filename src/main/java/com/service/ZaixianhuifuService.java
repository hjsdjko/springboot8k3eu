package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZaixianhuifuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZaixianhuifuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZaixianhuifuView;


/**
 * 在线回复
 *
 * @author 
 * @email 
 * @date 2022-04-01 12:56:25
 */
public interface ZaixianhuifuService extends IService<ZaixianhuifuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZaixianhuifuVO> selectListVO(Wrapper<ZaixianhuifuEntity> wrapper);
   	
   	ZaixianhuifuVO selectVO(@Param("ew") Wrapper<ZaixianhuifuEntity> wrapper);
   	
   	List<ZaixianhuifuView> selectListView(Wrapper<ZaixianhuifuEntity> wrapper);
   	
   	ZaixianhuifuView selectView(@Param("ew") Wrapper<ZaixianhuifuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZaixianhuifuEntity> wrapper);
   	

}

