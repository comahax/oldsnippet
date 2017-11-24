/**
 * 
 */
package com.sunrise.boss.ui.cms.reward.rewardtotal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.resmanage.fileitem.persistent.FileitemVO;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.resmanage.common.ResUploadFileAction;

/**
 * @author Administrator
 * 
 */
public class RewardtotalBatchAction extends ResUploadFileAction {
	private User user;
	/**
	 * 
	 */
	public RewardtotalBatchAction() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunrise.boss.ui.resmanage.common.ResUploadFileAction#setFilecode(java.util.HashMap,
	 *      com.sunrise.boss.ui.commons.User)
	 */
	protected void setFilecode(HashMap map, User user) {
		// TODO Auto-generated method stub
		this.filecode = "REWARDTOTAL_0_0";
		this.user=user;
	}

	protected List getParamList(HashMap map, User user) throws Exception {
		List list = new ArrayList();
		addParam(list, "cityid", SessionFactoryRouter.conversionCityid(user
				.getCityid()));
		addParam(list, "oprcode", user.getOpercode());
		SimpleDateFormat fs = new SimpleDateFormat("yyyyMMddHHmmss");
		addParam(list, "batchno", user.getCityid() + fs.format(new Date()));
		return list;
	}

	protected void checkOther(int row, String item, FileitemVO fileitem)
			throws Exception {
//		if("wayid".equalsIgnoreCase(fileitem.getItemcode())){
//			WayDelegate delegate=new WayDelegate();
//			if(delegate.doFindByPk(item, user)==null)
//				throw new Exception("第" + row + "行格式有错，[" + item
//						+ "]应该为系统中以存在的渠道编码。");
//		}else if("rewardtype".equalsIgnoreCase(fileitem.getItemcode())){
//			DictitemDelegate delegate=new DictitemDelegate();
//			DictitemVO vo=new DictitemVO();
//			vo.setDictid(item);
//			vo.setGroupid("CH_REWARDTYPE");
//			vo=delegate.doFindByPk(vo, user);
//			if(vo==null)
//				throw new Exception("第" + row + "行格式有错，[" + item
//						+ "]应该为系统中以存在的酬金类型标识。");
//		}else 
//		if("paymonth".equalsIgnoreCase(fileitem.getItemcode())){
//			SimpleDateFormat format=new SimpleDateFormat("yyyyMM");
//			try{
//			format.parse(item);
//			if(Long.valueOf(item).longValue()<198001){
//				throw new Exception();
//			}
//			}catch(Exception e){
//				throw new Exception("第" + row + "行格式有错，[" + item
//						+ "]应该为6位的时间格式yyyyMM。");
//			}
//		}
//		else if("paymoney".equalsIgnoreCase(fileitem.getItemcode())){
//			try{
//			Double double1=Double.valueOf(item);
//			}catch(Exception e){
//				throw new Exception("第" + row + "行格式有错，[" + item
//						+ "]应该为数字。");
//			}
//		}
	}
}
