package com.gmcc.pboss.common.config.xml;

import java.io.File;
import java.util.Hashtable;

public interface IXmlHandle {
    
    /**
     * @description:����XML�ķ����ӿڣ��ɸ���ʵ���Լ��ļ����߼���
     *              ���Ѽ��غ�Ķ��󱣴��ڼ����С�
     * @param: file-Ҫ���ص��ļ� <p>
     *         hashtable-�ļ����غ����ݱ���ļ���
     * @return:
     * @throws:
     */
    void load(File file, Hashtable hashtable) throws Exception;
}
