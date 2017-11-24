package com.sunrise.boss.ui.qsmanage.paramsmanage.batchparamset;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import com.sunrise.boss.business.fee.qsmanage.common.utils.QsUtils;
import com.sunrise.boss.business.qsmanage.paramrules.impfielddeta.persistent.ImpFieldDetaListVO;
import com.sunrise.boss.business.qsmanage.paramrules.impfielddeta.persistent.ImpFieldDetaVO;
import com.sunrise.boss.business.qsmanage.paramrules.imprule.persistent.ImpRuleVO;
import com.sunrise.boss.business.qsmanage.paramrules.imptabledeta.persistent.ImpTableDetaListVO;
import com.sunrise.boss.business.qsmanage.paramrules.imptabledeta.persistent.ImpTableDetaVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.delegate.fee.qsmanage.common.QsCommonDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.PublicUtils;
import com.sunrise.pub.tools.StringSplit;
/**
 * 
 * @author wangguangying 20090320
 *
 */
public class BatchParamSetTaskBean extends BaseBatchTaskBean {

	private static final long serialVersionUID = 441397927042809931L;

	private ImpRuleVO rulevo;

	private DataPackage dp;

	private Long matchid;
	
	private HashMap tablemap = new HashMap();

	public DataPackage getDp() {
		return dp;
	}

	public void setDp(DataPackage dp) {
		this.dp = dp;
	}

	public ImpRuleVO getRulevo() {
		return rulevo;
	}

	public void setRulevo(ImpRuleVO rulevo) {
		this.rulevo = rulevo;
	}

	protected String doStart() {
		initbat();
		return buildStart();
	}
/**
 * 初始化此bean中的几个变量
 *
 */
	private void initbat() {
		try {
			CommonDelegate ruledele = new CommonDelegate(ImpRuleVO.class);
			this.setRulevo((ImpRuleVO) ruledele.doFindByPk(getRuleid(), user));
			
			CommonDelegate fielddele = new CommonDelegate(ImpFieldDetaVO.class);
			ImpFieldDetaListVO listVO = new ImpFieldDetaListVO();
			listVO.set_ne_ruleid(getRuleid().toString());
			listVO.set_orderby("fieldindex");
			listVO.set_desc("asc");
			listVO.set_pagesize("0");
			this.setDp(fielddele.doQuery(listVO, user, false));

			this.setMatchid(ruledele.getSequence("qscs_chg_req_matchid_seq",
					user));

			CommonDelegate tabledele = new CommonDelegate(ImpTableDetaVO.class);
			ImpTableDetaListVO tablist = new ImpTableDetaListVO();
			tablist.set_ne_ruleid(getRuleid().toString());
			DataPackage tabdp = tabledele.doQuery(tablist, user, false);
			List list = tabdp.toList(ImpTableDetaVO.class);
			for(int i = 0 ; i < list.size() ; i++){
				ImpTableDetaVO detavo = (ImpTableDetaVO) list.get(i);
				Object entvo = Class.forName(detavo.getEntparam()).newInstance();
				getTablemap().put(detavo.getTabfoml(), entvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * 拼装结果文件的文件头
	 * @return
	 */
	private String buildStart() {
		StringBuffer starttext = new StringBuffer("序号|");
		for (int i = 0; i < getDp().getDatas().size(); i++) {
			ImpFieldDetaVO detavo = (ImpFieldDetaVO) getDp().toList(
					ImpFieldDetaVO.class).get(i);
			starttext.append(detavo.getFieldname()).append(
					getRulevo().getSepchar());
		}
		starttext.append("处理结果").append(getRulevo().getSepchar()).append("\r\n");
		return starttext.toString();
	}

	/**
	 * 处理一条记录
	 */
	public ResultVO processLine(String line, int rowCount) {

		String msg = null;
		ResultVO resultVO = new ResultVO();
		String[] items = StringSplit.split(line, getRulevo().getSepchar());

		try {
			for (int i = 0; i < getDp().getDatas().size(); i++) {
				ImpFieldDetaVO detavo = (ImpFieldDetaVO) getDp().toList(
						ImpFieldDetaVO.class).get(i);
				int index = detavo.getFieldindex().intValue();
				index = index < 0 ? -index : index ;
				if (detavo.getMainfield().intValue() == 1
						&& (items[index-1] == null || "".equals(items[index-1]))) {
					throw new Exception(detavo.getFieldname() + "字段不能为空！！ ");
				}
				if (detavo.getMainfield().intValue() == 2
						&& (items[index-1] == null || "".equals(items[index-1]))) {
					if(detavo.getDefaultvalue().equals("sqlsysdate")){
						Date newdate = new Date(System.currentTimeMillis());
						String date = PublicUtils.utilDateToStr(newdate).substring(0, 7) + "-01" ;
						items[index-1] = date;
					}else if(detavo.getDefaultvalue().equals("utilsysdate")){
						java.util.Date newdate = new Date(System.currentTimeMillis());
						String date = PublicUtils.utilDateToStr(newdate).substring(0, 7) + "-01 00:00:00" ;
						items[index-1] = date;
					}else{
						items[index-1] = detavo.getDefaultvalue();
					}
				}
				BeanUtils.setProperty((Serializable) getTablemap().get(detavo.getTabcode()), detavo
						.getFieldcode(), QsUtils.checkVarible(detavo, items[index-1]));
			}
			QsCommonDelegate delegate = new QsCommonDelegate(null);
			delegate.doBatch(tablemap, matchid, getChgreason(), user);

			msg = "成功";
			resultVO.setOk(true);
		} catch (BusinessException ex) {
			msg = ex.getCode();
			resultVO.setOk(false);
		}catch (Exception ex) {
			ex.printStackTrace();
			msg = "失败!" + ex.getMessage();
			resultVO.setOk(false);
		}
		resultVO.setInfo(buildResultInfo(resultVO.isOk(), line, rowCount, msg));
		return resultVO;
	}

	/**
	 * 生成结果信息,用于生成结果文件用
	 * 
	 * @param resultVO
	 * @param line
	 * @param i
	 * @return
	 */
	private String buildResultInfo(boolean result, String line, int i, String msg) {
		final String COMPART = getRulevo().getSepchar(); // 分隔
		StringBuffer resultInfo = new StringBuffer();
		resultInfo.append(i).append(COMPART);
		resultInfo.append(line);
		resultInfo.append(msg);
		resultInfo.append(COMPART).append("\r\n");
		return resultInfo.toString();
	}

	private Long getRuleid() {
		return Long.valueOf((String) parameterMap.get("ruleid"));
	}
	
	private String getChgreason(){
		return (String) parameterMap.get("chgreason");
	}

	public Long getMatchid() {
		return matchid;
	}

	public void setMatchid(Long matchid) {
		this.matchid = matchid;
	}

	public HashMap getTablemap() {
		return tablemap;
	}

	public void setTablemap(HashMap tablemap) {
		this.tablemap = tablemap;
	}


}
