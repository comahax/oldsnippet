/**
* auto-generated code
* Thu Feb 25 14:28:35 CST 2010
*/
package com.sunrise.boss.ui.cms.bbc.hdnetsales;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.bbc.hdnetsales.persistent.HdnetsalesListVO;
import com.sunrise.boss.business.cms.bbc.hdnetsales.persistent.HdnetsalesVO;
import com.sunrise.boss.business.cms.bbc.operation.persistent.BBCoperationListVO;
import com.sunrise.boss.business.cms.bbc.operation.persistent.BBCoperationVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.bbc.hdnetsales.HdnetsalesDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: hdnetsalesAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class HdnetsalesAction extends BaseAction {
    public HdnetsalesAction() {
            setVoClass(HdnetsalesVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
    
	/**
	 * ��ѯ
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			Page.setPageSize(request, (BaseActionForm) actionForm);
			HdnetsalesListVO listvo = new HdnetsalesListVO();
			setListVO(listvo, actionForm); // ���ú�listVO����Ϊ��ѯ����
			HdnetsalesDelegate delegate = new HdnetsalesDelegate();
			
			//���ϲ�ѯ
			BBCoperationListVO listvo2 = new BBCoperationListVO();
			setListVO(listvo2, actionForm); // ���ú�listVO����Ϊ��ѯ����
			
			Class[] clazz = new Class[]{HdnetsalesVO.class,BBCoperationVO.class};
			Object[] params = new Object[] { listvo, listvo2 };
			String[][] joins = new String[][] { { "opnid", "opnid" } };
			
			DataPackage dp = delegate.doQuery2(params, clazz, joins, user);
			List unionList = (List) dp.getDatas();
			
			List hdnetsalesList = new ArrayList();
			for(int i=0; i<unionList.size(); i++)
			{
				Object[] objs = (Object[])unionList.get(i);
				HdnetsalesVO hdnetsalesVO = (HdnetsalesVO)objs[0];
				hdnetsalesList.add(hdnetsalesVO);
			}
			
			//ҳ���б���ʾ
			dp.setDatas(hdnetsalesList);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} catch (Exception e) {
			throw e;
		}
		return (actionMapping.findForward("list"));
	}
    
    public ActionForward doTxt(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�϶���ҵ�������Ϣ");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��",format.format(new Date(System.currentTimeMillis())) });
		export.addOutputProperty("seq", "��ˮ��");
		export.addOutputProperty("srcseq", "Դ������ˮ");
		export.addOutputProperty("ruleid", "У�����");
		export.addOutputProperty("opnid", "����ҵ�����");
		export.addOutputProperty("calcmonth", "�����·�");
		export.addOutputProperty("wayid", "ҵ��������");
		export.addOutputProperty("oprtime", "ҵ����ʱ��", CommonExportBean.DATE, "yyyy-MM-dd");
		export.addOutputProperty("oprcode", "ҵ��������");
		export.addOutputProperty("mobile", "ҵ��������");
		//export.addOutputProperty("opnid", "��Ա����", CommonExportBean.CODE2NAME, "$CH_ISNET");
		
		export.voClassArray = new Class[] { HdnetsalesVO.class };
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] {
				"��ˮ��", "Դ������ˮ", "У�����", "����ҵ�����", "�����·�", "ҵ��������", "ҵ����ʱ��", "ҵ��������", "ҵ��������"});
		
		super.ExportQuery(actionMapping, actionForm, request, response, user, export);
		return actionMapping.findForward(null);
	}
}
