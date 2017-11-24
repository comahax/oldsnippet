/**
 * 
 */
package com.sunrise.boss.ui.cms.adjustment;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.admin.operator.OperatorDelegate;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

/**
 * @author cx-yz
 *
 */
public class BatchAdjustmentCheck extends BaseCheckFormat {
	public static final String CH_ADT_ADJUST_COUNTY ="CH_ADT_ADJUST_COUNTY";//分公司权限令牌，否则能进入此导入的默认具有市公司令牌
	public static final String FEES_SWITCH = "91";
	public static final String UPPEROPNID_SWITCH = "93";
	public static final String SYS_CHANNEL = "channel";
	private boolean iscountyonly = false;
	private String countyid = null;
	private boolean supportfees = false;
	private boolean supportupper = false;
	public BatchAdjustmentCheck(){
		super();
	}
	
	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}
	
	public void checkLine(String line, int rowCount, User user)
	throws Exception{
		if (null == line || "".equals(line)) {
			return;
		}
		if(rowCount==1){
			ACLDelegate acldelegate = new ACLDelegate(); 
			this.iscountyonly = acldelegate.checkPermission(user.getOpercode(), CH_ADT_ADJUST_COUNTY);
			OperatorDelegate odelegate = new OperatorDelegate();
    		this.countyid = odelegate.doQuerycountyid(user.getOpercode(), user);
    		if(this.iscountyonly && this.countyid==null){
    			throw new Exception("工号具有分公司操作令牌CH_ADT_ADJUST_COUNTY，但工号对应分公司为空");
    		}
    		//是否支持手续费
    		SysparamDelegate sysparamDelegate = new SysparamDelegate();
        	SysparamListVO sysparamListVO = new SysparamListVO();
        	sysparamListVO.set_se_paramtype(SYS_CHANNEL);
        	sysparamListVO.set_ne_systemid(FEES_SWITCH);
        	DataPackage sysparamDP = sysparamDelegate.doQuery(sysparamListVO, user);
        	if(sysparamDP != null && sysparamDP.getDatas() != null && sysparamDP.getDatas().size() > 0){
        		Iterator<SysparamVO> it = sysparamDP.getDatas().iterator();
        		if(it.hasNext()){
        			SysparamVO sysparamVO= it.next();
        			if(sysparamVO.getParamvalue()!=null && "1".equals(sysparamVO.getParamvalue())){
        				this.supportfees = true;
        			}
        		}        		
        	}
        	//是否支持业务大类
        	sysparamListVO.set_se_paramtype(SYS_CHANNEL);
        	sysparamListVO.set_ne_systemid(UPPEROPNID_SWITCH);
        	sysparamDP = sysparamDelegate.doQuery(sysparamListVO, user);
        	if(sysparamDP != null && sysparamDP.getDatas() != null && sysparamDP.getDatas().size() > 0){
        		Iterator<SysparamVO> it = sysparamDP.getDatas().iterator();
        		if(it.hasNext()){
        			SysparamVO sysparamVO= it.next();
        			if(sysparamVO.getParamvalue()!=null && "1".equals(sysparamVO.getParamvalue())){
        				this.supportupper = true;
        			}
        		}        		
        	}
		}
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		if(this.supportfees){//支持手续费			
			this.supportfeesCheck(items, user);			
		}else if(this.supportupper){//支持业务大类
			this.supportupperCheck(items, user);
		}else{
			this.commonCheck(items, user);
		}
	}
	
	private void commonCheck(String[] items, User user) throws Exception{
		// 检查列数
		if (items.length != 6) {
			throw new Exception("上传数据列数不对,应为5列,且以“|”结尾，请查看文件格式说明!");
		}
		//检查渠道编码
		this.chechWayid(items[0], user);
		//检查结算月份
		this.chechMonth(items[1]);
		//检查税金
		this.chechTax(items[2]);
		//检查奖罚
		this.chechRpmoney(items[3]);
	}
	
	private void supportfeesCheck(String[] items, User user) throws Exception{
		// 检查列数
		if (items.length != 7) {
			throw new Exception("上传数据列数不对,应为6列,且以“|”结尾，请查看文件格式说明!");
		}
		//检查渠道编码
		this.chechWayid(items[0], user);
		//检查结算月份
		this.chechMonth(items[1]);
		//检查税金
		this.chechTax(items[2]);
		//检查奖罚
		this.chechRpmoney(items[3]);
		//检查手续费
		this.chechFees(items[4]);
	}
	
	private void supportupperCheck(String[] items, User user)throws Exception{
		// 检查列数
		if (items.length != 7) {
			throw new Exception("上传数据列数不对,应为6列,且以“|”结尾，请查看文件格式说明!");
		}
		//检查渠道编码
		this.chechWayid(items[0], user);
		//检查结算月份
		this.chechMonth(items[1]);
		//检查业务大类
		this.chechUpperopnid(items[2], user);
		//检查税金
		this.chechTax(items[3]);
		//检查奖罚
		this.chechRpmoney(items[4]);
	}
	
	private void chechUpperopnid(String upperopnid, User user)throws Exception{
		//检查业务大类
		if(upperopnid==null || "".equals(upperopnid.trim())){
			throw new Exception("业务大类编码不能为空");
		}else{
			OperationDelegate delegate = new OperationDelegate();
			OperationVO vo = delegate.doFindByPk(upperopnid.trim(), user);
			if(vo==null || vo.getOpnlevel()==null || vo.getOpnlevel()!=1){
				//业务编码不存在、或者业务级别字段为空、或者业务级别不是一级
				throw new Exception("不是有效的业务大类编码");
			}
		}
	}
	
	private void chechWayid(String wayid, User user) throws Exception{
		//检查渠道编码
		if(wayid==null || "".equals(wayid.trim())){
			throw new Exception("渠道编码不能为空");
		}else{
			WayDelegate delegate = new WayDelegate();
			WayVO vo = delegate.doFindByPk(wayid, user);
			if(vo==null){
				throw new Exception("渠道编码错误，渠道不存在");
			}
			if(vo.getCityid()==null || !vo.getCityid().equals(SessionFactoryRouter.conversionCityid(user.getCityid()))){
				throw new Exception("渠道编码所属地市与当前工号所属地市不一致");
			}
			if(this.iscountyonly){
				if(vo.getCountyid()!=null){
					if(!this.countyid.equals(vo.getCountyid())){
						throw new Exception("渠道编码对应渠道所属分公司与当前工号所属分公司不一致，当前工号只能上传其所属分公司下属渠道数据");
					}
				}else{
					throw new Exception("渠道编码对应分公司为空");
				}
			}
		}
	}
	
	private void chechMonth(String month) throws Exception{
		//检查结算月份
		if (month == null || "".equals(month.trim())) {
			throw new Exception("结算月份不能为空");
		} else if (!month.trim().matches("[0-9]{6}")) {
			throw new Exception("结算月份格式不正确，必须为6位的数字格式的年份加月份，如201208");
		} else {
			int year = Integer.parseInt(month.trim().substring(0, 4));
			int mon = Integer.parseInt(month.trim().substring(4));
			if (year < 1000 || mon < 1 || mon > 12) {
				throw new Exception("结算月份格式不正确，结算月份必须是有效的6位年月，如201208");
			}
		}
	}
	
	private void chechTax(String taxmoney)throws Exception {
		//检查税金
		if(taxmoney!=null && !"".equals(taxmoney.trim())){
			String s = taxmoney.trim();
			try{
				Double.parseDouble(s);
			}catch(NumberFormatException ex){
				throw new Exception("税金字段必须是数字，不能出现非数字字符");
			}			
			int index = s.indexOf(".");
			if(index!=-1){
				if(s.substring(index).length()>5){
					throw new Exception("税金字段小数点后最多允许4位");
				}
				if(s.substring(0, index).length()>6){
					throw new Exception("税金金额字段整数最多允许6位");
				}
			}else{
				if(s.length()>6){
					throw new Exception("税金金额字段整数最多允许6位");
				}
			}			
		}
	}
	
	private void chechRpmoney(String rpmoney)throws Exception{
		//检查奖罚
		if(rpmoney!=null && !"".equals(rpmoney.trim())){
			String s = rpmoney.trim();
			double jf = 0;
			try{
				jf = Double.parseDouble(s);
			}catch(NumberFormatException ex){
				throw new Exception("奖罚金额字段必须是数字，不能出现非数字字符");
			}			
			int index = s.indexOf(".");
			if(index!=-1){
				if(s.substring(index).length()>5){
					throw new Exception("奖罚金额字段小数点后最多允许4位");
				}
				if ((jf > 0 && s.substring(0, index).length() > 6)
						|| (jf < 0 && s.substring(0, index).length() > 7)) {
					throw new Exception("奖罚金额字段整数最多允许6位");
				}
			}else{
				if((jf > 0 && s.length()>6) || (jf < 0 && s.length()>7)){
					throw new Exception("奖罚金额字段整数最多允许6位");
				}
			}
			
		}
	}
	
	private void chechFees(String fees)throws Exception{
		//检查手续费
		if(fees!=null && !"".equals(fees.trim())){
			String s = fees.trim();
			try{
				Double.parseDouble(s);
			}catch(NumberFormatException ex){
				throw new Exception("手续费字段必须是数字，不能出现非数字字符");
			}			
			int index = s.indexOf(".");
			if(index!=-1){
				if(s.substring(index).length()>5){
					throw new Exception("手续费字段小数点后最多允许4位");
				}
				if(s.substring(0, index).length()>6){
					throw new Exception("手续费字段整数最多允许6位");
				}
			}else{
				if(s.length()>6){
					throw new Exception("手续费字段整数最多允许6位");
				}
			}
		}
	}
}
