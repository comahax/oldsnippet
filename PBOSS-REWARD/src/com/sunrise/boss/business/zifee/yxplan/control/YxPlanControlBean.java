package com.sunrise.boss.business.zifee.yxplan.control;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemDAO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.zifee.eboxdisc.persistent.EboxdiscDAO;
import com.sunrise.boss.business.zifee.eboxdisc.persistent.EboxdiscListVO;
import com.sunrise.boss.business.zifee.eboxdisc.persistent.EboxdiscVO;
import com.sunrise.boss.business.zifee.feedisc.persistent.FeediscDAO;
import com.sunrise.boss.business.zifee.feedisc.persistent.FeediscListVO;
import com.sunrise.boss.business.zifee.feedisc.persistent.FeediscVO;
import com.sunrise.boss.business.zifee.feediscmonth.persistent.FeediscmonthDAO;
import com.sunrise.boss.business.zifee.feediscmonth.persistent.FeediscmonthListVO;
import com.sunrise.boss.business.zifee.feediscmonth.persistent.FeediscmonthVO;
import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeediscDAO;
import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeediscListVO;
import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeediscVO;
import com.sunrise.boss.business.zifee.minconsume.persistent.MinconsumeDAO;
import com.sunrise.boss.business.zifee.minconsume.persistent.MinconsumeListVO;
import com.sunrise.boss.business.zifee.minconsume.persistent.MinconsumeVO;
import com.sunrise.boss.business.zifee.plandisccode.persistent.PlandisccodeDAO;
import com.sunrise.boss.business.zifee.plandisccode.persistent.PlandisccodeListVO;
import com.sunrise.boss.business.zifee.plandisccode.persistent.PlandisccodeVO;
import com.sunrise.boss.business.zifee.prodservset.persistent.ProdservsetDAO;
import com.sunrise.boss.business.zifee.prodservset.persistent.ProdservsetVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanDAO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanListVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanVO;
import com.sunrise.boss.business.zifee.yxplancplog.persistent.YxplancplogDAO;
import com.sunrise.boss.business.zifee.yxplancplog.persistent.YxplancplogVO;
import com.sunrise.boss.business.zifee.yxplanpresnt.persistent.YxplanpresntDAO;
import com.sunrise.boss.business.zifee.yxplanpresnt.persistent.YxplanpresntListVO;
import com.sunrise.boss.business.zifee.yxplanpresnt.persistent.YxplanpresntVO;
import com.sunrise.boss.business.zifee.yxplansplitscale.persistent.YxPlanSplitScaleDAO;
import com.sunrise.boss.business.zifee.yxplansplitscale.persistent.YxPlanSplitScaleListVO;
import com.sunrise.boss.business.zifee.yxplansplitscale.persistent.YxPlanSplitScaleVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.zifee.yxplan.YxPlanDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.integration.IntegrationBean;
import com.sunrise.boss.ui.zifee.commons.ResultBean;

/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/zifee/yxplan/control/YxPlanControlBean"
 *           name="YxPlanControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class YxPlanControlBean extends AbstractControlBean implements
		YxPlanControl {

	public YxPlanVO doCreate(YxPlanVO vo, User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			YxPlanDAO dao = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class, user);
			// vo.setStartdate(new java.sql.Date(2006,4,1));
			// vo.setStopdate(new java.sql.Date(2006,5,1));
			// vo.setYxplanid(Long.valueOf(1));
			// vo.setYxplanname("weww");
			if (vo.getSpecialflag() == null || "".equals(vo.getSpecialflag())) {
				vo.setSpecialflag("0");
			}
			if (vo.getYxplanshortname() == null
					|| "".equals(vo.getYxplanshortname().trim())) {
				if (vo.getYxplanname() == null || "".equals(vo.getYxplanname())) {
					throw new Exception("新增时营销方案名称不能为空");
				}
				vo.setYxplanshortname(vo.getYxplanname());
			}
			return (YxPlanVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(YxPlanVO vo, User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			YxPlanDAO dao = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public YxPlanVO doUpdate(YxPlanVO vo, User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			if (vo.getYxplanshortname() == null
					|| "".equals(vo.getYxplanshortname().trim())) {
				if (vo.getYxplanname() != null
						&& !"".equals(vo.getYxplanname())) {
					vo.setYxplanshortname(vo.getYxplanname());
				}
			}
			YxPlanDAO dao = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class, user);
			return (YxPlanVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public YxPlanVO doFindByPk(Serializable pk, User user) throws Exception {
		// TODO Auto-generated method stub
		YxPlanDAO dao = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class, user);
		dao.setDbFlag("DB_COMMON", false);
		//dao.setDbFlag("DB_BOSSCOMMON", false);
		return (YxPlanVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(YxPlanListVO params, User user) throws Exception {
		// TODO Auto-generated method stub
		YxPlanDAO dao = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class, user);
		//dao.setDbFlag("DB_BOSSCOMMON", false);
		dao.setDbFlag("DB_COMMON", false);
		return dao.query(params);
	}

	public Long getYxplanSeq(User user) throws Exception {
		YxPlanDAO dao = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class, user);
		return (Long) dao.getSequence("PC_PS_YXPlAN_SEQ");// 直接到oracle里面取seq的值
	}

	/**
	 * 批量新增营销方案
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public YxPlanVO doBatchCreate(YxPlanVO vo, User user) throws Exception {
		YxPlanDAO dao = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class, user);
		YxPlanVO yxplanvo = (YxPlanVO) dao.findByPk(vo.getYxplanid());
		if (yxplanvo != null) {
			throw new BusinessException("", "新增的记录已经在数据库中");
		}
		if (StringUtils.isEmpty(vo.getAreacode())) {
			throw new Exception("要新增的营销方案区域标识为空");
		}
		if (user.isProvinceUser()) {
			DictitemDAO dictitemdao = (DictitemDAO) DAOFactory.build(
					DictitemDAO.class, user);
			DictitemListVO dictitemlist = new DictitemListVO();
			dictitemlist.set_se_groupid("PC_YXPLANAREACODE");
			dictitemlist.set_se_dictid(vo.getAreacode());
			if (dictitemdao.query(dictitemlist).getRowCount() == 0) {
				throw new BusinessException("", "区域标识" + vo.getAreacode()
						+ "不存在!");
			}
			if (!"100".equals(vo.getYxplanid().toString().substring(0, 3))) {
				throw new Exception("全省工号只能录入前三位为100的营销方案ID.");
			}
			if (!"100".equals(vo.getAreacode())
					&& !"999".equals(vo.getAreacode())) {
				throw new BusinessException("", "全省工号新增的营销方案区域标识必须是\"100\"");
			}
		} else {
			if (!user.getCityid().equals(vo.getAreacode())) {
				throw new BusinessException("", "新增的营销方案区域标识与当前操作员的区域标识不一致!");
			}
			if (!vo.getYxplanid().toString().substring(0, 3).equals(
					user.getCityid())) {
				throw new Exception("新营销方案标识前3位不合法，应为操作员所在地市标识.");
			}
		}

		checkPlanType(vo, user);
		checkuploadcalcfeekind(vo, user);
		// 屏蔽specialFlag字段，但要给默认的值0，
		if (vo.getSpecialflag() == null || "".equals(vo.getSpecialflag())) {
			vo.setSpecialflag("0");
		}
		if (vo.getYxplanshortname() == null
				|| "".equals(vo.getYxplanshortname().trim())) {
			if (vo.getYxplanname() == null || "".equals(vo.getYxplanname())) {
				throw new Exception("修改时原营销方案名称不能为空");
			}
			vo.setYxplanshortname(vo.getYxplanname());
		}
		try {
			return (YxPlanVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}

	}

	/**
	 * 批量更新营销方案
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public YxPlanVO doBatchUpdate(YxPlanVO vo1, User user) throws Exception {
		YxPlanDAO dao = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class, user);
		YxPlanVO yxplanvo = (YxPlanVO) dao.findByPk(vo1.getYxplanid());
		if (yxplanvo == null) {
			throw new BusinessException("", "要修改的记录不在数据库中!");
		}
		// 判断历史记录是否一致
		if (user.isProvinceUser()) {
			DictitemDAO dictitemdao = (DictitemDAO) DAOFactory.build(
					DictitemDAO.class, user);
			DictitemListVO dictitemlist = new DictitemListVO();
			dictitemlist.set_se_groupid("PC_YXPLANAREACODE");
			dictitemlist.set_se_dictid(vo1.getAreacode());
			if (dictitemdao.query(dictitemlist).getRowCount() == 0) {
				throw new BusinessException("", "区域标识" + vo1.getAreacode()
						+ "不存在!");
			}
			// if(!"100".equals(vo1.getYxplanid().toString().substring(0, 3)))
			// {
			// throw new Exception("全省工号只能录入前三位为100的营销方案ID.");
			// }
			if (!"999".equals(vo1.getAreacode())
					&& !"100".equals(vo1.getAreacode())) {
				throw new BusinessException("", "修改的营销方案区域标识与当前操作员的区域标识不一致!");
			}
		} else {
			if (!vo1.getAreacode().equals(user.getCityid())) {
				throw new BusinessException("", "修改的营销方案区域标识与当前操作员的区域标识不一致!");
			}
		}
		String areacode = yxplanvo.getAreacode();

		if (vo1.getUploadcalcfeekind() != null) {
			checkuploadcalcfeekind(vo1, user);
		}
		if (vo1.getPlantype() != null) {
			checkPlanType(vo1, user);
		}
		if (vo1.getYxplanshortname() == null
				|| "".equals(vo1.getYxplanshortname())) {
			if (vo1.getYxplanname() != null && !"".equals(vo1.getYxplanname())) {
				vo1.setYxplanshortname(vo1.getYxplanname());
			}
		}
		// 屏蔽了specialflag字段，因此更改了setSaveVO方法，恢复之后记得改回来
		setSaveVO(yxplanvo, vo1);
		yxplanvo.setAreacode(areacode);
		try {
			return (YxPlanVO) dao.update(yxplanvo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	/**
	 * 检测上传算费方案类别
	 * 
	 * @param feedVO
	 * @param user
	 * @throws Exception
	 */
	private void checkuploadcalcfeekind(YxPlanVO yxPlanVO, User user)
			throws Exception {
		DictitemDAO delegate = (DictitemDAO) DAOFactory.build(
				DictitemDAO.class, user);
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid("PC_UPLOADCALCFEEKIND");
		listVO.set_se_dictid(yxPlanVO.getUploadcalcfeekind().toString());
		if (delegate.query(listVO).getRowCount() == 0) {
			throw new Exception(
					"上传算费方案类别字段内容不合法，请参考0. 不算费方案;1. 下下月生效方案;2. 绝对下月生效方案;3. 本月立即生效方案;4. 算费实时生效方案;5. 预付费方案");
		}
	}

	/**
	 * 检测 套餐类型
	 */
	private void checkPlanType(YxPlanVO yxPlanVO, User user) throws Exception {
		DictitemDAO delegate = (DictitemDAO) DAOFactory.build(
				DictitemDAO.class, user);
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid("PC_PLANTYPE");
		listVO.set_se_dictid(yxPlanVO.getPlantype().toString());
		if (delegate.query(listVO).getRowCount() == 0) {
			throw new Exception(
					"套餐类型字段内容不合法，请参考[SMS，GPRS，IP，MMS，RING，OTHERS，VOICE]");
		}
	}

	/**
	 * 将游离对象的值赋到持久对象中
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	protected void setSaveVO(Object yxplanvo, Object newVO) throws Exception {
		YxPlanVO tempVO = (YxPlanVO) yxplanvo;
		if (tempVO.getSpecialflag() != null
				&& "".equals(tempVO.getSpecialflag())) {
			((YxPlanVO) newVO).setSpecialflag(tempVO.getSpecialflag());
		}
		com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(yxplanvo,
				newVO);
	}

	/**
	 * 根据字符串构造YxPlanVO
	 * 
	 * @param fields
	 * @param user
	 * @return
	 * @throws Exception
	 *             营销方案标识0|营销方案名称1|全省标识2|启动日期3|停用日期4|区域标识5|最低消费额6|最低消费跨越周期7|
	 *             是否需要捆绑套餐8|捆绑期9|是否允许预约10|是否预收月租11|可享用次数12|最小优惠周期数13|优惠起算偏移量14|
	 *             起算时间单元15|生效时间规则16|营销方案分组标识17|是否备份18|是否打印到受理单19|
	 *             是否算费优惠20|是否营业费优惠21|停机状态是否收取月租费22|是否网外成员优惠23|来源24|营销类别25|
	 *             营销方案类别26|特殊方案标志27|优惠范围28|资费说明29|说明30|
	 */
	public YxPlanVO buildVO(String[] fields, User user) throws Exception {
		YxPlanVO result = null;
		try {
			result = new YxPlanVO();
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");

			result.setYxplanid(new Long(fields[0]));// 营销方案标识
			result.setYxplanname(fields[1]);// 营销方案名称
			result.setYxplancode(fields[2]);// 全省标识
			result.setStartdate(format.parse(fields[3]));// 启动日期
			result.setStopdate(format.parse(fields[4]));// 停用日期
			result.setCheckercode(user.getOpercode());// 审批人工号
			result.setOperatorcode(user.getOpercode());// 操作员工号
			if (fields[5].trim().length() > 0)
				result.setAreacode(fields[5]);// 区域标识
			if (fields[6].trim().length() > 0)
				result.setMinconsume(new Double(fields[6]));// 最低消费额
			if (fields[7].trim().length() > 0)
				result.setConsumecycle(new Long(fields[7]));// 最低消费跨越周期
			if (fields[8].trim().length() > 0)
				result.setBindpackageflag(new Byte(fields[8]));// 是否需要捆绑套餐
			if (fields[9].trim().length() > 0)
				result.setBindmonths(new Long(fields[9]));// 捆绑期
			if (fields[10].trim().length() > 0)
				result.setBookflag(new Byte(fields[10]));// 是否允许预约
			if (fields[11].trim().length() > 0)
				result.setRcprepayflag(new Byte(fields[11]));// 是否预收月租
			if (fields[12].trim().length() > 0)
				result.setCouldusetimes(new Long(fields[12]));// 可享用次数
			if (fields[13].trim().length() > 0)
				result.setMindisccycle(new Long(fields[13]));// 最小优惠周期数
			if (fields[14].trim().length() > 0)
				result.setDiscoffset(new Long(fields[14]));// 优惠起算偏移量
			if (fields[15].trim().length() > 0)
				result.setTimeunit(fields[15]);// 起算时间单元
			if (fields[16].trim().length() > 0)
				result.setStarttimetype(new Byte(fields[16]));// 生效时间规则
			if (fields[17].trim().length() > 0)
				result.setYxplangroupid(new Long(fields[17]));// 营销方案分组标识
			result.setGroupflag(new Byte("0"));// 是否营销方案组
			if (fields[18].trim().length() > 0)
				result.setBackupflag(new Byte(fields[18]));// 是否备份
			if (fields[19].trim().length() > 0)
				result.setPrintflag(new Byte(fields[19]));// 是否打印到受理单
			if (fields[20].trim().length() > 0)
				result.setFeecalcprivflag(new Byte(fields[20]));// 是否算费优惠
			if (fields[21].trim().length() > 0)
				result.setRecfeeprivflag(new Byte(fields[21]));// 是否营业费优惠
			if (fields[22].trim().length() > 0)
				result.setStopuserrentflag(new Byte(fields[22]));// 停机状态是否收取月租费
			if (fields[23].trim().length() > 0)
				result.setIsoutmemberpriv(new Byte(fields[23]));// 是否网外成员优惠
			if (fields[24].trim().length() > 0)
				result.setSource(fields[24]);// 来源
			if (fields[25].trim().length() > 0)
				result.setSalestype(new Long(fields[25]));// 营销类别
			if (fields[26].trim().length() > 0)
				result.setPlankind(fields[26]);// 营销方案类别
			if (fields[27].trim().length() > 0)
				result.setSpecialflag(fields[27]);// 特殊方案标志
			if (fields[28].trim().length() > 0)
				result.setDiscscope(fields[28]);// 优惠范围
			if (fields[29].trim().length() > 0)
				result.setFeecomment(fields[29]);// 资费说明
			if (fields[30].trim().length() > 0)
				result.setRemark(fields[30]);// 说明
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
	public ResultBean doCheck(String[] fields, User user) throws Exception {
		ResultBean result = new ResultBean();
		result.setCode(0);
		result.setInfo("");

		if (fields.length != 31) {
			result.setCode(88);
			result.setInfo("导入文件格式字段数不对，正确为31个");
			return result;
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
				;
				break;

			// 营销方案名称1
			case 1:
				if (fields[i].length() < 1 || fields[i].length() > 128) {
					result.setCode(77);
					result.setInfo("[营销方案名称]长度不符合要求，范围应该在(1~128)");
				}
				;
				break;

			// 全省标识2
			case 2:
				if (!fields[i].trim().equals("")
						&& !fields[i]
								.matches("^([a-z|A-Z]{2})([01]{4})([012]{1})((20|19)\\d{2}(0[0-9]{1}|1[012]{1})(0[0-9]{1}|[12]{1}\\d{1}|3[01]{1}))(\\d{3})(\\d{6})(\\d{2})$")) {
					result.setCode(77);
					result.setInfo("全省标识命名不符合要求，具体请参考帮助文件");
				}
				;
				break;

			// 启动日期3
			case 3:
				try {
					SimpleDateFormat format = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					format.parse(fields[i]);
				} catch (Exception e) {
					result.setCode(77);
					result.setInfo("[启动日期]格式不对，正确格式为[yyyy-MM-dd HH:mm:ss]");
				}
				;
				break;

			// 停用日期4
			case 4:
				try {
					SimpleDateFormat format = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					format.parse(fields[i]);
				} catch (Exception e) {
					result.setCode(77);
					result.setInfo("[停用日期]格式不对，正确格式为[yyyy-MM-dd HH:mm:ss]");
				}
				;
				break;

			// 区域标识5
			case 5:
				if (fields[i].length() > 32) {
					result.setCode(77);
					result.setInfo("[区域标识]长度不对,范围应该在(0~32)");
				}
				;
				break;

			// 最低消费额6
			case 6:
				if (!fields[i].trim().equals("")) {
					try {
						new Double(fields[i]);
					} catch (Exception e) {
						result.setCode(77);
						result.setInfo("[最低消费额]格式不对");
					}
				}
				;
				break;

			// 最低消费跨越周期7
			case 7:
				if (!fields[i].trim().equals("")
						&& !fields[i].matches("[0-9\\-]+")) {
					result.setCode(77);
					result.setInfo("[最低消费跨越周期]格式不对,应该为数字型");
				}
				;
				break;

			// 是否需要捆绑套餐8
			case 8:
				if (!fields[i].trim().equals("") && !fields[i].matches("[0-1]")) {
					result.setCode(77);
					result.setInfo("[是否需要捆绑套餐]格式不对,只能为数字0或1");
				}
				;
				break;

			// 捆绑期9
			case 9:
				if (!fields[i].trim().equals("")
						&& !fields[i].matches("[0-9\\-]+")) {
					result.setCode(77);
					result.setInfo("[捆绑期]格式不对,应该为数字型");
				}
				;
				break;

			// 是否允许预约10
			case 10:
				if (!fields[i].trim().equals("") && !fields[i].matches("[0-1]")) {
					result.setCode(77);
					result.setInfo("[是否允许预约]格式不对,只能为数字0或1");
				}
				;
				break;

			// 是否预收月租11
			case 11:
				if (!fields[i].trim().equals("") && !fields[i].matches("[0-1]")) {
					result.setCode(77);
					result.setInfo("[是否预收月租]格式不对,只能为数字0或1");
				}
				;
				break;

			// 可享用次数12
			case 12:
				if (!fields[i].trim().equals("")
						&& !fields[i].matches("[0-9\\-]+")) {
					result.setCode(77);
					result.setInfo("[可享用次数]格式不对,只能为数字0或1");
				}
				;
				break;

			// 最小优惠周期数13
			case 13:
				if (!fields[i].trim().equals("")
						&& !fields[i].matches("[0-9\\-]+")) {
					result.setCode(77);
					result.setInfo("[最小优惠周期数]格式不对,应该为数字型");
				}
				;
				break;

			// 优惠起算偏移量14
			case 14:
				if (!fields[i].trim().equals("")
						&& !fields[i].matches("[0-9\\-]+")) {
					result.setCode(77);
					result.setInfo("[优惠起算偏移量]格式不对,应该为数字型");
				}
				;
				break;

			// 起算时间单元15
			case 15:
				if (fields[i].length() > 32) {
					result.setCode(77);
					result.setInfo("[起算时间单元]长度不对,范围应该在0~32");
				}
				;
				break;

			// 生效时间规则16
			case 16:
				if (!fields[i].trim().equals("") && !fields[i].matches("[0-1]")) {
					result.setCode(77);
					result.setInfo("[生效时间规则]格式不对,只能为数字0或1");
				}
				;
				break;

			// 营销方案分组标识17
			case 17:
				if (!fields[i].trim().equals("")
						&& !fields[i].matches("[0-9\\-]+")) {
					result.setCode(77);
					result.setInfo("[营销方案分组标识]格式不对,应该为数字型");
				}
				;
				break;

			// 是否备份18
			case 18:
				if (!fields[i].trim().equals("") && !fields[i].matches("[0-1]")) {
					result.setCode(77);
					result.setInfo("[是否备份]格式不对,只能为数字0或1");
				}
				;
				break;

			// 是否打印到受理单19
			case 19:
				if (!fields[i].trim().equals("") && !fields[i].matches("[0-1]")) {
					result.setCode(77);
					result.setInfo("[是否打印到受理单]格式不对,只能为数字0或1");
				}
				;
				break;

			// 是否算费优惠20
			case 20:
				if (!fields[i].trim().equals("") && !fields[i].matches("[0-1]")) {
					result.setCode(77);
					result.setInfo("[是否算费优惠]格式不对,只能为数字0或1");
				}
				;
				break;

			// 是否营业费优惠21
			case 21:
				if (!fields[i].trim().equals("") && !fields[i].matches("[0-1]")) {
					result.setCode(77);
					result.setInfo("[是否营业费优惠]格式不对,只能为数字0或1");
				}
				;
				break;

			// 停机状态是否收取月租费22
			case 22:
				if (!fields[i].trim().equals("") && !fields[i].matches("[0-1]")) {
					result.setCode(77);
					result.setInfo("[停机状态是否收取月租费]格式不对,只能为数字0或1");
				}
				;
				break;

			// 是否网外成员优惠23
			case 23:
				if (!fields[i].trim().equals("") && !fields[i].matches("[0-1]")) {
					result.setCode(77);
					result.setInfo("[是否网外成员优惠]格式不对,只能为数字0或1");
				}
				;
				break;

			// 来源24
			case 24:
				if (fields[i].length() > 255) {
					result.setCode(77);
					result.setInfo("[来源]长度不对,范围应该在0~255");
				}
				;
				break;

			// 营销类别25
			case 25:
				if (!fields[i].trim().equals("")
						&& !fields[i].matches("[0-1]{1,2}")) {
					result.setCode(77);
					result.setInfo("[营销类别]格式不对，正确为数字2位数字之内");
				}
				;
				break;

			// 营销方案类别26
			case 26:
				if (fields[i].length() > 32) {
					result.setCode(77);
					result.setInfo("[营销方案类别]长度不对,范围应该在0~32");
				}
				;
				break;

			// 特殊方案标志27
			case 27:
				if (fields[i].length() > 32) {
					result.setCode(77);
					result.setInfo("[特殊方案标志]长度不对,范围应该在0~32");
				}
				;
				break;

			// 优惠范围28
			case 28:
				if (fields[i].length() > 8) {
					result.setCode(77);
					result.setInfo("[优惠范围]长度不对,范围应该在0~8");
				}
				;
				break;

			// 资费说明29
			case 29:
				if (fields[i].length() > 255) {
					result.setCode(77);
					result.setInfo("[资费说明]长度不对,范围应该在0~255");
				}
				;
				break;

			// 说明30
			case 30:
				if (fields[i].length() > 255) {
					result.setCode(77);
					result.setInfo("[说明]长度不对,范围应该在0~255");
				}
				;
				break;

			}
		}

		return result;
	}

	/**
	 * 系统自动生成yxplanid.
	 * 
	 * @param user
	 * @return Long
	 * @throws Exception
	 */
	public Long doGetYxplanID(User user) throws Exception {
		Long result = null;
		YxPlanDAO dao = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class, user);
		String cityid = user.getCityid();
		if (user.isProvinceUser()) {
			cityid = "100";
		}
		do {
			String seqString = "" + getYxplanSeq(user);
			String yxplanid = cityid
					+ StringUtils.repeat("0", 11 - seqString.length())
					+ seqString;
			result = new Long(yxplanid);
		} while (dao.findByPk(result) != null);
		return result;
	}

	public void doSinglecopy(String oldid, String copyitem, YxPlanVO vo,
			boolean f, String filename, User user) throws Exception {
		try {
			YxPlanDAO dao = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class, user);

			String tempstr = "," + copyitem + ",";
			Long newid = vo.getYxplanid();
			String strID = String.valueOf(newid);
			if (strID.length() != 14) {
				throw new Exception("新营销方案标识长度需为14位数字字串");
			}
			if (user.isProvinceUser()) {
				if (!"100".equals(strID.substring(0, 3))) {
					throw new Exception("全省工号只能录入前三位为100的营销方案ID.");
				}
			} else if (!strID.substring(0, 3).equals(user.getCityid())) {
				throw new Exception("新营销方案标识前3位不合法，应为操作员所在地市标识.");
			}
			YxPlanVO temp = (YxPlanVO) dao.findByPk(newid);
			if (temp != null) {
				throw new Exception("新营销方案标识已存在.");
			}
			// 复制主表
			if (vo.getYxplanshortname() == null
					|| "".equals(vo.getYxplanshortname())) {
				if (vo.getYxplanname() != null
						&& !"".equals(vo.getYxplanname())) {
					vo.setYxplanshortname(vo.getYxplanname());
				}
			}
			dao.create(vo);
			if (tempstr.indexOf(",0,") != -1) {
				doCopyfixfeedisc(oldid, newid, user);
			}
			if (tempstr.indexOf(",1,") != -1) {
				doCopyplandisccode(oldid, newid, user);
			}
			if (tempstr.indexOf(",2,") != -1) {
				doCopyfeedisc(oldid, newid, user);
			}
			if (tempstr.indexOf(",3,") != -1) {
				doCopyeboxdisc(oldid, newid, user);
			}
			if (tempstr.indexOf(",4,") != -1) {
				doCopyscale(oldid, newid, user);
			}
			if (tempstr.indexOf(",5,") != -1) {
				doCopypresnt(oldid, newid, user);
			}
			if (tempstr.indexOf(",27,") != -1) {
				doCopymonth(oldid, newid, user);
			}
			if (tempstr.indexOf(",28,") != -1) {
				doCopyminconsume(oldid, newid, user);
			}
			if (tempstr.indexOf(",29,") != -1) {
				doCopyprodservset(oldid, newid, user);
			}
			if (f) {
				doLogCopy(new Long(oldid), newid, copyitem, user);
			} else {
				doBatchLogCopy(new Long(oldid), newid, copyitem, filename, user);
			}
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	/**
	 * 拷贝固定费优惠明细
	 * 
	 * @param oldid
	 * @param newid
	 * @param user
	 * @return 1-拷贝了明细 0-无对应的明细
	 * @throws Exception
	 */
	private int doCopyfixfeedisc(String oldid, Long newid, User user)
			throws Exception {
		PcPsFixfeediscDAO fixfeediscDAO = (PcPsFixfeediscDAO) DAOFactory.build(
				PcPsFixfeediscDAO.class, user);
		PcPsFixfeediscListVO listVO = new PcPsFixfeediscListVO();
		listVO.set_ne_yxplanid(oldid);
		DataPackage dp = fixfeediscDAO.query(listVO);
		if (dp.getRowCount() > 0) {
			Iterator iterator = dp.getDatas().iterator();
			while (iterator.hasNext()) {
				PcPsFixfeediscVO vo = new PcPsFixfeediscVO();
				PcPsFixfeediscVO temp = (PcPsFixfeediscVO) iterator.next();
				BeanUtils.copyProperties(vo, temp);
				vo.setFixfeediscid(null);
				vo.setYxplanid(newid);
				fixfeediscDAO.create(vo);
			}
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * 拷贝营销方案优惠代码明细
	 * 
	 * @param oldid
	 * @param newid
	 * @param user
	 * @return 1-拷贝了明细 0-无对应的明细
	 * @throws Exception
	 */
	private int doCopyplandisccode(String oldid, Long newid, User user)
			throws Exception {
		PlandisccodeDAO plandisccodeDAO = (PlandisccodeDAO) DAOFactory.build(
				PlandisccodeDAO.class, user);
		PlandisccodeListVO listVO = new PlandisccodeListVO();
		listVO.set_ne_yxplanid(oldid);
		DataPackage dp = plandisccodeDAO.query(listVO);
		if (dp.getRowCount() > 0) {
			Iterator iterator = dp.getDatas().iterator();
			while (iterator.hasNext()) {
				PlandisccodeVO vo = new PlandisccodeVO();
				PlandisccodeVO temp = (PlandisccodeVO) iterator.next();
				BeanUtils.copyProperties(vo, temp);
				vo.setYxplanid(newid);
				plandisccodeDAO.create(vo);
			}
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * 拷贝资费优惠配置明细
	 * 
	 * @param oldid
	 * @param newid
	 * @param user
	 * @return 1-拷贝了明细 0-无对应的明细
	 * @throws Exception
	 */
	private int doCopyfeedisc(String oldid, Long newid, User user)
			throws Exception {
		FeediscDAO feediscDAO = (FeediscDAO) DAOFactory.build(FeediscDAO.class,
				user);
		FeediscListVO listVO = new FeediscListVO();
		listVO.set_ne_yxplanid(oldid);
		DataPackage dp = feediscDAO.query(listVO);
		if (dp.getRowCount() > 0) {
			Iterator iterator = dp.getDatas().iterator();
			while (iterator.hasNext()) {
				FeediscVO vo = new FeediscVO();
				FeediscVO temp = (FeediscVO) iterator.next();
				BeanUtils.copyProperties(vo, temp);
				vo.setYxplanid(newid);
				vo.setFeediscid(null);
				feediscDAO.create(vo);
			}
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * 拷贝帐户预存优惠明细
	 * 
	 * @param oldid
	 * @param newid
	 * @param user
	 * @return 1-拷贝了明细 0-无对应的明细
	 * @throws Exception
	 */
	private int doCopyeboxdisc(String oldid, Long newid, User user)
			throws Exception {
		EboxdiscDAO eboxdiscDAO = (EboxdiscDAO) DAOFactory.build(
				EboxdiscDAO.class, user);
		EboxdiscListVO listVO = new EboxdiscListVO();
		listVO.set_ne_yxplanid(oldid);
		DataPackage dp = eboxdiscDAO.query(listVO);
		if (dp.getRowCount() > 0) {
			Iterator iterator = dp.getDatas().iterator();
			while (iterator.hasNext()) {
				EboxdiscVO vo = new EboxdiscVO();
				EboxdiscVO temp = (EboxdiscVO) iterator.next();
				BeanUtils.copyProperties(vo, temp);
				vo.setYxplanid(newid);
				eboxdiscDAO.create(vo);
			}
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * 拷贝营销方案列帐拆分明细
	 * 
	 * @param oldid
	 * @param newid
	 * @param user
	 * @return 1-拷贝了明细 0-无对应的明细
	 * @throws Exception
	 */
	private int doCopyscale(String oldid, Long newid, User user)
			throws Exception {
		YxPlanSplitScaleDAO scaleDAO = (YxPlanSplitScaleDAO) DAOFactory.build(
				YxPlanSplitScaleDAO.class, user);
		YxPlanSplitScaleListVO listVO = new YxPlanSplitScaleListVO();
		listVO.set_ne_yxplanid(oldid);
		DataPackage dp = scaleDAO.query(listVO);
		if (dp.getRowCount() > 0) {
			Iterator iterator = dp.getDatas().iterator();
			while (iterator.hasNext()) {
				YxPlanSplitScaleVO vo = new YxPlanSplitScaleVO();
				YxPlanSplitScaleVO temp = (YxPlanSplitScaleVO) iterator.next();
				BeanUtils.copyProperties(vo, temp);
				vo.setYxplanid(newid);
				scaleDAO.create(vo);
			}
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * 拷贝营销方案附加帐务赠送信息表
	 * 
	 * @param oldid
	 * @param newid
	 * @param user
	 * @return 1-拷贝了明细 0-无对应的明细
	 * @throws Exception
	 */
	private int doCopypresnt(String oldid, Long newid, User user)
			throws Exception {
		YxplanpresntDAO presntDAO = (YxplanpresntDAO) DAOFactory.build(
				YxplanpresntDAO.class, user);
		YxplanpresntListVO listVO = new YxplanpresntListVO();
		listVO.set_ne_yxplanid(oldid);
		DataPackage dp = presntDAO.query(listVO);
		if (dp.getRowCount() > 0) {
			Iterator iterator = dp.getDatas().iterator();
			while (iterator.hasNext()) {
				YxplanpresntVO vo = new YxplanpresntVO();
				YxplanpresntVO temp = (YxplanpresntVO) iterator.next();
				BeanUtils.copyProperties(vo, temp);
				vo.setYxplanid(newid);
				presntDAO.create(vo);
			}
			return 1;
		} else {
			return 0;
		}
	}

	private int doCopymonth(String oldid, Long newid, User user)
			throws Exception {
		FeediscmonthDAO monthDAO = (FeediscmonthDAO) DAOFactory.build(
				FeediscmonthDAO.class, user);
		FeediscmonthListVO listVO = new FeediscmonthListVO();
		listVO.set_ne_yxplanid(oldid);
		DataPackage dp = monthDAO.query(listVO);
		if (dp.getRowCount() > 0) {
			Iterator iterator = dp.getDatas().iterator();
			while (iterator.hasNext()) {
				FeediscmonthVO vo = new FeediscmonthVO();
				FeediscmonthVO temp = (FeediscmonthVO) iterator.next();
				BeanUtils.copyProperties(vo, temp);
				vo.setYxplanid(newid);
				monthDAO.create(vo);
			}
			return 1;
		} else {
			return 0;
		}
	}

	private int doCopyminconsume(String oldid, Long newid, User user)
			throws Exception {
		MinconsumeDAO minDAO = (MinconsumeDAO) DAOFactory.build(
				MinconsumeDAO.class, user);
		MinconsumeListVO listVO = new MinconsumeListVO();
		listVO.set_ne_yxplanid(oldid);
		DataPackage dp = minDAO.query(listVO);
		if (dp.getRowCount() > 0) {
			Iterator iterator = dp.getDatas().iterator();
			while (iterator.hasNext()) {
				MinconsumeVO vo = new MinconsumeVO();
				MinconsumeVO temp = (MinconsumeVO) iterator.next();
				BeanUtils.copyProperties(vo, temp);
				vo.setYxplanid(newid);
				minDAO.create(vo);
			}
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * 
	 * @param oldid
	 * @param newid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private int doCopyprodservset(String oldid, Long newid, User user)
			throws Exception {
		ProdservsetDAO prodDAO = (ProdservsetDAO) DAOFactory.build(
				ProdservsetDAO.class, user);
		try {
			Long oldID = new Long(oldid);
			ProdservsetVO temp = (ProdservsetVO) prodDAO.findByPk(oldID);
			if (temp != null) {
				ProdservsetVO vo = new ProdservsetVO();
				BeanUtils.copyProperties(vo, temp);
				vo.setYxplanid(newid);
				prodDAO.create(vo);
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			if (e instanceof NumberFormatException) {
				throw new Exception("数字格式化出错");
			} else {
				throw new Exception(e.getMessage());
			}
		}

	}

	private void doLogCopy(Long oldid, Long newid, String copyitem, User user)
			throws Exception {
		YxplancplogDAO yxplancplogDAO = (YxplancplogDAO) DAOFactory.build(
				YxplancplogDAO.class, user);
		YxplancplogVO vo = new YxplancplogVO();
		Date now = new Date(System.currentTimeMillis());
		IntegrationBean integrationBean = new IntegrationBean(user);

		String huaweiIP = integrationBean.getHuaweiIP();
		String huaweiPort = integrationBean.getHuaweiPort();
		String huaweiWebRoot = integrationBean.getHuaweiWebRoot();

		if (huaweiWebRoot == null)
			huaweiWebRoot = "/boss";
		String huaweiContextPath = huaweiIP != null ? "http://" + huaweiIP : "";
		if (huaweiIP != null && huaweiPort != null && !"80".equals(huaweiPort))
			huaweiContextPath = huaweiContextPath + ":" + huaweiPort;
		huaweiContextPath = huaweiContextPath + huaweiWebRoot;
		String url = huaweiContextPath + "/product/privilegeCopyAction.do"
				+ "?actionType=queryInit&yxplanid=" + oldid.toString()
				+ "&newyxplanid=" + newid.toString();
		vo.setCopyitem(copyitem);
		vo.setCreatetime(now);
		vo.setModifytime(now);
		vo.setNewyxplanid(newid);
		vo.setOprcode(user.getOpercode());
		vo.setOprobject("CX");
		vo.setOprresulte("Success");
		vo.setOprstate("2");
		vo.setOprtype("Single");
		vo.setOrgyxplanid(oldid);
		vo.setRemark(url);
		yxplancplogDAO.create(vo);
	}

	private void doBatchLogCopy(Long oldid, Long newid, String copyitem,
			String filename, User user) throws Exception {
		YxplancplogDAO yxplancplogDAO = (YxplancplogDAO) DAOFactory.build(
				YxplancplogDAO.class, user);
		YxplancplogVO vo = new YxplancplogVO();
		Date now = new Date(System.currentTimeMillis());
		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddhhmmss");
		vo.setCopyitem(copyitem);
		vo.setCreatetime(now);
		vo.setModifytime(now);
		vo.setNewyxplanid(newid);
		vo.setOprcode(user.getOpercode());
		vo.setOprobject("CX");
		vo.setOprresulte("Success");
		vo.setOprstate("1");
		vo.setOprtype("Batch");
		vo.setOrgyxplanid(oldid);
		vo.setBatchno(user.getCityid() + fmt.format(rightNow.getTime()));
		vo.setRemark(filename);
		yxplancplogDAO.create(vo);

	}

	public String getAreacode(Long yxplanid, User user) throws Exception {
		YxPlanDelegate delegate = new YxPlanDelegate();
		YxPlanVO vo = delegate.doFindByPk(yxplanid, user);
		if (vo == null) {
			return null;
		} else {
			return vo.getAreacode() == null ? "" : vo.getAreacode();
		}
	}
}
