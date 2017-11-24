/**
* auto-generated code
* Sat Mar 09 12:08:48 CST 2013
*/
package com.sunrise.boss.ui.cms.zjty.chzjtylocalperconfigdetail;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigdetail.persistent.ChZjtyLocalperconfigdetailListVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigdetail.persistent.ChZjtyLocalperconfigdetailVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.zjty.chzjtylocalperconfigdetail.ChZjtyLocalperconfigdetailDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2NameConfiger;

/**
 * <p>Title: ChZjtyLocalperconfigdetailAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChZjtyLocalperconfigdetailAction extends BaseAction {
    public ChZjtyLocalperconfigdetailAction() {
            setVoClass(ChZjtyLocalperconfigdetailVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "recid"; 
    }
    
    protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	ChZjtyLocalperconfigdetailForm form = (ChZjtyLocalperconfigdetailForm) actionForm;
		if (form.isQuery()) {
			String cityid = user.getCityid();
			String _sk_cityid = Code2NameConfiger.getName("CITYIDNUM2NMAME", cityid, cityid).toString();
			form.set_sk_cityid(_sk_cityid);
			ChZjtyLocalperconfigdetailListVO listVO = new ChZjtyLocalperconfigdetailListVO();
			BeanUtils.copyProperties(listVO, form);
			ChZjtyLocalperconfigdetailDelegate delegate = new ChZjtyLocalperconfigdetailDelegate();
			DataPackage dp = delegate.doQuery(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		}
		return actionMapping.findForward("list");
	}
    
    public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("人员配置明细");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:", format.format(new Date()) });
		export.addOutputProperty("upperwayname", "所属合作商");
		export.addOutputProperty("cityid", "市公司");
		export.addOutputProperty("countyid", "分公司");
		export.addOutputProperty("wayid", "渠道编码");
		export.addOutputProperty("wayname", "渠道名称");
		export.addOutputProperty("zjtypersonname", "姓名");
		export.addOutputProperty("station", "职位");
		export.addOutputProperty("oprcode", "BOSS工号");
		export.addOutputProperty("regdate", "工号开通时间", CommonExportBean.DATE, "yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("certification", "认证情况");
		export.addOutputProperty("tel", "联系电话");
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
