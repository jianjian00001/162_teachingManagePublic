package com.dao;

import com.entity.DiscusszuoyefabuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusszuoyefabuVO;
import com.entity.view.DiscusszuoyefabuView;


/**
 * 作业发布评论表
 * 
 * @author 
 * @email 
 
 */
public interface DiscusszuoyefabuDao extends BaseMapper<DiscusszuoyefabuEntity> {
	
	List<DiscusszuoyefabuVO> selectListVO(@Param("ew") Wrapper<DiscusszuoyefabuEntity> wrapper);
	
	DiscusszuoyefabuVO selectVO(@Param("ew") Wrapper<DiscusszuoyefabuEntity> wrapper);
	
	List<DiscusszuoyefabuView> selectListView(@Param("ew") Wrapper<DiscusszuoyefabuEntity> wrapper);

	List<DiscusszuoyefabuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszuoyefabuEntity> wrapper);
	
	DiscusszuoyefabuView selectView(@Param("ew") Wrapper<DiscusszuoyefabuEntity> wrapper);
	
}
