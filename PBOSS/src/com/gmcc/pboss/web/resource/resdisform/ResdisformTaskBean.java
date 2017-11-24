package com.gmcc.pboss.web.resource.resdisform;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.compack.CompackDBParam;
import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.business.resource.discomres.DiscomresVO;
import com.gmcc.pboss.business.resource.resdisform.ResdisformVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.control.resource.comressmp.Comressmp;
import com.gmcc.pboss.control.resource.comressmp.ComressmpBO;
import com.gmcc.pboss.control.resource.discomres.Discomres;
import com.gmcc.pboss.control.resource.discomres.DiscomresBO;
import com.gmcc.pboss.control.resource.resdisform.Resdisform;
import com.gmcc.pboss.control.resource.resdisform.ResdisformBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class ResdisformTaskBean extends BaseBatchTaskBean{

	private List<WayVO> ways;
	private Compack compackBO;
	private Discomres discomresB0;
	private Map<String,Map<String,String>> resourceMap = new HashMap<String,Map<String,String>>();
	public ResdisformTaskBean() throws Exception {
		super();
		// TODO Auto-generated constructor stub
		super.setBatchName("�׿���Դ��������");

	}

	
	@Override
	public void doProcessFile(String fileInPath, String fileOutPath)
			throws Exception {
		// TODO Auto-generated method stub
//		��������Ϣ���أ���ѯ������CH_PW_WAY����ƥ������Ϊ���������������������WAYTYPE=AG��
//		�������������������̣���WAYSUBTYPE=LOGS����������ʶ��WAYID����Ϊ�����̱��룬����������Ϣ���ص��ڴ��У�����MAP���档
		Way wayBO = (WayBO)BOFactory.build(WayBO.class,user);
		WayDBParam params = new WayDBParam();
		params.setQueryAll(true);
		params.set_se_waytype("AG");
		params.set_se_waysubtype("LOGS");
		DataPackage dp = wayBO.doQuery(params);
		ways = dp.getDatas();
		super.doProcessFile(fileInPath, fileOutPath);
		
//		�ļ�������ɺ��������ݵ���Դ���䵥��IM_PR_RESDISFORM�������䵥�ź���Դ����ȡ�������ݣ�
//		�����˹���Ϊ��ǰ����Ա���ţ�����ʱ��Ϊ��ǰʱ�䣬���䵥״̬Ϊ����ǩ�ա���
//		�����̱��롢��Դ����ȡ�ļ���������ۼ���Ϣ��ͳ����ϢΪ�ļ���������ۼ���Ʒ���༰��Ӧ������
//		��ʽΪ����Ʒ����1-���� ��Ʒ����2-�����������硰DG55-15000 DG100-5000����
//		�����ֶΰ���ǩ���˹��š�ǩ��ʱ�䡢�����˹��š�����ʱ�䡢�����������ݡ�����֪ͨ�Ƿ�������ա�
		String disid = (String)super.getParameterMap().get("disid");
		String storarea = (String)super.getParameterMap().get("storarea");
		Resdisform resdisformBO = (ResdisformBO)BOFactory.build(ResdisformBO.class,user);
		long total = 0;//������������Դ����
		StringBuilder detail = new StringBuilder(50);//������������Դͳ����Ϣ
		if( !resourceMap.isEmpty()){
			Set<String> resourceKeySet = resourceMap.keySet();
			for(String resourceKey : resourceKeySet){
				Map<String,String> categoryMap = resourceMap.get(resourceKey);
				Set<String> categoryKeySet = categoryMap.keySet();
				for(String categoryKey:categoryKeySet){
					total += Long.parseLong(categoryMap.get(categoryKey));
					detail.append(categoryKey).append("-").append(categoryMap.get(categoryKey)).append(" ");
				}
				{
					
					ResdisformVO resdisformVO = new ResdisformVO();
					resdisformVO.setResamt(total);
					resdisformVO.setStatinfo(detail.toString());
					resdisformVO.setDisid(disid);
					resdisformVO.setStorarea(storarea);
					resdisformVO.setDiscode(user.getOprcode());
					resdisformVO.setDistime(new Date());
					resdisformVO.setDisformstate("WAITSIGN");
					resdisformVO.setDiscomcode(resourceKey);
					
					resdisformBO.doCreate(resdisformVO);
				}
			}
		}
		
	}


	@Override
	protected ResultVO processLine(String line, int rowCount) {
		// TODO Auto-generated method stub
		ResultVO resultVO = new ResultVO();
		try{
			String disid = (String)super.getParameterMap().get("disid");
			String storarea = (String)super.getParameterMap().get("storarea");
			
			String[] item = StringUtils.splitPreserveAllTokens(line, "|");
			int i = 0;
			for(i = 0;i<ways.size();i++){
				if(ways.get(i).getWayid().equals(item[0]))
					break;
			}
			//��ѯ�����̱����Ƿ���������MAP�У����������ͨ����������������¼����ԭ�������̲����ڡ���
			if(i==ways.size()){
				throw new Exception ("������["+item[0]+"]������");
			}
			
			Resdisform resdisformBO = (ResdisformBO)BOFactory.build(ResdisformBO.class,user);
			Map<String,String> categoryMap = resdisformBO.doUpdate(item, ways, disid, storarea);
			if(!categoryMap.isEmpty()){//������һЩ��Ʒ
				Map<String,String> tempMap = resourceMap.get(item[0]);
				if(null == tempMap){//��δ�и������̵���Ϣ
					resourceMap.put(item[0], categoryMap);
				}else{
					Set<String> keySet = categoryMap.keySet();
					for(String key: keySet){
						String count = tempMap.get(key);
						if( null == count){//����������Ʒ������ӽ�
							tempMap.put(key, categoryMap.get(key));
						}else{//���ڴ���Ʒ�������Ʒ�����Ӵ�����Ʒ������
							tempMap.put(key, Long.parseLong(categoryMap.get(key))+Long.parseLong(tempMap.get(key))+"");
						}
						resourceMap.put(item[0], tempMap);//���¸������̵�������Ʒ��Ϣ
					}
				}
				
			}
				
			line = rowCount + "   " + line + "    �ɹ�";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		}catch(Exception e){
			line = rowCount + "   " + line + "    ������Ϣ:" + e.getMessage();
			e.printStackTrace();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
			return resultVO;
	}
}
