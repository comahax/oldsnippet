/**
* auto-generated code
* Fri Oct 20 10:53:27 CST 2006
*/
package com.sunrise.boss.ui.zifee.yxplanlog;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.zifee.yxplanlog.YxplanlogForm;
import com.sunrise.boss.business.zifee.fixfeedisclog.persistent.FixfeedisclogListVO;
import com.sunrise.boss.business.zifee.yxplanlog.persistent.YxplanlogListVO;
import com.sunrise.boss.business.zifee.yxplanlog.persistent.YxplanlogVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.zifee.yxplanlog.YxplanlogDelegate;

/**
 * <p>Title: YxplanlogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author eboxdisc
 * @version 1.0
 */
public class YxplanlogAction extends BaseDelegateAction {
    public YxplanlogAction() {
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(YxplanlogVO.class);
            //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
    /**
	 * ��ѯ
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		YxplanlogForm form = (YxplanlogForm) actionForm;

		try {
			Page.setPageSize(request, form);
			YxplanlogListVO listVO = new YxplanlogListVO();
			setListVO(listVO, actionForm); // ���ú�listVO����Ϊ��ѯ����
			listVO.set_ne_groupflag("0"); // 1 ��, 0
											// ��������ǡ�Ӫ�������飬����[Ӫ����������]�в��ɼ�����[Ӫ�������������]�ж�Ӫ�����������
	
				//����ͳһӪ����,ȫʡ,�й�˾,�����ʶΪ��Ҳ�ڲ�ѯ��Χ��
				String _sql_areacode = " (areacode is null or  areacode in ('865','100','999','','"+user.getCityid()+"')) ";
				listVO.set_sql_areacode(_sql_areacode);
				String _desc=((BaseActionForm)actionForm).get_desc();
				String _orderby=((BaseActionForm)actionForm).get_orderby();
				if("".equals(_desc) && "".equals(_orderby) || _desc==null && _orderby==null)
				{
					listVO.set_desc("1");
					listVO.set_orderby("logid");
				}
			YxplanlogDelegate delegate = new YxplanlogDelegate();
			DataPackage dp = delegate.doQuery(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} catch (Exception e) {
			throw e;
		}
		return (actionMapping.findForward("list"));
	}
}
