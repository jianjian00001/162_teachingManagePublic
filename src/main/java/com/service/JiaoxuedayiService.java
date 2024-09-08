package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiaoxuedayiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiaoxuedayiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaoxuedayiView;


/**
 * 教学答疑
 *
 * @author 
 * @email 
 
 */
public interface JiaoxuedayiService extends IService<JiaoxuedayiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaoxuedayiVO> selectListVO(Wrapper<JiaoxuedayiEntity> wrapper);
   	
   	JiaoxuedayiVO selectVO(@Param("ew") Wrapper<JiaoxuedayiEntity> wrapper);
   	
   	List<JiaoxuedayiView> selectListView(Wrapper<JiaoxuedayiEntity> wrapper);
   	
   	JiaoxuedayiView selectView(@Param("ew") Wrapper<JiaoxuedayiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaoxuedayiEntity> wrapper);
   	
}

