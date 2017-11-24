package test.com.gmcc.pboss.biz.basic.goods.service;

import javax.servlet.http.HttpSession;

import org.springframework.mock.web.MockHttpSession;

import com.gmcc.pboss.biz.basic.goods.service.GoodsRemote;
import com.gmcc.pboss.biz.basic.goods.supper.GoodsListQueryParameter;
import com.gmcc.pboss.biz.basic.node.service.WayApplyService;
import com.gmcc.pboss.biz.basic.node.support.WayApplyQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.model.wayapply.ChPwWayapply;
import com.gmcc.pboss.service.WebSiteService;
import com.gmcc.pboss.service.result.RetResult;
import com.gmcc.pboss.service.result.goods.BookBasicInfo;
import com.gmcc.pboss.service.result.goods.GoodsInfo;
import com.gmcc.pboss.service.result.goods.GoodsResource;

import test.com.gmcc.pboss.common.BaseTest;

/**
 * 远程接口测试类
 * @author vaio
 *
 */
public class GoodsRemoveServiceTest extends BaseTest {
	/**
	 * server
	 */
	private GoodsRemote goodsRemote;
	
	private WebSiteService httpWebRemote;
	
	/**
	 * @return the goodsRemote
	 */
	public GoodsRemote getGoodsRemote() {
		return goodsRemote;
	}
	/**
	 * @param goodsRemote the goodsRemote to set
	 */
	public void setGoodsRemote(GoodsRemote goodsRemote) {
		this.goodsRemote = goodsRemote;
	}
	/**
	 * @return the httpWebRemote
	 */
	public WebSiteService getHttpWebRemote() {
		return httpWebRemote;
	}
	/**
	 * @param httpWebRemote the httpWebRemote to set
	 */
	public void setHttpWebRemote(WebSiteService httpWebRemote) {
		this.httpWebRemote = httpWebRemote;
	}
	/**
	 * 接口1：bookQualificationCheck
	 */
	public void testRemove1() {
		//WebSiteService接口
//		WebSiteService service = (WebSiteService) context.getBean("httpWebSiteService");
		//调用hello方法
		RetResult result = httpWebRemote.bookQualificationCheck("CH_2323");
		
		System.out.println("::"+result.getRetCode());
		if (result.getRetCode() == RetResult.ERROR){
			System.out.println("ERROR by:" + result.getMessage());
		}
	}
	/**
	 * 接口2：queryBookBasicInfo
	 */
	public void testRemove2() {
		//WebSiteService接口
//		WebSiteService service = (WebSiteService) context.getBean("httpWebSiteService");
		//调用hello方法
		BookBasicInfo result = httpWebRemote.queryBookBasicInfo("TDZS04T01");
		if (result.getRetCode()!=BookBasicInfo.SUCCESS){
			System.out.println("["+ result.getRetCode() +"]:"+ result.getMessage());
		}else{
			System.out.println("::"+result.getRetCode());
			System.out.println(result.getBookInfos().size());
		}
		if (result.getRetCode() == RetResult.ERROR){
			System.out.println("ERROR by:" + result.getMessage());
		}
	}
	/**
	 * 接口3：queryGoodsPriceRadix
	 */
	public void testRemove3() {
		//WebSiteService接口
//		WebSiteService service = (WebSiteService) context.getBean("httpWebSiteService");
		//调用hello方法
		GoodsInfo result = httpWebRemote.queryGoodsPriceRadix("TDZS04T01","55DG");
		if (result.getRetCode()!=BookBasicInfo.SUCCESS){
			System.out.println("["+ result.getRetCode() +"]:"+ result.getMessage());
		}else{
			System.out.println("::"+result.getRetCode());
			System.out.println(result.getPrice());
		}
		if (result.getRetCode() == RetResult.ERROR){
			System.out.println("ERROR by:" + result.getMessage());
		}
	}

	/**
	 * 接口4：getGoodsResource
	 */
	public void testRemove4() {
		//WebSiteService接口
//		WebSiteService service = (WebSiteService) context.getBean("httpWebSiteService");
		//调用hello方法
		GoodsResource result = httpWebRemote.getGoodsResource("TDZS04T01","55DG",20);
		if (result.getRetCode()!=BookBasicInfo.SUCCESS){
			System.out.println("["+ result.getRetCode() +"]:"+ result.getMessage());
		}else{
			System.out.println("::"+result.getRetCode()+" :返回条数:");
			System.out.println(result.getGoodsList().size());
		}
	}
	//测试query
	public void testQuery() {
		//WebSiteService接口
//		WebSiteService service = (WebSiteService) context.getBean("httpWebSiteService");
		//调用hello方法
		LoginMember member = new LoginMember();
		member.setCityid("ZS");
		member.setWayid("CH_2323");//
		GoodsListQueryParameter param = new GoodsListQueryParameter();
		param.setSize(2);
		param.setNo(1);
		param.setSession(new MockHttpSession());
		param.setComType("55DG");//商品种类
		param.setOrderCount(20);//订购基数
		
		ServiceResult reslt = this.goodsRemote.transact(member, param, ServiceType.QUERY);
		if (reslt.isSuccess()){
			System.out.println(":DATE SIZE:"+reslt.getRetResult().getData().size());
		}else{
			System.out.println(":ERROR:"+reslt.getMessage());
		}
	}
}
