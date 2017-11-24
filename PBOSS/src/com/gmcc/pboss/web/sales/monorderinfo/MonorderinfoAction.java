/**
 * auto-generated code
 * Tue Oct 13 09:40:58 CST 2009
 */
 package com.gmcc.pboss.web.sales.monorderinfo;

import java.util.LinkedList;
import java.util.List;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.monorderinfo.MonorderinfoDBParam;
import com.gmcc.pboss.business.sales.monorderinfo.MonorderinfoVO;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.monorderinfo.Monorderinfo;
import com.gmcc.pboss.web.channel.way.WayWebParam;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: MonorderinfoAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class MonorderinfoAction extends BaseAction{
	private List<MonorderinfoForm> monorderinfoList = new LinkedList<MonorderinfoForm>();
	public MonorderinfoAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new MonorderinfoForm());
		this.setParam(new MonorderinfoWebParam());

        //ָ��VO��
        setClsVO(MonorderinfoVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Monorderinfo.class);
		this.setClsQueryParam(MonorderinfoDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doList() throws Exception{
		super.doList();
		DataPackage dp = getDp();
		List<MonorderinfoVO> list = dp.getDatas();

		String wayname = new String();
		for(MonorderinfoVO monorderinfoVO:list)
		{
			MonorderinfoForm monorderinfoForm = new MonorderinfoForm();
			BeanUtils.copyProperties(monorderinfoForm, monorderinfoVO);
			WayBO way = (WayBO)BOFactory.build(WayBO.class,getDBAccessUser());
			WayWebParam param = new WayWebParam();
			param.set_se_wayid(monorderinfoVO.getWayid());
			dp = way.doQuery(param);
			if(dp.getDatas() != null && !"".equals(dp.getDatas())
					&& dp.getDatas().size() > 0){
				wayname =  ((WayVO)dp.getDatas().get(0)).getWayname();
				monorderinfoForm.setWayname(wayname);
				
				monorderinfoList.add(monorderinfoForm);
			}
		}
		
		return WEB_RESULT_LIST;
	}

	public List<MonorderinfoForm> getMonorderinfoList() {
		return monorderinfoList;
	}

	public void setMonorderinfoList(List<MonorderinfoForm> monorderinfoList) {
		this.monorderinfoList = monorderinfoList;
	}
}