/**
* auto-generated code
* Sat Jul 29 16:54:43 CST 2006
*/
package com.sunrise.exam.business.example.employee;

import com.sunrise.exam.business.example.company.persistent.CompanyVO;
import com.sunrise.exam.business.example.employee.control.Employee;
import com.sunrise.exam.business.example.employee.control.EmployeeBO;
import com.sunrise.exam.business.example.employee.persistent.EmployeeDBParam;
import com.sunrise.exam.business.example.employee.persistent.EmployeeVO;
import com.sunrise.jop.infrastructure.cache.CacheFactory;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.test.jop.BOTestCase;

import junit.textui.TestRunner;

import java.util.Iterator;


/**
 * <p>Title: CompanyControlTest</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author jinbo
 * @version 1.0
 */
public class EmployeeBOTest extends BOTestCase {

    private Employee bo;
    private static final String DATAFILE = "com/sunrise/exam/business/example/employee/Employee.data.xml";
    
    public EmployeeBOTest() throws Exception {
        super("EmployeeBOTest");
        bo = (Employee) BOFactory.build(EmployeeBO.class, getUser());
    }
    
    public static void main(String[] args) {
		TestRunner.run(EmployeeBOTest.class);
	}
	protected void setUp() throws Exception {
		super.setUp();		
	}

	protected void tearDown() throws Exception {
		super.tearDown();		
	}

	/**
	 * 新增,删除,修改测试
	 */
	public void testCRUD() throws Exception{
		EmployeeVO vo = new EmployeeVO();
        vo.setEmpname("新员工");
        vo.setAddress("广州大道南368");
        vo.setBank("招商银行");
        vo.setAccount("893313441200435553");
        vo = bo.doCreate(vo);
        log.info("新增记录ID=" + vo.getId());

		vo.setEmpname("老员工");
        vo = bo.doUpdate(vo);
        log.info("emp_name=" + vo.getEmpname());

        EmployeeDBParam param = new EmployeeDBParam();
        param.set_sk_empname("员工");
        DataPackage data = bo.doQuery(param);
        log.info("count =" + data.getRowCount());

		bo.doRemoveByVO(vo);
        log.info("delete...");
	}

    public void testUnionQuery() throws Exception{
        EmployeeDBParam params = new EmployeeDBParam();
        params.set_ne_companyid(new Long("3"));
        try {
            DataPackage dp = bo.doUnionQuery1(params);
            assertNotNull(dp);
            assertNotNull(dp.getDatas());
            assertTrue(dp.getDatas().size() > 0);
    		Iterator iter = dp.getDatas().iterator();
    		while( iter != null && iter.hasNext() ) {
    			Object[] objects=(Object[])iter.next();
    			CompanyVO vo1 = (CompanyVO)objects[0];
    			EmployeeVO vo2 = (EmployeeVO)objects[1];

    			System.out.println("companyid = " + vo2.getCompanyid());
    			System.out.println("companyname = " + vo1.getCompanyname());
    			System.out.println("empname = " + vo2.getEmpname());
    		}
        } catch (Exception e) {
            log.error(e);
            fail(e.getMessage());
        }

    }

    public void testDoQuery() throws Exception {
        insertFileIntoDb(DATAFILE);
        EmployeeDBParam params = new EmployeeDBParam();
        params.getQueryConditions().put("_sk_empname", "员工");
        try {
            DataPackage dp = bo.doQuery(params);
            assertNotNull(dp);
            log.info("testDoQuery count =" + dp.getRowCount());
            assertNotNull(dp.getDatas());
            assertTrue(dp.getDatas().size() > 0);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            fail(e.getMessage());
        } finally {
            deleteFileFromDb(DATAFILE);
        }
    }

    protected void finalize() {
    	CacheFactory.logStatistics();
    }
}
