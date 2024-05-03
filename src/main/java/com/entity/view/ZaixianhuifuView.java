package com.entity.view;

import com.entity.ZaixianhuifuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 在线回复
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-01 12:56:25
 */
@TableName("zaixianhuifu")
public class ZaixianhuifuView  extends ZaixianhuifuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZaixianhuifuView(){
	}
 
 	public ZaixianhuifuView(ZaixianhuifuEntity zaixianhuifuEntity){
 	try {
			BeanUtils.copyProperties(this, zaixianhuifuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
