/**
 * auto-generated code
 * Tue Oct 13 16:31:10 CST 2009
 */
package com.gmcc.pboss.control.sales.actfilerec;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.gmcc.pboss.business.sales.actfilerec.ActfilerecDAO;
import com.gmcc.pboss.business.sales.actfilerec.ActfilerecDBParam;
import com.gmcc.pboss.business.sales.actfilerec.ActfilerecVO;
import com.gmcc.pboss.business.sales.noactinfo.NoactinfoVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.sales.actrepair.Actrepair;
import com.gmcc.pboss.control.sales.actrepair.ActrepairBO;
import com.gmcc.pboss.control.sales.noactinfo.Noactinfo;
import com.gmcc.pboss.control.sales.noactinfo.NoactinfoBO;
import com.gmcc.pboss.business.sales.noactinfo.NoactinfoDBParam;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ActfilerecBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/sales/actfilerec/control/ActfilerecBO"
*    name="Actfilerec"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class ActfilerecBO extends AbstractControlBean implements
		Actfilerec {

	private Logger log = Logger.getLogger(ActfilerecBO.class);
	public ActfilerecVO doCreate(ActfilerecVO vo) throws Exception {
		try {
			ActfilerecDAO dao = (ActfilerecDAO) DAOFactory.build(ActfilerecDAO.class, user);
			// TODO set the pk */
			return (ActfilerecVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ActfilerecVO vo) throws Exception {
		try {
			ActfilerecDAO dao = (ActfilerecDAO) DAOFactory.build(ActfilerecDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ActfilerecDAO dao = (ActfilerecDAO) DAOFactory.build(ActfilerecDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ActfilerecVO doUpdate(ActfilerecVO vo) throws Exception {
		try {
			ActfilerecDAO dao = (ActfilerecDAO) DAOFactory.build(ActfilerecDAO.class,user);
			return (ActfilerecVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ActfilerecVO doFindByPk(Serializable pk) throws Exception {
		ActfilerecDAO dao = (ActfilerecDAO) DAOFactory.build(ActfilerecDAO.class,user);
		return (ActfilerecVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ActfilerecDBParam params)
			throws Exception {
		ActfilerecDAO dao = (ActfilerecDAO) DAOFactory.build(ActfilerecDAO.class,user);
		return dao.query(params);
	}

	public void doHandleFileLines(File file) throws Exception {

		String filename = file.getName();
		// �Ǽ��Ѵ����ļ�
		ActfilerecVO afVo = new ActfilerecVO();
		afVo.setFilename(filename);
		afVo.setBegintime(new java.util.Date());
		this.doCreate(afVo);
		
		BufferedReader br = null;
		long totalAmt = 0;
		long actualAmt = 0;
		long success = 0;
		long fail = 0;
		Noactinfo niBo = (NoactinfoBO)BOFactory.build(NoactinfoBO.class, user);
		String cityid = user.getCityid();
		Session currentSession = SessionUtils.currentSession(cityid);
		try {
			br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(file)));
			String s = "";
			while(true) {
				try {
					if((s = br.readLine()) != null) {
						String[] lineContent = s.split("\\|");
						/* 
						 �����ݸ�ʽ: ����|Ʒ��|����ʱ��|����
						 
						 �����ݴ����飺
						 1.������ÿ�а��շָ�����ȡ�� ����4���ֶΣ�������2�������򷵻ص���һ�����ݣ�����ֻ�ۼ��ܼ�¼���ͽ�������Ϣд����־�ļ���
						 2.ƥ�����ID����ƥ��ɹ������ۼ�ʵ�ʴ�������������3�������򷵻ص���һ�����ݣ�����ֻ�ۼ��ܼ�¼����
						 3.�����ֻ����룬����11λ��������4�������򷵻ص���һ�����ݣ������ۼ�ʧ�������ܼ�¼����
						 4.���鼤��ʱ���ʽ����Ϊyyyy-MM-dd HH:mm:ss��������5�������򷵻ص���һ�����ݣ������ۼ�ʧ�������ܼ�¼����
						 5.�������ݵ����뼤���¼���ۼƳɹ������ܼ�¼��
						 */
						java.util.Date activeDate = null;
						if(lineContent.length == 4) {
							
							if(!cityid.equalsIgnoreCase(lineContent[3])) {
								++totalAmt;
								log.debug("��"+totalAmt+"�У�"+s+" | �������ݲ����ڵ��� "+cityid);
								continue;
							}else {
								// �ۼ�ʵ�ʴ�����
								++actualAmt;
								if(lineContent[0].length() != 11) {
									++fail;
									++totalAmt;
									log.debug("��"+totalAmt+"�У�"+s+" | �����������11λ��");
									continue;
								}
								if(!PublicUtils.checkDateTime(4, lineContent[1])) {
									// �ۼ�ʧ�������ܼ�¼��
									++fail;
									++totalAmt;
									log.debug("��"+totalAmt+"�У�"+s+" | ���ڸ�ʽ����ȷ,��ʽӦΪ\"yyyy-MM-dd HH:mm:ss\"");
									continue;
								}
								NoactinfoVO niVo = new NoactinfoVO();
								niVo.setMobileno(lineContent[0]);
								activeDate = PublicUtils.UtilStrToDate(lineContent[1]);
								niVo.setActivedate(activeDate);
								niVo.setCreattime(new java.util.Date());
								niVo.setMemo("�����ļ�����");
								niBo.doCreate(niVo);
								// �ۼƳɹ���
								++success;
								if(success % 50 == 0) { // ��hibernate.jdbc.batch_size�趨��ֵ��ͬ���Կ���һ������Ĵ�С
									currentSession.flush();
									currentSession.clear();
								}
							}
							
							
						}else {
							// �������ֶβ�����4ʱ
							// Ԥ��д��־����
							++totalAmt;
							log.debug("��"+totalAmt+"�У�"+s+" | �ֶθ���������4��");
							continue;
						}
					}else {
						break;
					}
				} catch (IOException e) {
					LoggerUtils.error(e, log);
					// Ԥ��д��־����
					// �ۼ�ʧ����
					//++fail;
				} catch (Exception e) {
					LoggerUtils.error(e, log);
					// Ԥ��д��־����
					// �ۼ�ʧ����
					//++fail;
				}
				// �ۼ��ܼ�¼��
				++totalAmt;
			}
			afVo.setTotalamt(totalAmt);
			afVo.setActualamt(actualAmt);
			afVo.setSuccess(success);
			afVo.setFail(fail);
			afVo.setOvertime(new java.util.Date());
			// �����Ѵ����ļ�
			this.doUpdate(afVo);
			log.info("�Ѵ����ļ�����"+filename+";�ܼ�¼����"+totalAmt+";ʵ�ʴ�������"+actualAmt+"�ɹ�����"+success+"ʧ������"+fail);
		} catch(Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doHandleFileLines2(File file) throws Exception {
		
		String filename = file.getName();
		// �Ǽ��Ѵ����ļ�
		ActfilerecVO afVo = new ActfilerecVO();
		afVo.setFilename(filename);
		afVo.setBegintime(new java.util.Date());
		this.doCreate(afVo);
		
		BufferedReader br = null;
		long totalAmt = 0;
		long actualAmt = 0;
		long success = 0;
		long fail = 0;
		Noactinfo niBo = (NoactinfoBO)BOFactory.build(NoactinfoBO.class, user);
		String cityid = user.getCityid();
		Session currentSession = SessionUtils.currentSession(cityid);
		try {
			br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(file)));
			String s = "";
			Sysparam sys = (Sysparam) BOFactory.build(
					SysparamBO.class, user);
			String day = sys.doFindByID("75", "pboss_fx");
			if (day == null || day.equals("")) {
				day = "3";
			}
			while(true) {
				try {
					if((s = br.readLine()) != null) {
						String[] lineContent = s.split("\\|");
						/* 
						 �����ݸ�ʽ: ����|����ʱ��|,  �� 13631478031|2010-02-28 10:02:25|
						 
						 �����ݴ����飺
						 1.������ÿ�а��շָ�����ȡ�� ����2���ֶΣ�������2�������򷵻ص���һ�����ݣ�����ֻ�ۼ��ܼ�¼���ͽ�������Ϣд����־�ļ���
						 2.�����ֻ����룬����11λ��������3�������򷵻ص���һ�����ݣ������ۼ�ʧ�������ܼ�¼����
						 3.���鼤��ʱ���ʽ����Ϊyyyy-MM-dd HH:mm:ss��������4�������򷵻ص���һ�����ݣ������ۼ�ʧ�������ܼ�¼����
						 4.�������ݵ����뼤���¼���ۼƳɹ������ܼ�¼��
						 */
						java.util.Date activeDate = null;
						if(lineContent.length == 2) {
							
							// �ۼ�ʵ�ʴ�����
							++actualAmt;
							if(lineContent[0].length() != 11) {
								++fail;
								++totalAmt;
								log.debug("��"+totalAmt+"�У�"+s+" | �����������11λ��");
								continue;
							}
							if(!PublicUtils.checkDateTime(4, lineContent[1])) {
								// �ۼ�ʧ�������ܼ�¼��
								++fail;
								++totalAmt;
								log.debug("��"+totalAmt+"�У�"+s+" | ���ڸ�ʽ����ȷ,��ʽӦΪ\"yyyy-MM-dd HH:mm:ss\"");
								continue;
							}
							NoactinfoVO niVo = new NoactinfoVO();
							niVo.setMobileno(lineContent[0]);
							activeDate = PublicUtils.UtilStrToDate(lineContent[1]);
							niVo.setActivedate(activeDate);
							niVo.setCreattime(new java.util.Date());
							niVo.setMemo("�����ļ�����");
							
							String mobileno = niVo.getMobileno();
								
							Actrepair actrepair = (Actrepair) BOFactory.build(
									ActrepairBO.class, user);
							boolean bo = actrepair.doCheckDate(mobileno, activeDate,day);
							
							if (bo) {
								niBo.doCreate(niVo);
								// �ۼƳɹ���
								++success;
							}
							else{
								log.info(niVo.getMobileno()+"�ú���ļ����¼�Ѿ����ڣ����顣");
								++fail;
							}
							if(success % 50 == 0) { // ��hibernate.jdbc.batch_size�趨��ֵ��ͬ���Կ���һ������Ĵ�С
								currentSession.flush();
								currentSession.clear();
							}
							
							
						}else {
							// �������ֶβ�����2ʱ
							// Ԥ��д��־����
							++totalAmt;
							log.debug("��"+totalAmt+"�У�"+s+" | �ֶθ���������2��");
							continue;
						}
					}else {
						break;
					}
				} catch (IOException e) {
					LoggerUtils.error(e, log);
					// Ԥ��д��־����
					// �ۼ�ʧ����
					//++fail;
				} catch (Exception e) {
					LoggerUtils.error(e, log);
					// Ԥ��д��־����
					// �ۼ�ʧ����
					//++fail;
				}
				// �ۼ��ܼ�¼��
				++totalAmt;
			}
			afVo.setTotalamt(totalAmt);
			afVo.setActualamt(actualAmt);
			afVo.setSuccess(success);
			afVo.setFail(fail);
			afVo.setOvertime(new java.util.Date());
			// �����Ѵ����ļ�
			this.doUpdate(afVo);
			log.info("�Ѵ����ļ�����"+filename+";�ܼ�¼����"+totalAmt+";ʵ�ʴ�������"+actualAmt+";�ɹ�����"+success+";ʧ������"+fail);
		} catch(Exception ex) {
			throw new JOPException(ex);
		}
	}
	
	
	
}
