/**
 * auto-generated code
 * Tue May 01 13:34:19 CST 2007
 */
package com.sunrise.boss.ui.cms.bbc.opnacctmap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ajaxanywhere.AAUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.bbc.operation.persistent.BBCoperationVO;
import com.sunrise.boss.business.cms.bbc.opnacctmap.persistent.OpnacctmapListVO;
import com.sunrise.boss.business.cms.bbc.opnacctmap.persistent.OpnacctmapVO;
import com.sunrise.boss.business.fee.woff.acct.persistent.AcctListVO;
import com.sunrise.boss.business.fee.woff.acct.persistent.AcctVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.bbc.operation.BBCoperationDelegate;
import com.sunrise.boss.delegate.cms.bbc.opnacctmap.OpnacctmapDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.delegate.fee.woff.acct.AcctDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: OpnacctmapAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class OpnacctmapAction extends BaseDelegateAction {

	public OpnacctmapAction() {
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(OpnacctmapVO.class);
		// ָ����������
		this.pkNameArray = new String[2];
		pkNameArray[0] = "opnid";
		pkNameArray[1] = "acctid";
	}
	
	public ActionForward doSelect(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		OpnacctmapForm form = (OpnacctmapForm) actionForm;
		AcctListVO listvo=new AcctListVO();
		try {
			Page.setPageSize(request, form);
			setListVO(listvo, form); // ���ú�listVO����Ϊ��ѯ����
			//CommonDelegate delegate = new CommonDelegate(AcctVO.class);
			AcctDelegate delegate = new AcctDelegate();//ֱ�Ӳ�ѯBOSSCOMMON
			DataPackage dp = delegate.doQuery(listvo, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return (actionMapping.findForward("select"));
	}
	
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		OpnacctmapForm form=(OpnacctmapForm)actionForm;
		try{
			if(AAUtils.isAjaxRequest(request)){
				//����ҵ�������߼�,ˢ��ҵ������
				if(null!=form.get_sk_opnid()&&!"".equals(form.get_sk_opnid())){
					BBCoperationVO vo=new BBCoperationVO();
					BBCoperationDelegate delegate=new BBCoperationDelegate();
					vo.setOpnid(form.get_sk_opnid());
					vo=delegate.doFindByPk(vo.getOpnid(), user);
					if(vo!=null){
						form.set_sk_opnname(vo.getName());
					}else{
						form.set_sk_opnname(null);
					}
				}else{
					form.set_sk_opnname(null);
				}
				//�������������߼�,ˢ����������
				if(null!=form.get_sk_acctid()&&!"".equals(form.get_sk_acctid())){
					AcctVO vo=new AcctVO();
					vo.setAcctid(new Long(form.get_sk_acctid()));
					//CommonDelegate delegate = new CommonDelegate(AcctVO.class);
					AcctDelegate delegate = new AcctDelegate();//ֱ�Ӳ�ѯBOSSCOMMON
					vo=(AcctVO) delegate.doFindByPk(vo.getAcctid(), user);
					if(vo!=null){
						form.set_sk_acctname(vo.getAcctname());
					}else{
						form.set_sk_acctname(null);
					}
				}else{
					form.set_sk_acctname(null);
				}
				AAUtils.addZonesToRefresh(request, "showopnname");
			}else{
				super.doList(actionMapping, actionForm, request, response, user);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return actionMapping.findForward("list"); 
	}
	
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		OpnacctmapForm form=(OpnacctmapForm)actionForm;
		try{
			StringBuffer sb=new StringBuffer("");
			if(null!=form.getBatchacctid()&&!"".equals(form.getBatchacctid())){
				//������acctid
				String[] strs=StringUtils.split(form.getBatchacctid(),",");
				OpnacctmapDelegate delegate=new OpnacctmapDelegate();
				CommonDelegate operdelegate=new CommonDelegate(BBCoperationVO.class);
				//CommonDelegate acctdelegate=new CommonDelegate(AcctVO.class);
				AcctDelegate acctdelegate = new AcctDelegate();//ֱ�Ӳ�ѯBOSSCOMMON
				for(int i=0;i<strs.length;i++){
	//				�������
					BBCoperationVO operVO=new BBCoperationVO();
					operVO.setOpnid(form.getOpnid());
					operVO = (BBCoperationVO) operdelegate.doFindByPk(operVO.getOpnid() , user);
					if(null==operVO){
						sb.append("ҵ����� [").append(form.getOpnid()).append("]").append(" ������!\t\n");
						break;
					}
					AcctVO acctVO=new AcctVO();
					acctVO.setAcctid(new Long(strs[i]));
					acctVO=(AcctVO) acctdelegate.doFindByPk(acctVO.getAcctid(), user);
					if(null==acctVO){
						sb.append("������� [").append(strs[i]).append("]").append(" ������!\t\n");
						continue;
					}
					
					OpnacctmapListVO listvo=(OpnacctmapListVO) this.getListVO();
					listvo.set_se_opnid(form.getOpnid());
					listvo.set_ne_acctid(strs[i]);
					DataPackage dp=delegate.doQuery(listvo, user);
					if(dp.getDatas().size()>0){
						sb.append("[").append(form.getOpnid()).append("] - [")
					      .append(strs[i]).append("]").append(" ��ϵ�Ѿ�����!\t\n");
					}else{
						OpnacctmapVO vo=new OpnacctmapVO();
						vo.setOpnid(form.getOpnid());
						vo.setAcctid(new Long(strs[i]));
						delegate.doCreate(vo, user);
						sb.append("[").append(form.getOpnid()).append("] - [")
					      .append(strs[i]).append("]").append(" �����ɹ�!\t\n");
					}
				}
				form.setResultstr(sb.toString());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return actionMapping.findForward("content"); 
	}
}
