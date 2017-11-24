package com.sunrise.boss.delegate.fee.qsmanage.common;

import java.io.Serializable;
import java.util.HashMap;

import com.sunrise.boss.business.fee.qsmanage.common.control.QsCommonControl;
import com.sunrise.boss.business.fee.qsmanage.common.control.QsCommonControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.ui.commons.User;

public class QsCommonDelegate {
	
    private Class voClass;
    private QsCommonControl control;


    public QsCommonDelegate(Class voClazz) throws
            Exception {
        this.voClass = voClazz;

        try {
			control = (QsCommonControl) ControlFactory.build(QsCommonControlBean.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
        if (control == null) {
            throw new Exception(this.getClass() + " initial failure");
        }
    }

    public Object doFindByPk(Serializable pk, User user) throws Exception {
        if (null == pk || null == user) {
            throw new IllegalArgumentException();
        } else {
            return control.doFindByPk(pk, voClass, user);
        }
    }

    //--------------------for qs log --------------------------
    public Object doUpdateWithQsLog(Object vo, User user)  throws Exception {
        if (null == vo || null == user) {
            throw new IllegalArgumentException();
        } else {
            return control.doUpdateWithQsLog(vo, voClass, user);
        }
	}

	public void doRemoveByPkWithQsLog(Serializable pk, User user) throws Exception {
        if (null == pk || null == user) {
            throw new IllegalArgumentException();
        } else {
            control.doRemoveByPkWithQsLog(pk, voClass, user);
        }
	}

	public Object doCreateWithQsLog(Object vo, Long matchid, String chgreason, boolean isbatch, User user)  throws Exception {
        if (null == vo || null == user) {
            throw new IllegalArgumentException();
        } else {
            return control.doCreateWithQsLog(vo, voClass, matchid, chgreason, isbatch, user);
        }
	}

	public void doRemoveByVoWithQsLog(Serializable vo, User user)  throws Exception {
		if (null == vo || null == user) {
            throw new IllegalArgumentException();
        } else {
            control.doRemoveByVoWithQsLog(vo, voClass, user);
        }
	}
	
	 public void doBatch(HashMap map, Long matchid, String chgreason, User user) throws Exception{
		 control.doBatch(map, matchid, chgreason, user);
	 }
    
}
