package test.com.gmcc.pboss.nosect;


import com.gmcc.pboss.common.nosect.service.NosectService;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.member.support.MemberQueryParameter;
import com.sun.corba.se.spi.activation.Server;

import test.com.gmcc.pboss.common.BaseTest;

/**
 * ���˹�˾Ӫ���з���
 * @author yuwenjun
 * @date 2010-3-1
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * �������ֻ���������ز�ѯ
 */
public class NosectServiceTest extends BaseTest {
	private NosectService nosectService;

	public void testQuery() {
		MemberQueryParameter param= new MemberQueryParameter();
		param.setOfficeTel("13560697384");
//		param.setMobileNo("13826042731");
		//����ʹ�ù�����
		SessionFactoryContextHolder.setSessionFactoryContext(null);
		ServiceResult rtnS = nosectService.transact(null, param, ServiceType.INITIATE);
		if (rtnS.isSuccess()){			
			System.out.println("��ѯ�ɹ���"+rtnS.getRetObject());
		}else{
			System.out.println("��ѯʧ�ܣ�"+rtnS.getMessage()+",["+rtnS.getRetCode()+"]");
		}
	}

	/**
	 * @return the nosectService
	 */
	public NosectService getNosectService() {
		return nosectService;
	}

	/**
	 * @param nosectService the nosectService to set
	 */
	public void setNosectService(NosectService nosectService) {
		this.nosectService = nosectService;
	}
}
