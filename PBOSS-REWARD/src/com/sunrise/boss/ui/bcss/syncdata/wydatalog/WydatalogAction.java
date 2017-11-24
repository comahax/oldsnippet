/**
* auto-generated code
* Wed Feb 18 23:47:47 CST 2009
*/
package com.sunrise.boss.ui.bcss.syncdata.wydatalog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.bcss.syncdata.filedef.persistent.FiledefListVO;
import com.sunrise.boss.business.bcss.syncdata.filedef.persistent.FiledefVO;
import com.sunrise.boss.business.bcss.syncdata.wydataitem.persistent.WydataitemListVO;
import com.sunrise.boss.business.bcss.syncdata.wydataitem.persistent.WydataitemVO;
import com.sunrise.boss.business.bcss.syncdata.wydatalog.persistent.WydatalogVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: WydatalogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class WydatalogAction extends BaseAction {
    public WydatalogAction() {
        this.voClass = WydatalogVO.class;
        // TODO: ������������������
        this.pkNameArray=new String[]{"logid"};
    }
    
    /**
	 * ��ѯ
	 */
	protected ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		WydatalogForm form = (WydatalogForm)actionForm;
		//���filecodeΪ��,���ҵ������������ȡһ��filecode
		if (StringUtils.isEmpty(form.get_se_filecode())){
			DataPackage dp = new CommonDelegate(FiledefVO.class).doQuery(new FiledefListVO(), user, false);
			if (dp != null && dp.getDatas() != null && dp.getDatas().size() >0){
				FiledefVO fd = (FiledefVO)dp.getDatas().iterator().next();
				form.set_se_filecode(fd.getFilecode());
			}
		}
		
		WydataitemListVO itemListvo = new WydataitemListVO();
		itemListvo.set_se_filecode(form.get_se_filecode());
		itemListvo.set_orderby("itemid");
		itemListvo.set_pagesize("0");
		//��ȡ��ҵ���ļ����ֶ���
		DataPackage dp = new CommonDelegate(WydataitemVO.class).doQuery(itemListvo, user, false);
		request.setAttribute("fileitems", dp);
		
		return super.doList(actionMapping, form, request, response, user);
	}
}
