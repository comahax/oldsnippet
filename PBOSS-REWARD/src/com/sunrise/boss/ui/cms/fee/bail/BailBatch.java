package com.sunrise.boss.ui.cms.fee.bail;

import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.Logger;

import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.boss.business.admin.operator.persistent.OperatorListVO;
import com.sunrise.boss.business.cms.fee.bail.persistent.BailVO;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.admin.operator.OperatorDelegate;
import com.sunrise.boss.delegate.cms.fee.bail.BailDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;

public class BailBatch extends BaseBatchTaskBean {
	private Logger log = Logger.getLogger(BailBatch.class);
	private Short oprtype;
	protected Class voClass;
	private BailDelegate delegate;
	private WayDelegate wayd;
	private OperatorDelegate oDelegate;
	private String dbFlag;
	
	public BailBatch()
	{
		try {
			delegate = new BailDelegate();
			wayd = new WayDelegate();
			oDelegate = new OperatorDelegate();
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}
	
	protected String doStart() {
		oprtype=new Short(parameterMap.get("oprtype").toString());
		return "序号 | 渠道编码 | 保证金类型 | 金额 | 缴纳日期 | 操作类型 | 收费员员工号 | 收费日期 | 备注 | 批量导入类型 | 操作结果"+"\r\n";
	}

	/**
	 * 处理一条记录
	 */
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] items = line.split("\\|");
		try {			
			String wayid = items[0];
			String bailtype = items[1];
			Double money = Double.valueOf(items[2]);
			java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyyMMdd");
			Date givetime;
			if(items[3].length()>0){
				givetime = format.parse(items[3]);
			}else{
				givetime = new Date();	
			}
			String opertype = items[4];
			String recvoprcode = items[5];
			Date recvtime;
			if(items[6].length()>0){
				recvtime = format.parse(items[6]);
			}else{
				recvtime = new Date();	
			}		
			String memo = items[7];		
		
			if (oprtype.shortValue() == 0 || oprtype.shortValue() == 2) { // 增加/修改
				try{
				doInsert(wayid, bailtype, money,givetime,opertype,recvoprcode,recvtime,memo);
				}catch (Exception ex) { // 插入失败
					//ex.printStackTrace();
					msg = "插入失败，"+ex.getMessage();
					resultVO.setOk(false);
					resultVO.setInfo(showInfo(resultVO, items, rowCount)+msg);
					return resultVO;
				}
			}
			if (oprtype.shortValue() == 3) { // 删除
				doDelete(wayid, bailtype, money,givetime,opertype,recvoprcode,recvtime,memo);
			}
			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount));
			return resultVO;
		} catch (Exception ex) { // 插入失败
			//ex.printStackTrace();
			msg = ex.getMessage();
			resultVO.setOk(false);
			resultVO.setInfo(showInfo(resultVO, items, rowCount)+msg);
			return resultVO;
		}
	}

	/**
	 * 结果文件格式
	 */
	public String showInfo(ResultVO resultVO, String[] items, int rowCount) {
		final String COMPART = " | "; // 分隔
		StringBuffer resultStr = new StringBuffer();
		// 序号"序号 | 渠道编码 | 保证金类型 | 金额 | 缴纳日期 | 操作类型 | 收费员员工号 | 收费日期 | 备注 | 批量导入类型 | 操作结果"+"\r\n";
		resultStr.append(rowCount).append(COMPART);
		// 渠道编码
		resultStr.append(items[0]).append(COMPART);		
		// 保证金类型
		resultStr.append(items[1]).append(COMPART);
		// 金额
		resultStr.append(items[2]).append(COMPART);
		// 缴纳日期
		resultStr.append(items[3]).append(COMPART);
		// 操作类型
		resultStr.append(items[4]).append(COMPART);
		// 收费员员工号
		resultStr.append(items[5]).append(COMPART);
		// 收费日期
		resultStr.append(items[6]).append(COMPART);
		// 备注
		resultStr.append(items[7]).append(COMPART);
		// 操作类型
		if (oprtype.shortValue() == 0) {
			resultStr.append("增加");
		}
		if (oprtype.shortValue() == 2) {
			resultStr.append("更新");
		}
		if (oprtype.shortValue() == 3) {
			resultStr.append("删除");
		}
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

	private void doDelete(String wayid,String  bailtype,Double money,Date givetime,String opertype,String recvoprcode,Date recvtime,String memo)
			throws Exception {
		 String pkValue = wayid+"|"+bailtype+"|"+money+"|"+givetime+"|"+opertype+"|"+recvoprcode+"|"+recvtime+"|"+memo;
		 BailVO BailVO = (BailVO)delegate.doFindByPk(getDeletePkVO(pkValue),user);
		 if (BailVO == null) {
		 throw new Exception("找不到相应的记录,不在渠道保证金记录表中");
		 }
		 BailVO = new BailVO();
		 BailVO.setWayid(wayid);
		 BailVO.setBailtype(new Short(bailtype));
		 BailVO.setMoney(money);
		 BailVO.setGivetime(givetime);
		 BailVO.setOpertype(new Short(opertype));
		 BailVO.setRecvoprcode(recvoprcode);
		 BailVO.setRecvtime(recvtime);
		 BailVO.setMemo(memo);

		 delegate.doRemove(BailVO,user);
	}

	/**
	 * 插入记录
	 * 
	 */
	private void doInsert(String wayid,String  bailtype,Double money,Date givetime,String opertype,String recvoprcode,Date recvtime,String memo)
			throws Exception {
		
		if (!wayd.isWayExist(wayid, user)) {
			throw new Exception("[渠道代码]不存在！");
		} 
		OperatorListVO oListVO=new OperatorListVO();
		oListVO.set_se_operid(recvoprcode);
		if (oDelegate.doQuery(oListVO, user).getRowCount() == 0) {
			throw new Exception("该收费工号不存在");
		}
		String pkValue = wayid+"|"+bailtype+"|"+money+"|"+givetime+"|"+opertype+"|"+recvoprcode+"|"+recvtime+"|"+memo;
		 //BailVO oldBailVO = (BailVO)delegate.doFindByPk(getDeletePkVO(pkValue),user);
		 BailVO newBailVO = new BailVO();
		 newBailVO.setWayid(wayid);
		 newBailVO.setBailtype(new Short(bailtype));
		 newBailVO.setMoney(money);
		 newBailVO.setGivetime(givetime);
		 newBailVO.setOpertype(new Short(opertype));
		 newBailVO.setRecvoprcode(recvoprcode);
		 newBailVO.setRecvtime(recvtime);
		 newBailVO.setMemo(memo);
						
		 
		 delegate.doCreate(newBailVO, user); // 插数据
		 oprtype = Short.valueOf("0");//默认是新增
		 /*
		 if (oldBailVO == null) {//新增
			 delegate.doCreate(newBailVO, user); // 插数据
			 oprtype = Short.valueOf("0");//默认是新增
		 }else{ //更新
			 delegate.doUpdate(newBailVO, user);
			 oprtype = Short.valueOf("2");
		 }*/
	}

	public void setOprtype(Short oprtype) {
		this.oprtype = oprtype;
	}
	
    /**
     * 按复合主键删除时，返回主键VO
     * 用于List.jsp按删除按钮时，从参数中取出删除数据的主键列
     */
    protected Serializable getDeletePkVO(String pkValue) throws Exception {
        String[] pkValueArray = pkValue.split("\\|"); 
//      TODO: 给出主键的名字数组
        String[] pkNameArray = new String[8];
        pkNameArray[0] = "wayid";		
        pkNameArray[1] = "bailtype";	
        pkNameArray[2] = "money";	
        pkNameArray[3] = "givetime";	
        pkNameArray[4] = "opertype";	
        pkNameArray[5] = "recvoprcode";	
        pkNameArray[6] = "recvtime";	
        pkNameArray[7] = "memo";
        Serializable vo = (Serializable) new BailVO();
        for (int j = 0; j < pkValueArray.length; j++) {
            BeanUtils.setProperty(vo, pkNameArray[j], pkValueArray[j]);
        }       
        return vo;
    }
}
