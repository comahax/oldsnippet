/**
* auto-generated code
* Mon Dec 08 10:50:04 CST 2008
*/
package com.sunrise.boss.ui.cms.bbc.bbcfaildataquery;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.bbc.bbcfaildataquery.persistent.BbcFaildataqueryVO;
import com.sunrise.boss.business.cms.reward.adtcode.persistent.AdtcodeListVO;
import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.reward.adtcode.AdtcodeDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: BbcFaildataqueryAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: SUNRISE Tech Ltd.</p>
 * @author Li Zhaoliang
 * @version 1.0
 */
public class BbcFaildataqueryAction extends BaseDelegateAction {
    public BbcFaildataqueryAction() {
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(BbcFaildataqueryVO.class);
            //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
    
    public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	BbcFaildataqueryForm form = (BbcFaildataqueryForm) actionForm;
    	//form.set_pagesize("300");
    	form.set_se_rewardtype("9");
    	super.doList(actionMapping, actionForm, request, response, user);
		return actionMapping.findForward("list");
    }
    
    /**
     * ʧ��ԭ���ѯ������
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @param user
     * @return
     * @throws Exception
     */
    public ActionForward doSelect(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	BbcFaildataqueryForm form = (BbcFaildataqueryForm) actionForm;
    	String adttype = request.getParameter("adttype");
    	
    	AdtcodeListVO adtlistvo = new AdtcodeListVO();
    	try {
			Page.setPageSize(request, form);
			setListVO(adtlistvo, form); // ���ú�listVO����Ϊ��ѯ����
			if(StringUtils.isNotEmpty(adttype)){
				ArrayList list = new ArrayList();
				list.add("COMM");
				list.add(adttype);
				adtlistvo.set_sin_adttype(list);
			}
			AdtcodeDelegate delegate = new AdtcodeDelegate();
			DataPackage dp = delegate.doQuery(adtlistvo, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return (actionMapping.findForward("select"));
	}
    
    public ActionForward doTxt(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("B2M��վ�����Ч��У��ʧ�����ݲ�ѯ");
		
		export.addOutputProperty("seq");
		export.addOutputProperty("rewardtype");
		export.addOutputProperty("calcmonth");
		export.addOutputProperty("opnid");
//		export.addOutputProperty("name");
		export.addOutputProperty("opnid", CommonExportBean.CODE2NAME,	"#BBC_OPERATION");
		export.addOutputProperty("wayid");
		export.addOutputProperty("wayname");
		export.addOutputProperty("oprcode");
		export.addOutputProperty("mobile");
		export.addOutputProperty("oprtime", CommonExportBean.DATE,"yyyy-MM-dd");
		export.addOutputProperty("creattime", CommonExportBean.DATE,"yyyy-MM-dd");
		export.addOutputProperty("ruleid");
		export.addOutputProperty("adtflag", CommonExportBean.CODE2NAME,	"#CH_ADTFLAG");
		export.addOutputProperty("adtcode");
		export.addOutputProperty("adtremark");
		export.addOutputProperty("ossrc", CommonExportBean.CODE2NAME,"#CH_BBC_OSSRC");
		export.addOutputProperty("batchno");

		export.voClassArray = new Class[] { BbcFaildataqueryVO.class };
		export.queryMethodName="doQueryexport";
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] {
			"��ˮ��","�������","�����·�","ȫʡҵ�����","ҵ������","ҵ������������","ҵ������������","ҵ��������","ҵ�����ֻ���","ҵ����ʱ��","У��ʱ��","У��������","У����","ʧ��ԭ�����","ʧ��ԭ��","ҵ��ƽ̨��Դ","���κ�"});
		
		BaseActionForm baseActionForm = (BaseActionForm) actionForm;
		baseActionForm.set_orderby("seq");
		super.ExportQuery(actionMapping, actionForm, request, response, user,
				export);
		return actionMapping.findForward(null);
	}
    /**
	 * ����ΪEXCEL��ʽ��
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("B2M��վ�����Ч��У��ʧ�����ݲ�ѯ");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
		export.addOutputProperty("seq","��ˮ��");
		export.addOutputProperty("rewardtype","�������");
		export.addOutputProperty("calcmonth","�����·�");
		export.addOutputProperty("opnid","ȫʡҵ�����");
//		export.addOutputProperty("name","ҵ������");
		export.addOutputProperty("opnid","ҵ������", CommonExportBean.CODE2NAME,	"#BBC_OPERATION");
		export.addOutputProperty("wayid","ҵ������������");
		export.addOutputProperty("wayname","ҵ������������");
		export.addOutputProperty("oprcode","ҵ��������");
		export.addOutputProperty("mobile","ҵ�����ֻ���");
		export.addOutputProperty("oprtime","ҵ����ʱ��",CommonExportBean.DATE,"yyyy-MM-dd");
		export.addOutputProperty("creattime","У��ʱ��",CommonExportBean.DATE,"yyyy-MM-dd");
		export.addOutputProperty("ruleid","У��������");
		export.addOutputProperty("adtflag","У����", CommonExportBean.CODE2NAME,	"#CH_ADTFLAG");
		export.addOutputProperty("adtcode","ʧ��ԭ�����");
		export.addOutputProperty("adtremark","ʧ��ԭ��");
		export.addOutputProperty("ossrc","ҵ��ƽ̨��Դ", CommonExportBean.CODE2NAME,"#CH_BBC_OSSRC");
		export.addOutputProperty("batchno","���κ�");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		
		BaseActionForm baseActionForm = (BaseActionForm) actionForm;
		baseActionForm.set_orderby("seq");
//		return super
//				.doExcel(actionMapping, actionForm, request, response, user);
		export.voClassArray = new Class[] { voClass };
		export.queryMethodName = "doQueryexport";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
		return actionMapping.findForward(null);
	}
	public ActionForward doQueryexport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
        	Page.setPageSize(request, (BaseActionForm) actionForm);        	
        	BaseListVO listVO = getListVO(); 
        	setListVO(listVO, actionForm); //���ú�listVO����Ϊ��ѯ����
        	
        	Object delegate = getDelegate();
            
            String methodName = "doQuery2";
            DataPackage pack = (DataPackage)invokeDelegateMethod(delegate,methodName,new Object[]{listVO, user});
            request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
        }catch(BusinessException e) {
        	 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
        }catch(Exception e) {
        	throw e;
        } 
		return actionMapping.findForward(null);
	} 
}
