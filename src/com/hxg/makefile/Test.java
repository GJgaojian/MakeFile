package com.hxg.makefile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.hxg.makefile.entity.ParamsEntity;
import com.hxg.makefile.entity.ParamsListEntity;
import com.hxg.makefile.util.FileUtil;

public class Test {

	public static void main(String[] args) {
		// ParamsEntity paramsEntity = new ParamsEntity();

		// List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, String> e = new HashMap<String, String>();
		// e.put("name", "aaaaaaa1bbb");
		// e.put("pwd", "123");
		e.put("", 1 + "");
		// list.add(e);
		// paramsEntity.setBodyParams(list);
		// String str = new Gson().toJson(e);
		// String str = map2String(e);
		String str = "1";
		ParamsEntity paramsEntity = new ParamsEntity(
				str,
				"http://www.yasite.net/shopapi/index.php/goodController/getGoodList/",
				"GET");
		// String par = new Gson().toJson(paramsEntity);
		// System.out.println(par);
		// FileUtil.writeFile(par);
		String s = "9deeebcf757b9143065424d726875cd9";
		List<ParamsEntity> list = test();
		for (ParamsEntity paramsEntity2 : list) {
			System.out.println(paramsEntity2);
		}
		ParamsListEntity paramsListEntity = new ParamsListEntity(list);
		String par = new Gson().toJson(paramsListEntity);
		System.out.println(par);
		FileUtil.writeFile(par);
	}

	static String map2String(Map<String, String> map) {
		StringBuffer sb = new StringBuffer();
		for (Map.Entry<String, String> m : map.entrySet()) {
			sb.append(m.getKey()).append("=");
			sb.append(m.getValue()).append("&");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	static List<ParamsEntity> test() {
		String[] strings = new String[] {
				"http://www.yasite.net/shopapi/index.php/userController/register,post,name,abc11fffav,pwd,1",
				"http://www.yasite.net/shopapi/index.php/userController/login,post,name,abc11fffav,pwd,1",
				"http://www.yasite.net/shopapi/index.php/cartController/getGoodList/677,post,token,9deeebcf757b9143065424d726875cd9",
				"http://www.yasite.net/shopapi/index.php/goodController/getGoodList/,get,1"};
		List<ParamsEntity> list = new ArrayList<ParamsEntity>();
		for (int i = 0; i < strings.length; i++) {
			String[] temp = strings[i].split(",");
			
			if("post".equalsIgnoreCase(temp[1])){
				Map<String, String> map = new HashMap<String, String>();
				for (int j = 2; j < temp.length - 1; j = j + 2) {
					map.put(temp[j], temp[j + 1]);
				}
				String method = map2String(map);
				list.add(new ParamsEntity(method, temp[0], temp[1]));
			}else{
				StringBuffer sb = new StringBuffer();
				for (int j = 2; j < temp.length ; j++) {
					sb.append(temp[j]);
				}
				list.add(new ParamsEntity(sb.toString(), temp[0], temp[1]));
			}
		}
		return list;
	}
}
