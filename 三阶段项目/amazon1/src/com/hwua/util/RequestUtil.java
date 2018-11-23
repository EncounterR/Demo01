package com.hwua.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 请求处理工具类
 * 
 * @author maple
 *
 */
public class RequestUtil {
	/**
	 * 获取请求头login?username=tom&password=111111&type=0
	 * 
	 * @param request
	 * @return
	 */
	public static String getHeader(String request) {
		String[] arr = request.split("\\?");
		return arr[0];
	}

	public static void main(String[] args) {
		String str = "LOGIN?username=zs&userpwd=123".trim();
		String[] st = str.split("\\?");
		System.out.println(st[0]);
	}

	/**
	 * 获取请求的参数的Map,key:String,value:String
	 * 
	 * @param request 请求地址及附带的参数
	 * @return 参数的Map对象
	 */
	public static Map<String, String> getParams(String request) {
		//login?username=tom&password=111111&type=0
		Map<String, String> paramMap = new HashMap<>();
		// 格式demo： header?param1=value1&param2=value2
		String[] array = request.split("\\?");
		//login  [0]
		//username=tom&password=111111&type=0 [1]
		if (array.length == 2) {
			String[] paramArray = array[1].split("&");
			//username=tom
			//password=111111
			//type=0
			if (paramArray.length > 0) {
				for (String param : paramArray) {
					String[] p = param.split("=");
					paramMap.put(p[0], p[1]);
				}
			}
		}
//		paramMap("username",tom);
//		paramMap("password",111111);
//		paramMap("type",type);
		return paramMap;
	}

}
