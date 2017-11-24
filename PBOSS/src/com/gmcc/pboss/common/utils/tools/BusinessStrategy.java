package com.gmcc.pboss.common.utils.tools;

import java.util.HashMap;

import open.tool.rule.Strategy;
import open.tool.rule.Tree;

/**
 * ��������ģ���н���������ʽ��ҵ�����
 * @author zhangsiwei
 *
 */
public class BusinessStrategy implements Strategy {

	protected HashMap common(Tree leftTree, Tree rightTree, final String operator) {
		if (leftTree.getValue() == null && leftTree.getTreeName() == null) {
			leftTree.execute(this);
		}
		if (rightTree.getValue() == null && rightTree.getTreeName() == null) {
			rightTree.execute(this);
		}

		HashMap result = new HashMap();

		if (leftTree.getValue() == null) {
			if (rightTree.getValue() == null) { // ���֡�����
				String expression = leftTree.getTreeName()+operator+rightTree.getTreeName();
				throw new RuntimeException("���ʽ "+expression+" ���Ϸ�");
			} else {// ���֡�����
				double lValue = Double.valueOf(leftTree.getTreeName());
				HashMap right = rightTree.getValue();
				if(right != null && right.size() > 0) {
					for (Object key : right.keySet()) {
						double rValue = right.get(key) == null ? 0:(Double) right.get(key);
	
						Object value = run(lValue, rValue, operator);
						result.put(key, value);
					}
				}
				/*else {
					// �����ݼ�Ϊ��(��û�м�¼)�����
					throw new RuntimeException("ʵ�� [ "+rightTree.getTreeName()+" ] �����ݼ�Ϊ��");
				}*/
			}
		} else {
			if (rightTree.getValue() == null) { // ���ϡ�����
				HashMap left = leftTree.getValue();
				double rValue = Double.valueOf(rightTree.getTreeName());
				if(left != null && left.size() > 0) {
					for (Object key : left.keySet()) {
						double lValue = left.get(key) == null ? 0:(Double) left.get(key);
						Object value = run(lValue, rValue, operator);
						result.put(key, value);
					}
				}
				/*else {
					throw new RuntimeException("ʵ�� [ "+leftTree.getTreeName()+" ] �����ݼ�Ϊ��");
				}*/
			} else {// ���ϡ�����
				HashMap left = leftTree.getValue();
				HashMap right = rightTree.getValue();
				
				if(left != null && left.size() > 0 ) { // ���ӷ��ص����ݼ���Ϊ��
					
					if(right != null && right.size() > 0) {
						for (Object key : left.keySet()) {
							double lValue = left.get(key) == null ? 0 : (Double) left.get(key);
							
							double rValue = right.get(key) == null ? 0 : (Double)right.get(key);
							Object value = run(lValue, rValue, operator);
							result.put(key, value);
						}
					}else {
						// ���Һ��ӷ��ص����ݼ�Ϊ�գ����Һ��ӵ�ҵ������ 0 ������ʽ����
						for (Object key : left.keySet()) {
							double lValue = left.get(key) == null ? 0 : (Double) left.get(key);
							Object value = run(lValue, 0, operator);
							result.put(key, value);
						}
					}
				}else { // ���ӷ��ص����ݼ�Ϊ��
					
					// ���Һ��ӷ��ص����ݼ���Ϊ�գ������ӵ�ҵ������ 0 ������ʽ����
					if(right != null && right.size() > 0) {
						for (Object key : right.keySet()) {
							double rValue = right.get(key) == null ? 0 : (Double)right.get(key);
							Object value = run(0, rValue, operator);
							result.put(key, value);
						}
					}
				}
				/*else {
					throw new RuntimeException("ʵ�� [ "+leftTree.getTreeName()+" ] �����ݼ�Ϊ��");
				}*/
			}
		}

		return result;
	}
	
	protected Object run(double lValue, double rValue, String operator) {
		Object result = null;
		if ("+".equals(operator)) {
			result = lValue + rValue;
		} else if ("-".equals(operator)) {
			result = lValue - rValue;
		} else if ("*".equals(operator)) {
			result = lValue * rValue;
		} else if ("/".equals(operator)) {
			if(rValue == 0) {
				// ������Ϊ0,����resultһ���㹻���ֵ,�ݶ�1000
				result = (double)1000;
			}else {
				result = lValue / rValue;
			}
			
		} else if (">".equals(operator)) {
			result = (lValue > rValue);
		} else if ("<".equals(operator)) {
			result = (lValue < rValue);
		} else if (">=".equals(operator)) {
			result = (lValue >= rValue);
		} else if ("<=".equals(operator)) {
			result = (lValue <= rValue);
		} else if ("!=".equals(operator)) {
			result = (lValue != rValue);
		} else if ("==".equals(operator)) {
			result = (lValue == rValue);
		} else {
			throw new RuntimeException("��Ч������ operator[" + operator + "]");
		}
		return result;
	}
	// ��
	public HashMap divide(Tree leftTree, Tree rightTree) {
		final String operator = "/";
		return common(leftTree, rightTree, operator);
	}

	public HashMap less(Tree leftTree, Tree rightTree) {
		final String operator = "<";
		return common(leftTree, rightTree, operator);
	}

	public HashMap lessEqual(Tree leftTree, Tree rightTree) {
		final String operator = "<=";
		return common(leftTree, rightTree, operator);
	}

	public HashMap minus(Tree leftTree, Tree rightTree) {
		final String operator = "-";
		return common(leftTree, rightTree, operator);
	}

	public HashMap more(Tree leftTree, Tree rightTree) {
		final String operator = ">";
		return common(leftTree, rightTree, operator);
	}

	public HashMap moreEqual(Tree leftTree, Tree rightTree) {
		final String operator = ">=";
		return common(leftTree, rightTree, operator);
	}

	public HashMap notEqual(Tree leftTree, Tree rightTree) {
		final String operator = "!=";
		return common(leftTree, rightTree, operator);
	}

	public HashMap plus(Tree leftTree, Tree rightTree) {
		final String operator = "+";
		return common(leftTree, rightTree, operator);
	}

	public HashMap multiply(Tree leftTree, Tree rightTree) {
		final String operator = "*";
		return common(leftTree, rightTree, operator);
	}

	public HashMap equal(Tree leftTree, Tree rightTree) {
		final String operator = "==";
		return common(leftTree, rightTree, operator);
	}

}
