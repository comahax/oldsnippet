package com.gmcc.pboss.control.sales.bgcontrol.BookResRelease;

import com.gmcc.pboss.business.sales.smpextramid.SmpextramidVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface BookResRelease extends AbstractControl {

	/**
     * <pre>
     * �������κͰ��Ÿ�����Ʒ����
     * �޸��׿���Դ��ȡ�м���¼״̬Ϊ0-ʧЧ
     * </pre>
     * @param batchno
     * @param boxno
     * @param seVo
     * @throws Exception
     */
    public void doUpdateComPackAndExtra(String batchno,String boxno,SmpextramidVO seVo) throws Exception;
    
    /**
     * Ԥ����Դ�ͷ�֮��ڷ���
     * @throws Exception
     */
    public void doProcess() throws Exception;
}
