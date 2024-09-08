package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZuoyefabuEntity;
import com.entity.view.ZuoyefabuView;

import com.service.ZuoyefabuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 作业发布
 * 后端接口
 * @author 
 * @email 
 
 */
@RestController
@RequestMapping("/zuoyefabu")
public class ZuoyefabuController {
    @Autowired
    private ZuoyefabuService zuoyefabuService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZuoyefabuEntity zuoyefabu, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshixinxi")) {
			zuoyefabu.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZuoyefabuEntity> ew = new EntityWrapper<ZuoyefabuEntity>();
    	PageUtils page = zuoyefabuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuoyefabu), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZuoyefabuEntity zuoyefabu, HttpServletRequest request){
        EntityWrapper<ZuoyefabuEntity> ew = new EntityWrapper<ZuoyefabuEntity>();
    	PageUtils page = zuoyefabuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuoyefabu), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZuoyefabuEntity zuoyefabu){
       	EntityWrapper<ZuoyefabuEntity> ew = new EntityWrapper<ZuoyefabuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zuoyefabu, "zuoyefabu")); 
        return R.ok().put("data", zuoyefabuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZuoyefabuEntity zuoyefabu){
        EntityWrapper< ZuoyefabuEntity> ew = new EntityWrapper< ZuoyefabuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zuoyefabu, "zuoyefabu")); 
		ZuoyefabuView zuoyefabuView =  zuoyefabuService.selectView(ew);
		return R.ok("查询作业发布成功").put("data", zuoyefabuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZuoyefabuEntity zuoyefabu = zuoyefabuService.selectById(id);
        return R.ok().put("data", zuoyefabu);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZuoyefabuEntity zuoyefabu = zuoyefabuService.selectById(id);
        return R.ok().put("data", zuoyefabu);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        ZuoyefabuEntity zuoyefabu = zuoyefabuService.selectById(id);
        if(type.equals("1")) {
        	zuoyefabu.setThumbsupnum(zuoyefabu.getThumbsupnum()+1);
        } else {
        	zuoyefabu.setCrazilynum(zuoyefabu.getCrazilynum()+1);
        }
        zuoyefabuService.updateById(zuoyefabu);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZuoyefabuEntity zuoyefabu, HttpServletRequest request){
    	zuoyefabu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zuoyefabu);

        zuoyefabuService.insert(zuoyefabu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody ZuoyefabuEntity zuoyefabu, HttpServletRequest request){
    	zuoyefabu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zuoyefabu);

        zuoyefabuService.insert(zuoyefabu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ZuoyefabuEntity zuoyefabu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zuoyefabu);
        zuoyefabuService.updateById(zuoyefabu);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zuoyefabuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ZuoyefabuEntity> wrapper = new EntityWrapper<ZuoyefabuEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshixinxi")) {
			wrapper.eq("gonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = zuoyefabuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	


}
