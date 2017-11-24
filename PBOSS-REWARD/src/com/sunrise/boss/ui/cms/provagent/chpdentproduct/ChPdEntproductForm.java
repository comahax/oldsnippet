/**
* auto-generated code
* Tue Sep 03 17:48:46 CST 2013
*/
package com.sunrise.boss.ui.cms.provagent.chpdentproduct;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.provagent.chpdentproduct.persistent.ChPdEntproductVO;

/**
 * <p>Title: ChPdEntproductForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class ChPdEntproductForm extends BaseActionForm {

    private java.lang.String prodid;
    private java.lang.String prodname;
    private java.lang.String category;
    private java.lang.String subcategory;

    private String _se_prodid;
    private String _sk_prodname;
    private String _se_category;
    private String _se_subcategory;

    public java.lang.String getProdid(){
        return prodid;
    }

    public void setProdid(java.lang.String prodid){
        this.prodid = prodid;
    }
    public java.lang.String getProdname(){
        return prodname;
    }

    public void setProdname(java.lang.String prodname){
        this.prodname = prodname;
    }
    public java.lang.String getCategory(){
        return category;
    }

    public void setCategory(java.lang.String category){
        this.category = category;
    }
    public java.lang.String getSubcategory(){
        return subcategory;
    }

    public void setSubcategory(java.lang.String subcategory){
        this.subcategory = subcategory;
    }

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
