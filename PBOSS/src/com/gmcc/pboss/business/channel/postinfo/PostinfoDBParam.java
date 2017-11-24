/**
 * auto-generated code
 * Wed Jul 01 17:28:49 CST 2009
 */
package com.gmcc.pboss.business.channel.postinfo;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: PostinfoDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class PostinfoDBParam extends DBQueryParam {
    private String _ne_postid;
    private String _ne_postkind;
	/**
     * @return Returns the _ne_postid.
     */
    public String get_ne_postid() {
        return this._ne_postid;
    }
    /**
     * @param _sk_companyname The _ne_postid to set.
     */
    public void set_ne_postid(String _ne_postid) {
        this._ne_postid = _ne_postid;
    }
	public String get_ne_postkind() {
		return _ne_postkind;
	}
	public void set_ne_postkind(String _ne_postkind) {
		this._ne_postkind = _ne_postkind;
	}

}
