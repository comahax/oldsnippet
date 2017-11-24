package com.gmcc.pboss.BgProcess.sales.waystockrecordissued;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.BgProcess.base.SecurityPass;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.sales.waystockrecord.WaystockrecordDBParam;
import com.gmcc.pboss.business.sales.waystockrecord.WaystockrecordVO;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.common.utils.tools.DateUtil.DateFormatType;
import com.gmcc.pboss.common.utils.tools.DateUtil.DateOperationType;
import com.gmcc.pboss.common.utils.tools.DateUtil.TimeFormatType;
import com.gmcc.pboss.control.sales.bgcontrol.salesstdWarn.SalesstdWarn;
import com.gmcc.pboss.control.sales.bgcontrol.salesstdWarn.SalesstdWarnBO;
import com.gmcc.pboss.control.sales.waystockrecord.Waystockrecord;
import com.gmcc.pboss.control.sales.waystockrecord.WaystockrecordBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * COMS�׿���������·��ӿں�̨����(WayStockRecordIssuedProcess)
 * @author yangdaren
 *
 */
public class WayStockRecordIssuedProcess extends BgBase{
	
	private static FTPClient ftpClient = new FTPClient();
    private static String encoding = System.getProperty("file.encoding");
    
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		
		WayStockRecordIssuedProcess pro = new WayStockRecordIssuedProcess();
		
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		String runtime = "";
		if (args.length > 1) {
			runtime=args[1];
		}
		
		// ��ȡUser
		User user = pro.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/waystockrecordissued/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		pro.setMyProfilePath("/WayStockRecordIssuedProcess.properties");
		// ��ʼ��
		try {
			pro.init(args);
			
			/* ------------------------------------------------------------------------------- */
			log.info("=========�׿���������·�=====��ʼ����ɣ���ʼ����==========");
			// ��ʼ����
			
			pro.process(user,runtime);
			
			log.info("======�׿���������·�========������ɣ������˳�===========");
			
		} catch (Exception e) {
			log.error(e);
			log.error("=====�׿���������·�=========�쳣�˳�===============");
		}
	}
	
//	protected void init(String[] args) throws Exception {
//		
//		String cityid = args[0];
//		// ���ظ��Ի�����
//		if (myProfilePath != null) {
//			InputStream is = BgBase.class.getResourceAsStream(myProfilePath);
//			properties.load(is);
//			is.close();
//		}
//
//		// ��ʼ��log
//		String logFilename = properties.getProperty(cityid+"_log");
//
//		BasicConfigurator.configure();
//		Logger logger = Logger.getRootLogger();
//		DailyRollingFileAppender appender = (DailyRollingFileAppender) logger.getAppender("FILE");
//		Date today = new Date();
//		appender.setFile((logFilename + "." + (new SimpleDateFormat("yyMMdd")).format(today)));
//		appender.activateOptions();
//
//		logger.info("------log file changed to " + logFilename + " ---------------");
//		StringBuffer sb = new StringBuffer();
//		for (String arg : args) {
//			sb.append("[").append(arg).append("] ");
//		}
//		logger.info(sb);
//		log = logger;
//		
//		// ��ʼ��hibernate�����Ϣ
//		String url = properties.getProperty(cityid + "_db_url");
//		String username = properties.getProperty(cityid + "_db_user");
//		String tempPoolsize = properties.getProperty(cityid + "_db_poolsize");
//		String poolsize = "5";
//		if (tempPoolsize != null) {
//			poolsize = tempPoolsize;
//		}
//		String password = properties.getProperty(cityid + "_db_password");
//		password = new String(SecurityPass.decode(SecurityPass.hex2byte(password), SecurityPass.hex2byte(mkey)));
//
//		Properties hibernateProperties = new Properties();
//		hibernateProperties.setProperty("hibernate.connection.url", url);
//		hibernateProperties.setProperty("hibernate.connection.username", username);
//		hibernateProperties.setProperty("hibernate.connection.password", password);
//		hibernateProperties.setProperty("hibernate.connection.pool_size", poolsize);
//		this.registerSessionFactoryBean(hibernateProperties);
//
//		registerTypeConvert();//ע������ת����
//	}
	
	/**
     * Description: ��FTP�������ϴ��ļ�
     *
     * @Version1.0
     * @param url
     *            FTP������hostname
     * @param port
     *            FTP�������˿�
     * @param username
     *            FTP��¼�˺�
     * @param password
     *            FTP��¼����
     * @param path
     *            FTP����������Ŀ¼,����Ǹ�Ŀ¼��Ϊ��/��
     * @param filename
     *            �ϴ���FTP�������ϵ��ļ���
     * @param input
     *            �����ļ�������
     * @return �ɹ�����true�����򷵻�false
     */
    public static boolean uploadFile(String url, int port, String username,
            String password, String path, String filename, InputStream input) {
        boolean result = false;
 
        try {
            int reply;
            // �������Ĭ�϶˿ڣ�����ʹ��ftp.connect(url)�ķ�ʽֱ������FTP������
            ftpClient.connect(url);
            // ftp.connect(url, port);// ����FTP������
            // ��¼
            ftpClient.login(username, password);
            ftpClient.setControlEncoding(encoding);
            // �����Ƿ����ӳɹ�
            reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
            	log.error("=====�׿���������ļ��ϴ�=========����ʧ��===============");
                ftpClient.disconnect();
                return result;
            }
 
            // ת�ƹ���Ŀ¼��ָ��Ŀ¼��
            boolean change = ftpClient.changeWorkingDirectory(path);
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            if (change) {
                result = ftpClient.storeFile(new String(filename.getBytes(encoding),"iso-8859-1"), input);
                if (result) {
                    log.info("======�׿���������ļ��ϴ�========�ϴ��ɹ�!===========");
                }
            } else {
            	log.info("======�ļ�ת�ƹ���Ŀ¼��ָ��Ŀ¼��ʧ��!===========");
            }
            input.close();
            ftpClient.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }
	
	private void process(DBAccessUser user,String runtime) throws Exception{
		 
		// ȡ�����е��׿�Ʒ��
		Map barand = Code2NameUtils.valueList("$FX_SMPBRAND", user.getCityid());
		
		// ȡ�����е���Ʒ����
		Waystockrecord waystockrecord = (WaystockrecordBO) BOFactory.build(WaystockrecordBO.class, user);
		ComcategoryrelaDBParam params = new ComcategoryrelaDBParam();
		Map comcategory = waystockrecord.doLoadComCateAndBrand(params);
		
		// ȡ��������Ʒ����ֵ
		Set<String> key = comcategory.keySet();
		List list = new ArrayList();
		for (Iterator it = key.iterator(); it.hasNext();) {
            String s = (String) it.next();
            list.add(s);
        }
		
		// ��ȡָ�����ڣ����Ϊ��ȡ��ǰ����ǰһ��
		Date Afdate = new Date();
		Date temp = DateUtil.operationDateOfDay(Afdate,1,DateOperationType.DIFF);
		if (StringUtils.isEmpty(runtime) || runtime.length()!=8) {			
			runtime = new SimpleDateFormat("yyyyMMdd").format(temp);
		}
		
		// ȡ�������������
		WaystockrecordDBParam wayparams = new WaystockrecordDBParam();
		wayparams.set_sin_comcategory(list);
		wayparams.setCountOnly(true);
		Map query = new HashMap();
		query.put("stocktime", runtime);
		wayparams.setQueryConditions(query);
		DataPackage dp1 = waystockrecord.queryRestypeToComcategory(wayparams,"com.gmcc.pboss.business.sales.waystockrecord.querywaystockrecord");
		int count = dp1.getRowCount();		
		WaystockrecordDBParam waydparams = new WaystockrecordDBParam();		
		
		
		//����txt�ļ�
		log.info("======�׿���������·�========����txt�ļ���ʼ===========");
		String path = properties.getProperty("locationpath");
		
		// �ļ�����
		String filname = "card_repertory_"+user.getCityid()+"."+runtime;
		System.out.println("�����ļ�Ŀ¼�Լ����ƣ�"+path+filname);
		File filename = new File(path+filname);		
		RandomAccessFile mm = null;
		// �ļ����ɳɹ���־
		boolean yflag = false;
		try {
			mm = new RandomAccessFile(filename, "rw");
			if (count > 1000) {
				// ���ݴ���1000����ʱ�򣬰���ÿ1000��ȡһ������
				int cnt = count/1000;
				boolean flag = count%1000 > 0?true:false;
				if (flag) {
					cnt=cnt+1;
				}
				for (int i=0; i<cnt; i++) {
					waydparams.set_pagesize("1000");
					waydparams.set_pageno(i+"");
					waydparams.set_sin_comcategory(list);
					waydparams.setQueryConditions(query);
					DataPackage dp = waystockrecord.queryRestypeToComcategory(waydparams,"com.gmcc.pboss.business.sales.waystockrecord.querywaystockrecord");
					for (int k =0; k<dp.getDatas().size(); k++) {
						WaystockrecordVO vo = (WaystockrecordVO)dp.getDatas().get(k);
						writemeber(vo,barand,comcategory,mm);
						//����
						mm.writeBytes("\r\n");
					}
				}
				
			} else {
				waydparams.set_sin_comcategory(list);
				waydparams.set_pagesize("1000");
				waydparams.setQueryConditions(query);
				DataPackage dp = waystockrecord.queryRestypeToComcategory(waydparams,"com.gmcc.pboss.business.sales.waystockrecord.querywaystockrecord");
				for (int k =0; k<dp.getDatas().size(); k++) {
					WaystockrecordVO vo = (WaystockrecordVO)dp.getDatas().get(k);
					writemeber(vo,barand,comcategory,mm);
					//����
					mm.writeBytes("\r\n");
				}
			}
			mm.write("������".getBytes());
			mm.writeBytes(count+"");
			mm.writeBytes("\r\n");
			yflag = true;
		} catch (IOException e1) {
			// ����д���ļ��쳣
			log.info("======�׿���������·�========����д���ļ��쳣===========");
			e1.printStackTrace();
		} finally {
			if (mm != null) {
				try {
					mm.close();
				} catch (IOException e2) {
					// �ļ����ر��쳣
					log.info("======�׿���������·�========�ļ����ر��쳣===========");
					e2.printStackTrace();
				}
			}
		}
		if (yflag) {
			log.info("======�׿���������·�========����txt�ļ�����������===========");
			
			// �ϴ����ɵ��ļ�
			String url = properties.getProperty("ftp.address");
			int port = 21;
			String tmp = properties.getProperty("ftp.port");
			if (StringUtils.isNotEmpty(tmp))
				port=Integer.parseInt(tmp);
			String username = properties.getProperty("ftp.user");
			String password = properties.getProperty("ftp.password");
			String dirpath = properties.getProperty("ftp.work.dir");
			System.out.println("�ϴ��ļ�Ŀ¼�Լ����ƣ�"+dirpath+filname);
			FileInputStream in = new FileInputStream(new File(path+filname));			
			uploadFile(url,port,username,password,dirpath,filname,in);
		}
		
		// ɾ��15��ǰ���ɵ��ļ�
		deleteFile(path,user.getCityid());
	}
	
	/**
	 * д���ݵ��ļ���
	 * @author yangdaren
	 * @param vo
	 * @param mbrand
	 * @param comcg
	 * @param mm
	 * @throws IOException
	 */
	public void writemeber(WaystockrecordVO vo,Map mbrand,Map comcg,RandomAccessFile mm) throws IOException {
		
		mm.writeBytes(DateUtil.formatDate(vo.getStocktime(), DateFormatType.DATE_FORMAT_STR));
		mm.writeBytes("|");
		mm.writeBytes(vo.getWayid());
		mm.writeBytes("|");
		// ��ֹ��������		
		mm.write(vo.getWayname().getBytes(encoding));
		mm.writeBytes("|");
		mm.writeBytes(vo.getStarlevel()+"");
		mm.writeBytes("|");
		// ��ֹ��������
		String brand = mbrand.get(vo.getBrand())+"";
		mm.write(brand.getBytes(encoding));
		mm.writeBytes("|");
		// ��ֹ��������
		String strcomcg =comcg.get(vo.getComcategory())+"";
		mm.write(strcomcg.getBytes(encoding));
		mm.writeBytes("|");
		mm.writeBytes(vo.getComresid());
		
	}
	
	/**
	 * @author yangdaren
	 * ɾ��15��ǰ���ļ�
	 * @param path
	 * @param cityid
	 */
	public void deleteFile(String path,String cityid) {
		// ��ȡ15��ǰ������
	    Date curentDate = new Date();
	    Date tmpdate = DateUtil.operationDateOfDay(curentDate,15,DateOperationType.DIFF);
	    String diffDate = new SimpleDateFormat("yyyyMMdd").format(tmpdate); 
	    System.out.println(diffDate);
	      
//		String filePath = path;
		String filname = "card_repertory_"+cityid+"."+diffDate; 
        //�жϴ��ļ��Ƿ���һ���ļ�  
        String s = path + filname;//�ļ��ľ���·��
        System.out.println("ɾ���ļ�Ŀ¼�Լ����ƣ�"+s);
        File file = new File(s);
        if(file.exists()){
           boolean d = file.delete();
           if(d){
               log.info(filname+"ɾ���ɹ���");
           }else{
               log.info(filname+"ɾ��ʧ�ܣ�");
           } 
        }
	}
	
	

}
