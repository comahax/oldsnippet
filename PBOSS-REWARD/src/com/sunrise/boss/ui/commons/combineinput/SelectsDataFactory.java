package com.sunrise.boss.ui.commons.combineinput;

/**
 * <p>Title: SelectsDataFactory </p>
 * <p>Description: 工厂类方法 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Sunrise Tech Ltd.</p>
 * @author Zhang Fengchao
 * @since 1.0
 * @version 1.0
 * @date 2007-11-16
 */
public class SelectsDataFactory {
	public static SelectsData build (String definition) {
		try {
			ConfigBean cfg = ConfigMap.getConfigBean(definition);
			if (null == cfg || null == cfg.getClassname()) {
				return null;
			}
			return (SelectsData) Class.forName(cfg.getClassname()).newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
