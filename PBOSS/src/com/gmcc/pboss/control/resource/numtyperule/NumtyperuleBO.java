/**
 * auto-generated code
 * Sat Sep 05 16:02:03 CST 2009
 */
package com.gmcc.pboss.control.resource.numtyperule;

import java.util.List;

import com.gmcc.pboss.business.resource.numtypedef.NumtypedefDBParam;
import com.gmcc.pboss.business.resource.numtypedef.NumtypedefDAO;
import com.gmcc.pboss.business.resource.numtyperule.NumtyperuleDAO;
import com.gmcc.pboss.business.resource.numtyperule.NumtyperuleDBParam;
import com.gmcc.pboss.business.resource.numtyperule.NumtyperuleVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: NumtyperuleBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */

public class NumtyperuleBO extends AbstractControlBean implements
		Numtyperule {

	public DataPackage doQuery(NumtypedefDBParam params)
			throws Exception {
		NumtypedefDAO dao = (NumtypedefDAO) DAOFactory.build(NumtyperuleDAO.class,user);
		return dao.query(params);
	}
	
	public DataPackage doQueryByNameSql(String nameSql,NumtyperuleDBParam params)
	throws Exception {
	NumtyperuleDAO dao = (NumtyperuleDAO) DAOFactory.build(NumtyperuleDAO.class,user);
	return dao.queryByNamedSqlQuery(nameSql, params);
	}
	
	/**
	 * ��������ƥ��
	 * @param number	����
	 * @param numbertyperules	������ʽ�б�
	 * @return
	 * @throws Exception
	 */
	public Long doMatchNumber(String number,List<NumtyperuleVO> numbertyperules)throws Exception{
		int X,Y,L;
		String ruleexp=null;
		String byStr=null;
		String byChar=null;
		boolean byBo=false;
		for(NumtyperuleVO typerule:numbertyperules){
			//System.out.println(typerule);
			ruleexp= ( null == typerule.getRuleexp() )?"":typerule.getRuleexp();
			
			X=ruleexp.length();
			L=number.length();
			
			if(ruleexp.indexOf("ab")>0){
				Long t1 = doFs(number,L,ruleexp,typerule);
				if(t1>0){
					return t1;
				}
				
				Long t2 = doTs(number,L,ruleexp,typerule);
				if(t2>0){
					return t2;
				}
				
				if("*abcdabcd".equals(ruleexp) 
						|| "*abcabc".equals(ruleexp)
						|| "*abab".equals(ruleexp)){
					//������ʽ�а�����ab����˫˳��
					//��ȡ���볤��L���Ƚϡ�0��L-Y���͡�L-Y��L���Ƿ���ͬ��������򷵻غ������ͱ���
					Y=(X-1)/2;
					if(number.substring(L-(X-1),L-Y).equals(number.substring(L-Y,L))){
						return typerule.getTypeid();
					}
				}
			}
			
			Long t3 = doFL(number,L,ruleexp,typerule);
			if(t3>0){
				return t3;
			}
			Long t4 = doTL(number,L,ruleexp,typerule);
			if(t4>0){
				return t4;
			}
			
			
			if(ruleexp.indexOf("ABC")>0){//������ʽ��ֻ���С�ABC����˳��
				//��ȡ���ʽ����X��ȡ����ĩβX-1λ�������һ�Ƚϣ����ȫ����ͬ�򷵻غ������ͱ��룻
				byBo=false;
				byChar=null;
				byStr=number.substring(L-(X-1),L);
				for(int i=0;i<byStr.length();i++){
					if(byChar!=null){
						if(byChar!=null && byChar.equals(String.valueOf(Integer.valueOf(byStr.charAt(i))))){
							byBo=true;
						}else{
							byBo=false;
							break;
						}
					}
					byChar=String.valueOf((Integer.valueOf(byStr.charAt(i))+1));
				}
				if(byBo)
					return typerule.getTypeid();				
			}
			if(ruleexp.indexOf("CBA")>0){//������ʽ�к��С�CBA��������
				//��ȡ���ʽ����X��ȡ����ĩβX-1λ�������һ�Ƚϣ����ȫ����ͬ�򷵻غ������ͱ���
				byBo=false;
				byChar=null;
				byStr=number.substring(L-(X-1),L);
				for(int i=0;i<byStr.length();i++){
					if(byChar!=null){
						if(byChar.equals(String.valueOf(Integer.valueOf(byStr.charAt(i))))){
							byBo=true;
						}else{
							byBo=false;
							break;
						}
					}
					byChar=String.valueOf(Integer.valueOf(byStr.charAt(i))-1);
				}
				if(byBo)
					return typerule.getTypeid();				
			}
			if(ruleexp.indexOf("AABB")>0){//������ʽ�к��С�AABB�����������ţ�
				byBo=false;
				byChar=null;
				//��ȡ���ʽ����X�����Ÿ���ΪY=��X-1��/2��
				Y=(X-1)/2;
				//ȡ����ĩβYλ��������Ƚϣ������ͬ�������һ����
				byStr=number.substring(L-Y,L);
				for(int i=0;i<byStr.length();i++){
					if(byChar!=null){
						if(byChar.equals(String.valueOf(Integer.valueOf(byStr.charAt(i))))){
							byBo=true;
						}else{
							byBo=false;
							break;
						}
					}
					byChar=String.valueOf(Integer.valueOf(byStr.charAt(i)));
				}
				//����ȡĩβ��ʼY��2Yλ���бȽϣ������ͬ�������һ������ͬ�򷵻غ������ͱ��롣
				if(byBo){
					byChar=null;
					byStr=number.substring(L-2*Y,L-Y);
					for(int i=0;i<byStr.length();i++){
						if(byChar!=null){
							if(byChar.equals(String.valueOf(Integer.valueOf(byStr.charAt(i))))){
								byBo=true;
							}else{
								byBo=false;
								break;
							}
						}					
						byChar=String.valueOf(Integer.valueOf(byStr.charAt(i)));
					}
				}
				if(byBo){
					return typerule.getTypeid(); 
				}					
			}
			if(ruleexp.indexOf("A")>0){//������ʽ���С�A�������ţ�
				byBo=false;
				byChar=null;
				//���ȡ���ʽ����X�������Ÿ���Y=X-1����ȡ�����Yλ��������Աȣ����ȫ����ͬ�򷵻غ������ͱ��룻���������һ��
				Y=X-1;
				byStr=number.substring(L-Y,L);
				for(int i=0;i<byStr.length();i++){
					if(byChar!=null){
						if(byChar.equals(String.valueOf(byStr.charAt(i)))){
							byBo=true;
						}else{
							byBo=false;
							break;
						}
					}				
					byChar=String.valueOf(byStr.charAt(i));
				}
				if(byBo){
					return typerule.getTypeid(); 
				}
			}
			//Ĭ��Ϊ�Զ�����ʽ����ȡ���ʽ����X����ȡ���ʽĩβX-1λ����ȡ����ĩβX-1λ���Ƚ������Ƿ���ͬ�������ͬ�򷵻غ������ͱ��룬���������һ����
			if(!"".equals(ruleexp.trim())){
				Y=X-1;
				String ruleexpLastX=ruleexp.substring(1,X);
				String numberLastX=number.substring(L-Y,L);
				byBo=false;
				for(int i=0;i<ruleexpLastX.length();i++){
					if(String.valueOf(ruleexpLastX.charAt(i)).equals(String.valueOf(numberLastX.charAt(i)))){
						byBo=true;
					}else{
						byBo=false;
						break;
					}
				}
				if(byBo){
					return typerule.getTypeid(); 
				}
			}												
		}
		for(NumtyperuleVO typerule:numbertyperules){
			if(typerule.getIsdefault()!=null && typerule.getIsdefault()==1){
				return typerule.getTypeid();
			}
		}
		return null;
	}
	
	/**
	 * ��˳
	 * @param number
	 * @param L
	 * @param ruleexp
	 * @param typerule
	 * @return
	 */
	public Long doFs(String number,int L,String ruleexp,NumtyperuleVO typerule){
		
		if("*abababab".equals(ruleexp)){//��˳
			if(L>=8){
				String tmp1 = number.substring(L-8,L-6);
				String tmp2 = number.substring(L-6,L-4);
				String tmp3 = number.substring(L-4,L-2);
				String tmp4 = number.substring(L-2);
				
				if(tmp1.equals(tmp2) && tmp2.equals(tmp3) && tmp3.equals(tmp4) ){
					return typerule.getTypeid();
				}
			}
		}
		return -1L;
	}
	
	/**
	 * ��˳
	 * @param number
	 * @param L
	 * @param ruleexp
	 * @param typerule
	 * @return
	 */
	public Long doTs(String number,int L,String ruleexp,NumtyperuleVO typerule){
		if("*abcabcabc".equals(ruleexp) || "*ababab".equals(ruleexp)){//��˳
			if("*abcabcabc".equals(ruleexp)){//����
				if(L>=9){
					String tmp1 = number.substring(L-9,L-6);
					String tmp2 = number.substring(L-6,L-3);
					String tmp3 = number.substring(L-3);
					
					if(tmp1.equals(tmp2) && tmp2.equals(tmp3)){
						return typerule.getTypeid();
					}
				}
			}
			if("*ababab".equals(ruleexp)){//����
				if(L>=6){
					String tmp1 = number.substring(L-6,L-4);
					String tmp2 = number.substring(L-4,L-2);
					String tmp3 = number.substring(L-2);
					
					if(tmp1.equals(tmp2) && tmp2.equals(tmp3)){
						return typerule.getTypeid();
					}
				}
			}
		}
		
		return -1L;
	}
	
	/**
	 * �Ķ�����
	 * @param number
	 * @param L
	 * @param ruleexp
	 * @param typerule
	 * @return
	 */
	public Long doFL(String number,int L,String ruleexp,NumtyperuleVO typerule){
		if("*AABBCCDD".equals(ruleexp)){//�Ķ�����
			if(L>=8){
				String tmp1 = number.substring(L-8,L-7);
				String tmp2 = number.substring(L-7,L-6);
				String tmp3 = number.substring(L-6,L-5);
				String tmp4 = number.substring(L-5,L-4);
				String tmp5 = number.substring(L-4,L-3);
				String tmp6 = number.substring(L-3,L-2);
				String tmp7 = number.substring(L-2,L-1);
				String tmp8 = number.substring(L-1);
				if(tmp1.equals(tmp2) && tmp3.equals(tmp4) 
						&& tmp5.equals(tmp6) && tmp7.equals(tmp8) ){
					return typerule.getTypeid();
				}
			}
		}
		
		return -1L;
	}
	
	/**
	 * ��������
	 * @param number
	 * @param L
	 * @param ruleexp
	 * @param typerule
	 * @return
	 */
	public Long doTL(String number,int L,String ruleexp,NumtyperuleVO typerule){
		if("*AAABBBCCC".equals(ruleexp) || "*AABBCC".equals(ruleexp)){//��������
			if("*AAABBBCCC".equals(ruleexp)){//����
				if(L>=9){
					String tmp1 = number.substring(L-9,L-8);
					String tmp2 = number.substring(L-8,L-7);
					String tmp3 = number.substring(L-7,L-6);
					String tmp4 = number.substring(L-6,L-5);
					String tmp5 = number.substring(L-5,L-4);
					String tmp6 = number.substring(L-4,L-3);
					String tmp7 = number.substring(L-3,L-2);
					String tmp8 = number.substring(L-2,L-1);
					String tmp9 = number.substring(L-1);
					if(tmp1.equals(tmp2) && tmp2.equals(tmp3) 
							&& tmp4.equals(tmp5) && tmp5.equals(tmp6)
							&& tmp7.equals(tmp8) && tmp8.equals(tmp9)){
						return typerule.getTypeid();
					}
				}
			}
			if("*AABBCC".equals(ruleexp)){//����
				if(L>=6){
					String tmp1 = number.substring(L-6,L-5);
					String tmp2 = number.substring(L-5,L-4);
					String tmp3 = number.substring(L-4,L-3);
					String tmp4 = number.substring(L-3,L-2);
					String tmp5 = number.substring(L-2,L-1);
					String tmp6 = number.substring(L-1);
					if(tmp1.equals(tmp2) && tmp3.equals(tmp4) 
							&& tmp5.equals(tmp6)){
						return typerule.getTypeid();
					}
				}
			}
		}
		
		return -1L;
	}
	
	/**
	 * ����ƥ�䷽��
	 * @param number
	 * @return
	 * @throws Exception
	 */
	public Long doMatchNumber(String number)throws Exception{
		NumtyperuleDBParam params = new NumtyperuleDBParam();
		List<NumtyperuleVO> numtyperuleList = this.doGetNumtyperuleList(params);
		return this.doMatchNumber(number, numtyperuleList);
	}
/**
 * ��ȡ���������ʽ
 * @param params
 * @return
 * @throws Exception
 */
	public List<NumtyperuleVO> doGetNumtyperuleList(NumtyperuleDBParam params) throws Exception {
		DataPackage data=this.doQueryByNameSql("com.gmcc.pboss.business.resource.numtyperule.queryLeftJoinNumsortrule", params);
		return data.getDatas();
	}
}
