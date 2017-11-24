package com.sunrise.boss.business.resmanage.interf.constant;

/**
 * <p>
 * Title: BOSS1.5
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * 
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Rodney
 * @version 下午04:13:182006-8-29
 */
public class InterfConstant {
	public static final String COMP = "|";

	public static final String RESDELEGATE_CFG_PATH = "/com/sunrise/boss/business/resmanage/interf/interface.cfg.xml";

	public InterfConstant getInstance() {
		return new InterfConstant();
	}

	/**
	 * 资源操作类型
	 */
	public static final int RESTYPE_COMRESCARD = 0; // 刮卡类（表示单独销售的卡，如神州行充值卡）

	public static final int RESTYPE_COMRESPHONE = 1; // 手机类

	public static final int RESTYPE_VIPCARD = 2; // 积分卡类

	public static final int RESTYPE_COMRESSMP = 3; // SIM套卡类（表示整套销售的并含有SIM卡在内的套卡，如神州行/动感地带/随e卡等）

	public static final int RESTYPE_COMRESTICKET = 4; // 电子充值券

	public static final int RESTYPE_SIMCARD = 5; // SIM卡

	public static final int RESTYPE_COMRESOTHER = 99; // 其他

	/**
	 * 资源操作动作
	 */
	public static final int RESOPRTYPE_BATCHIN = 0; // 入库

	public static final int RESOPRTYPE_DISTRIBUTE = 1; // 发放

	public static final int RESOPRTYPE_RECYCLE = 2; // 回收

	public static final int RESOPRTYPE_DELETE = 3; // 删除

	public static final int RESOPRTYPE_UPDATESTATE = 4; // 状态修改

	public static final int RESOPRTYPE_SEND = 5; // 配送

	public static final String CMD_RESOPRTYPE_BATCHIN = "/batchin"; // 入库

	public static final String CMD_RESOPRTYPE_DISTRIBUTE = "/distribute"; // 发放

	public static final String CMD_RESOPRTYPE_RECYCLE = "/recycle"; // 回收

	public static final String CMD_RESOPRTYPE_DELETE = "/delete"; // 删除

	public static final String CMD_RESOPRTYPE_UPDATESTATE = "/updatestate"; // 状态修改

	public static final String CMD_RESOPRTYPE_SEND = "/send"; // 配送

	String Path = "/resmanage";

	public String setPath(Long restype, Long oprtype) {
		if (restype != null) {
			switch (restype.intValue()) {
			case RESTYPE_COMRESCARD:
				Path += "/comrescard";
				break;
			case RESTYPE_COMRESPHONE:
				Path += "/comresphone";
				break;
			case RESTYPE_VIPCARD:
				Path += "/vipcard";
				break;
			case RESTYPE_COMRESSMP:
				Path += "/comressmp";
				break;
			case RESTYPE_COMRESTICKET:
				Path += "/comresticket";
				break;
			case RESTYPE_SIMCARD:
				Path += "/sim";
				break;
			case RESTYPE_COMRESOTHER:
				Path += "/comresother";
				break;
			default:
				break;
			}
			if (oprtype != null) {
				switch (oprtype.intValue()) {
				case RESOPRTYPE_BATCHIN:
					Path += "/batchin";
					break;
				case RESOPRTYPE_DISTRIBUTE:
					Path += "/distribute";
					break;
				case RESOPRTYPE_RECYCLE:
					Path += "/recycle";
					break;
				case RESOPRTYPE_DELETE:
					Path += "/delegate";
					break;
				case RESOPRTYPE_UPDATESTATE:
					Path += "/updatestate";
					break;
				case RESOPRTYPE_SEND:
					Path += "/send";
					break;
				default:
					break;
				}
			}
		}
		return Path;
	}
}
