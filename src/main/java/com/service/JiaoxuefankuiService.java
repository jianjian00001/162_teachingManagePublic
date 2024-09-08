package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiaoxuefankuiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiaoxuefankuiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaoxuefankuiView;


/**
 * 教学反馈
 *
 * @author 
 * @email 
 
 */
public interface JiaoxuefankuiService extends IService<JiaoxuefankuiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaoxuefankuiVO> selectListVO(Wrapper<JiaoxuefankuiEntity> wrapper);
   	
   	JiaoxuefankuiVO selectVO(@Param("ew") Wrapper<JiaoxuefankuiEntity> wrapper);
   	
   	List<JiaoxuefankuiView> selectListView(Wrapper<JiaoxuefankuiEntity> wrapper);
   	
   	JiaoxuefankuiView selectView(@Param("ew") Wrapper<JiaoxuefankuiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaoxuefankuiEntity> wrapper);
   	
}

