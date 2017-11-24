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
		return "��� | �������� | ��֤������ | ��� | �������� | �������� | �շ�ԱԱ���� | �շ����� | ��ע | ������������ | �������"+"\r\n";
	}

	/**
	 * ����һ����¼
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
		
			if (oprtype.shortValue() == 0 || oprtype.shortValue() == 2) { // ����/�޸�
				try{
				doInsert(wayid, bailtype, money,givetime,opertype,recvoprcode,recvtime,memo);
				}catch (Exception ex) { // ����ʧ��
					//ex.printStackTrace();
					msg = "����ʧ�ܣ�"+ex.getMessage();
					resultVO.setOk(false);
					resultVO.setInfo(showInfo(resultVO, items, rowCount)+msg);
					return resultVO;
				}
			}
			if (oprtype.shortValue() == 3) { // ɾ��
				doDelete(wayid, bailtype, money,givetime,opertype,recvoprcode,recvtime,memo);
			}
			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount));
			return resultVO;
		} catch (Exception ex) { // ����ʧ��
			//ex.printStackTrace();
			msg = ex.getMessage();
			resultVO.setOk(false);
			resultVO.setInfo(showInfo(resultVO, items, rowCount)+msg);
			return resultVO;
		}
	}

	/**
	 * ����ļ���ʽ
	 */
	public String showInfo(ResultVO resultVO, String[] items, int rowCount) {
		final String COMPART = " | "; // �ָ�
		StringBuffer resultStr = new StringBuffer();
		// ���"��� | �������� | ��֤������ | ��� | �������� | �������� | �շ�ԱԱ���� | �շ����� | ��ע | ������������ | �������"+"\r\n";
		resultStr.append(rowCount).append(COMPART);
		// ��������
		resultStr.append(items[0]).append(COMPART);		
		// ��֤������
		resultStr.append(items[1]).append(COMPART);
		// ���
		resultStr.append(items[2]).append(COMPART);
		// ��������
		resultStr.append(items[3]).append(COMPART);
		// ��������
		resultStr.append(items[4]).append(COMPART);
		// �շ�ԱԱ����
		resultStr.append(items[5]).append(COMPART);
		// �շ�����
		resultStr.append(items[6]).append(COMPART);
		// ��ע
		resultStr.append(items[7]).append(COMPART);
		// ��������
		if (oprtype.shortValue() == 0) {
			resultStr.append("����");
		}
		if (oprtype.shortValue() == 2) {
			resultStr.append("����");
		}
		if (oprtype.shortValue() == 3) {
			resultStr.append("ɾ��");
		}
		resultStr.append(COMPART);
		// ������
		if (resultVO.isOk()) {
			resultStr.append("�ɹ�");
		} else {
			resultStr.append("ʧ��");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}

	private void doDelete(String wayid,String  bailtype,Double money,Date givetime,String opertype,String recvoprcode,Date recvtime,String memo)
			throws Exception {
		 String pkValue = wayid+"|"+bailtype+"|"+money+"|"+givetime+"|"+opertype+"|"+recvoprcode+"|"+recvtime+"|"+memo;
		 BailVO BailVO = (BailVO)delegate.doFindByPk(getDeletePkVO(pkValue),user);
		 if (BailVO == null) {
		 throw new Exception("�Ҳ�����Ӧ�ļ�¼,����������֤���¼����");
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
	 * �����¼
	 * 
	 */
	private void doInsert(String wayid,String  bailtype,Double money,Date givetime,String opertype,String recvoprcode,Date recvtime,String memo)
			throws Exception {
		
		if (!wayd.isWayExist(wayid, user)) {
			throw new Exception("[��������]�����ڣ�");
		} 
		OperatorListVO oListVO=new OperatorListVO();
		oListVO.set_se_operid(recvoprcode);
		if (oDelegate.doQuery(oListVO, user).getRowCount() == 0) {
			throw new Exception("���շѹ��Ų�����");
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
						
		 
		 delegate.doCreate(newBailVO, user); // ������
		 oprtype = Short.valueOf("0");//Ĭ��������
		 /*
		 if (oldBailVO == null) {//����
			 delegate.doCreate(newBailVO, user); // ������
			 oprtype = Short.valueOf("0");//Ĭ��������
		 }else{ //����
			 delegate.doUpdate(newBailVO, user);
			 oprtype = Short.valueOf("2");
		 }*/
	}

	public void setOprtype(Short oprtype) {
		this.oprtype = oprtype;
	}
	
    /**
     * ����������ɾ��ʱ����������VO
     * ����List.jsp��ɾ����ťʱ���Ӳ�����ȡ��ɾ�����ݵ�������
     */
    protected Serializable getDeletePkVO(String pkValue) throws Exception {
        String[] pkValueArray = pkValue.split("\\|"); 
//      TODO: ������������������
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
