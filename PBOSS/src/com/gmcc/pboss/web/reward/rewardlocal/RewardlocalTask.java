package com.gmcc.pboss.web.reward.rewardlocal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;


import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.gmcc.pboss.business.reward.rewardlocaldtl.RewardlocaldtlVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.reward.rewardlocal.Rewardlocal;
import com.gmcc.pboss.control.reward.rewardlocal.RewardlocalBO;
import com.gmcc.pboss.control.reward.rewardlocaldtl.Rewardlocaldtl;
import com.gmcc.pboss.control.reward.rewardlocaldtl.RewardlocaldtlBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class RewardlocalTask extends BaseBatchTaskBean{

	private Logger log = Logger.getLogger(BaseBatchTaskBean.class);
	
	private String rewardmonth;
	private String rpttype;	
	private int[] req;
	
	public RewardlocalTask() throws Exception {
		super();
		// TODO Auto-generated constructor stub
		super.setBatchName("本地酬金导入");
		
	}

	@Override
	public void doProcessFile(String fileInPath, String fileOutPath)
			throws Exception {
		// TODO Auto-generated method stub
		rewardmonth = (String)parameterMap.get("rewardmonth");
		rpttype = (String)parameterMap.get("rpttype");
		try{
			Rewardlocal rewardlocalBO = (Rewardlocal)BOFactory.build(RewardlocalBO.class,user);
			rewardlocalBO.doRemoveReward(rewardmonth, rpttype);
			File resultFile = new File(fileOutPath);
			this.resultFile = fileOutPath;
			FileInputStream fileInputStream = new FileInputStream(fileInPath);
			InputStreamReader read = new InputStreamReader(fileInputStream, "gbk");
			BufferedReader rin = new BufferedReader(read);
			FileOutputStream fileOutputStream = new FileOutputStream(resultFile);
			OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream,
					"gbk");
			BufferedWriter fos = new BufferedWriter(writer);
			try {
				// 文件处理开始,写标题等
				fos.write(doStart());
				String line;
				ResultVO resultVO = new ResultVO();
				int count = 0;
				if(super.isHasTitle()){//如果有标题行,标题行不处理
					line = rin.readLine();
					fos.write(line + "\r\n");
				}
				while ((line = rin.readLine()) != null) {
					if (null != line && line.trim().length() > 0) {
						++count;
						try {
							resultVO = processLine(line.trim(), count); // 关键处理，处理一条记录
							// 写处理结果
							fos.write(resultVO.getInfo() + "\r\n");
						}catch(AddTitleException addex){ 
							super.isComplete = true;
							throw addex;
						}catch (Exception e) {
							fos.write(count + "|" + line + "|失败|" + e.getMessage()
									+ "\r\n");
						}
						if (resultVO.isOk()) {
							++ok;
							// 组合字段
						} else {
							++fail;
						}
						currentrecord++;
					}
				}
				// 文件处理结束
				fos.write(doEnd());
			} catch (Exception ex) {
				fos.write(ex.getMessage());
				
				fail = countrecord;
			} finally {
				rin.close();
				read.close();
				fos.close();
				writer.close();
				this.resultFile = fileOutPath;
				currentrecord = countrecord;
				isComplete = true;
				if (isWriteLog) {
					if (ok == currentrecord) {
						writeLog(batchName, optype, "0");// 成功
					} else if (fail == currentrecord) {
						writeLog(batchName, optype, "1");// 失败
					} else {
						writeLog(batchName, optype, "2");// 部分成功
					}
				} else {
					// deleteFile_(fileInPath);
				}
			}
		}catch(Exception e){
			LoggerUtils.error(e, log);
		}

	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		// TODO Auto-generated method stub
		ResultVO result = new ResultVO();
		
		try{
			Rewardlocal rewardlocalBO = (Rewardlocal)BOFactory.build(RewardlocalBO.class,user);
			String[] items = StringUtils.splitPreserveAllTokens(line, "|");
			
			if(!"RPWDLocalRPT".equals(rpttype)){//	若选择的报表类型不等于RPWDLocalRPT
				if( rowCount == 1){//添加本地酬金字段定义
					if(items.length >= 6){
						try{
							String[] titleItems = (String[])ArrayUtils.subarray(items, 6, items.length);
							req = rewardlocalBO.doAddRewardlocaltitle(rewardmonth, rpttype, titleItems);
						}catch(Exception e){
							e.printStackTrace();
							throw new AddTitleException(" 添加标题时出错："+e.getMessage());
						}
					}
					super.countrecord--;
				}else if( rowCount>1){//本地酬金值
					if(rowCount == 2){
						super.ok = 0;
					}
					//星级可为空，默认为0
					if(items[5]==null || "".equals(items[5].trim())){
						items[5] = "0";
					}
					rewardlocalBO.doAddRewardlocal(rewardmonth, rpttype, items, req);
				}
			}else if("RPWDLocalRPT".equals(rpttype)){//【本地酬金明细导入】逻辑
					Rewardlocaldtl rewardlocaldtlBO = (Rewardlocaldtl)BOFactory.build(RewardlocaldtlBO.class,user);
					RewardlocaldtlVO rewardlocaldtlVO = new RewardlocaldtlVO();
					rewardlocaldtlVO.setRewardmonth(rewardmonth);
					rewardlocaldtlVO.setWayid(items.length>=1?items[0]:null);
					rewardlocaldtlVO.setMobleno(items.length>=2?items[1]:null);	
					rewardlocaldtlVO.setType(items.length>=3?items[2]:null);
					rewardlocaldtlVO.setFailureexplain(items.length>=4?items[3]:null);
					if(items.length>=5 && items[4].trim().matches("([0-9]+)(\\.?)([0-9]*)")){
						rewardlocaldtlVO.setPaymoney(new Double(items[4].trim()));
					}else{
						rewardlocaldtlVO.setPaymoney(new Double(0));
					}
					rewardlocaldtlBO.doCreate(rewardlocaldtlVO);
			}
			
			result.setInfo(line+" 处理成功");
			result.setOk(true);
		}catch (AddTitleException ex){
			throw new AddTitleException(ex.getMessage());
		}catch(Exception e){
			result.setOk(false);
			result.setInfo(line+" 处理失败:"+e.getMessage());
			e.printStackTrace();
			LoggerUtils.error(e, log);
		}
		return result;
	}
	
	@Override
	public void run() {
		rpttype = (String)parameterMap.get("rpttype");
		if("RPWDLocalRPT".equals(rpttype)){
			super.setHasTitle(true);
		}
		super.run();
	}
	
	public static void main(String[] args){
		try{
			System.out.println(StringUtils.isNumeric("222.32"));
			System.out.println(StringUtils.isNumeric("222"));
			System.out.println(StringUtils.isNumeric("222a"));
			
			
			String src = "aa|bb|cc|dd|ee|ff|hh|ii|jj|kk|ll|mm|nn|00";
			String[] items = StringUtils.splitPreserveAllTokens(src, "|");
			String[] subItems1 = (String[])ArrayUtils.subarray(items, 0, 6);
			String[] subItems = (String[])ArrayUtils.subarray(items, 6, items.length);
			
			System.out.println("********");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
