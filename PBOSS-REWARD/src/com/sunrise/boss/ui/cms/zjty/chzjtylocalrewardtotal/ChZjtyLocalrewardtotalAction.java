/**
* auto-generated code
* Sat Mar 09 12:11:47 CST 2013
*/
package com.sunrise.boss.ui.cms.zjty.chzjtylocalrewardtotal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.sunrise.boss.business.cms.zjty.chzjtylocalrewardtotal.persistent.ChZjtyLocalrewardtotalListVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalrewardtotal.persistent.ChZjtyLocalrewardtotalVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.cms.zjty.chzjtylocalrewardtotal.ChZjtyLocalrewardtotalDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2NameConfiger;

/**
 * <p>Title: ChZjtyLocalrewardtotalAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChZjtyLocalrewardtotalAction extends BaseAction {
    public ChZjtyLocalrewardtotalAction() {
            setVoClass(ChZjtyLocalrewardtotalVO.class);
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
		
		ChZjtyLocalrewardtotalForm form = (ChZjtyLocalrewardtotalForm) actionForm;
		if (form.isQuery()) {
			ChZjtyLocalrewardtotalListVO listVO = new ChZjtyLocalrewardtotalListVO();
			BeanUtils.copyProperties(listVO, form);
			ChZjtyLocalrewardtotalDelegate delegate = new ChZjtyLocalrewardtotalDelegate();
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
				double gdreward = 0;
				double jjreward = 0;
				double cereward = 0;
				double ywkj = 0;
				double total = 0;
				while(iterator.hasNext()) {
					ChZjtyLocalrewardtotalVO vo = (ChZjtyLocalrewardtotalVO) iterator.next();
					gdreward += vo.getGdreward();
					jjreward += vo.getJjreward();
					cereward  += vo.getCereward();
					ywkj += vo.getYwkj();
					total += vo.getTotal();
				}
				Object[] queryTotal = {gdreward, jjreward, cereward, ywkj, total};
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
		export.setFileName("酬金汇总");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:", format.format(new Date()) });
		export.addOutputProperty("wayname", "合作商");
		export.addOutputProperty("companytype", "公司类别");
		export.addOutputProperty("cityid", "市公司");
		export.addOutputProperty("zjtyname", "自建他营厅名称");
		export.addOutputProperty("wayid", "BOSS渠道编码");
		export.addOutputProperty("gdreward", "固定酬金总额");
		export.addOutputProperty("jjreward", "计件酬金总额");
		export.addOutputProperty("cereward", "超额酬金扣减");
		export.addOutputProperty("ywkj", "业务扣减");
		export.addOutputProperty("total", "酬金总计");
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
