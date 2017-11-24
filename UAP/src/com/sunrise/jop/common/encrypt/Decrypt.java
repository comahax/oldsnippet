/**
 * 
 */
package com.sunrise.jop.common.encrypt;

/**
 * <p>Title: 广东移动BOSS2.0用户密码解密</p>
 * <p>Description: </p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 冼育队
 * @version 1.0
 * @date 2010-10-26上午10:27:32
 */
public class Decrypt {

	  public static String decrypt(String inString) {
	    String base_64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
	    String buf = new String(inString);
	    String outString = null;
	    char outBuf[] = new char[32];
	    int reverse[] = new int[256];
	    int i = 0;
	    buf = buf.trim();
	    if (inString.length() != 8) {
	      return "";
	    }
	    for (i = 0; i < 256; i++) {
	      reverse[i] = -1;
	    }

	    for (i = 0; i < 64; i++) {
	      reverse[base_64.charAt(i)] = i;
	    }

	    for (i = 0; i < 6; i += 3) {
	      char b1 = (char) reverse[buf.charAt( (i / 3) * 4 + 0)];
	      char b2 = (char) reverse[buf.charAt( (i / 3) * 4 + 1)];
	      char b3 = (char) reverse[buf.charAt( (i / 3) * 4 + 2)];
	      char b4 = (char) reverse[buf.charAt( (i / 3) * 4 + 3)];
	      char a1 = (char) (b1 << 2 | b2 >> 4);
	      char a2 = (char) ( (b2 & 0xf) << 4 | b3 >> 2);
	      char a3 = (char) ( (b3 & 3) << 6 | b4);
	      outBuf[i + 0] = a1;
	      outBuf[i + 1] = a2;
	      outBuf[i + 2] = a3;
	    }

	    outString = new String(outBuf);
	    return outString.substring(0, 6);
	  }

	  public static String decrypt1(String inString) {
	    System.out.println("输入的密文："+inString);
	    String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
	    char[] base_64=base.toCharArray();
	    char[] buf2=new char[32];
	    char[] buf3=new char[32];
	    int[] reverse = new int[256];
	    char a1, a2, a3, b1, b2, b3, b4;
	    int i = 0;
	    int j = 0;
	    if (inString.length()>31) {
	           return "";
	    }
	    for(i=0;i<256;i++) reverse[i]=-1;
	    for(i=0;i<64;i++) reverse[base_64[i]]=i;
	    for(i=0;i<buf2.length;i++) buf2[i]=0x00;
	    for(i=0;i<buf3.length;i++) buf3[i]=0x00;
	    inString.trim();
	    buf2=inString.toCharArray();
	    int enpasslen = buf2.length;
	    for (i = 0; i < enpasslen / 4 * 3; i += 3) {
	      b1 =(char) reverse[buf2[i / 3 * 4 + 0]];
	      b2 =(char) reverse[buf2[i / 3 * 4 + 1]];
	      b3 =(char) reverse[buf2[i / 3 * 4 + 2]];
	      b4 =(char) reverse[buf2[i / 3 * 4 + 3]];
	      a1 =(char) ((b1 << 2) | (b2 >> 4));//(b1 << 2 | b2 >> 4);
	      a2 =(char) (( (b2 & 0x0f) << 4) | (b3 >> 2));
	      a3 =(char) (((b3 & 0x3) << 6) | b4);
	      buf3[i + 0] = a1;
	      buf3[i + 1] = a2;
	      buf3[i + 2] = a3;
	      j++;
	    }
	    if (2 == enpasslen % 4){//独立的一位密码原文，生成两位密文。解密的时候，如果密文两位，说明明文为一位
	      b1 =(char) reverse[buf2[j * 4 + 0]];
	      b2 =(char) reverse[buf2[j * 4 + 1]];
	      a1 =(char) ((b1 << 2) | (b2 >> 4));
	      buf3[3 * j + 0] = a1;
	    } else if (3 == enpasslen % 4) {//独立的2位密码原文，生成3位密文。解密的时候，如果密文3位，说明明文为2位
	      b1 =(char) reverse[buf2[j * 4 + 0]];
	      b2 =(char) reverse[buf2[j * 4 + 1]];
	      b3 =(char) reverse[buf2[j * 4 + 2]];
	      a1 =(char) ((b1 << 2) | (b2 >> 4));
	      a2 =(char) (( (b2 & 0x0f) << 4) | (b3 >> 2));
	      buf3[3 * j + 0] = a1;
	      buf3[3 * j + 1] = a2;
	    } else if (0 == enpasslen % 4){
	    } else {
	      return "";
	    }
	    String result= new String(buf3);
	    System.out.println("输出的明文："+result);
	    return result.trim();
	  }
	  public static void main(String[] args){
	    if (args[0].equals("1"))
	      System.out.println(Decrypt.decrypt(args[1]) + "!");
	    if (args[0].equals("2"))
	      System.out.println(Decrypt.decrypt1(args[1]) + "!");
	  }
	}