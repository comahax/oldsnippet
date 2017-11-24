/**
* auto-generated code
* Wed Feb 29 11:21:28 CST 2012
*/
package com.sunrise.boss.ui.cms.zjty.zjtyfailrecord;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.zjty.zjtyfailrecord.persistent.ZjtyFailrecordVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ZjtyFailrecordAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public class ZjtyFailrecordAction extends BaseDelegateAction {
    public ZjtyFailrecordAction() {
            setVoClass(ZjtyFailrecordVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
    
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			ZjtyFailrecordForm form = (ZjtyFailrecordForm) actionForm;
			//form.set_se_cityid(user.getCityid());
			form.set_orderby("seq");
	    	return super.doList(actionMapping, actionForm, request, response, user);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return (actionMapping.findForward("list"));
		}
	}
    
    public ActionForward doTxt(ActionMapping actionMapping,
    		ActionForm actionForm, HttpServletRequest request,
    		HttpServletResponse response, User user) throws Exception {
    	CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�Խ���Ӫ���ʧ����ϸ");
		//export.addOutputProperty("seq", "���");
		//export.addOutputProperty("oprtime", "ҵ����ʱ��", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		//export.addOutputProperty("rewardtype","�������", CommonExportBean.CODE2NAME, "$CH_ZJTY_REWARDTYPE");
		export.addOutputProperty("seq","���к�");
		//export.addOutputProperty("srcseq","");
		//export.addOutputProperty("cityid","");
		export.addOutputProperty("opnid","ҵ�����");
		export.addOutputProperty("opnid","ҵ������", CommonExportBean.CODE2NAME, "#ZJTY_OPERATION");
		export.addOutputProperty("wayid","��������");
		export.addOutputProperty("wayid","��������", CommonExportBean.CODE2NAME, "#WAY");
		export.addOutputProperty("oprcode","Ա������");
		export.addOutputProperty("oprtime","����ʱ��", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("mobile","�ֻ�����");
		export.addOutputProperty("busivalue","ҵ����");
		export.addOutputProperty("brand","Ʒ��");
		export.addOutputProperty("creattime","����ʱ��", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		//export.addOutputProperty("src","");
		export.addOutputProperty("ruleid","�������");
		export.addOutputProperty("ruleitemid","����ϸ�����");
		export.addOutputProperty("adtcode","У������");
		export.addOutputProperty("adtremark","У���������");
		export.addOutputProperty("oid","������");
		export.addOutputProperty("noncyc","����");
		export.addOutputProperty("batchno","���κ�");
		export.addOutputProperty("calcopnid","����ҵ�����");
		export.addOutputProperty("calcmonth","�����·�");
		export.addOutputProperty("adtttime","����ʱ��", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("adtflag","���˽����ʶ");
		export.addOutputProperty("rewardtype","�������", CommonExportBean.CODE2NAME, "$ZJTY_REWARDTYPE");
		export.addOutputProperty("bakinfo","IMEI");
		export.addOutputProperty("bakinfo2","��ƷID");
		export.addOutputProperty("bakinfo3","Э���");
		export.addOutputProperty("wrapfee","��ŵ����");
		export.addOutputProperty("bakinfo2","��Ʒ����", CommonExportBean.CODE2NAME, "#IM_PR_COM");
		export.addOutputProperty("prodid","��ƷID");
		export.addOutputProperty("bakinfo4","��׼��");
		export.addOutputProperty("bakinfo5","������");
		export.addOutputProperty("bakinfo6","�ն���ʽ",CommonExportBean.CODE2NAME, "$ZD_SYSTEM"); 
		export.addOutputProperty("bakinfo7","����");
		export.addOutputProperty("bakinfo8","ARPUֵ");
		export.addOutputProperty("bakinfo9","���ʿͻ�");
		export.addOutputProperty("bakinfo10","�ն�����" ,CommonExportBean.CODE2NAME, "$ZD_TYPE");
		
		export.queryMethodName="doList";
		export.voClassArray = new Class[]{ZjtyFailrecordVO.class};
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] {"���к�", 
			"ҵ�����", "ҵ������", "��������", "��������", "Ա������", "����ʱ��", "�ֻ�����",
			"ҵ����", "Ʒ��", "����ʱ��", "�������", "����ϸ�����", "У������", "У���������",
			"������", "����", "���κ�", "����ҵ�����", "�����·�", "����ʱ��", 
			"���˽����ʶ", "�������", "IMEI", "��ƷID", "Э���", "��ŵ����", "��Ʒ����" ,"��ƷID","��׼��","������","�ն���ʽ","����","ARPUֵ","���ʿͻ�","�ն�����" });
		
		super.ExportQuery(actionMapping, actionForm, request, response,	user, export);
		return actionMapping.findForward(null);
    }
}
