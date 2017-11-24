/**
* auto-generated code
* Thu Dec 15 07:12:07 GMT 2011
*/
package com.sunrise.boss.ui.cms.cityrecord;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.sunrise.boss.business.cms.bbc.bbcrewardrecord2.control.BbcRewardrecord2Control;
import com.sunrise.boss.business.cms.bbc.bbcrewardrecord2.control.BbcRewardrecord2ControlBean;
import com.sunrise.boss.business.cms.bbc.bbcrewardrecord2.persistent.BbcRewardrecord2ListVO;
import com.sunrise.boss.business.cms.chadtdictparam.persistent.ChAdtDictparamListVO;
import com.sunrise.boss.business.cms.chadtdictparam.persistent.ChAdtDictparamVO;
import com.sunrise.boss.business.cms.cityrecord.control.CityrecordControl;
import com.sunrise.boss.business.cms.cityrecord.control.CityrecordControlBean;
import com.sunrise.boss.business.cms.cityrecord.persistent.CityrecordListVO;
import com.sunrise.boss.business.cms.cityrecord.persistent.CityrecordVO;
import com.sunrise.boss.business.cms.reward.pwdictparam.persistent.PwDictparamListVO;
import com.sunrise.boss.business.cms.reward.pwdictparam.persistent.PwDictparamVO;
import com.sunrise.boss.business.cms.reward.rewardrecord.control.RewardrecordControl;
import com.sunrise.boss.business.cms.reward.rewardrecord.control.RewardrecordControlBean;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.RewardrecordListVO;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.RewardrecordVO;
import com.sunrise.boss.business.cms.rewardupload.control.RewarduploadControl;
import com.sunrise.boss.business.cms.rewardupload.control.RewarduploadControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.chadtdictparam.ChAdtDictparamDelegate;
import com.sunrise.boss.delegate.cms.reward.pwdictparam.PwDictparamDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.boss.ui.commons.ftp.FtpAccess;
import com.sunrise.boss.ui.commons.ftp.FtpInfo;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2NameConfiger;
import com.sunrise.boss.ui.resmanage.common.ResPubUtil;
import com.sunrise.pub.tools.PublicUtils;

/**
 * <p>Title: CityrecordAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class Cityrecord4IssueTaskBean extends BaseBatchTaskBean {
	private static final Logger log = Logger.getLogger(Cityrecord4IssueTaskBean.class);
	
	private String systemflag;
	private String rewardmonth ;
	private String isflag ;
	//可选参数
	private String wayid ;
	private String chainhead;
	private String opnid;
	private String approveid ;
	private String countyid;
	private String taskid ;
	private String sin_opnid;
	private String mobile;

	protected int countrecord;
	
	protected int currentrecord = 0;
	
	private int pwmainopnPersent = 0;
	private int pwopn07Persent = 0;
	private int pwopn0403Persent = 0;
	
//	protected boolean isComplete=false;
	
	protected boolean start_end; // 进度条辅助标志
	
    public int getCountrecord() {
		return countrecord;
	}

	public void setCountrecord(int countrecord) {
		this.countrecord = countrecord;
	}

	public int getCurrentrecord() {
		return currentrecord;
	}

	public void setCurrentrecord(int currentrecord) {
		this.currentrecord = currentrecord;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public boolean isStart_end() {
		return start_end;
	}

	public void setStart_end(boolean start_end) {
		this.start_end = start_end;
	}
	public void setStart_end() {
        this.start_end = false;
    }
	public Cityrecord4IssueTaskBean() {
		
    }
    
 // **************************** start **********************
    public synchronized int getPercent() {
        if (countrecord == 0) {
            return 0;
        }
        int res = (currentrecord * 100) / countrecord;
        if (res == 100) {
            this.setStart_end();
        }
        if(isComplete){
            res = 100;
        }
        return res;
    }
    
    protected String doStart() {
		return " \r\n";
	}
    
    //2012-8-2 shixiaolong rewrite
    public void run(){
    	CityrecordListVO params = this.buildListVO();
    	if ("1".equals(params.get_ne_isflag()) && "2".equals(params.get_ne_systemflag())) {
			this.doPwrewardissue(params);
		} else if ("1".equals(params.get_ne_isflag()) && "3".equals(params.get_ne_systemflag())) {
			this.doBbcrewardisue(params);
		} else {
			this.doOnlyissue(params);
		}
    }
   
    //地市上传酬金发布
    private void doOnlyissue(CityrecordListVO params){
    	String fileInPath = filename;
		this.resultFile = fileInPath;
    	BufferedWriter fos;
    	try{
    		fos = this.getBufferedWriter(fileInPath);
    		// 文件处理开始,写标题等
			fos.write("渠道编码|业务编码|酬金期数|手机、充值卡号码或IMEI号|结算月份|业务发生时间|业务量或业务发生金额|应发酬金合计|备注 \r\n");			
			setRunning(true);
			this.countrecord = 1;
			
    		CityrecordControl crcontrol = (CityrecordControl) ControlFactory.build(CityrecordControlBean.class);
    		// 模拟进度条，一次100%，一条sql，update所有记录。只是针对ch_adt_cityrecord
			crcontrol.doOnlyissue(params, user);
			currentrecord = 1;
			isComplete = true;
			fos.write(" 处理完成  \r\n");
			
			setRunning(false);
			if(this.closeFileWriter(fos)){//本地文件流关闭成功，同步FTP文件
				this.doFTP(fileInPath);
			}			
    	}catch(Exception ex){
    		setRunning(false);
			isComplete = true;
			ex.printStackTrace();
    	}finally{
    		this.setThreadDictparam(params, "0");//将状态改为开启，以允许其它发布操作
    	}    	
    }
    
    //社会渠道酬金同步
    private void doPwrewardissue(CityrecordListVO params){
    	try{
    		long starttime = System.currentTimeMillis();
    	    setRunning(true);
    		isComplete = false;
    		// 设置分页查询的页大小
    		params.set_pagesize(this.getPagesize());    		
    		RewarduploadControl rpcontrol = (RewarduploadControl) ControlFactory.build(RewarduploadControlBean.class);
    		//long datestamp = ((Integer) Math.round(new Date().getTime() / 1000));
			Long datestamp = rpcontrol.doGetSequence(user);
    		String[] filenames = new String[5];
    		String head = this.filename.substring(0, this.filename.length() - 4);
    		String tail = this.filename.substring(this.filename.length() - 4,
    				this.filename.length());
    		filenames[0] = head + "_main" + tail;
    		filenames[1] = head + "_main_multi" + tail;
    		filenames[2] = head + "_07" + tail;
    		filenames[3] = head + "_07_multi" + tail;
    		filenames[4] = head + "_0403" + tail;
    		
    		Thread mainopn = new Thread(new PwdealThread(filenames[0], filenames[1], PwdealThread.MAIN, params, datestamp));
    		Thread special07 = new Thread(new PwdealThread(filenames[2], filenames[3], PwdealThread.SPECIAL_07, params, datestamp));
    		Thread special0403 = new Thread(new PwdealThread(filenames[4], null, PwdealThread.SPECIAL_0403, params, datestamp));

    		this.resultFile = head + ".zip";

    		mainopn.setContextClassLoader(this.getClass().getClassLoader());
    		special07.setContextClassLoader(this.getClass().getClassLoader());
    		special0403.setContextClassLoader(this.getClass().getClassLoader());
    		mainopn.start();
    		special07.start();
    		special0403.start();

    		this.currentrecord = 0;
    		this.countrecord = 100;
    		int currpersent;
    		while (isRunning() && !isCompleted()) {
    			if (mainopn.getState() == Thread.State.TERMINATED
    					&& special07.getState() == Thread.State.TERMINATED
    					&& special0403.getState() == Thread.State.TERMINATED) {
    				System.out.println("多线程任务结束，开始写文件");
    				log.info("多线程任务结束，开始写文件");
    				this.currentrecord = 99;//此时文件还未写完，1是为后续写ZIP和FTP文件预留的时间				
    				try{// 文件压缩
    					String errmsg = this.doZip(this.resultFile, filenames);
    					if(errmsg == null){
    						this.doFTP(this.resultFile);// FTP
    					}else{	
    						System.out.println("压缩文件时出错："+errmsg);
    						log.info("压缩文件时出错："+errmsg);
    					}
    				}catch(Exception ex){
    					ex.printStackTrace();
    				}				
    				this.currentrecord = 100;
    				isComplete = true;
    			} else {
    				currpersent = this.pwmainopnPersent + this.pwopn07Persent + this.pwopn0403Persent;
    				if(currpersent>=99){
    					this.currentrecord = 99;
    				}
    				this.currentrecord = currpersent;
    			}
    		}		
    		
    		this.setRunning(false);
    		this.setThreadDictparam(params, "0");//将状态改为开启，以允许其它发布操作	
    		long intervaltime = System.currentTimeMillis() - starttime;
    		System.out.println("处理时长:"+intervaltime);
    		log.info("处理时长:"+intervaltime);
		}catch(Exception ex){
			ex.printStackTrace();
		}    	
    }
    
    //写ZIP压缩文件
    private String doZip(String targetname, String[] filenames)throws Exception{
    	String errmsg = null;
    	System.out.println("准备生成压缩文件：" + targetname);
    	log.info("准备生成压缩文件：" + targetname);
		final int BUFFER = 4096;
		int readByte;
		FileOutputStream dest = new FileOutputStream(targetname);
		ZipOutputStream zipout = new ZipOutputStream(dest);
		byte data[] = new byte[BUFFER];
		BufferedInputStream orgin = null;
		File file = null;
		for (String filename : filenames) {
			file = new File(filename);
			if (!file.exists()) {
				errmsg = "文件"+filename+"不存在；";
				continue;
			}
			orgin = new BufferedInputStream(new FileInputStream(file));
			System.out.println("准备压缩文件：" + filename);
			log.info("准备压缩文件：" + filename);
			ZipEntry entry = new ZipEntry(file.getName());
			zipout.putNextEntry(entry);
			while ((readByte = orgin.read(data)) > 0) {
				zipout.write(data, 0, readByte);
			}
			orgin.close();
			zipout.closeEntry();
			System.out.println("完成压缩文件：" + filename);
			log.info("完成压缩文件：" + filename);
		}
		zipout.close();
		System.out.println("生成压缩文件完成：" + targetname);
		log.info("生成压缩文件完成：" + targetname);
		return errmsg;
    }
    
    //线程类，实现社会渠道酬金的多线程同步
    private class PwdealThread extends Observable implements Runnable,Observer{
    	private ConcurrentLinkedQueue<Collection> queue;
    	private String pwfilename;
    	private String pwfilename_multi;
    	private int dealtype;
    	private CityrecordListVO params;
    	private long datestamps;
    	private BufferedWriter fos = null;
    	private BufferedWriter fosMulti = null;
    	private List<RewardrecordVO> multipays = null;
    	public static final int MAIN = 0;
    	public static final int SPECIAL_07 = 1;
    	public static final int SPECIAL_0403 = 2;
    	private boolean finished = false;
    	private int totalcount = 0;
    	private int current = 0;
    	private CityrecordControl crcontrol;
    	
    	public PwdealThread(String pwfilename, String pwfilename_mutil, int type, CityrecordListVO params, long datestamps)
    	throws Exception{
    		super();
    		this.queue = new ConcurrentLinkedQueue<Collection>();
    		this.pwfilename = pwfilename;
    		this.dealtype = type;
    		if(this.dealtype==SPECIAL_0403){
    			this.pwfilename_multi = null;
    		}else{
    			this.pwfilename_multi = pwfilename_mutil;
    		}
    		this.params = params;
    		this.datestamps = datestamps;
    		this.addObserver(this);
    		this.multipays = new ArrayList<RewardrecordVO>();
    		this.crcontrol = (CityrecordControl) ControlFactory.build(CityrecordControlBean.class);
    	}
    	
    	public void run(){
    		try{
    			int total = this.doQueryCount();    	
    			this.totalcount = total;
        		DataPackage dp = new DataPackage();
        		if(fos==null){
    				fos = getBufferedWriter(this.pwfilename);
    				// 文件处理开始,写标题等
        			fos.write("渠道编码|业务编码|酬金期数|手机、充值卡号码或IMEI号|结算月份|业务发生时间|业务量或业务发生金额|应发酬金合计\r\n");	
    			}
        		if(this.dealtype!=SPECIAL_0403){
        			fosMulti = getBufferedWriter(this.pwfilename_multi);
        			// 文件处理开始,写标题等
        			fosMulti.write("渠道编码|业务编码|酬金期数|手机、充值卡号码或IMEI号|结算月份|业务发生时间|业务量或业务发生金额|应发酬金合计|备注\r\n");
        		}
				if (total <= 0) {// 处理没有结果集的情况
					fos.write("无数据需要同步，处理完成\r\n");
					fos.close();
					if(this.dealtype!=SPECIAL_0403){
						fosMulti.write("无数据需要同步，处理完成\r\n");
						fosMulti.close();
					}					
					this.current = 1;
					this.totalcount = 1;
					finished = true;
					this.calPersent();
				} else {
					int totalpage = (total + Integer.parseInt(params.get_pagesize()) - 1) / Integer.parseInt(params.get_pagesize());
					for (int i = totalpage; i >= 1; i--) {//此处必须由最后一页向前处理
						params.set_pageno("" + i);
						dp = this.doQueryData();
						if (dp.getDatas().size() > 0) {
							this.queue.add(dp.getDatas());
							this.setChanged();
							this.notifyObservers();//此方法会导致update()方法触发写文件操作，实现写文件和查询数据查询进行
						}
					}
					
					if( !this.queue.isEmpty()){
						this.notifyObservers();
					}
					
					String insertInfo = null;
//					try{
						params.set_pageno(""+totalpage);//用于根据每页大小确定总共有多少数据量需要保存
						insertInfo = this.doInsert();
						insertInfo = "---------------批量同步数据处理结果：处理数据量"+total+"条，任务号"+datestamps+","+insertInfo;
						System.out.println(insertInfo);
						log.info(insertInfo);
						fos.write(insertInfo+"\r\n");												
//					}catch(Exception ex){
//						insertInfo = "---------------批量同步数据异常，以上数据均处理失败，处理数据量"+total+"条，任务号"+datestamps;
//						System.out.println(insertInfo);
//						fos.write(insertInfo+"\r\n");
//						ex.printStackTrace();
//					}
					
					//处理剩余待拆分记录						
					if (this.multipays.size() > 0) {
						this.doDealMultipays();							
					}
					if(this.dealtype!=SPECIAL_0403){
						fosMulti.write("---------------分期发放酬金同步处理完毕，任务号"+datestamps+"\r\n");
					}
					
					fos.close();
					if(this.dealtype!=SPECIAL_0403){
						fosMulti.close();
					}
					finished = true;					
				}
    		}catch(Exception ex){
    			finished = true;
    			ex.printStackTrace();
    		}    		
    	}
    	
    	//计算处理进度
    	private void calPersent(){
    		switch(this.dealtype){
    		case 0:
    			if(finished){
        			pwmainopnPersent = 80;//其他占比百分之80
        		}else{
        			pwmainopnPersent  = this.current*80/this.totalcount;
        		}
    			break;
    		case 1:
    			if(finished){
        			pwopn07Persent = 10;//07类业务占比百分之10
        		}else{
        			pwopn07Persent  = this.current*10/this.totalcount;
        		}
    			break;
    		case 2:
    			if(finished){
        			pwopn0403Persent = 10;//0403类业务占比百分之10
        		}else{
        			pwopn0403Persent  = this.current*10/this.totalcount;
        		}
    			break;
    		}
    	}
    	
    	//处理写文件，实现写文件和查询数据查询进行
    	public void update(Observable o, Object arg){
    		try{    					
    			Collection data = this.queue.poll();
    			while(data!=null){
    				Iterator<RewardrecordVO> it = data.iterator();
    				while(it.hasNext()){
    					RewardrecordVO rrvo = it.next();
    					it.remove();
    					CityrecordVO crvo = new CityrecordVO();
    					this.doRewardCity(rrvo, crvo);
    					this.calPersent();
    				}
    				data = this.queue.poll();
    			}
    			if(this.pwfilename_multi!=null && this.multipays.size()>=Integer.parseInt(this.params.get_pagesize())){
    				//为避免由于保存后与CH_PW_REWARDRECORD表ID冲突导致分页查询、保存出错，需要将rewardlistid设为空
    				this.doDealMultipays();
    			}
    		}catch(Exception ex){
    			ex.printStackTrace();
    		}
    	}
    	
    	//写每一条记录
    	private void doRewardCity(RewardrecordVO rrvo, CityrecordVO crvo)throws IOException{
    		String line = "";
    		ResultVO resultVO = new ResultVO();
    		try{
    			BeanUtils.copyProperties(crvo, rrvo);
    			if(this.dealtype==SPECIAL_0403){
    				crvo.setMobile(rrvo.getBakinfo());
    				crvo.setIsflag((short)1);
					crvo.setSystemflag((short)2);
					crvo.setPaymoney(rrvo.getPaysum());
					crvo.setRewardlistid(rrvo.getRewardlistid());
					crvo.setOprcode(user.getOpercode());
					crvo.setOptime(new Date());
					crvo.setTaskid(new Long(this.datestamps));
    			}else{
    				if(rrvo.getPaymoney1()!=null && rrvo.getPaymoney1()>0){//第一期大于零
    					crvo.setRewardmonth(rrvo.getPaymonth1());
    					crvo.setPaymoney(rrvo.getPaymoney1());
    					if(rrvo.getPaymoney2()!=null && rrvo.getPaymoney2()>0){//第二期大于零
    						if(rrvo.getPaymoney3()!=null && rrvo.getPaymoney3()>0){//第三期大于零    							
    	    					this.multipays.add(rrvo);
    	    					this.totalcount=this.totalcount+2;//再拆分出2条
    						}else{//第三期等于零    							
    	    					this.multipays.add(rrvo);
    	    					this.totalcount=this.totalcount+1;//再拆分出1条
    						}
    					}else{//第二期等于零
    						if(rrvo.getPaymoney3()!=null && rrvo.getPaymoney3()>0){//第三期大于零    							
    	    					this.multipays.add(rrvo);
    	    					this.totalcount=this.totalcount+1;//再拆分出1条
    						}else{//第三期等于零    							
    						}
    					}
    				}else{//第一期等于零
    					if(rrvo.getPaymoney2()!=null && rrvo.getPaymoney2()>0){//第二期大于零
    						crvo.setRewardmonth(rrvo.getPaymonth2());
	    					crvo.setPaymoney(rrvo.getPaymoney2());
    						if(rrvo.getPaymoney3()!=null && rrvo.getPaymoney3()>0){//第三期大于零    							
    	    					this.multipays.add(rrvo);
    	    					this.totalcount=this.totalcount+1;//再拆分出1条
    						}else{//第三期等于零    							
    						}
    					}else{//第二期等于零
    						if(rrvo.getPaymoney3()!=null && rrvo.getPaymoney3()>0){//第三期大于零
    							crvo.setRewardmonth(rrvo.getPaymonth3());
    	    					crvo.setPaymoney(rrvo.getPaymoney3());
    						}else{//第三期等于零
    							crvo.setPaymoney(rrvo.getPaysum());
    						}
    					}
    				}    				 
    				crvo.setIsflag((short)1);
					crvo.setSystemflag((short)2);					
					crvo.setOprcode(user.getOpercode());
					crvo.setOptime(new Date());
					crvo.setTaskid(new Long(this.datestamps));
    			}
    			String rewardtypename = (String)Code2NameConfiger.getName("REWARDTYPE", crvo.getRewardtype().toString(), user.getCityid());
    			//String rewardtypename = ChrewardtypeCacheUtil.getCityRewardname(user.getCityid(), crvo.getRewardtype().toString());
    			line = crvo.getWayid() + "|" + crvo.getOpnid() + "|" + rewardtypename + "|" + crvo.getMobile() + "|"
						+ crvo.getRewardmonth() + "|" + crvo.getOprtime() + "|" + crvo.getBusivalue() + "|" + crvo.getPaysum() + "|";				
				
				resultVO.setInfo(line);
				resultVO.setOk(true);
				fos.write(resultVO.getInfo() + "\r\n");
				this.current++;
    		}catch(Exception ex){
    			ex.printStackTrace();
    			this.current++;
    			line = "   " + line + "    错误信息:" + ex.getMessage();
				resultVO.setInfo(line);
				resultVO.setOk(false);
				fos.write(resultVO.getInfo() + "\r\n");
    		}
    	}
    	
    	//处理每一条待拆分的记录
    	private void doDealMultipays()throws Exception{
			String line = "";
			ResultVO resultVO = new ResultVO();
			String rewardtypename = "";
			Iterator<RewardrecordVO> iter = this.multipays.iterator();
			while (iter.hasNext()) {
				RewardrecordVO rrvo = iter.next();
				iter.remove();
				CityrecordVO crvo2 = new CityrecordVO();
				BeanUtils.copyProperties(crvo2, rrvo);
				crvo2.setPaymoney(0.0);
				CityrecordVO crvo3 = new CityrecordVO();
				BeanUtils.copyProperties(crvo3, rrvo);	
				crvo3.setPaymoney(0.0);
				if(rrvo.getPaymoney1()!=null && rrvo.getPaymoney1()>0){//第一期大于零					
					if(rrvo.getPaymoney2()!=null && rrvo.getPaymoney2()>0){//第二期大于零
						if(rrvo.getPaymoney3()!=null && rrvo.getPaymoney3()>0){//第三期大于零    							
							crvo2.setRewardmonth(rrvo.getPaymonth2());
							crvo2.setPaymoney(rrvo.getPaymoney2());
							crvo3.setRewardmonth(rrvo.getPaymonth3());
							crvo3.setPaymoney(rrvo.getPaymoney3());
						}else{//第三期等于零    							
							crvo2.setRewardmonth(rrvo.getPaymonth2());
							crvo2.setPaymoney(rrvo.getPaymoney2());
						}
					}else{//第二期等于零
						if(rrvo.getPaymoney3()!=null && rrvo.getPaymoney3()>0){//第三期大于零    							
							crvo3.setRewardmonth(rrvo.getPaymonth3());
							crvo3.setPaymoney(rrvo.getPaymoney3());
						}
					}
				}else{//第一期等于零
					if(rrvo.getPaymoney2()!=null && rrvo.getPaymoney2()>0){//第二期大于零						
						if(rrvo.getPaymoney3()!=null && rrvo.getPaymoney3()>0){//第三期大于零    							
							crvo3.setRewardmonth(rrvo.getPaymonth3());
							crvo3.setPaymoney(rrvo.getPaymoney3());
						}
					}
				}
				if(crvo2.getPaymoney()>0){
					try {// 第二条记录					
						crvo2.setIsflag((short) 1);
						crvo2.setSystemflag((short) 2);					
						crvo2.setPaysum(0.0);					
						crvo2.setOprcode(user.getOpercode());
						crvo2.setOptime(new Date());
						crvo2.setTaskid(new Long(this.datestamps));
						crvo2.setRewardlistid(null);//rrvo.getRewardlistid() 避免由于保存后与CH_PW_REWARDRECORD表ID冲突导致分页查询、保存出错
						this.crcontrol.doCreate(crvo2, user);
						rewardtypename = (String)Code2NameConfiger.getName("REWARDTYPE", crvo2.getRewardtype().toString(), user.getCityid());
						//rewardtypename = ChrewardtypeCacheUtil.getCityRewardname(user.getCityid(), crvo2.getRewardtype().toString());
						line = crvo2.getWayid() + "|" + crvo2.getOpnid() + "|" + rewardtypename + "|" + crvo2.getMobile() + "|"
								+ crvo2.getRewardmonth() + "|" + crvo2.getOprtime() + "|" + crvo2.getBusivalue() + "|" + crvo2.getPaysum() + "|";

						resultVO.setInfo(line);
						resultVO.setOk(true);
						fosMulti.write(resultVO.getInfo() + "处理成功的 \r\n");
						this.current++;
					} catch (Exception ex) {
						ex.printStackTrace();
						this.current++;
						line = "   " + line + "    错误信息:" + ex.getMessage();
						resultVO.setInfo(line);
						resultVO.setOk(false);
						fosMulti.write(resultVO.getInfo() + "\r\n");
					}
				}
				if(crvo3.getPaymoney()>0){
					try {						
						crvo3.setIsflag((short) 1);
						crvo3.setSystemflag((short) 2);
						crvo3.setPaysum(0.0);
						crvo3.setOprcode(user.getOpercode());
						crvo3.setOptime(new Date());
						crvo3.setTaskid(new Long(this.datestamps));
						crvo3.setRewardlistid(null);//rrvo.getRewardlistid() 避免由于保存后与CH_PW_REWARDRECORD表ID冲突导致分页查询、保存出错
						this.crcontrol.doCreate(crvo3, user);
						rewardtypename = (String)Code2NameConfiger.getName("REWARDTYPE", crvo3.getRewardtype().toString(), user.getCityid());
						//rewardtypename = ChrewardtypeCacheUtil.getCityRewardname(user.getCityid(), crvo3.getRewardtype().toString());
						line = crvo3.getWayid() + "|" + crvo3.getOpnid() + "|" + rewardtypename + "|" + crvo3.getMobile()
								+ "|" + crvo3.getRewardmonth() + "|" + crvo3.getOprtime() + "|" + crvo3.getBusivalue() + "|" + crvo3.getPaysum() + "|";

						resultVO.setInfo(line);
						resultVO.setOk(true);
						fosMulti.write(resultVO.getInfo() + "处理成功的\r\n");
						this.current++;
					} catch (Exception ex) {
						ex.printStackTrace();
						this.current++;
						line = "   " + line + "    错误信息:" + ex.getMessage();
						resultVO.setInfo(line);
						resultVO.setOk(false);
						fosMulti.write(resultVO.getInfo() + "\r\n");
					}
				}
				this.calPersent();
			}       				
    	}
    	
    	//统计要处理的数据总量
    	private int doQueryCount() throws Exception{ 
    		DataPackage dp = new DataPackage();
    		int result = -1;
    		switch(this.dealtype){
    		case 0:
    			dp = crcontrol.doQueryMainopn(params, user, 2);
    			break;
    		case 1:
    			dp = crcontrol.doQuerySpecialopn07(params, user, 2);
    			break;
    		case 2:
    			dp = crcontrol.doQuerySpecialopn0403(params, user, 2);
    			break;
    		}
    		result = dp.getRowCount();
    		return result;
    	}
    	
    	//获取数据
    	private DataPackage doQueryData() throws Exception{    		
    		DataPackage dp = new DataPackage();
    		switch(this.dealtype){
    		case 0:
    			dp = crcontrol.doQueryMainopn(params, user, 1);
    			break;
    		case 1:
    			dp = crcontrol.doQuerySpecialopn07(params, user, 1);
    			break;
    		case 2:
    			dp = crcontrol.doQuerySpecialopn0403(params, user, 1);
    			break;
    		}
    		return dp;
    	}
    	
    	//批量发布数据，执行INSERT语句实现
    	private String doInsert(){ //throws Exception
    		String result = "";
    		int totalpage = Integer.parseInt(params.get_pageno());//总页数
    		int pages = 10;//一次处理10页
    		int batchsize = Integer.parseInt(params.get_pagesize()) * pages;//一次处理10页
    		System.out.println("总页数"+totalpage+"，每次处理"+pages+"页，每批次处理"+batchsize+"条数据");
    		log.info("总页数"+totalpage+"，每次处理"+pages+"页，每批次处理"+batchsize+"条数据");
    		int succ = 0;//处理数量
    		int num = 0;
    		while(totalpage>0){
    			try{
    				switch(this.dealtype){
    	    		case 0:    			
    	    			num = crcontrol.doSaveMainopn(params, user, datestamps,batchsize);			
    	    			break;
    	    		case 1:
    	    			num = crcontrol.doSaveSpecialopn07(params, user, datestamps, batchsize);
    	    			break;
    	    		case 2:
    	    			num = crcontrol.doSaveSpecialopn0403(params, user, datestamps, batchsize);
    	    			break;
    	    		}
    			}catch(Exception ex){
    				log.info("批量插入数据失败一次，检查能否后台干预");
    				num=0;
    			}
    			succ = succ + num;
    			totalpage=totalpage-pages;//一次处理10页
    		}
    		result = result+"总计处理成功"+succ+"条";
    		return result;
    	}
    }
    
    //创新联盟酬金同步
    private void doBbcrewardisue(CityrecordListVO params){
    	String fileInPath = filename;
		this.resultFile = fileInPath;		
		BufferedWriter fos;	
		try {
			fos = this.getBufferedWriter(fileInPath);
			// 文件处理开始,写标题等
			fos.write("渠道编码|业务编码|酬金期数|手机、充值卡号码或IMEI号|结算月份|业务发生时间|业务量或业务发生金额|应发酬金合计|备注\r\n");			
			setRunning(true);
			//设置分页查询的页大小
			params.set_pagesize(this.getPagesize());
			//获取总记录数
			int total = this.computeTotal(params);
			if(total == -1){
				throw new Exception("获取总记录数异常");				
			}
			
			CityrecordControl crcontrol = (CityrecordControl) ControlFactory.build(CityrecordControlBean.class);
			int totalpage = (total + Integer.parseInt(params.get_pagesize()) - 1) / Integer.parseInt(params.get_pagesize());
			DataPackage dp = new DataPackage();
			RewarduploadControl rpcontrol = (RewarduploadControl) ControlFactory.build(RewarduploadControlBean.class);
			//String datestamp = ((Integer) Math.round(new Date().getTime() / 1000)).toString();
			Long datestamp = rpcontrol.doGetSequence(user);
			while (isRunning() && !isCompleted()) {
				if (totalpage == 0) {// 处理没有结果集的情况
					countrecord = 1;
					currentrecord = 1;
					isComplete = true;
					fos.write("处理完成  \r\n");
				} else {
					countrecord = total;
					for (int i = totalpage; i >= 1; i--) {//此处必须有最后一页向前处理，否则报错
						params.set_pageno("" + i);
						dp = crcontrol.doThreeQuery4Thread(params, user);
						Iterator<CityrecordVO> it = dp.getDatas().iterator();
						String line = "";
						ResultVO resultVO = new ResultVO();
						while (it.hasNext()) {
							CityrecordVO vo = it.next();
							try {
								//ChrewardtypeCacheUtil用于翻译
								//String rewardtypename = ChrewardtypeCacheUtil.getCityRewardname(user.getCityid(), vo.getRewardtype().toString());
								String rewardtypename = (String)Code2NameConfiger.getName("REWARDTYPE", vo.getRewardtype().toString(), user.getCityid());
								line = vo.getWayid() + "|" + vo.getOpnid() + "|" + rewardtypename + "|" + vo.getMobile() + "|"
										+ vo.getRewardmonth() + "|" + vo.getOprtime() + "|" + vo.getBusivalue() + "|" + vo.getPaysum() + "|";

								vo.setIsflag(new Short("1"));
								vo.setOprcode(user.getOpercode());
								vo.setOptime(new Date());
								vo.setTaskid(new Long(datestamp));
								crcontrol.doCreate(vo, user);								
								
								resultVO.setInfo(line);
								resultVO.setOk(true);
								fos.write(resultVO.getInfo() + "处理成功的 \r\n");
								currentrecord++;
							} catch (Exception e) {								
								currentrecord++;
								line = "   " + line + "    错误信息:" + e.getMessage();
								resultVO.setInfo(line);
								resultVO.setOk(false);
								fos.write(resultVO.getInfo() + "\r\n");
							}
						}
					}
					fos.write("---------------处理数据量"+total+"条，任务号"+datestamp+"\r\n");
					if(this.closeFileWriter(fos)){//本地文件流关闭成功，同步FTP文件
						this.doFTP(fileInPath);
					}
					
					isComplete = true;
				}
			}
				
			setRunning(false);
		}catch(Exception ex){
			ex.printStackTrace();
			isComplete = true;
			setRunning(false);
		}finally{			
			this.setThreadDictparam(params, "0");//将状态改为开启，以允许其它发布操作
		}
    }
    
    /**
     * 获取总记录数
     * @param params 
     * @return -1表示失败，其他成功
     */
    private int computeTotal(CityrecordListVO params) {
    	DataPackage dptemp = new DataPackage();
    	try{
    		if ("1".equals(params.get_ne_isflag()) && "2".equals(params.get_ne_systemflag())) {
    			// 如果发布标识ISFLAG=2待确认且计酬系统SYSTEMFLAG=2则查询社会渠道酬金明细记录表
    			RewardrecordControl rrcontrol = (RewardrecordControl) ControlFactory.build(RewardrecordControlBean.class);
    			RewardrecordListVO rrlistvo = new RewardrecordListVO();
    			BeanUtils.copyProperties(rrlistvo, params);
    			dptemp = rrcontrol.doQuery4ThreadTotal(rrlistvo, user);
    			return dptemp.getRowCount();//* 3
    		} else if ("1".equals(params.get_ne_isflag()) && "3".equals(params.get_ne_systemflag())) {
    			BbcRewardrecord2Control rrcontrol = (BbcRewardrecord2Control) ControlFactory.build(BbcRewardrecord2ControlBean.class);
    			BbcRewardrecord2ListVO rrlistvo = new BbcRewardrecord2ListVO();
    			BeanUtils.copyProperties(rrlistvo, params);
    			dptemp = rrcontrol.doQuery4ThreadTotal(rrlistvo, user);
    			return dptemp.getRowCount();
    		} else{
    			return 1;
    		}
    	}catch(Exception ex){
    		ex.printStackTrace();
    		System.out.println("获取总记录数异常");
    		return -1;
    	}
    }
   
    /**
     * 关闭文件流，将内存中的信息写到磁盘文件
     * @param fos
     * @return
     */
    private boolean closeFileWriter(BufferedWriter fos){
    	try {
			fos.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//如果发生异常，则不能写FTP文件
			System.out.println("写本地文件，关闭文件流失败，不能做FTP同步");
			return false;
		}
    }
    
    /**
     * 将处理结果文件FTP到文件服务器
     * @param fileInPath 本地文件全路径名
     */
    private void doFTP(String fileInPath){
    	FtpInfo ftpInfo = null;
		FtpAccess ftp;
		try {
			System.out.println("----------------------------写FTP文件开始");
			ftpInfo = ResPubUtil.getFtpInfo(user);

			ftp = new FtpAccess(ftpInfo);
			ftp.ftp.setFileType(ftp.ftp.BINARY_FILE_TYPE);
			//ftp.ftp.setFileTransferMode(ftp.ftp.BLOCK_TRANSFER_MODE);
			String localFileName = fileInPath;

			// 获得全省各个地市的存放的公共目录，eg"/appdatas/"
			ChAdtDictparamDelegate de = new ChAdtDictparamDelegate();
			ChAdtDictparamListVO chadtlistvo = new ChAdtDictparamListVO();
			chadtlistvo.set_se_dkey("thread_result_path");
			DataPackage dp = de.doQuery(chadtlistvo, user);
			String location = "";
			if (dp.getDatas() != null && dp.getDatas().size() > 0) {
				Iterator<ChAdtDictparamVO> it = dp.getDatas().iterator();if (it.hasNext()) {
					location = it.next().getDvalue();
				}
			} else {
				throw new Exception("没有配置结果文件存放的目录，请联系cmos维护人员配置一下。");
			}

			String ftppath = location + SessionFactoryRouter.conversionCityid(user.getCityid()).toLowerCase() + "/";
			String remotePath = ftppath;
			boolean genFileName = false;
			String succ = ftp.uploadFile(localFileName, remotePath,genFileName);
			System.out.println("----------------------------写FTP文件完成");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("----------------------------写FTP文件异常");
			e.printStackTrace();
		}
    }
    
    /**
     * 设置酬金发布系统参数
     * flag 1表示关闭，不允许其他发布操作；0表示开启，允许其他发布操作
     */
    private boolean setThreadDictparam(CityrecordListVO params, String flag){
    	// 防止再起一个thread，设置一个参数（CH_ADT_DICTPARAM），
		// thread_ch_pw_Rewardrecord
		// ,thread_ch_bbc_Rewardrecord,dvalue的值为1就不让在进入了
    	if(flag==null || ( !"1".equals(flag) && !"0".equals(flag) )){
    		System.out.println(Cityrecord4IssueTaskBean.class.getName()
    				+".setThreadDictparam()参数String flag必须为1表示关闭，不允许其他发布操作；0表示开启，允许其他发布操作");
    		return false;
    	}
		try{
			ChAdtDictparamDelegate de = new ChAdtDictparamDelegate();
			ChAdtDictparamListVO listvo = new ChAdtDictparamListVO();
			ChAdtDictparamVO vo = new ChAdtDictparamVO();
			if ("2".equals(params.get_ne_systemflag())) {
				listvo.set_se_dkey("thread_ch_pw_rewardrecord");
				DataPackage dp = de.doQuery(listvo, user);
				Iterator<ChAdtDictparamVO> it = dp.getDatas().iterator();
				if (it.hasNext()) {
					vo = it.next();
					vo.setDvalue(flag);
					de.doUpdate(vo, user);
				}
			}
			if ("3".equals(params.get_ne_systemflag())) {
				listvo.set_se_dkey("thread_ch_bbc_rewardrecord");
				DataPackage dp = de.doQuery(listvo, user);
				Iterator<ChAdtDictparamVO> it = dp.getDatas().iterator();
				if (it.hasNext()) {
					vo = it.next();
					vo.setDvalue(flag);
					de.doUpdate(vo, user);
				}
			}
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }
    
    /**
     * 获取写文件的对象
     * @param fileInPath
     * @return
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    private BufferedWriter getBufferedWriter(String fileInPath) throws FileNotFoundException,UnsupportedEncodingException{
    	FileOutputStream fileOutputStream = new FileOutputStream(fileInPath);
		OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, "gbk");
		BufferedWriter fos = new BufferedWriter(writer);		
		return fos;
    }
    
    /**
     * 获取页大小
     * 查询系统参数，如果存在取其值；否则设置为9999
     * 注：JOP的DAO层封装一次值允许查询一万条
     * @return
     */
    private String getPagesize(){
    	try{
    		PwDictparamDelegate dictparamdelegate = new PwDictparamDelegate();
    		PwDictparamListVO dictparamlistVO = new PwDictparamListVO();
    		dictparamlistVO.set_ne_state("0");
    		dictparamlistVO.set_se_dkey("UPSIZE");
    		DataPackage dictparamdp = dictparamdelegate.doQuery(dictparamlistVO, user);
    		Iterator<PwDictparamVO> dictparamVit = dictparamdp.getDatas().iterator();
    		if (dictparamVit.hasNext()) {
    			PwDictparamVO vo = dictparamVit.next();
    			return vo.getDvalue();
    		}    		
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}    	
    	return "9999";
    }
    
    /**
     * 根据对象属性构建查询参数ListVO对象
     * @return
     */
    private CityrecordListVO buildListVO(){
    	CityrecordListVO params = new CityrecordListVO();
 		params.set_se_rewardmonth(rewardmonth);
		params.set_ne_isflag(isflag);
		params.set_ne_systemflag(systemflag);
		// 可选参数
		if (null != wayid) {
			params.set_se_wayid(wayid);
		}
		if (null != chainhead) {
			params.set_se_chainhead(chainhead);
		}
//2012-08-28 此2个界面查询条件已删除
//		if (null != opnid) {
//			params.set_se_opnid(opnid);
//		}
//		if (null != approveid) {
//			params.set_se_approveid(approveid);
//		}
		if (null != countyid) {
			params.set_se_countyid(countyid);
		}
		if (null != taskid) {
			params.set_ne_taskid(taskid);
		}
		if(null != sin_opnid){
			params.set_sin_opnid(sin_opnid);
		}
		if(null != mobile){
			params.set_se_mobile(mobile);
		}
    	
    	return params;
    }
    
	protected void process() {
		try {
			CityrecordListVO params = new CityrecordListVO();
			CityrecordControl crcontrol = (CityrecordControl) ControlFactory.build(CityrecordControlBean.class);
			DataPackage dp = crcontrol.doThreeQuery(params, user);

			Iterator<CityrecordVO> it = dp.getDatas().iterator();
			while (it.hasNext()) {
				CityrecordVO vo = it.next();
				if (vo.getIsflag() != 2) {
					continue;
				} else {
					CityrecordListVO listvo = new CityrecordListVO();
					if (StringUtils.isNotBlank(vo.getMobile())) {
						// 如果MOBILE不为空的计件类业务,根据:用业务编码+业务发生时间+酬金期数+业务发生号码或IMEI号+结算月份
						listvo.set_se_opnid(vo.getOpnid());
						listvo.set_de_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(), "yyyy-MM-dd HH:mm:ss"));
						listvo.set_ne_rewardtype(vo.getRewardtype().toString());
						listvo.set_se_mobile(vo.getMobile());
						listvo.set_se_rewardmonth(vo.getRewardmonth());
						// listvo.set_ne_isflag("1");//已发布
						String sql = " isflag in (0,1) ";
						listvo.set_sql_isflag(sql);
						DataPackage dp2 = crcontrol.doQuery(listvo, user);
						if (null != dp2 && dp2.getDatas().size() > 0) {
							throw new BusinessException("", "市公司已上传相同的酬金结果");
						}
					} else if (StringUtils.isBlank(vo.getMobile())
							&& ("0701010100004".equals(vo.getOpnid())
									|| "0701010100003".equals(vo.getOpnid()) 
									|| "0701010100002".equals(vo.getOpnid()))) {
						// 如果MOBILE为空按非计件类业务,则根据:网点编码+业务编码+酬期数+业务发生时间+结算月份
						listvo.set_se_wayid(vo.getWayid());
						listvo.set_se_opnid(vo.getOpnid());
						listvo.set_de_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(), "yyyy-MM-dd HH:mm:ss"));
						listvo.set_ne_rewardtype(vo.getRewardtype().toString());
						listvo.set_se_rewardmonth(vo.getRewardmonth());
						// listvo.set_ne_isflag("1");//已发布
						String sql = " isflag in (0,1) ";
						listvo.set_sql_isflag(sql);
						DataPackage dp2 = crcontrol.doQuery(listvo, user);
						if (null != dp2 && dp2.getDatas().size() > 0) {
							throw new BusinessException("", "市公司已上传相同的酬金结果");
						}
					}
					vo.setIsflag(new Short("1"));
					vo.setOprcode(user.getOpercode());
					vo.setOptime(new Date());
					if (null != vo.getRecordid()) {
						crcontrol.doUpdate(vo, user);
					} else {
						crcontrol.doCreate(vo, user);
					}
				}
				// 当前处理数++
				currentrecord++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String getSystemflag() {
		return systemflag;
	}

	public void setSystemflag(String systemflag) {
		this.systemflag = systemflag;
	}

	public String getRewardmonth() {
		return rewardmonth;
	}

	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}

	public String getIsflag() {
		return isflag;
	}

	public void setIsflag(String isflag) {
		this.isflag = isflag;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getChainhead() {
		return chainhead;
	}

	public void setChainhead(String chainhead) {
		this.chainhead = chainhead;
	}

	public String getOpnid() {
		return opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public String getApproveid() {
		return approveid;
	}

	public void setApproveid(String approveid) {
		this.approveid = approveid;
	}

	public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}
    
	public String getSin_opnid() {
		return sin_opnid;
	}

	public void setSin_opnid(String sin_opnid) {
		this.sin_opnid = sin_opnid;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
