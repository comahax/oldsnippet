package com.gmcc.pboss.control.channel.zjty.zjtywayinfo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.ejb.EJBException;
import javax.ejb.EJBLocalHome;
import javax.ejb.EJBLocalObject;
import javax.ejb.RemoveException;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.bchcontact.BchcontactVO;
import com.gmcc.pboss.business.channel.common.AuditUtils;
import com.gmcc.pboss.business.channel.way.WayDAO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.waycompact.WaycompactVO;
import com.gmcc.pboss.business.channel.wayprovince.WayprovinceVO;
import com.gmcc.pboss.business.channel.zjty.zjtywayinfo.ZjtywayinfoVO;
import com.gmcc.pboss.control.channel.bchcontact.Bchcontact;
import com.gmcc.pboss.control.channel.bchcontact.BchcontactBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.waycompact.Waycompact;
import com.gmcc.pboss.control.channel.waycompact.WaycompactBO;
import com.gmcc.pboss.control.channel.wayprovince.Wayprovince;
import com.gmcc.pboss.control.channel.wayprovince.WayprovinceBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;


/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtywayinfo/control/ZjtywayinfoControlBean"
 *           name="ZjtywayinfoControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */

public class ZjtywayinfoBO extends AbstractControlBean implements
		Zjtywayinfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ZjtywayinfoBO() {
		// TODO Auto-generated constructor stub
	}

	private WayDAO doGetwaydao(DBAccessUser user) throws Exception {
		return (WayDAO) DAOFactory.build(WayDAO.class, user);
	}

	private Way doGetwayControl(DBAccessUser user) throws Exception {
		return (Way)BOFactory.build(WayBO.class, user);
//		Way delegate = (Way)BOFactory.build(WayBO.class, user);
	}

	public DataPackage doQuery(WayDBParam waylistvo,DBAccessUser user) throws Exception {
		waylistvo.set_se_waytype("ET");
		Map querycondition = new HashMap();
		String basewayid = StringUtils.isEmpty(waylistvo.getBasewayid()) ?user.getCityid() : waylistvo.getBasewayid();
		querycondition.put("basewayid", basewayid);
		waylistvo.setQueryConditions(querycondition);
		if (waylistvo.get_ne_waystate() == null) {
//			waylistvo.set_sql_waystate("(waystate = 1 or waystate = 0)");
			return this.doGetwaydao(user).queryByNamedSqlQuery(
					"boss.cms.querySvwayinfo.withwaystate", waylistvo);
		}
//		String ss=this.doGetwaydao(user).queryByNamedSqlQuery(
//				"boss.cms.querySvwayinfo", waylistvo).toString();
		return this.doGetwaydao(user).queryByNamedSqlQuery(
				"boss.cms.querySvwayinfo", waylistvo);
	}

	public WayVO doCreate(WayVO vo, DBAccessUser user) throws Exception {
//		WayControl control = this.doGetwayControl(user);
		Way control = this.doGetwayControl(user);
		AuditUtils utils = new AuditUtils();
		vo = (WayVO) utils.doSaveAudit(vo, "CH_PW_WAY", "CH_PW_SVWAY",
				new String[] { "address" }, new String[] { "wayid" },
				"CH_PW_SVWAY_AUDIT", user);
		// vo.setAddress("");// ��ϸ��ַ�ֶ���Ҫ��˺�ż���������
		/**
		 * ������Ҫ�������������Ϣ�ӿ�
		 */
		return (WayVO) control.doCreate(vo, user);
	}

	public DataPackage doQueryZjty(Collection coll,DBAccessUser user)throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return 	dao.queryAllZJTYWay(coll,user);
		}

	public WayVO doUpdate(WayVO vo, DBAccessUser user) throws Exception {
//		WayControl control = this.doGetwayControl(user);
		Way control = this.doGetwayControl(user);
		// WayVO oldvo=(WayVO)dao.findByPk(vo.getWayid());
		// BeanUtils.copyProperties(oldvo, vo,false);
		AuditUtils utils = new AuditUtils();
		vo = (WayVO) utils.doUpdateValue(vo, "CH_PW_WAY", "CH_PW_SVWAY",
				new String[] { "address" }, new String[] { "wayid" },
				"CH_PW_SVWAY_AUDIT", user);
		return (WayVO) control.doUpdate(vo, user);
	}

	public void doRemove(WayVO vo,DBAccessUser user) throws Exception {
		Way control = this.doGetwayControl(user);
		vo.setWaystate(new Short("0"));
		control.doUpdate(vo, user);
	}

	public Object doFindByPk(String pk, DBAccessUser user) throws Exception {
		WayDAO dao = this.doGetwaydao(user);
		return dao.findByPk(pk);
	}

	public void doMulsave(ZjtywayinfoVO vo,DBAccessUser user) throws Exception {

//		WayDelegate delegate = new WayDelegate();
		Way delegate = (Way)BOFactory.build(WayBO.class, user);
		WayVO newvo = new WayVO();
		if (vo.getWaystate() != null) {
			newvo.setWaystate(Short.valueOf(vo.getWaystate() + ""));
		}
		BeanUtils.copyProperties(newvo, vo);
		newvo.setWaytype("AG");
		newvo.setWaysubtype("ZJTY");
		newvo.setRunmode(Long.valueOf("1"));
		newvo.setCityid(vo.getCityid());
		delegate.doCreate(newvo, user);

		// �����ֶα��浽CH_PW_BCHCONTACT��
		// ί�з���˾���ơ�����ע��š����˴������֤���롢�����˵绰��
		BchcontactVO bchcontactvo = new BchcontactVO();
		bchcontactvo.setCompany(vo.getCompany());
		bchcontactvo.setPrincipal(vo.getPrincipal());
		bchcontactvo.setPrincipaltel(vo.getPrincipaltel());
		bchcontactvo.setLinkman(vo.getPrincipal());
		bchcontactvo.setLinkmantel(vo.getPrincipaltel());
		bchcontactvo.setCertinum(vo.getCertinum());
		bchcontactvo.setBusnum(vo.getBusnum());
		bchcontactvo.setWayid(vo.getWayid());

//		BchcontactDelegate bcdelegate = new BchcontactDelegate();
		Bchcontact  bcdelegate=(Bchcontact)BOFactory.build(BchcontactBO.class,user);
		bcdelegate.doCreate(bchcontactvo);

		// �����ֶα��浽CH_PW_WAYCOMPACT��
		// ǩԼ��š�Э�����ơ�Э��ǩ����Чʱ�䣨��ʽ��YYYYMMDD����Э���ֹʱ�䣨��ʽ��YYYYMMDD����ǩԼʱ�䣨��ʽ��YYYYMMDD����
		WaycompactVO waycompactvo = new WaycompactVO();
		waycompactvo.setEndtime(vo.getEndtime());
		waycompactvo.setSigntime(vo.getSigntime());
		waycompactvo.setBegintime(vo.getBegintime());
		waycompactvo.setCompactname(vo.getCompactname());
		waycompactvo.setCompactno(vo.getCompactno());
		waycompactvo.setWayid(vo.getWayid());

//		WaycompactDelegate waycompactdelegate = new WaycompactDelegate();
		Waycompact  waycompactdelegate=(Waycompact)BOFactory.build(WaycompactBO.class,user);
		waycompactdelegate.doCreate(waycompactvo);

		// �����ֶα��浽����ʡ��˾���Ա�(ch_pw_wayprovince)��
		// ȫ��ͳһ�������롢���������������͡��Ƿ��ֻ�������ǰ̨Ӫҵ������O���������ŶӽкŻ�������POS����
		// ����24Сʱ����Ӫҵ��������VIPרϯ������VIP�ҡ�G3�����������
		WayprovinceVO wayprovincevo = new WayprovinceVO();
		wayprovincevo.setUniquewayid(vo.getUniquewayid());
		wayprovincevo.setTown(vo.getTown());
		wayprovincevo.setProvtype(vo.getProvtype());
		wayprovincevo.setMobilemall(vo.getMobilemall());
		wayprovincevo.setFrontarea(vo.getFrontarea());
		wayprovincevo.setHaswaitmach(vo.getHaswaitmach());
		wayprovincevo.setHas24mall(vo.getHas24mall());
		wayprovincevo.setHasposmach(vo.getHasposmach());
		wayprovincevo.setHasviproom(vo.getHasviproom());
		wayprovincevo.setHasvipseat(vo.getHasvipseat());
		wayprovincevo.setG3area(vo.getG3area());

		wayprovincevo.setWayid(vo.getWayid());

//		WayprovinceDelegate wayprovincedelegate = new WayprovinceDelegate();
		Wayprovince  wayprovincedelegate=(Wayprovince)BOFactory.build(WayprovinceBO.class,user);
		wayprovincedelegate.doCreate(wayprovincevo);

		// ¼��ɹ�Ҫ�Ǽ������־������ʡ��˾������־��(ch_pw_wayprovincelog)��
		// ��־��¼��ܻ��Զ�д�뵽�����BaseLogDAO.java

	}

	public void doMulupdate(ZjtywayinfoVO vo,DBAccessUser user) throws Exception {
		// TODO Auto-generated method stub
//		WayDelegate delegate = new WayDelegate();
		Way delegate = (Way)BOFactory.build(WayBO.class, user);
		WayVO newvo = new WayVO();

		newvo = delegate.doFindByPk(vo.getWayid());
		newvo.setWaymagcode(null);
		if (vo.getWaystate() != null) {
			newvo.setWaystate(Short.valueOf(vo.getWaystate() + ""));
		}

		newvo.setWaysubtype("ZJTY");
		newvo.setRunmode(Long.valueOf("1"));
		newvo.setCityid(vo.getCityid());
		BeanUtils.copyProperties(newvo, vo);

		WayVO nvo = new WayVO();

		BeanUtils.copyProperties(nvo, newvo);

		delegate.doUpdate(nvo, user);

		// �ϼ�����״̬�ֶ�����Ϊ��0:��ͣӪҵ��-1:�ѹصꡯʱ��Ҫ��������������Ϊ��Ӧ״̬��
		if (newvo.getWaystate() != null) {
			if ("0".equals(newvo.getWaystate().toString())
					|| "-1".equals(newvo.getWaystate().toString())) {
				WayDBParam waylistvo = new WayDBParam();
				Map querycondition = new HashMap();
				querycondition.put("basewayid", vo.getWayid());
				waylistvo.setQueryConditions(querycondition);

				DataPackage dp = this.doGetwaydao(user).queryByNamedSqlQuery(
						"boss.cms.querySvwayinfoSubWay", waylistvo);
				if (dp.getRowCount() != 0) {
					Iterator it = dp.getDatas().iterator();
					while (it.hasNext()) {
						WayVO wayvo = null;
						wayvo = (WayVO) it.next();
						wayvo.setWaystate(newvo.getWaystate());
						delegate.doUpdate(wayvo, user);
					}
				}
			}
		}

		// �����ֶα��浽CH_PW_BCHCONTACT��
		// ί�з���˾���ơ�����ע��š����˴������֤���롢�����˵绰��
//		BchcontactDelegate bcdelegate = new BchcontactDelegate();
		Bchcontact  bcdelegate=(Bchcontact)BOFactory.build(BchcontactBO.class,user);
		BchcontactVO bchcontactvo = new BchcontactVO();

		bchcontactvo = bcdelegate.doFindByPk(vo.getWayid());
		if (bchcontactvo == null) {
			bchcontactvo = new BchcontactVO();

			bchcontactvo.setCompany(vo.getCompany());
			bchcontactvo.setPrincipal(vo.getPrincipal());
			bchcontactvo.setPrincipaltel(vo.getPrincipaltel());
			bchcontactvo.setLinkman(vo.getPrincipal());
			bchcontactvo.setLinkmantel(vo.getPrincipaltel());
			bchcontactvo.setCertinum(vo.getCertinum());
			bchcontactvo.setBusnum(vo.getBusnum());
			bchcontactvo.setWayid(vo.getWayid());

			bcdelegate.doCreate(bchcontactvo);
		} else {
			bchcontactvo.setCompany(vo.getCompany());
			bchcontactvo.setPrincipal(vo.getPrincipal());
			bchcontactvo.setPrincipaltel(vo.getPrincipaltel());
			bchcontactvo.setLinkman(vo.getPrincipal());
			bchcontactvo.setLinkmantel(vo.getPrincipaltel());
			bchcontactvo.setCertinum(vo.getCertinum());
			bchcontactvo.setBusnum(vo.getBusnum());
			bchcontactvo.setWayid(vo.getWayid());
			bcdelegate.doUpdate(bchcontactvo);
		}

		// �����ֶα��浽CH_PW_WAYCOMPACT��
		// ǩԼ��š�Э�����ơ�Э��ǩ����Чʱ�䣨��ʽ��YYYYMMDD����Э���ֹʱ�䣨��ʽ��YYYYMMDD����ǩԼʱ�䣨��ʽ��YYYYMMDD����
//		WaycompactDelegate waycompactdelegate = new WaycompactDelegate();
		Waycompact  waycompactdelegate=(Waycompact)BOFactory.build(WaycompactBO.class,user);
		WaycompactVO waycompactvo = new WaycompactVO();

		waycompactvo = waycompactdelegate.doFindByPk(vo.getWayid());

		if (waycompactvo == null) {
			waycompactvo = new WaycompactVO();
			waycompactvo.setEndtime(vo.getEndtime());
			waycompactvo.setSigntime(vo.getSigntime());
			waycompactvo.setBegintime(vo.getBegintime());
			waycompactvo.setCompactname(vo.getCompactname());
			waycompactvo.setCompactno(vo.getCompactno());
			waycompactvo.setWayid(vo.getWayid());

			waycompactdelegate.doCreate(waycompactvo);
		} else {

			waycompactvo.setEndtime(vo.getEndtime());
			waycompactvo.setSigntime(vo.getSigntime());
			waycompactvo.setBegintime(vo.getBegintime());
			waycompactvo.setCompactname(vo.getCompactname());
			waycompactvo.setCompactno(vo.getCompactno());
			waycompactvo.setWayid(vo.getWayid());

			waycompactdelegate.doUpdate(waycompactvo);
		}

		// �����ֶα��浽����ʡ��˾���Ա�(ch_pw_wayprovince)��
		// ȫ��ͳһ�������롢���������������͡��Ƿ��ֻ�������ǰ̨Ӫҵ������O���������ŶӽкŻ�������POS����
		// ����24Сʱ����Ӫҵ��������VIPרϯ������VIP�ҡ�G3�����������
//		WayprovinceDelegate wayprovincedelegate = new WayprovinceDelegate();
		Wayprovince  wayprovincedelegate=(Wayprovince)BOFactory.build(WayprovinceBO.class,user);
		WayprovinceVO wayprovincevo = new WayprovinceVO();

		wayprovincevo = wayprovincedelegate.doFindByPk(vo.getWayid());
		if (wayprovincevo == null) {
			wayprovincevo = new WayprovinceVO();
			wayprovincevo.setUniquewayid(vo.getUniquewayid());
			wayprovincevo.setTown(vo.getTown());
			wayprovincevo.setProvtype(vo.getProvtype());
			wayprovincevo.setMobilemall(vo.getMobilemall());
			wayprovincevo.setFrontarea(vo.getFrontarea());
			wayprovincevo.setHaswaitmach(vo.getHaswaitmach());
			wayprovincevo.setHas24mall(vo.getHas24mall());
			wayprovincevo.setHasposmach(vo.getHasposmach());
			wayprovincevo.setHasviproom(vo.getHasviproom());
			wayprovincevo.setHasvipseat(vo.getHasvipseat());
			wayprovincevo.setG3area(vo.getG3area());
			wayprovincevo.setWayid(vo.getWayid());

			wayprovincedelegate.doCreate(wayprovincevo);
		} else {
			wayprovincevo.setUniquewayid(vo.getUniquewayid());
			wayprovincevo.setTown(vo.getTown());
			wayprovincevo.setProvtype(vo.getProvtype());
			wayprovincevo.setMobilemall(vo.getMobilemall());
			wayprovincevo.setFrontarea(vo.getFrontarea());
			wayprovincevo.setHaswaitmach(vo.getHaswaitmach());
			wayprovincevo.setHas24mall(vo.getHas24mall());
			wayprovincevo.setHasposmach(vo.getHasposmach());
			wayprovincevo.setHasviproom(vo.getHasviproom());
			wayprovincevo.setHasvipseat(vo.getHasvipseat());
			wayprovincevo.setG3area(vo.getG3area());
			wayprovincevo.setWayid(vo.getWayid());

			wayprovincedelegate.doUpdate(wayprovincevo);
		}

		// ¼��ɹ�Ҫ�Ǽ������־������ʡ��˾������־��(ch_pw_wayprovincelog)��
		// ��־��¼��ܻ��Զ�д�뵽�����BaseLogDAO.java

	}

	public EJBLocalHome getEJBLocalHome() throws EJBException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPrimaryKey() throws EJBException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isIdentical(EJBLocalObject arg0) throws EJBException {
		// TODO Auto-generated method stub
		return false;
	}

//	public void remove() throws RemoveException, EJBException {
//		// TODO Auto-generated method stub
//		
//	}

	public DBAccessUser getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setUser(DBAccessUser user) {
		// TODO Auto-generated method stub
		
	}
}
