/**
 * 
 */
package com.sunrise.boss.ui.cms.adjustment;

import java.util.Date;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.adjustment.persistent.AdjustmentListVO;
import com.sunrise.boss.business.cms.adjustment.persistent.AdjustmentVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.adjustment.AdjustmentDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

/**
 * @author cx-yz
 * 
 */
public class BatchTaskBean extends BaseBatchTaskBean {
	AdjustmentDelegate delegate;
	
	private static final String COMMON_TITLE = "��������|�����·�|˰��|�۷����|��ע|������|\r\n";
	private static final String FEES_SUPPORT_TITLE = "��������|�����·�|˰��|�۷����|������|��ע|������|\r\n";
	private static final String UPPER_SUPPORT_TITLE = "��������|�����·�|ҵ��������|˰��|�۷����|��ע|������|\r\n";
	
	private boolean fees_support = false;
	private boolean upper_support = false;

	public BatchTaskBean() {
		try {
			delegate = new AdjustmentDelegate();
			batchName = "˰����Ϣ��������";
			setWriteLog(true);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		SysparamDelegate sysparamDelegate;
		try {
			//�Ƿ�֧��������
			sysparamDelegate = new SysparamDelegate();
			SysparamListVO sysparamListVO = new SysparamListVO();
			sysparamListVO.set_se_paramtype(BatchAdjustmentCheck.SYS_CHANNEL);
			sysparamListVO.set_ne_systemid(BatchAdjustmentCheck.FEES_SWITCH);
			DataPackage sysparamDP = sysparamDelegate.doQuery(sysparamListVO,user);
			if (sysparamDP != null && sysparamDP.getDatas() != null	&& sysparamDP.getDatas().size() > 0) {
				for (Iterator<SysparamVO> it = sysparamDP.getDatas().iterator(); it.hasNext();) {
					SysparamVO sysparamVO = it.next();
					if (sysparamVO.getParamvalue() != null && "1".equals(sysparamVO.getParamvalue())) {
						this.fees_support = true;
						return FEES_SUPPORT_TITLE;
					}
				}
			}
			//�Ƿ�֧��ҵ�����
			sysparamListVO.set_se_paramtype(BatchAdjustmentCheck.SYS_CHANNEL);
			sysparamListVO.set_ne_systemid(BatchAdjustmentCheck.UPPEROPNID_SWITCH);
			sysparamDP = sysparamDelegate.doQuery(sysparamListVO,user);
			if (sysparamDP != null && sysparamDP.getDatas() != null	&& sysparamDP.getDatas().size() > 0) {
				for (Iterator<SysparamVO> it = sysparamDP.getDatas().iterator(); it.hasNext();) {
					SysparamVO sysparamVO = it.next();
					if (sysparamVO.getParamvalue() != null && "1".equals(sysparamVO.getParamvalue())) {
						this.upper_support = true;
						return UPPER_SUPPORT_TITLE;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return COMMON_TITLE;
	}
	
	private void processLineFees(String line, ResultVO resultVO) throws Exception{
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");		
		String wayid = content[0].trim();
		String rewardmonth = content[1].trim();
		String tax = "0.0";
		String rpmoney = "0.0";
		String fees = "0.0";
		String remark = "";
		if (content[2] != null && !"".equals(content[2].trim())) {
			tax = content[2].trim();
		}
		if (content[3] != null && !"".equals(content[3].trim())) {
			rpmoney = content[3].trim();
		}
		if (content[4] != null && !"".equals(content[4].trim())) {
			fees = content[4].trim();
		}								
		if (content[5] != null && !"".equals(content[5].trim())) {
			remark = content[5].trim();
		}
		
		AdjustmentListVO listvo = new AdjustmentListVO();
		listvo.set_se_wayid(wayid);
		listvo.set_se_rewardmonth(rewardmonth);
		listvo.set_sql_batchno(" batchno is null");
		listvo.set_pagesize("0");
		DataPackage dp = delegate.doQuery(listvo, user);
		if (dp != null && dp.getDatas() != null && dp.getDatas().size() > 0) {//��Ӧ����������Ѵ��ڼ�¼
			Iterator it = dp.getDatas().iterator();
			if (it.hasNext()) {
				AdjustmentVO vo = (AdjustmentVO) it.next();
				if (vo.getTaxmoney() != null) {						// ���˰��Ϊ�գ��ۼ�
					vo.setTaxmoney(vo.getTaxmoney()+ Double.parseDouble(tax));
				} else {
					vo.setTaxmoney(Double.parseDouble(tax));
				}
				
				if (vo.getRpmoney() != null) {						// ������Ϊ�գ��ۼ�
					vo.setRpmoney(vo.getRpmoney()+ Double.parseDouble(rpmoney));
				} else {
					vo.setRpmoney(Double.parseDouble(rpmoney));
				}
				
				if (vo.getFees() != null) {// �����Ѳ�Ϊ�գ��ۼ�
					vo.setFees(vo.getFees() + Double.parseDouble(fees));
				} else {
					vo.setFees(Double.parseDouble(fees));
				}
				
				if (vo.getRemark() != null) {// ��ע��Ϊ��
					remark = vo.getRemark() + "|" + remark;// ƴ��
					if (remark.getBytes().length > 128) {// ����128λ��ȡ��128λ
						// remark = remark.substring(remark.length()-128);
						byte[] rb = remark.getBytes();
						remark = new String(rb, rb.length - 128, 128);
					}
				}else{// ��עΪ��
					if (remark.getBytes().length > 128) {// �ļ��ϴ���ע����128λ��ȡǰ128λ
						//vo.setRemark(remark.substring(0, 128));
						byte[] rb = remark.getBytes();
						remark = new String(rb, rb.length - 128, 128);
					}
				}
				vo.setRemark(remark);
				vo.setTaxoprcode(user.getOpercode());
				vo.setTaxoptime(new Date());
				delegate.doUpdate(vo, user);
			}
			line += "�����ɹ�|";
		} else {//��Ӧ��������²����ڼ�¼
			AdjustmentVO vo = new AdjustmentVO();
			WayDelegate wdelegate = new WayDelegate();
			WayVO wvo = wdelegate.doFindByPk(wayid, user);
			if (wvo != null) {
				vo.setWayid(wayid);
				vo.setCountyid(wvo.getCountyid());
				vo.setPaysum(0.0);
				vo.setRewardmonth(rewardmonth);
				vo.setTaxmoney(Double.parseDouble(tax));
				vo.setRemark(remark);
				vo.setRpmoney(Double.parseDouble(rpmoney));
				vo.setTaxoprcode(user.getOpercode());
				vo.setTaxoptime(new Date());
				vo.setFees(Double.parseDouble(fees));
				delegate.doCreate(vo, user);
				line += "�����ɹ�|";
			} else {
				line += "���������Ӧ���㲻���ڣ��޷���ȡ�ֹ�˾��Ϣ";
			}
		}
		resultVO.setOk(true);
		resultVO.setInfo(line);
	}
	
	private void processLineCommon(String line, ResultVO resultVO) throws Exception{
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");

		String wayid = content[0].trim();
		String rewardmonth = content[1].trim();
		String tax = "0.0";
		String remark = "";
		String rpmoney = "0.0";
		if (content[2] != null && !"".equals(content[2].trim())) {
			tax = content[2].trim();
		}
		if (content[3] != null && !"".equals(content[3].trim())) {
			rpmoney = content[3].trim();
		}
		if (content[4] != null && !"".equals(content[4].trim())) {
			remark = content[4].trim();
		}
		
		AdjustmentListVO listvo = new AdjustmentListVO();
		listvo.set_se_wayid(wayid);
		listvo.set_se_rewardmonth(rewardmonth);
		listvo.set_sql_batchno(" batchno is null");
		listvo.set_pagesize("0");
		DataPackage dp = delegate.doQuery(listvo, user);
		if (dp != null && dp.getDatas() != null && dp.getDatas().size() > 0) {//��Ӧ����������Ѵ��ڼ�¼
			Iterator it = dp.getDatas().iterator();
			if (it.hasNext()) {
				AdjustmentVO vo = (AdjustmentVO) it.next();
				if (vo.getTaxmoney() != null) {						// ���˰��Ϊ�գ��ۼ�
					vo.setTaxmoney(vo.getTaxmoney()+ Double.parseDouble(tax));
				} else {
					vo.setTaxmoney(Double.parseDouble(tax));
				}
				
				if (vo.getRpmoney() != null) {						// ������Ϊ�գ��ۼ�
					vo.setRpmoney(vo.getRpmoney()+ Double.parseDouble(rpmoney));
				} else {
					vo.setRpmoney(Double.parseDouble(rpmoney));
				}
										
				if (vo.getRemark() != null) {// ��ע��Ϊ��
					remark = vo.getRemark() + "|" + remark;// ƴ��
					if (remark.getBytes().length > 128) {// ����128λ��ȡ��128λ
						byte[] rb = remark.getBytes();
						remark = new String(rb, rb.length - 128, 128);
					}
				} else {// ��עΪ��
					if (remark.length() > 128) {// �ļ��ϴ���ע����128λ��ȡǰ128λ
						byte[] rb = remark.getBytes();
						remark = new String(rb, rb.length - 128, 128);
					} 
				}
				vo.setRemark(remark);
				
				vo.setTaxoprcode(user.getOpercode());
				vo.setTaxoptime(new Date());
				delegate.doUpdate(vo, user);
			}
			line += "�����ɹ�|";
		} else {//��Ӧ��������²����ڼ�¼
			AdjustmentVO vo = new AdjustmentVO();
			WayDelegate wdelegate = new WayDelegate();
			WayVO wvo = wdelegate.doFindByPk(wayid, user);
			if (wvo != null) {
				vo.setWayid(wayid);
				vo.setCountyid(wvo.getCountyid());
				vo.setPaysum(0.0);
				vo.setRewardmonth(rewardmonth);
				vo.setTaxmoney(Double.parseDouble(tax));
				vo.setRemark(remark);
				vo.setRpmoney(Double.parseDouble(rpmoney));
				vo.setTaxoprcode(user.getOpercode());
				vo.setTaxoptime(new Date());
				delegate.doCreate(vo, user);
				line += "�����ɹ�|";
			} else {
				line += "���������Ӧ���㲻���ڣ��޷���ȡ�ֹ�˾��Ϣ";
			}
		}
		resultVO.setOk(true);
		resultVO.setInfo(line);
	
	}
	
	private void processLineUpper(String line, ResultVO resultVO) throws Exception{
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");

		String wayid = content[0].trim();
		String rewardmonth = content[1].trim();
		String upperopnid = content[2].trim();
		String tax = "0.0";
		String remark = "";
		String rpmoney = "0.0";
		if (content[3] != null && !"".equals(content[3].trim())) {
			tax = content[3].trim();
		}
		if (content[4] != null && !"".equals(content[4].trim())) {
			rpmoney = content[4].trim();
		}
		if (content[5] != null && !"".equals(content[5].trim())) {
			remark = content[5].trim();
		}
		
		AdjustmentListVO listvo = new AdjustmentListVO();
		listvo.set_se_wayid(wayid);
		listvo.set_se_rewardmonth(rewardmonth);
		listvo.set_se_upperopnid(upperopnid);
		listvo.set_sql_batchno(" batchno is null");
		listvo.set_pagesize("0");
		DataPackage dp = delegate.doQuery(listvo, user);
		if (dp != null && dp.getDatas() != null && dp.getDatas().size() > 0) {//��Ӧ����������Ѵ��ڼ�¼
			Iterator it = dp.getDatas().iterator();
			if (it.hasNext()) {
				AdjustmentVO vo = (AdjustmentVO) it.next();
				if (vo.getTaxmoney() != null) {						// ���˰��Ϊ�գ��ۼ�
					vo.setTaxmoney(vo.getTaxmoney()+ Double.parseDouble(tax));
				} else {
					vo.setTaxmoney(Double.parseDouble(tax));
				}
				
				if (vo.getRpmoney() != null) {						// ������Ϊ�գ��ۼ�
					vo.setRpmoney(vo.getRpmoney()+ Double.parseDouble(rpmoney));
				} else {
					vo.setRpmoney(Double.parseDouble(rpmoney));
				}
										
				if (vo.getRemark() != null) {// ��ע��Ϊ��
					remark = vo.getRemark() + "|" + remark;// ƴ��
					if (remark.getBytes().length > 128) {// ����128λ��ȡ��128λ
						byte[] rb = remark.getBytes();
						remark = new String(rb, rb.length - 128, 128);
					}
				} else {// ��עΪ��
					if (remark.length() > 128) {// �ļ��ϴ���ע����128λ��ȡǰ128λ
						byte[] rb = remark.getBytes();
						remark = new String(rb, rb.length - 128, 128);
					} 
				}
				vo.setRemark(remark);
				
				vo.setTaxoprcode(user.getOpercode());
				vo.setTaxoptime(new Date());
				delegate.doUpdate(vo, user);
			}
			line += "�����ɹ�|";
		} else {//��Ӧ��������²����ڼ�¼
			AdjustmentVO vo = new AdjustmentVO();
			WayDelegate wdelegate = new WayDelegate();
			WayVO wvo = wdelegate.doFindByPk(wayid, user);
			if (wvo != null) {
				vo.setWayid(wayid);
				vo.setCountyid(wvo.getCountyid());
				vo.setUpperopnid(upperopnid);
				vo.setPaysum(0.0);
				vo.setRewardmonth(rewardmonth);
				vo.setTaxmoney(Double.parseDouble(tax));
				vo.setRemark(remark);
				vo.setRpmoney(Double.parseDouble(rpmoney));
				vo.setTaxoprcode(user.getOpercode());
				vo.setTaxoptime(new Date());
				delegate.doCreate(vo, user);
				line += "�����ɹ�|";
			} else {
				line += "���������Ӧ���㲻���ڣ��޷���ȡ�ֹ�˾��Ϣ";
			}
		}
		resultVO.setOk(true);
		resultVO.setInfo(line);
	}

	/**
	 * ����һ����¼
	 */
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			if(this.fees_support){
				this.processLineFees(line, resultVO);
			}else if(this.upper_support){
				this.processLineUpper(line, resultVO);
			}else{
				this.processLineCommon(line, resultVO);
			}
		} catch (Exception ex) {
			line += "������Ϣ:" + ex.getMessage() + "|";
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
