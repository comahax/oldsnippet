package com.gmcc.pboss.common.utils.tools;

import java.util.HashMap;

import open.tool.rule.Strategy;
import open.tool.rule.Tree;

/**
 * 促销管理模块中解析运算表达式的业务策略
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
			if (rightTree.getValue() == null) { // 数字、数字
				String expression = leftTree.getTreeName()+operator+rightTree.getTreeName();
				throw new RuntimeException("表达式 "+expression+" 不合法");
			} else {// 数字、集合
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
					// 当数据集为空(即没有记录)的情况
					throw new RuntimeException("实例 [ "+rightTree.getTreeName()+" ] 的数据集为空");
				}*/
			}
		} else {
			if (rightTree.getValue() == null) { // 集合、数字
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
					throw new RuntimeException("实例 [ "+leftTree.getTreeName()+" ] 的数据集为空");
				}*/
			} else {// 集合、集合
				HashMap left = leftTree.getValue();
				HashMap right = rightTree.getValue();
				
				if(left != null && left.size() > 0 ) { // 左孩子返回的数据集不为空
					
					if(right != null && right.size() > 0) {
						for (Object key : left.keySet()) {
							double lValue = left.get(key) == null ? 0 : (Double) left.get(key);
							
							double rValue = right.get(key) == null ? 0 : (Double)right.get(key);
							Object value = run(lValue, rValue, operator);
							result.put(key, value);
						}
					}else {
						// 若右孩子返回的数据集为空，则右孩子的业务量以 0 参与表达式运算
						for (Object key : left.keySet()) {
							double lValue = left.get(key) == null ? 0 : (Double) left.get(key);
							Object value = run(lValue, 0, operator);
							result.put(key, value);
						}
					}
				}else { // 左孩子返回的数据集为空
					
					// 若右孩子返回的数据集不为空，则左孩子的业务量以 0 参与表达式运算
					if(right != null && right.size() > 0) {
						for (Object key : right.keySet()) {
							double rValue = right.get(key) == null ? 0 : (Double)right.get(key);
							Object value = run(0, rValue, operator);
							result.put(key, value);
						}
					}
				}
				/*else {
					throw new RuntimeException("实例 [ "+leftTree.getTreeName()+" ] 的数据集为空");
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
				// 若除数为0,赋予result一个足够大的值,暂定1000
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
			throw new RuntimeException("无效操作符 operator[" + operator + "]");
		}
		return result;
	}
	// 除
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
