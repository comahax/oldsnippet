package com.sunrise.boss.business.common.managelog.persistent;

public class OperState {

	  public static final Integer SUCCESS = new Integer(0);
	  public static final Integer ERROR = new Integer(100);
	  public static final Integer ABORT = new Integer(200);

	  public static final String[] CODES = {
	      "", "0", "100", "200"};
	  public static final String[] NAMES = {
		  "", "完成", "出错", "终止"};

	  public static String getName(String code) {
	    if (code == null) {
	      return null;
	    }

	    for (int i = 0; i < CODES.length; i++) {
	      if (code.equals(CODES[i])) {
	        return NAMES[i];
	      }
	    }

	    return "";
	  }

	  public static String getCode(String name) {
	    if (name == null) {
	      return null;
	    }

	    for (int i = 0; i < NAMES.length; i++) {
	      if (name.equals(CODES[i])) {
	        return CODES[i];
	      }
	    }

	    return "";
	  }

}
