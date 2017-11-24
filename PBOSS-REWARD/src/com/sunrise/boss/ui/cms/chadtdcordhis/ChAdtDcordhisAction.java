/**
* auto-generated code
* Tue Aug 21 12:28:54 CST 2012
*/
package com.sunrise.boss.ui.cms.chadtdcordhis;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.chadtdcordhis.persistent.ChAdtDcordhisListVO;
import com.sunrise.boss.business.cms.chadtdcordhis.persistent.ChAdtDcordhisVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.chadtdcordhis.ChAdtDcordhisDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ChAdtDcordhisAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChAdtDcordhisAction extends BaseAction {
    public ChAdtDcordhisAction() {
            setVoClass(ChAdtDcordhisVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "id"; 
    }
    /**
	 * �����ϸ��ʷ���ݲ�ѯ
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		long starttime = System.currentTimeMillis();
		Page.setPageSize(request, (BaseActionForm) actionForm);
		try{
			ChAdtDcordhisListVO listVO = new ChAdtDcordhisListVO();
			ChAdtDcordhisForm chadtDcordhisForm = (ChAdtDcordhisForm) actionForm;
			setListVO(listVO, chadtDcordhisForm);

			if (chadtDcordhisForm.get_sin_opnid() != null && !"".equals(chadtDcordhisForm.get_sin_opnid())) {
				String _sin_opnid = "";
				String[] opnidandnames = chadtDcordhisForm.get_sin_opnid().split(",");
				for (int i = 0; i < opnidandnames.length; i++) {
					String[] opnidandname = opnidandnames[i].split("-");
					String opnid = opnidandname[0];
					_sin_opnid += "'" + opnid.trim() + "',";
				}
				_sin_opnid = _sin_opnid.substring(0, _sin_opnid.length() - 1);
                listVO.set_sql_opnid("opnid in ("+_sin_opnid+")");
                listVO.set_sin_opnid(""); 
			}
			if (null!= chadtDcordhisForm.get_se_oprmonth() && !"".equals(chadtDcordhisForm.get_se_oprmonth())) {
				listVO.set_sql_oprtime("to_char(oprtime,'yyyyMM')="+chadtDcordhisForm.get_se_oprmonth());
				listVO.set_se_oprmonth("");
			}
			 ChAdtDcordhisDelegate delegate = new ChAdtDcordhisDelegate();
			DataPackage pack = delegate.doQuery(listVO, user);
			if (pack.getRowCount() > 100000){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"�����ӹ�������,һ���Բ�ѯ������ܳ���10��");
			}else{ 
			   request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
			}
			
		}catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
		} catch (Exception e) {
			throw e;
		}
		long interval = System.currentTimeMillis()-starttime;
		System.out.println("ͳ�Ʋ�ѯ��ʱ��"+interval);
		return (actionMapping.findForward("list"));
	}

    
    
	public ActionForward doTxt(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�����ϸ��ʷ���ݲ�ѯ");  
		export.addOutputProperty("recordid");
		export.addOutputProperty("isflag",CommonExportBean.CODE2NAME,"#ISFLAG");
		export.addOutputProperty("opnid");
		export.addOutputProperty("wayid");
		export.addOutputProperty("wayid",CommonExportBean.CODE2NAME,"#WAY");
		export.addOutputProperty("rewardtype",CommonExportBean.CODE2NAME,"$CH_REWARDTYPE");
		export.addOutputProperty("rewardmonth",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("oprtime",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("mobile"); 
		export.addOutputProperty("brand"); 
		export.addOutputProperty("busivalue"); 
		export.addOutputProperty("paysum");
		export.addOutputProperty("paymoney");
		export.addOutputProperty("oprcode"); 
		export.addOutputProperty("optime",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("systemflag",CommonExportBean.CODE2NAME,"#SYSTEMFLAG"); 
		export.addOutputProperty("accountoprcode");
		export.addOutputProperty("accountoptime",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("adjustoprcode");
		export.addOutputProperty("adjustoptime",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("rewardlistid");
		export.addOutputProperty("taskid");
		export.addOutputProperty("batchno");  
		export.voClassArray = new Class[] { ChAdtDcordhisVO.class };
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] {
				"�����ϸ��ʶ", "������־", "ҵ�����","ҵ���������", "������ʶ","��������", "�������", "�����·�", "ҵ����ʱ��", "�ֻ������IMEI��","Ʒ��",
				"ҵ������ҵ�������", "Ӧ�����ϼ�", "����Ӧ�����", "�ϴ��򷢲�����", "�ѷ���ʱ��", "ȷ�Ϲ���","������������","��������ʱ��","ԭ�����ϸID","�ļ������","��������"});
		super.ExportQuery(actionMapping, actionForm, request, response, user,
				export);
		return actionMapping.findForward(null);
	}
}
