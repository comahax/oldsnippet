package com.gmcc.pboss.BgProcess.sales.bgHandle;

import java.util.Date;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.sales.bgcontrol.alaOrderCol.AlaOrderColBg;
import com.gmcc.pboss.control.sales.bgcontrol.alaOrderCol.AlaOrderColBgBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.ui.User;

/**
 * <pre>
 * ��Ԥ�����䵥���ܡ���̨����
 *  �������������ָ�����ڴ������Զ�����Ķ���������ά�Ƚ���ͳ�ƻ��ܡ�Ĭ������¶�ǰһ������Ķ������д���
 * </pre>
 * @author yedaoe
 *
 */
public class AlaOrderColBgProcess extends BgBase {
	
	private Logger log = Logger.getLogger(AlaOrderColBgProcess.class);

	public static void main(String[] args) throws Exception{
		AlaOrderColBgProcess pro = new AlaOrderColBgProcess();
		boolean isPass = pro.myCheckArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = pro.getUser(args[0]);
		//��ȡĿ������
		String coldate = "";
		if(args.length>1){
			coldate = args[1];
		}else{
			coldate = PublicUtils.formatUtilDate(new Date(), "yyyyMMdd");
		}
		// ����hibernate�����ļ�·���������class path��·����
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		pro.setMyProfilePath("/sales/bgHandle/alaOrderCol.properties");
		// ��ʼ��
		pro.init(args);
		pro.alaOrderCol(user,coldate);
	}
	
	/**
	 * �������
	 */
	private boolean myCheckArgs(String[] args) {
		if (args.length < 1) {
			//System.out.println(getHelp());
			log.info("�������в���δ���ã��˳�");
			return false;
		}
		if (!CityMappingUtil.contain(args[0])) {
			System.out.println("cityid is not exist");
			return false;
		}
		if(args.length>1){
			String coldatestr = "";
			coldatestr = args[1];
			try{
				Date date = PublicUtils.UtilStrToDate(coldatestr,"yyyyMMdd");
			}catch(Exception e){
				log.info("Ŀ�����ڸ�ʽ������yyyyMMdd");
				return false;
			}
			String now = PublicUtils.formatUtilDate(new Date(), "yyyyMMdd");
			if(new Long(coldatestr)>new Long(now)){
				log.info("Ŀ�����ڲ�������ڵ�ǰʱ��");
				return false;
			}
		}
		return true;
	}
	
	private void alaOrderCol(User user,String coldate) throws Exception {
		
		AlaOrderColBg alaOrderCol = (AlaOrderColBg)BOFactory.build(AlaOrderColBgBO.class, user);
		try {
			log.info("==================Ԥ�����䵥���ܺ�̨����ʼ==================");
			log.info("Ŀ������Ϊ��"+coldate);
			alaOrderCol.doProcess(coldate);
			log.info("==================Ԥ�����䵥���ܺ�̨�������==================");
		}catch(BusinessException ex) {
			log.info(ex.getMessage());
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}
}
