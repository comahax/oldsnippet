/**
* auto-generated code
* Sat Jul 29 16:54:43 CST 2006
*/
package com.sunrise.exam.business.example.company;


import com.sunrise.exam.business.example.company.control.Company;
import com.sunrise.exam.business.example.company.control.CompanyBO;
import com.sunrise.exam.business.example.company.persistent.CompanyDBParam;
import com.sunrise.exam.business.example.company.persistent.CompanyVO;
import com.sunrise.exam.web.common.ExamUser;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.test.jop.BOTestCase;

import junit.textui.TestRunner;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>Title: CompanyBOTest</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CompanyBOTest extends BOTestCase {

    private Company bo;
    
    private static final String DATAFILE = "com/sunrise/exam/business/example/company/Company.data.xml";

    protected static final Logger log = Logger.getLogger(CompanyBOTest.class);

    public CompanyBOTest() throws Exception {
        super("CompanyBOTest");

//        this.schema ="JOP2";  
      this.schema ="NGCRM_ZH_KF";  
        bo = (Company) BOFactory.build(CompanyBO.class, getUser());
    }
    
    public static void main(String[] args) {
		TestRunner.run(CompanyBOTest.class);
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
		CompanyVO vo = new CompanyVO();
        vo.setCompanyname("999公司");
        vo.setShortname("999");
        vo.setCreatedate(new Date());
        vo.setCapital(new Long(1000000));
        vo.setAddress("广州大道南368");
        vo.setBank("中国人民很行");
        vo.setAccount("893313441200435553");
        vo.setState(new Byte("1"));
		vo = bo.doCreate(vo);
        log.info("新增记录ID="+vo.getId());

		vo.setShortname("99残");
        vo = bo.doUpdate(vo);
        log.info("shorname="+vo.getShortname());

        CompanyDBParam param = new CompanyDBParam();
        param.set_sk_companyname("999");
        DataPackage data = bo.doQuery(param);
        log.info("count =" + data.getRowCount());

        bo.doRemoveByVO(vo);
        log.info("delete...");
	}

    /**
     * 查询测试,用于示例测试数据的准备和清理
     * @throws Exception
     */
    public void testDoQuery() throws Exception {
        insertFileIntoDb(DATAFILE);
        CompanyDBParam params = new CompanyDBParam();
        params.getQueryConditions().put("_sk_companyname", "999");
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

	public void testDoCreate() throws Exception {
        CompanyVO vo = new CompanyVO();
        try {
        	vo.setId(new Long(999));
            vo.setCompanyname("999公司");
        	vo.setShortname("999");
        	vo.setCreatedate(new Date());
        	vo.setCapital(new Long(1000000));
        	vo.setAddress("广州大道南368");
            vo.setState(new Byte("9"));
            vo = bo.doCreate(vo);
            log.info("新增记录ID="+vo.getId());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            fail();
        }
    }

    public void testDoFindByPk() throws Exception {
        insertFileIntoDb(DATAFILE);
        java.io.Serializable pk = new Long(1);
        try {
            CompanyVO vo = bo.doFindByPk(pk);
            log.info("doFindByPk companyname=" + vo.getCompanyname());
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            fail();
        } finally {
            deleteFileFromDb(DATAFILE);
        }
    }
     
    /**
     * 用于示例查询指定字段 与自定义SQL的使用
     */
	public void testDoQueryCompanyCapical() {
		try {
			CompanyDBParam param =  new CompanyDBParam();
			param.setSelectFieldsString("capital");
			List list = bo.doQueryCompanyCapicals(param);

			log.info("data " + list.size());
			for (int i = 0; i < list.size(); i++) {
				log.info(list.get(i) +" " + list.get(i).getClass());

			}
			assertTrue(list.size() > 0);
		} catch (Exception e) {
			 log.error(e.getMessage(),e);
            fail(e.getMessage());
		}

	}

    /**
     * 用于示例查询指定字段与自定义SQL的使用
     */
	public void testDoQueryCompanyNames() {
		try {
			CompanyDBParam param =  new CompanyDBParam();
			param.setSelectFieldsString("companyname");
			
			List list = bo.doQueryCompanyNames(param);
			
			log.info("data " + list.size());
			for (int i = 0; i < list.size(); i++) {
				log.info(list.get(i) +" " + list.get(i).getClass());
			}
			assertTrue(list.size() > 0);
		} catch (Exception e) {
			 log.error(e.getMessage(),e);
            fail(e.getMessage());
		}
	}

    /**
     * 用于示例查询指定字段,setSelectFieldsUseVOType与自定义SQL的使用
     */
	public void testDoQueryIdAndAccounts() {
		try {
			CompanyDBParam param =  new CompanyDBParam();

			param.setSelectFieldsString("id,account,addr,sss ");

			Map fieldClass = new HashMap();
			fieldClass.put("sss", Short.class);
			param.setSelectFieldsClass(fieldClass);
			param.setSelectFieldsUseVOType(true);

			List list = bo.doQueryIdAndAccounts(param);

			log.info("data " + list.size());
			for (int i = 0; i < list.size(); i++) {
				log.info(list.get(i) + " " + list.get(i).getClass());

				log.info( ReflectionToStringBuilder.toString(list.get(i)));
//				Map map = (Map)list.get(i);
//
//				if( map.get("id")!=null) System.out.println(" id " + map.get("id").getClass());
//				if(map.get("account")!=null) System.out.println(" account " + map.get("account").getClass());
//				if(map.get("sss")!=null) System.out.println(" sss " + map.get("sss").getClass());

			}
			assertTrue(list.size() > 0);
		} catch (Exception e) {
			 log.error(e.getMessage(),e);
            fail(e.getMessage());
		}
	}

}
