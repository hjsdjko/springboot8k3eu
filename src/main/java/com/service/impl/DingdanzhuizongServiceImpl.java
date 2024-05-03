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


import com.dao.DingdanzhuizongDao;
import com.entity.DingdanzhuizongEntity;
import com.service.DingdanzhuizongService;
import com.entity.vo.DingdanzhuizongVO;
import com.entity.view.DingdanzhuizongView;

@Service("dingdanzhuizongService")
public class DingdanzhuizongServiceImpl extends ServiceImpl<DingdanzhuizongDao, DingdanzhuizongEntity> implements DingdanzhuizongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DingdanzhuizongEntity> page = this.selectPage(
                new Query<DingdanzhuizongEntity>(params).getPage(),
                new EntityWrapper<DingdanzhuizongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DingdanzhuizongEntity> wrapper) {
		  Page<DingdanzhuizongView> page =new Query<DingdanzhuizongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DingdanzhuizongVO> selectListVO(Wrapper<DingdanzhuizongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DingdanzhuizongVO selectVO(Wrapper<DingdanzhuizongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DingdanzhuizongView> selectListView(Wrapper<DingdanzhuizongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DingdanzhuizongView selectView(Wrapper<DingdanzhuizongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
