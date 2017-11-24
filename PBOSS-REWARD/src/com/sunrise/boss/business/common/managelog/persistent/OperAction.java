package com.sunrise.boss.business.common.managelog.persistent;

public class OperAction {

	  public static final String INSERT = "INSERT";
	  public static final String DELETE = "DELETE";
	  public static final String UPDATE = "UPDATE";

	  public static final String[] CODES = {
	      "", "INSERT", "DELETE", "UPDATE"};
	  public static final String[] NAMES = {
	      "", "ÐÂ½¨", "É¾³ý", "ÐÞ¸Ä"};

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
