package com.gmcc.pboss.BgProcess.sales.bgHandle;

import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.BgProcess.base.SecurityPass;
import com.gmcc.pboss.business.sales.bankdeduct.BankdeductDBParam;
import com.gmcc.pboss.business.sales.bankdeduct.BankdeductVO;
import com.gmcc.pboss.common.bankunite.BankUniteProcessCom;
import com.gmcc.pboss.common.bankunite.model.receivebatch.request.RecBatchRequest;
import com.gmcc.pboss.common.bankunite.model.receivebatch.response.RecBatchResponse;
import com.gmcc.pboss.control.sales.bankdeduct.Bankdeduct;
import com.gmcc.pboss.control.sales.bankdeduct.BankdeductBO;
import com.gmcc.pboss.control.sales.bgcontrol.bankreceive.BankReceive;
import com.gmcc.pboss.control.sales.bgcontrol.bankreceive.BankReceiveBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * @author limin
 * 
 */
public class BankReceiveProcess extends BgBase {

	protected static final String mkey = "70469B26CBF1E575";
	
	/** ��������ļ����·�� */
	private String srcpath;
	/** ���߼����(����) */
	private static String intervalMin;

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		BankReceiveProcess pro = new BankReceiveProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = pro.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		pro
				.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/bgHandle/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		pro.setMyProfilePath("/sales/bgHandle/bankreceive.properties");
		// ��ʼ��
		pro.init(args);
		pro.runTask(user, intervalMin);
		// pro.bankReceive(user);

	}

	@Override
	protected void init(String[] args) throws Exception {
		super.init(args);
		intervalMin = properties.getProperty(args[0] + "_intervalMin");
		// ���߼����(����)
		if (intervalMin == null) {
			intervalMin = "300";
		}
		if ("".equals(intervalMin)) {
			intervalMin = "300";
		}
	}

	public void runTask(final User user, final String intervalMin)
			throws Exception {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				try {
					List list = queryBankdeDuct(user);
					if (list.size() > 0) {
						bankReceive(user, list);
					}
					log.info("����  " + intervalMin + "��");
				} catch (Exception e) {
					LoggerUtils.error(e, log);
				}
			}

		};
		try {
			String cityid = user.getCityid();

			float intervalMinFloat = Float.parseFloat(intervalMin);
			Timer timer = new Timer();
			timer.schedule(task, new Date(), (long) (intervalMinFloat * 1000));

		} catch (Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}

	public void bankReceive(User user, List list) throws Exception {
		BankReceive bankReceiveBo = (BankReceiveBO) BOFactory.build(
				BankReceiveBO.class, user);
		try {
			//��ȡ�����ļ�������
			String proFile = "/DealDataCollectProcess.properties";
			InputStream is = this.getClass().getResourceAsStream(proFile);
			Properties properties = new Properties();
			properties.load(is);
			is.close();
			String username = properties.getProperty(user.getCityid() + "_username");
			String password = properties.getProperty(user.getCityid() + "_password");
			password = new String(SecurityPass.decode(SecurityPass.hex2byte(password), SecurityPass.hex2byte(mkey)));
			String sendmax = properties.getProperty("sendmax");
			
			
			
			
			// ���ͱ���ǰ��Ԥ����
			List<RecBatchRequest> recBatchRequestlist = bankReceiveBo.doProcess(list, username, password, sendmax);
			// RecBatchRequest recBatchRequest = bankReceiveBo.doProcess(list);

			for (Iterator<RecBatchRequest> it = recBatchRequestlist.iterator(); it
					.hasNext();) {
				RecBatchRequest recBatchRequest = it.next();

				// ��������
				try {
					RecBatchResponse recBatchResponse = bankReceiveBo
							.sendInfo(recBatchRequest);

					boolean bo = false;

					// �����صı���
					if (recBatchResponse != null
							&& recBatchResponse.getInfo() != null
							&& recBatchResponse.getInfo().getRet_code() != null) {

						if ("0000".equals(recBatchResponse.getInfo()
								.getRet_code())) { // ��0000��������ϣ�ʱ��������Ҫ���ľ�����ϸ��Ӧ��
							bankReceiveBo.dealResponse(recBatchResponse);
						} else
							bo = true;
					} else
						bo = true;

					// ����0000ʱ���߷��ض����ǿյ�ʱ�򣬶����л��ۼ�¼�����ع�����
					if (bo) {
						bankReceiveBo.rollBackBankDeduct(list);
					}

				} catch (Exception e) {

				}
			}

		} catch (Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}

	public List<BankdeductVO> queryBankdeDuct(User user) throws Exception {
		Bankdeduct bankdeduct = (Bankdeduct) BOFactory.build(
				BankdeductBO.class, user);

		BankdeductDBParam bankdeductDBParam = new BankdeductDBParam();
		bankdeductDBParam.set_se_state("WAITPROC");
		List<BankdeductVO> list = bankdeduct.doQuery(bankdeductDBParam)
				.getDatas();
		return list;
	}

}
