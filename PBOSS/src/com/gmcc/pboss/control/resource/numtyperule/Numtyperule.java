/**
 * auto-generated code
 * Sat Sep 05 16:02:03 CST 2009
 */
package com.gmcc.pboss.control.resource.numtyperule;

import java.util.List;

import com.gmcc.pboss.business.resource.numtypedef.NumtypedefDBParam;
import com.gmcc.pboss.business.resource.numtyperule.NumtyperuleDBParam;
import com.gmcc.pboss.business.resource.numtyperule.NumtyperuleVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: NumtyperuleVO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Numtyperule extends AbstractControl {

    public DataPackage doQuery(NumtypedefDBParam params) throws Exception;
    
    public DataPackage doQueryByNameSql(String nameSql,NumtyperuleDBParam params)throws Exception;
    
    /**
	 * ��������ƥ��
	 * @param number	����
	 * @param numbertyperules	������ʽ�б�
	 * @return
	 * @throws Exception
	 */
	public Long doMatchNumber(String number,List<NumtyperuleVO> numbertyperules)throws Exception;
	
	/**
	 * ����ƥ�䷽��
	 * @param number
	 * @return
	 * @throws Exception
	 */
	public Long doMatchNumber(String number)throws Exception;
	
	/**
	 * ��ȡ���������ʽ
	 * @param params
	 * @return
	 * @throws Exception
	 */
		public List<NumtyperuleVO> doGetNumtyperuleList(NumtyperuleDBParam params) throws Exception;
}
