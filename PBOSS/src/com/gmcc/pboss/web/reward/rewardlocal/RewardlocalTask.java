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
		super.setBatchName("���س����");
		
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
				// �ļ�����ʼ,д�����
				fos.write(doStart());
				String line;
				ResultVO resultVO = new ResultVO();
				int count = 0;
				if(super.isHasTitle()){//����б�����,�����в�����
					line = rin.readLine();
					fos.write(line + "\r\n");
				}
				while ((line = rin.readLine()) != null) {
					if (null != line && line.trim().length() > 0) {
						++count;
						try {
							resultVO = processLine(line.trim(), count); // �ؼ���������һ����¼
							// д������
							fos.write(resultVO.getInfo() + "\r\n");
						}catch(AddTitleException addex){ 
							super.isComplete = true;
							throw addex;
						}catch (Exception e) {
							fos.write(count + "|" + line + "|ʧ��|" + e.getMessage()
									+ "\r\n");
						}
						if (resultVO.isOk()) {
							++ok;
							// ����ֶ�
						} else {
							++fail;
						}
						currentrecord++;
					}
				}
				// �ļ��������
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
						writeLog(batchName, optype, "0");// �ɹ�
					} else if (fail == currentrecord) {
						writeLog(batchName, optype, "1");// ʧ��
					} else {
						writeLog(batchName, optype, "2");// ���ֳɹ�
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
			
			if(!"RPWDLocalRPT".equals(rpttype)){//	��ѡ��ı������Ͳ�����RPWDLocalRPT
				if( rowCount == 1){//��ӱ��س���ֶζ���
					if(items.length >= 6){
						try{
							String[] titleItems = (String[])ArrayUtils.subarray(items, 6, items.length);
							req = rewardlocalBO.doAddRewardlocaltitle(rewardmonth, rpttype, titleItems);
						}catch(Exception e){
							e.printStackTrace();
							throw new AddTitleException(" ��ӱ���ʱ����"+e.getMessage());
						}
					}
					super.countrecord--;
				}else if( rowCount>1){//���س��ֵ
					if(rowCount == 2){
						super.ok = 0;
					}
					//�Ǽ���Ϊ�գ�Ĭ��Ϊ0
					if(items[5]==null || "".equals(items[5].trim())){
						items[5] = "0";
					}
					rewardlocalBO.doAddRewardlocal(rewardmonth, rpttype, items, req);
				}
			}else if("RPWDLocalRPT".equals(rpttype)){//�����س����ϸ���롿�߼�
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
			
			result.setInfo(line+" ����ɹ�");
			result.setOk(true);
		}catch (AddTitleException ex){
			throw new AddTitleException(ex.getMessage());
		}catch(Exception e){
			result.setOk(false);
			result.setInfo(line+" ����ʧ��:"+e.getMessage());
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
