package com.gmcc.pboss.web.reward.stype;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.reward.ltype.LtypeDBParam;
import com.gmcc.pboss.business.reward.ltype.LtypeVO;
import com.gmcc.pboss.business.reward.stype.StypeDBParam;
import com.gmcc.pboss.business.reward.stype.StypeVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.reward.ltype.Ltype;
import com.gmcc.pboss.control.reward.ltype.LtypeBO;
import com.gmcc.pboss.control.reward.stype.Stype;
import com.gmcc.pboss.control.reward.stype.StypeBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class StypeTaskBean extends BaseBatchTaskBean{
	public StypeTaskBean() throws Exception {
		super.setBatchName("���й�˾�������Ϲ�����"); 
		super.setOprtype("����");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "ҵ������|������|���С��|  \r\n";
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
 		ResultVO resultVO = new ResultVO();
		try {
			String content[] = StringUtils.splitPreserveAllTokens(line, "|");
			Stype stype = (Stype) BOFactory.build(StypeBO.class, user);
			Ltype ltype = (Ltype) BOFactory.build(LtypeBO.class, user);
			
			String cityname = Code2NameUtils.code2Name("CITYNAME", user.getCityid(),user.getCityid());
			String tempLtype = content[1].substring(0,2).trim(); 
			String tempStype = content[2].substring(0,2).trim(); 
			if(!tempLtype.equals(cityname)){
				content[1] = cityname+content[1];//ҵ��������ӵ���ǰ׺������
			}
			if(!tempStype.equals(cityname)){
				content[2] = cityname+content[2];//����ҵ��С�����ӵ���ǰ׺��������ݵ��еġ�30Ԫ��������𡱣����STYPE������30Ԫ��������𡱣���
			}
			
			// ҵ���������ڡ�����ҵ�񡱣���ѯ�������CH_CW_ LTYPE��
			//��Ӧ�õ��й���CITYID��Ӧ�ĳ������Ƿ�ﵽ5��������ﵽ5����
			//�򱣴�ʧ�ܣ���ʾ������ҵ����и��Ի������಻�ܳ����������
			//LtypeVO vo = null;
			if("����ҵ��".equals(content[0].trim())){
			    LtypeDBParam params = new LtypeDBParam();
			    //params.set_se_optype(content[0].trim());
			    params.set_se_ltype(content[1].trim());
			    params.set_se_cityid(user.getCityid());
			    DataPackage dp = ltype.doQuery(params);
			    if(dp !=null){
				    if(dp.getDatas().size() >= 5){
					    throw new Exception("����ҵ����и��Ի������಻�ܳ������");
				    }
			    }
			}
			
			//�ж��Ƿ������ͬ��С��
			StypeDBParam stypeparams = new StypeDBParam();
			stypeparams.set_se_stype(content[2].trim());
			stypeparams.set_se_cityid(user.getCityid());
			DataPackage stypedp = stype.doQuery(stypeparams);
			if(stypedp.getDatas().size() > 0){
				StypeVO svo = (StypeVO) stypedp.getDatas().get(0);
				if(svo.getCityid().equals("GD") || svo.getCityid().equals(user.getCityid())){
				    throw new Exception("��" + content[2].trim() + "���Ѵ��ڸó��С��");
				}
			}
			
			//�ж��Ƿ������ͬ�Ĵ���
			LtypeDBParam ltypeparams = new LtypeDBParam();
			ltypeparams.set_se_optype(content[0].trim());
			ltypeparams.set_se_ltype(content[1].trim());
			ltypeparams.set_se_cityid(user.getCityid());
			DataPackage Ltypedp = ltype.doQuery(ltypeparams);
			//LtypeVO LtypeparamsVo = null;
			if(Ltypedp.getDatas().size() == 0){
				//�����಻���ڳ�������л��߹����������У������һ����¼���������
				LtypeVO ltypeVO = new LtypeVO();
				ltypeVO.setOptype(content[0].trim());
				ltypeVO.setLtype(content[1].trim());
				ltypeVO.setCityid(user.getCityid());
				ltypeVO = ltype.doCreate(ltypeVO);
				//BeanUtils.copyProperties(getForm(), ltypeVO);
			}
			if(stypedp.getDatas().size() == 0){
			    StypeVO stypeVO = new StypeVO();
			    stypeVO.setLtype(content[1].trim());
			    stypeVO.setStype(content[2].trim());
			    stypeVO.setCityid(user.getCityid());
			    stypeVO = stype.doCreate(stypeVO);
			}else{
				throw new Exception("��" + content[2].trim() + "���Ѵ��ڸó��С��");
			}
			
			line = rowCount + "|"+line+"|" + "����ɹ�" + "|";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) {
			line = rowCount + "|" + line + "|" + "����ԭ��:" + e.getMessage() + "|";
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
