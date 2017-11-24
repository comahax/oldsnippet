package com.gmcc.pboss.web.channel.impway;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.web.channel.way.WayForm;
import com.gmcc.pboss.web.channel.way.WayWebParam;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * 
 * @author hejw
 * 入柜商渠道管理
 */
public class ImpWayAction extends BaseAction {
	public ImpWayAction() {
		super();

		this.setForm(new WayForm());
		this.setParam(new WayWebParam());

		setClsVO(WayVO.class);
		this.pkNameArray = new String[] { "wayid" };
		this.setClsControl(Way.class);
		this.setClsQueryParam(WayDBParam.class);
	}
	
	public String doList() throws Exception {
		HttpServletRequest request = getRequest();
		User user = (User) request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
		Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		WayDBParam params = (WayDBParam)getParam();
		DataPackage dp = way.doQueryImpWay(params, user);
		setDp(dp);
		return "list";
	}
	
	public String doDelete() throws Exception{
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		for (int i = 0; i < selectArray.length; i++) {
			WayVO vo = way.doFindByPk(getSelectedPK(selectArray[i]));
			vo.setWaystate(new Short("0"));
			way.doRemove(vo);
		}
		return doList();
	}
	
	public String doSave() throws Exception{
		WayForm wayForm = (WayForm) getForm();
		Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		// 判断渠道编码格式
		String path = "^[a-zA-Z][a-zA-z0-9-]{0,18}$";
		Pattern pattern = Pattern.compile(path);
		Matcher matcher = pattern.matcher(wayForm.getWayid());
		if (!matcher.find()) {
			super.addActionError("渠道编码格式不正确,只能是字母+数字或者-");
			return "content";
		}
		// 判断渠道编码唯一性
		WayVO vo = way.doFindByPk(getSelectedPK(wayForm.getWayid()));
		if (vo != null && !CMD.equals("EDIT")) {
			super.addActionError("【" + wayForm.getWayid() + "】已存在该渠道编码");
			return "content";
			
		}
		// 判断是否存在相同的经度纬度
		WayDBParam params = new WayDBParam();
		params.set_se_longtitude(wayForm.getLongtitude());
		params.set_se_latitude(wayForm.getLatitude());
		DataPackage dp = way.doQueryWayByParams(params);
		if (dp.getDatas() != null && dp.getDatas().size() > 0 && !CMD.equals("EDIT")) {
			super.addActionError("已经存在经纬度【" + wayForm.getLongtitude() + "," 
					+ wayForm.getLatitude() + "】.如网点确实同一经纬度,建议修改小数点后第6位以示区分");
			return "content";
		}
		// 判断上级渠道有效性
		vo = way.doFindByPk(getSelectedPK(wayForm.getUpperwayid()));
		if (vo != null && (vo.getWaystate() == 0 || vo.getWaystate() == -1)) {
			super.addActionError("上级渠道状态为失效或已删除,请确认");
			return "content";
		}
		// 判断地市公司是否与上级渠道中的地市公司一致
		if (vo != null && !vo.getCityid().equals(wayForm.getCityid())) {
			super.addActionError("地市公司应该与上级渠道中的地市公司保持一致");
			return "content";
		}
		// 判断分公司是否与上级渠道中分公司一致
		if (vo != null && vo.getCountyid() != null && !vo.getCountyid().equals(wayForm.getCountyid())) {
			super.addActionError("分公司应该与上级渠道中的分公司保持一致");
			return "content";
		}
		// 判断所属合作商编码是否存在
		if (wayForm.getChainhead() != null
				&& !wayForm.getChainhead().equals("")
				&& !wayForm.getChainhead().equals("0000")) {
			params = new WayDBParam();
			params.set_se_wayid(wayForm.getChainhead());
			params.set_se_waytype("AG");
			params.set_se_waysubtype("DIS");
			params.set_ne_waystate("1");
			dp = way.doQueryWayByParams(params);
			if (dp.getDatas() == null || dp.getDatas().size() == 0) {
				super.addActionError("所属合作商编码【" + wayForm.getChainhead() + "】不存在或者不是连锁经营合作商");
				return "content";
			}
		}
		if (CMD.equals("NEW")) {
			wayForm.setWaytype("IMP");
			wayForm.setWaystate(new Short("1"));
			wayForm.setCreatetime(new Date());
			WayVO wayVO = new WayVO();
			BeanUtils.copyProperties(wayVO, wayForm);
			wayVO = way.doSave(wayVO);
			BeanUtils.copyProperties(getForm(), wayVO);
		} else if (CMD.equals("EDIT")) {
			WayVO wayVO = way.doFindByPk(getSelectedPK(wayForm.getWayid()));
			BeanUtils.copyProperties(wayVO, wayForm);
			wayVO = way.doUpdateImpWay(wayVO);
			BeanUtils.copyProperties(getForm(), wayVO);
		}
		this.CMD = WEB_CMD_SAVE;
		setActionMessage("操作成功!");
		return "content";
	}
	
	public String doExportExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("入柜商渠道信息");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date())});
		export.addOutputProperty("wayid", "渠道编码");
		export.addOutputProperty("wayname", "渠道名称");
		export.addOutputProperty("upperwayid", "上级渠道");
		export.addOutputProperty("waysubtype", "子类型", CommonExportBean.CODE2NAME, "waysubtype");
		export.addOutputProperty("cityid", "地市公司", CommonExportBean.CODE2NAME, "#CITYCOMPANY");
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode", "服务销售中心", CommonExportBean.CODE2NAME, "#SERVCENT");
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("starlevel", "星级", CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("runmode", "经营模式", CommonExportBean.CODE2NAME, "$CH_RUNMODE");
		export.addOutputProperty("isconnected", "是否联网", CommonExportBean.CODE2NAME, "$CH_ISCONNECTED");
		export.addOutputProperty("connecttype", "联网方式", CommonExportBean.CODE2NAME, "$CH_CONNECTTYPE");
		export.addOutputProperty("prtsource", "物业来源分类", CommonExportBean.CODE2NAME, "$CH_PRTSOURCE");
		export.addOutputProperty("buztypecode", "商圈类型", CommonExportBean.CODE2NAME, "$CH_BUZTYPE");
		export.addOutputProperty("adtypecode", "区域类型", CommonExportBean.CODE2NAME, "$CH_ADTYPE");
		export.addOutputProperty("buzphoneno", "店面经理联系电话");
		export.addOutputProperty("adacode", "行政区划编码", CommonExportBean.CODE2NAME, "#CH_ADIMAREA");
		export.addOutputProperty("isshare", "是否共享", CommonExportBean.CODE2NAME, "$CH_DSTISKEYSTEP");
		
		// 设置VO类
		export.voClassArray = new Class[] { WayVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doList";
		WayDBParam params = (WayDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	public String  doCheckupperway() throws Exception {
		Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		WayForm form = (WayForm) getForm();
		if (form.getUpperwayid() == null || form.getUpperwayid().equals("")) {
			return "content";
		}
		WayVO uppwayVO = way.doFindByPk(form.getUpperwayid());
		if (uppwayVO == null) {
			throw new Exception("上级渠道编码【" + form.getUpperwayid() + "】不存在数据，请确认渠道编码是否正确!");
		}

		// 设置【是否授权网点】，设置回原来的值
		WayVO wayVO = way.doFindByPk(form.getWayid());
		if (wayVO != null) {
			form.setChecked(wayVO.getChecked());
		} else {// 新增调成否
			form.setChecked("N");
		}
		
		// 社会网点的上级渠道必须是合作商，移动部门/科室或服务厅下添加社会网点
		if ( !"IMP".equals(uppwayVO.getWaysubtype()) && 1==uppwayVO.getWaystate()) {
			form.setCityid(uppwayVO.getCityid());
			form.setCountyid(uppwayVO.getCountyid());
			form.setSvccode(uppwayVO.getSvccode());
			form.setMareacode(uppwayVO.getMareacode());
		} else {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"录入的上级渠道只能是有效的非引商入柜的渠道");
			form.setUpperwayid("");
			form.setCityid("");
			form.setCountyid("");
			form.setSvccode("");
			form.setMareacode("");
		}
		if(StringUtils.equals(uppwayVO.getWaytype(), "AG") && StringUtils.equals(uppwayVO.getWaysubtype(), "DIS")) {
			form.setChainhead(uppwayVO.getWayid());
		} else {
			form.setChainhead("");
		}
		return "content";
	}
}
