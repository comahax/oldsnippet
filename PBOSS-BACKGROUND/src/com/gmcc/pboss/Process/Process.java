package com.gmcc.pboss.Process;

import java.util.List;
/**
 * 后台程序处理类统一实现此接口
 * @author zhangsiwei
 *
 */
public interface Process {

	public void handler(List params) throws Exception;
}
