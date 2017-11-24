package com.gmcc.pboss.business.sales.disformprint;

import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.business.sales.disform.DisformVO;

public class DisformFullInfo implements Serializable {
	private DisformVO disVO;
	private List<ComIccInfo> comIcc;
	
	public DisformFullInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DisformFullInfo(DisformVO disVO, List<ComIccInfo> comIcc) {
		super();
		this.disVO = disVO;
		this.comIcc = comIcc;
	}

	public DisformVO getDisVO() {
		return disVO;
	}

	public void setDisVO(DisformVO disVO) {
		this.disVO = disVO;
	}

	public List<ComIccInfo> getComIcc() {
		return comIcc;
	}

	public void setComIcc(List<ComIccInfo> comIcc) {
		this.comIcc = comIcc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comIcc == null) ? 0 : comIcc.hashCode());
		result = prime * result + ((disVO == null) ? 0 : disVO.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DisformFullInfo other = (DisformFullInfo) obj;
		if (comIcc == null) {
			if (other.comIcc != null)
				return false;
		} else if (!comIcc.equals(other.comIcc))
			return false;
		if (disVO == null) {
			if (other.disVO != null)
				return false;
		} else if (!disVO.equals(other.disVO))
			return false;
		return true;
	}		
}
