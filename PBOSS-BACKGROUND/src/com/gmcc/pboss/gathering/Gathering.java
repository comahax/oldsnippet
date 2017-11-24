package com.gmcc.pboss.gathering;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 用于促销管理 数据采集模块 中的程序采集方式
 * 根据 [采集逻辑] 给出的具体类来采集数据;
 * 这些具体类都必须实现此接口
 * </pre>
 * @author zhangsiwei
 *
 */
public interface Gathering {

	public List gather(Map factor);
}
