package com.sunrise.boss.delegate.common;

import java.io.Serializable;

import com.sunrise.boss.business.common.CommonControl;
import com.sunrise.boss.business.common.CommonControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

public class CommonDelegate {
    private Class voClass;
    private Class logVoClass;

    private CommonControl control;

    public CommonDelegate() throws Exception {
        this(null);
    }

    public CommonDelegate(Class voClazz) throws Exception {
        this(voClazz, null);
    }

    public CommonDelegate(Class voClazz, Class logVoClazz) throws
            Exception {
        this.voClass = voClazz;
        this.logVoClass = logVoClazz;

        try {
			control = (CommonControl) ControlFactory.build(CommonControlBean.class);
		} catch (Exception e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
        if (control == null) {
            throw new Exception(this.getClass() + " initial failure");
        }
    }

    /**
     * ---------------------------------------------------------------
     */
    public Object doCreate(Object vo, User user) throws Exception {
        if (null == vo || null == user) {
            throw new IllegalArgumentException();
        } else {
            return control.doCreate(vo, voClass, user);
        }
    }

    public void doRemoveByPK(Serializable pk, User user) throws Exception {
        if (null == pk || null == user) {
            throw new IllegalArgumentException();
        } else {
            control.doRemoveByPK(pk, voClass, user);
        }
    }

    public void doRemoveByVO(Object vo, User user) throws Exception {
        if (null == vo || null == user) {
            throw new IllegalArgumentException();
        } else {
            control.doRemoveByVO(vo, voClass, user);
        }
    }

    public Object doUpdate(Object vo, User user) throws Exception {
        if (null == vo || null == user) {
            throw new IllegalArgumentException();
        } else {
            return control.doUpdate(vo, voClass, user);
        }
    }

    public Object doFindByPk(Serializable pk, User user) throws Exception {
        if (null == pk || null == user) {
            throw new IllegalArgumentException();
        } else {
            return control.doFindByPk(pk, voClass, user);
        }
    }

    public DataPackage doQuery(Object params, User user) throws Exception {
        if (null == params || null == user) {
            throw new IllegalArgumentException();
        } else {
            return control.doQuery(params, voClass, user);
        }
    }
    /**
     * get data list exuclde the data total
     * @param params
     * @param user
     * @return
     * @throws Exception
     */
    public DataPackage doQuery(Object params, User user,boolean getRcdCount) throws Exception {
        if (null == params || null == user) {
            throw new IllegalArgumentException();
        } else {
            return control.doQuery(params, voClass, user,getRcdCount);
        }
    }

    public int doCount(Object params, User user) throws Exception{
        return control.doCount(voClass, params, user);
    }

//代码迁移注：暂时关闭，需要时打开
//  public DataPackage doQuery2(Class voClass1, Class voClass2,
//                              Object listVO1, Object listVO2,
//                              String joinProp1, String joinProp2,
//                              int type, User user) throws
//      Exception {
//    BaseDAO basedao = new BaseDAO(Object.class);
//    com.sunrise.commons.util.dbutil.ComQuery comq = new com.sunrise.commons.
//        util.dbutil.ComQuery();
//    // 定义要查询的表
//    comq.addTable(voClass1);
//    comq.addTable(voClass2);
//    // 定义表间的关系
//    comq.addRelation(voClass1, joinProp1, voClass2,
//                     joinProp2);
//    // 定义查询条件，分页的信息放在第一个条件里
//    comq.addParam(voClass1, listVO1);
//    comq.addParam(voClass2, listVO2);
//
//    // 定义结果的排序,按查询条件listVO1、listVO2进行排序，默认为降序
//    BaseListVO baseListVO1 = (BaseListVO) listVO1;
//    BaseListVO baseListVO2 = (BaseListVO) listVO2;
//    if (baseListVO1 != null && baseListVO1.get_orderby() != null) {
//      comq.addOrderby(voClass1, baseListVO1.get_orderby(),isAsc(baseListVO1.get_desc()));
//    }
//    if (baseListVO2 != null && baseListVO2.get_orderby() != null) {
//      comq.addOrderby(voClass1, baseListVO2.get_orderby(),isAsc(baseListVO2.get_desc()));
//    }
//    DataPackage dp = basedao.queryEx(comq, type);
//    return dp;
//  }

    /**
     * 升降排序,默认
     */
    private boolean isAsc(String asc) {
        if (asc == null || asc.equals("")) {
            return true; //默认升序
        }
        if (asc.equals("1")) {//降序
            return false;
        } else {
            return true;
        }
    }

    public Object doUpdateWithModifyPK(Object oldVO, Object newVO,
                                       User user) throws Exception {
        if (null == oldVO || null == newVO || null == user) {
            throw new IllegalArgumentException();
        } else {
            return control.doUpdateWithModifyPK(oldVO, newVO, voClass, user);
        }

    }

    //--------------------for log --------------------------
    public Object doCreate(Object vo, Object logvo, User user) throws
            Exception {
        if (null == logVoClass) {
            throw new IllegalArgumentException();
        }
        if (null == vo || null == user || null == logvo) {
            throw new IllegalArgumentException();
        } else {
            return control.doCreate(vo, voClass, logvo, logVoClass, user);
        }
    }

    public void doRemoveByPK(Serializable pk, Object logvo, User user) throws
            Exception {
        if (null == logVoClass) {
            throw new IllegalArgumentException();
        }
        if (null == pk || null == user || null == logvo) {
            throw new IllegalArgumentException();
        } else {
            control.doRemoveByPK(pk, voClass, logvo, logVoClass, user);
        }
    }

    public void doRemoveByVO(Object vo, Object logvo, User user) throws
            Exception {
        if (null == logVoClass) {
            throw new IllegalArgumentException();
        }
        if (null == vo || null == user || null == logvo) {
            throw new IllegalArgumentException();
        } else {
            control.doRemoveByVO(vo, voClass, logvo, logVoClass, user);
        }
    }

    public Object doUpdate(Object vo, Object logvo, User user) throws
            Exception {
        if (null == logVoClass) {
            throw new IllegalArgumentException();
        }
        if (null == vo || null == user || null == logvo) {
            throw new IllegalArgumentException();
        } else {
            return control.doUpdate(vo, voClass, logvo, logVoClass, user);
        }
    }

    public Object doUpdate2(Object vo, Object oldLogvo, Object newLogvo,
                            User user) throws Exception {
        if (null == logVoClass) {
            throw new IllegalArgumentException();
        }

        if (null == vo || null == user || null == oldLogvo || null == newLogvo) {
            throw new IllegalArgumentException();
        } else {
            return control.doUpdate2(vo, voClass, oldLogvo, newLogvo, logVoClass,
            		user);
        }
    }

    //--------------------for manage log --------------------------
    public Object doUpdateWithManageLog(Object vo, User user)  throws Exception {
        if (null == vo || null == user) {
            throw new IllegalArgumentException();
        } else {
            return control.doUpdateWithManageLog(vo, voClass, user);
        }
	}

	public void doRemoveByPkWithManageLog(Serializable pk, User user) throws Exception {
        if (null == pk || null == user) {
            throw new IllegalArgumentException();
        } else {
            control.doRemoveByPkWithManageLog(pk, voClass, user);
        }
	}

	public Object doCreateWithManageLog(Object vo, User user)  throws Exception {
        if (null == vo || null == user) {
            throw new IllegalArgumentException();
        } else {
            return control.doCreateWithManageLog(vo, voClass, user);
        }
	}

	public void doRemoveByVoWithManageLog(Serializable vo, User user)  throws Exception {
		if (null == vo || null == user) {
            throw new IllegalArgumentException();
        } else {
            control.doRemoveByVoWithManageLog(vo, voClass, user);
        }
	}
	
	public Long getSequence(String sequence, User user)  throws Exception {
		if (sequence.equals("") || null == user) {
            throw new IllegalArgumentException();
        } else {
            return control.getSequence(sequence, user);
        }
	}
    
}
