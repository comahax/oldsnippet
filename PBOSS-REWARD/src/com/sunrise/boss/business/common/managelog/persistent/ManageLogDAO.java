/**
* auto-generated code
* Fri Aug 11 17:18:05 CST 2006
*/
package com.sunrise.boss.business.common.managelog.persistent;
import java.sql.Timestamp;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.ui.commons.User;


/**
 * <p>Title: ManagelogDAO</p>
 * <p>Description: Data Access Object for ManagelogVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author xqy
 * @version 1.0
 */
public class ManageLogDAO extends BaseDAO {

    /**
     * default constructor
     */
    public ManageLogDAO(){
        super(ManageLogVO.class);
    }
    
    /*
     * manageLog:   记录管理操作日志
     * 
     * user			操作员对象
     * oprtype		操作的表名或者实体名
     * action		操作类型,OperAction类中有定义
     * voOld		修改前实体,如果操作类型是新增则填null
     * voNew		修改后实体,如果操作类型是删除则填null
     * state		操作状态,OperState类中有定义
     */
	public void manageLog(User user, String oprtype, String action,
            Object voOld, Object voNew, Integer state) throws Exception  {
				ToStringStyle style = ManageLogToStringStyle.MANAGE_LOG_STYLE;
				
				ManageLogVO vo = new ManageLogVO();
				vo.setOprcode(user.getOpercode());
				vo.setOprtime(new Timestamp(System.currentTimeMillis()));
				vo.setOprtype(GetSimpleName(oprtype));
				vo.setOpraction(action);
				vo.setOprcon1(voOld == null ? "" :
				      ReflectionToStringBuilder.toString(voOld, style));
				vo.setOprcon2(voNew == null ? "" :
				      ReflectionToStringBuilder.toString(voNew, style));
				vo.setOprstate(state);
				
				super.create(vo);
	}  
	public void manageLog(User user, Object obj, String action,
            Object voOld, Object voNew, Integer state) throws Exception  {		
		manageLog(user, obj.getClass().getName(), action, voOld, voNew, state);
	}
	
	private String GetSimpleName(String name) {
		String[] tmp = name.split("\\.");
		return tmp[tmp.length-1];
	}
}
