package com.sunrise.boss.business.fee.billing.rhtouchrule.persistent;

import java.util.ArrayList;
import java.util.List;

public class ResultVO {

	  private String cityid;
	  private Integer validbillcyc;
	  private Short flstate;
	  private Short flischeck;
	  private Short lzstate;
	  private Short lzischeck;
	  private Short lzstate2;
	    private Short lzischeck2;
	  
	  
	  private static String NOSTART = "0";
	  private static String RUNNING =  "1";
	  private static String COMPLETE =  "2";
	  private static String WRONG =  "3";
	  
	public ResultVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ResultVO(String cityid, Integer validbillcyc, Short flstate, Short lzstate, Short lzstate2) {
		super();
		// TODO Auto-generated constructor stub
		this.cityid = cityid;
		this.validbillcyc = validbillcyc;
		this.flstate = flstate;
		this.lzstate = lzstate;
		this.lzstate2 = lzstate2;
	}


	
	public Short getFlischeck() {
		return flischeck;
	}


	public void setFlischeck(Short flischeck) {
		this.flischeck = flischeck;
	}


	public Short getLzischeck() {
		return lzischeck;
	}


	public void setLzischeck(Short lzischeck) {
		this.lzischeck = lzischeck;
	}


	public Short getLzischeck2() {
		return lzischeck2;
	}


	public void setLzischeck2(Short lzischeck2) {
		this.lzischeck2 = lzischeck2;
	}


	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public Short getFlstate() {
		return flstate;
	}
	public void setFlstate(Short flstate) {
		this.flstate = flstate;
	}
	public Short getLzstate() {
		return lzstate;
	}
	public void setLzstate(Short lzstate) {
		this.lzstate = lzstate;
	}
	public Short getLzstate2() {
		return lzstate2;
	}
	public void setLzstate2(Short lzstate2) {
		this.lzstate2 = lzstate2;
	}
	public Integer getValidbillcyc() {
		return validbillcyc;
	}
	public void setValidbillcyc(Integer validbillcyc) {
		this.validbillcyc = validbillcyc;
	}
	  

	
	
	/**
	 * 优先级: 3 -> 1 -> 2 -> 0
	 * @param list  
	 * @return String
	 */
	public static String chkState(List list) {
		String state = NOSTART;
		StringBuffer _strBState = new StringBuffer();

		if (null != list) {

			for (int i = 0; i < list.size(); i++) {

				Object ob = (Object) list.get(i);
				String _state = ob == null ? "0" : ob.toString();
				_strBState.append(_state);

				if (WRONG.equals(_state)) {
					return _state;
				}
				if (RUNNING.equals(_state)) {
					state = _state;
				}
			}
			if (RUNNING.equals(state)) {
				return state;
			}

			String _strState = _strBState.toString();
			if (_strState.indexOf(COMPLETE) == -1) {
				return NOSTART;
			}
			if (_strState.indexOf(NOSTART) == -1) {
				return COMPLETE;
			}
			return RUNNING;
		}

		return state;
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List list = new ArrayList();
		list.add(new Short("0"));
		list.add(new Short("6"));
	
		System.out.println(chkState(list));
		;
	}
}
