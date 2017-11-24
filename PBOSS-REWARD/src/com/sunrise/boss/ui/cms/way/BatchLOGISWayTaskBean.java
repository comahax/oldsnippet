package com.sunrise.boss.ui.cms.way;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountDAO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountListVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountVO;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.bchcontact.BchcontactDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.wayaccount.WayaccountDelegate;
import com.sunrise.boss.delegate.cms.waycompact.WaycompactDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

/**
 * 物流商导入处理BEAN
 * @author zhaowen
 *
 */
public class BatchLOGISWayTaskBean extends BaseBatchTaskBean {
	private WayDelegate delegate;
	private BchcontactDelegate bchdelegate;
	private WaycompactDelegate comdelegate;
	private WayaccountDelegate accdelegate;
	
	public BatchLOGISWayTaskBean() {
		try {
			delegate = new WayDelegate();
			bchdelegate = new BchcontactDelegate();
			comdelegate = new WaycompactDelegate();
			accdelegate = new WayaccountDelegate();
			batchName = "社会渠道信息管理";
			setWriteLog(true);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		return "序号 | 渠道编码 | 渠道名称 | 上级渠道编码 | 合作方 | 地市公司 | 分公司 | 服务销售中心 | 微区域  | 行政区划 | 详细地址 | 负责人姓名 | 负责人联系电话 | 负责人电子邮箱 | 业务联系人姓名 | 业务联系人联系电话 | 业务联系人电子邮箱 | 合同编码 | 合同名称 | 签署合同时间 | 合同到期日 | 法人代表 | 营业执照编号 | 经营区域类型编码 | 经营范围 | 银行帐号 | 开户银行 | 开户账号名称 | 开户人身份证号码 " + "\r\n";
	}

	/**
	 * 处理一条记录
	 */
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		//去空格
		for(int i=0;i<items.length;i++)
		{
			if(items[i]!=null)
				items[i]=items[i].trim();
		}
		WayVO wayVO = new WayVO();
		BchcontactVO bchcontactVO = new BchcontactVO();
		WaycompactVO waycompactVO = new WaycompactVO();
		WayaccountVO wayaccountVO = new WayaccountVO();
		
		WayVO wayVO1 = new WayVO();
		BchcontactVO bchcontactVO1 = new BchcontactVO();
		WaycompactVO waycompactVO1 = new WaycompactVO();
		WayaccountVO wayaccountVO1 = new WayaccountVO();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {

			//社会渠道基本信息
			wayVO.setWayid(items[0]);
			wayVO1 = delegate.doFindByPk(wayVO.getWayid(), user);
			if (wayVO1 == null) {// 新增
				wayVO.setWayname(items[1]);
				wayVO.setUpperwayid(items[2]);
				wayVO.setCooperator("".equals(items[3].trim())? null : new Short(items[3]));
				wayVO.setCityid(items[4]);
				wayVO.setCountyid(items[5]);
				wayVO.setSvccode(items[6]);
				wayVO.setMiscode(items[7]);
				wayVO.setAdacode(items[8]);
				wayVO.setLatitude(items[9]);
				wayVO.setLongtitude(items[10]);
				wayVO.setAddress(items[11]);
				wayVO.setWaytype("AG");
				wayVO.setWaysubtype("LOGS");
				delegate.doCreate(wayVO, user);
			}else {
				BeanUtils.copyProperties(wayVO, wayVO1);
				if (items[1] == null || "".equals(items[1])) {
					wayVO.setWayname(wayVO1.getWayname());
				} else if ("null".equals(items[1]) || "空".equals(items[1])) {
					throw new BusinessException("渠道名称不能修改为空!");
				} else
					wayVO.setWayname(items[1]);
				if (items[2] == null || "".equals(items[2])) {
					wayVO.setUpperwayid(wayVO1.getUpperwayid());
				} else if ("null".equals(items[2]) || "空".equals(items[2])) {
					throw new BusinessException("上级渠道编码不能修改为空!");
				} else
					wayVO.setUpperwayid(items[2]);
				if (items[3] == null || "".equals(items[3])) {
					wayVO.setCooperator(wayVO1.getCooperator());
				} else if ("null".equals(items[3]) || "空".equals(items[3])) {
					wayVO.setCooperator(null);
				} else
					wayVO.setCooperator(new Short(items[3]));
				if (items[4] == null || "".equals(items[4])) {
					wayVO.setCityid(wayVO1.getCityid());
				} else if ("null".equals(items[4]) || "空".equals(items[4])) {
					wayVO.setCityid(null);
				} else
					wayVO.setCityid(items[4]);
				if (items[5] == null || "".equals(items[5])) {
					wayVO.setCountyid(wayVO1.getCountyid());
				} else if ("null".equals(items[5]) || "空".equals(items[5])) {
					wayVO.setCountyid(null);
				} else
					wayVO.setCountyid(items[5]);
				if (items[6] == null || "".equals(items[6])) {
					wayVO.setSvccode(wayVO1.getSvccode());
				} else if ("null".equals(items[6]) || "空".equals(items[6])) {
					wayVO.setSvccode(null);
				} else
					wayVO.setSvccode(items[6]);
				if (items[7] == null || "".equals(items[7])) {
					wayVO.setMiscode(wayVO1.getMiscode());
				} else if ("null".equals(items[7]) || "空".equals(items[7])) {
					wayVO.setMiscode(null);
				} else
					wayVO.setMiscode(items[7]);
				if (items[8] == null || "".equals(items[8])) {
					wayVO.setAdacode(wayVO1.getAdacode());
				} else if ("null".equals(items[8]) || "空".equals(items[8])) {
					wayVO.setAdacode(null);
				} else
					wayVO.setAdacode(items[8]);
				if (items[9] == null || "".equals(items[9])) {
					wayVO.setLatitude(wayVO1.getLatitude());
				} else if ("null".equals(items[9]) || "空".equals(items[9])) {
					wayVO.setLatitude(null);
				} else
					wayVO.setLatitude(items[9]);
				if (items[10] == null || "".equals(items[10])) {
					wayVO.setLongtitude(wayVO1.getLongtitude());
				} else if ("null".equals(items[10]) || "空".equals(items[10])) {
					wayVO.setLongtitude(null);
				} else
					wayVO.setLongtitude(items[10]);
				if (items[11] == null || "".equals(items[11])) {
					wayVO.setAddress(wayVO1.getAddress());
				} else if ("null".equals(items[11]) || "空".equals(items[11])) {
					wayVO.setAddress(null);
				} else
					wayVO.setAddress(items[11]);
				
				delegate.doUpdate(wayVO, user);
			}
			
			//沟通信息
			bchcontactVO.setWayid(items[0]);
			bchcontactVO1 = bchdelegate.doFindByPk(bchcontactVO.getWayid(),
					user);
			if (bchcontactVO1 == null) { // 新增
				bchcontactVO.setPrincipal(items[10]);
				bchcontactVO.setPrincipaltel(items[13]);
				bchcontactVO.setPrincipalemail(items[14]);
				bchcontactVO.setLinkman(items[15]);
				bchcontactVO.setLinkmantel(items[16]);
				bchcontactVO.setLinkmanemail(items[17]);
				bchdelegate.doCreate(bchcontactVO,user);
			}else {
				BeanUtils.copyProperties(bchcontactVO, bchcontactVO1);
				if (items[10] == null || "".equals(items[10])) {
					bchcontactVO.setPrincipal(bchcontactVO1.getPrincipal());
				} else if ("null".equals(items[10]) || "空".equals(items[10])) {
					throw new BusinessException("负责人姓名不能修改为空!");
				} else
					bchcontactVO.setPrincipal(items[10]);
				if (items[13] == null || "".equals(items[13])) {
					bchcontactVO.setPrincipaltel(bchcontactVO1.getPrincipaltel());
				} else if ("null".equals(items[13]) || "空".equals(items[13])) {
					throw new BusinessException("负责人联系电话不能修改为空!");
				} else
					bchcontactVO.setPrincipaltel(items[13]);
				if (items[14] == null || "".equals(items[14])) {
					bchcontactVO.setPrincipalemail(bchcontactVO1.getPrincipalemail());
				} else if ("null".equals(items[14]) || "空".equals(items[14])) {
					bchcontactVO.setPrincipalemail(null);
				} else
					bchcontactVO.setPrincipalemail(items[14]);
				if (items[15] == null || "".equals(items[15])) {
					bchcontactVO.setLinkman(bchcontactVO1.getLinkman());
				} else if ("null".equals(items[15]) || "空".equals(items[15])) {
					throw new BusinessException("业务联系人姓名不能修改为空!");
				} else
					bchcontactVO.setLinkman(items[15]);
				if (items[16] == null || "".equals(items[16])) {
					bchcontactVO.setLinkmantel(bchcontactVO1.getLinkmantel());
				} else if ("null".equals(items[16]) || "空".equals(items[16])) {
					bchcontactVO.setLinkmantel(null);
				} else
					bchcontactVO.setLinkmantel(items[16]);
				if (items[17] == null || "".equals(items[17])) {
					bchcontactVO.setLinkmanemail(bchcontactVO1.getLinkmanemail());
				} else if ("null".equals(items[17]) || "空".equals(items[17])) {
					bchcontactVO.setLinkmanemail(null);
				} else
					bchcontactVO.setLinkmanemail(items[17]);
				bchdelegate.doUpdate(bchcontactVO, user);
			}

			//合同信息
			waycompactVO.setWayid(items[0]);
			waycompactVO1 = comdelegate.doFindByPk(waycompactVO.getWayid(), user);
			if (waycompactVO1 ==null) {
				waycompactVO.setCompactno(items[18]);
				waycompactVO.setCompactname(items[19]);
				waycompactVO.setBegintime(new  java.sql.Date(format.parse(items[20]).getTime()));
				waycompactVO.setSigntime(new  java.sql.Date(format.parse(items[20]).getTime()));
				waycompactVO.setEndtime(new  java.sql.Date(format.parse(items[21]).getTime()));
				waycompactVO.setPrincipal(items[22]);
				waycompactVO.setLicenceno(items[23]);
				if (items[24] != null && !"".equals(items[24])) {
					waycompactVO.setRunareatype(new Short(items[24]));
				}
				waycompactVO.setCopbound(items[25]);
				comdelegate.doCreate(waycompactVO,user);
			}else {
				BeanUtils.copyProperties(waycompactVO, waycompactVO1);
				if (items[18] == null || "".equals(items[18])) {
					waycompactVO.setCompactno(waycompactVO1.getCompactno());
				} else if ("null".equals(items[18]) || "空".equals(items[18])) {
					throw new BusinessException("合同编码不能修改为空!");
				} else
					waycompactVO.setCompactno(items[18]);
				if (items[19] == null || "".equals(items[19])) {
					waycompactVO.setCompactname(waycompactVO1.getCompactname());
				} else if ("null".equals(items[19]) || "空".equals(items[19])) {
					throw new BusinessException("合同名称不能修改为空!");
				} else
					waycompactVO.setCompactname(items[19]);
				if (items[20] == null || "".equals(items[20])) {
					waycompactVO.setBegintime(waycompactVO1.getBegintime());
					waycompactVO.setSigntime(waycompactVO1.getSigntime());
				} else if ("null".equals(items[20]) || "空".equals(items[20])) {
					throw new BusinessException("签署合同时间或者合同到期日不能修改为空!");
				} else {
					waycompactVO.setBegintime(new  java.sql.Date(format.parse(items[20]).getTime()));
					waycompactVO.setSigntime(new  java.sql.Date(format.parse(items[20]).getTime()));
				}
					
				if (items[21] == null || "".equals(items[21])) {
					waycompactVO.setEndtime(waycompactVO1.getEndtime());
				} else if ("null".equals(items[21]) || "空".equals(items[21])) {
					waycompactVO.setEndtime(null);
				} else
					waycompactVO.setEndtime(new  java.sql.Date(format.parse(items[21]).getTime()));
				if (items[22] == null || "".equals(items[22])) {
					waycompactVO.setPrincipal(waycompactVO1.getPrincipal());
				} else if ("null".equals(items[22]) || "空".equals(items[22])) {
					waycompactVO.setPrincipal(null);
				} else
					waycompactVO.setPrincipal(items[22]);
				if (items[23] == null || "".equals(items[23])) {
					waycompactVO.setLicenceno(waycompactVO1.getLicenceno());
				} else if ("null".equals(items[23]) || "空".equals(items[23])) {
					waycompactVO.setLicenceno(null);
				} else
					waycompactVO.setLicenceno(items[23]);
				if (items[24] == null || "".equals(items[24])) {
					waycompactVO.setRunareatype(waycompactVO1.getRunareatype());
				} else if ("null".equals(items[24]) || "空".equals(items[24])) {
					waycompactVO.setRunareatype(null);
				} else
					waycompactVO.setRunareatype(new Short(items[24]));
				if (items[25] == null || "".equals(items[25])) {
					waycompactVO.setCopbound(waycompactVO1.getCopbound());
				} else if ("null".equals(items[25]) || "空".equals(items[25])) {
					waycompactVO.setCopbound(null);
				} else
					waycompactVO.setCopbound(items[25]);
				
				comdelegate.doUpdate(waycompactVO,user);
			}
			
			//帐户信息
			wayaccountVO.setWayid(items[0]);
			wayaccountVO.setAccid(new Integer(1));
			WayaccountListVO acclistvo = new WayaccountListVO();
			acclistvo.set_ne_accid(wayaccountVO.getAccid());
			acclistvo.set_se_wayid(wayaccountVO.getWayid());
			DataPackage accdp = (DataPackage) accdelegate.doQuery(acclistvo, user);
			List acclist = (List)accdp.getDatas();
			if (acclist.size()==0) {
				wayaccountVO.setBankname(items[27]);
				wayaccountVO.setAcctno(items[26]);
				wayaccountVO.setAcctname(items[28]);
				wayaccountVO.setAcctfid(items[29]);
				wayaccountVO.setAccttype(new Short("0"));
				wayaccountVO.setChargetype(new Short("0"));
				accdelegate.doCreate(wayaccountVO,user);
			}else {
				wayaccountVO1 = (WayaccountVO)acclist.get(0);
				BeanUtils.copyProperties(wayaccountVO, wayaccountVO1);
				
				if (items[27] == null || "".equals(items[27])) {
					wayaccountVO.setBankname(wayaccountVO.getBankname());
				} else if ("null".equals(items[27]) || "空".equals(items[27])) {
					throw new BusinessException("开户银行不能修改为空!");
				} else
					wayaccountVO.setBankname(items[27]);
				if (items[26] == null || "".equals(items[26])) {
					wayaccountVO.setAcctno(wayaccountVO.getAcctno());
				} else if ("null".equals(items[26]) || "空".equals(items[26])) {
					wayaccountVO.setAcctno(null);
				} else
					wayaccountVO.setAcctno(items[26]);
				if (items[28] == null || "".equals(items[28])) {
					wayaccountVO.setAcctname(wayaccountVO.getAcctname());
				} else if ("null".equals(items[28]) || "空".equals(items[28])) {
					throw new BusinessException("开户帐号名称不能修改为空!");
				} else
					wayaccountVO.setAcctname(items[28]);
				if (items[29] == null || "".equals(items[29])) {
					wayaccountVO.setAcctfid(wayaccountVO.getAcctfid());
				} else if ("null".equals(items[29]) || "空".equals(items[29])) {
					wayaccountVO.setAcctfid(null);
				} else
					wayaccountVO.setAcctfid(items[29]);
				
				accdelegate.doUpdate(wayaccountVO,user);
			}

			
			
			
			
				
			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount));
			return resultVO;
		} catch (Exception ex) { // 插入失败
			msg = ex.getMessage();
			ex.printStackTrace();
			resultVO.setOk(false);
			resultVO.setInfo(showInfo(resultVO, items, rowCount) + msg);
			return resultVO;
		}
	}

	/**
	 * 结果文件格式
	 */
	public String showInfo(ResultVO resultVO, String[] items, int rowCount) {
		final String COMPART = " | "; // 分隔
		StringBuffer resultStr = new StringBuffer();
		// 序号
		resultStr.append(rowCount).append(COMPART);
		resultStr.append(items[0]).append(COMPART);
		resultStr.append(items[1]).append(COMPART);
		resultStr.append(items[2]).append(COMPART);
		resultStr.append(items[3]).append(COMPART);
		resultStr.append(items[4]).append(COMPART);
		resultStr.append(items[5]).append(COMPART);
		resultStr.append(items[6]).append(COMPART);
		resultStr.append(items[7]).append(COMPART);
		resultStr.append(items[8]).append(COMPART);
		resultStr.append(items[9]).append(COMPART);
		resultStr.append(items[10]).append(COMPART);
		resultStr.append(items[11]).append(COMPART);
		resultStr.append(items[12]).append(COMPART);
		resultStr.append(items[13]).append(COMPART);
		resultStr.append(items[14]).append(COMPART);
		resultStr.append(items[15]).append(COMPART);
		resultStr.append(items[16]).append(COMPART);
		resultStr.append(items[17]).append(COMPART);
		resultStr.append(items[18]).append(COMPART);
		resultStr.append(items[19]).append(COMPART);
		resultStr.append(items[20]).append(COMPART);
		resultStr.append(items[21]).append(COMPART);
		resultStr.append(items[22]).append(COMPART);	
		resultStr.append(items[23]).append(COMPART);
		resultStr.append(items[24]).append(COMPART);
		resultStr.append(items[25]).append(COMPART);
		resultStr.append(items[26]).append(COMPART);
		resultStr.append(items[27]).append(COMPART);
		resultStr.append(items[28]).append(COMPART);

		resultStr.append("增加");
		resultStr.append(COMPART);
		// 办理结果
		if (resultVO.isOk()) {
			resultStr.append("成功");
		} else {
			resultStr.append("失败");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}

}
