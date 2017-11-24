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
 * @version ����04:13:182006-8-29
 */
public class InterfConstant {
	public static final String COMP = "|";

	public static final String RESDELEGATE_CFG_PATH = "/com/sunrise/boss/business/resmanage/interf/interface.cfg.xml";

	public InterfConstant getInstance() {
		return new InterfConstant();
	}

	/**
	 * ��Դ��������
	 */
	public static final int RESTYPE_COMRESCARD = 0; // �ο��ࣨ��ʾ�������۵Ŀ����������г�ֵ����

	public static final int RESTYPE_COMRESPHONE = 1; // �ֻ���

	public static final int RESTYPE_VIPCARD = 2; // ���ֿ���

	public static final int RESTYPE_COMRESSMP = 3; // SIM�׿��ࣨ��ʾ�������۵Ĳ�����SIM�����ڵ��׿�����������/���еش�/��e���ȣ�

	public static final int RESTYPE_COMRESTICKET = 4; // ���ӳ�ֵȯ

	public static final int RESTYPE_SIMCARD = 5; // SIM��

	public static final int RESTYPE_COMRESOTHER = 99; // ����

	/**
	 * ��Դ��������
	 */
	public static final int RESOPRTYPE_BATCHIN = 0; // ���

	public static final int RESOPRTYPE_DISTRIBUTE = 1; // ����

	public static final int RESOPRTYPE_RECYCLE = 2; // ����

	public static final int RESOPRTYPE_DELETE = 3; // ɾ��

	public static final int RESOPRTYPE_UPDATESTATE = 4; // ״̬�޸�

	public static final int RESOPRTYPE_SEND = 5; // ����

	public static final String CMD_RESOPRTYPE_BATCHIN = "/batchin"; // ���

	public static final String CMD_RESOPRTYPE_DISTRIBUTE = "/distribute"; // ����

	public static final String CMD_RESOPRTYPE_RECYCLE = "/recycle"; // ����

	public static final String CMD_RESOPRTYPE_DELETE = "/delete"; // ɾ��

	public static final String CMD_RESOPRTYPE_UPDATESTATE = "/updatestate"; // ״̬�޸�

	public static final String CMD_RESOPRTYPE_SEND = "/send"; // ����

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
