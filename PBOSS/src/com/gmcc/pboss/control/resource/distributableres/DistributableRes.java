package com.gmcc.pboss.control.resource.distributableres;

import com.gmcc.pboss.business.channel.cntycompany.CntycompanyVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.resource.distributableres.DistributableResDBParam;
import com.gmcc.pboss.business.resource.distributableres.DistributableResVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

public interface DistributableRes extends AbstractControl {


	public DistributableResVO 	doGetDistributableRes(CntycompanyVO cntVO,ComcategoryrelaVO comcatVO) throws Exception;

}
