package test.com.gmcc.pboss.biz.basic.dictItem.service;

import java.util.Map;

import com.gmcc.pboss.biz.basic.dictItem.service.DictItemService;
import com.gmcc.pboss.biz.basic.dictItem.support.DictItemQueryParameter;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;

import test.com.gmcc.pboss.common.BaseTest;

/**
 * 商品种类Service测试
 * @author Jimmy
 *
 */
public class DictItemServiceTest extends BaseTest {

	private DictItemService dictItemService;

	/**
	 * @return the dictItemService
	 */
	public DictItemService getDictItemService() {
		return dictItemService;
	}
	/**
	 * @param dictItemService the dictItemService to set
	 */
	public void setDictItemService(DictItemService dictItemService) {
		this.dictItemService = dictItemService;
	}

	public QueryParameter getParameter() {
//		parameter = ;
		//parameter.setName(getQ());

		return new DictItemQueryParameter();
	}

	public void testQuery() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		System.out.println("::"+ dictItemService.getNameByCode("55DG"));
		Map c =(Map)dictItemService.query(null, getParameter()).getRetObject();
		System.out.println(c.size());
	}

}
