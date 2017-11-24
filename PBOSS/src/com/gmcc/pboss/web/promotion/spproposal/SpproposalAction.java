/**
 * auto-generated code
 * Mon Sep 14 14:51:11 CST 2009
 */
 package com.gmcc.pboss.web.promotion.spproposal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.promotion.daemon.DaemonDBParam;
import com.gmcc.pboss.business.promotion.daemon.DaemonVO;
import com.gmcc.pboss.business.promotion.spproposal.SpproposalDBParam;
import com.gmcc.pboss.business.promotion.spproposal.SpproposalVO;
import com.gmcc.pboss.control.promotion.daemon.Daemon;
import com.gmcc.pboss.control.promotion.daemon.DaemonBO;
import com.gmcc.pboss.control.promotion.spproposal.Spproposal;
import com.gmcc.pboss.control.promotion.spproposal.SpproposalBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.AAUtilsForStruts2;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: SpproposalAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class SpproposalAction extends BaseAction{
	
	private final static String REWARD = "0"; //酬金
	private final static String ORDER = "1"; //订货量
	private final static String BIND = "2"; //绑定搭售
	private final static String GIVEBEFORE = "3"; //赠送(事前)
	private final static String GIVEAFTER = "4"; //赠送(事后)
	
	private final static String FORWEEK = "0"; //按周
	private final static String FORDAY = "1"; //按天
	
	public SpproposalAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new SpproposalForm());
		this.setParam(new SpproposalWebParam());

        //指定VO类
        setClsVO(SpproposalVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"pid"};
		this.setClsControl(Spproposal.class);
		this.setClsQueryParam(SpproposalDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doList() throws Exception {
		// TODO Auto-generated method stub

		SpproposalDBParam params = (SpproposalDBParam) getParam();
		if (StringUtils.isEmpty(params.get_desc())
				&& StringUtils.isEmpty(params.get_orderby())) {
			params.set_orderby("pid");
			params.set_desc("1");
		}
		if (params.get_de_pstarttime() == null
				|| params.get_de_pstarttime().equals("")) {
			super.doList();
		} else {
			SpproposalBO bo = (SpproposalBO) BOFactory.build(
					SpproposalBO.class, getDBAccessUser());
			params.set_dnm_pstarttime(params.get_de_pstarttime());
			params.set_dnl_pendtime(params.get_de_pstarttime());
			params.set_de_pstarttime(null);
			DataPackage dp = bo.doQuery(params);
			this.setDp(dp);
		}
		DataPackage dp = getDp();
		Date date = new Date();
		for (Iterator itt = dp.getDatas().iterator(); itt.hasNext();) {
			SpproposalVO vo = (SpproposalVO) itt.next();
			if (date.before(vo.getPstarttime())) {
				vo.setIsDeletable("true");
			} else {
				vo.setIsDeletable("false");
			}
		}
		return WEB_RESULT_LIST;
	}
	
	public String doNew() throws Exception {
		super.doNew();
		SpproposalForm form = (SpproposalForm)getForm();
		form.setNowDate(new Date());
		form.setPfrtmode("0");
		return WEB_RESULT_CONTENT;
	}
	
	@Override
	public String doEdit() throws Exception {
		// TODO Auto-generated method stub
		super.doEdit();
		SpproposalForm form = (SpproposalForm)getForm();
		form.setNowDate(new Date());
		if(StringUtils.isEmpty(ServletActionContext.getRequest().getParameter("VIEW"))){
			Date date = new Date();
			if(date.before(form.getPstarttime())){
				setCMD(WEB_CMD_EDIT);
			}else{
				setCMD(WEB_CMD_SAVE);
			}
		}else{
			setCMD(WEB_CMD_SAVE);
		}
		
		
		if(ORDER.equals(form.getPtype())){ //选择订货量保存完之后的展现
			Map map = new LinkedMap(); //记录日期
			Calendar startC = Calendar.getInstance();
			Calendar endC = Calendar.getInstance();
			startC.setTime(form.getPstarttime());
			endC.setTime(form.getPendtime());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			while(!startC.after(endC)){
				map.put(sdf.format(startC.getTime()), sdf.format(startC.getTime()));
				startC.add(Calendar.DATE, 1);
			}
			form.setForMode("1");
			form.setDayMap(map);
			Daemon daemon = (Daemon)BOFactory.build(DaemonBO.class, getDBAccessUser());
			DaemonDBParam param = new DaemonDBParam();
			param.setQueryAll(true);
			param.set_se_params(form.getPid()+",");
			DataPackage dp = daemon.doQuery(param);
			if(dp.getDatas().size() != 0){
				String[] forDays = new String[dp.getDatas().size()];
				for(int i=0;i<dp.getDatas().size();i++){
					DaemonVO daemonvo = (DaemonVO)dp.getDatas().get(i);
					forDays[i]=sdf.format(daemonvo.getStartingdate());
				}
				form.setForDays(forDays);
			}
		}
		return WEB_RESULT_CONTENT;
	}
	
	@Override
	public String doSave() throws Exception {
		// TODO Auto-generated method stub
		try{
			SpproposalForm form = (SpproposalForm)getForm();
			SpproposalVO vo = new SpproposalVO();
			BeanUtils.copyProperties(vo, form);
			List<String> saveDays = new ArrayList<String>();
			
			
			Map map = new LinkedMap(); //记录日期
			if(this.ORDER.equals(form.getPtype())){ //如果是订货量
				if(FORWEEK.equals(form.getForMode())){//如果是按周保存的话要进行取值
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					List weekdays = Arrays.asList(form.getForWeeks());
					Calendar startC = Calendar.getInstance();
					Calendar endC = Calendar.getInstance();
					startC.setTime(form.getPstarttime());
					endC.setTime(form.getPendtime());
					while(!startC.after(endC)){
						String weekday = new Integer(startC.get(Calendar.DAY_OF_WEEK)).toString();
						if(weekdays.contains(weekday)){
							saveDays.add(sdf.format(startC.getTime()));
						}
						map.put(sdf.format(startC.getTime()), sdf.format(startC.getTime()));
						startC.add(Calendar.DATE, 1);
					}
					if(saveDays.size() == 0){
						throw new BusinessException("开始时间跟结束时间没有跟定期模式(按周)匹配起来!");
					}
				}else{
					Calendar startC = Calendar.getInstance();
					Calendar endC = Calendar.getInstance();
					startC.setTime(form.getPstarttime());
					endC.setTime(form.getPendtime());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					while(!startC.after(endC)){
						map.put(sdf.format(startC.getTime()), sdf.format(startC.getTime()));
						startC.add(Calendar.DATE, 1);
					}
					saveDays = Arrays.asList(form.getForDays());
				}
			}
			Spproposal spproposal = (Spproposal)BOFactory.build(SpproposalBO.class, getDBAccessUser());
			
			if(super.getCMD().equals(super.WEB_CMD_NEW)){
				spproposal.doBatchCreate(vo, saveDays);
			}else if(super.getCMD().equals(super.WEB_CMD_EDIT)){
				spproposal.doBatchEdit(vo, saveDays);
			}
			
			if(ORDER.equals(form.getPtype())){
				//选择订货量保存完之后的展现
				String[] forDays = new String[saveDays.size()];
				int i = 0;
				for(String day : saveDays){
					forDays[i++] = day;
				}
				form.setForMode(FORDAY);
				form.setDayMap(map);
				form.setForDays(forDays);
			}
			setCMD(WEB_CMD_SAVE);
			setActionMessage("保存成功!");
			return this.WEB_RESULT_CONTENT;
		}catch (Exception e) {
			// TODO: handle exception
			setActionMessage(e.getMessage());
			return this.WEB_RESULT_CONTENT;
		}
		
	}
	
	public String doRefresh() throws Exception {
		if(AAUtilsForStruts2.isAjaxRequest()){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SpproposalForm form = (SpproposalForm)getForm();
			if(form.getForMode() == null){
				form.setForMode("0");
			}
			Calendar startC = Calendar.getInstance();
			Calendar endC = Calendar.getInstance();
			startC.setTime(form.getPstarttime());
			endC.setTime(form.getPendtime());
			Map map = new LinkedMap();
			while(startC.before(endC)){
				String str = sdf.format(startC.getTime());
				map.put(str, str);
				startC.add(Calendar.DATE, 1);
			}
			map.put(sdf.format(endC.getTime()), sdf.format(endC.getTime()));
			form.setDayMap(map);
			
			super.getRequest().setAttribute("showjs","true");
			AAUtilsForStruts2.addZonesToRefresh("refreshTable2");
		}
		return WEB_RESULT_CONTENT;
	}
	
	@Override
	/**
	 * 删除促销方案同时删除该方案下的所有关联记录
	 */
	public String doDelete() throws Exception {
		// TODO Auto-generated method stub
		SpproposalBO spproposalbo = (SpproposalBO) BOFactory.build(
				SpproposalBO.class, getDBAccessUser());
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		if (selectArray == null) {
			addActionError("无法获取选中项目！");
			return "list";
		}
		for (int i = 0; i < selectArray.length; i++) {
			spproposalbo.doBatchDelete(new Long(selectArray[i]));
		}
		setActionMessage("操作成功!");
		return this.doList();
	}
}