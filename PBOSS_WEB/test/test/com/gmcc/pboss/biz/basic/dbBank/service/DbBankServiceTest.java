package test.com.gmcc.pboss.biz.basic.dbBank.service;

import java.util.Map;

import com.gmcc.pboss.biz.basic.dictItem.service.DictItemService;
import com.gmcc.pboss.biz.basic.dictItem.support.DictItemQueryParameter;
import com.gmcc.pboss.biz.info.node.service.DbBankService;
import com.gmcc.pboss.biz.info.node.support.DbBankQueryParameter;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;

import test.com.gmcc.pboss.common.BaseTest;

/**
 * 类购销划扣银行标识Service测试
 * @author Jimmy
 *
 */
public class DbBankServiceTest extends BaseTest {
	
	private DbBankService dbBankService; 

	/**
	 * @return the dbBankService
	 */
	public DbBankService getDbBankService() {
		return dbBankService;
	}

	/**
	 * @param dbBankService the dbBankService to set
	 */
	public void setDbBankService(DbBankService dbBankService) {
		this.dbBankService = dbBankService;
	}

	public QueryParameter getParameter() {
//		parameter = ;
		//parameter.setName(getQ());

		return new DbBankQueryParameter();
	}

	public void testQuery() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		System.out.println("::"+ dbBankService.getNameByCode("B11"));
		Map c =(Map)dbBankService.query(null, getParameter()).getRetObject();
		System.out.println(c.size());
	}

}
