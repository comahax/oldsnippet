package com.gmcc.pboss.control.resource.wayrcstat;

import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;

public interface Wayrcstat extends AbstractControl {

	DataPackage doQueryreal(DBQueryParam param) throws Exception;

	public DataPackage doQueryhistory(DBQueryParam param) throws Exception;

}
