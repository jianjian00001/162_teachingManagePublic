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

import com.entity.JiaoxueziyuanEntity;
import com.entity.view.JiaoxueziyuanView;

import com.service.JiaoxueziyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 教学资源
 * 后端接口
 * @author 
 * @email 
 
 */
@RestController
@RequestMapping("/jiaoxueziyuan")
public class JiaoxueziyuanController {
    @Autowired
    private JiaoxueziyuanService jiaoxueziyuanService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaoxueziyuanEntity jiaoxueziyuan, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshixinxi")) {
			jiaoxueziyuan.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiaoxueziyuanEntity> ew = new EntityWrapper<JiaoxueziyuanEntity>();
    	PageUtils page = jiaoxueziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaoxueziyuan), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaoxueziyuanEntity jiaoxueziyuan, HttpServletRequest request){
        EntityWrapper<JiaoxueziyuanEntity> ew = new EntityWrapper<JiaoxueziyuanEntity>();
    	PageUtils page = jiaoxueziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaoxueziyuan), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaoxueziyuanEntity jiaoxueziyuan){
       	EntityWrapper<JiaoxueziyuanEntity> ew = new EntityWrapper<JiaoxueziyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaoxueziyuan, "jiaoxueziyuan")); 
        return R.ok().put("data", jiaoxueziyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaoxueziyuanEntity jiaoxueziyuan){
        EntityWrapper< JiaoxueziyuanEntity> ew = new EntityWrapper< JiaoxueziyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaoxueziyuan, "jiaoxueziyuan")); 
		JiaoxueziyuanView jiaoxueziyuanView =  jiaoxueziyuanService.selectView(ew);
		return R.ok("查询教学资源成功").put("data", jiaoxueziyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaoxueziyuanEntity jiaoxueziyuan = jiaoxueziyuanService.selectById(id);
		jiaoxueziyuan.setClicknum(jiaoxueziyuan.getClicknum()+1);
		jiaoxueziyuan.setClicktime(new Date());
		jiaoxueziyuanService.updateById(jiaoxueziyuan);
        return R.ok().put("data", jiaoxueziyuan);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaoxueziyuanEntity jiaoxueziyuan = jiaoxueziyuanService.selectById(id);
		jiaoxueziyuan.setClicknum(jiaoxueziyuan.getClicknum()+1);
		jiaoxueziyuan.setClicktime(new Date());
		jiaoxueziyuanService.updateById(jiaoxueziyuan);
        return R.ok().put("data", jiaoxueziyuan);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        JiaoxueziyuanEntity jiaoxueziyuan = jiaoxueziyuanService.selectById(id);
        if(type.equals("1")) {
        	jiaoxueziyuan.setThumbsupnum(jiaoxueziyuan.getThumbsupnum()+1);
        } else {
        	jiaoxueziyuan.setCrazilynum(jiaoxueziyuan.getCrazilynum()+1);
        }
        jiaoxueziyuanService.updateById(jiaoxueziyuan);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaoxueziyuanEntity jiaoxueziyuan, HttpServletRequest request){
    	jiaoxueziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaoxueziyuan);

        jiaoxueziyuanService.insert(jiaoxueziyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody JiaoxueziyuanEntity jiaoxueziyuan, HttpServletRequest request){
    	jiaoxueziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaoxueziyuan);

        jiaoxueziyuanService.insert(jiaoxueziyuan);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody JiaoxueziyuanEntity jiaoxueziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaoxueziyuan);
        jiaoxueziyuanService.updateById(jiaoxueziyuan);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaoxueziyuanService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<JiaoxueziyuanEntity> wrapper = new EntityWrapper<JiaoxueziyuanEntity>();
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

		int count = jiaoxueziyuanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,JiaoxueziyuanEntity jiaoxueziyuan, HttpServletRequest request,String pre){
        EntityWrapper<JiaoxueziyuanEntity> ew = new EntityWrapper<JiaoxueziyuanEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = jiaoxueziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaoxueziyuan), params), params));
        return R.ok().put("data", page);
    }


}
