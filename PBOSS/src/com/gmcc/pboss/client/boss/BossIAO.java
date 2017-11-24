/**
 * 
 */
package com.gmcc.pboss.client.boss;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import open.tool.socketserver.ClientUtils;
import open.tool.socketserver.data.PackageMessage;
import open.tool.socketserver.utils.CoreUtils;

import com.gmcc.pboss.client.boss.result.CancelAccountResult;
import com.gmcc.pboss.client.boss.result.IncomeAccountResult;
import com.gmcc.pboss.client.boss.send.CancelAccountDataPack;
import com.gmcc.pboss.client.boss.send.ChargeData;
import com.gmcc.pboss.client.boss.send.IncomeAccountDataPack;

/**
 * BOSS Interface Access Object
 * 
 * ���ڶ� Э����������ԭ����ֻ��dataTrans������ʵ����Ҫ����Ļ�������ͷ�Ͱ���������Ϣ�Ĵ����������open.tool.socketserver�����д���
 * @author hbm
 * 
 */
public class BossIAO {

	// ������Ʒ����BOSS����ʵʱ�ӿ� 52210
	public IncomeAccountResult incomeAccount(IncomeAccountDataPack data,String cityID) {
		BossSocket socket = null;
		try {
			socket = BossSocketFactory.build(cityID);
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			DataInputStream in = new DataInputStream(socket.getInputStream());
			
			byte[] send = ClientUtils.bytes("52210", BossProtocol.packForIncomeAccount(data)); // pack
			out.write(send);
			out.flush();

			byte begin = in.readByte();
			byte[] buff = new byte[in.available()+1];
			buff[0] = begin;
			in.readFully(buff, 1, buff.length-1);
			PackageMessage pm = CoreUtils.bytesToPackageMessage(buff);
			
			return BossProtocol.unpackForIncomeAccount(pm.getDataTrans()); // unpack

		} catch (IOException e) {
			socket.setLive(false);
			throw new BossException(e);
		} finally {
			BossSocketFactory.gather(socket);
		}
	}

	// ������Ʒ����BOSS������ʵʱ�ӿ� 52211
	public CancelAccountResult cancelAccount(CancelAccountDataPack data,String cityID) {
		BossSocket socket = null;
		try {
			socket = BossSocketFactory.build(cityID);
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			DataInputStream in = new DataInputStream(socket.getInputStream());

			byte[] send = ClientUtils.bytes("52211", BossProtocol.packForCancelAccount(data)); // pack
			out.write(send);
			out.flush();

			byte begin = in.readByte();
			byte[] buff = new byte[in.available()+1];
			buff[0] = begin;
			in.readFully(buff, 1, buff.length - 1);

			PackageMessage pm = CoreUtils.bytesToPackageMessage(buff);
			
			return BossProtocol.unpackForCancelAccount(pm.getDataTrans()); // unpack

		} catch (IOException e) {
			socket.setLive(false);
			throw new BossException(e);
		} finally {
			BossSocketFactory.gather(socket);
		}
	}

	static public void main(String[] av) {
		BossIAO bossIAO = new BossIAO();
		IncomeAccountDataPack data1 = new IncomeAccountDataPack();
		data1.setWayid("wayid");
		data1.setPbossNo("123456789");
		data1.setOprcode("hbm");
		data1.setFeeStr("100");
		ChargeData cd = new ChargeData();
		cd.setChargeType(ChargeData.CHARGE_TYPE_POS);
		cd.setMoney("100");
		cd.setPosNo("987654321");
		data1.setChargeData(cd);

		IncomeAccountResult result1 = bossIAO.incomeAccount(data1,"ZS");
		System.out.println(result1.getRet());
		System.out.println(result1.getExplain());
		System.out.println(result1.getBossNo());
		System.out.println(result1.getOther());
	}
}
