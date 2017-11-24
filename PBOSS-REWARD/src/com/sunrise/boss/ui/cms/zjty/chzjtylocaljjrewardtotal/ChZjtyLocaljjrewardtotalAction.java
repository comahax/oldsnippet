/**
* auto-generated code
* Sat Mar 09 12:07:52 CST 2013
*/
package com.sunrise.boss.ui.cms.zjty.chzjtylocaljjrewardtotal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.sunrise.boss.business.cms.zjty.chzjtylocaljjrewardtotal.persistent.ChZjtyLocaljjrewardtotalListVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocaljjrewardtotal.persistent.ChZjtyLocaljjrewardtotalVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.cms.zjty.chzjtylocaljjrewardtotal.ChZjtyLocaljjrewardtotalDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2NameConfiger;

/**
 * <p>Title: ChZjtyLocaljjrewardtotalAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChZjtyLocaljjrewardtotalAction extends BaseAction {
    public ChZjtyLocaljjrewardtotalAction() {
            setVoClass(ChZjtyLocaljjrewardtotalVO.class);
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
		
    	ChZjtyLocaljjrewardtotalForm form = (ChZjtyLocaljjrewardtotalForm) actionForm;
		if (form.isQuery()) {
			ChZjtyLocaljjrewardtotalListVO listVO = new ChZjtyLocaljjrewardtotalListVO();
			BeanUtils.copyProperties(listVO, form);
			ChZjtyLocaljjrewardtotalDelegate delegate = new ChZjtyLocaljjrewardtotalDelegate();
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
				double qqtxzfhcj = 0;
				double yffzqqtcj = 0;
				double dgddtkxscj = 0;
				double szxtkxscj = 0;
				double czywcj = 0;
				double dzzdcj = 0;
				double zhywcj = 0;
				double zzywcj = 0;
				double dgddwlk = 0;
				double jtkdkhcj = 0;
				double sjywcj = 0;
				double jtywcj = 0;
				double dsgsyxzd = 0;
				double qqtffcjkj = 0;
				double total = 0;
				while(iterator.hasNext()) {
					ChZjtyLocaljjrewardtotalVO vo = (ChZjtyLocaljjrewardtotalVO) iterator.next();
					qqtxzfhcj += vo.getQqtxzfhcj();
					yffzqqtcj += vo.getYffzqqtcj();
					dgddtkxscj += vo.getDgddtkxscj();
					szxtkxscj += vo.getSzxtkxscj();
					czywcj += vo.getCzywcj();
					dzzdcj += vo.getDzzdcj();
					zhywcj += vo.getZhywcj();
					zzywcj += vo.getZzywcj();
					dgddwlk += vo.getDgddwlk();
					jtkdkhcj += vo.getJtkdkhcj();
					sjywcj += vo.getSjywcj();
					jtywcj += vo.getJtywcj();
					dsgsyxzd += vo.getDsgsyxzd();
					qqtffcjkj += vo.getQqtffcjkj();
					total += vo.getTotal();
				}
				Object[] queryTotal = {qqtxzfhcj, yffzqqtcj, dgddtkxscj, szxtkxscj, 
						czywcj, dzzdcj, zhywcj, zzywcj, dgddwlk, jtkdkhcj, sjywcj, 
						jtywcj, dsgsyxzd, qqtffcjkj, total};
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
		export.setFileName("�Ƽ����������");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��:", format.format(new Date()) });
		export.addOutputProperty("wayname", "������");
		export.addOutputProperty("companytype", "��˾���");
		export.addOutputProperty("cityid", "�й�˾");
		export.addOutputProperty("zjtywayname", "�Խ���Ӫ������");
		export.addOutputProperty("qqtxzfhcj", "ȫ��ͨ�����źų��");
		export.addOutputProperty("yffzqqtcj", "Ԥ����תȫ��ͨ���");
		export.addOutputProperty("dgddtkxscj", "���еش��׿����۳��");
		export.addOutputProperty("szxtkxscj", "�������׿����۳��");
		export.addOutputProperty("czywcj", "��ֵҵ����");
		export.addOutputProperty("dzzdcj", "�����ն˳��");
		export.addOutputProperty("zhywcj", "�ۺ�ҵ����");
		export.addOutputProperty("zzywcj", "����ҵ����");
		export.addOutputProperty("dgddwlk", "���еش����Ŀ�����Ϣ���׿����������߳��");
		export.addOutputProperty("jtkdkhcj", "��ͥ����������");
		export.addOutputProperty("sjywcj", "����ҵ����");
		export.addOutputProperty("jtywcj", "����ҵ����");
		export.addOutputProperty("dsgsyxzd", "���й�˾Ӫ���ص���ҵ����");
		export.addOutputProperty("qqtffcjkj", "ȫ��ͨ�źų��ۼ�");
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
