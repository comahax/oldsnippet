package com.gmcc.pboss.common.config;

import java.io.File;
import com.gmcc.pboss.common.config.exception.FileConfigException;
import com.gmcc.pboss.common.config.xml.IXmlHandle;


public interface IConfigHandle {
    
    File loadFile(String fileCode)throws FileConfigException;
    
    Object loadProperty(String fileCode, String property, IXmlHandle handle)throws FileConfigException;
    
}
