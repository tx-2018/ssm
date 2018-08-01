package com.fw.util;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
/**
 * StringUtil类
 * 
 */
public final class StringUtil {
	public static final String EMPTY_STRING = "";

	public static final char DOT = '.';

	public static final char UNDERSCORE = '_';

	public static final String COMMA_SPACE = ", ";

	public static final String COMMA = ",";

	public static final String OPEN_PAREN = "(";

	public static final String CLOSE_PAREN = ")";

	public static final char SINGLE_QUOTE = '\'';
	
	public static final int PAD_LEFT = 1;
	
	public static final int PAD_RIGHT = 2;

	/**
	 * 对字符串进行填充
	 * 
	 * @param str
	 *            要填充的字符串
	 * @param c
	 *            用于进行填充的字符
	 * @param totalLength
	 *            总长度
	 * @param padtype
	 *            填充类型：1 前面填充 2 后面填充
	 * @return 填充后字符串
	 */
	public static String pad(String str, char c, int totalLength, int padtype) {

		if(str == null)
			// 如果传入空串则返回null
			return null;
		if(str.length() >= totalLength)
			// 如果字符串长度不小于总长度，则截取字符串前面部分
			return str.substring(0, totalLength);
		String result = "";
		int zeroLength = totalLength - str.length();
		for(int i = 0; i < zeroLength; i++)
			result += c;
		switch(padtype) {
			case 1:// 前面填充
				result += str;
				break;
			case 2:// 后面填充
				result = str + result;
				break;
			default:
				result = str;
		}
		return result;
	}
	
	public static String getStr2(String str){
		StringBuffer sb = new StringBuffer("");
		int i = str.length();
		while(i>0){
			sb.append(str.substring(i-2, i));
			i -= 2;
		}
		return sb.toString();
	}
	

	public static String toEmptyStr(String str) {
		return toEmptyStr(str, EMPTY_STRING);
	}

	public static String toEmptyStr(String str, String dev) {
		return str == null ? dev : str;
	}

	public static boolean hasLength(String str) {
		return (str != null && str.length() > 0);
	}

	public static boolean hasText(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return false;
		}
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	public static String completeStr(String str, String endStr) {
		if (!(str.endsWith(endStr))) {
			return str + endStr;
		} else {
			return str;
		}
	}

	public static boolean isEmpty(String str) {
		if (str == null) {
			return true;
		}
		if (str.equals("")) {
			return true;
		} else {
			return false;
		}
	}

	public static String join(String seperator, String[] strings) {
		int length = strings.length;
		if (length == 0) {
			return EMPTY_STRING;
		}
		StringBuffer buf = new StringBuffer(length * strings[0].length()).append(strings[0]);
		for (int i = 1; i < length; i++) {
			buf.append(seperator).append(strings[i]);
		}
		return buf.toString();
	}

	public static String join(String seperator, Iterator objects) {
		StringBuffer buf = new StringBuffer();
		if (objects.hasNext()) {
			buf.append(objects.next());
		}
		while (objects.hasNext()) {
			buf.append(seperator).append(objects.next());
		}
		return buf.toString();
	}

	public static String[] add(String[] x, String sep, String[] y) {
		String[] result = new String[x.length];
		for (int i = 0; i < x.length; i++) {
			result[i] = x[i] + sep + y[i];
		}
		return result;
	}

	public static String repeat(String string, int times) {
		StringBuffer buf = new StringBuffer(string.length() * times);
		for (int i = 0; i < times; i++) {
			buf.append(string);
		}
		return buf.toString();
	}

	public static String replace(String template, String placeholder, String replacement) {
		return replace(template, placeholder, replacement, false);
	}

	public static String replace(String template, String placeholder, String replacement, boolean wholeWords) {
		int loc = template.indexOf(placeholder);
		if (loc < 0) {
			return template;
		} else {
			final boolean actuallyReplace = !wholeWords || loc + placeholder.length() == template.length()
					|| !Character.isJavaIdentifierPart(template.charAt(loc + placeholder.length()));
			String actualReplacement = actuallyReplace ? replacement : placeholder;
			return new StringBuffer(template.substring(0, loc)).append(actualReplacement).append(
					replace(template.substring(loc + placeholder.length()), placeholder, replacement, wholeWords)).toString();
		}
	}

	public static String replaceOnce(String template, String placeholder, String replacement) {
		int loc = template.indexOf(placeholder);
		if (loc < 0) {
			return template;
		} else {
			return new StringBuffer(template.substring(0, loc)).append(replacement).append(template.substring(loc + placeholder.length())).toString();
		}
	}

	public static String[] split(String seperators, String list) {
		return split(seperators, list, false);
	}

	public static String[] split(String seperators, String list, boolean include) {
		StringTokenizer tokens = new StringTokenizer(list, seperators, include);
		String[] result = new String[tokens.countTokens()];
		int i = 0;
		while (tokens.hasMoreTokens()) {
			result[i++] = tokens.nextToken();
		}
		return result;
	}

	public static String unqualify(String qualifiedName) {
		return unqualify(qualifiedName, ".");
	}

	public static String unqualify(String qualifiedName, String seperator) {
		return qualifiedName.substring(qualifiedName.lastIndexOf(seperator) + 1);
	}

	public static String qualifier(String qualifiedName) {
		int loc = qualifiedName.lastIndexOf(".");
		if (loc < 0) {
			return EMPTY_STRING;
		} else {
			return qualifiedName.substring(0, loc);
		}
	}

	public static String[] suffix(String[] columns, String suffix) {
		if (suffix == null) {
			return columns;
		}
		String[] qualified = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			qualified[i] = suffix(columns[i], suffix);
		}
		return qualified;
	}

	public static String suffix(String name, String suffix) {
		return (suffix == null) ? name : name + suffix;
	}

	public static String[] prefix(String[] columns, String prefix) {
		if (prefix == null) {
			return columns;
		}
		String[] qualified = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			qualified[i] = prefix + columns[i];
		}
		return qualified;
	}

	public static String root(String qualifiedName) {
		int loc = qualifiedName.indexOf(".");
		return (loc < 0) ? qualifiedName : qualifiedName.substring(0, loc);
	}

	public static boolean booleanValue(String tfString) {
		String trimmed = tfString.trim().toLowerCase();
		return trimmed.equals("true") || trimmed.equals("t");
	}

	public static String toString(Object[] array) {
		int len = array.length;
		if (len == 0) {
			return StringUtil.EMPTY_STRING;
		}
		StringBuffer buf = new StringBuffer(len * 12);
		for (int i = 0; i < len - 1; i++) {
			buf.append(array[i]).append(StringUtil.COMMA_SPACE);
		}
		return buf.append(array[len - 1]).toString();
	}

	public static String[] multiply(String string, Iterator placeholders, Iterator replacements) {
		String[] result = new String[] { string };
		while (placeholders.hasNext()) {
			result = multiply(result, (String) placeholders.next(), (String[]) replacements.next());
		}
		return result;
	}

	private static String[] multiply(String[] strings, String placeholder, String[] replacements) {
		String[] results = new String[replacements.length * strings.length];
		int n = 0;
		for (int i = 0; i < replacements.length; i++) {
			for (int j = 0; j < strings.length; j++) {
				results[n++] = replaceOnce(strings[j], placeholder, replacements[i]);
			}
		}
		return results;
	}

	public static int count(String string, char character) {
		int n = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == character) {
				n++;
			}
		}
		return n;
	}

	public static int countUnquoted(String string, char character) {
		if (SINGLE_QUOTE == character) {
			throw new IllegalArgumentException("Unquoted count of quotes is invalid");
		}
		int count = 0;
		int stringLength = string == null ? 0 : string.length();
		boolean inQuote = false;
		for (int indx = 0; indx < stringLength; indx++) {
			if (inQuote) {
				if (SINGLE_QUOTE == string.charAt(indx)) {
					inQuote = false;
				}
			} else if (SINGLE_QUOTE == string.charAt(indx)) {
				inQuote = true;
			} else if (string.charAt(indx) == character) {
				count++;
			}
		}
		return count;
	}

	public static boolean isNotEmpty(String string) {
		return string != null && string.length() > 0;
	}

	public static String qualify(String prefix, String name) {
		return new StringBuffer(prefix.length() + name.length() + 1).append(prefix).append(DOT).append(name).toString();
	}

	public static String[] qualify(String prefix, String[] names) {
		if (prefix == null) {
			return names;
		}
		int len = names.length;
		String[] qualified = new String[len];
		for (int i = 0; i < len; i++) {
			qualified[i] = qualify(prefix, names[i]);
		}
		return qualified;
	}

	public static int firstIndexOfChar(String sqlString, String string, int startindex) {
		int matchAt = -1;
		for (int i = 0; i < string.length(); i++) {
			int curMatch = sqlString.indexOf(string.charAt(i), startindex);
			if (curMatch >= 0) {
				if (matchAt == -1) { // first time we find match!
					matchAt = curMatch;
				} else {
					matchAt = Math.min(matchAt, curMatch);
				}
			}
		}
		return matchAt;
	}

	public static String truncate(String string, int length) {
		if (string.length() <= length) {
			return string;
		} else {
			return string.substring(0, length);
		}
	}

	public static String replaceAll(String s0, String s1, String s2) {
		return replace(s0, s1, s2, false);
	}

	public static String replaceFirst(String s0, String s1, String s2) {
		return replaceOnce(s0, s1, s2);
	}

	public static String strToLen(String str, int len) {
		if ((str == null) || (len <= 0)) {
			return "";
		}
		byte[] v = str.getBytes();
		StringBuffer result = new StringBuffer();
		if (v.length <= len) {
			return str;
		} else {
			int sum = 0;
			char chr = 0;
			byte[] tmp = null;
			for (int i = 1; i <= str.length(); i++) {
				chr = str.charAt(i - 1);
				if (chr < 127) {
					sum++;
				} else {
					tmp = ("" + chr).getBytes();
					sum = sum + tmp.length;
					tmp = null;
				}
				if (sum <= len) {
					result.append(chr);
				}
			}
			return result.toString();
		}
	}

	public static String StringToUnicode(String str) throws Exception {
		StringBuffer result = new StringBuffer();
		int input = 0;
		StringReader strReader = null;
		try {
			strReader = new StringReader(new String(str.getBytes(), "GBK"));
			while ((input = strReader.read()) != -1) {
				if ((input >= 33) && (input <= 126)) {
					result.append(((char) input));
				} else {
					result.append("&#x");
					result.append(Integer.toHexString(input));
					result.append(";");
				}
			}
		} catch (Exception ex) {
			if (strReader != null) {
				strReader.close();
			}
			throw ex;
		}
		strReader.close();
		return result.toString();
	}

	public static String gb2utf(String inStr) {
		char tempChr;
		int ascInt;
		int i, size;
		StringBuffer result = new StringBuffer();
		if (inStr == null) {
			inStr = "";
		}
		size = inStr.length();
		for (i = 0; i < size; i++) {
			tempChr = inStr.charAt(i);
			ascInt = tempChr + 0;
			result.append("&#x");
			result.append(Integer.toHexString(ascInt));
			result.append(";");
		}
		return result.toString();
	}

	public static int strByteLen(String str) throws Exception {
		if (str == null) {
			throw new Exception("parameter is null.");
		}
		return str.getBytes().length;
	}

	public static String htmlEncode(String txt) {
		txt = replaceAll(txt, "&", "&amp;");
		txt = replaceAll(txt, "&amp;amp;", "&amp;");
		txt = replaceAll(txt, "&amp;quot;", "&quot;");
		txt = replaceAll(txt, "\"", "&quot;");
		txt = replaceAll(txt, "&amp;lt;", "&lt;");
		txt = replaceAll(txt, "<", "&lt;");
		txt = replaceAll(txt, "&amp;gt;", "&gt;");
		txt = replaceAll(txt, ">", "&gt;");
		txt = replaceAll(txt, "&amp;nbsp;", "&nbsp;");
		txt = replaceAll(txt, " ", "&nbsp;");
		return txt;
	}

	public static String unHtmlEncode(String txt) {
		txt = replaceAll(txt, "&amp;", "&");
		txt = replaceAll(txt, "&quot;", "\"");
		txt = replaceAll(txt, "&lt;", "<");
		txt = replaceAll(txt, "&gt;", ">");
		txt = replaceAll(txt, "&nbsp;", " ");
		return txt;
	}

	public static String Encoding(String incode, String outcode, String str) throws Exception {
		String newStr = null;
		if (str != null) {
			newStr = new String(str.getBytes(incode), outcode);
		}
		return newStr;
	}

	public static String uncapitalize(String str) {
		return changeFirstCharacterCase(str, false);
	}

	private static String changeFirstCharacterCase(String str, boolean capitalize) {
		if (str == null || str.length() == 0) {
			return str;
		}
		StringBuffer buf = new StringBuffer(str.length());
		if (capitalize) {
			buf.append(Character.toUpperCase(str.charAt(0)));
		} else {
			buf.append(Character.toLowerCase(str.charAt(0)));
		}
		buf.append(str.substring(1));
		return buf.toString();
	}

	public static String collectionToDelimitedString(Collection coll, String delim) {
		return collectionToDelimitedString(coll, delim, "", "");
	}

	public static String collectionToDelimitedString(Collection coll, String delim, String prefix, String suffix) {
		if (coll == null) {
			return "";
		}

		StringBuffer sb = new StringBuffer();
		Iterator it = coll.iterator();
		int i = 0;
		while (it.hasNext()) {
			if (i > 0) {
				sb.append(delim);
			}
			sb.append(prefix).append(it.next()).append(suffix);
			i++;
		}
		return sb.toString();
	}

	public static String[] delimitedListToStringArray(String str, String delimiter) {
		if (str == null) {
			return new String[0];
		}
		if (delimiter == null) {
			return new String[] { str };
		}

		List result = new ArrayList();
		int pos = 0;
		int delPos = 0;
		while ((delPos = str.indexOf(delimiter, pos)) != -1) {
			result.add(str.substring(pos, delPos));
			pos = delPos + delimiter.length();
		}
		if (str.length() > 0 && pos <= str.length()) {
			// Add rest of String, but not in case of empty input.
			result.add(str.substring(pos));
		}

		return (String[]) result.toArray(new String[result.size()]);
	}

	public static Locale parseLocaleString(String localeString) {
		String[] parts = tokenizeToStringArray(localeString, "_ ", false, false);
		String language = parts.length > 0 ? parts[0] : "";
		String country = parts.length > 1 ? parts[1] : "";
		String variant = parts.length > 2 ? parts[2] : "";
		return (language.length() > 0 ? new Locale(language, country, variant) : null);
	}

	public static String[] tokenizeToStringArray(String str, String delimiters, boolean trimTokens, boolean ignoreEmptyTokens) {

		StringTokenizer st = new StringTokenizer(str, delimiters);
		List tokens = new ArrayList();
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (trimTokens) {
				token = token.trim();
			}
			if (!ignoreEmptyTokens || token.length() > 0) {
				tokens.add(token);
			}
		}
		return (String[]) tokens.toArray(new String[tokens.size()]);
	}

	public static String[] tokenizeToStringArray(String str, String delimiters) {
		return tokenizeToStringArray(str, delimiters, true, true);
	}

	public static String[] commaDelimitedListToStringArray(String str) {
		return delimitedListToStringArray(str, ",");
	}

	public static String arrayToCommaDelimitedString(Object[] arr) {
		return arrayToDelimitedString(arr, ",");
	}

	public static String arrayToDelimitedString(Object[] arr, String delim) {
		if (arr == null) {
			return "";
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			if (i > 0) {
				sb.append(delim);
			}
			sb.append(arr[i]);
		}
		return sb.toString();
	}

	public static String deleteAny(String inString, String charsToDelete) {
		if (inString == null || charsToDelete == null) {
			return inString;
		}
		StringBuffer out = new StringBuffer();
		for (int i = 0; i < inString.length(); i++) {
			char c = inString.charAt(i);
			if (charsToDelete.indexOf(c) == -1) {
				out.append(c);
			}
		}
		return out.toString();
	}

	public static String toPrexLen(String str, char fill, int len) {
		if (str == null) {
			return null;
		}
		StringBuffer buf = new StringBuffer();
		int strlen = str.length();
		for (int i = 0; i < len - strlen; i++) {
			buf.append(fill);
		}
		buf.append(str);
		return buf.toString();
	}

	public static String toSuffLen(String str, char fill, int len) {
		if (str == null) {
			return null;
		}
		StringBuffer buf = new StringBuffer(str);
		int strlen = str.length();
		for (int i = 0; i < len - strlen; i++) {
			buf.append(fill);
		}
		return buf.toString();

	}
	public static String[] toStringArray(Collection collection) {
		if (collection == null) {
			return null;
		}
		return (String[]) collection.toArray(new String[collection.size()]);
	}
	public static List split(String s, int step) throws Exception {
		List result = new ArrayList();

		if ((s.length() < step) || (s == null)) {
			result.add(s);
		} else {
			for (int i = 0; i < s.length(); i = i + step) {
				if ((i + step) > s.length()) {
					result.add(s.substring(i, s.length()));
				} else {
					result.add(s.substring(i, i + step));
				}
			}
		}
		return result;
	}
	public static String toEmptyStr(Object obj){
		if(obj==null)
		  return "";
		else{
			String returnStr=(String)obj.toString();
		    returnStr=returnStr.replace(" ", "");
		  return returnStr;	
		  }
	}
	
	public static String toEmptyInt(Object obj){
		if(obj==null)
		  return "0";
		else{
			String returnStr=(String)obj.toString();
		    returnStr=returnStr.replace(" ", "");
		  return returnStr;	
		  }
	}
	
	
}

