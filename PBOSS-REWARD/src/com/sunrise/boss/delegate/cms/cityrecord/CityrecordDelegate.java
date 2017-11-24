/**
* auto-generated code
* Thu Dec 15 07:12:07 GMT 2011
*/
package com.sunrise.boss.delegate.cms.cityrecord;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.cityrecord.persistent.CityrecordVO;
import com.sunrise.boss.business.cms.cityrecord.persistent.CityrecordListVO;
import com.sunrise.boss.business.cms.cityrecord.control.CityrecordControlBean;
import com.sunrise.boss.business.cms.cityrecord.control.CityrecordControl;

import java.io.Serializable;

/**
 * <p>Title: CityrecordDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CityrecordDelegate {

    private static CityrecordControl control;

    public CityrecordDelegate() throws Exception {
        control = (CityrecordControl) ControlFactory.build(CityrecordControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public CityrecordVO doCreate(CityrecordVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(CityrecordVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public CityrecordVO doUpdate(CityrecordVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public CityrecordVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (CityrecordVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(CityrecordListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public DataPackage doThreeQuery(CityrecordListVO params, User user)
    	throws Exception {
    	return control.doThreeQuery(params, user);
    }
    public DataPackage doThreeQueryEhance(CityrecordListVO params, User user)
		throws Exception {
		return control.doThreeQueryEhance(params, user);
    }
    public DataPackage doThreeQueryEhanceCount(CityrecordListVO params, User user) throws Exception{
    	return control.doThreeQueryEhanceCount(params, user);
    }
    
    public void doIssue(String[] pkValueArray, User user)
		throws Exception {
    	control.doIssue(pkValueArray, user);
    }

    public String[] doIssue(CityrecordListVO params, User user)
	throws Exception {
    	return control.doIssue(params, user);
}
    public void doIssuecheck(CityrecordVO params, User user)
		throws Exception {
		control.doIssuecheck(params, user);
    }
    public void doAllissue(CityrecordListVO params, User user)
		throws Exception {
    	control.doAllissue(params, user);
    }
    public void doOnlyissue(CityrecordListVO params, User user)
	throws Exception {
	control.doOnlyissue(params, user);
}
    public DataPackage doListstat(CityrecordListVO params, User user)
    	throws Exception {
//    	return control.doListstat(params, user);
    	return control.doListstatenhance(params, user);
    }
    public DataPackage doListstatcount(CityrecordListVO params, User user)throws Exception {
    	return control.doListstatenhancecount(params, user);
    }
    public DataPackage doListstatexcel(CityrecordListVO params, User user)
		throws Exception {
	//	return control.doListstat(params, user);
		return control.doListstatenhanceexcel(params, user);
	}
    public int doAllConfirm(CityrecordListVO params, User user)
		throws Exception {
    	return control.doAllConfirm(params, user);
    }
    
    public DataPackage doListdetail(CityrecordListVO params,String opnid2,String rewardtype,String oprmonth,String isflag, User user)
		throws Exception {
    	return control.doListdetail(params,opnid2,rewardtype,oprmonth,isflag, user);
    }
    
    public int doConfirmone(CityrecordListVO params,String opnid2,String rewardtype,String oprmonth, User user)
		throws Exception{
    	return control.doConfirmone( params, opnid2, rewardtype, oprmonth,  user);
    }
    public DataPackage doQueryDetail(CityrecordListVO params, User user)
    throws Exception {
    	return control.doQueryDetail(params, user);
    }
    
	/**
	 * 单笔删除，该方法不再使用
	 * 20120914 将该功能从[地市酬金明细上传管理]迁移到[酬金明细数据查询]菜单
	 */
//    public void doDeletepart(CityrecordListVO params, User user)   throws Exception {
//    	control.doDeletepart(params, user);
//    }
    public int doDeleteall(CityrecordListVO params, User user)
    throws Exception {
    	return control.doDeleteall(params, user);
    }

    public DataPackage doOnlysum(CityrecordListVO params, User user)
	throws Exception {
//	return control.doListstat(params, user);
	return control.doOnlysum(params, user);
}
    
    public DataPackage doQueryexceldetail(CityrecordListVO params, User user)
	throws Exception {
    	return control.doQueryexceldetail(params, user);
    }
    
    public int updateIsflagByDcordid(Short isflag, Long dcordid, User user) throws Exception {
    	return control.updateIsflagByDcordid(isflag, dcordid, user);
    }
}
