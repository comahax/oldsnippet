/**
 * auto-generated code
 * Tue Sep 29 10:11:13 CST 2009
 */
package com.gmcc.pboss.control.communication.questionnaire;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.business.communication.advaffix.AdvaffixVO;
import com.gmcc.pboss.business.communication.questionnaire.QuestionnaireDBParam;
import com.gmcc.pboss.business.communication.questionnaire.QuestionnaireVO;
import com.gmcc.pboss.business.communication.questionnaire.QuestionnaireVOHelper;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Questionnaire </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Questionnaire extends AbstractControl {
    public QuestionnaireVO doCreate(QuestionnaireVO vo) throws Exception;

    public void doRemoveByVO(QuestionnaireVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public QuestionnaireVO doUpdate(QuestionnaireVO vo) throws Exception;

    public QuestionnaireVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(QuestionnaireDBParam params) throws Exception;

    public Long doQueSave(QuestionnaireVOHelper helper, File[] docs, String[] docFileNames, Boolean createFlag) throws Exception;

    public String doGetObjinfo(Long advinfoid, String desttype)throws Exception;
    
    //通过advinfoid查询对应附件列表
	public List<AdvaffixVO> doGetAdvaffixByAdvinfoid(Long advinfoid)throws Exception;
	//通过advinfoid查询对应回复列表
	public DataPackage doGetReplyByAdvinfoid(Long advinfoid)throws Exception;
	
    public void doQueDelete(DBQueryParam dbparam)throws Exception;
}
