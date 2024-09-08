package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusszuoyefabuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusszuoyefabuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusszuoyefabuView;


/**
 * 作业发布评论表
 *
 * @author 
 * @email 
 
 */
public interface DiscusszuoyefabuService extends IService<DiscusszuoyefabuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusszuoyefabuVO> selectListVO(Wrapper<DiscusszuoyefabuEntity> wrapper);
   	
   	DiscusszuoyefabuVO selectVO(@Param("ew") Wrapper<DiscusszuoyefabuEntity> wrapper);
   	
   	List<DiscusszuoyefabuView> selectListView(Wrapper<DiscusszuoyefabuEntity> wrapper);
   	
   	DiscusszuoyefabuView selectView(@Param("ew") Wrapper<DiscusszuoyefabuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusszuoyefabuEntity> wrapper);
   	
}

