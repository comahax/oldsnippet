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
			//查出状态不为已结束的记录
			Advinfo advinfo = (Advinfo)BOFactory.build(AdvinfoBO.class, user);
			AdvinfoDBParam param = new AdvinfoDBParam();
			param.set_pagesize("0");
			param.set_nne_state(AdvinfoConstant.STATE_END);
			DataPackage dp = advinfo.doQuery(param);
			
			//将当前日期大于等于发布日期的记录状态更新为已发布；将当前日期大于等于发布有效日期，并且发布有效期不为空的记录状态更新为已关闭。
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
				
				//将当前日期大于等于发布日期.对于并且发布日期不为空的，状态为未发布的记录，更新状态为已发布
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
				
				//将当前日期大于等于发布有效日期，并且发布有效期不为空的记录状态更新为已关闭
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
