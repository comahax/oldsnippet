package com.gmcc.pboss.control.sales.bgcontrol.BookResRelease;

import com.gmcc.pboss.business.sales.smpextramid.SmpextramidVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface BookResRelease extends AbstractControl {

	/**
     * <pre>
     * 根据批次和包号更新商品包表
     * 修改套卡资源抽取中间表记录状态为0-失效
     * </pre>
     * @param batchno
     * @param boxno
     * @param seVo
     * @throws Exception
     */
    public void doUpdateComPackAndExtra(String batchno,String boxno,SmpextramidVO seVo) throws Exception;
    
    /**
     * 预定资源释放之入口方法
     * @throws Exception
     */
    public void doProcess() throws Exception;
}
