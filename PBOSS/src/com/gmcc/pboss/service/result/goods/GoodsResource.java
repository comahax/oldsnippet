/**
 * 
 */
package com.gmcc.pboss.service.result.goods;

import java.util.List;

import com.gmcc.pboss.service.result.RetResult;

/**
 * 商品资源结果类
 * 
 * @author hbm
 */
public class GoodsResource extends RetResult {
	static final public int OVER_QUERY_LIMIT_TIMES = 3; //(返回码常量)查询失败，查询次数超过限制
	
	private List goodsList;//List里面的元素是<SCPackage>类型

	public List getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List goodsList) {
		this.goodsList = goodsList;
	}

}
