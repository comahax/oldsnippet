package com.asisinfo.common.container;


/**
 * @author Quake Wang
 * @since 2004-7-13
 * @version $Revision$
 */
public interface Container {
    public Object getComponent(Object key) throws ComponentNotFoundException;  

    public void reload();
    
    public void autowireComponent(Object bean);
}