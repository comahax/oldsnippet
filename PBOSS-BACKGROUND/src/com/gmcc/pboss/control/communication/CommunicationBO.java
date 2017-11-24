/**
 * auto-generated code
 * Wed Nov 18 17:19:05 CST 2009
 */
package com.gmcc.pboss.control.communication;

import java.util.Date;
import java.util.List;

import com.gmcc.pboss.business.communication.advinfo.AdvinfoDBParam;
import com.gmcc.pboss.business.communication.advinfo.AdvinfoVO;
import com.gmcc.pboss.control.communication.advinfo.Advinfo;
import com.gmcc.pboss.control.communication.advinfo.AdvinfoBO;
import com.gmcc.pboss.control.communication.advinfo.AdvinfoConstant;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrderreqBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CommunicationBO extends AbstractControlBean implements
		Communication {

	public void doProcess() throws Exception{
		try {
			//���״̬��Ϊ�ѽ����ļ�¼
			Advinfo advinfo = (Advinfo)BOFactory.build(AdvinfoBO.class, user);
			AdvinfoDBParam param = new AdvinfoDBParam();
			param.set_pagesize("0");
			param.set_nne_state(AdvinfoConstant.STATE_END);
			DataPackage dp = advinfo.doQuery(param);
			
			//����ǰ���ڴ��ڵ��ڷ������ڵļ�¼״̬����Ϊ�ѷ���������ǰ���ڴ��ڵ��ڷ�����Ч���ڣ����ҷ�����Ч�ڲ�Ϊ�յļ�¼״̬����Ϊ�ѹرա�
			List<AdvinfoVO> advinfoList = (List<AdvinfoVO>)dp.getDatas();
			Date endDate = null;
			Date releaseDate = null;
			Date now = new Date();
			
			String endDateStr = new String();
			String releaseDateStr = new String();
			String nowStr = new String();
			for(int i=0; i<advinfoList.size(); i++)
			{
				AdvinfoVO advinfoVO = advinfoList.get(i); 
				
				//����ǰ���ڴ��ڵ��ڷ�������.���ڲ��ҷ������ڲ�Ϊ�յģ�״̬Ϊδ�����ļ�¼������״̬Ϊ�ѷ���
				if(null!=advinfoVO.getState()&&String.valueOf(advinfoVO.getState()).equals(AdvinfoConstant.STATE_UNPUBLISHED))
				{
					releaseDate = advinfoVO.getReleasetime();
					if(releaseDate!=null)
					{
						releaseDateStr = PublicUtils.formatUtilDate(releaseDate, "yyyyMMdd");
						nowStr = PublicUtils.formatUtilDate(now, "yyyyMMdd");
						if(nowStr.compareTo(releaseDateStr)>=0)
						{
							advinfoVO.setState(Short.valueOf(AdvinfoConstant.STATE_PUBLISHED));
							advinfo.doUpdate(advinfoVO);
						}
					}
				}
				
				//����ǰ���ڴ��ڵ��ڷ�����Ч���ڣ����ҷ�����Ч�ڲ�Ϊ�յļ�¼״̬����Ϊ�ѹر�
				endDate = advinfoVO.getEnddate();
				if(endDate!=null)
				{
					endDateStr = PublicUtils.formatUtilDate(endDate, "yyyyMMdd");
					nowStr = PublicUtils.formatUtilDate(now, "yyyyMMdd");
					if(nowStr.compareTo(endDateStr)>0)
					{
						advinfoVO.setState(Short.valueOf(AdvinfoConstant.STATE_END));
						advinfo.doUpdate(advinfoVO);
					}
				}
			}
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}
}
