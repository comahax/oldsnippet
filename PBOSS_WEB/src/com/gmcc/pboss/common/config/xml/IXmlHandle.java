package com.gmcc.pboss.common.config.xml;

import java.io.File;
import java.util.Hashtable;

public interface IXmlHandle {
    
    /**
     * @description:加载XML的方法接口，由各人实现自己的加载逻辑，
     *              并把加载后的对象保存在集合中。
     * @param: file-要加载的文件 <p>
     *         hashtable-文件加载后数据保存的集合
     * @return:
     * @throws:
     */
    void load(File file, Hashtable hashtable) throws Exception;
}
