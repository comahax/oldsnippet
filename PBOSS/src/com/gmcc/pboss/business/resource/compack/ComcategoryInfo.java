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
	
	private String comcategory;	//��Ʒ����
	private Long packSize;	//����С
	private List<NumberTypeInfo> numberTypeInfo;	//����������Ϣ
	
	
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
	 * �����Ʒ�����к��������ı���֮���Ƿ���ȷ������֮�͵��ڰ���С��
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
	 * �����Ʒ�����к�����ռ����֮���Ƿ���ȷ������֮�͵��ڰ���С��
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
	 * ��������(������
	 * ��������ͱ���֮�Ͳ����ڣ���С�ڣ�����С����Է������ı�����������ݼ�0.01��
	 * ֱ��������֮�͵��ڰ���СΪֹ����¼���ձ���
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
	 * ȡ��Ʒ�����к��루�����������������ȡ����������ʱ����С��������
	 * 
	 */
	public int getIntegerPack() throws Exception{
		int result = 0;
		if( !this.checkAdjustScale())
			throw new Exception("�������������ȷ");
		
		boolean isAllInteger = true;
//		�����������ʽΪ##.00 �������ѭ�h������������_��ȫ��������Ч��
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
	 * ����Ʒ�����к������ͽ��У�������������������������
	 */
	public List<Map<String,Long>> numberTypeDistribute() throws Exception{
		List<Map<String,Long>> resultList = new ArrayList<Map<String,Long>>();
		
		long totalResource = 0;//�����ͺ���������
		
		for(NumberTypeInfo typeInfo :this.numberTypeInfo) {
			totalResource += typeInfo.getQuantity();
		}
//		����������=����������֮��/�׿�Ʒ�ư���С������ȡ����
		long packCount = totalResource/this.packSize;
//		�����׿���������ϣ��ü��ϴ�С�ĵ����������������ü������ڼ�¼ÿ���и����͵�ʵ�ʷ���������
//		���׿���������б���������������ռ����������λ�����������У���ÿ������ǰ�жϵ�ǰ���͵�ʵ�������Ƿ��㹻��
//		���������������Ȼ������һ�����͡������ͬʱ����¼�����͵�ʣ��������
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
//		���׿���������ж��α����������������֮���Ƿ���ڰ���С������������һ��������
//		������˳�����������ÿ�η���һ��������Ϊ��ʱ��������ֱ���Ը�����֮�͵��ڰ���Сʱ��ֹ��
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
	
//		���������䣺�������α�������������ʹ��������������һ�������׿���������ϣ��ð��ж�Ӧ������������
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
	 * �ж��Ƿ�������
	 */
	private boolean hasRemain(List<NumberTypeInfo> numbTypes){
		for(NumberTypeInfo type:numbTypes){
			if(type.getRemain()>0)
				return true;
		}
		return false;
	}
	
	/*
	 * �ж���Ʒ���������Ͱ����������ȡ������һ���������Ƿ�����Ʒ����С���
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
	 * ȡ����Ʒ�����к������͵�����ı�����������֮��
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
