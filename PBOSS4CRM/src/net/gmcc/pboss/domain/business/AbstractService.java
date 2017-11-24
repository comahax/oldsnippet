package net.gmcc.pboss.domain.business;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.gmcc.pboss.common.dao.IBaseDao;
import net.gmcc.pboss.comswebservice.Reqheader;
import net.gmcc.pboss.comswebservice.Rspheader;
import net.gmcc.pboss.pboss4crmservice.Msgreqheader;
import net.gmcc.pboss.pboss4crmservice.Msgrspheader;
//import com.gmcc.hsc.webservice.ResultHeader;
//import com.gmcc.hsc.webservice.domain.additional.syslog.Syslog;
//import com.gmcc.hsc.webservice.domain.business.syshelper.DBHelper;
//import com.gmcc.hsc.webservice.domain.model.common.ProxylogVO;
//import com.gmcc.hsc.webservice.domain.model.subproductsyn.ChangeproductVO;
import net.gmcc.pboss.domain.additional.exception.RequestMessageException;
import net.gmcc.pboss.domain.model.operator.OperatorVO;
import net.gmcc.pboss.utils.LoggerUtil;
import net.gmcc.pboss.utils.ServiceUtil;
import net.gmcc.pboss.utils.StringUtil;

/**
 * 实现Service的抽象类，子类必须继承该类
 */
@Transactional
public abstract class AbstractService {

	private static final Logger log = Logger.getLogger(AbstractService.class);

	@Autowired
	protected IBaseDao dao; // 存取数据库操作

	// SPRING中的BEAN为单例模式,不能用局部变量,TRANSID改用与线程相关的线程局部变量来处理.
	//public ThreadLocal<String> transIdLocal = new ThreadLocal<String>();
	//本次调用业务标识：process_code-seq_req，用于日志输出
	public ThreadLocal<String> processCode = new ThreadLocal<String>();
	// public String transId = "";//流水号

	protected static boolean testFlag = true;

	/**
	 * 
	 * 检查判断流水号是否(存在)冲突.
	 * 
	 * @param transid
	 * @throws Exception
	 */
//	public void checkTransID(String transid) throws Exception{
//		List<ProxylogVO> list = null;
//		try {
//			StringBuffer hql = new StringBuffer(" from ProxylogVO ")
//			.append(" where transid = :transid ");// unique index
//			
//			Query query = dao.createQuery(hql.toString())
//			.setString("transid", transid);
//			
//			list = query.list();
//		} catch (Exception e) {
//			log.info(transIdLocal.get()+"获取流水日志信息出错."+e.getMessage());
//		}
//		if(null != list && list.size() > 0){
//			throw new Exception("流水号 ( "+transid+" ) 冲突.");
//		}
//	}
	
	
	/**
	 * 对批量数据对象进行入库
	 * 
	 * 需要"写事务"的方法必须加上@Transactional标注， 而且必须是public， 并且方法的执行时间越短越好
	 * 
	 */
	@Transactional
	public void executeAllDatas(Map<String, Object> objectMap) throws Exception {
		String operType = "";
		Object tmpObject = null;
		if (null != objectMap && objectMap.size() > 0) {
			try {//先执行删除和更新操作.
				Collection<?> deleteObjectMap = (Collection<?>) objectMap.get(OprType.DELETE);
				if (null != deleteObjectMap) {
					operType = OprType.DELETE;
					log.info(processCode.get() + "开始删除数据,数据量为" + deleteObjectMap.size());
					for (Iterator<?> it = deleteObjectMap.iterator(); it.hasNext();) {
						long startTime = System.currentTimeMillis();
						tmpObject = it.next();
						dao.delete(tmpObject);
						dao.flush();
						long endTime = System.currentTimeMillis();
						log.info(processCode.get() + tmpObject.getClass().getSimpleName()+"删除数据使用时间为：" + (endTime-startTime) + "ms");
					}
					// dao.deleteAll(deleteObjectMap);
					// log.info(transId + "数据删除成功. ");
				}

				Collection<?> updateObjectMap = (Collection<?>) objectMap.get(OprType.UPDATE);
				if (null != updateObjectMap) {
					operType = OprType.UPDATE;
					log.info(processCode.get() + "开始更新数据,数据量为" + updateObjectMap.size());
					for (Iterator<?> it = updateObjectMap.iterator(); it.hasNext();) {
						long startTime = System.currentTimeMillis();
						tmpObject = it.next();
						dao.update(tmpObject);
						dao.flush();
						long endTime = System.currentTimeMillis();
						log.info(processCode.get() + tmpObject.getClass().getSimpleName()+"更新数据使用时间为：" + (endTime-startTime)+ "ms");
					}
					// dao.saveOrUpdateAll(updateObjectMap);
					// log.info(transId + "数据更新成功. ");
				}
				
				Collection<?> insertObjectMap = (Collection<?>) objectMap.get(OprType.CREATE);
				if (null != insertObjectMap) {
					operType = OprType.CREATE;
					log.info(processCode.get() + "开始插入数据,数据量为" + insertObjectMap.size());
					// SAVEORUPDATEALL
					// 并不能反映实际情况(已存在的不能再插入,应该报错),改用多个save操作;下面UPDATE和DELETE也一样
					for (Iterator<?> it = insertObjectMap.iterator(); it.hasNext();) {
						long startTime = System.currentTimeMillis();
						tmpObject = it.next();
						dao.save(tmpObject);
						dao.flush();// 提交事务
						long endTime = System.currentTimeMillis();
						log.info(processCode.get() + tmpObject.getClass().getSimpleName()+"插入数据使用时间为：" + (endTime-startTime) + "ms");
					}
					// dao.saveOrUpdateAll(insertObjectMap);
					// log.info(transId + "数据入库成功. ");//ri,测试的鸟人,测些没用的东西
				}
				
				log.info(processCode.get() + "数据库操作完成");
			} catch (Exception e) {
				String clazzName = tmpObject.getClass().toString();
				log.info(processCode.get() + clazzName);
				//测试时打印异常信息，实际生产换进可注释掉
				e.printStackTrace();
				String subClazzName = clazzName.substring(clazzName.lastIndexOf(".")+1);
				// 异常处理
				String errMsg = dealExecuteException(e, operType);
				// 简化客户端异常显示
				throw new Exception("数据库操作失败(进行事务回滚)!" + subClazzName + errMsg);
			}
		} else {
			log.info(processCode.get() + "数据集合为空,不进行数据库操作.");
		}
	}

	/**
	 * 对单个数据对象进行入库
	 */
	@Transactional
	public void executeSingleData(String operType, Object object) throws Exception {
		if (null == object) {
			log.info(processCode.get() + "数据为空,不进行数据库操作.");
		} else {
			try {//先执行删除和更新操作.
				if (OprType.DELETE.equals(operType)) {
					log.info(processCode.get() + "开始删除数据:"+object.getClass().getSimpleName());
					dao.delete(object);
					dao.flush();
					// log.info(processCode.get() + "数据删除成功. ");
				}else if (OprType.UPDATE.equals(operType)) {
					log.info(processCode.get() + "开始更新数据:"+object.getClass().getSimpleName());
					dao.update(object);
					dao.flush();
					// log.info(processCode.get() + "数据更新成功. ");
				} else if (OprType.CREATE.equals(operType)) {
					log.info(processCode.get() + "开始插入数据:"+object.getClass().getSimpleName());
					dao.save(object);
					dao.flush();
					// log.info(processCode.get() + "数据入库成功. ");
				} else {
					log.info(processCode.get() + "数据操作类型: " + operType + " 无法识别,对象 " + object.getClass() + " 数据无法入库!");
				}
				dao.flush();
				log.info(processCode.get() + "数据库操作完成");
			} catch (Exception e) {
				log.info(processCode.get() + object.getClass());
				//测试时打印异常信息，实际生产换进可注释掉
				e.printStackTrace();
				// 异常处理				
				String errMsg = dealExecuteException(e, operType);

				// 简化客户端异常显示
				throw new Exception("数据库操作出错(进行事务回滚)!" + errMsg);
			}
		}
	}
	
	/**
	 * 记录业务日志
	 */	
	//@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@Transactional
	public void executeBusinessLog(Object object) throws Exception {
		if(null==object){
			log.info(processCode.get()+"\t数据为空,不进行数据库操作");
		}else{
			try{
				log.info(processCode.get()+"日志操作：开始插入数据:"+object.getClass().getSimpleName());
				dao.save(object);
				dao.flush();
				log.info(processCode.get()+"日志操作：数据库操作完成");
			}catch(Exception e){
				log.info(processCode.get() + object.getClass());
				//测试时打印异常信息，实际生产换进可注释掉
				e.printStackTrace();
				// 异常处理				
				String errMsg = dealExecuteException(e, null);

				// 简化客户端异常显示
				throw new Exception("数据库操作出错(进行事务回滚)!" + errMsg);
			}
		}
	}

	/**
	 * 尝试解释数据入库出现的异常,对以下几个常见的错误进行解释. SHIT
	 * 都不想处理了,相当蛋疼,很多诡异的异常,每次都要新加判断.哪天把这段代码砍了.
	 * 
	 * IdentifierGenerationException 表主键的不能为空. SQLGrammarException
	 * SQL执行出错,请确定库表已经建立,并且数据对象VO和库表对应. constraint [null] 库表字段定义为非空(not
	 * null)的数据不能为空. PK_HSC_ 主键冲突,数据插入失败. NonUniqueObjectException
	 * 冲突:入库对象中存在主键值重复 UnresolvableObjectException (REFRESH)数据不存在.
	 * StaleObjectStateException (删除,更新)数据不存在. UncategorizedSQLException
	 * 不能获取数据库连接. UncategorizedSQLException ORA-12899
	 * 数据入库出错,("COMMON"."HSC_MK_CUSTMAILBILL"."ISMAILLEVELBILL")字段数值太大.
	 * DataException 数据入库出错,入库数据与库表字段定义长度不相符.(数字太大)
	 *  ORA-01407 定义字段不能为空.
	 */
	public String dealExecuteException(Exception e, String operType) {
		log.info(processCode.get() + "数据库异常: " + e.toString());
		String errMsg = null;
		if (e.toString().contains("NonUniqueObjectException")) {
			errMsg = "待入库对象中存在主键冲突.";
		} else if (e.toString().contains("IdentifierGenerationException")) {
			log.info(processCode.get() + e.toString());// 主键检查会有逻辑判断,一般不会报这个错误.
			errMsg = "表主键不能为空.";
		} else if (e.toString().contains("sequence") && e.toString().indexOf("_SEQ") > 0) {
			//这里需要使用Pattern Matcher详细处理
			int startindex = e.toString().lastIndexOf(' ', e.toString().indexOf("_SEQ"));
			String sequence = e.toString().substring(startindex+1, e.toString().indexOf(".nextval"));
			log.info(processCode.get() + sequence);// 内部暴露表序列名
			errMsg = "SQL执行出错,请确定库表SEQUENCE已经建立";
		} else if (e.toString().contains("SQLGrammarException") ) {//&& e.toString().indexOf("HSC_") > 0
			//这里需要使用Pattern Matcher详细处理
			//String tableName = e.toString().substring(e.toString().indexOf("HSC_"), e.toString().indexOf(" ("));
			log.info(processCode.get() + e.toString());// 内部暴露表名 tableName
			errMsg = "SQL执行出错,请确定库表已经建立,并且数据对象VO和库表结构一致.";
		} else if (e.toString().contains("constraint [null]") || e.toString().contains("ORA-01407")) {
			if (null == (errMsg = paraseStraceTrace(e))) {
				errMsg = "数据已存在,数据插入失败.";// 主键冲突
			}
		} else if (e.toString().contains("UnresolvableObjectException")) {
			errMsg = "数据不存在.";
		} else if (e.toString().contains("StaleObjectStateException")) {
			if (OprType.UPDATE.equals(operType)) {
				errMsg = "数据更新失败,待更新数据不存在.";
			} else if (OprType.DELETE.equals(operType)) {
				errMsg = "数据删除失败,待删除数据不存在.";
			}
		} else if (e.toString().contains("ORA-12899")) {
			String column = e.toString().substring(e.toString().lastIndexOf(" \"") + 1, e.toString().lastIndexOf("\"") + 1);
			log.info(processCode.get() + column);// 内部暴露表名和字段
			errMsg = "数据入库出错,字段值太大.";
		} else if (e.toString().contains("DataException")) {// - -!
			// 纠结的ORACLE,和上面同样的错误,异常还不一样.
			errMsg = "数据入库出错,入库数据与库表字段定义长度不相符.";
		} else if (e.toString().contains("UncategorizedSQLException")) {
			log.info(e.toString());
			String eStr = e.toString();
			if (eStr.contains("Connection reset")) {
				errMsg = " 连接已被重置,不能获取数据库连接.";
			} else {
				errMsg = " 不能获取数据库连接,请确认数据库已经启动并连接正常.";
			}
		}

		if (null != errMsg) {
			log.info(processCode.get() + errMsg);
		} else {
			errMsg = "未知数据库异常!";
		}
		return errMsg;
	}

	/**
	 * 解释堆栈内容 找出不能为空的表字段名
	 * 
	 * @param e
	 * @return
	 */
	public String paraseStraceTrace(Exception e) {
		String retStr = null;
		try {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			BufferedReader bufferedReader = new BufferedReader(new StringReader(stringWriter.toString()));
			String line = bufferedReader.readLine();
			while (line != null) {
				if (line.contains("ORA-") && line.indexOf("\".\"") > 0) { // 尝试解释StackTrace的内容.
					//ORA-01407: cannot update ("COMMON". #"HSC_SUBS_SUBSCRIBER"."SERVNUMBER"# ) to NULL
					retStr = "表字段(" + line.substring(line.indexOf("\".\"") + 2, line.lastIndexOf("\"") + 1) + ")不能为空.";
					break;
				}
				line = bufferedReader.readLine();
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			log.info(processCode.get() + "堆栈内容解释出错." + e1.getMessage());
		}
		return retStr;
	}

	/**
	 * 没有显式调用事务回滚的方法,让dao出错来触发事务.CICS返回错误后调用
	 * 
	 */
//	public void rollBack() {
//		try {
//			DBHelper dbHelper = new DBHelper(dao, "");
//			dao.save(dbHelper);
//			dao.flush();
//		} catch (DataAccessException e) {
//			//
//		}

//	}

	public void insertDbLog(Msgreqheader reqHeader, String tradeType, String orderID, Date changedate,Map<String, Object> objectMap) throws Exception {
//		Syslog syslog = ServiceUtil.ac.getBean(Syslog.class);
//		Object tmpObject = null;
//		if (null != objectMap && objectMap.size() > 0) {
//			try {
//				Collection<?> insertObjectMap = (Collection<?>) objectMap.get("I");
//				if (null != insertObjectMap) {
//					for (Iterator<?> it = insertObjectMap.iterator(); it.hasNext();) {
//						tmpObject = it.next();
//						syslog.insertSysVoPkLog(reqHeader, tradeType, orderID, changedate,tmpObject,dao);
//					}
//				}
//				
//				Collection<?> updateObjectMap = (Collection<?>) objectMap.get("U");
//				if (null != updateObjectMap) {
//					for (Iterator<?> it = updateObjectMap.iterator(); it.hasNext();) {
//						tmpObject = it.next();
//						syslog.insertSysVoPkLog(reqHeader, tradeType, orderID, changedate,tmpObject,dao);
//					}
//				}
//				
//				Collection<?> deleteObjectMap = (Collection<?>) objectMap.get("D");
//				if (null != deleteObjectMap) {
//					for (Iterator<?> it = deleteObjectMap.iterator(); it.hasNext();) {
//						tmpObject = it.next();
//						syslog.insertSysVoPkLog(reqHeader, tradeType, orderID, changedate,tmpObject,dao);
//					}
//				}
//				log.info(transIdLocal.get() + "记录流水表成功.");
//			} catch (Exception e) {
//				//记流水异常不影响正常业务
//				//log.info(transIdLocal.get() + "记录流水表失败." + e.getMessage());
//			}
//		} 
	}
	
}
