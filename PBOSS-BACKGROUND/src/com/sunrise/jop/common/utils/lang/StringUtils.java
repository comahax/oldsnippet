package com.sunrise.jop.common.utils.lang;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author douglas
 * @version 1.0
 */

import java.security.*;
import java.text.*;
import java.util.*;
import java.sql.Timestamp;

/**
 * Utility class to peform common String manipulation algorithms.
 */
public class StringUtils extends org.apache.commons.lang.StringUtils{

    /**
     * Initialization lock for the whole class. Init's only happen once per
     * class load so this shouldn't be a bottleneck.
     */
    private static Object initLock = new Object();

    /**
     * Replaces all instances of oldString with newString in line.
     *
     * @param line the String to search to perform replacements on
     * @param oldString the String that should be replaced by newString
     * @param newString the String that will replace all instances of oldString
     *
     * @return a String will all instances of oldString replaced by newString
     */
    public static final String replace( String line, String oldString, String newString )
    {
        if (line == null) {
            return null;
        }
        int i=0;
        if ( ( i=line.indexOf( oldString, i ) ) >= 0 ) {
            char [] line2 = line.toCharArray();
            char [] newString2 = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(line2.length);
            buf.append(line2, 0, i).append(newString2);
            i += oLength;
            int j = i;
            while( ( i=line.indexOf( oldString, i ) ) > 0 ) {
                buf.append(line2, j, i-j).append(newString2);
                i += oLength;
                j = i;
            }
            buf.append(line2, j, line2.length - j);
            return buf.toString();
        }
        return line;
    }

    /**
     * Replaces all instances of oldString with newString in line with the
     * added feature that matches of newString in oldString ignore case.
     *
     * @param line the String to search to perform replacements on
     * @param oldString the String that should be replaced by newString
     * @param newString the String that will replace all instances of oldString
     *
     * @return a String will all instances of oldString replaced by newString
     */
    public static final String replaceIgnoreCase(String line, String oldString,
            String newString)
    {
        if (line == null) {
            return null;
        }
        String lcLine = line.toLowerCase();
        String lcOldString = oldString.toLowerCase();
        int i=0;
        if ( ( i=lcLine.indexOf( lcOldString, i ) ) >= 0 ) {
            char [] line2 = line.toCharArray();
            char [] newString2 = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(line2.length);
            buf.append(line2, 0, i).append(newString2);
            i += oLength;
            int j = i;
            while( ( i=lcLine.indexOf( lcOldString, i ) ) > 0 ) {
                buf.append(line2, j, i-j).append(newString2);
                i += oLength;
                j = i;
            }
            buf.append(line2, j, line2.length - j);
            return buf.toString();
        }
        return line;
    }

   /**
    * Replaces all instances of oldString with newString in line.
    * The count Integer is updated with number of replaces.
    *
    * @param line the String to search to perform replacements on
    * @param oldString the String that should be replaced by newString
    * @param newString the String that will replace all instances of oldString
    *
    * @return a String will all instances of oldString replaced by newString
    */
    public static final String replace( String line, String oldString,
            String newString, int[] count)
    {
        if (line == null) {
            return null;
        }
        int i=0;
        if ( ( i=line.indexOf( oldString, i ) ) >= 0 ) {
            int counter = 0;
            counter++;
            char [] line2 = line.toCharArray();
            char [] newString2 = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(line2.length);
            buf.append(line2, 0, i).append(newString2);
            i += oLength;
            int j = i;
            while( ( i=line.indexOf( oldString, i ) ) > 0 ) {
                counter++;
                buf.append(line2, j, i-j).append(newString2);
                i += oLength;
                j = i;
            }
            buf.append(line2, j, line2.length - j);
            count[0] = counter;
            return buf.toString();
        }
        return line;
    }

    /**
     * This method takes a string which may contain HTML tags (ie, &lt;b&gt;,
     * &lt;table&gt;, etc) and converts the '&lt'' and '&gt;' characters to
     * their HTML escape sequences.
     *
     * @param input the text to be converted.
     * @return the input string with the characters '&lt;' and '&gt;' replaced
     *  with their HTML escape sequences.
     */
    public static final String escapeHTMLTags( String input ) {
        //Check if the string is null or zero length -- if so, return
        //what was sent in.
        if( input == null || input.length() == 0 ) {
            return input;
        }
        //Use a StringBuffer in lieu of String concatenation -- it is
        //much more efficient this way.
        StringBuffer buf = new StringBuffer(input.length());
        char ch = ' ';
        for( int i=0; i<input.length(); i++ ) {
            ch = input.charAt(i);
            if( ch == '<' ) {
                buf.append("&lt;");
            }
            else if( ch == '>' ) {
                buf.append("&gt;");
            }
            else {
                buf.append( ch );
            }
        }
        return buf.toString();
    }

    /**
     * Used by the hash method.
     */
    private static MessageDigest digest = null;

    /**
     * Hashes a String using the Md5 algorithm and returns the result as a
     * String of hexadecimal numbers. This method is synchronized to avoid
     * excessive MessageDigest object creation. If calling this method becomes
     * a bottleneck in your code, you may wish to maintain a pool of
     * MessageDigest objects instead of using this method.
     * <p>
     * A hash is a one-way function -- that is, given an
     * input, an output is easily computed. However, given the output, the
     * input is almost impossible to compute. This is useful for passwords
     * since we can store the hash and a hacker will then have a very hard time
     * determining the original password.
     * <p>
     * In Jive, every time a user logs in, we simply
     * take their plain text password, compute the hash, and compare the
     * generated hash to the stored hash. Since it is almost impossible that
     * two passwords will generate the same hash, we know if the user gave us
     * the correct password or not. The only negative to this system is that
     * password recovery is basically impossible. Therefore, a reset password
     * method is used instead.
     *
     * @param data the String to compute the hash of.
     * @return a hashed version of the passed-in String
     */
    public synchronized static final String hash(String data) {
        if (digest == null) {
            try {
                digest = MessageDigest.getInstance("MD5");
            }
            catch (NoSuchAlgorithmException nsae) {
                System.err.println("Failed to load the MD5 MessageDigest. " +
                "Jive will be unable to function normally.");
                nsae.printStackTrace();
            }
        }
        //Now, compute hash.
        digest.update(data.getBytes());
        return toHex(digest.digest());
    }

    /**
     * Turns an array of bytes into a String representing each byte as an
     * unsigned hex number.
     * <p>
     * Method by Santeri Paavolainen, Helsinki Finland 1996<br>
     * (c) Santeri Paavolainen, Helsinki Finland 1996<br>
     * Distributed under LGPL.
     *
     * @param hash an rray of bytes to convert to a hex-string
     * @return generated hex string
     */
    public static final String toHex (byte hash[]) {
        StringBuffer buf = new StringBuffer(hash.length * 2);
        int i;

        for (i = 0; i < hash.length; i++) {
            if (((int) hash[i] & 0xff) < 0x10) {
                buf.append("0");
            }
            buf.append(Long.toString((int) hash[i] & 0xff, 16));
        }
        return buf.toString();
    }

    /**
     * Converts a line of text into an array of lower case words. Words are
     * delimited by the following characters: , .\r\n:/\+
     * <p>
     * In the future, this method should be changed to use a
     * BreakIterator.wordInstance(). That class offers much more fexibility.
     *
     * @param text a String of text to convert into an array of words
     * @return text broken up into an array of words.
     */
    public static final String [] toLowerCaseWordArray(String text) {
        if (text == null || text.length() == 0) {
                return new String[0];
        }
        StringTokenizer tokens = new StringTokenizer(text, " ,\r\n.:/\\+");
        String [] words = new String[tokens.countTokens()];
        for (int i=0; i<words.length; i++) {
            words[i] = tokens.nextToken().toLowerCase();
        }
        return words;
    }

    /**
     * A list of some of the most common words. For searching and indexing, we
     * often want to filter out these words since they just confuse searches.
     * The list was not created scientifically so may be incomplete :)
     */
    private static final String [] commonWords =  new String [] {
        "a", "and", "as", "at", "be", "do", "i", "if", "in", "is", "it", "so",
        "the", "to"
    };
    private static Map commonWordsMap = null;

    /**
     * Returns a new String array with some of the most common English words
     * removed. The specific words removed are: a, and, as, at, be, do, i, if,
     * in, is, it, so, the, to
     */
    public static final String [] removeCommonWords(String [] words) {
        //See if common words map has been initialized. We don't statically
        //initialize it to save some memory. Even though this a small savings,
        //it adds up with hundreds of classes being loaded.
        if (commonWordsMap == null) {
            synchronized(initLock) {
                if (commonWordsMap == null) {
                    commonWordsMap = new HashMap();
                    for (int i=0; i<commonWords.length; i++) {
                        commonWordsMap.put(commonWords[i], commonWords[i]);
                    }
                }
            }
        }
        //Now, add all words that aren't in the common map to results
        ArrayList results = new ArrayList(words.length);
        for (int i=0; i<words.length; i++) {
            if (!commonWordsMap.containsKey(words[i])) {
                results.add(words[i]);
            }
        }
        return (String[])results.toArray(new String[results.size()]);
    }

    /**
     * Pseudo-random number generator object for use with randomString().
     * The Random class is not considered to be cryptographically secure, so
     * only use these random Strings for low to medium security applications.
     */
    private static Random randGen = null;

    /**
     * Array of numbers and letters of mixed case. Numbers appear in the list
     * twice so that there is a more equal chance that a number will be picked.
     * We can use the array to get a random number or letter by picking a random
     * array index.
     */
    private static char[] numbersAndLetters = null;

    /**
     * Returns a random String of numbers and letters of the specified length.
     * The method uses the Random class that is built-in to Java which is
     * suitable for low to medium grade security uses. This means that the
     * output is only pseudo random, i.e., each number is mathematically
     * generated so is not truly random.<p>
     *
     * For every character in the returned String, there is an equal chance that
     * it will be a letter or number. If a letter, there is an equal chance
     * that it will be lower or upper case.<p>
     *
     * The specified length must be at least one. If not, the method will return
     * null.
     *
     * @param length the desired length of the random String to return.
     * @return a random String of numbers and letters of the specified length.
     */
    public static final String randomString(int length) {
        if (length < 1) {
            return null;
        }
        //Init of pseudo random number generator.
        if (randGen == null) {
            synchronized (initLock) {
                if (randGen == null) {
                    randGen = new Random();
                    //Also initialize the numbersAndLetters array
                    numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz" +
                    "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
                }
            }
        }
        //Create a char buffer to put random letters and numbers in.
        char [] randBuffer = new char[length];
        for (int i=0; i<randBuffer.length; i++) {
            randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
        }
        return new String(randBuffer);
    }

   /**
    * Intelligently chops a String at a word boundary (whitespace) that occurs
    * at the specified index in the argument or before. However, if there is a
    * newline character before <code>length</code>, the String will be chopped
    * there. If no newline or whitespace is found in <code>string</code> up to
    * the index <code>length</code>, the String will chopped at <code>length</code>.
    * <p>
    * For example, chopAtWord("This is a nice String", 10) will return
    * "This is a" which is the first word boundary less than or equal to 10
    * characters into the original String.
    *
    * @param string the String to chop.
    * @param length the index in <code>string</code> to start looking for a
    *       whitespace boundary at.
    * @return a substring of <code>string</code> whose length is less than or
    *       equal to <code>length</code>, and that is chopped at whitespace.
    */
    public static final String chopAtWord(String string, int length) {
        if (string == null) {
            return string;
        }

        char [] charArray = string.toCharArray();
        int sLength = string.length();
        if (length < sLength) {
            sLength = length;
        }

        //First check if there is a newline character before length; if so,
        //chop word there.
        for (int i=0; i<sLength-1; i++) {
            //Windows
            if (charArray[i] == '\r' && charArray[i+1] == '\n') {
                return string.substring(0, i);
            }
            //Unix
            else if (charArray[i] == '\n') {
                return string.substring(0, i);
            }
        }
        //Also check boundary case of Unix newline
        if (charArray[sLength-1] == '\n') {
            return string.substring(0, sLength-1);
        }

        //Done checking for newline, now see if the total string is less than
        //the specified chop point.
        if (string.length() < length) {
            return string;
        }

        //No newline, so chop at the first whitespace.
        for (int i = length-1; i > 0; i--) {
            if (charArray[i] == ' ') {
                return string.substring(0, i).trim();
            }
        }

        //Did not find word boundary so return original String chopped at
        //specified length.
        return string.substring(0, length);
    }

    /**
     * Highlights words in a string. Words matching ignores case. The actual
     * higlighting method is specified with the start and end higlight tags.
     * Those might be beginning and ending HTML bold tags, or anything else.
     *
     * @param string the String to highlight words in.
     * @param words an array of words that should be highlighted in the string.
     * @param startHighlight the tag that should be inserted to start highlighting.
     * @param endHighlight the tag that should be inserted to end highlighting.
     * @return a new String with the specified words highlighted.
     */
    public static final String highlightWords(String string, String[] words,
        String startHighlight, String endHighlight)
    {
        if (string == null || words == null ||
                startHighlight == null || endHighlight == null)
        {
            return null;
        }

        //Iterate through each word.
        for (int x=0; x<words.length; x++) {
            //we want to ignore case.
            String lcString = string.toLowerCase();
            //using a char [] is more efficient
            char [] string2 = string.toCharArray();
            String word = words[x].toLowerCase();

            //perform specialized replace logic
            int i=0;
            if ( ( i=lcString.indexOf( word, i ) ) >= 0 ) {
                int oLength = word.length();
                StringBuffer buf = new StringBuffer(string2.length);

                //we only want to highlight distinct words and not parts of
                //larger words. The method used below mostly solves this. There
                //are a few cases where it doesn't, but it's close enough.
                boolean startSpace = false;
                char startChar = ' ';
                if (i-1 > 0) {
                    startChar = string2[i-1];
                    if (!Character.isLetter(startChar)) {
                        startSpace = true;
                    }
                }
                boolean endSpace = false;
                char endChar = ' ';
                if (i+oLength<string2.length) {
                    endChar = string2[i+oLength];
                    if (!Character.isLetter(endChar))  {
                        endSpace = true;
                    }
                }
                if ((startSpace && endSpace) || (i==0 && endSpace)) {
                    buf.append(string2, 0, i);
                    if (startSpace && startChar==' ') { buf.append(startChar); }
                    buf.append(startHighlight);
                    buf.append(string2, i, oLength).append(endHighlight);
                    if (endSpace && endChar==' ') { buf.append(endChar); }
                }
                else {
                    buf.append(string2, 0, i);
                    buf.append(string2, i, oLength);
                }

                i += oLength;
                int j = i;
                while( ( i=lcString.indexOf( word, i ) ) > 0 ) {
                    startSpace = false;
                    startChar = string2[i-1];
                    if (!Character.isLetter(startChar)) {
                        startSpace = true;
                    }

                    endSpace = false;
                    if (i+oLength<string2.length) {
                        endChar = string2[i+oLength];
                        if (!Character.isLetter(endChar))  {
                            endSpace = true;
                        }
                    }
                    if ((startSpace && endSpace) || i+oLength==string2.length) {
                        buf.append(string2, j, i-j);
                        if (startSpace && startChar==' ') { buf.append(startChar); }
                        buf.append(startHighlight);
                        buf.append(string2, i, oLength).append(endHighlight);
                        if (endSpace && endChar==' ') { buf.append(endChar); }
                    }
                    else {
                        buf.append(string2, j, i-j);
                        buf.append(string2, i, oLength);
                    }
                    i += oLength;
                    j = i;
                }
                buf.append(string2, j, string2.length - j);
                string = buf.toString();
            }
        }
        return string;
    }

    /**
     * Escapes all necessary characters in the String so that it can be used
     * in an XML doc.
     *
     * @param string the string to escape.
     * @return the string with appropriate characters escaped.
     */
    public static final String escapeForXML(String string) {
        //Check if the string is null or zero length -- if so, return
        //what was sent in.
        if (string == null || string.length() == 0 ) {
            return string;
        }
        char [] sArray = string.toCharArray();
        StringBuffer buf = new StringBuffer(sArray.length);
        char ch;
        for (int i=0; i<sArray.length; i++) {
            ch = sArray[i];
            if(ch == '<') {
                buf.append("&lt;");
            }
            else if (ch == '&') {
                buf.append("&amp;");
            }
            else if (ch == '"') {
                buf.append("&quot;");
            }
            else {
                buf.append(ch);
            }
        }
        return buf.toString();
    }

    public static final String formatDate(Timestamp date) {
      if (date == null)
        return "";
      DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT);
      return df.format(date);
    }

    public static final String formatDateTime(Timestamp date) {
      if (date == null)
        return "";
      DateFormat df = DateFormat.getDateTimeInstance(DateFormat.DEFAULT,DateFormat.DEFAULT);
      return df.format(date);
    }


    public static final Timestamp String2Date(String sdate) {
      DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT);
      try {
        return new Timestamp(df.parse(sdate).getTime());
      }
      catch (ParseException ex) {
        return null;
      }
    }

    public static final Timestamp String2DateTime(String sdate) {
      DateFormat df = DateFormat.getDateTimeInstance(DateFormat.DEFAULT,DateFormat.DEFAULT);
      try {
        return new Timestamp(df.parse(sdate).getTime());
      }
      catch (ParseException ex) {
        return null;
      }
    }

    /**
     * ���ض��ַ����ض��ָ��ָ������\uFFFD
     * The string "boo:and:foo",
     * Regex     Result
     *   :      { "boo", "and", "foo" }
     *   o      { "b", "", ":and:f" }
     * @param strSrc String
     * @param regex String
     * @return String[]
     */
    public static String[] tokenizeByRegex(String strSrc, String regex) {
      String[] strRst = null;
      if (isValuedString(strSrc) && isValuedString(regex)) {
        strRst = strSrc.split(regex);
      }
      return strRst;
    }
    /**
     *�ж�һ���ַ��Ƿ�Ϊnull���ǿ��ַ�<p>
     *
     * @param str The string for checking
     * @return true if the string is neither null nor empty string
     */
    public static boolean isValuedString(String str) {
      return str != null && !str.trim().equals("");
    }

    /**
     * ���ַ������ָ�����ȷ�Χ��\uFFFD
     * @param content String
     * @param length int
     * @return String
     */
    public static String getLimitLengthString(String content, int length) {
      if ( content==null )
        return "";

      if (content.length() > length) {
        content = content.substring(0, length) + "...";
      }
      return content;
    }







    /**
     * ģ��ƥ�䣬desΪǰ���У�����ʽ
     * @param src String
     * @param dec String
     * @return boolean
     */
    public static boolean blurEquals(String src, String dec) {
      boolean isMatch = false;
      if (dec.startsWith("%") && dec.endsWith("%")) { //ǰ���У�
        if (src.indexOf(dec.substring(1, dec.length() - 1)) != -1) {
          isMatch = true;
        }
      }
      else if (dec.startsWith("%")) {
        if (src.endsWith(dec.substring(1))) {
          isMatch = true;
        }
      }
      else if (dec.endsWith("%")) {
        if (src.startsWith(dec.substring(0, dec.length() - 1))) {
          isMatch = true;
        }
      }
      else {
        if (src.equals(dec)) {
          isMatch = true;

        }
      }
      return isMatch;
    }






    /**
     * ���ַ��ISO��ʽת��Ϊgb2312��ʽ
     * @param str
     * @return
     */
    public static String ISOtoGB(String str) {
      if (str == null || str.trim().length() == 0) {
        return "";
      }
      try {
        str = new String(str.getBytes("ISO-8859-1"), "gb2312");
      }
      catch (Exception e) {
        System.err.println("StringUtils.java:ISOtoGB():" + e);
      }
      return str;
    }

    /**
     * ���ַ��gb2312��ʽת��ΪISO��ʽ
     * @param str
     * @return
     */
    public static String GBtoISO(String str) {
      if (str == null || str.trim().length() == 0) {
        return "";
      }
      try {
        str = new String(str.getBytes("gb2312"), "ISO-8859-1");
      }
      catch (Exception e) {
        System.err.println("StringUtils.java:GBtoISO():" + e);
      }

      return str;
    }

    public  static List splitToVecString(String in, String delimiter) {
        List q = new ArrayList();

        if( in == null || in.length() == 0 ){
            return q;
        }

        int pos =0;
        pos = in.indexOf(delimiter);
        String val = null;
        while (pos >= 0) {
            if (pos>0) {
                val = in.substring(0,pos);
            }
            q.add(val);
            in = in.substring(pos + delimiter.length(), in.length());
            pos = in.indexOf(delimiter);
        }
        if (in.length() > 0) {
            q.add(in);
        }
        return q;
    }

    /**
     * �滻�ַ���
     * @param src String
     * @param from String
     * @param to String
     * @return String
     */
    public static String replaceAll( String src, String from, String to ) {
      if ( src==null || src.length()<1 )
        return src;
      if ( from==null || to==null || from.equals(to) )
        return src;

      int tmpIndex = -1;
      while ( (tmpIndex=src.indexOf(from))!=-1 ) {
        src = src.substring(0,tmpIndex)+to+src.substring(tmpIndex+from.length());
      }
      return src;
    }

    public static String toUpperFisrtChar( String src ) {
      if ( src==null || src.length()<1 )
        return "";

      String first = src.substring(0,1);
      return first.toUpperCase()+src.substring(1, src.length() );
    }
    
    /**
     * �ж�mobileno�ǲ����ƶ��ֻ���
     * @param mobileno
     * @return
     */
    public static boolean isMobileno(String mobileno) {
    	boolean result = false;
    	long min = 13400000000L;
    	long max = 13999999999L;
    	try{
    		long no = Long.parseLong(mobileno);
    		if(no>=min&&no<=max){
    			result = true;
    		}
    	}catch(Exception e){
//    		throw new Exception("�ֻ��Ű�����ĸ��");
    	}
    	return result;
    }
    
    /**
     * ������isValuedString,ͬapacheһ��
     * @param str
     * @return
     * @author Canigar
     */
    public static boolean isEmpty(String str){
    	return !StringUtils.isValuedString(str);
    }
    
    /**
     * ������isValuedString,ͬapacheһ��
     * @param str
     * @return
	 * @author Canigar
     */
    public static boolean isNotEmpty(String str){
    	return StringUtils.isValuedString(str);
    }
    
    /**
     * ����StringSplit,ͬapacheһ��
     * @param str
     * @param split
	 * @author Canigar
     * @return
     */
	public static String[] split(String str, String split) {
		return StringSplit.split(str, split);
	}
    
  }
