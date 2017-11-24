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
    	// 判断CH_ZJTY_PROTOKEN令牌
		ACLDelegate aclDelegate = new ACLDelegate();
		boolean protoken = aclDelegate.checkPermission(user.getOpercode(), "CH_ZJTY_PROTOKEN");
		if (protoken) {
			this.doList(actionMapping, actionForm, request, response, user);
			return actionMapping.findForward("exptotal");
		}
		
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("计件酬金分项业务量数据");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:", format.format(new Date()) });
		export.addOutputProperty("wayname", "合作商");
		export.addOutputProperty("companytype", "公司类别");
		export.addOutputProperty("cityid", "市公司");
		export.addOutputProperty("zjtyname", "自建他营厅名称");
		export.addOutputProperty("qqtxzfh", "全球通新增放号酬金");
		export.addOutputProperty("yffzqqt", "预付费转全球通");
		export.addOutputProperty("dgddtkxs", "动感地带套卡销售酬金");
		export.addOutputProperty("szxtkxs", "神州行套卡销售酬金");
		export.addOutputProperty("czyw", "充值业务酬金");
		export.addOutputProperty("dzzd", "定制终端酬金");
		export.addOutputProperty("zhyw", "综合业务酬金");
		export.addOutputProperty("zzyw", "自助业务酬金");
		export.addOutputProperty("dgddwlk", "动感地带网聊卡、信息机套卡、欢乐在线酬金");
		export.addOutputProperty("jtkdkh", "家庭宽带开户酬金");
		export.addOutputProperty("sjyw", "数据业务酬金");
		export.addOutputProperty("jtyw", "集团业务酬金");
		export.addOutputProperty("dsgsyxzdlyw", "地市公司营销重点类业务酬金");
		export.addOutputProperty("total", "合计");
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
