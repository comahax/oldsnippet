package com.gmcc.pboss.web.channel.common;

import java.io.File;

public class CMSConstant {
    private CMSConstant() {
    }
   

    public final static String GMCC = "GMCC";
    public final static int POSTIL_FILEDATA_LENGTH = 4; // 批量批复文件（附加资料文件的）每行数据的长度
    
    /* 正则表达式 */
    /* 匹配"yyyy-MM-dd"格式的字符串, yyyy限制为4为数字, 其中MM[00-12], dd[00-31] */
    public final static String DATE_REGEX = "^\\d{4}-{1}(0{1}[0-9]{1}|1{1}[012]{1})-{1}(0{1}[0-9]{1}|[12]{1}\\d{1}|3{1}[01]{1})$";
    
    public final static String COMMAND_STATE = "STATE";
    public final static String COMMAND_STEP = "STEP";
    public final static String COMMAND_RECID = "RECID";
    public final static String COMMAND_FLOWFLAG = "FLOWFLAG";
    public final static String COMMAND_NEXT = "NEXT";
    public final static String COMMAND_BACK = "BACK";
    public final static String RESOPRDATA_RESTYPE_APPLY = "1"; // 资源单类型（申请）
    public final static String RESOPRDATA_RESTYPE_PUT = "2"; // 资源单类型（发放）
    public final static String RESOPRDATA_RESTYPE_BACK = "3"; // 资源单类型（回收）
    public final static String RESOPRDATA_RESTYPE_INDEPOT = "4"; // 资源单类型（入库）

    public final static String COMMAND_MAIN = "MAIN"; // 转到main页面
    public final static String COMMAND_RELEASE = "RELEASE"; // 发布发放申请单（保存）
    public final static String COMMAND_UPDATE = "UPDATE"; // 申请单更新（修改）
    public final static String COMMAND_TOPUT = "TOPUT"; // 转到发放（批复）标签页
    public final static String COMMAND_TOBATCHPOSTIL = "TOBATCHPOSTIL"; // 转到批量批复标签页
    public final static String COMMAND_PUT = "PUT"; // 发放
    public final static String COMMAND_BATCHPOSTIL = "BATCHPOSTIL"; // 批量批复
    public final static String COMMAND_UNIFYPUT = "UNIFYPUT"; // 统一发放
    public final static String COMMAND_LEACHTYPE = "LEACHTYPE"; // 过滤商品类型
    public final static String COMMAND_LEACHID = "LEACHID"; // 过滤商品标识
    public final static String COMMAND_SUBMIT = "SUBMIT"; // 提交
    public final static String COMMAND_DENY = "DENY"; // 拒绝
    public final static String COMMAND_TOSEND = "TOSEND"; // 转到资源配送单页面
    public final static String COMMAND_TOPRINT = "TOPRINT"; // 转到打印配送单页面
    public final static String COMMAND_UPDATE_SENDNO = "UPDATE_SENDNO"; // 更新配送单号
    public final static String COMMAND_INCEPT = "INCEPT"; // 接收
    public final static String COMMAND_SHOWDIALOG = "SHOWDIALOG"; // 弹出框命令
    
    
    /* 有价物类别 */
    public final static short CH_GOODSCLASS_INTEGRAL = 2; // 积分卡类
    public final static short CH_GOODSCLASS_SIM = 5; // SIM卡
    public final static short CH_GOODSCLASS_OTHERS = 99; // 其他
    
    /* 页面参数  */
    /* 配送单用 */
    public final static String SEND = "SEND"; // 标识是否是配送单页面 
    public final static String NOT_TOBE_SEND = "NOT_TOBE_SEND"; // 申请单页面（配送营销物资） 
    public final static String TOBE_SEND = "TOBE_SEND"; // 待配送页面（资源配送单）
    public final static String REQUEST_PARAMETER_SENDNO = "SENDNO"; // 配送单号
    public final static String REQUEST_PARAMETER_AGAIN = "AGAIN"; // 再此保存配送单号
    public final static String REQUEST_PARAMETER_PRINTTIME = "PRINTTIME"; // 打印时间
    public final static String REQUEST_PARAMETER_PRINTCODE = "PRINTCODE"; // 打印人（操作员）工号
    public final static String PAGE_ATTRIBUTE_ERRORMSG = "ERRORMSG"; // 错误信息标志
    public final static String REQUEST_PARAMETER_RECID = "RECID"; // 资源单标识
    /* PUT */
    public final static String REQUEST_PARAMETER_OPINION = "OPINION"; // 评审意见
    
    /* 页面翻译 */
    public final static String TRANSLATE_IM_COMTYPE = "IM_COMTYPE"; // 商品类型翻译组ID
    public final static String TRANSLATE_COMTYPE = "COMTYPE"; // 商品类型翻译
    
    /* 固定参数 */
    public final static String DICTITEM_IM_SIMTYPE = "IM_SIMTYPE"; // SIM卡类型
    
    /* 按钮屏蔽 */
    public final static String BUTTON_SAVE_DISABLED = "SAVE_DISABLED"; // 保存按钮被屏蔽
    public final static String BUTTON_SEND_DISABLED = "SEND_DISABLED"; // 发放按钮被屏蔽
    
    /* 流程步骤 */
    public final static short FLOW_STEP_ONE = 0;
    public final static short FLOW_STEP_TWO = 1;
    public final static short FLOW_STEP_THREE = 2;
    public final static short FLOW_STEP_FOUR = 3;
    public final static short FLOW_STEP_FIVE = 4;
    public final static short FLOW_STEP_SIX = 5;
    public final static short FLOW_STEP_SEVEN = 6;
    
    //信息管理部分
    public final static Short MAIL_STATE_SHORT = new Short("0");//邮件
    public final static Short MESSAGE_STATE_SHORT = new Short("1");//公告
    public final static Short REMSG_STATE_SHORT = new Short("2");//回复
    public final static String MAIL_ADDR_SPLIT = ",";
    public final static String APPENDIX_UPLOADPATH = File.separator+"upload"+File.separator+"cms"+File.separator+"mail"+File.separator;
    public final static String REQUEST_ATTRIBUTE_FOLDERSEQ = "FOLDERSEQ";
    public final static String REQUEST_ATTRIBUTE_GROUPSEQ = "GROUPSEQ";

    /* 库存运营监控 */
    /* 页面参数 */
    public final static String REQUEST_PARAMETER_REARTIME = "REARTIME"; // 实时查询
    
    //合同信息上传保存位置
    public final static String COMPACT_UPLOADPATH = File.separator+"upload"+File.separator+"cms"+File.separator+"compact"+File.separator;

}
