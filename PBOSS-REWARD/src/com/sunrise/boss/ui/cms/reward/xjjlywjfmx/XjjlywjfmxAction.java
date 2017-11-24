/**
* auto-generated code
* Thu Mar 15 09:32:40 CST 2012
*/
package com.sunrise.boss.ui.cms.reward.xjjlywjfmx;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.reward.xjjlywjfmx.persistent.XjjlywjfmxListVO;
import com.sunrise.boss.business.cms.reward.xjjlywjfmx.persistent.XjjlywjfmxVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.reward.xjjlywjfmx.XjjlywjfmxDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: XjjlywjfmxAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class XjjlywjfmxAction extends BaseAction {
    public XjjlywjfmxAction() {
            setVoClass(XjjlywjfmxVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[3]; 
           pkNameArray[0] = "busivalue"; 
           pkNameArray[1] = "flag"; 
           pkNameArray[2] = "wayid"; 
    }
    
public ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception{		
    	
    	XjjlywjfmxDelegate ywjfbbDelegate=new XjjlywjfmxDelegate();
    	XjjlywjfmxListVO ywjfbbListVO =new XjjlywjfmxListVO();
    	XjjlywjfmxForm ywjfbbForm=(XjjlywjfmxForm)actionForm;
    	BeanUtils.copyProperties(ywjfbbListVO, ywjfbbForm);
    	DataPackage dp=ywjfbbDelegate.doQuery(ywjfbbListVO, user);
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("list"));
    	
    }
    
    /**
	 * ����Excel�ļ�
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("ҵ����ֽ�����ϸ��");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��:",format.format(new Date()) });
		export.addOutputProperty("countycompid", "�ֹ�˾");
		export.addOutputProperty("chainhead", "������/�����̼�");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel", "�Ǽ�",export.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("calcmonth", "�����·�");
		export.addOutputProperty("dzzd", "3Gҵ�����");
		export.addOutputProperty("sr", "����������ҵ�����");
		export.addOutputProperty("fsr", "������������ҵ�����");
		export.addOutputProperty("czjf", "��ֵ�ɷѽ��");
		export.addOutputProperty("yckb", "Ԥ������ҵ�����");
		export.addOutputProperty("jtdh", "��ͥ�̺�������");
		export.addOutputProperty("dhjq", "�̺ż�Ⱥ������");
		export.addOutputProperty("lxw", "����������������");
		export.addOutputProperty("ajh", "A+�ƻ�����");
		export.addOutputProperty("creditaccount", "ҵ���ܻ���");
		export.addOutputProperty("paysum", "ҵ����ֽ���");
					
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		
		export.voClassArray = new Class[] { voClass };
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
		
		return actionMapping.findForward(null);
	}
    
}
