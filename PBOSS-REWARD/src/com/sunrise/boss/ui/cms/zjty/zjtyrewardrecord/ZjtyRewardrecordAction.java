/**
* auto-generated code
* Tue Feb 28 17:21:47 CST 2012
*/
package com.sunrise.boss.ui.cms.zjty.zjtyrewardrecord;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.zjty.zjtyrewardrecord.persistent.ZjtyRewardrecordVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ZjtyRewardrecordAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public class ZjtyRewardrecordAction extends BaseDelegateAction {
    public ZjtyRewardrecordAction() {
            setVoClass(ZjtyRewardrecordVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "rewardlistid"; 
    }
    
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			ZjtyRewardrecordForm form = (ZjtyRewardrecordForm) actionForm;
			form.set_orderby("rewardlistid");
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
		export.setFileName("�Խ���Ӫ���ɹ���ϸ");
		//export.addOutputProperty("seq", "���");
		//export.addOutputProperty("oprtime", "ҵ����ʱ��", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		//export.addOutputProperty("rewardtype", "�������", CommonExportBean.CODE2NAME, "$CH_BBCREWARDTYPE");
		export.addOutputProperty("rewardlistid","����ֵ");
		export.addOutputProperty("operseq","��Դ���к�");
		export.addOutputProperty("opnid","ҵ�����");
		export.addOutputProperty("opnid","ҵ������", CommonExportBean.CODE2NAME, "#ZJTY_OPERATION");
		export.addOutputProperty("wayid","��������");
		export.addOutputProperty("wayid","��������", CommonExportBean.CODE2NAME, "#WAY");
		export.addOutputProperty("wayoprcode","������");
		export.addOutputProperty("totalsum","������");
		export.addOutputProperty("paysum","֧�����");
		export.addOutputProperty("coef1","������ϵ��");
		export.addOutputProperty("coef2","�ۺ�����ϵ��");
		export.addOutputProperty("coef3","���ϵ��");
		export.addOutputProperty("coef4","�����̾���ϵ��");
		export.addOutputProperty("batchno","�������κ�");
		export.addOutputProperty("runtime","����ʱ��", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("mobile","ҵ��������");
		export.addOutputProperty("oid","��������");
		export.addOutputProperty("ruleid","�������");
		export.addOutputProperty("rewardid","����ʶ");
		export.addOutputProperty("rewardtype","�������", CommonExportBean.CODE2NAME, "$ZJTY_REWARDTYPE");
		export.addOutputProperty("rewardstd","����׼");
		export.addOutputProperty("rewardmonth","�����·�");
		export.addOutputProperty("isbudget","Ԥ����־");
		export.addOutputProperty("paymonth1","һ�ڷ����·�");
		export.addOutputProperty("paymoney1","һ��Ӧ�����");
		export.addOutputProperty("paymonth2","���ڷ����·�");
		export.addOutputProperty("paymoney2","����Ӧ�����");
		export.addOutputProperty("paymonth3","���ڷ����·�");
		export.addOutputProperty("paymoney3","����Ӧ�����");
		export.addOutputProperty("acctype","����귽ʽ");
		export.addOutputProperty("assegrade","����ϵ��");
		export.addOutputProperty("oprtime","ҵ����ʱ��", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("busivalue","ҵ����");
		export.addOutputProperty("rewardflag","�������־");
		export.addOutputProperty("noncyc","��������");
		export.addOutputProperty("bakinfo","IMEI");
		export.addOutputProperty("bakinfo2","��ƷID");
		export.addOutputProperty("bakinfo3","Э���");
		export.addOutputProperty("wrapfee","��ŵ����");
		export.addOutputProperty("adtflag","���˽����ʶ");
		export.addOutputProperty("assegrade2","����ϵ��2");
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
		export.voClassArray = new Class[]{ZjtyRewardrecordVO.class};
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] { "����ֵ",
				"��Դ���к�", "ҵ�����", "ҵ������", "��������", "��������", "������", "������",
				"֧�����", "������ϵ��", "�ۺ�����ϵ��", "���ϵ��", "�����̾���ϵ��", "�������κ�", "����ʱ��",
				"ҵ��������", "��������", "�������", "����ʶ", "�������", "����׼", "�����·�",
				"Ԥ����־", "һ�ڷ����·�", "һ��Ӧ�����", "���ڷ����·�", "����Ӧ�����", "���ڷ����·�",
				"����Ӧ�����", "����귽ʽ", "����ϵ��", "ҵ����ʱ��", "ҵ����", "�������־", "��������",
				"IMEI", "��ƷID", "Э���", "��ŵ����", "���˽����ʶ", "����ϵ��2", "��Ʒ����","��ƷID","��׼��","������","�ն���ʽ","����","ARPUֵ","���ʿͻ�","�ն�����" });
		
		super.ExportQuery(actionMapping, actionForm, request, response,	user, export);
		return actionMapping.findForward(null);
    }
}
