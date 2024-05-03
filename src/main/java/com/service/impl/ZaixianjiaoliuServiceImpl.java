package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZaixianjiaoliuDao;
import com.entity.ZaixianjiaoliuEntity;
import com.service.ZaixianjiaoliuService;
import com.entity.vo.ZaixianjiaoliuVO;
import com.entity.view.ZaixianjiaoliuView;

@Service("zaixianjiaoliuService")
public class ZaixianjiaoliuServiceImpl extends ServiceImpl<ZaixianjiaoliuDao, ZaixianjiaoliuEntity> implements ZaixianjiaoliuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZaixianjiaoliuEntity> page = this.selectPage(
                new Query<ZaixianjiaoliuEntity>(params).getPage(),
                new EntityWrapper<ZaixianjiaoliuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZaixianjiaoliuEntity> wrapper) {
		  Page<ZaixianjiaoliuView> page =new Query<ZaixianjiaoliuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZaixianjiaoliuVO> selectListVO(Wrapper<ZaixianjiaoliuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZaixianjiaoliuVO selectVO(Wrapper<ZaixianjiaoliuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZaixianjiaoliuView> selectListView(Wrapper<ZaixianjiaoliuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZaixianjiaoliuView selectView(Wrapper<ZaixianjiaoliuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
