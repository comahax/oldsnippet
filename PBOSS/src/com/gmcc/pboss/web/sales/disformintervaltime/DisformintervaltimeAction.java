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

		//���¼��������Ǳ����
		this.setForm(new DisformintervaltimeForm());
		this.setParam(new DisformintervaltimeDBParam());

        //ָ��VO��
        setClsVO(DisformintervaltimeVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Disformintervaltime.class);
		this.setClsQueryParam(DisformintervaltimeDBParam.class) ;

	}
	
	public String doSave() throws Exception {
		try{		
			if (WEB_CMD_NEW.equals(CMD)) {//����
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
					this.addActionError("��Ӧ���ֹ�˾��΢�����Ǽ���������ʱ����Ϣ�Ѵ��ڡ�");
					return WEB_RESULT_CONTENT;
				}
			}else{//�޸�
				DisformintervaltimeForm form = (DisformintervaltimeForm)this.getForm();
				DisformintervaltimeDBParam param = new DisformintervaltimeDBParam();
				param.set_se_countyid(form.getCountyid());
				param.set_se_mareacode(form.getMareacode());
				param.set_ne_starlevel(form.getStarlevel().toString());
				param.set_pagesize("0");
				
				Disformintervaltime bo =(DisformintervaltimeBO)BOFactory.build(DisformintervaltimeBO.class, this.getDBAccessUser());
				
				DataPackage dp = bo.doQuery(param);
				if(dp.getDatas().size()>0){//���ֹ�˾��΢�����Ǽ�����¼�Ѵ���
					DisformintervaltimeVO vo = (DisformintervaltimeVO)dp.getDatas().get(0);
					if(!vo.getRecid().equals(form.getRecid())){//���ǵ�ǰ�����޸ĵļ�¼
						this.addActionError("��Ӧ���ֹ�˾��΢�����Ǽ���������ʱ����Ϣ�Ѵ��ڡ�");
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
		export.setFileName("���͵�����ʱ������");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
		export.addOutputProperty("recid", "���");
		export.addOutputProperty("countyid", "�ֹ�˾",export.CODE2NAME,"#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "΢����",export.CODE2NAME,"#MICROAREA");
		export.addOutputProperty("starlevel", "�Ǽ�",export.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("intervaltime", "����ʱ��(��)");		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		DisformintervaltimeDBParam params = (DisformintervaltimeDBParam)super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		return super.doExcel();
	}
	
	/**
	 * ������������>�����͵����� ->�����͵���ʱԤ��ͳ�Ʋ�ѯ��
	 * @return
	 * @throws Exception
	 */
	public String doTodisformstat() throws Exception {//�״ν�����治��ѯ
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
				setActionMessage("����ʱ�������ܳ���31�졣");
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
				setActionMessage("����ʱ�������ܳ���31�졣");
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