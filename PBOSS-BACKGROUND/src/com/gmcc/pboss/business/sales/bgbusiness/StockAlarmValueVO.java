package com.gmcc.pboss.business.sales.bgbusiness;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * װ����߿���Ԥ����ֵ��VO
 * @author 
 *
 */
public class StockAlarmValueVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long maxstock;//��߿��
	private String alarmvalue;//����ͷ�ֵ��Ԥ������ͷ�ֵ����ϣ���ð�źͷֺż����Ԥ���������FX_STOCKALARMLEVEL
	
	public Long getMaxstock() {
		return maxstock;
	}

	public void setMaxstock(Long maxstock) {
		this.maxstock = maxstock;
	}

	public String getAlarmvalue() {
		return alarmvalue;
	}

	public void setAlarmvalue(String alarmvalue) {
		this.alarmvalue = alarmvalue;
	}

	public StockAlarmValueVO() {
	}
	
	public StockAlarmValueVO(Long maxstock) {
		this.maxstock = maxstock;
	}
	
	public StockAlarmValueVO(Long maxstock,String level,String alarmvalue) {
		this.maxstock = maxstock;
		this.alarmvalue = alarmvalue;
	}
	
	public boolean equals(Object other) {
		 if ( !(other instanceof StockAlarmValueVO) ) return false;
		 StockAlarmValueVO castOther = (StockAlarmValueVO) other;
	        return new EqualsBuilder()
	            .append(this.getMaxstock(), castOther.getMaxstock())
	            .append(this.getAlarmvalue(), castOther.getAlarmvalue())
	            .isEquals();
	}
	
	public int hashCode() {
        return new HashCodeBuilder()
            .append(getMaxstock())
            .append(getAlarmvalue())
            .toHashCode();
    }
}
