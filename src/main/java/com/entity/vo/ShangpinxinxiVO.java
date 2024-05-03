package com.entity.vo;

import com.entity.ShangpinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 商品信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-04-01 12:56:25
 */
public class ShangpinxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品类型
	 */
	
	private String shangpinleixing;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 价格
	 */
	
	private Integer jiage;
		
	/**
	 * 数量
	 */
	
	private Integer shuliang;
		
	/**
	 * 预计时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date yujishijian;
		
	/**
	 * 商品详情
	 */
	
	private String shangpinxiangqing;
		
	/**
	 * 账号
	 */
	
	private String zhanghao;
		
	/**
	 * 卖家姓名
	 */
	
	private String maijiaxingming;
		
	/**
	 * 电话
	 */
	
	private String dianhua;
				
	
	/**
	 * 设置：商品类型
	 */
	 
	public void setShangpinleixing(String shangpinleixing) {
		this.shangpinleixing = shangpinleixing;
	}
	
	/**
	 * 获取：商品类型
	 */
	public String getShangpinleixing() {
		return shangpinleixing;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：价格
	 */
	 
	public void setJiage(Integer jiage) {
		this.jiage = jiage;
	}
	
	/**
	 * 获取：价格
	 */
	public Integer getJiage() {
		return jiage;
	}
				
	
	/**
	 * 设置：数量
	 */
	 
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	
	/**
	 * 获取：数量
	 */
	public Integer getShuliang() {
		return shuliang;
	}
				
	
	/**
	 * 设置：预计时间
	 */
	 
	public void setYujishijian(Date yujishijian) {
		this.yujishijian = yujishijian;
	}
	
	/**
	 * 获取：预计时间
	 */
	public Date getYujishijian() {
		return yujishijian;
	}
				
	
	/**
	 * 设置：商品详情
	 */
	 
	public void setShangpinxiangqing(String shangpinxiangqing) {
		this.shangpinxiangqing = shangpinxiangqing;
	}
	
	/**
	 * 获取：商品详情
	 */
	public String getShangpinxiangqing() {
		return shangpinxiangqing;
	}
				
	
	/**
	 * 设置：账号
	 */
	 
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
				
	
	/**
	 * 设置：卖家姓名
	 */
	 
	public void setMaijiaxingming(String maijiaxingming) {
		this.maijiaxingming = maijiaxingming;
	}
	
	/**
	 * 获取：卖家姓名
	 */
	public String getMaijiaxingming() {
		return maijiaxingming;
	}
				
	
	/**
	 * 设置：电话
	 */
	 
	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}
	
	/**
	 * 获取：电话
	 */
	public String getDianhua() {
		return dianhua;
	}
			
}
