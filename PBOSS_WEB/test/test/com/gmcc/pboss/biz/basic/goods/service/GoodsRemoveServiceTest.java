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
 * Զ�̽ӿڲ�����
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
	 * �ӿ�1��bookQualificationCheck
	 */
	public void testRemove1() {
		//WebSiteService�ӿ�
//		WebSiteService service = (WebSiteService) context.getBean("httpWebSiteService");
		//����hello����
		RetResult result = httpWebRemote.bookQualificationCheck("CH_2323");
		
		System.out.println("::"+result.getRetCode());
		if (result.getRetCode() == RetResult.ERROR){
			System.out.println("ERROR by:" + result.getMessage());
		}
	}
	/**
	 * �ӿ�2��queryBookBasicInfo
	 */
	public void testRemove2() {
		//WebSiteService�ӿ�
//		WebSiteService service = (WebSiteService) context.getBean("httpWebSiteService");
		//����hello����
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
	 * �ӿ�3��queryGoodsPriceRadix
	 */
	public void testRemove3() {
		//WebSiteService�ӿ�
//		WebSiteService service = (WebSiteService) context.getBean("httpWebSiteService");
		//����hello����
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
	 * �ӿ�4��getGoodsResource
	 */
	public void testRemove4() {
		//WebSiteService�ӿ�
//		WebSiteService service = (WebSiteService) context.getBean("httpWebSiteService");
		//����hello����
		GoodsResource result = httpWebRemote.getGoodsResource("TDZS04T01","55DG",20);
		if (result.getRetCode()!=BookBasicInfo.SUCCESS){
			System.out.println("["+ result.getRetCode() +"]:"+ result.getMessage());
		}else{
			System.out.println("::"+result.getRetCode()+" :��������:");
			System.out.println(result.getGoodsList().size());
		}
	}
	//����query
	public void testQuery() {
		//WebSiteService�ӿ�
//		WebSiteService service = (WebSiteService) context.getBean("httpWebSiteService");
		//����hello����
		LoginMember member = new LoginMember();
		member.setCityid("ZS");
		member.setWayid("CH_2323");//
		GoodsListQueryParameter param = new GoodsListQueryParameter();
		param.setSize(2);
		param.setNo(1);
		param.setSession(new MockHttpSession());
		param.setComType("55DG");//��Ʒ����
		param.setOrderCount(20);//��������
		
		ServiceResult reslt = this.goodsRemote.transact(member, param, ServiceType.QUERY);
		if (reslt.isSuccess()){
			System.out.println(":DATE SIZE:"+reslt.getRetResult().getData().size());
		}else{
			System.out.println(":ERROR:"+reslt.getMessage());
		}
	}
}
