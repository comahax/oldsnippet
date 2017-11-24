/**
 * auto-generated code
 * Tue Sep 29 10:11:13 CST 2009
 */
package com.gmcc.pboss.control.communication.pendingtask;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.communication.advinfo.AdvinfoVO;
import com.gmcc.pboss.business.communication.rcvobj.RcvobjConstant;
import com.gmcc.pboss.business.communication.rcvobj.RcvobjVO;
import com.gmcc.pboss.control.communication.advinfo.AdvinfoBO;
import com.gmcc.pboss.control.communication.advinfo.AdvinfoConstant;
import com.gmcc.pboss.control.communication.rcvobj.Rcvobj;
import com.gmcc.pboss.control.communication.rcvobj.RcvobjBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;

/**
 * <p>Title: PendingtaskBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 * @ejb.bean
 *    local-jndi-name="com/sunrise/jop/business/communication/pendingtask/PendingtaskBO"
 *    name="Pendingtask"
 *    view-type="local"
 *    type="Stateless"
 *
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class PendingtaskBO extends AbstractControlBean implements Pendingtask {
	
	/**
	 * 公共模块待办任务新增
	 * String title - 标题 
	 * String url - 内容 
	 * String desttype - 1.全社会 2.全部签约渠道 3.全部签约渠道及其店员 4.特定人员 5.特定群组 6.渠道经理 7.内部工号
	 * String objid - 对象编码
	 * Short smsnotify - 是否短信通知 1.是 0.否
	 * String oprcode - 下一处理人工号
	 * Date releasetime - 当前系统时间
	 * Date plantime - 计划完成时间
	 */
	public void doCreate(String title, String url, String desttype,
			String objid, Short smsnotify, String oprcode, Date releasetime,
			Date plantime) throws Exception {
		try{
			AdvinfoBO advbo = (AdvinfoBO) BOFactory.build(AdvinfoBO.class, user);
			Rcvobj rcvobj = (Rcvobj) BOFactory.build(RcvobjBO.class, user);
			AdvinfoVO advvo = new AdvinfoVO();
			List<String> objidList = new ArrayList<String>();
			advvo.setTitle(title);
			advvo.setUrl(url);
			advvo.setDesttype(new Short(desttype));
			advvo.setSmsnotify(smsnotify);
			advvo.setOprcode(oprcode);
			advvo.setReleasetime(releasetime);
			advvo.setPlantime(plantime);
			advvo.setNdapproval(new Short("0"));
			advvo.setState(new Short(AdvinfoConstant.STATE_UNPUBLISHED));
			advvo.setType(new Short(AdvinfoConstant.TYPE_PENDDING));
			advvo = advbo.doCreate(advvo);
			
			//如果对象编码不为空,每个对象编号新增一条记录. 对象编码为空时, 不做操作
			if (!StringUtils.isEmpty(objid)) {
				String[] objids = objid.split(",");
	
				//接收接收对象类型为特定人员、特定群组或者内部工号
				if (desttype.equals(AdvinfoConstant.DESTTYPE_GROUP)
						|| desttype.equals(AdvinfoConstant.DESTTYPE_INSIDE) || desttype.equals(AdvinfoConstant.DESTTYPE_EMPLOYEE)) {
					for (int i = 0; i < objids.length; i++) {
						RcvobjVO rcvobjVO = new RcvobjVO();
						rcvobjVO.setAdvinfoid(advvo.getAdvinfoid());
						rcvobjVO.setState(RcvobjConstant.STATE_OPEN);
						rcvobjVO.setObjid(objids[i]);
						objidList.add(objids[i]);
						rcvobj.doCreate(rcvobjVO);
					}
				} 
			}
			
			/*
			//新增短信待发送表
			if (null != smsnotify && String.valueOf(smsnotify).equals("1")) {
				Smstmpl Smstmpl = (Smstmpl)BOFactory.build(SmstmplBO.class,user);
				Map<String,String> map = new HashMap<String,String>();
				map.put("TITLE", title);
				String content = Smstmpl.doGenSMS("SMSADVInfo", map);
				//String content = "尊敬的客户，您有1条新的待办请处理：" + title;
				
				Waitreq waitreq = (Waitreq) BOFactory.build(WaitreqBO.class, user);
				Short mobileType = Waitreq.SMS_GOTO;
				waitreq.doSaveWaitreq(mobileType, content, desttype, objidList);
			}
			*/
		}catch (Exception e) {
			throw new JOPException(e);
			// TODO: handle exception
		}
	}
}
