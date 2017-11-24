package com.sunrise.boss.ui.resmanage.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.apache.commons.lang.StringUtils;
/**
 * @describe ���ʽ��,֧��+,-,*,/
 * @author cwl
 *
 */
public class Expression {
	private String expression;//���ʽ���ַ�����ʾ,��(a+bef*(4-3))/(2-1)-g

	private Context ctx;//ִ�б��ʽ�Ļ�������(�籣����ʽ�еı�������ֵ��ӳ��)

	private char[] oprmodel = { '+', '-', '*', '/', '(', ')' };
	
	private String[] comparemodel = {"==","!=",">=","<=",">","<"};

	public Expression(String expression, Context ctx) {
		this.expression = expression;
		this.ctx = ctx;
	}
	
	/**
	 * @describe ������ʽ
	 * @return
	 * @throws Exception
	 */
	public Object compute() throws Exception {
		Stack oprStack = new Stack();
		Stack varStack = new Stack();
		List eList = analyzeExpression();
		//�ڱ��ʽǰ������ַ�'#',���ڽ���
		eList.add(0, new Character('#'));
		eList.add(new Character('#'));
		if (eList.isEmpty()) {
			return new Double(0.00);
		}
		
		Iterator iter = eList.iterator();
		boolean getNextFlag = true;
		Object obj = null;
		do {
			if (getNextFlag){
				obj = iter.next();
			}
			if (obj instanceof String) {
				varStack.push(ctx.lookup((String) obj));
			} else if (obj instanceof Double) {
				varStack.push(obj);
			} else if (obj instanceof Character) {
				if (oprStack.empty()) {
					oprStack.push(obj);getNextFlag = true;
				} else {
					char pri = priority((Character) oprStack.peek(),
							(Character) obj);
					switch (pri) {
					case '<':
						oprStack.push(obj);getNextFlag = true;
						break;
					case '=':
						oprStack.pop();getNextFlag = true;
						break;
					case '>':
						Double d2 = (Double)varStack.pop();
						Double d1 = (Double)varStack.pop();
						Character opr = (Character)oprStack.pop();
						varStack.push(operate(d1,opr,d2));
						getNextFlag = false;
						break;
					}
				}

			}
		} while (iter.hasNext());
		
		return varStack.pop();
	}
	
	/**
	 * @describe �ֽ��ַ������ʽΪ�ַ�����,���ֳ���,������
	 * @return
	 * @throws Exception
	 */
	private List analyzeExpression() throws Exception {
		if (StringUtils.isEmpty(expression)){
			throw new Exception("���ʽ�ַ�������Ϊ��");
		}
		char[] exp = expression.toCharArray();
		if (!checkParentheses(exp)) {
			throw new Exception("���ʽ���Ų�ƥ��");
		}
		List eList = new ArrayList();
		int len = exp.length;
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < len; i++) {
			String val;
			Double digit;
			if (Character.isLetterOrDigit(exp[i]) || exp[i] == '.') {
				if (i != len-1 && (Character.isLetterOrDigit(exp[i + 1]) || exp[i + 1] == '.')) {
					buf.append(exp[i]);
					continue;
				}
				buf.append(exp[i]);
				if (containsLetter(buf.toString())){
					//�����׷�������ĸ,˵��������Ϊ����
					if (Character.isLetter(buf.charAt(0))){
						val = buf.toString();
						eList.add(val);
						buf.setLength(0);
					}else {
						throw new Exception("����ı�������'"+buf.toString()+"',����Ӧ����ĸ��ͷ");
					}
				}else if (buf.charAt(0) != '.'){
					digit = new Double(buf.toString());
					eList.add(digit);
					buf.setLength(0);
				}else {
					throw new Exception("����ı�������'"+buf.toString()+"',����Ӧ����ĸ��ͷ");
				}
			}
			else {
				if (isOpr(exp[i])) {
					if (i == len-1 && exp[i] != ')'){
						throw new Exception("���ʽ����ȷ(��Ӧ�Բ�����'"+exp[i]+"'����)");
					}else {
						if (!isParenttheses(exp[i]) && !isParenttheses(exp[i+1]) && isOpr(exp[i+1])){
							throw new Exception("�����Ų�����������������");
						}
					}
					eList.add(new Character(exp[i]));
				} else {
					throw new Exception("���ʽ����ȷ(�Ƿ��Ĳ�����:"+exp[i]+")");
				}
			}
		}
		return eList;
	}
	
	
	/**
	 * �Ƚϱ��ʽ,��:a+be*(4.5-3)>(30-1)*g
	 * @return
	 * @throws Exception
	 */
	public boolean doCompare() throws Exception{
		if (StringUtils.isEmpty(expression)){
			throw new Exception("���ʽ�ַ�������Ϊ��");
		}
		String model = checkComparemodel();
		String leftExpression = expression.substring(0,expression.indexOf(model));
		String rightExpression = expression.substring(expression.indexOf(model)+model.length());
		String oldExpression = expression;
		expression = leftExpression;
		Double leftValue = (Double)this.compute();
		expression = rightExpression;
		Double rightValue = (Double)this.compute();
		expression = oldExpression;
		return compare(leftValue,model,rightValue);
	}
	/**
	 * @describe ȷ���������Ȩ
	 * @param topOpr
	 * @param cOpr
	 * @return
	 */
	private char priority(Character topOpr, Character cOpr) {
		char rValue = ' ';
		char opr1 = topOpr.charValue();
		char opr2 = cOpr.charValue();
		switch (opr1) {
		case '#':
			if (opr2 == '#') {
				rValue = '=';
			} else {
				rValue = '<';
			}
			break;
		case '+':
		case '-':
			if (opr2 == '*' || opr2 == '/' || opr2 == '(') {
				rValue = '<';
			} else {
				rValue = '>';
			}
			break;
		case '*':
		case '/':
			if (opr2 == '(') {
				rValue = '<';
			} else {
				rValue = '>';
			}
			break;
		case '(':
			if (opr2 == ')') {
				rValue = '=';
			} else {
				rValue = '<';
			}
			break;
		case ')':
			rValue = '>';
			break;
		}
		return rValue;
	}
	
	/**
	 * @describe�ж��Ƿ�Ϊ������
	 * @param c
	 * @return
	 */
	private boolean isOpr(char c) {
		for (int i = 0; i < oprmodel.length; i++) {
			if (c == oprmodel[i]) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @describe �����ʽ������(ֻ֧��С����)�Ƿ�ƥ��
	 * @param exp
	 * @return
	 */
	private boolean checkParentheses(char[] exp) {
		Stack st = new Stack();
		for (int i = 0; i < exp.length; i++) {
			if (exp[i] == '(') {
				st.push(new Character(exp[i]));
			} else if (exp[i] == ')') {
				if (st.empty()) {
					return false;
				} else {
					st.pop();
				}
			}
		}
		if (!st.empty()) {
			return false;
		}
		return true;
	}
	
	private boolean isParenttheses(char c){
		return (c == '(' || c == ')')?true:false;
	}
	
	/**
	 * @describe ������,֧��double���͵�+,-,*,/
	 * @param d1
	 * @param opr
	 * @param d2
	 * @return
	 */
	private Double operate(Double d1,Character opr,Double d2){
		Double rValue = null;
		double value1 = d1.doubleValue();
		double value2 = d2.doubleValue();
		char op = opr.charValue();
		switch(op){
		case '+':rValue = new Double(value1 + value2);break;
		case '-':rValue = new Double(value1 - value2);break;
		case '*':rValue = new Double(value1 * value2);break;
		case '/':rValue = new Double(value1 / value2);break;
		}
		return rValue;
	}
	
	private boolean containsLetter(String str){
		char[] chars = str.toCharArray();
		for (int i = 0;i < chars.length;i++){
			if (Character.isLetter(chars[i])){
				return true;
			}
		}
		return false;
	}
	
	
	private String checkComparemodel() throws Exception{ 
		String model = "";
		int num = 0;
		for(int i = 0;i < comparemodel.length;i++){
			if (expression.indexOf(comparemodel[i]) != -1){
				model = comparemodel[i];
				num ++;
			}
		}
		if (num > 1 || num == 0){
			throw new Exception("���ʽ"+expression+"�Ƿ�,Ӧ����һ��������('>','<','==','>=','<=','!='�е�һ��)");
		}
		return model;
	}
	
	
	private boolean compare(Double leftValue,String opr,Double rightValue){
		double left = leftValue.doubleValue();
		double right = rightValue.doubleValue();
		if ("==".equals(opr)){
			return left == right;
		}else if ("!=".equals(opr)){
			return left != right;
		}else if (">".equals(opr)){
			return left > right;
		}else if (">=".equals(opr)){
			return left >= right;
		}else if ("<".equals(opr)){
			return left < right;
		}else {
			return left <= right;
		}
	}
//	public static void main(String[]args){
////		Expression exp = new Expression("(3+52*(4-3))/(2-1)",null);
//		Context ctx = new Context();
//		ctx.assign("a", new Double(3));
//		ctx.assign("be", new Double(4));
//		ctx.assign("g", new Double(2));
//		Expression exp = new Expression("a+be*(4.5-3)>(30-1)*g",ctx);
//		try {
////			Double d = (Double)exp.compute();
//			boolean b = exp.doCompare();
//			System.out.println(b);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
