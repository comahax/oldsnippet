/**
 * auto-generated code
 * Mon Sep 04 20:34:08 CST 2006
 */
package com.sunrise.boss.business.zifee.eboxdisc.control;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.business.fee.woff.eboxunit.persistent.EBoxUnitDAO;
import com.sunrise.boss.business.fee.woff.eboxunit.persistent.EBoxUnitListVO;
import com.sunrise.boss.business.fee.woff.eboxunit.persistent.EBoxUnitVO;
import com.sunrise.boss.business.zifee.eboxdisc.persistent.EboxdiscDAO;
import com.sunrise.boss.business.zifee.eboxdisc.persistent.EboxdiscListVO;
import com.sunrise.boss.business.zifee.eboxdisc.persistent.EboxdiscVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanDAO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanListVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.zifee.yxplan.YxPlanDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.zifee.commons.ResultBean;

/**
 * <p>
 * Title: EboxdiscControlBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author eboxdisc
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/zifee/eboxdisc/control/EboxdiscControlBean"
 *           name="EboxdiscControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class EboxdiscControlBean extends AbstractControlBean implements
		EboxdiscControl {

	public EboxdiscVO doCreate(EboxdiscVO vo, User user) throws Exception {
		try {
			doCheckCreate(vo, user);
			EboxdiscDAO dao = (EboxdiscDAO) DAOFactory.build(EboxdiscDAO.class,
					user);
			vo.setEboxdiscid(getEboxdiscSeq(user));
			return (EboxdiscVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(EboxdiscVO vo, User user) throws Exception {
		try {
			EboxdiscDAO dao = (EboxdiscDAO) DAOFactory.build(EboxdiscDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public EboxdiscVO doUpdate(EboxdiscVO vo, User user) throws Exception {
		try {

			EBoxUnitDAO edao = (EBoxUnitDAO) DAOFactory.build(
					EBoxUnitDAO.class, user);
			EBoxUnitVO eboxunitVO = new EBoxUnitVO();
			EBoxUnitVO feesourceVO = new EBoxUnitVO();

			EboxdiscControl control = (EboxdiscControl) ControlFactory
					.build(EboxdiscControlBean.class);

			EboxdiscVO pkvo = new EboxdiscVO();
			pkvo.setYxplanid(vo.getYxplanid());
			pkvo.setEboxdiscid(vo.getEboxdiscid());

			EboxdiscVO vo2 = control.doFindByPk(pkvo, user);
			if (vo.getEboxunitid() != null
					&& !"".equals(vo.getEboxunitid().toString().trim())) {
				eboxunitVO = (EBoxUnitVO) edao.findByPk(vo.getEboxunitid());
			} else {
				vo2.setEboxunitid(null);
			}

			if (vo.getFeesourceid() != null
					&& !"".equals(vo.getFeesourceid().toString().trim())) {
				feesourceVO = (EBoxUnitVO) edao.findByPk(vo.getFeesourceid());
			} else {
				vo2.setFeesourceid(null);
			}
			if (vo != vo2 && vo != null && vo2 != null) {

				if (eboxunitVO != null && feesourceVO != null) {
					if (feesourceVO.getEboxunitstate() != null
							&& eboxunitVO.getEboxunitstate() != null) {
						int flag = 1;
						if (flag != feesourceVO.getEboxunitstate().intValue()
								&& flag != eboxunitVO.getEboxunitstate()
										.intValue()) {
							throw new BusinessException("",
									"保存失败：输入的[账本科目标识]和[扣费帐目标识]已禁用");
						}
					}
				}

				if (vo.getEboxunitid() != null
						&& !vo.getEboxunitid().equals(vo2.getEboxunitid())) {
					if (eboxunitVO != null) {

						if (eboxunitVO.getEboxunitstate() != null) {
							int flag = 1;
							if (flag != eboxunitVO.getEboxunitstate()
									.intValue()) {
								throw new BusinessException("",
										"保存失败：[账本科目标识]已禁用");
							}
						}
					}
				}
				if (vo.getFeesourceid() != null
						&& !vo.getFeesourceid().equals(vo2.getFeesourceid())) {
					if (feesourceVO != null) {

						if (feesourceVO.getEboxunitstate() != null) {
							int flag = 1;
							if (flag != feesourceVO.getEboxunitstate()
									.intValue()) {
								throw new BusinessException("",
										"保存失败：[扣费帐目标识]已禁用");
							}
						}

					}

				}

			}
			EboxdiscDAO dao = (EboxdiscDAO) DAOFactory.build(EboxdiscDAO.class,
					user);
			BeanUtils.copyProperties(vo2, vo);
			EboxdiscVO eboxdiscvo = (EboxdiscVO) dao.update(vo2);

			return eboxdiscvo;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public EboxdiscVO doFindByPk(Serializable pk, User user) throws Exception {
		EboxdiscDAO dao = (EboxdiscDAO) DAOFactory.build(EboxdiscDAO.class,
				user);
		return (EboxdiscVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(EboxdiscListVO params, User user)
			throws Exception {
		EboxdiscDAO dao = (EboxdiscDAO) DAOFactory.build(EboxdiscDAO.class,
				user);
		return dao.query(params);
	}

	public DataPackage doBatchquery(EboxdiscListVO params, User user)
			throws Exception {
		EboxdiscDAO dao = (EboxdiscDAO) DAOFactory.build(EboxdiscDAO.class,
				user);
		return dao.queryByNamedSqlQuery("batchQuery", params);
	}

	public Long getEboxdiscSeq(User user) throws Exception {
		EboxdiscDAO dao = (EboxdiscDAO) DAOFactory.build(EboxdiscDAO.class,
				user);

		return (Long) dao.getSequence("PC_PS_EBOXDISC_SEQ");
	}

	/**
	 * 根据字符串构造EboxdiscVO
	 * 
	 * @param fields
	 * @param user
	 * @return
	 * @throws Exception
	 *             营销方案标识0|到达账本科目1|智能网营销方案标识2|帐户预存优惠生效类型3|开始生效时间4|生效时间间隔5|
	 *             是否顺延6|支付次数7|金额/比例8|是否进入帐目明细9|帐户预存优惠类型10|帐户预存优惠结转类型11|
	 *             开始偏移周期12|结束偏移周期13|优惠结束日期14|是否赠费15|赠送方式16|本金优惠标识17|
	 *             附加属性编码18|扣费来源类型19|扣费帐目标识20|支付间隔21|说明22|
	 */
	public EboxdiscVO buildVO(String[] fields, User user, String oprtype)
			throws Exception {
		EboxdiscVO result = null;
		try {
			result = new EboxdiscVO();
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			// 增加
			if ("0".equals(oprtype)) {
				result.setYxplanid(new Long(fields[0]));// 营销方案标识
				if (fields[1].trim().length() > 0)
					result.setEboxunitid(new Long(fields[1]));// 到达账本科目
				if (fields[2].trim().length() > 0)
					result.setInplanid(new Long(fields[2]));// 智能网营销方案标识
				if (fields[3].trim().length() > 0)
					result.setEffectivetype(fields[3]);// 帐户预存优惠生效类型
				if (fields[4].trim().length() > 0)
					result.setEffectivedate(format.parse(fields[4]));// 开始生效时间
				if (fields[5].trim().length() > 0)
					result.setEffectiveinterval(new Integer(fields[5]));// 生效时间间隔
				if (fields[6].trim().length() > 0)
					result.setIspostpone(new Byte(fields[6]));// 是否顺延
				if (fields[7].trim().length() > 0)
					result.setPaytimes(new Integer(fields[7]));// 支付次数
				if (fields[8].trim().length() > 0)
					result.setAmount(new Long(fields[8]));// 金额/比例
				if (fields[9].trim().length() > 0)
					result.setEnterunitdetflag(new Byte(fields[9]));// 是否进入帐目明细
				if (fields[10].trim().length() > 0)
					result.setDisctype(fields[10]);// 帐户预存优惠类型
				if (fields[11].trim().length() > 0)
					result.setRollovertype(fields[11]);// 帐户预存优惠结转类型
				if (fields[12].trim().length() > 0)
					result.setEffectivecycles(new Integer(fields[12]));// 开始偏移周期
				if (fields[13].trim().length() > 0)
					result.setExpiredcycles(new Integer(fields[13]));// 结束偏移周期
				if (fields[14].trim().length() > 0)
					result.setExpireddate(format.parse(fields[14]));// 优惠结束日期
				if (fields[15].trim().length() > 0)
					result.setIspresent(new Byte(fields[15]));// 是否赠费
				if (fields[16].trim().length() > 0)
					result.setPresenttype(fields[16]);// 赠送方式
				if (fields[17].trim().length() > 0)
					result.setReladiscid(new Long(fields[17]));// 本金优惠标识
				if (fields[18].trim().length() > 0)
					result.setAffixid(fields[18]);// 附加属性编码
				if (fields[19].trim().length() > 0)
					result.setFeesourcetype(fields[19]);// 扣费来源类型
				if (fields[20].trim().length() > 0)
					result.setFeesourceid(new Long(fields[20]));// 扣费帐目标识
				if (fields[21].trim().length() > 0)
					result.setRemark(fields[21]);// 说明
				if (fields[22].trim().length() > 0)
					result.setPayinterval(new Integer(fields[22]));// 支付间隔
				if (fields[23].trim().length() > 0)
					result.setValidity(new Integer(fields[23]));// 有效期天数
				if (fields[24].trim().length() > 0)
					result.setPesenteboxunitid(new Long(fields[24]));// 补贴优惠账本科目标识
			}
			// 修改
			if ("1".equals(oprtype)) {
				result.setEboxdiscid(new Long(fields[0]));// 帐户预存优惠标识
				result.setYxplanid(new Long(fields[1]));// 营销方案标识
				if (fields[2].trim().length() > 0)
					result.setEboxunitid(new Long(fields[2]));// 到达账本科目
				if (fields[3].trim().length() > 0)
					result.setInplanid(new Long(fields[3]));// 智能网营销方案标识
				if (fields[4].trim().length() > 0)
					result.setEffectivetype(fields[4]);// 帐户预存优惠生效类型
				if (fields[5].trim().length() > 0)
					result.setEffectivedate(format.parse(fields[5]));// 开始生效时间
				if (fields[6].trim().length() > 0)
					result.setEffectiveinterval(new Integer(fields[6]));// 生效时间间隔
				if (fields[7].trim().length() > 0)
					result.setIspostpone(new Byte(fields[7]));// 是否顺延
				if (fields[8].trim().length() > 0)
					result.setPaytimes(new Integer(fields[8]));// 支付次数
				if (fields[9].trim().length() > 0)
					result.setAmount(new Long(fields[9]));// 金额/比例
				if (fields[10].trim().length() > 0)
					result.setEnterunitdetflag(new Byte(fields[10]));// 是否进入帐目明细
				if (fields[11].trim().length() > 0)
					result.setDisctype(fields[11]);// 帐户预存优惠类型
				if (fields[12].trim().length() > 0)
					result.setRollovertype(fields[12]);// 帐户预存优惠结转类型
				if (fields[13].trim().length() > 0)
					result.setEffectivecycles(new Integer(fields[13]));// 开始偏移周期
				if (fields[14].trim().length() > 0)
					result.setExpiredcycles(new Integer(fields[14]));// 结束偏移周期
				if (fields[15].trim().length() > 0)
					result.setExpireddate(format.parse(fields[15]));// 优惠结束日期
				if (fields[16].trim().length() > 0)
					result.setIspresent(new Byte(fields[16]));// 是否赠费
				if (fields[17].trim().length() > 0)
					result.setPresenttype(fields[17]);// 赠送方式
				if (fields[18].trim().length() > 0)
					result.setReladiscid(new Long(fields[18]));// 本金优惠标识
				if (fields[19].trim().length() > 0)
					result.setAffixid(fields[19]);// 附加属性编码
				if (fields[20].trim().length() > 0)
					result.setFeesourcetype(fields[20]);// 扣费来源类型
				if (fields[21].trim().length() > 0)
					result.setFeesourceid(new Long(fields[21]));// 扣费帐目标识
				if (fields[22].trim().length() > 0)
					result.setRemark(fields[22]);// 说明
				if (fields[23].trim().length() > 0)
					result.setPayinterval(new Integer(fields[23]));// 支付间隔
				if (fields[24].trim().length() > 0)
					result.setValidity(new Integer(fields[24]));// 有效期天数
				if (fields[25].trim().length() > 0)
					result.setPesenteboxunitid(new Long(fields[25]));// 补贴优惠账本科目标识
			}

			return result;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 检查入库文件的合法性(正则表达式匹配)
	 * 
	 * @param fields
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ResultBean doCheck(String[] fields, User user, String oprtype)
			throws Exception {

		EBoxUnitDAO ebdao = (EBoxUnitDAO) DAOFactory.build(EBoxUnitDAO.class,
				user);

		ResultBean result = new ResultBean();
		result.setCode(0);
		result.setInfo("");
		
		if ("0".equals(oprtype)) {// 增加

			YxPlanDAO yxdao = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class,
					user);

			if (fields.length != 25) {
				result.setCode(88);
				result.setInfo("导入文件格式字段数不对，正确为25个");
				return result;
			}
			checkYxplanID(fields[0],user);
			// 业务检查，如果不需要的，全部赋空
			// 帐户预存优惠生效类型="FIX_DATE"(指定日期生),生效时间间隔无效
			// 帐户预存优惠生效类型="AFTER_MONS_1ST"(指定日期生),开始生效时间
			if (fields[3].equals("FIX_DATE")) {
				fields[5] = "";
			} else if (fields[3].equals("AFTER_MONS_1ST")) {
				fields[4] = "";
			}

			// 是否赠费为0，赠送方式、本金优惠标识均不可用
			// 为1的话，附加属性编码不可用，如果赠送方式为按金额，那么本金优惠标识不可用
			if (fields[15].equals("0")) {
				fields[16] = "";
				fields[17] = "";
			} else if (fields[15].equals("1")) {
				fields[18] = "";
				if (fields[16].equals("PresentAmount")) {
					fields[17] = "";
				}
			}

			// 扣费来源类型为现金时，扣费帐目标识不能用
			if (fields[19].equals("FeeSrcCash")) {
				fields[20] = "";
			}

			// 对字段逐一进行检查
			for (int i = 0; i < fields.length; i++) {

				// 只要检查到一个错误，跳出，不再检查
				if (result.getCode() != 0)
					break;

				switch (i) {

				// 营销方案标识0
				case 0:
					if (!fields[i].matches("[0-9]{14}")) {
						result.setCode(77);
						result.setInfo("[营销方案标识]出错，必须为14位数字");
					}
					if (result.getCode() == 0 && !fields[i].trim().equals("")) {
						YxPlanListVO listvo = new YxPlanListVO();
						listvo.set_ne_yxplanid(fields[i]);
						if (yxdao.count(listvo) == 0) {
							result.setCode(78);
							result.setInfo("[营销方案标识]" + fields[i] + "不存在!");
						}

					}
					;
					break;

				// 到达账本科目1
				case 1:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[到达账本科目]类型不符合要求，应该为数字");
					}
					if (result.getCode() == 0 && !fields[i].trim().equals("")) {
						EBoxUnitListVO listvo = new EBoxUnitListVO();
						listvo.set_ne_eboxunitid(fields[i]);
						if (ebdao.count(listvo) == 0) {
							result.setCode(78);
							result.setInfo("[到达账本科目]" + fields[i] + "不存在!");
						}
					}
					;
					break;

				// 智能网营销方案标识2
				case 2:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[智能网营销方案标识]类型不符合要求，应该为数字");
					}
					;
					break;

				// 帐户预存优惠生效类型3
				case 3:
					if (fields[i].length() > 32) {
						result.setCode(77);
						result.setInfo("[帐户预存优惠生效类型]长度不对,范围应该在(0~32)");
					}
					;
					break;

				// 开始生效时间4
				case 4:
					if (!fields[i].trim().equals("")) {
						try {
							SimpleDateFormat format = new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss");
							format.parse(fields[i]);
						} catch (Exception e) {
							result.setCode(77);
							result
									.setInfo("[开始生效时间]格式不对，正确格式为[yyyy-MM-dd HH:mm:ss]");
						}
					}
					;
					break;

				// 生效时间间隔5
				case 5:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[生效时间间隔]类型不符合要求，应该在数字");
					}
					;
					break;

				// 是否顺延6
				case 6:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-1]+")) {
						result.setCode(77);
						result.setInfo("[是否顺延]格式不对,只能为数字0或1");
					}
					;
					break;

				// 支付次数7
				case 7:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[支付次数]格式不对,应该为数字型");
					}
					;
					break;

				// 金额/比例8
				case 8:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[金额/比例]格式不对,应该为数字型");
					}
					;
					break;

				// 是否进入帐目明细9
				case 9:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-1]")) {
						result.setCode(77);
						result.setInfo("[是否进入帐目明细]格式不对,只能为数字0或1");
					}
					;
					break;

				// 帐户预存优惠类型10
				case 10:
					if (fields[i].length() > 32) {
						result.setCode(77);
						result.setInfo("[帐户预存优惠类型]长度不对,范围应该在0~32");
					}
					;
					break;

				// 帐户预存优惠结转类型11
				case 11:
					if (fields[i].length() > 32) {
						result.setCode(77);
						result.setInfo("[帐户预存优惠结转类型]长度不对,范围应该在0~32");
					}
					;
					break;

				// 开始偏移周期12
				case 12:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[开始偏移周期]格式不对,应该为数字型");
					}
					;
					break;

				// 结束偏移周期13
				case 13:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[结束偏移周期]格式不对,应该为数字型");
					}
					;
					break;

				// 优惠结束日期14
				case 14:
					if (!fields[i].trim().equals("")) {
						try {
							SimpleDateFormat format = new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss");
							format.parse(fields[i]);
						} catch (Exception e) {
							result.setCode(77);
							result
									.setInfo("[优惠结束日期]格式不对，正确格式为[yyyy-MM-dd HH:mm:ss]");
						}
					}
					;
					break;

				// 是否赠费15
				case 15:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-1]")) {
						result.setCode(77);
						result.setInfo("[是否赠费]格式不对,只能为数字0或1");
					}
					;
					break;

				// 赠送方式16
				case 16:
					if (fields[i].length() > 16) {
						result.setCode(77);
						result.setInfo("[赠送方式]长度不对,范围应该在0~16");
					}
					;
					break;

				// 本金优惠标识17
				case 17:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[本金优惠标识]格式不对,应该为数字型");
					}
					;
					break;

				// 附加属性编码18
				case 18:
					if (fields[i].length() > 16) {
						result.setCode(77);
						result.setInfo("[附加属性编码]长度不对,范围应该在0~16");
					}
					;
					break;

				// 扣费来源类型19
				case 19:
					if (fields[i].length() > 16) {
						result.setCode(77);
						result.setInfo("[扣费来源类型]长度不对,范围应该在0~16");
					}
					;
					break;

				// 扣费帐目标识20
				case 20:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[扣费帐目标识]格式不对,应该为数字型");
					}
					;
					break;

				// 说明21
				case 21:
					if (fields[i].length() > 255) {
						result.setCode(77);
						result.setInfo("[扣费来源类型]长度不对,范围应该在0~255");
					}
					;
					break;
				// 支付间隔22
				case 22:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[支付间隔]格式不对,应该为数字型");
					}
					;
					break;

				// 有效期天数23
				case 23:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[有效期天数]格式不对,应该为数字型");
					}
					;
					break;
				
				case 24:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[补贴优惠账本科目标识]格式不对,应该为数字型");
					}
					;
					break;
				}
			}

			int payinterval = 0;
			int paytimes = 0;
			int cycles = 0;
			int pro = 0;
			try {
				payinterval = "".equals(fields[22].trim()) ? 0 : new Integer(
						fields[22]).intValue();
				paytimes = "".equals(fields[7].trim()) ? 0 : new Integer(
						fields[7]).intValue();
				cycles = "".equals(fields[13].trim()) ? 0 : new Integer(
						fields[13]).intValue();
				pro = payinterval * paytimes;
			} catch (Exception e) {
				result.setCode(77);
				result.setInfo("字符型转化为数字型类型报错");
				return result;
			}
			// 帐户预存优惠结转类型11
			if (!"1".equals(fields[11].trim())
					&& !"0".equals(fields[11].trim())) {
				result.setCode(77);
				result.setInfo("[帐户预存优惠结转类型]格式不对,只能为数字0或1");
				return result;
			}
			if (fields[11].trim().equals("0") && cycles >= 1) {
				// ok
			} else {
				if (fields[11].trim().equals("1")) {
					if (cycles == -1 || cycles >= pro) {
						// ok
					} else {
						result.setCode(77);
						result
								.setInfo("帐户预存优惠结转类型直角梯形时,结束偏移周期必须为-1或者大于等于支付次数*支付间隔");
						return result;
					}
				} else {
					result.setCode(77);
					result.setInfo("帐户预存优惠结转类型为平行四边形时,结束偏移周期必须大于等于1");
					return result;
				}
			}

		} else if ("1".equals(oprtype)) {// 修改
			EboxdiscDAO dao = (EboxdiscDAO) DAOFactory.build(EboxdiscDAO.class,
					user);// 用于查询该记录是否存在

			if (fields.length != 26) {
				result.setCode(88);
				result.setInfo("导入文件格式字段数不对，正确为26个");
				return result;
			}
			checkYxplanID(fields[1],user);
			// 对主键进行存在性检查
			if (!fields[0].trim().equals("") && !fields[1].trim().equals("")) {
				if(!CheckUtil.checkNum(fields[0]))
				{
					throw new Exception("[帐户预存优惠标识]必须为数字");
				}
				EboxdiscListVO listvo = new EboxdiscListVO();
				listvo.set_ne_eboxdiscid(fields[0]);
				listvo.set_ne_yxplanid(fields[1]);
				if (dao.count(listvo) == 0) {
					result.setCode(100);
					result.setInfo("修改失败，系统不存在营销方案标识" + fields[1]
							+ "下的帐户预存优惠标识为" + fields[0] + "的记录");
				}
			}

			// 业务检查，如果不需要的，全部赋空
			// 帐户预存优惠生效类型="FIX_DATE"(指定日期生),生效时间间隔无效
			// 帐户预存优惠生效类型="AFTER_MONS_1ST"(指定日期生),开始生效时间
			if (fields[4].equals("FIX_DATE")) {
				fields[6] = "";
			} else if (fields[4].equals("AFTER_MONS_1ST")) {
				fields[5] = "";
			}

			// 是否赠费为0，赠送方式、本金优惠标识均不可用
			// 为1的话，附加属性编码不可用，如果赠送方式为按金额，那么本金优惠标识不可用
			if (fields[16].equals("0")) {
				fields[17] = "";
				fields[18] = "";
			} else if (fields[16].equals("1")) {
				fields[19] = "";
				if (fields[17].equals("PresentAmount")) {
					fields[18] = "";
				}
			}

			// 扣费来源类型为现金时，扣费帐目标识不能用
			if (fields[20].equals("FeeSrcCash")) {
				fields[21] = "";
			}

			// 对字段逐一进行检查
			for (int i = 2; i < fields.length; i++) {

				// 只要检查到一个错误，跳出，不再检查
				if (result.getCode() != 0)
					break;

				switch (i) {
				// 到达账本科目2
				case 2:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[到达账本科目]类型不符合要求，应该为数字");
					}
					if (result.getCode() == 0 && !fields[i].trim().equals("")) {
						EBoxUnitListVO listvo = new EBoxUnitListVO();
						listvo.set_ne_eboxunitid(fields[i]);
						if (ebdao.count(listvo) == 0) {
							result.setCode(78);
							result.setInfo("[到达账本科目]" + fields[i] + "不存在!");
						}
					}
					;
					break;

				// 智能网营销方案标识3
				case 3:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[智能网营销方案标识]类型不符合要求，应该为数字");
					}
					;
					break;

				// 帐户预存优惠生效类型4
				case 4:
					if (fields[i].length() > 32) {
						result.setCode(77);
						result.setInfo("[帐户预存优惠生效类型]长度不对,范围应该在(0~32)");
					}
					;
					break;

				// 开始生效时间5
				case 5:
					if (!fields[i].trim().equals("")) {
						try {
							SimpleDateFormat format = new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss");
							format.parse(fields[i]);
						} catch (Exception e) {
							result.setCode(77);
							result
									.setInfo("[开始生效时间]格式不对，正确格式为[yyyy-MM-dd HH:mm:ss]");
						}
					}
					;
					break;

				// 生效时间间隔6
				case 6:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[生效时间间隔]类型不符合要求，应该在数字");
					}
					;
					break;

				// 是否顺延7
				case 7:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-1]+")) {
						result.setCode(77);
						result.setInfo("[是否顺延]格式不对,只能为数字0或1");
					}
					;
					break;

				// 支付次数8
				case 8:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[支付次数]格式不对,应该为数字型");
					}
					;
					break;

				// 金额/比例9
				case 9:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[金额/比例]格式不对,应该为数字型");
					}
					;
					break;

				// 是否进入帐目明细10
				case 10:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-1]")) {
						result.setCode(77);
						result.setInfo("[是否进入帐目明细]格式不对,只能为数字0或1");
					}
					;
					break;

				// 帐户预存优惠类型11
				case 11:
					if (fields[i].length() > 32) {
						result.setCode(77);
						result.setInfo("[帐户预存优惠类型]长度不对,范围应该在0~32");
					}
					;
					break;

				// 帐户预存优惠结转类型12
				case 12:
					if (fields[i].length() > 32) {
						result.setCode(77);
						result.setInfo("[帐户预存优惠结转类型]长度不对,范围应该在0~32");
					}
					;
					break;

				// 开始偏移周期13
				case 13:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[开始偏移周期]格式不对,应该为数字型");
					}
					;
					break;

				// 结束偏移周期14
				case 14:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[结束偏移周期]格式不对,应该为数字型");
					}
					;
					break;

				// 优惠结束日期15
				case 15:
					if (!fields[i].trim().equals("")) {
						try {
							SimpleDateFormat format = new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss");
							format.parse(fields[i]);
						} catch (Exception e) {
							result.setCode(77);
							result
									.setInfo("[优惠结束日期]格式不对，正确格式为[yyyy-MM-dd HH:mm:ss]");
						}
					}
					;
					break;

				// 是否赠费16
				case 16:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-1]")) {
						result.setCode(77);
						result.setInfo("[是否赠费]格式不对,只能为数字0或1");
					}
					;
					break;

				// 赠送方式17
				case 17:
					if (fields[i].length() > 16) {
						result.setCode(77);
						result.setInfo("[赠送方式]长度不对,范围应该在0~16");
					}
					;
					break;

				// 本金优惠标识18
				case 18:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[本金优惠标识]格式不对,应该为数字型");
					}
					;
					break;

				// 附加属性编码19
				case 19:
					if (fields[i].length() > 16) {
						result.setCode(77);
						result.setInfo("[附加属性编码]长度不对,范围应该在0~16");
					}
					;
					break;

				// 扣费来源类型20
				case 20:
					if (fields[i].length() > 16) {
						result.setCode(77);
						result.setInfo("[扣费来源类型]长度不对,范围应该在0~16");
					}
					;
					break;

				// 扣费帐目标识21
				case 21:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[扣费帐目标识]格式不对,应该为数字型");
					}
					;
					break;

				// 说明22
				case 22:
					if (fields[i].length() > 255) {
						result.setCode(77);
						result.setInfo("[扣费来源类型]长度不对,范围应该在0~255");
					}
					;
					break;
				// 支付间隔23
				case 23:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[支付间隔]格式不对,应该为数字型");
					}
					;
					break;
				// 有效期天数24
				case 24:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[有效期天数]格式不对,应该为数字型");
					}
					;
					break;
				case 25:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[补贴优惠账本科目标识]格式不对,应该为数字型");
					}
					;
					break;
				}
			}

			int payinterval = 0;
			int paytimes = 0;
			int cycles = 0;
			int pro = 0;
			try {
				payinterval = "".equals(fields[23].trim()) ? 0 : new Integer(
						fields[23]).intValue();
				paytimes = "".equals(fields[8].trim()) ? 0 : new Integer(
						fields[8]).intValue();
				cycles = "".equals(fields[14].trim()) ? 0 : new Integer(
						fields[14]).intValue();
				pro = payinterval * paytimes;
			} catch (Exception e) {
				result.setCode(77);
				result.setInfo("字符型转化为数字型类型报错");
				return result;
			}
			// 帐户预存优惠结转类型12
			if (!"1".equals(fields[12].trim())
					&& !"0".equals(fields[12].trim())) {
				result.setCode(77);
				result.setInfo("[帐户预存优惠结转类型]格式不对,只能为数字0或1");
				return result;
			}
			if (fields[12].trim().equals("0") && cycles >= 1) {
				// ok
			} else {
				if (fields[12].trim().equals("1")) {
					if (cycles == -1 || cycles >= pro) {
						// ok
					} else {
						result.setCode(77);
						result
								.setInfo("帐户预存优惠结转类型直角梯形时,结束偏移周期必须为-1或者大于等于支付次数*支付间隔");
						return result;
					}
				} else {
					result.setCode(77);
					result.setInfo("帐户预存优惠结转类型为平行四边形时,结束偏移周期必须大于等于1");
					return result;
				}
			}

		} else {
			result.setCode(100);
			result.setInfo("请选择正确的操作类型(增加/修改/删除)!");
		}

		return result;
	}

	/**
	 * 新增“账本科目标识”和“扣费帐目标识”逻辑检查
	 * 
	 * @param vo
	 * @param user
	 */
	private void doCheckCreate(EboxdiscVO vo, User user) throws Exception {// 检查

		// 检查 [账本科目标识]&[扣费帐目标识]状态是否为可用[1]
		EBoxUnitDAO eboxUnitDAO = (EBoxUnitDAO) DAOFactory.build(
				EBoxUnitDAO.class, user);
		EBoxUnitVO eboxUnitidVO = new EBoxUnitVO();
		EBoxUnitVO FeesourceidVO = new EBoxUnitVO();
		if (vo.getEboxunitid() != null) {
			eboxUnitidVO = (EBoxUnitVO) eboxUnitDAO
					.findByPk(vo.getEboxunitid());
		}
		if (vo.getFeesourceid() != null) {
			FeesourceidVO = (EBoxUnitVO) eboxUnitDAO.findByPk(vo
					.getFeesourceid());
		}

		if (eboxUnitidVO != null && FeesourceidVO != null)

			if (FeesourceidVO.getEboxunitstate() != null
					&& eboxUnitidVO.getEboxunitstate() != null) {
				int flag = 1;
				if (flag != FeesourceidVO.getEboxunitstate().intValue()
						&& flag != eboxUnitidVO.getEboxunitstate().intValue()) {
					throw new BusinessException("",
							"保存失败：输入的[账本科目标识]和[扣费帐目标识]已禁用");
				}
			}
		if (eboxUnitidVO != null)

			if (eboxUnitidVO.getEboxunitstate() != null) {
				int flag = 1;
				if (flag != eboxUnitidVO.getEboxunitstate().intValue()) {
					throw new BusinessException("", "保存失败：[账本科目标识]已禁用");
				}
			}
		if (FeesourceidVO != null)

			if (FeesourceidVO.getEboxunitstate() != null) {
				int flag = 1;
				if (flag != FeesourceidVO.getEboxunitstate().intValue()) {
					throw new BusinessException("", "保存失败：[扣费帐目标识]已禁用");
				}
			}
	}
	private void checkYxplanID(String yxplanid,User user) throws Exception
	{
		if(!CheckUtil.checkNum(yxplanid,14))
		{
			throw new Exception("营销方案标识为不长于14位长度的数字并且不能为空:"+yxplanid);
		}
		String areacode=new YxPlanDelegate().getAreacode(new Long(StringUtils.trim(yxplanid)), user);
		if(areacode==null)
		{
			throw new Exception("营销方案标识在主表中不存在!"+yxplanid);
		}
		if(user.isProvinceUser())
		{
			if(!"999".equals(areacode) && !"100".equals(areacode))
			{
				throw new Exception("省级工号只能操作省级营销方案! 出错信息:"+yxplanid);
			}
		}else 
		{
			if(!areacode.equals(user.getCityid()))
			{
				throw new Exception("该登录用户只能操作本地市营销方案! 出错信息:"+yxplanid);
			}
		}
	}

}
