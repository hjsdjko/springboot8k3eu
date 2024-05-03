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

import com.entity.ZaixianjiaoliuEntity;
import com.entity.view.ZaixianjiaoliuView;

import com.service.ZaixianjiaoliuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 在线交流
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-01 12:56:25
 */
@RestController
@RequestMapping("/zaixianjiaoliu")
public class ZaixianjiaoliuController {
    @Autowired
    private ZaixianjiaoliuService zaixianjiaoliuService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZaixianjiaoliuEntity zaixianjiaoliu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("maijia")) {
			zaixianjiaoliu.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			zaixianjiaoliu.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZaixianjiaoliuEntity> ew = new EntityWrapper<ZaixianjiaoliuEntity>();
		PageUtils page = zaixianjiaoliuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zaixianjiaoliu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZaixianjiaoliuEntity zaixianjiaoliu, 
		HttpServletRequest request){
        EntityWrapper<ZaixianjiaoliuEntity> ew = new EntityWrapper<ZaixianjiaoliuEntity>();
		PageUtils page = zaixianjiaoliuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zaixianjiaoliu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZaixianjiaoliuEntity zaixianjiaoliu){
       	EntityWrapper<ZaixianjiaoliuEntity> ew = new EntityWrapper<ZaixianjiaoliuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zaixianjiaoliu, "zaixianjiaoliu")); 
        return R.ok().put("data", zaixianjiaoliuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZaixianjiaoliuEntity zaixianjiaoliu){
        EntityWrapper< ZaixianjiaoliuEntity> ew = new EntityWrapper< ZaixianjiaoliuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zaixianjiaoliu, "zaixianjiaoliu")); 
		ZaixianjiaoliuView zaixianjiaoliuView =  zaixianjiaoliuService.selectView(ew);
		return R.ok("查询在线交流成功").put("data", zaixianjiaoliuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZaixianjiaoliuEntity zaixianjiaoliu = zaixianjiaoliuService.selectById(id);
        return R.ok().put("data", zaixianjiaoliu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZaixianjiaoliuEntity zaixianjiaoliu = zaixianjiaoliuService.selectById(id);
        return R.ok().put("data", zaixianjiaoliu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZaixianjiaoliuEntity zaixianjiaoliu, HttpServletRequest request){
    	zaixianjiaoliu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zaixianjiaoliu);
        zaixianjiaoliuService.insert(zaixianjiaoliu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZaixianjiaoliuEntity zaixianjiaoliu, HttpServletRequest request){
    	zaixianjiaoliu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zaixianjiaoliu);
        zaixianjiaoliuService.insert(zaixianjiaoliu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ZaixianjiaoliuEntity zaixianjiaoliu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zaixianjiaoliu);
        zaixianjiaoliuService.updateById(zaixianjiaoliu);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zaixianjiaoliuService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ZaixianjiaoliuEntity> wrapper = new EntityWrapper<ZaixianjiaoliuEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("maijia")) {
			wrapper.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = zaixianjiaoliuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
