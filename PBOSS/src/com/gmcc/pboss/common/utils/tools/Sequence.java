package com.gmcc.pboss.common.utils.tools;

import java.net.InetAddress;

/**
 * <p>���к����������÷����£�</p>
 * <pre>
 * Sequence.getInstance().getXXX();
 * </pre>
 *
 * @author Gaven
 * @version 1.0
 */

public class Sequence {
    private static Sequence me;
//  private static CounterDelegate counterDelegate;

    // ȡIP�����һλ�������ڼ�Ⱥ��IP�����һλ�ǲ���ͬ�ģ���ȡ����SEQҲ����ͬ
    private static final int IP;
    static {
        int ipadd;
        try {
            String hostadd = InetAddress.getLocalHost().getHostAddress();
            ipadd = Integer.parseInt(hostadd.substring(hostadd.length() - 1));
        }
        catch (Exception e) {
            ipadd = 0;
        }
        IP = ipadd;
    }

    /**
     * �������кŵĻ������������������10��N�η���һ������ֻ��ȡ��������һ�����к�
     */
    private static final int base = 10;
    private static long millis, old;

    private Sequence()
        throws Exception {
//    counterDelegate = new CounterDelegate();
    }

    /**
     * ȡ��һ������λ����ʵ��
     */
    public static synchronized Sequence getInstance()
        throws Exception {
        if (me == null) {
            me = new Sequence();
        }
        return me;
    }

    /**
     * ȡ�������кţ����к���ʱ����أ��ǵ�ǰ�ĺ����������һ�����ظ���������
     * @return ���к�
     */
    public static synchronized long getSequence()
        throws SequenceException {
        long result = System.currentTimeMillis();
        if (result == millis) {
            old++;
            if (old >= (millis + 1) * base) {
                throw new SequenceException("�Ѵﵽ�������ڵ�������к�");
            }
            result = old;
        }
        else {
            millis = result;
            result *= base;
            old = result;
        }
        return result * 10 + IP;
    }
    /**
     * todo
     * @param strTime
     * @return
     */
//  public static synchronized long getSequence(String name) throws SequenceException {
//    try {
////      return counterDelegate.getNextValue(name);
//    }
//    catch (Exception ex) {
//      throw new SequenceException("ȡ����ָ�������кţ�" + ex.getMessage());
//    }
//  }

//  public static long getMinSeqByTime(String strTime) {
//    try {
//      Date date = DateUtil.parseDateTime(strTime);
//      return date.getTime() * base;
//    }
//    catch (Exception ex) {
//    }
//
//    return 0;
//  }
//
//  public static long getMaxSeqByTime(String strTime) {
//    try {
//      Date date = DateUtil.parseDateTime(strTime);
//      return (date.getTime() + 1000) * base; // ��һ��
//    }
//    catch (Exception ex) {
//    }
//    return 0;
//  }
}
