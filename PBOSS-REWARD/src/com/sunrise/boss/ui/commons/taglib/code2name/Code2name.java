package com.sunrise.boss.ui.commons.taglib.code2name;

import com.sunrise.boss.ui.commons.User;

public interface Code2name {
    /**
     * Code2NameTag标签会调用该方法
     *
     * @param code Object    要被翻译的code
     * @return String        翻译后的字符串
     */
    public String translate(Object code,User user)throws Exception;
}
