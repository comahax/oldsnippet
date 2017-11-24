/**
 * auto-generated code
 * Sat Mar 31 17:39:07 CST 2012
 */
 package com.gmcc.pboss.web.sales.disformintervaltime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.sales.disformintervaltime.DisformintervaltimeVO ;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.sales.disformintervaltime.DisformintervaltimeDBParam;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.sales.disformintervaltime.DisformintervaltimeBO;
import com.gmcc.pboss.control.sales.disformintervaltime.Disformintervaltime ;

/**
 * <p>Title: DisformintervaltimeAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class DisformintervaltimeAction extends BaseAction{
	
	public DisformintervaltimeAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new DisformintervaltimeForm());
		this.setParam(new DisformintervaltimeDBParam());

        //指定VO类
        setClsVO(DisformintervaltimeVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Disformintervaltime.class);
		this.setClsQueryParam(DisformintervaltimeDBParam.class) ;

	}
	
	public String doSave() throws Exception {
		try{		
			if (WEB_CMD_NEW.equals(CMD)) {//新增
				DisformintervaltimeForm form = (DisformintervaltimeForm)this.getForm();
				DisformintervaltimeDBParam param = new DisformintervaltimeDBParam();
				param.set_se_countyid(form.getCountyid());
				param.set_se_mareacode(form.getMareacode());
				param.set_ne_starlevel(form.getStarlevel().toString());
				param.setCountOnly(true);
				param.set_pagesize("0");
				
				Disformintervaltime bo =(DisformintervaltimeBO)BOFactory.build(DisformintervaltimeBO.class, this.getDBAccessUser());
				
				DataPackage dp = bo.doQuery(param);
				if(dp.getRowCount()>0){
					this.addActionError("相应【分公司、微区域、星级】的配送时限信息已存在。");
					return WEB_RESULT_CONTENT;
				}
			}else{//修改
				DisformintervaltimeForm form = (DisformintervaltimeForm)this.getForm();
				DisformintervaltimeDBParam param = new DisformintervaltimeDBParam();
				param.set_se_countyid(form.getCountyid());
				param.set_se_mareacode(form.getMareacode());
				param.set_ne_starlevel(form.getStarlevel().toString());
				param.set_pagesize("0");
				
				Disformintervaltime bo =(DisformintervaltimeBO)BOFactory.build(DisformintervaltimeBO.class, this.getDBAccessUser());
				
				DataPackage dp = bo.doQuery(param);
				if(dp.getDatas().size()>0){//【分公司、微区域、星级】记录已存在
					DisformintervaltimeVO vo = (DisformintervaltimeVO)dp.getDatas().get(0);
					if(!vo.getRecid().equals(form.getRecid())){//不是当前正在修改的记录
						this.addActionError("相应【分公司、微区域、星级】的配送时限信息已存在。");
						return WEB_RESULT_CONTENT;
					}
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}		
		
		return super.doSave();
	}
	
	public String doBatchimport()throws Exception {
		return "batchimport";
	}
	
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("配送单配送时限设置");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "导出时间",
						format.format(new Date()) });
		export.addOutputProperty("recid", "编号");
		export.addOutputProperty("countyid", "分公司",export.CODE2NAME,"#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "微区域",export.CODE2NAME,"#MICROAREA");
		export.addOutputProperty("starlevel", "星级",export.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("intervaltime", "配送时限(天)");		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		DisformintervaltimeDBParam params = (DisformintervaltimeDBParam)super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		return super.doExcel();
	}
	
	/**
	 * 【分销管理】—>【配送单管理】 ->【配送单超时预警统计查询】
	 * @return
	 * @throws Exception
	 */
	public String doTodisformstat() throws Exception {//首次进入界面不查询
		DisformintervaltimeDBParam params = new DisformintervaltimeDBParam();
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DAY_OF_MONTH, 1);
		String nl = myformat.format(c.getTime())+" 00:00:00";
		c.set(Calendar.MONTH, c.get(Calendar.MONTH)+1);
		c.set(Calendar.DAY_OF_MONTH,c.get(Calendar.DAY_OF_MONTH)-1);
		String nm = myformat.format(c.getTime())+" 23:59:59";
		params.set_dnl_createtime(nl);
		params.set_dnm_createtime(nm);
		
		this.setParam(params);
		
		return "disformstat";
	}	
	public String doDisformstat() throws Exception {
		try{
			//DisformintervaltimeForm form = (DisformintervaltimeForm)this.getForm();
			DisformintervaltimeDBParam params = (DisformintervaltimeDBParam)this.getParam();
			
			Date ldate = new Date();
			Date mdate = new Date();
			SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
			ldate = myformat.parse(params.get_dnl_createtime());
			mdate = myformat.parse(params.get_dnm_createtime());
			Long day = (mdate.getTime() - ldate.getTime())
					/ (1000 * 60 * 60 * 24);
			if (day > 30) {
				setActionMessage("创建时间间隔不能超过31天。");
				return "disformstat";
			}
			
			Disformintervaltime bo =(DisformintervaltimeBO)BOFactory.build(DisformintervaltimeBO.class, this.getDBAccessUser());
			DataPackage dp = bo.doDisformStat(params);
			this.setDp(dp);
		}catch(Exception e ){
			setActionMessage(e.getMessage());
		}		
		return "disformstat";
	}
	
	public String doExceldisformstat() throws Exception {
		try{
			DisformintervaltimeDBParam params = (DisformintervaltimeDBParam)this.getParam();			
			Date ldate = new Date();
			Date mdate = new Date();
			SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
			ldate = myformat.parse(params.get_dnl_createtime());
			mdate = myformat.parse(params.get_dnm_createtime());
			Long day = (mdate.getTime() - ldate.getTime())
					/ (1000 * 60 * 60 * 24);
			if (day > 30) {
				setActionMessage("创建时间间隔不能超过31天。");
				return "disformstat";
			}
			params.set_pagesize("0");
			Disformintervaltime bo =(DisformintervaltimeBO)BOFactory.build(DisformintervaltimeBO.class, this.getDBAccessUser());
			DataPackage dp = bo.doDisformStat(params);
			this.setDp(dp);
		}catch(Exception e){
			setActionMessage(e.getMessage());
		}
		return "exceldisformstat";
	}
	
}