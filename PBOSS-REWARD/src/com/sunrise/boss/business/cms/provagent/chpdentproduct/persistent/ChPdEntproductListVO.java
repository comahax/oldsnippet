/**
* auto-generated code
* Tue Sep 03 17:48:46 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdentproduct.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChPdEntproductListVO</p>
 * <p>Description: Query Params Object for ChPdEntproductDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class ChPdEntproductListVO extends BaseListVO {
    private String _se_prodid;
    private String _sk_prodname;
    private String _se_category;
    private String _se_subcategory;

    public String get_se_prodid(){
        return _se_prodid;
    }

    public void set_se_prodid(String _se_prodid){
        this._se_prodid = _se_prodid;
    }
    public String get_sk_prodname(){
        return _sk_prodname;
    }

    public void set_sk_prodname(String _sk_prodname){
        this._sk_prodname = _sk_prodname;
    }
    public String get_se_category(){
        return _se_category;
    }

    public void set_se_category(String _se_category){
        this._se_category = _se_category;
    }
    public String get_se_subcategory(){
        return _se_subcategory;
    }

    public void set_se_subcategory(String _se_subcategory){
        this._se_subcategory = _se_subcategory;
    }

}
