/**
 * 
 */
package com.sunrise.boss.ui.cms.adjustment;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

/**
 * @author cx-yz
 *
 */
public class BatchAdjustmentForm extends UploadFileForm {
	public BatchAdjustmentForm(){
		this.setCheckFormat(new BatchAdjustmentCheck());
	}
}