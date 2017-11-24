/**
 * auto-generated code
 * Thu Jul 08 15:12:12 CST 2010
 */
 package com.gmcc.pboss.web.sales.timesect;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;

import com.gmcc.pboss.business.base.operator.OperatorVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.timesect.TimesectDBParam;
import com.gmcc.pboss.business.sales.timesect.TimesectVO;
import com.gmcc.pboss.control.base.operator.Operator;
import com.gmcc.pboss.control.base.operator.OperatorBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.timesect.Timesect;
import com.gmcc.pboss.control.sales.timesect.TimesectBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: TimesectAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class TimesectAction extends BaseAction{
	private List<TimesectForm> timesectList = new LinkedList<TimesectForm>();
	
	public List<TimesectForm> getTimesectList() {
		return timesectList;
	}

	public void setTimesectList(List<TimesectForm> timesectList) {
		this.timesectList = timesectList;
	}

	public TimesectAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new TimesectForm());
		this.setParam(new TimesectDBParam());

        //ָ��VO��
        setClsVO(TimesectVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Timesect.class);
		this.setClsQueryParam(TimesectDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	public String doShow() throws Exception{
		Operator operator = (Operator)BOFactory.build(OperatorBO.class,DBAccessUser.getInnerUser());
		OperatorVO vo = operator.doFindByPk(getDBAccessUser().getOprcode());
		String countyid = "";
		if(StringUtils.isNotBlank(vo.getOrgid())){
			Way way = (Way)BOFactory.build(WayBO.class,DBAccessUser.getInnerUser());
			WayVO wayvo = way.doFindByPk(vo.getOrgid());
			countyid = wayvo.getCountyid();
			TimesectDBParam param = (TimesectDBParam)getParam();
			param.set_se_cityid(wayvo.getCityid());
			param.set_se_countyid(countyid);
		}
		return "list";
	}
	
	
	public String doList() throws Exception {
		try {
			Operator operator = (Operator)BOFactory.build(OperatorBO.class,DBAccessUser.getInnerUser());
			OperatorVO opvo = operator.doFindByPk(getDBAccessUser().getOprcode());
			if(StringUtils.isNotBlank(opvo.getOrgid())){
				Way way = (Way)BOFactory.build(WayBO.class,DBAccessUser.getInnerUser());
				WayVO wayvo = way.doFindByPk(opvo.getOrgid());
				TimesectDBParam param = (TimesectDBParam)getParam();
				param.set_se_cityid(wayvo.getCityid());
			}
			super.doList();
			DataPackage dp = getDp();
			List<TimesectVO> list = dp.getDatas();
			for(TimesectVO vo : list){
				TimesectForm form = new TimesectForm();
				BeanUtils.copyProperties(form,vo);
				String datetype = vo.getDatetype();
				String weekset = vo.getWeekset();
				String timesect = vo.getTimesect();
				Date begindate = vo.getBegindate();
				Date enddate = vo.getEnddate();
				String orderdatetimesect = "";//����&&ʱ��
				if(StringUtils.isNotBlank(datetype)){
					if("APPWEEK".equals(datetype)&&StringUtils.isNotBlank(weekset)&&StringUtils.isNotBlank(timesect)){
						String[] weeksetArray = weekset.split(";");
						String[] timesectArray = timesect.split(";");
						for(int i=0;i<weeksetArray.length;i++){
							switch(Integer.parseInt(weeksetArray[i])){
							case 1:
								if(StringUtils.isNotBlank(timesectArray[i]))
									orderdatetimesect="��һ "+timesectArray[i];
								else
									orderdatetimesect="��һ ";
								break;
							case 2:
								if(StringUtils.isNotBlank(timesectArray[i]))
									orderdatetimesect=orderdatetimesect+"�ܶ� "+timesectArray[i];
								else
									orderdatetimesect=orderdatetimesect+"�ܶ� ";
								break;
							case 3:
								if(StringUtils.isNotBlank(timesectArray[i]))
									orderdatetimesect=orderdatetimesect+"���� "+timesectArray[i];
								else
									orderdatetimesect=orderdatetimesect+"���� ";
								break;
							case 4:
								if(StringUtils.isNotBlank(timesectArray[i]))
									orderdatetimesect=orderdatetimesect+"���� "+timesectArray[i];
								else
									orderdatetimesect=orderdatetimesect+"���� ";
								break;
							case 5:
								if(StringUtils.isNotBlank(timesectArray[i]))
									orderdatetimesect=orderdatetimesect+"���� "+timesectArray[i];
								else
									orderdatetimesect=orderdatetimesect+"���� ";
								break;
							case 6:
								if(StringUtils.isNotBlank(timesectArray[i]))
									orderdatetimesect=orderdatetimesect+"���� "+timesectArray[i];
								else
									orderdatetimesect=orderdatetimesect+"���� ";
								break;
							case 7:
								if(StringUtils.isNotBlank(timesectArray[i]))
									orderdatetimesect=orderdatetimesect+"���� "+timesectArray[i];
								else
									orderdatetimesect=orderdatetimesect+"���� ";
								break;
							}
							orderdatetimesect=orderdatetimesect+"<br>";
						}
						orderdatetimesect=orderdatetimesect.substring(0, orderdatetimesect.length()-4);
					}else if ("STOPDATE".equals(datetype)&&null!=begindate&&null!=enddate){
						java.sql.Date sqlbegindate = new java.sql.Date(begindate.getTime());
						java.sql.Date sqlenddate = new java.sql.Date(enddate.getTime());

						String d1 = PublicUtils.sqlDateToStr(sqlbegindate);
						String d2 = PublicUtils.sqlDateToStr(sqlenddate);
						orderdatetimesect = d1 + " �� " + d2;
					}
				}
				form.setOrderdatetimesect(orderdatetimesect);
				timesectList.add(form);
			}
			return WEB_RESULT_LIST;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addActionError(e.getMessage());
			return WEB_RESULT_LIST;
		}
	}

	@Override
	public String doEdit() throws Exception {
		try {
			super.doEdit();
			TimesectVO vo = (TimesectVO) getForm();
			TimesectForm form = new TimesectForm();
			BeanUtils.copyProperties(form, vo);
			if (null != form.getWeekset()) {
				String[] weeksetArray = form.getWeekset().split(";");
				String[] timesectArray = form.getTimesect().split(";");
				for (int i = 0; i < weeksetArray.length; i++) {
					switch (Integer.parseInt(weeksetArray[i])) {
					case 1:
						form.setTimesect1(timesectArray[i]);
						break;
					case 2:
						form.setTimesect2(timesectArray[i]);
						break;
					case 3:
						form.setTimesect3(timesectArray[i]);
						break;
					case 4:
						form.setTimesect4(timesectArray[i]);
						break;
					case 5:
						form.setTimesect5(timesectArray[i]);
						break;
					case 6:
						form.setTimesect6(timesectArray[i]);
						break;
					case 7:
						form.setTimesect7(timesectArray[i]);
						break;
					}
				}
			}
			setForm(form);
			return "content";
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
			return "content";
		}
	}

	@Override
	public String doNew() throws Exception {
		super.doNew();
		TimesectForm form = (TimesectForm)getForm();
		String cityid = getDBAccessUser().getCityid();
		form.setCityid(cityid);
		form.setDatetype("APPWEEK");
		form.setTimesect1("08:00-16:00");
		form.setTimesect2("08:00-16:00");
		form.setTimesect3("08:00-16:00");
		form.setTimesect4("08:00-16:00");
		form.setTimesect5("08:00-16:00");
		form.setTimesect6("08:00-16:00");
		form.setTimesect7("08:00-16:00");
		return WEB_RESULT_CONTENT;
	}

	@Override
	public String doSave() throws Exception {
		TimesectForm form = (TimesectForm)getForm();
		if(StringUtils.isBlank(form.getMareacode()))
			form.setMareacode("ALL");//΢����Ϊ��ʱ��Ĭ��Ϊ��ALL��
		if("APPWEEK".equals(form.getDatetype())){//ָ������ʱ
			TimesectDBParam param = new TimesectDBParam();
			param.set_se_cityid(form.getCityid());
			param.set_se_countyid(form.getCountyid());
			param.set_se_mareacode(form.getMareacode());
			param.set_se_datetype(form.getDatetype());
			if (WEB_CMD_EDIT.equals(CMD)) {
				param.set_nne_recid(form.getRecid().toString());
			}
			Timesect ts = (Timesect)BOFactory.build(TimesectBO.class, getDBAccessUser());
			DataPackage dp = ts.doQuery(param);
			if (dp.getDatas().size() > 0) {
				addActionError("��ͬ��¼�Ѿ����ڣ����顣");
				return WEB_RESULT_CONTENT;
			}
			//����ʼ���ںͽ����������
			form.setBegindate(null);
			form.setEnddate(null);
			
			String weekset = "";
			String timesect = "";
			if (StringUtils.isNotBlank(form.getTimesect1())){
				weekset = "1;";
				timesect = form.getTimesect1()+";";
			}
			if (StringUtils.isNotBlank(form.getTimesect2())){
				weekset = weekset+"2;";
				timesect = timesect+form.getTimesect2()+";";
			}
			if (StringUtils.isNotBlank(form.getTimesect3())){
				weekset = weekset+"3;";
				timesect = timesect+form.getTimesect3()+";";
			}
			if (StringUtils.isNotBlank(form.getTimesect4())){
				weekset = weekset+"4;";
				timesect = timesect+form.getTimesect4()+";";
			}
			if (StringUtils.isNotBlank(form.getTimesect5())){
				weekset = weekset+"5;";
				timesect = timesect+form.getTimesect5()+";";
			}
			if (StringUtils.isNotBlank(form.getTimesect6())){
				weekset = weekset+"6;";
				timesect = timesect+form.getTimesect6()+";";
			}
			if (StringUtils.isNotBlank(form.getTimesect7())){
				weekset = weekset+"7;";
				timesect = timesect+form.getTimesect7()+";";
			}
			form.setWeekset(weekset);
			form.setTimesect(timesect);
		}else{//ͣ������
			form.setWeekset(null);
			form.setTimesect(null);
		}
		
 		return super.doSave();
	}
}