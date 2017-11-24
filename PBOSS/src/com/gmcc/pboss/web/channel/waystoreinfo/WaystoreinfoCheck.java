package com.gmcc.pboss.web.channel.waystoreinfo;

 
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils; 
import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class WaystoreinfoCheck extends BaseCheckFormat {  
	
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		} 
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {

		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
		DictitemVO vo = new DictitemVO();  

		if (content.length != 24) {
			throw new Exception("�ϴ�������������,ӦΪ23��,��鿴˵������!");
		}
		//�ŵ����
		if (content[0] == null || "".equals(content[0])) {
			throw new Exception("�ŵ���벻��Ϊ��");
		} else{
			Way way = (Way) BOFactory.build(WayBO.class, user);
			WayDBParam wayDBParam = new WayDBParam();
			wayDBParam.set_se_wayid(content[0]);
			wayDBParam.set_se_waytype("AG");
			wayDBParam.set_ne_waystate("1");
			ArrayList<String> waysubtype_in = new ArrayList<String>();
			waysubtype_in.add("PSAL");
			waysubtype_in.add("SAGT");
			waysubtype_in.add("VWAY");
			waysubtype_in.add("FD");
			waysubtype_in.add("FDS");
			waysubtype_in.add("JMQD");
			wayDBParam.set_sin_waysubtype(waysubtype_in);
			DataPackage dp = way.doQuery(wayDBParam);  
			 if(dp.getRowCount()==0){
				throw new Exception("��������Ч���ŵ����");
			 } 
		} 
		//��� 
		if (content[1] == null || "".equals(content[1])) {
			throw new Exception("�������Ϊ��");
		}else if(!CheckUtil.checkDouble(content[1])){
			throw new Exception("��������ȷ�����");
		}
		//ר������
		if(content[2] == null || "".equals(content[2])) {
			throw new Exception("ר�����Ͳ���Ϊ��"); 
		}else{
			vo.setGroupid("CH_WAYSTORETYPE");
			vo.setDictid(content[2]);
			DictitemVO dictitemVO = dictitem.doFindByPk(vo);
			if(null == dictitemVO){
			throw new Exception("��������Ч��ר������ ");
			}
			
		}
		//ר�����
		if (content[3] == null || "".equals(content[3])) {
			throw new Exception("ר���������Ϊ��");
		}else if(!CheckUtil.checkDouble(content[1])){
			throw new Exception("��������ȷ��ר�����");
		}  
		//ר������4
		if(content[4] == null || "".equals(content[4])) {
			throw new Exception("ר�����岻��Ϊ��"); 
		}else{
			vo.setGroupid("CH_YESORNO1");
			vo.setDictid(content[4]);
			DictitemVO dictitemVO = dictitem.doFindByPk(vo);
			if(null == dictitemVO){
			throw new Exception("��������Ч��ר������ ");
			} 
		}
		//ר��ר��
		if(content[5] == null || "".equals(content[5])) {
			throw new Exception("ר��ר����Ϊ��"); 
		}else if(!CheckUtil.checkNum(content[5])){ 
			throw new Exception("��������Ч��ר��ר������ "); 
		}
		
		//ר������
		if(content[6] == null || "".equals(content[6])) {
			throw new Exception("ר�����Ʋ���Ϊ��"); 
		}else if(!CheckUtil.checkNum(content[6])){ 
			throw new Exception("��������Ч��ר���������� "); 
		}
		
		//ר����ǩ
		if(content[7] == null || "".equals(content[7])) {
			throw new Exception("ר������ר����ǩ����Ϊ��"); 
		}else if(!CheckUtil.checkNum(content[7])){ 
			throw new Exception("��������Ч��ר����ǩ���� "); 
		}
		//ר��չ��
		if(content[8] == null || "".equals(content[8])) {
			throw new Exception("ר��չ�ܲ���Ϊ��"); 
		}else if(!CheckUtil.checkNum(content[8])){ 
			throw new Exception("��������Ч��ר��չ������ "); 
		} 
		
		//ר�����ں��
		if(content[9] == null || "".equals(content[9])) {
			throw new Exception("ר�����ں������Ϊ��"); 
		}else{
			vo.setGroupid("CH_YESORNO1");
			vo.setDictid(content[9]);
			DictitemVO dictitemVO = dictitem.doFindByPk(vo);
			if(null == dictitemVO){
			throw new Exception("��������Ч��ר�����ں�� ");
			} 
		}
		//ר��������
		if(content[10] == null || "".equals(content[10])) {
			throw new Exception("ר������������Ϊ��"); 
		}else{
			vo.setGroupid("CH_YESORNO1");
			vo.setDictid(content[10]);
			DictitemVO dictitemVO = dictitem.doFindByPk(vo);
			if(null == dictitemVO){
			throw new Exception("��������Ч��ר�������� ");
			} 
		}
		//ר����ͷ
		if(content[11] == null || "".equals(content[11])) {
			throw new Exception("ר����ͷ����Ϊ��"); 
		}else{
			vo.setGroupid("CH_YESORNO1");
			vo.setDictid(content[11]);
			DictitemVO dictitemVO = dictitem.doFindByPk(vo);
			if(null == dictitemVO){
			throw new Exception("��������Ч��ר����ͷ ");
			} 
		}
		//ר������
		if(content[12] == null || "".equals(content[12])) {
			throw new Exception("ר����������Ϊ��"); 
		}else{
			vo.setGroupid("CH_YESORNO1");
			vo.setDictid(content[12]);
			DictitemVO dictitemVO = dictitem.doFindByPk(vo);
			if(null == dictitemVO){
			throw new Exception("��������Ч��ר������ ");
			} 
		}  
		//ר������̨�Ƶ�λ
		if(content[13] == null || "".equals(content[13])) {
			throw new Exception("ר������̨�Ƶ�λ����Ϊ��"); 
		}else if(!CheckUtil.checkNum(content[13])){ 
			throw new Exception("��������Ч��ר������̨�Ƶ�λ "); 
		} 
		//ר������̨����λ
		if(content[14] == null || "".equals(content[14])) {
			throw new Exception("ר������̨����λ����Ϊ��"); 
		}else if(!CheckUtil.checkNum(content[14])){ 
			throw new Exception("��������Ч��ר������̨����λ "); 
		}  
		//ר������
		if(content[15] == null || "".equals(content[15])) {
			throw new Exception("ר����������Ϊ��"); 
		}else if(!CheckUtil.checkNum(content[15])){ 
			throw new Exception("��������Ч��ר������ "); 
		}   
		//��ͷ����
		if(content[16] == null || "".equals(content[16])) {
			throw new Exception("��ͷ���Ͳ���Ϊ��"); 
		}else{
			vo.setGroupid("CH_DOORTYPE");
			vo.setDictid(content[16]);
			DictitemVO dictitemVO = dictitem.doFindByPk(vo);
			if(null == dictitemVO){
			  throw new Exception("��������Ч����ͷ���� ");
			} 
		}
		//ר����������ͷ���ͻ���
		if( (("3").equals(content[2]) && ("4").equals(content[16])) || (("4").equals(content[2]) && ("3").equals(content[16]))  ){
			throw new Exception("3Gר������ͷ���ͱ���Ϊ3G��ͷ��4Gר������ͷ���ͱ���Ϊ4G��ͷ");
		}
		
		//��ǽ��������С 
		if (content[17] == null || "".equals(content[17])) {
			throw new Exception("��ǽ��������С����Ϊ��");
		}else if(!CheckUtil.checkDouble(content[17])){
			throw new Exception("��������ȷ����ǽ��������С");
		}
		//��ǽ�������������λ
		if(content[18] == null || "".equals(content[18])) {
			throw new Exception("��ǽ�������������λ����Ϊ��"); 
		}else if(!CheckUtil.checkNum(content[18])){ 
			throw new Exception("��������Ч����ǽ�������������λ "); 
		}  
		//�ն�רӪ
		if(content[19] == null || "".equals(content[19])) {
			throw new Exception("�ն�רӪ����Ϊ��"); 
		}else{
			vo.setGroupid("CH_YESORNO2");
			vo.setDictid(content[19]);
			DictitemVO dictitemVO = dictitem.doFindByPk(vo);
			if(null == dictitemVO){
			throw new Exception("��������Ч���ն�רӪ ");
			} 
		}   
		//ҵ��רӪ
		if(content[20] == null || "".equals(content[20])) {
			throw new Exception("ҵ��רӪ����Ϊ��"); 
		}else{
			vo.setGroupid("CH_YESORNO2");
			vo.setDictid(content[20]);
			DictitemVO dictitemVO = dictitem.doFindByPk(vo);
			if(null == dictitemVO){
			throw new Exception("��������Ч��ҵ��רӪ ");
			} 
		}
		// ������������ 
		if(content[21] == null || "".equals(content[21])) {
			throw new Exception("����������������Ϊ��"); 
		}else if(!CheckUtil.checkNum(content[21])){ 
			throw new Exception("��������Ч�ĵ����������� "); 
		}  
		//ϵ��
		if(CheckUtil.isEmpty(content[22])){
			throw new Exception("ϵ������Ϊ��"); 
		}else if(!CheckUtil.checkDouble(content[22], 1, 2) || Double.parseDouble(content[22]) < 0 || Double.parseDouble(content[22]) > 1){
			throw new Exception("ϵ������Ϊ0-1֮���С��ֵ"); 
		}
		
		
		

	}
}
