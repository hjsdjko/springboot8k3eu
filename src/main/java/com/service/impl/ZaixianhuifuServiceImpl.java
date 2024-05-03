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


import com.dao.ZaixianhuifuDao;
import com.entity.ZaixianhuifuEntity;
import com.service.ZaixianhuifuService;
import com.entity.vo.ZaixianhuifuVO;
import com.entity.view.ZaixianhuifuView;

@Service("zaixianhuifuService")
public class ZaixianhuifuServiceImpl extends ServiceImpl<ZaixianhuifuDao, ZaixianhuifuEntity> implements ZaixianhuifuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZaixianhuifuEntity> page = this.selectPage(
                new Query<ZaixianhuifuEntity>(params).getPage(),
                new EntityWrapper<ZaixianhuifuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZaixianhuifuEntity> wrapper) {
		  Page<ZaixianhuifuView> page =new Query<ZaixianhuifuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZaixianhuifuVO> selectListVO(Wrapper<ZaixianhuifuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZaixianhuifuVO selectVO(Wrapper<ZaixianhuifuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZaixianhuifuView> selectListView(Wrapper<ZaixianhuifuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZaixianhuifuView selectView(Wrapper<ZaixianhuifuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
