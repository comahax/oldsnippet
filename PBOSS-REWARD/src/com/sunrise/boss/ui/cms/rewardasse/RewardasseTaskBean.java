package com.sunrise.boss.ui.cms.rewardasse;

import org.apache.commons.beanutils.BeanUtils;

import com.sunrise.boss.business.cms.rewardasse.persistent.RewardasseVO;
import com.sunrise.boss.delegate.cms.rewardasse.RewardasseDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class RewardasseTaskBean extends BaseBatchTaskBean {
	private RewardasseDelegate delegate;
	boolean cando = false;
	public RewardasseTaskBean() throws Exception{
		// TODO Auto-generated constructor stub
		delegate = new RewardasseDelegate();
		super.setBatchName("������𿼺�ϵ������������־��ѯ");
		super.setWriteLog(true);
	}
	protected String doStart() {
		return "������𿼺�ϵ������������ \r\n";
	}
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO=new ResultVO();
		String[] content = StringSplit.split(line, "|");
		String[] rewardasstype = RewardassebatchCheck.rewardasstype;
		try{
			RewardasseVO rewardasseVO=new RewardasseVO();
			rewardasseVO.setWayid(content[0]);
			rewardasseVO.setAssemonth(content[1]);
			rewardasseVO.setRewardtype(Integer.valueOf(content[2]));
			rewardasseVO.setAssegrade(Float.valueOf(content[3]));
			if(content.length>4){
				rewardasseVO.setMemo(content[4]);
			}
			RewardasseVO queryvo = (RewardasseVO)BeanUtils.cloneBean(rewardasseVO);
			if(delegate.doFindByPk(queryvo, user)==null){
				//��������������Ϊ99�Ĵ���취
				if(rewardasseVO.getRewardtype().intValue()==99){
					cando = delegate.doQueryRewardtype(rewardasseVO.getRewardtype(), user);
					if(cando){
						for(int i=0;i<rewardasstype.length-1;i++){
							rewardasseVO.setRewardtype(Integer.valueOf(rewardasstype[i]));
							BeanUtils.copyProperties(queryvo, rewardasseVO);
							if(delegate.doFindByPk(queryvo, user)==null){
								delegate.doCreate(rewardasseVO, user);
							}else{
								delegate.doUpdate(rewardasseVO, user);
							}
						}
						line = rowCount + "   " + line + "    �����ɹ�";
					}else{
						line = rowCount + "   " + line + "    ����ʧ��:" + "��������, �������������͵ĳ�𿼺�ϵ��";
						resultVO.setInfo(line);
						resultVO.setOk(false);
						return resultVO;
					}
				}else{
					cando = delegate.doQueryRewardtype(rewardasseVO.getRewardtype(), user);
					if(cando){
						delegate.doCreate(rewardasseVO, user);
						line = rowCount + "   " + line + "    �����ɹ�";
					}else{
						line = rowCount + "   " + line + "    ����ʧ��:" + "��������, �������������͵ĳ�𿼺�ϵ��";
						resultVO.setInfo(line);
						resultVO.setOk(false);
						return resultVO;
					}
				}
			}else{
				BeanUtils.copyProperties(queryvo, rewardasseVO);
				cando = delegate.doQueryRewardtype(queryvo.getRewardtype(), user);
				if(cando){
					delegate.doUpdate(queryvo, user);
					line = rowCount + "   " + line + "    ���³ɹ�";
				}else{
					line = rowCount + "   " + line + "    ����ʧ��:" + "��������, �������������͵ĳ�𿼺�ϵ��";
					resultVO.setInfo(line);
					resultVO.setOk(false);
					return resultVO;
				}
			}
			
			resultVO.setInfo(line);
			resultVO.setOk(true);
			
		}catch(Exception e){
			line = rowCount + "   " + line + "    ������Ϣ:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
