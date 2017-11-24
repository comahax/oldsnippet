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
 * COMS套卡库存数据下发接口后台程序(WayStockRecordIssuedProcess)
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
		
		// 获取User
		User user = pro.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/waystockrecordissued/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		pro.setMyProfilePath("/WayStockRecordIssuedProcess.properties");
		// 初始化
		try {
			pro.init(args);
			
			/* ------------------------------------------------------------------------------- */
			log.info("=========套卡库存数据下发=====初始化完成，开始处理==========");
			// 开始处理
			
			pro.process(user,runtime);
			
			log.info("======套卡库存数据下发========处理完成，正常退出===========");
			
		} catch (Exception e) {
			log.error(e);
			log.error("=====套卡库存数据下发=========异常退出===============");
		}
	}
	
//	protected void init(String[] args) throws Exception {
//		
//		String cityid = args[0];
//		// 加载个性化配置
//		if (myProfilePath != null) {
//			InputStream is = BgBase.class.getResourceAsStream(myProfilePath);
//			properties.load(is);
//			is.close();
//		}
//
//		// 初始化log
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
//		// 初始化hibernate相关信息
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
//		registerTypeConvert();//注册类型转换器
//	}
	
	/**
     * Description: 向FTP服务器上传文件
     *
     * @Version1.0
     * @param url
     *            FTP服务器hostname
     * @param port
     *            FTP服务器端口
     * @param username
     *            FTP登录账号
     * @param password
     *            FTP登录密码
     * @param path
     *            FTP服务器保存目录,如果是根目录则为“/”
     * @param filename
     *            上传到FTP服务器上的文件名
     * @param input
     *            本地文件输入流
     * @return 成功返回true，否则返回false
     */
    public static boolean uploadFile(String url, int port, String username,
            String password, String path, String filename, InputStream input) {
        boolean result = false;
 
        try {
            int reply;
            // 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
            ftpClient.connect(url);
            // ftp.connect(url, port);// 连接FTP服务器
            // 登录
            ftpClient.login(username, password);
            ftpClient.setControlEncoding(encoding);
            // 检验是否连接成功
            reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
            	log.error("=====套卡库存数据文件上传=========连接失败===============");
                ftpClient.disconnect();
                return result;
            }
 
            // 转移工作目录至指定目录下
            boolean change = ftpClient.changeWorkingDirectory(path);
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            if (change) {
                result = ftpClient.storeFile(new String(filename.getBytes(encoding),"iso-8859-1"), input);
                if (result) {
                    log.info("======套卡库存数据文件上传========上传成功!===========");
                }
            } else {
            	log.info("======文件转移工作目录至指定目录下失败!===========");
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
		 
		// 取出所有的套卡品牌
		Map barand = Code2NameUtils.valueList("$FX_SMPBRAND", user.getCityid());
		
		// 取出所有的商品种类
		Waystockrecord waystockrecord = (WaystockrecordBO) BOFactory.build(WaystockrecordBO.class, user);
		ComcategoryrelaDBParam params = new ComcategoryrelaDBParam();
		Map comcategory = waystockrecord.doLoadComCateAndBrand(params);
		
		// 取出所有商品类型值
		Set<String> key = comcategory.keySet();
		List list = new ArrayList();
		for (Iterator it = key.iterator(); it.hasNext();) {
            String s = (String) it.next();
            list.add(s);
        }
		
		// 获取指定日期，如果为空取当前日期前一天
		Date Afdate = new Date();
		Date temp = DateUtil.operationDateOfDay(Afdate,1,DateOperationType.DIFF);
		if (StringUtils.isEmpty(runtime) || runtime.length()!=8) {			
			runtime = new SimpleDateFormat("yyyyMMdd").format(temp);
		}
		
		// 取出库存数据总数
		WaystockrecordDBParam wayparams = new WaystockrecordDBParam();
		wayparams.set_sin_comcategory(list);
		wayparams.setCountOnly(true);
		Map query = new HashMap();
		query.put("stocktime", runtime);
		wayparams.setQueryConditions(query);
		DataPackage dp1 = waystockrecord.queryRestypeToComcategory(wayparams,"com.gmcc.pboss.business.sales.waystockrecord.querywaystockrecord");
		int count = dp1.getRowCount();		
		WaystockrecordDBParam waydparams = new WaystockrecordDBParam();		
		
		
		//生成txt文件
		log.info("======套卡库存数据下发========生成txt文件开始===========");
		String path = properties.getProperty("locationpath");
		
		// 文件名称
		String filname = "card_repertory_"+user.getCityid()+"."+runtime;
		System.out.println("生成文件目录以及名称："+path+filname);
		File filename = new File(path+filname);		
		RandomAccessFile mm = null;
		// 文件生成成功标志
		boolean yflag = false;
		try {
			mm = new RandomAccessFile(filename, "rw");
			if (count > 1000) {
				// 数据大于1000条的时候，按照每1000条取一次数据
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
						//换行
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
					//换行
					mm.writeBytes("\r\n");
				}
			}
			mm.write("总数：".getBytes());
			mm.writeBytes(count+"");
			mm.writeBytes("\r\n");
			yflag = true;
		} catch (IOException e1) {
			// 数据写入文件异常
			log.info("======套卡库存数据下发========数据写入文件异常===========");
			e1.printStackTrace();
		} finally {
			if (mm != null) {
				try {
					mm.close();
				} catch (IOException e2) {
					// 文件流关闭异常
					log.info("======套卡库存数据下发========文件流关闭异常===========");
					e2.printStackTrace();
				}
			}
		}
		if (yflag) {
			log.info("======套卡库存数据下发========生成txt文件正常，结束===========");
			
			// 上传生成的文件
			String url = properties.getProperty("ftp.address");
			int port = 21;
			String tmp = properties.getProperty("ftp.port");
			if (StringUtils.isNotEmpty(tmp))
				port=Integer.parseInt(tmp);
			String username = properties.getProperty("ftp.user");
			String password = properties.getProperty("ftp.password");
			String dirpath = properties.getProperty("ftp.work.dir");
			System.out.println("上传文件目录以及名称："+dirpath+filname);
			FileInputStream in = new FileInputStream(new File(path+filname));			
			uploadFile(url,port,username,password,dirpath,filname,in);
		}
		
		// 删除15天前生成的文件
		deleteFile(path,user.getCityid());
	}
	
	/**
	 * 写数据到文件中
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
		// 防止中文乱码		
		mm.write(vo.getWayname().getBytes(encoding));
		mm.writeBytes("|");
		mm.writeBytes(vo.getStarlevel()+"");
		mm.writeBytes("|");
		// 防止中文乱码
		String brand = mbrand.get(vo.getBrand())+"";
		mm.write(brand.getBytes(encoding));
		mm.writeBytes("|");
		// 防止中文乱码
		String strcomcg =comcg.get(vo.getComcategory())+"";
		mm.write(strcomcg.getBytes(encoding));
		mm.writeBytes("|");
		mm.writeBytes(vo.getComresid());
		
	}
	
	/**
	 * @author yangdaren
	 * 删除15天前的文件
	 * @param path
	 * @param cityid
	 */
	public void deleteFile(String path,String cityid) {
		// 获取15天前的日期
	    Date curentDate = new Date();
	    Date tmpdate = DateUtil.operationDateOfDay(curentDate,15,DateOperationType.DIFF);
	    String diffDate = new SimpleDateFormat("yyyyMMdd").format(tmpdate); 
	    System.out.println(diffDate);
	      
//		String filePath = path;
		String filname = "card_repertory_"+cityid+"."+diffDate; 
        //判断此文件是否是一个文件  
        String s = path + filname;//文件的绝对路径
        System.out.println("删除文件目录以及名称："+s);
        File file = new File(s);
        if(file.exists()){
           boolean d = file.delete();
           if(d){
               log.info(filname+"删除成功！");
           }else{
               log.info(filname+"删除失败！");
           } 
        }
	}
	
	

}
