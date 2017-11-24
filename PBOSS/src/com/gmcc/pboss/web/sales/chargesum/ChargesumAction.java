/**
 * auto-generated code
 * Thu Jul 08 10:27:55 CST 2010
 */
 package com.gmcc.pboss.web.sales.chargesum;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.chargesum.ChargesumDBParam;
import com.gmcc.pboss.business.sales.chargesum.ChargesumVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.chargesum.Chargesum;
import com.gmcc.pboss.control.sales.chargesum.ChargesumBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: LimitsetAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChargesumAction extends BaseAction{
	
	public ChargesumAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new ChargesumForm());
		
		ChargesumDBParam param = new ChargesumDBParam();
		Date today = new Date();
		String todayStr = DateUtil.formatDate(today, DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
		param.setStarttimeStr(todayStr);
		param.setEndtimeStr(todayStr);
		this.setParam(param);

        //ָ��VO��
        setClsVO(ChargesumVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Chargesum.class);
		this.setClsQueryParam(ChargesumDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doList() throws Exception{
		ChargesumDBParam param = (ChargesumDBParam)getParam();
		String starttimeStr = param.getStarttimeStr();
		String endtimeStr = param.getEndtimeStr();
		
		Map<String,String> conditionMap = new HashMap<String, String>();
		
		//���߲�಻�ܳ���30��
		if(!StringUtils.isEmpty(starttimeStr)&&!StringUtils.isEmpty(endtimeStr))
		{
			Date startdate = DateUtil.parseDate(starttimeStr,DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
			Date enddate = DateUtil.parseDate(endtimeStr,DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
			int diff = DateUtil.operationDate(enddate, startdate, DateUtil.DateOperationType.DIFF);
			if(diff>30)
			{
				setActionMessage("ʱ�������ܳ���30�졣");
				return WEB_RESULT_LIST;
			}
			starttimeStr = starttimeStr + " 00:00:00";
			endtimeStr = endtimeStr + " 23:59:59";
			
			conditionMap.put("starttimeStr", starttimeStr);
			conditionMap.put("endtimeStr", endtimeStr);
		}
		
		if(!StringUtils.isEmpty(param.getWayid()))
		{
			conditionMap.put("wayid", param.getWayid());
		}
		param.setQueryAll(true);
		Chargesum chargesum = (Chargesum)BOFactory.build(ChargesumBO.class, getDBAccessUser());
		DataPackage dp = chargesum.doQueryChargesum(conditionMap, param);
		
		//��ʽ������
		List<ChargesumVO> chargesumList = dp.getDatas();
		BigDecimal recamtFormat = null;
		BigDecimal actamtFormat = null;
		BigDecimal recamtTotal = new BigDecimal("0");
		BigDecimal actamtTotal = new BigDecimal("0");
		
		String wayid = "";
		Way way = (Way)BOFactory.build(WayBO.class, getDBAccessUser());
		WayVO wayVO = new WayVO();
		for(int i=0; i<chargesumList.size(); i++)
		{
			if(null!=chargesumList.get(i).getRecamt())
			{
				recamtFormat = new BigDecimal(chargesumList.get(i).getRecamt());
				recamtFormat = recamtFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				chargesumList.get(i).setRecamtFormat(recamtFormat.toString());
			}
			if(null!=chargesumList.get(i).getActamt())
			{
				actamtFormat = new BigDecimal(chargesumList.get(i).getActamt());
				actamtFormat = actamtFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				chargesumList.get(i).setActamtFormat(actamtFormat.toString());
			}
			recamtTotal = recamtTotal.add(recamtFormat);
			actamtTotal = actamtTotal.add(actamtFormat);
			
			wayid = chargesumList.get(i).getWayid();
			wayVO = way.doFindByPk(wayid);
			chargesumList.get(i).setWayname(wayVO.getWayname());
		}
		ChargesumVO chargesumVO = new ChargesumVO();
		chargesumVO.setWayid("�ϼ�");
		recamtTotal = recamtTotal.setScale(2,BigDecimal.ROUND_HALF_EVEN);
		actamtTotal = actamtTotal.setScale(2,BigDecimal.ROUND_HALF_EVEN);
		chargesumVO.setRecamtFormat(recamtTotal.toString());
		chargesumVO.setActamtFormat(actamtTotal.toString());
		chargesumList.add(chargesumVO);
		setDp(dp);
		return WEB_RESULT_LIST;
	}

	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("���û���");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
		export.addOutputProperty("wayid", "��������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("paytype", "�ɷѷ�ʽ",CommonExportBean.CODE2NAME,"$FX_PAYTYPE");
		export.addOutputProperty("recamtFormat", "Ӧ�գ�Ԫ��");
		export.addOutputProperty("actamtFormat", "ʵ�գ�Ԫ��");
		getParam().set_pagesize("0");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
}