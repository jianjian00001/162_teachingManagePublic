package com.dao;

import com.entity.JiaoxuefankuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiaoxuefankuiVO;
import com.entity.view.JiaoxuefankuiView;


/**
 * 教学反馈
 * 
 * @author 
 * @email 
 
 */
public interface JiaoxuefankuiDao extends BaseMapper<JiaoxuefankuiEntity> {
	
	List<JiaoxuefankuiVO> selectListVO(@Param("ew") Wrapper<JiaoxuefankuiEntity> wrapper);
	
	JiaoxuefankuiVO selectVO(@Param("ew") Wrapper<JiaoxuefankuiEntity> wrapper);
	
	List<JiaoxuefankuiView> selectListView(@Param("ew") Wrapper<JiaoxuefankuiEntity> wrapper);

	List<JiaoxuefankuiView> selectListView(Pagination page,@Param("ew") Wrapper<JiaoxuefankuiEntity> wrapper);
	
	JiaoxuefankuiView selectView(@Param("ew") Wrapper<JiaoxuefankuiEntity> wrapper);
	
}
