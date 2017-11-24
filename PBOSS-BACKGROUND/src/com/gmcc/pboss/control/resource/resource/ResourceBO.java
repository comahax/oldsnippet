package com.gmcc.pboss.control.resource.resource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.resource.comrescard.ComrescardVO;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.business.resource.emptysim.EmptysimVO;
import com.gmcc.pboss.business.resource.emptysimlog.EmptysimlogVO;
import com.gmcc.pboss.business.resource.numtyperule.NumtyperuleVO;
import com.gmcc.pboss.business.resource.simnoactinfo.SimnoactinfoDBParam;
import com.gmcc.pboss.business.resource.simnoactinfo.SimnoactinfoVO;
import com.gmcc.pboss.business.sales.partnerres.PartnerresDBParam;
import com.gmcc.pboss.business.sales.partnerres.PartnerresVO;
import com.gmcc.pboss.control.resource.baodi.BaodiBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.control.resource.comrescard.Comrescard;
import com.gmcc.pboss.control.resource.comrescard.ComrescardBO;
import com.gmcc.pboss.control.resource.comressmp.Comressmp;
import com.gmcc.pboss.control.resource.comressmp.ComressmpBO;
import com.gmcc.pboss.control.resource.emptysim.Emptysim;
import com.gmcc.pboss.control.resource.emptysim.EmptysimBO;
import com.gmcc.pboss.control.resource.emptysimlog.Emptysimlog;
import com.gmcc.pboss.control.resource.emptysimlog.EmptysimlogBO;
import com.gmcc.pboss.control.resource.numtyperule.Numtyperule;
import com.gmcc.pboss.control.resource.numtyperule.NumtyperuleBO;
import com.gmcc.pboss.control.resource.simnoactinfo.Simnoactinfo;
import com.gmcc.pboss.control.resource.simnoactinfo.SimnoactinfoBO;
import com.gmcc.pboss.control.sales.partnerres.Partnerres;
import com.gmcc.pboss.control.sales.partnerres.PartnerresBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;


public class ResourceBO extends AbstractControlBean implements Resource{
	private Log log = LogFactory.getLog(BaodiBO.class);
	
	public void process() throws Exception {
		// TODO Auto-generated method stub
		try{
			
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}	
	}

	
	/**
	 * �׿���Դ��������
	 * @param line ����������ֶ������&&�ֿ�
	 * @param map ��Ʒ��MAP ��ÿ�β�����������¼�����������ļ����ͳһ����
	 * @param defaultState	Ĭ����Ʒ״̬
	 * @param resourceUse	Ĭ����Դ��;
	 * @param storage		Ĭ�ϴ洢����	
	 * @param batchno		��Ʒ����
	 * @throws Exception
	 */
	public void doComressmDeploy(String line,Map map,String defaultState,String resourceUser,String storage,String batchno,List<NumtyperuleVO> typeruleList) throws Exception{
		
		String split_sybm = "|";
		String tempLine = line.replaceAll("&&", "|");
		String[] items = StringUtils.splitPreserveAllTokens(tempLine,"|");
		if(items.length !=20 ){
			throw new Exception("������Ӧ����19������������֮����'&&'�ֿ� :"+line);
		}
		
//		���ж�ȡ�ļ����ݣ�����Э��涨���ֶ�˳��ȡֵ��Ҫ����Ʒ��Դ��š���Ʒ��ʶ����Ʒ���Ρ���Ʒ״̬��
//		������ʶ��Ʒ���ֶηǿգ����Ϊ�����¼�����ļ�������ԭ����д��XX�ֶ�Ϊ�ա���
//		�Ǽ�ʧ�ܼ�¼�������ش�����һ����¼����������ֶ�Ϊ�գ�����Ĭ��ֵ��000-000-000����
		if( "".equals(items[0].trim()))
			throw new Exception("��Ʒ��Դ����ֶ�Ϊ��");
		if( "".equals(items[1].trim()))
			throw new Exception("��Ʒ��ʶ�ֶ�Ϊ��");
		if( "".equals(items[3].trim()))
			throw new Exception("��Ʒ״̬�ֶ�Ϊ��");
		if( "".equals(items[4].trim()))
			throw new Exception("������ʶ�ֶ�Ϊ��");
		if( "".equals(items[17].trim()))
			throw new Exception("Ʒ���ֶ�Ϊ��");
		String boxnum = items[18];
		if( "".equals(items[18].trim())){
			boxnum = items[1].trim()+items[4].trim()+"000-000-000";
			items[18] = items[1].trim()+items[4].trim()+"000-000-000";
		}
			
		try{
//			1��	������Ʒ���κͰ��Ų�ѯ��Ʒ��MAP������������5�������������һ����
			
			if(map.get(batchno+split_sybm+boxnum) == null){
				Compack compackBO = (CompackBO)BOFactory.build(CompackBO.class,user);
				CompackVO compackVO = new CompackVO();
				compackVO.setBatchno(batchno);
				compackVO.setBoxnum(boxnum);
				compackVO = compackBO.doFindByPk(compackVO);
//				2��	������Ʒ���κͰ��Ų�ѯ��Ʒ�������������������һ������������4����
				if(compackVO != null){
		
//				3��	�ж���Ʒ������Ʒ���ࡢ��״̬(Ĭ��״̬���ȡ���ļ��޹�)�������Ƿ�͵�ǰ��Դһ�¡�
//				������Ʒ��ʶ��ѯ��Ʒ������Ϲ�ϵ���ȡ��Ʒ���࣬�ж���ʱȡ��һ�����ɣ�������������¼������Ϣ��������Ʒ��ʶ[XXX]�Ҳ�����Ӧ����Ʒ������Ϲ�ϵ�������ش�����һ�����ݣ��׿���Դ״̬ȡ�׿�Ĭ����Ʒ״̬������ȡ�ļ���������ʶ��
//				���ȫ��һ���������һ�������������һ���Բ�һ�����¼������Ϣ���׿���Ʒ����[A]����Ʒ����Ʒ����[B]��һ�¡������׿����Ĭ��״̬[A]����Ʒ��״̬[B]��һ�¡����׿�����[A]����Ʒ������[B]��һ�¡������ش�����һ�����ݡ�

					Comcategoryrela comcategoryrelaBO = (ComcategoryrelaBO) BOFactory.build(ComcategoryrelaBO.class,user);
					ComcategoryrelaDBParam comcategoryrelaDBParam = new ComcategoryrelaDBParam();
					comcategoryrelaDBParam.setDataOnly(true);
					comcategoryrelaDBParam.set_ne_comid(items[1]);
					DataPackage comcategoryrelaDP = comcategoryrelaBO.doQuery(comcategoryrelaDBParam);
					if( null == comcategoryrelaDP || null == comcategoryrelaDP.getDatas() || comcategoryrelaDP.getDatas().size() == 0)
						throw new JOPException("������Ʒ��ʶ["+items[1]+"]�Ҳ�����Ӧ����Ʒ������Ϲ�ϵ");
					ComcategoryrelaVO ComcategoryrelaVO = (ComcategoryrelaVO) ((List)comcategoryrelaDP.getDatas()).get(0);
					if(!ComcategoryrelaVO.getComcategory().equals(compackVO.getComcategory()))
						throw new JOPException("�׿���Ʒ����["+ComcategoryrelaVO.getComcategory()+"]����Ʒ����Ʒ����["+compackVO.getComcategory()+"]��һ��");	
					if(!defaultState.equals(compackVO.getPackstate()))
						throw new JOPException("�׿����Ĭ��״̬["+defaultState+"]����Ʒ��״̬["+compackVO.getPackstate()+"]��һ��");	
					if(!compackVO.getWayid().equals(items[4]))
						throw new JOPException("�׿�����["+items[4]+"]����Ʒ������["+compackVO.getWayid()+"]��һ��");			
				}
//				4��	�������ݵ�MAP�У�keyȡ������|���š���valueȡ��Ʒ��������Ʒ�������գ�
//				������Ʒ��ʶ��ѯ��Ʒ������Ϲ�ϵ��IM_PR_COMCATEGORYRELA����ȡ��Ʒ���ࣻ��״̬������������ȡ�׿���Ӧ�ֶΣ�
//				�����Ŷ�ȡ����ǰ3λ����Դ��;����������ȡϵͳĬ�ϲ��������������̺ʹ��ʱ�����ա�
				Comcategoryrela comcategoryrelaBO = (ComcategoryrelaBO) BOFactory.build(ComcategoryrelaBO.class,user);
				ComcategoryrelaDBParam comcategoryrelaDBParam = new ComcategoryrelaDBParam();
				comcategoryrelaDBParam.setQueryAll(true);
				comcategoryrelaDBParam.setDataOnly(true);
				comcategoryrelaDBParam.set_ne_comid(items[1]);
				DataPackage comcategoryrelaDP = comcategoryrelaBO.doQuery(comcategoryrelaDBParam);
				if( null == comcategoryrelaDP || null == comcategoryrelaDP.getDatas() || comcategoryrelaDP.getDatas().size() == 0)
					throw new JOPException("������Ʒ��ʶ["+items[1]+"]�Ҳ�����Ӧ����Ʒ������Ϲ�ϵ");
				ComcategoryrelaVO ComcategoryrelaVO = (ComcategoryrelaVO) ((List)comcategoryrelaDP.getDatas()).get(0);
				compackVO = new CompackVO();
				compackVO.setBatchno(batchno);
				compackVO.setBoxnum(boxnum);
				compackVO.setComcategory(ComcategoryrelaVO.getComcategory());
				compackVO.setPackstate(defaultState);
				compackVO.setWayid(items[4]);
				compackVO.setNosect(items[0].substring(0,3));
				compackVO.setResuse(resourceUser);
				compackVO.setStorarea(storage);
			map.put(batchno+split_sybm+boxnum, compackVO);
			} else {
				CompackVO compackVO = (CompackVO) map.get(batchno + split_sybm + boxnum);
				if (!compackVO.getWayid().equals(items[4])) {
					throw new JOPException("�׿�����[" + items[4] + "]����Ʒ������[" + compackVO.getWayid() + "]��һ�� -----");
				}
			}
//			5��	�������ݵ��׿���Դ��IM_FX_COMRESSMP������Ʒ����ȡ��ǰ���ڣ���ʽΪyyyy-MM-dd������Ʒ״̬��ȡ�׿�Ĭ����Ʒ״̬��
//			�����ʱ�䡱ȡ��ǰʱ�䣻������Ʒ��Դ��ţ������룩���ú������ģ���ȡ���������͡���
//			�׿�Ʒ�ƣ�������Ʒ��ʶ��ѯ��Ʒ������Ϲ�ϵ��IM_PR_COMCATEGORYRELA����ȡ�׿�Ʒ�������ֶ�ȡ��ǰ�в���ֶΡ�
			
			Comcategoryrela comcategoryrelaBO = (ComcategoryrelaBO) BOFactory.build(ComcategoryrelaBO.class,user);
			ComcategoryrelaDBParam comcategoryrelaDBParam = new ComcategoryrelaDBParam();
			comcategoryrelaDBParam.setQueryAll(true);
			comcategoryrelaDBParam.setDataOnly(true);
			comcategoryrelaDBParam.set_ne_comid(items[1]);
			DataPackage comcategoryrelaDP = comcategoryrelaBO.doQuery(comcategoryrelaDBParam);
			if( null == comcategoryrelaDP || null == comcategoryrelaDP.getDatas() || comcategoryrelaDP.getDatas().size() == 0)
				throw new JOPException("������Ʒ��ʶ["+items[1]+"]�Ҳ�����Ӧ����Ʒ������Ϲ�ϵ");
			ComcategoryrelaVO comcategoryrelaVO = (ComcategoryrelaVO) ((List)comcategoryrelaDP.getDatas()).get(0);
			Numtyperule numtyperuleBO = (Numtyperule)BOFactory.build(NumtyperuleBO.class,user);
			Long type = numtyperuleBO.doMatchNumber(items[0],typeruleList);//���ݺ���ȡ��������
	log.info(items[0]+"================��������:"+type+" ===========================");
	
			Comressmp bo = (ComressmpBO) BOFactory.build(ComressmpBO.class,user);
			//������Ʒ��Դ��ţ������룩��ѯ�׿���Դ��IM_FX_COMRESSMP����ȡ�׿����ϡ�
			ComressmpDBParam comressmpDBParam=new ComressmpDBParam();
			comressmpDBParam.set_se_comresid(items[0]);
			List<ComressmpVO> comressmpList=bo.doQuery(comressmpDBParam).getDatas();
			boolean isUpdate=false;
			ComressmpVO vo = new ComressmpVO();
			//����׿����ϲ�Ϊ�գ����׿����Ͻ��б��������������Ʒ״̬���ǡ����ۡ������ݣ���ʾ���׿���Դ[XXX]���ڷ�����״̬���ݡ������������
			if(comressmpList!=null && comressmpList.size()>0){
				for(ComressmpVO tempvo:comressmpList){
					if(2!=tempvo.getComstate()){
						throw new JOPException(" ========�׿���Դ["+items[0]+"]���ڷ�����״̬����");
						//throw new JOPException(" ===========��Ʒ��Դ���["+items[0]+"] ��Ʒ��ʶ ["+items[1]+"] ���׿���Դ �Ѿ�����");
					}
				}
				//���׿����϶��α������ж��Ƿ������Ʒ��ʶ��ͬ�����ݣ���������������ݵ��׿���Դ���߼����ϣ�����������޸Ķ�Ӧ��¼���޸ĺ����ݲ��������߼���ע���ж���ʱֻ�޸�������һ�����ɡ�
				for(ComressmpVO tempvo:comressmpList){
					if(tempvo.getComid().longValue()==new Long(items[1]).longValue()){
						vo=tempvo;
						isUpdate=true;
						break;
					}
				}
			}
			
			vo.setNumbertype(type==null ? null:type.toString());
			vo.setComresid(items[0]);
			vo.setComid(new Long(items[1]));
			vo.setBrand(comcategoryrelaVO.getBrand());
			vo.setBatchno(batchno);
			vo.setComstate(Short.valueOf(defaultState));
			vo.setWayid(items[4]);
			vo.setOprcode(items[5]);
			vo.setStarttime(formatDate(items[6],"yyyy-MM-dd HH:mm:SS"));
			vo.setValidperiod(formatDate(items[7],"yyyy-MM-dd HH:mm:SS"));
			vo.setComkeep(formatDate(items[8],"yyyy-MM-dd HH:mm:SS"));
			vo.setComdisc(new Long(items[9]));
			vo.setPrice(new Long(items[10]));
			vo.setComactive(formatDate(items[11],"yyyy-MM-dd HH:mm:ss"));
			vo.setComsource(new Integer(items[12]));
			vo.setStockprice(new Long(items[13]));
			vo.setSimprice(new Long(items[14]));
			vo.setIsopen(new Short(items[15]));
			vo.setIccid(items[16]);
			vo.setBoxnum(items[18]);
			vo.setEntertime(new Date());
			if(isUpdate){
				bo.doUpdate(vo);
			}else{
				bo.doCreate(vo);
			}
					
		}catch(Exception e){
			e.printStackTrace();
//			try{
//				//���ʧ����Ӧ�����������MAP��ֵ
//				if(map.containsKey(batchno+split_sybm+boxnum))
//				map.remove(batchno+split_sybm+boxnum);
//			}catch(Exception ex){
//				log.error(ex);
//			}
			if(null != e.getCause())
				throw new JOPException(e.getCause().getMessage());
			throw new JOPException(e.getMessage());
		}
	}
	
	
	/**
	 * ��ֵ����������
	 * @param line	����������ֶ������&&�ֿ�
	 * @param comrescardState	��ֵ����Ʒ״̬
	 * @param batchno ����
	 * @throws Exception
	 */
	public void doComrescardDeploy(String line,String comrescardState,String batchno) throws Exception{
		// TODO Auto-generated method stub

			String tempLine = line.replaceAll("&&", "|");
			String[] items = StringUtils.splitPreserveAllTokens(tempLine,"|");
			if(items.length != 17){
				throw new Exception("������Ӧ����16������������֮����'&&'�ֿ�");
			}
//			����Э��涨���ֶ�˳��ȡֵ��Ҫ����Ʒ��Դ��š���Ʒ��ʶ����Ʒ���Ρ���Ʒ״̬��������ʶ�ֶηǿ�
//			�����Ϊ�����¼�����ļ�������ԭ����д��XX�ֶ�Ϊ�ա����Ǽ�ʧ�ܼ�¼�������ش�����һ����¼��
			if("".equals(items[0].trim()))
				throw new JOPException("��Ʒ��Դ����ֶ�Ϊ��");
			if("".equals(items[1].trim()))
				throw new JOPException("��Ʒ��ʶ�ֶ�Ϊ��");
			if("".equals(items[3].trim()))
				throw new JOPException("��Ʒ״̬�ֶ�Ϊ��");
			if("".equals(items[4].trim()))
				throw new JOPException("������ʶ�ֶ�Ϊ��");
			ComrescardVO vo = new ComrescardVO();
			vo.setComresid(items[0]);
			vo.setComid(new Long(items[1]));
			vo.setBatchno(batchno);
			vo.setComstate(new Short(comrescardState));
			vo.setWayid(items[4]);
			vo.setOprcode(items[5]);
			vo.setStarttime(formatDate(items[6],"yyyy-MM-dd HH:mm:ss"));
			vo.setValidperiod(formatDate(items[7],"yyyy-MM-dd HH:mm:ss"));
			vo.setComkeep(formatDate(items[8],"yyyy-MM-dd HH:mm:ss"));
			vo.setComdisc(new Long(items[9]));
			vo.setPrice(new Long(items[10]));
			vo.setComactive(formatDate(items[11],"yyyy-MM-dd HH:mm:ss"));
			vo.setComsource(new Integer(items[12]));
			vo.setStockprice(new Long(items[13]));
			vo.setChargepwd(items[14]);
			vo.setPacktype(new Long(items[15]));
			vo.setEntertime(new Date());
			
			Comrescard bo = (ComrescardBO)BOFactory.build(ComrescardBO.class,user);
			bo.doCreate(vo);
//			����ʹ��SPRING AOP ����DOCREATE,DOUPDATE,DOREMOVE����������ϵͳ�Զ���¼��־,���Դ˴�����Ҫ������д��־��
//			try{
//				ComrescardlogVO logVO = new ComrescardlogVO();
//				BeanUtils.copyProperties(logVO,vo);
//				logVO.setOprcode2(operator);
//				logVO.setOptime(new Date());
//				logVO.setSuccess("success");
//				logVO.setOprtype("create");
//				Comrescardlog logBO = (ComrescardlogBO)BOFactory.build(ComrescardlogBO.class,user);
//				logBO.doCreate(logVO);
//			}catch(Exception e){
//				log.error("��ֵ���Ǽ���־����:"+e.getMessage());
//			}
	}
	
	/**
	 * �հ׿���������
	 * @param line	������
	 * @param operator	����Ա
	 * @throws Exception
	 */
	public void doEmptysimDeploy(String line,String simrescardState,String batchno ) throws Exception{
		String tempLine = line.replaceAll("&&", "|");
		String[] items = StringUtils.splitPreserveAllTokens(tempLine,"|");
		if(items.length != 14){
			throw new Exception("������Ӧ����13������������֮����'&&'�ֿ�");
		}
//		Ҫ��տ����кš�������ʶ��״̬�ֶηǿգ����Ϊ�����¼�����ļ�������ԭ����д��XX�ֶ�Ϊ�ա�
//		���Ǽ�ʧ�ܼ�¼�������ش�����һ����¼��
		if("".equals(items[0].trim()))
			throw new Exception("�տ����к��ֶ�Ϊ��");
		if("".equals(items[7].trim()))
			throw new Exception("������ʶ�ֶ�Ϊ��");
		if("".equals(items[10].trim()))
			throw new JOPException("��Ʒ״̬�ֶ�Ϊ��");
		if("".equals(items[12].trim()))
			throw new JOPException("��Ʒ��ʶ�ֶ�Ϊ��");
		EmptysimVO vo = new EmptysimVO(); 
		vo.setEmptyno(items[0]);
		if("".equals(items[1].trim())){
			vo.setCardmill(null);
		}else{
			vo.setCardmill(new Integer(items[1]));
		}
		
		vo.setIccid(items[2]);
		vo.setPukno(items[3]);
		if("".equals(items[4].trim())){
			vo.setBegintime(null);
		}else{
			vo.setBegintime(formatDate(items[4],"yyyy-MM-dd HH:mm:ss"));
		}
		
		if("".equals(items[5].trim())){
			vo.setStoptime(null);
		}else{
			vo.setStoptime(formatDate(items[5],"yyyy-MM-dd HH:mm:ss"));
		}
		
		if("".equals(items[6].trim())){
			vo.setIntime(null);
		}else{
			vo.setIntime(formatDate(items[6],"yyyy-MM-dd HH:mm:ss"));
		}
		vo.setWayid(items[7]);
		vo.setOprcode(items[8]);
		if("".equals(items[9].trim())){
			vo.setSimtype(null);
		}else{
			vo.setSimtype(new Integer(items[9]));
		}
		vo.setUsestate(new Short(simrescardState));
		if("".equals(items[11].trim())){
			vo.setBackup(null);
		}else{
			vo.setBackup(new Short(items[11]));
		}
		vo.setEntertime(new Date());
		vo.setBatchno(batchno);
		vo.setComid(new Long(items[12]));
		
		Emptysim bo = (EmptysimBO)BOFactory.build(EmptysimBO.class,user);
		bo.doCreate(vo);
		
//		����ʹ��SPRING AOP ����DOCREATE,DOUPDATE,DOREMOVE����������ϵͳ�Զ���¼��־,���Դ˴�����Ҫ������д��־��
//		try{
//			EmptysimlogVO logVO = new EmptysimlogVO();
//			BeanUtils.copyProperties(logVO,vo);
//			logVO.setOprcode2(vo.getOprcode());
//			logVO.setOptime(new Date());
//			logVO.setSuccess("success");
//			logVO.setOprtype("create");
//			Emptysimlog logBO = (EmptysimlogBO)BOFactory.build(EmptysimlogBO.class, user);
//			logBO.doCreate(logVO);
//		}catch(Exception e){
//			e.printStackTrace();
//			log.error("�հ�SIM����Դ������"+e.getMessage());
//		}
	}
	private static Date formatDate (String dateString,String format)throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.parse(dateString);
	}
	
	public void doSimStateProcess(String line) throws Exception {
		String[] items = StringUtils.splitPreserveAllTokens(line,"|");
		
		if(items.length !=4 ){
			throw new Exception("������Ӧ����3������������֮����'|'�ֿ� :"+line);
		}
		if(items[0] == null || "".equals(items[0].trim()))
			throw new Exception("�տ����к��ֶ�Ϊ��");
		if(items[1] == null || "".equals(items[1].trim()))
			throw new Exception("״̬�ֶ�Ϊ��");
		if(items[2] == null || "".equals(items[2].trim()))
			throw new Exception("���ʱ���ֶ�Ϊ��");
		
		String format = "yyyy-MM-dd HH:mm:ss";
		Date changetime = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			changetime = dateFormat.parse(items[2]);
		} catch (Exception e) {
			throw new Exception("���ʱ�䣬��ʽ����");
		}
		
		Simnoactinfo simnoactinfoBO = (SimnoactinfoBO)BOFactory.build(SimnoactinfoBO.class, user);
		SimnoactinfoDBParam simnoactinfoDBParam = new SimnoactinfoDBParam();
		simnoactinfoDBParam.set_se_emptyno(items[0]);
		SimnoactinfoVO simnoactinfoVO = null;
		DataPackage dp = simnoactinfoBO.doQuery(simnoactinfoDBParam);
		if(dp.getRowCount() > 0){
			simnoactinfoVO = (SimnoactinfoVO)dp.getDatas().get(0);
		}
		String emptyno = items[0];
		Date creattime = new Date();
		String memo = "�հ�SIM���ļ�����";
		String state = items[1];
		
		Short isactive = Short.parseShort(items[1]);
		
		if("5".equals(items[1]) || "10".equals(items[1])){
			state = "AVAILABLE";
			isactive = Short.parseShort("0");
		}
		if("2".equals(items[1])){
			state = "USED";
			isactive = Short.parseShort("1");
		}
		if("8".equals(items[1])){
			state = "CANCEL";
			isactive = Short.parseShort("2");
		}
		
		if(simnoactinfoVO == null){
			simnoactinfoVO = new SimnoactinfoVO();
			simnoactinfoVO.setChangetime(changetime);
			simnoactinfoVO.setCreattime(creattime);
			simnoactinfoVO.setEmptyno(emptyno);
			simnoactinfoVO.setState(state);
			simnoactinfoVO.setMemo(memo);
			
			simnoactinfoBO.doCreate(simnoactinfoVO);
		}else{
			if(changetime.getTime() > simnoactinfoVO.getChangetime().getTime()){
				simnoactinfoVO.setChangetime(changetime);
				simnoactinfoVO.setCreattime(creattime);
				simnoactinfoVO.setEmptyno(emptyno);
				simnoactinfoVO.setState(state);
				simnoactinfoVO.setMemo(memo);
				
				simnoactinfoBO.doUpdate(simnoactinfoVO);
			}
		}
		
		//���º�������Դ
		Partnerres partnerresBO = (PartnerresBO)BOFactory.build(PartnerresBO.class, user);
		PartnerresDBParam partnerresDBParam = new PartnerresDBParam();
		partnerresDBParam.set_ne_comid(emptyno);
		DataPackage dp1 = partnerresBO.doQuery(partnerresDBParam);
		if(dp1.getRowCount() > 0){
			PartnerresVO partnerresVO = (PartnerresVO)dp1.getDatas().get(0);
			partnerresVO.setIsactive(isactive);
			
			partnerresBO.doUpdate(partnerresVO);
		}
	}
}
