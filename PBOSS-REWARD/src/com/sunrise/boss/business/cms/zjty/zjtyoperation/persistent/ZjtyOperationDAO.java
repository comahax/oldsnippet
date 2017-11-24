/**
* auto-generated code
* Thu Oct 23 11:41:56 CST 2008
*/
package com.sunrise.boss.business.cms.zjty.zjtyoperation.persistent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;

/**
 * <p>Title: ZjtyOperationDAO</p>
 * <p>Description: Data Access Object for ZjtyOperationVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class ZjtyOperationDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public ZjtyOperationDAO(){
        super(ZjtyOperationVO.class);
    }
    
    /**
     * 节省开销,使用业务树不再需要数量,只需要数据
     * @param params
     * @param type
     * @return
     * @throws Exception
     */
    
    public DataPackage queryForTree(Object params) throws Exception {
		// TODO Auto-generated method stub
		return super.query(params, super.QUERY_TYPE_DATA);
	}

    public List doQueryupper(ZjtyOperationListVO params) throws Exception {
		Session session = SessionUtil.currentSession(this.getDbFlag());
		Query query = session.getNamedQuery("zjty.operation.queryupper");
		query.setString("id", params.get_se_opnid());
		query.setString("name", "%" + params.get_sk_name() + "%");
		List list = query.list();
		return list;
	}

	public String getFifthStr(String parentid) throws Exception {
		Session session = SessionUtil.currentSession(getDbFlag());
		Connection conn = session.connection();
		try {
			Statement stmt = conn.createStatement();
			//视乎后五位的规则
			//String sql = "select lpad(count(opnid)+1,5,'0')  from common.ch_zjty_operation where isbusi=1"
			String sql = "select lpad(count(opnid)+1,5,'0')  from common.ch_zjty_operation where isbusi=1 and parentid="+parentid;
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				String reStr = rs.getString(1);
				return reStr;
			} else {
				throw new Exception("SQL 语句查询出错!");
			}
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		} finally {

		}
	}
}
