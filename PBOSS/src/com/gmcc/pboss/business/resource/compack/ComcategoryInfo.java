package com.gmcc.pboss.business.resource.compack;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gmcc.pboss.business.resource.numtypedef.NumtypedefVO;
import com.sunrise.jop.common.utils.lang.PublicUtils;

public class ComcategoryInfo {
	
	private String comcategory;	//商品各类
	private Long packSize;	//包大小
	private List<NumberTypeInfo> numberTypeInfo;	//号码类型信息
	
	
	public ComcategoryInfo(){
		
	}
	
	public ComcategoryInfo(List<NumtypedefVO> numTypeList){

		List<NumberTypeInfo> numberTypeInfos = new ArrayList<NumberTypeInfo>();
		if( null != numTypeList ){
			for(NumtypedefVO vo:numTypeList){
				NumberTypeInfo info = new NumberTypeInfo();
				info.setType(""+vo.getTypeid());
				info.setQuantity(0L);
				info.setScale(0D);
				info.setRemain(0);
				numberTypeInfos.add(info);
				}
		}		
		this.numberTypeInfo = numberTypeInfos;
	}
	
	public String getComcategory() {
		return comcategory;
	}
	public void setComcategory(String comcategory) {
		this.comcategory = comcategory;
	}
	public Long getPackSize() {
		return packSize;
	}
	public void setPackSize(Long packSize) {
		this.packSize = packSize;
	}
	public List<NumberTypeInfo> getNumberTypeInfo() {
		return numberTypeInfo;
	}
	public void setNumberTypeInfo(List<NumberTypeInfo> numberTypeInfo) {
		this.numberTypeInfo = numberTypeInfo;
	}
	
	/*
	 * 检查商品下所有号码调整后的比例之和是否正确（比例之和等于包大小）
	 */
	public boolean checkAdjustScale(){
		if( null == numberTypeInfo || numberTypeInfo.size() == 0)
			return false;
		BigDecimal total = new BigDecimal(0);		
		for(NumberTypeInfo type:this.numberTypeInfo){
			if(type.getAdjustScale()<0)
				return false;
			total = total.add(new BigDecimal(Double.toString(type.getAdjustScale()))) ;
		}
		if(total.doubleValue() != this.packSize)
			return false;
		return true;
	}
	
	/*
	 * 检查商品下所有号码所占比例之和是否正确（比例之和等于包大小）
	 */
	public boolean checkScale(){
		if( null == numberTypeInfo || numberTypeInfo.size() == 0)
			return false;
		BigDecimal total = new BigDecimal(0);
		for(NumberTypeInfo type:this.numberTypeInfo){
			if(type.getScale()<0)
				return false;
			total = total.add(new BigDecimal(Double.toString(type.getScale()))) ;
		}
		if(total.intValue() != this.packSize)
			return false;
		return true;
	}
	
	/*
	 * 调整比例(单个）
	 * 如果各类型比例之和不等于（即小于）包大小，则对非整数的比例进行逐个递加0.01，
	 * 直到各类型之和等于包大小为止，记录最终比例
	 */
	public void adjustScale(){		
		BigDecimal total = new BigDecimal(0);
		for(NumberTypeInfo type:numberTypeInfo){
			total = total.add(new BigDecimal(Double.toString(type.getScale())));
		}
		System.out.println("@@@@@@@@@@@@@@@total  ="+total);
		while(total.longValue()<packSize){
			for(NumberTypeInfo type:numberTypeInfo){
				BigDecimal scale = new BigDecimal(Double.toString(type.getScale()));
				if(this.isAllScaleInteger()){
					if(total.doubleValue()<this.packSize && type.getScale() != 0){
						type.setScale(type.getScale()+1);
						total =total.add(new BigDecimal(1));
					}
				}
				if(!(""+scale.doubleValue()).endsWith(".0")){
					type.setScale(scale.add(new BigDecimal(Double.toString(0.01))).doubleValue());
					total = total.add(new BigDecimal(Double.toString(0.01)));
					//total = new Double(doubleFormat.format(total));
					if(total.doubleValue() >= packSize){
						System.out.println("*****total"+total );
						break;
					}
				}
			}
		}	
		for(NumberTypeInfo type2:numberTypeInfo){
			System.out.println("@@@@"+type2.getScale());
		}
}
	
	private boolean isAllScaleInteger(){
		for(NumberTypeInfo type:numberTypeInfo){
			if(!(type.getScale()+"").endsWith(".0"))
				return false;
		}
		return true;
	}
	
	/*
	 * 取商品下所有号码（按调整后比例）都能取得整数分配时的最小公共包数
	 * 
	 */
	public int getIntegerPack() throws Exception{
		int result = 0;
		if( !this.checkAdjustScale())
			throw new Exception("调整后比例不正确");
		
		boolean isAllInteger = true;
//		调整后比例格式为##.00 所以最多循環１００遍就能達到全為整數的效果
		for(int i = 1;i<=100;i++){
			isAllInteger = true;
			for(NumberTypeInfo type:this.numberTypeInfo){
				BigDecimal decimal = new BigDecimal(Double.toString(type.getAdjustScale()));
				if(!(decimal.multiply(new BigDecimal(i)).doubleValue()+"").endsWith(".0")){
					isAllInteger = false;
					break;
				}
			}
			if(isAllInteger){
					result = i;
					break;
				}
		}
		return result;		
	}
	
	/*
	 * 对商品下所有号码类型进行（按调整后比例）进行组包分配
	 */
	public List<Map<String,Long>> numberTypeDistribute() throws Exception{
		List<Map<String,Long>> resultList = new ArrayList<Map<String,Long>>();
		
		long totalResource = 0;//各类型号码总数量
		
		for(NumberTypeInfo typeInfo :this.numberTypeInfo) {
			totalResource += typeInfo.getQuantity();
		}
//		计算整数包=各类型数量之和/套卡品牌包大小，向下取整。
		long packCount = totalResource/this.packSize;
//		创建套卡分配包集合，该集合大小的等于整数包数量，该集合用于记录每包中各类型的实际分配数量。
//		对套卡分配包进行遍历：将各类型所占比例的整数位分配至各包中，在每包分配前判断当前类型的实际数量是否足够，
//		如果不足则跳过，然后处理下一个类型。分配的同时，记录各类型的剩余数量。
		for(int i = 0;i<packCount;i++){
			Map<String,Long> packMap = new HashMap<String,Long>();
			for(NumberTypeInfo typeInfo :this.numberTypeInfo) {
				if(typeInfo.getRemain()>=typeInfo.getAdjustScale().longValue()){
					packMap.put(typeInfo.getType(), typeInfo.getAdjustScale().longValue());
					typeInfo.setRemain(typeInfo.getRemain()-typeInfo.getAdjustScale().longValue());
				}else{
					packMap.put(typeInfo.getType(), 0L);
				}
			}
			resultList.add(packMap);
		}
//		对套卡分配包进行二次遍历：逐包检查各类型之和是否等于包大小，等于则处理下一包；否则，
//		按类型顺序分配余数（每次分配一个，余数为零时跳过），直到对各类型之和等于包大小时终止。
		for(Map<String,Long> packMap:resultList){
			while(this.sumTypeNum(packMap)<this.packSize && hasRemain(this.numberTypeInfo)){
				for(NumberTypeInfo typeInfo :this.numberTypeInfo) {
					if(typeInfo.getRemain()>0){
						packMap.put(typeInfo.getType(), packMap.get(typeInfo.getType())+1);
						typeInfo.setRemain(typeInfo.getRemain()-1);
						if(this.sumTypeNum(packMap)>=this.packSize){
							break;
						}
					}
				}
			}
		}		
	
//		余数包分配：经过二次遍历后，如果各类型存在余数，则添加一个包到套卡分配包集合，该包中对应各类型余数。
		Map<String,Long> laskPackMap = new HashMap<String,Long>();
		if(hasRemain(this.numberTypeInfo)){
			for(NumberTypeInfo typeInfo :this.numberTypeInfo) {
				laskPackMap.put(typeInfo.getType(), typeInfo.getRemain());
			}
			resultList.add(laskPackMap);
		}
		return resultList;
	}
	
	private long sumTypeNum(Map<String,Long> packMap){
		Set<String> keys = packMap.keySet();
		long count = 0;
		for(String key:keys){
			count += packMap.get(key);
		}
		return count;
	}
	/*
	 * 判断是否还有余数
	 */
	private boolean hasRemain(List<NumberTypeInfo> numbTypes){
		for(NumberTypeInfo type:numbTypes){
			if(type.getRemain()>0)
				return true;
		}
		return false;
	}
	
	/*
	 * 判断商品下所有类型按调整后比例取整加上一整数量后是否与商品包大小相等
	 */
	private boolean isEqualAfterAdd(int i){
		long totalAdjustByInt = 0;
		for(NumberTypeInfo type:this.numberTypeInfo){
			totalAdjustByInt += type.getAdjustScale().longValue();
		}
		System.out.println(totalAdjustByInt+i);
		System.out.println(this.packSize.intValue() == (totalAdjustByInt+i));
		return this.packSize.intValue() == (totalAdjustByInt+i);
	}
	
	/*
	 * 取得商品下所有号码类型调整后的比例整数部分之和
	 */
	private long getLongTotalAdjustAfterAdd(int i){
		long totalAdjustByInt = 0;
		for(NumberTypeInfo type:this.numberTypeInfo){
			totalAdjustByInt += type.getAdjustScale().longValue();
		}
		return totalAdjustByInt+i;
	}
	

	public static void main(String[] args){
		ComcategoryInfo comInfo = new ComcategoryInfo();
		comInfo.setPackSize(20L);
		List<NumberTypeInfo> list = new ArrayList<NumberTypeInfo>();
		NumberTypeInfo typeInfo1 = new NumberTypeInfo();
		typeInfo1.setType("aa");
		typeInfo1.setQuantity(0l);
		typeInfo1.setRemain(0l);
		typeInfo1.setScale(0d);
		typeInfo1.setAdjustScale(0d);
		list.add(typeInfo1);
		
		NumberTypeInfo typeInfo2 = new NumberTypeInfo();
		typeInfo2.setType("bb");
		typeInfo2.setQuantity(0l);
		typeInfo2.setRemain(0l);
		typeInfo2.setScale(0.0);
		typeInfo2.setAdjustScale(0d);
		list.add(typeInfo2);
		
		NumberTypeInfo typeInfo3 = new NumberTypeInfo();
		typeInfo3.setType("cc");
		typeInfo3.setQuantity(22l);
		typeInfo3.setRemain(22l);
		typeInfo3.setScale(0.67);
		typeInfo3.setAdjustScale(0.67);
		list.add(typeInfo3);
		
		
		NumberTypeInfo typeInfo4 = new NumberTypeInfo();
		typeInfo4.setType("dd");
		typeInfo4.setQuantity(369l);
		typeInfo4.setRemain(368l);
		typeInfo4.setScale(9.56);
		typeInfo4.setAdjustScale(9.56);
		list.add(typeInfo4);
		
		NumberTypeInfo typeInfo5 = new NumberTypeInfo();
		typeInfo5.setType("ee");
		typeInfo5.setQuantity(137l);
		typeInfo5.setRemain(137l);
		typeInfo5.setScale(3.62);
		typeInfo5.setAdjustScale(3.62);
		list.add(typeInfo5);
		
		NumberTypeInfo typeInfo6 = new NumberTypeInfo();
		typeInfo6.setType("ff");
		typeInfo6.setQuantity(236l);
		typeInfo6.setRemain(236l);
		typeInfo6.setScale(6.15);
		typeInfo6.setAdjustScale(6.15);
		list.add(typeInfo6);
		
		comInfo.setNumberTypeInfo(list);
		
		try {
	
			comInfo.adjustScale();
			
			List<Map<String,Long>>  pack = comInfo.numberTypeDistribute();
			
			for(int i = 0; i<pack.size();i++){
				Map<String,Long> map = pack.get(i);
				System.out.println("******"+i);
				Set<String> keys = map.keySet();
				long k = 0;
				for(String key:keys){
					System.out.println(key+":"+map.get(key));
					k += map.get(key);
				}
				if(k != 20)
					System.out.println("**************@@*****************");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}
