package com.rm13.pattern;

import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: chenyuan
 * @Date: 2021/4/6 下午8:49
 */
public class PatternTest {

	public static void main(String[] args) {
		String str = "121.123123Java教程12.5qwe0sadfsadf";
		String regex =  "^\\d*[.]{0,1}\\d*";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(str);


		while (m.find()) {
			if (!"".equals(m.group())){
				String result = m.group();
				System.out.println("价格:" + m.group());
			}
		}

	}
}
