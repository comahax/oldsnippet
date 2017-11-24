/**
* auto-generated code
* Sat Mar 09 12:10:59 CST 2013
*/
package com.sunrise.boss.ui.cms.zjty.chzjtylocalrewardbusiness;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.sunrise.boss.business.cms.zjty.chzjtylocalrewardbusiness.persistent.ChZjtyLocalrewardbusinessListVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalrewardbusiness.persistent.ChZjtyLocalrewardbusinessVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.cms.zjty.chzjtylocalrewardbusiness.ChZjtyLocalrewardbusinessDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2NameConfiger;

/**
 * <p>Title: ChZjtyLocalrewardbusinessAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChZjtyLocalrewardbusinessAction extends BaseAction {
    public ChZjtyLocalrewardbusinessAction() {
            setVoClass(ChZjtyLocalrewardbusinessVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "recid"; 
    }
    
    protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	// �ж�CH_ZJTY_PROTOKEN����
		ACLDelegate aclDelegate = new ACLDelegate();
		boolean protoken = aclDelegate.checkPermission(user.getOpercode(), "CH_ZJTY_PROTOKEN");
		request.setAttribute("protoken", protoken);
		
    	ChZjtyLocalrewardbusinessForm form = (ChZjtyLocalrewardbusinessForm) actionForm;
		if (form.isQuery()) {
			ChZjtyLocalrewardbusinessListVO listVO = new ChZjtyLocalrewardbusinessListVO();
			BeanUtils.copyProperties(listVO, form);
			ChZjtyLocalrewardbusinessDelegate delegate = new ChZjtyLocalrewardbusinessDelegate();
			DataPackage dp = new DataPackage();
			if (!protoken) {
				String cityid = user.getCityid();
				String _sk_cityid = Code2NameConfiger.getName("CITYIDNUM2NMAME", cityid, cityid).toString();
				listVO.set_sk_cityid(_sk_cityid);
				dp = delegate.doQuery(listVO, user);
			} else {
				listVO.set_pagesize("100");
				dp = delegate.doQueryTotal(listVO, user);
				Iterator iterator = dp.getDatas().iterator();
				double qqtxzfh = 0;
				double yffzqqt = 0;
				double dgddtkxs = 0;
				double szxtkxs = 0;
				double czyw = 0;
				double dzzd = 0;
				double zhyw = 0;
				double zzyw = 0;
				double dgddwlk = 0;
				double jtkdkh = 0;
				double sjyw = 0;
				double jtyw = 0;
				double dsgsyxzdlyw = 0;
				double total = 0;
				while(iterator.hasNext()) {
					ChZjtyLocalrewardbusinessVO vo = (ChZjtyLocalrewardbusinessVO) iterator.next();
					qqtxzfh += vo.getQqtxzfh();
					yffzqqt += vo.getYffzqqt();
					dgddtkxs += vo.getDgddtkxs();
					szxtkxs += vo.getSzxtkxs();
					czyw += vo.getCzyw();
					dzzd += vo.getDzzd();
					zhyw += vo.getZhyw();
					zzyw += vo.getZzyw();
					dgddwlk += vo.getDgddwlk();
					jtkdkh += vo.getJtkdkh();
					sjyw += vo.getSjyw();
					jtyw += vo.getJtyw();
					dsgsyxzdlyw += vo.getDsgsyxzdlyw();
					total += vo.getTotal();
				}
				Object[] queryTotal = { qqtxzfh, yffzqqt, dgddtkxs, szxtkxs, czyw, 
					dzzd, zhyw, zzyw, dgddwlk, jtkdkh, sjyw, jtyw, dsgsyxzdlyw, total };
				request.setAttribute("queryTotal", queryTotal);
			}
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		}
		return actionMapping.findForward("list");
	}
    
    public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	// �ж�CH_ZJTY_PROTOKEN����
		ACLDelegate aclDelegate = new ACLDelegate();
		boolean protoken = aclDelegate.checkPermission(user.getOpercode(), "CH_ZJTY_PROTOKEN");
		if (protoken) {
			this.doList(actionMapping, actionForm, request, response, user);
			return actionMapping.findForward("exptotal");
		}
		
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�Ƽ�������ҵ��������");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��:", format.format(new Date()) });
		export.addOutputProperty("wayname", "������");
		export.addOutputProperty("companytype", "��˾���");
		export.addOutputProperty("cityid", "�й�˾");
		export.addOutputProperty("zjtyname", "�Խ���Ӫ������");
		export.addOutputProperty("qqtxzfh", "ȫ��ͨ�����źų��");
		export.addOutputProperty("yffzqqt", "Ԥ����תȫ��ͨ");
		export.addOutputProperty("dgddtkxs", "���еش��׿����۳��");
		export.addOutputProperty("szxtkxs", "�������׿����۳��");
		export.addOutputProperty("czyw", "��ֵҵ����");
		export.addOutputProperty("dzzd", "�����ն˳��");
		export.addOutputProperty("zhyw", "�ۺ�ҵ����");
		export.addOutputProperty("zzyw", "����ҵ����");
		export.addOutputProperty("dgddwlk", "���еش����Ŀ�����Ϣ���׿����������߳��");
		export.addOutputProperty("jtkdkh", "��ͥ����������");
		export.addOutputProperty("sjyw", "����ҵ����");
		export.addOutputProperty("jtyw", "����ҵ����");
		export.addOutputProperty("dsgsyxzdlyw", "���й�˾Ӫ���ص���ҵ����");
		export.addOutputProperty("total", "�ϼ�");
		export.addOutputProperty("rewardreporttime", "�·�");
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		export.voClassArray = new Class[] {voClass};
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
    	return null;
	}
}
