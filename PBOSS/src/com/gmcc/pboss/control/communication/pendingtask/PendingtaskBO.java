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
	 * ����ģ�������������
	 * String title - ���� 
	 * String url - ���� 
	 * String desttype - 1.ȫ��� 2.ȫ��ǩԼ���� 3.ȫ��ǩԼ���������Ա 4.�ض���Ա 5.�ض�Ⱥ�� 6.�������� 7.�ڲ�����
	 * String objid - �������
	 * Short smsnotify - �Ƿ����֪ͨ 1.�� 0.��
	 * String oprcode - ��һ�����˹���
	 * Date releasetime - ��ǰϵͳʱ��
	 * Date plantime - �ƻ����ʱ��
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
			
			//���������벻Ϊ��,ÿ������������һ����¼. �������Ϊ��ʱ, ��������
			if (!StringUtils.isEmpty(objid)) {
				String[] objids = objid.split(",");
	
				//���ս��ն�������Ϊ�ض���Ա���ض�Ⱥ������ڲ�����
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
			//�������Ŵ����ͱ�
			if (null != smsnotify && String.valueOf(smsnotify).equals("1")) {
				Smstmpl Smstmpl = (Smstmpl)BOFactory.build(SmstmplBO.class,user);
				Map<String,String> map = new HashMap<String,String>();
				map.put("TITLE", title);
				String content = Smstmpl.doGenSMS("SMSADVInfo", map);
				//String content = "�𾴵Ŀͻ�������1���µĴ����봦��" + title;
				
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
