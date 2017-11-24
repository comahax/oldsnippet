package com.gmcc.pboss.BgProcess.resource.resource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.business.resource.resimport.ResimportVO;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.resource.resimport.Resimport;
import com.gmcc.pboss.control.resource.resimport.ResimportBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;


/**
 * ��Դ���
 * @author wefrogll
 * @version 1.0 2009-12-18
 */
public class ResourceDeploy  extends BgBase{

	public  final static String LINE_END_FLAG = "HDR2";//β�б�ʶ
	private final static String SPLIT_SYMBOL = "&&";//�ֶηָ���
	
	private String interval; //������ͣʱ��
	private String srcpath;  //����ɨ���ļ�Ŀ¼
	private String bakpath;  //���򱸷��ļ�Ŀ¼
	private String errpath;  //���������־�ļ�Ŀ¼
	
	private String defaultState;	//Ĭ����Ʒ״̬
	private String resourceUse;		//Ĭ����Դ��;
	private String storage;			//Ĭ�ϴ洢����
	private String comrescardState;	//��ֵ����Ʒ״̬
	private String simrescardState;	//�հ�SIM��Ʒ״̬
	
		
	public static void main(String[] args){
		try{
			ResourceDeploy resourceDeploy = new ResourceDeploy();
			boolean isPass = resourceDeploy.checkArgs(args);
			if (!isPass) {
				return;
			}
			User user = resourceDeploy.getUser(args[0]);
			resourceDeploy.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/resource/resource/hibernate.cfg.xml");
			resourceDeploy.setMyProfilePath("/resource_resource.properties");
			resourceDeploy.init(args);	
			long start = 0;
			while(true){
				try{
					log.info("========��Դ��⿪ʼ====================");
					start = System.currentTimeMillis();
					resourceDeploy.addResource(user);
				}catch(Exception e){
					e.printStackTrace();
				}
				log.info("========��Դ������===========��ʱ���룩��"+(System.currentTimeMillis()-start)/1000);
				System.out.println("==============���� "+resourceDeploy.interval+" ����=====================");
				Thread.sleep(Integer.parseInt(resourceDeploy.interval)*60000);						
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	protected void init(String[] args) throws Exception {
		// TODO Auto-generated method stub
		super.init(args);
		String cityid=args[0];
		interval = properties.getProperty(cityid+"_intervalMin");
		srcpath = properties.getProperty(cityid+"_file_receive");
		bakpath = properties.getProperty(cityid+"_file_bak");
		errpath = properties.getProperty(cityid+"_file_err");
		
		User user = super.getUser(args[0]);
		SysparamBO sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
		SysparamVO sysparamVO = new SysparamVO();
		sysparamVO.setSystemid(new Long(1));
		sysparamVO.setParamtype("pboss_fx");
		sysparamVO = sysparamBO.doFindByPk(sysparamVO);
		if(sysparamVO == null || sysparamVO.getParamvalue() == null || "".equals(sysparamVO.getParamvalue().trim()))
			throw new Exception("�׿����Ĭ����Ʒ״̬");
		defaultState = sysparamVO.getParamvalue();
		
		sysparamVO = new SysparamVO();
		sysparamVO.setSystemid(new Long(7));
		sysparamVO.setParamtype("pboss_fx");
		sysparamVO = sysparamBO.doFindByPk(sysparamVO);
		if(sysparamVO == null || sysparamVO.getParamvalue() == null || "".equals(sysparamVO.getParamvalue().trim()))
			throw new Exception("��ֵ�����Ĭ����Ʒ״̬");
		comrescardState = sysparamVO.getParamvalue();
		
		sysparamVO = new SysparamVO();
		sysparamVO.setSystemid(new Long(83));
		sysparamVO.setParamtype("pboss_fx");
		sysparamVO = sysparamBO.doFindByPk(sysparamVO);
		if(sysparamVO == null || sysparamVO.getParamvalue() == null || "".equals(sysparamVO.getParamvalue().trim()))
			throw new Exception("�հ�SIM��Ʒ״̬");
		simrescardState = sysparamVO.getParamvalue();
		
		sysparamVO = new SysparamVO();
		sysparamVO.setSystemid(new Long(2));
		sysparamVO.setParamtype("pboss_fx");
		sysparamVO = sysparamBO.doFindByPk(sysparamVO);
		if(sysparamVO == null || sysparamVO.getParamvalue() == null || "".equals(sysparamVO.getParamvalue().trim()))
			throw new Exception("�׿����Ĭ����Դ��;");
		resourceUse = sysparamVO.getParamvalue();
		
		sysparamVO = new SysparamVO();
		sysparamVO.setSystemid(new Long(3));
		sysparamVO.setParamtype("pboss_fx");
		sysparamVO = sysparamBO.doFindByPk(sysparamVO);
		if(sysparamVO == null || sysparamVO.getParamvalue() == null || "".equals(sysparamVO.getParamvalue().trim()))
			throw new Exception("�׿����Ĭ����������");
		storage = sysparamVO.getParamvalue();
	}



	
	/**
	 * ��Դ���
	 * @param user	//���г�����û��������б�ʶ
	 * @return
	 * @throws Exception 
	 */
	public void addResource(User user) throws Exception {
		try{
						
			//==========================��̨ϵͳͳһ����Ϊ �û������õ�,��������ȡϵͳ���Ų��� 
//			sysparamVO = new SysparamVO();
//			sysparamVO.setSystemid(new Long(4));
//			sysparamVO.setParamtype("pboss");
//			sysparamVO = sysparamBO.doFindByPk(sysparamVO);
//			if(sysparamVO == null || sysparamVO.getParamvalue() == null || "".equals(sysparamVO.getParamvalue().trim()))
//				throw new Exception("��ϵͳ��̨����Ϊ��");
			String operator = user.getOprcode();
			
			this.processFile(srcpath, defaultState, resourceUse, storage,user);
		}catch(Exception e){
			LoggerUtils.error(e, log);
		}	
	}
	
	/**
	 * ���������ļ�
	 * @param file	�ļ�����Ŀ¼
	 * @param defaultState	Ĭ����Ʒ״̬
	 * @param resourceUse	Ĭ����Դ��;
	 * @param storage		Ĭ�ϴ洢����	
	 * @param user			�����û�������ϵͳ���ţ�
	 */
	private void processFile(String file,String defaultState,String resourceUse,String storage,User user ){
//		ɨ��ָ���ļ�Ŀ¼����ȡ�ļ��б�������ļ����ڣ������������״̬������ָ��ʱ������¿�ʼɨ���ļ���������ļ����ڣ�������ļ����д���
		File processFile = new File(file);
		String line = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String batchNo = df.format(new Date());
		BufferedReader reader = null;
		File files[] = processFile.listFiles();
		for(File tempFile: files){
			FileReader fileReader = null;
			int lineCount = 0;
			int count = 0;//�ļ�β�ļ�¼��
			try{
				
//				1��	�ļ���ƥ�䡣����Э������ƥ����Դ���ͺ͵��б�ʶ�����ƥ��ʧ�ܣ��򷵻ش�����һ���ļ������ƥ��ɹ����������һ������
				if(isProcessFile(tempFile,user.getCityid())){
					fileReader = new FileReader(tempFile);
					reader = new BufferedReader(fileReader);
					
					while((line = reader.readLine()) != null && !line.contains(LINE_END_FLAG) ){
						lineCount++;
					}
//					2��	�ļ������Լ�顣����ļ����һ���Ƿ����β�б�ǣ��������������Ϊ�ļ�������������ǰ�ļ���������ļ�Ŀ¼��
//					���ش�����һ���ļ����������β�б�ǣ����ȡ�ļ�����������������β�У��������������ļ�β�ļ�¼�����жԱȣ�
//					������߲�һ�£�����Ϊ�ļ�������������ǰ�ļ���������ļ�Ŀ¼�����ش�����һ���ļ�������ļ������������ļ�β�ļ�¼����ͬ
//					����ͨ���ļ������Լ�飬������һ������
					if(null == line){
						log.info("==========�ļ� "+tempFile.getName()+" ������β�б��==============");
						cutPaste(tempFile,errpath);
					}else{
						String[] endItems = line.trim().split("&&");
						count = Integer.parseInt(endItems[1]);
						if(count != lineCount){//�����������ļ�β�ļ�¼�����жԱȣ�������߲�һ�£�����Ϊ�ļ�������������ǰ�ļ���������ļ�Ŀ¼��
							log.info("==========�ļ� "+tempFile.getName()+" �ļ���¼�����ļ�β�ļ�¼����һ��==============");
							fileReader.close();
							reader.close();
							cutPaste(tempFile,errpath);
						}else{//���ش�����һ���ļ�������ļ������������ļ�β�ļ�¼����ͬ����ͨ���ļ������Լ�飬������һ������
//							3��	�Ǽ���Դ����¼��
//							������¼����Դ����¼��IM_PR_RESIMPORT�������ȡ���У�IM_PR_RESIMPORT_SEQ�����ļ���Ϊ��ǰ�����ļ�
//							����ʼʱ��ȡ��ǰʱ�䣬�����ֶ����ա���¼������¼�ı�š�
							Resimport resimportBO = (ResimportBO)BOFactory.build(ResimportBO.class,user);
							ResimportVO resimportVO = new ResimportVO();
							resimportVO.setFilename(tempFile.getName());
							resimportVO.setBegintime(new Date());
							resimportVO = resimportBO.doCreate(resimportVO);
//							4��	������Դ���ͷֱ���
//							�ļ������������Ҫ�ۼ��ļ��ܼ�¼�����ɹ���¼����ʧ�ܼ�¼����
							BaseProcess bp = null;
							if(tempFile.getName().startsWith("COMRESSMP")){//�׿�
								bp = new ComressmpProcess(user,defaultState,resourceUse,storage,batchNo);
								bp.processFile(tempFile,errpath);
							}else if(tempFile.getName().startsWith("COMRESCARD")){//��ֵ��
								bp = new ComrescardProcess(user,comrescardState,batchNo);
								bp.processFile(tempFile,errpath);
							}else if(tempFile.getName().startsWith("EMPTYSIM")){//�հ�SIM��
								bp = new EmptysimProcess(user,simrescardState,batchNo);
								bp.processFile(tempFile,errpath);
							}else{//δ����
								throw new Exception("δ֪�ļ�����"+tempFile.getName());
							}
//							5��	������Դ����¼��
//							�����ļ�������ϣ����ļ����Ƶ�����Ŀ¼�����ݱ�Ÿ�����Դ����¼�����ʱ��ȡ��ǰʱ�䣬��Դ�������ɹ�����ʧ����ȡ�ļ���������ۼ����ݡ�

							resimportVO.setAmount(new Long(lineCount));
							resimportVO.setSuccessamt(new Long(bp.getSuccess()));
							resimportVO.setFailamt(new Long(bp.getFail()));
							resimportVO.setOvertime(new Date());
							resimportBO.doUpdate(resimportVO);
						}
					}
				}
				
				
			}catch(Exception ex){
				LoggerUtils.error(ex, log);
			}finally{
				if( null != fileReader){
					try {
						fileReader.close();
						fileReader = null;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if( null != reader )
					try {
						reader.close();
						reader = null;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						LoggerUtils.error(e, log);
					}	
			}
			try {
				if(isProcessFile(tempFile,user.getCityid()))
				cutPaste(tempFile,bakpath);//�����ļ�
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("�����ļ�["+tempFile+"]����:"+e.getMessage());
			}
		}
	}
	
	
	/**
	 * �ж��ļ��Ƿ�Ϊ������Ҫ������ļ�
	 * @param file 
	 * @return
	 */
	private boolean isProcessFile(File file,String cityid){
//		���á���Դ����+����+ʱ�䡱�ĸ�ʽ��
//		�׿���COMRESSMP_XX_YYYYMMDDHHMISS.DAT��
//		��ֵ����COMRESCARD_XX_YYYYMMDDHHMISS.DAT��
//		�հ�SIM����EMPTYSIM_XX_YYYYMMDDHHMISS.DAT��

		if(file.isDirectory())
			return false;
		String reg = "(COMRESSMP|COMRESCARD|EMPTYSIM)_["+cityid+"]{2}_\\d{14}\\.DAT";
		return file.getName().matches(reg);
	}
	
	/**
	 * �����ļ�
	 * @param file		�����е��ļ�
	 * @param destDir	ճ�������ļ�Ŀ¼
	 * @throws Exception
	 */
	private void cutPaste(File file,String destDir) throws Exception{
		log.info("==========��Դ�ļ�����Ŀ¼=========="+destDir);
		BufferedReader reader =null;
		BufferedWriter writer = null;
		try{
			if(!file.exists())
				return ;
			reader = new BufferedReader(new FileReader(file));
			destDir = destDir.replace('/', File.separatorChar).replace('\\', File.separatorChar);
			if(!destDir.endsWith(""+File.separatorChar));
				destDir = destDir+File.separatorChar;
			File destFile = new File(destDir+file.getName());
			if(!destFile.exists())
				destFile.createNewFile();
			writer = new BufferedWriter(new FileWriter(destFile));
			String line = null;
			while( (line = reader.readLine()) != null){
				writer.write(line+"\n");
			}

			reader.close();
			file.delete();
		}catch(Exception e){
			e.printStackTrace();
			log.error("��Դ�ļ�����Ŀ¼ʱ����"+e.getMessage());
			throw  e;
		}finally{
			if( null != writer)
				writer.close();
			if( null != reader)
				reader.close();
		}
	}



	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public String getSrcpath() {
		return srcpath;
	}

	public void setSrcpath(String srcpath) {
		this.srcpath = srcpath;
	}

	public String getBakpath() {
		return bakpath;
	}

	public void setBakpath(String bakpath) {
		this.bakpath = bakpath;
	}

	public String getErrpath() {
		return errpath;
	}

	public void setErrpath(String errpath) {
		this.errpath = errpath;
	}
	
	
}
