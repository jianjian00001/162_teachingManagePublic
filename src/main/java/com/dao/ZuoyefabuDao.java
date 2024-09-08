package com.dao;

import com.entity.ZuoyefabuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZuoyefabuVO;
import com.entity.view.ZuoyefabuView;


/**
 * 作业发布
 * 
 * @author 
 * @email 
 
 */
public interface ZuoyefabuDao extends BaseMapper<ZuoyefabuEntity> {
	
	List<ZuoyefabuVO> selectListVO(@Param("ew") Wrapper<ZuoyefabuEntity> wrapper);
	
	ZuoyefabuVO selectVO(@Param("ew") Wrapper<ZuoyefabuEntity> wrapper);
	
	List<ZuoyefabuView> selectListView(@Param("ew") Wrapper<ZuoyefabuEntity> wrapper);

	List<ZuoyefabuView> selectListView(Pagination page,@Param("ew") Wrapper<ZuoyefabuEntity> wrapper);
	
	ZuoyefabuView selectView(@Param("ew") Wrapper<ZuoyefabuEntity> wrapper);
	
}
