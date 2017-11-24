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
		// 登记已处理文件
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
						 行数据格式: 号码|品牌|激活时间|地市
						 
						 行数据处理检查：
						 1.首先是每行按照分隔符提取， 若是4个字段，跳到第2步；否则返回到下一行数据，并且只累计总记录数和将出错信息写入日志文件；
						 2.匹配地市ID，若匹配成功，则累计实际处理数，跳到第3步；否则返回到下一行数据，并且只累计总记录数；
						 3.检验手机号码，若是11位，跳到第4步；否则返回到下一行数据，并且累计失败数和总记录数；
						 4.检验激活时间格式，若为yyyy-MM-dd HH:mm:ss，跳到第5步；否则返回到下一行数据，并且累计失败数和总记录数；
						 5.新增数据到号码激活记录表，累计成功数和总记录数
						 */
						java.util.Date activeDate = null;
						if(lineContent.length == 4) {
							
							if(!cityid.equalsIgnoreCase(lineContent[3])) {
								++totalAmt;
								log.debug("第"+totalAmt+"行："+s+" | 该行数据不属于地市 "+cityid);
								continue;
							}else {
								// 累计实际处理数
								++actualAmt;
								if(lineContent[0].length() != 11) {
									++fail;
									++totalAmt;
									log.debug("第"+totalAmt+"行："+s+" | 号码个数不是11位。");
									continue;
								}
								if(!PublicUtils.checkDateTime(4, lineContent[1])) {
									// 累计失败数和总记录数
									++fail;
									++totalAmt;
									log.debug("第"+totalAmt+"行："+s+" | 日期格式不正确,格式应为\"yyyy-MM-dd HH:mm:ss\"");
									continue;
								}
								NoactinfoVO niVo = new NoactinfoVO();
								niVo.setMobileno(lineContent[0]);
								activeDate = PublicUtils.UtilStrToDate(lineContent[1]);
								niVo.setActivedate(activeDate);
								niVo.setCreattime(new java.util.Date());
								niVo.setMemo("激活文件导入");
								niBo.doCreate(niVo);
								// 累计成功数
								++success;
								if(success % 50 == 0) { // 与hibernate.jdbc.batch_size设定的值相同，以控制一级缓存的大小
									currentSession.flush();
									currentSession.clear();
								}
							}
							
							
						}else {
							// 行数据字段不等于4时
							// 预留写日志操作
							++totalAmt;
							log.debug("第"+totalAmt+"行："+s+" | 字段个数不等于4。");
							continue;
						}
					}else {
						break;
					}
				} catch (IOException e) {
					LoggerUtils.error(e, log);
					// 预留写日志操作
					// 累计失败数
					//++fail;
				} catch (Exception e) {
					LoggerUtils.error(e, log);
					// 预留写日志操作
					// 累计失败数
					//++fail;
				}
				// 累计总记录数
				++totalAmt;
			}
			afVo.setTotalamt(totalAmt);
			afVo.setActualamt(actualAmt);
			afVo.setSuccess(success);
			afVo.setFail(fail);
			afVo.setOvertime(new java.util.Date());
			// 更新已处理文件
			this.doUpdate(afVo);
			log.info("已处理文件名："+filename+";总记录数："+totalAmt+";实际处理数："+actualAmt+"成功数："+success+"失败数："+fail);
		} catch(Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doHandleFileLines2(File file) throws Exception {
		
		String filename = file.getName();
		// 登记已处理文件
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
						 行数据格式: 号码|激活时间|,  如 13631478031|2010-02-28 10:02:25|
						 
						 行数据处理检查：
						 1.首先是每行按照分隔符提取， 若是2个字段，跳到第2步；否则返回到下一行数据，并且只累计总记录数和将出错信息写入日志文件；
						 2.检验手机号码，若是11位，跳到第3步；否则返回到下一行数据，并且累计失败数和总记录数；
						 3.检验激活时间格式，若为yyyy-MM-dd HH:mm:ss，跳到第4步；否则返回到下一行数据，并且累计失败数和总记录数；
						 4.新增数据到号码激活记录表，累计成功数和总记录数
						 */
						java.util.Date activeDate = null;
						if(lineContent.length == 2) {
							
							// 累计实际处理数
							++actualAmt;
							if(lineContent[0].length() != 11) {
								++fail;
								++totalAmt;
								log.debug("第"+totalAmt+"行："+s+" | 号码个数不是11位。");
								continue;
							}
							if(!PublicUtils.checkDateTime(4, lineContent[1])) {
								// 累计失败数和总记录数
								++fail;
								++totalAmt;
								log.debug("第"+totalAmt+"行："+s+" | 日期格式不正确,格式应为\"yyyy-MM-dd HH:mm:ss\"");
								continue;
							}
							NoactinfoVO niVo = new NoactinfoVO();
							niVo.setMobileno(lineContent[0]);
							activeDate = PublicUtils.UtilStrToDate(lineContent[1]);
							niVo.setActivedate(activeDate);
							niVo.setCreattime(new java.util.Date());
							niVo.setMemo("激活文件导入");
							
							String mobileno = niVo.getMobileno();
								
							Actrepair actrepair = (Actrepair) BOFactory.build(
									ActrepairBO.class, user);
							boolean bo = actrepair.doCheckDate(mobileno, activeDate,day);
							
							if (bo) {
								niBo.doCreate(niVo);
								// 累计成功数
								++success;
							}
							else{
								log.info(niVo.getMobileno()+"该号码的激活记录已经存在，请检查。");
								++fail;
							}
							if(success % 50 == 0) { // 与hibernate.jdbc.batch_size设定的值相同，以控制一级缓存的大小
								currentSession.flush();
								currentSession.clear();
							}
							
							
						}else {
							// 行数据字段不等于2时
							// 预留写日志操作
							++totalAmt;
							log.debug("第"+totalAmt+"行："+s+" | 字段个数不等于2。");
							continue;
						}
					}else {
						break;
					}
				} catch (IOException e) {
					LoggerUtils.error(e, log);
					// 预留写日志操作
					// 累计失败数
					//++fail;
				} catch (Exception e) {
					LoggerUtils.error(e, log);
					// 预留写日志操作
					// 累计失败数
					//++fail;
				}
				// 累计总记录数
				++totalAmt;
			}
			afVo.setTotalamt(totalAmt);
			afVo.setActualamt(actualAmt);
			afVo.setSuccess(success);
			afVo.setFail(fail);
			afVo.setOvertime(new java.util.Date());
			// 更新已处理文件
			this.doUpdate(afVo);
			log.info("已处理文件名："+filename+";总记录数："+totalAmt+";实际处理数："+actualAmt+";成功数："+success+";失败数："+fail);
		} catch(Exception ex) {
			throw new JOPException(ex);
		}
	}
	
	
	
}
