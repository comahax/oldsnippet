package com.sunrise.boss.ui.commons;

public class WebConstant {
    private WebConstant() {
    }
    //基本信息
    public static final String COMMAND_STRING_WAYID = "_se_wayid";
    public static final String COMMAND_STRING_ERROR = "ERROR";

    public final static String SESSION_ATTRIBUTE_AUTHEN_STATE = "AUTHEN_STATE";
    public final static String SESSION_ATTRIBUTE_LINES = "LINES";
    public final static String SESSION_ATTRIBUTE_USER = "_USER"; //添加下划线，和PBOSS的USER区分

    //
    public final static String SESSION_ATTRIBUTE_CALLSTATUS = "CALLSTATUS";
    public final static String SESSION_ATTRIBUTE_QUERYLOG = "QUERYLOG";
    public final static String SESSION_ATTRIBUTE_YXACTDIS = "YXACTDIS";  //是否有弹出页面(客户主动营销任务)

    // 页面提示信息的KEY，主要用于在页面上处理业务后，显示一些如‘成功’等提示信息
    public final static String PAGE_ATTRIBUTE_MESSAGE = "MESSAGE";

    public final static String PAGE_ATTRIBUTE_LIST = "LIST";
    public final static String PAGE_ATTRIBUTE_ITEM = "ITEM";
    public final static String PAGE_ATTRIBUTE_INFO = "INFO";
//    public final static String PAGE_ATTRIBUTE_ISEDIT = "ISEDIT";
    public final static String PAGE_ATTRIBUTE_PUBINFO = "PUBINFO";
    public final static String PAGE_ATTRIBUTE_CURRENT = "CURRENT";
    public final static String PAGE_ATTRIBUTE_NEXT = "NEXT";

    public final static String PAGE_ATTRIBUTE_COMMAND = "CMD";
    public final static String PAGE_ATTRIBUTE_EXPORT= "EXPORT";
    
    
    public static final String COMMAND_STRING_VIEW = "VIEW";
    public static final String COMMAND_STRING_LIST = "LIST";
    public static final String COMMAND_STRING_LISTNOCOUNT = "LISTNOCOUNT";
    public static final String COMMAND_STRING_NEW = "NEW";
    public static final String COMMAND_STRING_EDIT = "EDIT";
    public static final String COMMAND_STRING_EDITNEW = "EDITNEW";
    public static final String COMMAND_STRING_SAVE = "SAVE";
    public static final String COMMAND_STRING_DELETE = "DELETE";
    public static final String COMMAND_STRING_TOEXCEL = "TOEXCEL";
    public static final String COMMAND_STRING_TOTXT = "TOTXT";

    public final static String REQUEST_ATTRIBUTE_HELPID = "HELPID";

    public final static String REQUEST_ATTRIBUTE_MPK = "MPK";
    public final static String REQUEST_ATTRIBUTE_TARGET = "TARGET";
    public final static String REQUEST_ATTRIBUTE_MASTERDETAIL = "MASTERDETAIL";
    public final static String REQUEST_ATTRIBUTE_MTBUSIOPRID = "MTBUSIOPRID";
    public final static String REQUEST_ATTRIBUTE_SERVCONTROLID = "SERVCONTROLID";
    public final static String REQUEST_ATTRIBUTE_CMDSTATE = "cmdState";
    public final static String REQUEST_CACHE = "REQUEST_CACHE";
    
    
    
    public final static String DEFAULT_PAGE = "1";
    public final static String DEFAULT_LINES_PER_PAGE = "20";

    public final static String STRING_TRUE = "TRUE";

    public final static String ERROR_SUMMARY = "ERROR_SUMMARY";
    public final static String ERROR_DETAIL = "ERROR_DETAIL";

    //====处理后信息参数====//
    //处理后返回的信息
    public final static String OPERATED_MESSAGE = "OPERATED_MESSAGE";
    //成功处理后，页面条转的url，格式为/xxx/xxx.jsp or /xx/xxx.do
    public final static String OPERATED_LOCATION = "OPERATED_LOCATION";
    //字串 true false
    public final static String OPERATED_ISSUCCESS = "OPERATED_ISSUCCESS";

    // form提交的按钮，恢复可用状态，格式 formName.buttonName，省却为btnSubmit
    public final static String OPERATED_SUBMITBUTTON = "OPERATED_SUBMITBUTTON";

    //public final static String OPERATED_GOBACKONLY = "OPERATED_GOBACKONLY";
    //====处理后信息参数====//
    //add code
    public final static String REQUEST_ATTRIBUTE_PK = "PK";
    public final static String STRING_FALSE = "FALSE";
    public final static String PAGE_ATTRIBUTE_ISNEW = "ISNEW";
    public final static String REQUEST_ATTRIBUTE_KEY = "KEY";
    //=====页面参数的分隔符号=======//
    public final static String PAGE_SPLIT_SYMBOL = "\\|";
    
    public final static String CACHE_SELECT_PARAMETER_NAME="cachename";
    //短信类型    不同模块填写不同数字
//  0:渠道管理
    public final static Short SMS_TYPE_CH_0=0;
//    1:系统管理
    public final static Short SMS_TYPE_SYS_1=1;
//    2:沟通管理 
    public final static Short SMS_TYPE_GT_2=2;
//    3:分销管理
    public final static Short SMS_TYPE_SALE_3=3;
//    4:资源管理
    public final static Short SMS_TYPE_RES_4=4;
//    5.酬金管理
    public final static Short SMS_TYPE_REWARD_5=5;
//    6.促销管理   
    public final static Short SMS_TYPE_PROM_6=6;
//    7.考核管理 
    public final static Short SMS_TYPE_KH_7=7;
//    8.其它
    public final static Short SMS_TYPE_OTHER_8=8;


}
