package com.sunrise.boss.ui.commons.taglib.code2name;

import com.sunrise.boss.ui.commons.User;

public interface Code2name {
    /**
     * Code2NameTag��ǩ����ø÷���
     *
     * @param code Object    Ҫ�������code
     * @return String        �������ַ���
     */
    public String translate(Object code,User user)throws Exception;
}
