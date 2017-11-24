/**
* auto-generated code
* Sat Mar 09 12:12:34 CST 2013
*/
package com.sunrise.boss.ui.cms.zjty.chzjtylocalzdsalereward;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.sunrise.boss.business.cms.zjty.chzjtylocalzdsalereward.persistent.ChZjtyLocalzdsalerewardListVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalzdsalereward.persistent.ChZjtyLocalzdsalerewardVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.cms.zjty.chzjtylocalzdsalereward.ChZjtyLocalzdsalerewardDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2NameConfiger;

/**
 * <p>Title: ChZjtyLocalzdsalerewardAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChZjtyLocalzdsalerewardAction extends BaseAction {
    public ChZjtyLocalzdsalerewardAction() {
            setVoClass(ChZjtyLocalzdsalerewardVO.class);
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
		
    	ChZjtyLocalzdsalerewardForm form = (ChZjtyLocalzdsalerewardForm) actionForm;
		if (form.isQuery()) {
			ChZjtyLocalzdsalerewardListVO listVO = new ChZjtyLocalzdsalerewardListVO();
			BeanUtils.copyProperties(listVO, form);
			ChZjtyLocalzdsalerewardDelegate delegate = new ChZjtyLocalzdsalerewardDelegate();
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
				double dzzdxlhyj = 0;
				double dzzdxllhy = 0;
				double dzzdxllj = 0;
				double dzzdxlhj = 0;
				double ysrgdzzdxlhyj = 0;
				double ysrgdzzdxllhy = 0;
				double ysrgdzzdxllj = 0;
				double ysrgdzzdxlhj = 0;
				double dzzdcjhyj = 0;
				double dzzdcjlhy = 0;
				double dzzdcjlj = 0;
				double dzzdcjhj = 0;
				double ysrgdzzdcjhyj = 0;
				double ysrgdzzdcjlhy = 0;
				double ysrgdzzdcjlj = 0;
				double ysrgdzzdcjhj = 0;
				while(iterator.hasNext()) {
					ChZjtyLocalzdsalerewardVO vo = (ChZjtyLocalzdsalerewardVO) iterator.next();
					dzzdxlhyj += vo.getDzzdxlhyj();
					dzzdxllhy += vo.getDzzdxllhy();
					dzzdxllj += vo.getDzzdxllj();
					dzzdxlhj += vo.getDzzdxlhj();
					ysrgdzzdxlhyj += vo.getYsrgdzzdxlhyj();
					ysrgdzzdxllhy += vo.getYsrgdzzdxllhy();
					ysrgdzzdxllj += vo.getYsrgdzzdxllj();
					ysrgdzzdxlhj += vo.getYsrgdzzdxlhj();
					dzzdcjhyj += vo.getDzzdcjhyj();
					dzzdcjlhy += vo.getDzzdcjlhy();
					dzzdcjlj += vo.getDzzdcjlj();
					dzzdcjhj += vo.getDzzdcjhj();
					ysrgdzzdcjhyj += vo.getYsrgdzzdcjhyj();
					ysrgdzzdcjlhy += vo.getYsrgdzzdcjlhy();
					ysrgdzzdcjlj += vo.getYsrgdzzdcjlj();
					ysrgdzzdcjhj += vo.getYsrgdzzdcjhj();
				}
				Object[] queryTotal = {dzzdxlhyj, dzzdxllhy, dzzdxllj, dzzdxlhj, ysrgdzzdxlhyj, 
						ysrgdzzdxllhy, ysrgdzzdxllj, ysrgdzzdxlhj, dzzdcjhyj, dzzdcjlhy, dzzdcjlj, 
						dzzdcjhj, ysrgdzzdcjhyj, ysrgdzzdcjlhy, ysrgdzzdcjlj, ysrgdzzdcjhj};
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
		export.setFileName("终端销量及酬金");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:", format.format(new Date()) });
		export.addOutputProperty("wayname", "合作商");
		export.addOutputProperty("cityid", "地市");
		export.addOutputProperty("zjtyname", "营业厅名称");
		export.addOutputProperty("dzzdxlhyj", "定制终端销量合约机");
		export.addOutputProperty("dzzdxllhy", "定制终端销量零合约");
		export.addOutputProperty("dzzdxllj", "定制终端销量裸机");
		export.addOutputProperty("dzzdxlhj", "定制终端销量合计");
		export.addOutputProperty("ysrgdzzdxlhyj", "引商入柜定制终端销量合约机");
		export.addOutputProperty("ysrgdzzdxllhy", "引商入柜定制终端销量零合约");
		export.addOutputProperty("ysrgdzzdxllj", "引商入柜定制终端销量裸机");
		export.addOutputProperty("ysrgdzzdxlhj", "引商入柜定制终端销量合计");
		export.addOutputProperty("dzzdcjhyj", "定制终端酬金合约机");
		export.addOutputProperty("dzzdcjlhy", "定制终端酬金零合约");
		export.addOutputProperty("dzzdcjlj", "定制终端酬金裸机");
		export.addOutputProperty("dzzdcjhj", "定制终端酬金合计");
		export.addOutputProperty("ysrgdzzdcjhyj", "引商入柜定制终端酬金合约机");
		export.addOutputProperty("ysrgdzzdcjlhy", "引商入柜定制终端酬金零合约");
		export.addOutputProperty("ysrgdzzdcjlj", "引商入柜定制终端酬金裸机");
		export.addOutputProperty("ysrgdzzdcjhj", "引商入柜定制终端酬金合计");
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
