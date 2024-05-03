package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DingdanzhuizongEntity;
import com.entity.view.DingdanzhuizongView;

import com.service.DingdanzhuizongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 订单追踪
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-01 12:56:25
 */
@RestController
@RequestMapping("/dingdanzhuizong")
public class DingdanzhuizongController {
    @Autowired
    private DingdanzhuizongService dingdanzhuizongService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DingdanzhuizongEntity dingdanzhuizong,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			dingdanzhuizong.setYonghuming((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("maijia")) {
			dingdanzhuizong.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DingdanzhuizongEntity> ew = new EntityWrapper<DingdanzhuizongEntity>();
		PageUtils page = dingdanzhuizongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdanzhuizong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DingdanzhuizongEntity dingdanzhuizong, 
		HttpServletRequest request){
        EntityWrapper<DingdanzhuizongEntity> ew = new EntityWrapper<DingdanzhuizongEntity>();
		PageUtils page = dingdanzhuizongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdanzhuizong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DingdanzhuizongEntity dingdanzhuizong){
       	EntityWrapper<DingdanzhuizongEntity> ew = new EntityWrapper<DingdanzhuizongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dingdanzhuizong, "dingdanzhuizong")); 
        return R.ok().put("data", dingdanzhuizongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DingdanzhuizongEntity dingdanzhuizong){
        EntityWrapper< DingdanzhuizongEntity> ew = new EntityWrapper< DingdanzhuizongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dingdanzhuizong, "dingdanzhuizong")); 
		DingdanzhuizongView dingdanzhuizongView =  dingdanzhuizongService.selectView(ew);
		return R.ok("查询订单追踪成功").put("data", dingdanzhuizongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DingdanzhuizongEntity dingdanzhuizong = dingdanzhuizongService.selectById(id);
        return R.ok().put("data", dingdanzhuizong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DingdanzhuizongEntity dingdanzhuizong = dingdanzhuizongService.selectById(id);
        return R.ok().put("data", dingdanzhuizong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DingdanzhuizongEntity dingdanzhuizong, HttpServletRequest request){
    	dingdanzhuizong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dingdanzhuizong);
        dingdanzhuizongService.insert(dingdanzhuizong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DingdanzhuizongEntity dingdanzhuizong, HttpServletRequest request){
    	dingdanzhuizong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dingdanzhuizong);
        dingdanzhuizongService.insert(dingdanzhuizong);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DingdanzhuizongEntity dingdanzhuizong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dingdanzhuizong);
        dingdanzhuizongService.updateById(dingdanzhuizong);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dingdanzhuizongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DingdanzhuizongEntity> wrapper = new EntityWrapper<DingdanzhuizongEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("maijia")) {
			wrapper.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = dingdanzhuizongService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
