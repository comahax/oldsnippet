/**
 * 
 */
package com.sunrise.boss.ui.cms.dcord;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

/**
 * @author cx-yz
 *
 */
public class BatchDcordForm extends UploadFileForm {
	public BatchDcordForm(){
		this.setCheckFormat(new BatchDcordCheck());
	}
}
