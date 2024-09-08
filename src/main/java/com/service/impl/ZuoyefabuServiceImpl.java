package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZuoyefabuDao;
import com.entity.ZuoyefabuEntity;
import com.service.ZuoyefabuService;
import com.entity.vo.ZuoyefabuVO;
import com.entity.view.ZuoyefabuView;

@Service("zuoyefabuService")
public class ZuoyefabuServiceImpl extends ServiceImpl<ZuoyefabuDao, ZuoyefabuEntity> implements ZuoyefabuService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZuoyefabuEntity> page = this.selectPage(
                new Query<ZuoyefabuEntity>(params).getPage(),
                new EntityWrapper<ZuoyefabuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZuoyefabuEntity> wrapper) {
		  Page<ZuoyefabuView> page =new Query<ZuoyefabuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZuoyefabuVO> selectListVO(Wrapper<ZuoyefabuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZuoyefabuVO selectVO(Wrapper<ZuoyefabuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZuoyefabuView> selectListView(Wrapper<ZuoyefabuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZuoyefabuView selectView(Wrapper<ZuoyefabuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
