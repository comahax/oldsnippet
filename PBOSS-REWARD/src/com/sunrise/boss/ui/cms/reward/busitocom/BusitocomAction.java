/**
 * auto-generated code
 * Fri Aug 28 11:17:48 CST 2009
 */
package com.sunrise.boss.ui.cms.reward.busitocom;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.operation.persistent.OperationListVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightVO;
import com.sunrise.boss.business.cms.reward.busitocom.persistent.BusitocomListVO;
import com.sunrise.boss.business.cms.reward.busitocom.persistent.BusitocomVO;
import com.sunrise.boss.business.resmanage.com.persistent.ComListVO;
import com.sunrise.boss.business.resmanage.com.persistent.ComVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.reward.busitocom.BusitocomDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.pub.tools.StringSplit;

/**
 * <p>Title: BusitocomAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class BusitocomAction extends BaseDelegateAction {
	public BusitocomAction() {
		setVoClass(BusitocomVO.class);
		// TODO: ������������������
		this.pkNameArray = new String[5];
		pkNameArray[0] = "cityid";
		pkNameArray[1] = "comid";
		pkNameArray[2] = "comresid";
		pkNameArray[3] = "comtype";
		pkNameArray[4] = "opnid";
	}

	/**
	 * ����comid��bug
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BusitocomForm form = (BusitocomForm) actionForm;
		if(!StringUtils.isEmpty(form.get_ne_comid())){
			String[] comids = StringSplit.split(form.get_ne_comid()," ");
			form.set_ne_comid(comids[0]);
		}
		form.set_sql_cityid("cityid = 'GD' or cityid is null or cityid ='' or cityid = '"+SessionFactoryRouter.conversionCityid(user.getCityid())+"'");
		return super.doList(actionMapping, form, request, response, user);
	}
	/**
	 * ����ΪEXCEL��ʽ��
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("ҵ������Ʒ��Դ��������");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
		export.addOutputProperty("opnid", "ҵ�����");
		export.addOutputProperty("cityid", "���б�־",CommonExportBean.CODE2NAME,"#CITYNAME");
		export.addOutputProperty("comtype", "��Ʒ����",CommonExportBean.CODE2NAME,"$IM_COMTYPE");
		export.addOutputProperty("comid", "��Ʒ��־");
		export.addOutputProperty("comid", "��Ʒ����",CommonExportBean.CODE2NAME,"#COMSYSTEM");
		export.addOutputProperty("pricelow", "��ƷЭ��ۣ�Ԫ��");
		export.addOutputProperty("busitype", "ҵ�������",CommonExportBean.CODE2NAME,"$CH_TOCOMBUSITYPE");
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super
				.doExcel(actionMapping, actionForm, request, response, user);
	}
	
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BusitocomForm form = (BusitocomForm) actionForm;
		//����OPNID
		OperationDelegate operDele = new OperationDelegate();
		OperationListVO operListVO = new OperationListVO();
		operListVO.set_se_opnid(form.getOpnid());
		operListVO.set_ne_isbusi("1");
		if(operDele.doQuery(operListVO, user).getDatas().size()==0){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ʧ�ܣ�ҵ�����["+form.getOpnid()+"]������");
			return actionMapping.findForward("content");
		}
		
		//У���Ƿ���Ȩ�޴���'0403'��ͷ��ҵ��
		if(form.getOpnid().toString().trim().substring(0, 4).equals("0403")){
			ProvincialrightVO rightvo = new ProvincialrightVO();
			rightvo.setProopr(user.getOpercode());
			rightvo.setRightid("CH_PW_TERMINALSELL");
			CommonDelegate delegate = new CommonDelegate(ProvincialrightVO.class);
			rightvo = (ProvincialrightVO) delegate.doFindByPk(rightvo, user);
			if (rightvo == null) {
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ʧ�ܣ���ǰ����û��Ȩ������/�༭��ҵ��!");
				return actionMapping.findForward("content");
			}
		}
		
		//У��COMID
		if(!StringUtils.isEmpty(form.getComid().toString())){
			String[] comids = StringSplit.split(form.getComid().toString()," ");
			form.setComid(new Long(comids[0]));
		}
		CommonDelegate comDele = new CommonDelegate(ComVO.class);
		ComListVO comListVO = new ComListVO();
		comListVO.set_ne_comid(form.getComid().toString());
		DataPackage comDp = comDele.doQuery(comListVO, user);
		if(comDp.getDatas().size()==0){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ʧ�ܣ���Ʒ��ʶ["+form.getComid()+"]������");
			return actionMapping.findForward("content");
		}
		
		ComVO comvo = (ComVO) ((List) comDp.getDatas()).get(0);
		if(form.getPricelow().longValue() <= comvo.getComprice().longValue() &&
				comvo.getComprice().longValue() <= form.getPricetop().longValue()){
			
		}else{
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ʧ�ܣ���Ʒ��ʶ["+form.getComid()+"]����Ʒ�۸�["+comvo.getComprice().longValue()/100+"]������������!");
			return actionMapping.findForward("content");
		}
		
		if(WebConstant.COMMAND_STRING_NEW.equals(form.getCmdState())){
			BusitocomDelegate delegate = new BusitocomDelegate();
			BusitocomListVO listvo = new BusitocomListVO();
			listvo.set_ne_comid(comvo.getComid().toString());
			DataPackage dp = delegate.doQuery(listvo, user);
			if(dp.getDatas() != null && dp.getDatas().size() != 0){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ʧ�ܣ���Ʒ��ʶ["+form.getComid()+"]ֻ�ܶ�Ӧһ����Ӧһ��ҵ�����!");
				return actionMapping.findForward("content");
			}
		}
		
		form.setCityid(comvo.getCityid());
		form.setComclassid(new Integer(comvo.getComclassid().intValue()));
		form.setComtype(new Integer(comvo.getComtype().intValue()));
		form.setComresid("0");
			
		return super.doSave(actionMapping, form, request, response, user);
	}
	
	
	protected ActionForward doDelete(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		BusitocomForm form = (BusitocomForm) actionForm;
		String[]  selectArray = ((BusitocomForm) actionForm).get_selectitem();
		for (int i = 0; i < selectArray.length; i++) {
			String[] str = selectArray[i].split("\\|");
			if(str[4].toString().trim().substring(0, 4).equals("0403")){
				ProvincialrightVO rightvo = new ProvincialrightVO();
				rightvo.setProopr(user.getOpercode());
				rightvo.setRightid("CH_PW_TERMINALSELL");
				CommonDelegate delegate = new CommonDelegate(ProvincialrightVO.class);
				rightvo = (ProvincialrightVO) delegate.doFindByPk(rightvo, user);
				if (rightvo == null) {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "ɾ��ʧ�ܣ���ǰ����û��Ȩ��ɾ����ҵ��!");
					return actionMapping.findForward("list");
				}
			}
		}
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�����ɹ�!");
		return super.doDelete(actionMapping, actionForm, request, response, user);
	}
}
