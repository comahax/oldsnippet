/**
* auto-generated code
* Wed Aug 15 12:26:00 CST 2012
*/
package com.sunrise.boss.ui.cms.dcord;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.adjustment.persistent.AdjustmentListVO;
import com.sunrise.boss.business.cms.dcord.persistent.DcordVO;
import com.sunrise.boss.business.cms.operation.persistent.OperationListVO;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.dcord.persistent.VDcordListVO;
import com.sunrise.boss.business.cms.dcord.persistent.VDcordVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.common.utils.sysinfo.SysInfo;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.admin.operator.OperatorDelegate;
import com.sunrise.boss.delegate.cms.adjustment.AdjustmentDelegate;
import com.sunrise.boss.delegate.cms.cityrecord.CityrecordDelegate;
import com.sunrise.boss.delegate.cms.dcord.DcordDelegate;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.cms.dcord.DcordForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: DcordAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class DcordAction extends BaseAction {
	public static final String CH_ADT_MONITOR_CON ="CH_ADT_MONITOR_CON";//�ֹ�˾������ɼ����зֹ�˾
	public static final String CH_ADT_ADJUST_COUNTY ="CH_ADT_ADJUST_COUNTY";//�ֹ�˾������������ֹ�˾�ɼ�
    public DcordAction() {
            setVoClass(DcordVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "id"; 
    }
    
    /**
     * �״ν���ҳ�治��ѯ
     */
    public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{
    	Page.setPageSize(request, (BaseActionForm) actionForm);
    	request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));  
    	try{
    		this.doCheckpermit(actionForm, user);
    		DcordForm form = (DcordForm)actionForm;
    		form.setSupportPaymonth(this.isSupportPaymonth(user));
    	}catch(BusinessException ex){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.toString());
    	}catch(Exception ex){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
    	}
    	return (actionMapping.findForward("list"));
    }
    
    private void doCheckpermit(ActionForm actionForm, User user)throws Exception{
    	DcordForm form = (DcordForm)actionForm;
    	ACLDelegate acldelegate = new ACLDelegate();    	
    	if(form.getCitypermited()==-1){
			boolean citypermit = acldelegate.checkPermission(user.getOpercode(), CH_ADT_MONITOR_CON);
	    	if(citypermit){
	    		form.setCitypermited(1);
	    	}else{
	    		form.setCitypermited(0);
	    	}
		}
		if(form.getCountypermited()==-1){
			boolean countypermit = acldelegate.checkPermission(user.getOpercode(), CH_ADT_ADJUST_COUNTY);
	    	if(countypermit){
	    		form.setCountypermited(1);
	    		OperatorDelegate odelegate = new OperatorDelegate();
	    		String countyid = odelegate.doQuerycountyid(user.getOpercode(), user);
	    		if(countyid!=null){
	    			form.set_se_countyid(countyid);
	    		}else{
	    			throw new BusinessException(null, "��¼�����޷ֹ�˾��Ϣ");
	    		}
	    	}else{
	    		form.setCountypermited(0);
	    	}
		}
    }
    
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{
    	Page.setPageSize(request, (BaseActionForm) actionForm);
    	try{
    		request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));    		
    		try{
        		this.doCheckpermit(actionForm, user);
        	}catch(BusinessException ex){
        		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.toString());
        	}
        	
        	VDcordListVO listvo = new VDcordListVO();
    		DcordForm form = (DcordForm)actionForm;
    		this.setListVO(listvo, form);
    		
    		List<String> opnids = new ArrayList<String>();
    		if (form.get_se_opnid() != null && !"".equals(form.get_se_opnid())) {
				String[] opnidandnames = form.get_se_opnid().split(",");
				for (int i = 0; i < opnidandnames.length; i++) {
					String[] opnidandname = opnidandnames[i].split("-");
					String opnid = opnidandname[0];
					opnids.add(opnid.trim());
				}				
			}
    		listvo.set_sin_opnid(opnids);
    		if(listvo.get_orderby()==null || listvo.get_orderby().trim().length()==0){
    			listvo.set_orderby("id,wayid,opnid");
    		}    		
    		//listvo.setThreshhold(SysInfo.THRESHHOLD);//���ò�ѯ������ķ�ֵ��С
    		
    		DcordDelegate delegate = new DcordDelegate();
        	DataPackage dp = delegate.doQuery(listvo, user);
        	
        	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
    	}catch(Exception ex){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
    	}    	

    	return (actionMapping.findForward("list"));
    }
    
    public ActionForward doAdjust(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{    	
    	response.setCharacterEncoding("UTF-8");
    	PrintWriter out = response.getWriter();
    	try{
    		Long id = Long.parseLong((String)request.getParameter("id"));
        	String wayid = (String)request.getParameter("wayid");
        	String rewardmonth = (String)request.getParameter("rewardmonth");
        	Short isflag = Short.parseShort((String)request.getParameter("isflag"));       	
        	
        	DcordDelegate dcorddelegate = new DcordDelegate();
        	DcordVO dvo = dcorddelegate.doFindByPk(id, user);
        	
        	//����wayid��rewardmonth���ch_adt_adjustment���Ƿ������ؼ�¼��batchnoΪ�յļ�¼
        	AdjustmentDelegate adjustdegelete = new AdjustmentDelegate();
        	AdjustmentListVO listvo = new AdjustmentListVO();
        	listvo.set_se_rewardmonth(rewardmonth);
        	listvo.set_se_wayid(wayid);
        	listvo.set_sql_batchno(" batchno is null");
        	listvo.set_pagesize("0");
        	
        	SysparamDelegate sysparamDelegate = new SysparamDelegate();
        	SysparamListVO sysparamListVO = new SysparamListVO();
        	sysparamListVO.set_se_paramtype("channel");
        	sysparamListVO.set_ne_systemid("93");
        	DataPackage sysparamDP = sysparamDelegate.doQuery(sysparamListVO, user);
        	if (sysparamDP != null && sysparamDP.getDatas() != null && sysparamDP.getDatas().size() > 0) {
        		SysparamVO sysparamVO = (SysparamVO) sysparamDP.getDatas().iterator().next();
        		if ("1".equals(sysparamVO.getParamvalue())) {
        			listvo.set_se_upperopnid(dvo.getUpperopnid());
        		}
			}
        	
        	DataPackage dp = adjustdegelete.doQuery(listvo, user);
        	if(dp!=null && dp.getDatas().size()>0){
//        		Iterator it = dp.getDatas().iterator();
//        		while(it.hasNext()){
//        			AdjustmentVO vo = (AdjustmentVO)it.next();
//        			if(vo.getBatchno()==null || "".equals(vo.getBatchno().trim())){
        				out.write("��������ǰ�����·���ȷ�ϴ��������,����������ڡ��������ݵ�����������ɾ����������Ѻ˶Լ�¼!");
        				return null;
//        			}
//        		}
        	}
        	//����ISFLAF/ADJUSTOPRCODE/ADJUSTOPTIME
        	if(dvo.getIsflag().shortValue()==isflag.shortValue()){
        		out.write("[����״̬]δ�����仯��������");
        	}else{
        		dvo.setIsflag(isflag);
            	dvo.setAdjustoprcode(user.getOpercode());
            	dvo.setAdjustoptime(new Date());
            	dcorddelegate.doUpdate(dvo, user);
            	
            	CityrecordDelegate cityrecordDelegate = new CityrecordDelegate();
            	cityrecordDelegate.updateIsflagByDcordid(isflag, dvo.getId(), user);
            	
            	out.write("����ɹ�");
        	}        	
    	}catch(Exception ex){
    		ex.printStackTrace();
    		out.write("����ʧ��");
    	}
    	
    	return null;
    }
    
    public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{ 
    	CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("��������ϸ��ѯ");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��:", format.format(new Date()) });
		export.addOutputProperty("id", "���к�");
		export.addOutputProperty("countyid", "�ֹ�˾", export.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("wayid", "��������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel", "�����Ǽ�", export.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("opnid", "ҵ�����");
		export.addOutputProperty("opnid", "ҵ������", export.CODE2NAME, "#OPERATION");
		export.addOutputProperty("upperopnid", "ҵ�����", export.CODE2NAME, "#OPERATION");
		export.addOutputProperty("subopnid", "ҵ��С��", export.CODE2NAME, "#OPERATION");
		export.addOutputProperty("oprmonth", "ҵ������");
		export.addOutputProperty("rewardtype", "�������", export.CODE2NAME, "#REWARDTYPE");
		export.addOutputProperty("rewardmonth", "�����·�");
		export.addOutputProperty("gotonebusivalue","ȫ��ͨҵ����");
		export.addOutputProperty("gotonemoney","ȫ��ͨ�����",export.NUMBER,"0.00");
		export.addOutputProperty("szxbusivalue","������ҵ����");
		export.addOutputProperty("szxmoney","�����г����",export.NUMBER,"0.00");
		export.addOutputProperty("mzonebusivalue","���еش�ҵ����");
		export.addOutputProperty("mzonemoney","���еش������",export.NUMBER,"0.00");
		export.addOutputProperty("tdbusivalue","TDҵ����");
		export.addOutputProperty("tdmoney","TD�����",export.NUMBER,"0.00");
		export.addOutputProperty("otherbusivalue","����ҵ����");
		export.addOutputProperty("othermoney","����ҵ������",export.NUMBER,"0.00");
		export.addOutputProperty("busivaluesum","��ҵ����");
		export.addOutputProperty("moneysum","��ҵ������",export.NUMBER,"0.00");
		export.addOutputProperty("isflag","�����ʶ", export.CODE2NAME, "$CH_ISFLAG");
		export.addOutputProperty("batchno","��������");
		export.addOutputProperty("abatchno","�������κ�");
		if(this.isSupportPaymonth(user)){
			export.addOutputProperty("paymonth", "�����·�");
		}

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);		
		export.voClassArray = new Class[] { VDcordVO.class };
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
    	
    	return null;
    }
    
	public ActionForward doTxt(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{ 
    	CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("��������ϸ��ѯ");
		export.addOutputProperty("id", "���к�");
		export.addOutputProperty("countyid", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("wayid");
		export.addOutputProperty("wayname");
		export.addOutputProperty("starlevel", CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("opnid");
		export.addOutputProperty("opnid", CommonExportBean.CODE2NAME, "#OPERATION");
		export.addOutputProperty("upperopnid", CommonExportBean.CODE2NAME, "#OPERATION");
		export.addOutputProperty("subopnid", CommonExportBean.CODE2NAME, "#OPERATION");
		export.addOutputProperty("oprmonth");
		export.addOutputProperty("rewardtype", CommonExportBean.CODE2NAME, "#REWARDTYPE");
		export.addOutputProperty("rewardmonth");
		export.addOutputProperty("gotonebusivalue");
		export.addOutputProperty("gotonemoney",CommonExportBean.NUMBER,"0.00");
		export.addOutputProperty("szxbusivalue");
		export.addOutputProperty("szxmoney",CommonExportBean.NUMBER,"0.00");
		export.addOutputProperty("mzonebusivalue");
		export.addOutputProperty("mzonemoney",CommonExportBean.NUMBER,"0.00");
		export.addOutputProperty("tdbusivalue");
		export.addOutputProperty("tdmoney",CommonExportBean.NUMBER,"0.00");
		export.addOutputProperty("otherbusivalue");
		export.addOutputProperty("othermoney",CommonExportBean.NUMBER,"0.00");
		export.addOutputProperty("busivaluesum");
		export.addOutputProperty("moneysum",CommonExportBean.NUMBER,"0.00");
		export.addOutputProperty("isflag", CommonExportBean.CODE2NAME, "$CH_ISFLAG");
		export.addOutputProperty("batchno");
		export.addOutputProperty("abatchno");
		String[] title = null;
		if(this.isSupportPaymonth(user)){
			export.addOutputProperty("paymonth");
			title = new String[] {
					"���к�", "�ֹ�˾", "��������", "��������", "�����Ǽ�", "ҵ�����", "ҵ������", "ҵ�����",
					"ҵ��С��", "ҵ������", "�������", "�����·�", "ȫ��ͨҵ����", "ȫ��ͨ�����", "������ҵ����",
					"�����г����", "���еش�ҵ����", "���еش������", "TDҵ����", "TD�����", "����ҵ����",
					"����ҵ������", "��ҵ����", "��ҵ������", "�����ʶ", "��������", "�������κ�","�����·�" };
		}else{
			title = new String[] {
					"���к�", "�ֹ�˾", "��������", "��������", "�����Ǽ�", "ҵ�����", "ҵ������", "ҵ�����",
					"ҵ��С��", "ҵ������", "�������", "�����·�", "ȫ��ͨҵ����", "ȫ��ͨ�����", "������ҵ����",
					"�����г����", "���еش�ҵ����", "���еش������", "TDҵ����", "TD�����", "����ҵ����",
					"����ҵ������", "��ҵ����", "��ҵ������", "�����ʶ", "��������", "�������κ�" };
		}
		export.voClassArray = new Class[] { VDcordVO.class };
		
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(),title );
		super.ExportQuery(actionMapping, actionForm, request, response, user, export);
    	return null;
    }
    
    public ActionForward doLoadsub(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{    	
    	response.setCharacterEncoding("UTF-8");
    	PrintWriter out = response.getWriter();
    	String upperopnid = request.getParameter("upperopnid");
    	try{
    		OperationDelegate operdelegate = new OperationDelegate();
    		OperationListVO listvo = new OperationListVO();
    		listvo.set_se_parentid(upperopnid);
    		listvo.set_ne_opnlevel("2");
    		listvo.set_pagesize("0");
    		DataPackage dp = operdelegate.doQuery(listvo, user);
    		if(dp!=null && dp.getDatas().size()>0){
    			StringBuilder sb = new StringBuilder();
    			Iterator it = dp.getDatas().iterator();
    			OperationVO vo = null;
    			while(it.hasNext()){
    				vo = (OperationVO)it.next();
    				sb.append(vo.getOpnid()+":"+vo.getName()+",");
    			}
    			out.write(sb.toString().substring(0,sb.toString().length()-1));
    		}else{
    			System.out.println("["+upperopnid+"]��������ض���ҵ�����");
    			out.write("");
    		}
    	}catch(Exception ex){
    		System.out.println("["+upperopnid+"]���ض���ҵ������쳣�˳�");
    		ex.printStackTrace();
    		out.write("");
    	}
    	
    	return null;
    }
    
    public ActionForward doBatch(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return actionMapping.findForward("batch");
	}
    
    //�Ƿ�֧�ָ����·�
    public boolean isSupportPaymonth(User user) throws Exception{
    	SysparamDelegate sysparamDelegate = new SysparamDelegate();
		String value = sysparamDelegate.doFindByID(95L, "channel", user);
		if(value!=null){
			if("1".equals(value)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;//������ϵͳ����������Ϊ��
		}
    }  
}
