/**
* auto-generated code
* Sat Mar 09 12:02:30 CST 2013
*/
package com.sunrise.boss.ui.cms.zjty.chzjtylocalgdrewardtotal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.sunrise.boss.business.cms.zjty.chzjtylocalgdrewardtotal.persistent.ChZjtyLocalgdrewardtotalListVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalgdrewardtotal.persistent.ChZjtyLocalgdrewardtotalVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.cms.zjty.chzjtylocalgdrewardtotal.ChZjtyLocalgdrewardtotalDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2NameConfiger;

/**
 * <p>Title: ChZjtyLocalgdrewardtotalAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChZjtyLocalgdrewardtotalAction extends BaseAction {
    public ChZjtyLocalgdrewardtotalAction() {
            setVoClass(ChZjtyLocalgdrewardtotalVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "recid"; 
    }
    
    protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	// 判断CH_ZJTY_PROTOKEN令牌
		ACLDelegate aclDelegate = new ACLDelegate();
		boolean protoken = aclDelegate.checkPermission(user.getOpercode(), "CH_ZJTY_PROTOKEN");
		request.setAttribute("protoken", protoken);
		
    	ChZjtyLocalgdrewardtotalForm form = (ChZjtyLocalgdrewardtotalForm) actionForm;
		if (form.isQuery()) {
			ChZjtyLocalgdrewardtotalListVO listVO = new ChZjtyLocalgdrewardtotalListVO();
			BeanUtils.copyProperties(listVO, form);
			ChZjtyLocalgdrewardtotalDelegate delegate = new ChZjtyLocalgdrewardtotalDelegate();
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
				long petotal = 0;
				double gdreward = 0;
				double mgmenoykc = 0;
				double total = 0;
				while(iterator.hasNext()) {
					ChZjtyLocalgdrewardtotalVO vo = (ChZjtyLocalgdrewardtotalVO) iterator.next();
					petotal += vo.getPetotal();
					gdreward += vo.getGdreward();
					mgmenoykc += vo.getMgmenoykc();
					total += vo.getTotal();
				}
				Object[] queryTotal = {petotal, gdreward, mgmenoykc, total};
				request.setAttribute("queryTotal", queryTotal);
			}
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		}
    	return actionMapping.findForward("list");
    }
    
    public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	// 判断CH_ZJTY_PROTOKEN令牌
		ACLDelegate aclDelegate = new ACLDelegate();
		boolean protoken = aclDelegate.checkPermission(user.getOpercode(), "CH_ZJTY_PROTOKEN");
		if (protoken) {
			this.doList(actionMapping, actionForm, request, response, user);
			return actionMapping.findForward("exptotal");
		}
		
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("固定酬金汇总");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:", format.format(new Date()) });
		export.addOutputProperty("wayname", "合作商");
		export.addOutputProperty("companytype", "公司类别");
		export.addOutputProperty("cityid", "市公司");
		export.addOutputProperty("zjtyname", "自建他营厅名称");
		export.addOutputProperty("connecttime", "交接日期", CommonExportBean.DATE, "yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("petotal", "配置人员总计");
		export.addOutputProperty("gdreward", "固定酬金额度");
		export.addOutputProperty("mgmenoykc", "运营管理费用扣除");
		export.addOutputProperty("total", "小计");
		export.addOutputProperty("rewardreporttime", "月份");
		
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
