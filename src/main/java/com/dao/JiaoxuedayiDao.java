package com.dao;

import com.entity.JiaoxuedayiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiaoxuedayiVO;
import com.entity.view.JiaoxuedayiView;


/**
 * 教学答疑
 * 
 * @author 
 * @email 
 
 */
public interface JiaoxuedayiDao extends BaseMapper<JiaoxuedayiEntity> {
	
	List<JiaoxuedayiVO> selectListVO(@Param("ew") Wrapper<JiaoxuedayiEntity> wrapper);
	
	JiaoxuedayiVO selectVO(@Param("ew") Wrapper<JiaoxuedayiEntity> wrapper);
	
	List<JiaoxuedayiView> selectListView(@Param("ew") Wrapper<JiaoxuedayiEntity> wrapper);

	List<JiaoxuedayiView> selectListView(Pagination page,@Param("ew") Wrapper<JiaoxuedayiEntity> wrapper);
	
	JiaoxuedayiView selectView(@Param("ew") Wrapper<JiaoxuedayiEntity> wrapper);
	
}
