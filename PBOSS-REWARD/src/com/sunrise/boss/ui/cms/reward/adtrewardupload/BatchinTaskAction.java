package com.sunrise.boss.ui.cms.reward.adtrewardupload;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.business.cms.reward.adtrewardupload.persistent.AdtRewarduploadVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.reward.adtrewardupload.AdtRewarduploadDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.batch.upload.ICheckFormat;
import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;
import com.sunrise.boss.ui.resmanage.common.ResUploadFileAction;
import com.sunrise.pub.tools.PublicUtils;

public class BatchinTaskAction extends ResUploadFileAction {
	protected void setFilecode(HashMap map, User user) {
//		this.filecode = "RESALE_0_0"; // 唯一定义
		this.filecode = "";
	}
	
	/**
	 * 复写父类方法
	 */
	public ActionForward execute(ActionMapping actionMapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType(CONTENT_TYPE);
		HttpSession session = request.getSession();
		User user = (User) session
				.getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);

		if (user == null) {
			user = new User();
			user.setOpercode("test");
			user.setWayid("test");
		}

		try {
			AdtRewarduploadbatchForm adtrewarduploadbatchForm = (AdtRewarduploadbatchForm) form; 
			if (adtrewarduploadbatchForm.getMobile().trim().length() != 11) {
				throw new Exception("短信接收号码必填且必须为11位手机号码.");
			}
			UploadFileForm fileForm = (UploadFileForm) form;
			FormFile file = fileForm.getTheFile();
			HashMap map = getParamMapFromRequest(request, user);

			setFilecode(map, user);

			String filename = getFile(file, user);
			int count = checkFile(file, filename, fileForm.getCheckFormat(), map, user);
			filename = ftpFile(filename, user);
			String filecode = processFile(filename, count, map, user);

			file.destroy();
			
			//带任务号(taskid)调用C++程序处理.FileIntoDB
			//Runtime.getRuntime().exec("FileIntoDB("+ filecode +")");
			
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"文件已上传成功，请收到短信通知后根据任务号:<font color=red>"+filecode+"</font>及时查询处理结果.");
			return actionMapping.findForward("success");
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
			return actionMapping.findForward("error");
		}
	}

	protected List getParamList(HashMap map, User user) throws Exception {
		List list = new ArrayList();
		//addParam(list, "remark", (String) map.get("remark"));
		addParam(list, "cityid", SessionFactoryRouter.conversionCityid(user
				.getCityid()));
		addParam(list, "oprcode", user.getOpercode());
		SimpleDateFormat fs = new SimpleDateFormat("yyyyMMddHHmmss");
		addParam(list, "batchno", user.getCityid() + fs.format(new Date()));
		return list;
	}
	
	/**
	 * 
	 * @param filename
	 * @param count
	 * @param map
	 * @param user
	 * @return
	 * @throws Exception
	 */
	protected String processFile(String filename, int count, HashMap map,
			User user) throws Exception {

		String filecode = getFilecode();
		List list = getParamList(map, user);

		String mobile = (String) map.get("mobile");

		//往CH_ADT_REWARDUPLOAD表中插入待处理记录: 
		//TASKID:CH_ADT_REWARDUPLOAD_SEQ自动生成
		//UPLOADFILE:上传文件保存的路径
		//TASKSTATE:2待处理
		//OPRCODE:操作员工号
		//UPLOADTIME:系统当前时间
		//TOTALCOUNT:文件总记录数
		//MOBILE:前台录入的’短信通知手机号码’
		AdtRewarduploadVO adtrewarduploadVO = new AdtRewarduploadVO();
		adtrewarduploadVO.setUploadfile(filename);
		adtrewarduploadVO.setTaskstate(new Byte("2"));
		adtrewarduploadVO.setOprcode(user.getOpercode());
		adtrewarduploadVO.setUploadtime(new Date());
		//adtrewarduploadVO.setTotalcount(count);
		adtrewarduploadVO.setMobile(mobile);
		new AdtRewarduploadDelegate().doCreate(adtrewarduploadVO, user);

		return adtrewarduploadVO.getTaskid().toString();
	}
	
	/**
	 * 检查文件格式，并返回文件总行数
	 * 
	 * @param filename
	 * @param iCheckFormat
	 * @param user
	 * @return
	 * @throws Exception
	 */
	protected int checkFile(FormFile file, String filename,
			ICheckFormat iCheckFormat, HashMap map, User user) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
		if(file.getFileSize()<=0 && file.getFileData().length<=0)
		{
			throw new Exception("上传的文件数据不能为空!");
		}
		
//		SELECT ParamValue FROM IB_GL_SysParam WHERE SystemId='74' AND ParamType='channel';
		SysparamDelegate sysparamDelegate = new SysparamDelegate();
		SysparamVO sysparamVO = new SysparamVO();
		sysparamVO.setSystemid(new Long("74"));
		sysparamVO.setParamtype("channel");
		sysparamVO = sysparamDelegate.doFindByPk(sysparamVO, user);
		if(sysparamVO == null || sysparamVO.getParamvalue() == null || "".equals(sysparamVO.getParamvalue())){
			throw new Exception("系统参数<font color=red>[酬金上传文件大小设置]</font>未配置，请通知管理人员.");
		}
		//System.out.println(1024 * 1024 * Integer.parseInt(sysparamVO.getParamvalue()));
		//System.out.println("file.getFileSize(): "+file.getFileSize());
		if(file.getFileSize() > 1024 * 1024 * Integer.parseInt(sysparamVO.getParamvalue())){
			throw new Exception("您上传的文件超过<font color=red>" + sysparamVO.getParamvalue() + "</font>M,请拆分后再上传.");
		}
		
//		FileitemDelegate fiDelegeate = new FileitemDelegate();
//		FileitemListVO listVO = new FileitemListVO();
//		listVO.set_se_filecode(getFilecode());
//		DataPackage fidp = fiDelegeate.doQuery(listVO, user, false);
//		if (fidp.getDatas().size()<=0) {
//			throw new Exception("文件编码" + getFilecode() + "没有定义文件数据项，请联系管理员！");
//		}

//		FiledefDelegate fdefDelegate = new FiledefDelegate();
//		FiledefVO fdVo = fdefDelegate.doFindByPk(this.filecode, user);
//		int maxLine = 100000;
//		if (fdVo != null) {
//			maxLine = fdVo.getLinelimit().intValue();
//		} else {
//			throw new Exception("文件编码" + getFilecode() + "无定义，请联系管理员！");
//		}

		FileInputStream fileInputStream = new FileInputStream(filename);
		InputStreamReader read = new InputStreamReader(fileInputStream, "gbk");
		BufferedReader rin = new BufferedReader(read);
		String line;
		int row = 0;// 记录当前检查到的行数

		try {
			while ((line = rin.readLine()) != null && row < 21 ) {//增加不再遍历整个文件
				if (line.trim().length() > 0) {
					++row;
//					if (row > maxLine) {
//						throw new Exception("文件实际行数大于文件所定义的最大行数");
//					}
//					Iterator iter = fidp.getDatas().iterator();
//					String[] items = StringUtils.splitPreserveAllTokens(line, splitFlag);
//					if (items.length != fidp.getDatas().size()) {
//						throw new Exception("上传数据列数不对,第" + row + "行数据应为"
//								+ fidp.getDatas().size() + "列,请查看说明帮助!");
//					}
//					int col = 0;
//					while (iter.hasNext()) {
//						FileitemVO fileitem = (FileitemVO) iter.next();
//						checkItem(row, items[col], fileitem);
//						col++;
//					}
					//检查前20行
					if(row < 21){
						String[] items = StringUtils.splitPreserveAllTokens(line, splitFlag);
						if (items.length != 9) {
							throw new Exception("上传数据列数不对,第" + row + "行数据应为8列,请查看说明帮助!");
						}else{
							for(int col = 0; col < 8; col++){
								checkItem2(row, col, items[col].trim(), user);
							}
						}
					}
				}
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			rin.close();
			read.close();
			fileInputStream.close();
		}
		return row;
	}
	
	// 检查数据项
	protected void checkItem2(int row, int col, String item, User user)
			throws Exception {
		switch (col) {
		case 0://渠道编码:必须为COMS中登记的有效社会渠道编码(WAYTYPE='AG' AND WAYSUBTYPE<>’ZJTY’ AND WAYSTATE=1)或合作商编码(WAYTYPE='AG' AND WAYSUBTYPE<>’DIS’ AND WAYSTATE=1).
			if(StringUtils.isEmpty(item)){
				throw new Exception("第" + row + "行格式有错，渠道编码不能为空");
			}
			//1.SELECT WAYID FROM CH_PW_WAY WHERE WAYTYPE = 'AG' AND WAYSUBTYPE <> 'ZJTY' AND WAYSTATE=1
			WayDelegate waydelegate=new WayDelegate();
			WayListVO wayListVO1 = new WayListVO();
			wayListVO1.set_se_wayid(item);
			//wayListVO1.set_ne_waystate(Short.valueOf("1"));
			wayListVO1.set_se_waytype("AG");
			wayListVO1.set_sne_waysubtype("ZJTY");
			DataPackage waydp1 = waydelegate.doQuery(wayListVO1, user);
			if(waydp1.getRowCount()==0){
				throw new Exception("第" + row + "行格式有错，渠道编码[" + item + "]不存在");
			}
			break;
		case 1://业务编码:必须为COMS中登记的有效业务编码(select opnid from ch_pw_operation).
			if(StringUtils.isEmpty(item)){
				throw new Exception("第" + row + "行格式有错，业务编码不能为空");
			}
			//SELECT OPNID FROM CH_PW_OPERATION
			OperationDelegate odel = new OperationDelegate();
			if(null == odel.doFindByPk(item, user)){
				throw new Exception("第" + row + "行格式有错，业务编码[" + item + "]不存在");
			}
			break;
		case 2://酬金期数:必须为1,2,3中任何一位数字
			if(StringUtils.isEmpty(item)){
				throw new Exception("第" + row + "行格式有错，酬金期数不能为空");
			}
			Set<String> rewardtypeset = new HashSet<String>();//非计件业务集合
			rewardtypeset.add("1");
			rewardtypeset.add("2");
			rewardtypeset.add("3");
			if(!rewardtypeset.contains(item)){
				throw new Exception("第" + row + "行格式有错，酬金期数必须为1,2,3中任何一位数字");
			}
			break;		
		case 3://手机、充值卡号码或IMEI号:如果有值必须小于等于17位数字.
			if(!StringUtils.isEmpty(item)){
				if(item.length() > 17){
					throw new Exception("第" + row + "行格式有错，手机、充值卡号码或IMEI号必须小于等于17位数字");
				}
				for (int i = 0; i < item.length(); i++) {
					if (item.charAt(i) < '0' || item.charAt(i) > '9') {
						throw new Exception("第" + row + "行格式有错，手机、充值卡号码或IMEI号[" + item + "]应该为数字字符串。");
					}
				}
			}
			break;
		case 4://结算月份:6位年月YYYYMM,如:201201,必填
			if(!CheckUtil.checkString(item, 6, true)){
				throw new Exception("第" + row + "行格式有错，结算月份不能为空且必须为6位数字");
			}
			try{
				Date now = new Date();
				String nowstr = PublicUtils.formatUtilDate(now, "yyyyMM");
				if(new Long(item)>new Long(nowstr)){
					throw new Exception("第" + row + "行格式有错，结算月份不能大于当前月份");
				}
			}catch (Exception e) {
				throw new Exception("第" + row + "行格式有错，结算月份不正确");
			}
			break;
		case 5://业务发生时间: 时间格式: 2011-11-01 08:04:35
			if(StringUtils.isEmpty(item)){
				throw new Exception("第" + row + "行格式有错，业务发生时间不能为空");
			}
			try{
				Date date = PublicUtils.UtilStrToDate(item, "yyyy-MM-dd HH:mm:ss");
				Calendar ca = Calendar.getInstance(Locale.CHINA);//当前时间
				Calendar ca2 = Calendar.getInstance();
				ca2.setTime(date);
				if(ca2.after(ca)){
					throw new Exception("第" + row + "行格式有错，业务发生时间不能大于当前系统时间");
				}
			}catch (Exception e) {
				throw new Exception("第" + row + "行格式有错，业务发生时间不正确");
			}
			break;
		case 6://业务量或业务发生金额:如果带小数则不能超过2位小数位.必填
			if(StringUtils.isEmpty(item)){
				throw new Exception("第" + row + "行格式有错，业务量或业务发生金额不能为空");
			}
//			if(new Double(item) <= 0){
//				throw new Exception("第" + row + "行格式有错，业务量或业务发生金额必须为正数");
//			}
			if(!CheckUtil.checkDouble(item,10, 4)||((item.trim().indexOf(".") == -1 && item.trim().length() > 10))){
				throw new Exception("第" + row + "行格式有错，业务量或业务发生金额整数部分不能超过10位,小数部分不能超过4位");
			}			
			break;
		case 7://应发酬金合计: 必填,数字可以带小数.
			if(StringUtils.isEmpty(item)){
				throw new Exception("第" + row + "行格式有错，应发酬金合计不能为空");
			}
			if(!CheckUtil.checkDouble(item,10, 4)||((item.trim().indexOf(".") == -1 && item.trim().length() > 10))){
				throw new Exception("第" + row + "行格式有错，应发酬金合计整数部分不能超过10位,小数部分不能超过4位");
			}
			break;
		default:
			break;
		}
	}
	
}