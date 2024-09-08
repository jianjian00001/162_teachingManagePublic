package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZuoyefabuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZuoyefabuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZuoyefabuView;


/**
 * 作业发布
 *
 * @author 
 * @email 
 
 */
public interface ZuoyefabuService extends IService<ZuoyefabuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZuoyefabuVO> selectListVO(Wrapper<ZuoyefabuEntity> wrapper);
   	
   	ZuoyefabuVO selectVO(@Param("ew") Wrapper<ZuoyefabuEntity> wrapper);
   	
   	List<ZuoyefabuView> selectListView(Wrapper<ZuoyefabuEntity> wrapper);
   	
   	ZuoyefabuView selectView(@Param("ew") Wrapper<ZuoyefabuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZuoyefabuEntity> wrapper);
   	
}

