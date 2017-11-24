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
	//��ѡ����
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
	
	protected boolean start_end; // ������������־
	
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
   
    //�����ϴ���𷢲�
    private void doOnlyissue(CityrecordListVO params){
    	String fileInPath = filename;
		this.resultFile = fileInPath;
    	BufferedWriter fos;
    	try{
    		fos = this.getBufferedWriter(fileInPath);
    		// �ļ�����ʼ,д�����
			fos.write("��������|ҵ�����|�������|�ֻ�����ֵ�������IMEI��|�����·�|ҵ����ʱ��|ҵ������ҵ�������|Ӧ�����ϼ�|��ע \r\n");			
			setRunning(true);
			this.countrecord = 1;
			
    		CityrecordControl crcontrol = (CityrecordControl) ControlFactory.build(CityrecordControlBean.class);
    		// ģ���������һ��100%��һ��sql��update���м�¼��ֻ�����ch_adt_cityrecord
			crcontrol.doOnlyissue(params, user);
			currentrecord = 1;
			isComplete = true;
			fos.write(" �������  \r\n");
			
			setRunning(false);
			if(this.closeFileWriter(fos)){//�����ļ����رճɹ���ͬ��FTP�ļ�
				this.doFTP(fileInPath);
			}			
    	}catch(Exception ex){
    		setRunning(false);
			isComplete = true;
			ex.printStackTrace();
    	}finally{
    		this.setThreadDictparam(params, "0");//��״̬��Ϊ������������������������
    	}    	
    }
    
    //����������ͬ��
    private void doPwrewardissue(CityrecordListVO params){
    	try{
    		long starttime = System.currentTimeMillis();
    	    setRunning(true);
    		isComplete = false;
    		// ���÷�ҳ��ѯ��ҳ��С
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
    				System.out.println("���߳������������ʼд�ļ�");
    				log.info("���߳������������ʼд�ļ�");
    				this.currentrecord = 99;//��ʱ�ļ���δд�꣬1��Ϊ����дZIP��FTP�ļ�Ԥ����ʱ��				
    				try{// �ļ�ѹ��
    					String errmsg = this.doZip(this.resultFile, filenames);
    					if(errmsg == null){
    						this.doFTP(this.resultFile);// FTP
    					}else{	
    						System.out.println("ѹ���ļ�ʱ����"+errmsg);
    						log.info("ѹ���ļ�ʱ����"+errmsg);
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
    		this.setThreadDictparam(params, "0");//��״̬��Ϊ������������������������	
    		long intervaltime = System.currentTimeMillis() - starttime;
    		System.out.println("����ʱ��:"+intervaltime);
    		log.info("����ʱ��:"+intervaltime);
		}catch(Exception ex){
			ex.printStackTrace();
		}    	
    }
    
    //дZIPѹ���ļ�
    private String doZip(String targetname, String[] filenames)throws Exception{
    	String errmsg = null;
    	System.out.println("׼������ѹ���ļ���" + targetname);
    	log.info("׼������ѹ���ļ���" + targetname);
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
				errmsg = "�ļ�"+filename+"�����ڣ�";
				continue;
			}
			orgin = new BufferedInputStream(new FileInputStream(file));
			System.out.println("׼��ѹ���ļ���" + filename);
			log.info("׼��ѹ���ļ���" + filename);
			ZipEntry entry = new ZipEntry(file.getName());
			zipout.putNextEntry(entry);
			while ((readByte = orgin.read(data)) > 0) {
				zipout.write(data, 0, readByte);
			}
			orgin.close();
			zipout.closeEntry();
			System.out.println("���ѹ���ļ���" + filename);
			log.info("���ѹ���ļ���" + filename);
		}
		zipout.close();
		System.out.println("����ѹ���ļ���ɣ�" + targetname);
		log.info("����ѹ���ļ���ɣ�" + targetname);
		return errmsg;
    }
    
    //�߳��࣬ʵ������������Ķ��߳�ͬ��
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
    				// �ļ�����ʼ,д�����
        			fos.write("��������|ҵ�����|�������|�ֻ�����ֵ�������IMEI��|�����·�|ҵ����ʱ��|ҵ������ҵ�������|Ӧ�����ϼ�\r\n");	
    			}
        		if(this.dealtype!=SPECIAL_0403){
        			fosMulti = getBufferedWriter(this.pwfilename_multi);
        			// �ļ�����ʼ,д�����
        			fosMulti.write("��������|ҵ�����|�������|�ֻ�����ֵ�������IMEI��|�����·�|ҵ����ʱ��|ҵ������ҵ�������|Ӧ�����ϼ�|��ע\r\n");
        		}
				if (total <= 0) {// ����û�н���������
					fos.write("��������Ҫͬ�����������\r\n");
					fos.close();
					if(this.dealtype!=SPECIAL_0403){
						fosMulti.write("��������Ҫͬ�����������\r\n");
						fosMulti.close();
					}					
					this.current = 1;
					this.totalcount = 1;
					finished = true;
					this.calPersent();
				} else {
					int totalpage = (total + Integer.parseInt(params.get_pagesize()) - 1) / Integer.parseInt(params.get_pagesize());
					for (int i = totalpage; i >= 1; i--) {//�˴����������һҳ��ǰ����
						params.set_pageno("" + i);
						dp = this.doQueryData();
						if (dp.getDatas().size() > 0) {
							this.queue.add(dp.getDatas());
							this.setChanged();
							this.notifyObservers();//�˷����ᵼ��update()��������д�ļ�������ʵ��д�ļ��Ͳ�ѯ���ݲ�ѯ����
						}
					}
					
					if( !this.queue.isEmpty()){
						this.notifyObservers();
					}
					
					String insertInfo = null;
//					try{
						params.set_pageno(""+totalpage);//���ڸ���ÿҳ��Сȷ���ܹ��ж�����������Ҫ����
						insertInfo = this.doInsert();
						insertInfo = "---------------����ͬ�����ݴ�����������������"+total+"���������"+datestamps+","+insertInfo;
						System.out.println(insertInfo);
						log.info(insertInfo);
						fos.write(insertInfo+"\r\n");												
//					}catch(Exception ex){
//						insertInfo = "---------------����ͬ�������쳣���������ݾ�����ʧ�ܣ�����������"+total+"���������"+datestamps;
//						System.out.println(insertInfo);
//						fos.write(insertInfo+"\r\n");
//						ex.printStackTrace();
//					}
					
					//����ʣ�����ּ�¼						
					if (this.multipays.size() > 0) {
						this.doDealMultipays();							
					}
					if(this.dealtype!=SPECIAL_0403){
						fosMulti.write("---------------���ڷ��ų��ͬ��������ϣ������"+datestamps+"\r\n");
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
    	
    	//���㴦�����
    	private void calPersent(){
    		switch(this.dealtype){
    		case 0:
    			if(finished){
        			pwmainopnPersent = 80;//����ռ�Ȱٷ�֮80
        		}else{
        			pwmainopnPersent  = this.current*80/this.totalcount;
        		}
    			break;
    		case 1:
    			if(finished){
        			pwopn07Persent = 10;//07��ҵ��ռ�Ȱٷ�֮10
        		}else{
        			pwopn07Persent  = this.current*10/this.totalcount;
        		}
    			break;
    		case 2:
    			if(finished){
        			pwopn0403Persent = 10;//0403��ҵ��ռ�Ȱٷ�֮10
        		}else{
        			pwopn0403Persent  = this.current*10/this.totalcount;
        		}
    			break;
    		}
    	}
    	
    	//����д�ļ���ʵ��д�ļ��Ͳ�ѯ���ݲ�ѯ����
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
    				//Ϊ�������ڱ������CH_PW_REWARDRECORD��ID��ͻ���·�ҳ��ѯ�����������Ҫ��rewardlistid��Ϊ��
    				this.doDealMultipays();
    			}
    		}catch(Exception ex){
    			ex.printStackTrace();
    		}
    	}
    	
    	//дÿһ����¼
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
    				if(rrvo.getPaymoney1()!=null && rrvo.getPaymoney1()>0){//��һ�ڴ�����
    					crvo.setRewardmonth(rrvo.getPaymonth1());
    					crvo.setPaymoney(rrvo.getPaymoney1());
    					if(rrvo.getPaymoney2()!=null && rrvo.getPaymoney2()>0){//�ڶ��ڴ�����
    						if(rrvo.getPaymoney3()!=null && rrvo.getPaymoney3()>0){//�����ڴ�����    							
    	    					this.multipays.add(rrvo);
    	    					this.totalcount=this.totalcount+2;//�ٲ�ֳ�2��
    						}else{//�����ڵ�����    							
    	    					this.multipays.add(rrvo);
    	    					this.totalcount=this.totalcount+1;//�ٲ�ֳ�1��
    						}
    					}else{//�ڶ��ڵ�����
    						if(rrvo.getPaymoney3()!=null && rrvo.getPaymoney3()>0){//�����ڴ�����    							
    	    					this.multipays.add(rrvo);
    	    					this.totalcount=this.totalcount+1;//�ٲ�ֳ�1��
    						}else{//�����ڵ�����    							
    						}
    					}
    				}else{//��һ�ڵ�����
    					if(rrvo.getPaymoney2()!=null && rrvo.getPaymoney2()>0){//�ڶ��ڴ�����
    						crvo.setRewardmonth(rrvo.getPaymonth2());
	    					crvo.setPaymoney(rrvo.getPaymoney2());
    						if(rrvo.getPaymoney3()!=null && rrvo.getPaymoney3()>0){//�����ڴ�����    							
    	    					this.multipays.add(rrvo);
    	    					this.totalcount=this.totalcount+1;//�ٲ�ֳ�1��
    						}else{//�����ڵ�����    							
    						}
    					}else{//�ڶ��ڵ�����
    						if(rrvo.getPaymoney3()!=null && rrvo.getPaymoney3()>0){//�����ڴ�����
    							crvo.setRewardmonth(rrvo.getPaymonth3());
    	    					crvo.setPaymoney(rrvo.getPaymoney3());
    						}else{//�����ڵ�����
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
    			line = "   " + line + "    ������Ϣ:" + ex.getMessage();
				resultVO.setInfo(line);
				resultVO.setOk(false);
				fos.write(resultVO.getInfo() + "\r\n");
    		}
    	}
    	
    	//����ÿһ������ֵļ�¼
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
				if(rrvo.getPaymoney1()!=null && rrvo.getPaymoney1()>0){//��һ�ڴ�����					
					if(rrvo.getPaymoney2()!=null && rrvo.getPaymoney2()>0){//�ڶ��ڴ�����
						if(rrvo.getPaymoney3()!=null && rrvo.getPaymoney3()>0){//�����ڴ�����    							
							crvo2.setRewardmonth(rrvo.getPaymonth2());
							crvo2.setPaymoney(rrvo.getPaymoney2());
							crvo3.setRewardmonth(rrvo.getPaymonth3());
							crvo3.setPaymoney(rrvo.getPaymoney3());
						}else{//�����ڵ�����    							
							crvo2.setRewardmonth(rrvo.getPaymonth2());
							crvo2.setPaymoney(rrvo.getPaymoney2());
						}
					}else{//�ڶ��ڵ�����
						if(rrvo.getPaymoney3()!=null && rrvo.getPaymoney3()>0){//�����ڴ�����    							
							crvo3.setRewardmonth(rrvo.getPaymonth3());
							crvo3.setPaymoney(rrvo.getPaymoney3());
						}
					}
				}else{//��һ�ڵ�����
					if(rrvo.getPaymoney2()!=null && rrvo.getPaymoney2()>0){//�ڶ��ڴ�����						
						if(rrvo.getPaymoney3()!=null && rrvo.getPaymoney3()>0){//�����ڴ�����    							
							crvo3.setRewardmonth(rrvo.getPaymonth3());
							crvo3.setPaymoney(rrvo.getPaymoney3());
						}
					}
				}
				if(crvo2.getPaymoney()>0){
					try {// �ڶ�����¼					
						crvo2.setIsflag((short) 1);
						crvo2.setSystemflag((short) 2);					
						crvo2.setPaysum(0.0);					
						crvo2.setOprcode(user.getOpercode());
						crvo2.setOptime(new Date());
						crvo2.setTaskid(new Long(this.datestamps));
						crvo2.setRewardlistid(null);//rrvo.getRewardlistid() �������ڱ������CH_PW_REWARDRECORD��ID��ͻ���·�ҳ��ѯ���������
						this.crcontrol.doCreate(crvo2, user);
						rewardtypename = (String)Code2NameConfiger.getName("REWARDTYPE", crvo2.getRewardtype().toString(), user.getCityid());
						//rewardtypename = ChrewardtypeCacheUtil.getCityRewardname(user.getCityid(), crvo2.getRewardtype().toString());
						line = crvo2.getWayid() + "|" + crvo2.getOpnid() + "|" + rewardtypename + "|" + crvo2.getMobile() + "|"
								+ crvo2.getRewardmonth() + "|" + crvo2.getOprtime() + "|" + crvo2.getBusivalue() + "|" + crvo2.getPaysum() + "|";

						resultVO.setInfo(line);
						resultVO.setOk(true);
						fosMulti.write(resultVO.getInfo() + "����ɹ��� \r\n");
						this.current++;
					} catch (Exception ex) {
						ex.printStackTrace();
						this.current++;
						line = "   " + line + "    ������Ϣ:" + ex.getMessage();
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
						crvo3.setRewardlistid(null);//rrvo.getRewardlistid() �������ڱ������CH_PW_REWARDRECORD��ID��ͻ���·�ҳ��ѯ���������
						this.crcontrol.doCreate(crvo3, user);
						rewardtypename = (String)Code2NameConfiger.getName("REWARDTYPE", crvo3.getRewardtype().toString(), user.getCityid());
						//rewardtypename = ChrewardtypeCacheUtil.getCityRewardname(user.getCityid(), crvo3.getRewardtype().toString());
						line = crvo3.getWayid() + "|" + crvo3.getOpnid() + "|" + rewardtypename + "|" + crvo3.getMobile()
								+ "|" + crvo3.getRewardmonth() + "|" + crvo3.getOprtime() + "|" + crvo3.getBusivalue() + "|" + crvo3.getPaysum() + "|";

						resultVO.setInfo(line);
						resultVO.setOk(true);
						fosMulti.write(resultVO.getInfo() + "����ɹ���\r\n");
						this.current++;
					} catch (Exception ex) {
						ex.printStackTrace();
						this.current++;
						line = "   " + line + "    ������Ϣ:" + ex.getMessage();
						resultVO.setInfo(line);
						resultVO.setOk(false);
						fosMulti.write(resultVO.getInfo() + "\r\n");
					}
				}
				this.calPersent();
			}       				
    	}
    	
    	//ͳ��Ҫ�������������
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
    	
    	//��ȡ����
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
    	
    	//�����������ݣ�ִ��INSERT���ʵ��
    	private String doInsert(){ //throws Exception
    		String result = "";
    		int totalpage = Integer.parseInt(params.get_pageno());//��ҳ��
    		int pages = 10;//һ�δ���10ҳ
    		int batchsize = Integer.parseInt(params.get_pagesize()) * pages;//һ�δ���10ҳ
    		System.out.println("��ҳ��"+totalpage+"��ÿ�δ���"+pages+"ҳ��ÿ���δ���"+batchsize+"������");
    		log.info("��ҳ��"+totalpage+"��ÿ�δ���"+pages+"ҳ��ÿ���δ���"+batchsize+"������");
    		int succ = 0;//��������
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
    				log.info("������������ʧ��һ�Σ�����ܷ��̨��Ԥ");
    				num=0;
    			}
    			succ = succ + num;
    			totalpage=totalpage-pages;//һ�δ���10ҳ
    		}
    		result = result+"�ܼƴ���ɹ�"+succ+"��";
    		return result;
    	}
    }
    
    //�������˳��ͬ��
    private void doBbcrewardisue(CityrecordListVO params){
    	String fileInPath = filename;
		this.resultFile = fileInPath;		
		BufferedWriter fos;	
		try {
			fos = this.getBufferedWriter(fileInPath);
			// �ļ�����ʼ,д�����
			fos.write("��������|ҵ�����|�������|�ֻ�����ֵ�������IMEI��|�����·�|ҵ����ʱ��|ҵ������ҵ�������|Ӧ�����ϼ�|��ע\r\n");			
			setRunning(true);
			//���÷�ҳ��ѯ��ҳ��С
			params.set_pagesize(this.getPagesize());
			//��ȡ�ܼ�¼��
			int total = this.computeTotal(params);
			if(total == -1){
				throw new Exception("��ȡ�ܼ�¼���쳣");				
			}
			
			CityrecordControl crcontrol = (CityrecordControl) ControlFactory.build(CityrecordControlBean.class);
			int totalpage = (total + Integer.parseInt(params.get_pagesize()) - 1) / Integer.parseInt(params.get_pagesize());
			DataPackage dp = new DataPackage();
			RewarduploadControl rpcontrol = (RewarduploadControl) ControlFactory.build(RewarduploadControlBean.class);
			//String datestamp = ((Integer) Math.round(new Date().getTime() / 1000)).toString();
			Long datestamp = rpcontrol.doGetSequence(user);
			while (isRunning() && !isCompleted()) {
				if (totalpage == 0) {// ����û�н���������
					countrecord = 1;
					currentrecord = 1;
					isComplete = true;
					fos.write("�������  \r\n");
				} else {
					countrecord = total;
					for (int i = totalpage; i >= 1; i--) {//�˴����������һҳ��ǰ�������򱨴�
						params.set_pageno("" + i);
						dp = crcontrol.doThreeQuery4Thread(params, user);
						Iterator<CityrecordVO> it = dp.getDatas().iterator();
						String line = "";
						ResultVO resultVO = new ResultVO();
						while (it.hasNext()) {
							CityrecordVO vo = it.next();
							try {
								//ChrewardtypeCacheUtil���ڷ���
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
								fos.write(resultVO.getInfo() + "����ɹ��� \r\n");
								currentrecord++;
							} catch (Exception e) {								
								currentrecord++;
								line = "   " + line + "    ������Ϣ:" + e.getMessage();
								resultVO.setInfo(line);
								resultVO.setOk(false);
								fos.write(resultVO.getInfo() + "\r\n");
							}
						}
					}
					fos.write("---------------����������"+total+"���������"+datestamp+"\r\n");
					if(this.closeFileWriter(fos)){//�����ļ����رճɹ���ͬ��FTP�ļ�
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
			this.setThreadDictparam(params, "0");//��״̬��Ϊ������������������������
		}
    }
    
    /**
     * ��ȡ�ܼ�¼��
     * @param params 
     * @return -1��ʾʧ�ܣ������ɹ�
     */
    private int computeTotal(CityrecordListVO params) {
    	DataPackage dptemp = new DataPackage();
    	try{
    		if ("1".equals(params.get_ne_isflag()) && "2".equals(params.get_ne_systemflag())) {
    			// ���������ʶISFLAG=2��ȷ���ҼƳ�ϵͳSYSTEMFLAG=2���ѯ������������ϸ��¼��
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
    		System.out.println("��ȡ�ܼ�¼���쳣");
    		return -1;
    	}
    }
   
    /**
     * �ر��ļ��������ڴ��е���Ϣд�������ļ�
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
			//��������쳣������дFTP�ļ�
			System.out.println("д�����ļ����ر��ļ���ʧ�ܣ�������FTPͬ��");
			return false;
		}
    }
    
    /**
     * ���������ļ�FTP���ļ�������
     * @param fileInPath �����ļ�ȫ·����
     */
    private void doFTP(String fileInPath){
    	FtpInfo ftpInfo = null;
		FtpAccess ftp;
		try {
			System.out.println("----------------------------дFTP�ļ���ʼ");
			ftpInfo = ResPubUtil.getFtpInfo(user);

			ftp = new FtpAccess(ftpInfo);
			ftp.ftp.setFileType(ftp.ftp.BINARY_FILE_TYPE);
			//ftp.ftp.setFileTransferMode(ftp.ftp.BLOCK_TRANSFER_MODE);
			String localFileName = fileInPath;

			// ���ȫʡ�������еĴ�ŵĹ���Ŀ¼��eg"/appdatas/"
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
				throw new Exception("û�����ý���ļ���ŵ�Ŀ¼������ϵcmosά����Ա����һ�¡�");
			}

			String ftppath = location + SessionFactoryRouter.conversionCityid(user.getCityid()).toLowerCase() + "/";
			String remotePath = ftppath;
			boolean genFileName = false;
			String succ = ftp.uploadFile(localFileName, remotePath,genFileName);
			System.out.println("----------------------------дFTP�ļ����");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("----------------------------дFTP�ļ��쳣");
			e.printStackTrace();
		}
    }
    
    /**
     * ���ó�𷢲�ϵͳ����
     * flag 1��ʾ�رգ���������������������0��ʾ����������������������
     */
    private boolean setThreadDictparam(CityrecordListVO params, String flag){
    	// ��ֹ����һ��thread������һ��������CH_ADT_DICTPARAM����
		// thread_ch_pw_Rewardrecord
		// ,thread_ch_bbc_Rewardrecord,dvalue��ֵΪ1�Ͳ����ڽ�����
    	if(flag==null || ( !"1".equals(flag) && !"0".equals(flag) )){
    		System.out.println(Cityrecord4IssueTaskBean.class.getName()
    				+".setThreadDictparam()����String flag����Ϊ1��ʾ�رգ���������������������0��ʾ����������������������");
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
     * ��ȡд�ļ��Ķ���
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
     * ��ȡҳ��С
     * ��ѯϵͳ�������������ȡ��ֵ����������Ϊ9999
     * ע��JOP��DAO���װһ��ֵ�����ѯһ����
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
     * ���ݶ������Թ�����ѯ����ListVO����
     * @return
     */
    private CityrecordListVO buildListVO(){
    	CityrecordListVO params = new CityrecordListVO();
 		params.set_se_rewardmonth(rewardmonth);
		params.set_ne_isflag(isflag);
		params.set_ne_systemflag(systemflag);
		// ��ѡ����
		if (null != wayid) {
			params.set_se_wayid(wayid);
		}
		if (null != chainhead) {
			params.set_se_chainhead(chainhead);
		}
//2012-08-28 ��2�������ѯ������ɾ��
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
						// ���MOBILE��Ϊ�յļƼ���ҵ��,����:��ҵ�����+ҵ����ʱ��+�������+ҵ���������IMEI��+�����·�
						listvo.set_se_opnid(vo.getOpnid());
						listvo.set_de_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(), "yyyy-MM-dd HH:mm:ss"));
						listvo.set_ne_rewardtype(vo.getRewardtype().toString());
						listvo.set_se_mobile(vo.getMobile());
						listvo.set_se_rewardmonth(vo.getRewardmonth());
						// listvo.set_ne_isflag("1");//�ѷ���
						String sql = " isflag in (0,1) ";
						listvo.set_sql_isflag(sql);
						DataPackage dp2 = crcontrol.doQuery(listvo, user);
						if (null != dp2 && dp2.getDatas().size() > 0) {
							throw new BusinessException("", "�й�˾���ϴ���ͬ�ĳ����");
						}
					} else if (StringUtils.isBlank(vo.getMobile())
							&& ("0701010100004".equals(vo.getOpnid())
									|| "0701010100003".equals(vo.getOpnid()) 
									|| "0701010100002".equals(vo.getOpnid()))) {
						// ���MOBILEΪ�հ��ǼƼ���ҵ��,�����:�������+ҵ�����+������+ҵ����ʱ��+�����·�
						listvo.set_se_wayid(vo.getWayid());
						listvo.set_se_opnid(vo.getOpnid());
						listvo.set_de_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(), "yyyy-MM-dd HH:mm:ss"));
						listvo.set_ne_rewardtype(vo.getRewardtype().toString());
						listvo.set_se_rewardmonth(vo.getRewardmonth());
						// listvo.set_ne_isflag("1");//�ѷ���
						String sql = " isflag in (0,1) ";
						listvo.set_sql_isflag(sql);
						DataPackage dp2 = crcontrol.doQuery(listvo, user);
						if (null != dp2 && dp2.getDatas().size() > 0) {
							throw new BusinessException("", "�й�˾���ϴ���ͬ�ĳ����");
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
				// ��ǰ������++
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
