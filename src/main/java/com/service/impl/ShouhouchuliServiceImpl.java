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


import com.dao.ShouhouchuliDao;
import com.entity.ShouhouchuliEntity;
import com.service.ShouhouchuliService;
import com.entity.vo.ShouhouchuliVO;
import com.entity.view.ShouhouchuliView;

@Service("shouhouchuliService")
public class ShouhouchuliServiceImpl extends ServiceImpl<ShouhouchuliDao, ShouhouchuliEntity> implements ShouhouchuliService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShouhouchuliEntity> page = this.selectPage(
                new Query<ShouhouchuliEntity>(params).getPage(),
                new EntityWrapper<ShouhouchuliEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShouhouchuliEntity> wrapper) {
		  Page<ShouhouchuliView> page =new Query<ShouhouchuliView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShouhouchuliVO> selectListVO(Wrapper<ShouhouchuliEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShouhouchuliVO selectVO(Wrapper<ShouhouchuliEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShouhouchuliView> selectListView(Wrapper<ShouhouchuliEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShouhouchuliView selectView(Wrapper<ShouhouchuliEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
