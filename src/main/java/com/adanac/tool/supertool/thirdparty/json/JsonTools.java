package com.adanac.tool.supertool.thirdparty.json;

import net.sf.json.JSONObject;

public class JsonTools {

	/**
	 * 将java对象转换为json字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static String objectToJson(Object obj) {
		JSONObject json = JSONObject.fromObject(obj);// 将java对象转换为json对象
		String str = json.toString();// 将json对象转换为字符串
		return str;
	}

	public static Object getValueFromJson(String jsonStr) {
		JSONObject jsonObj = JSONObject.fromObject(jsonStr);
		return jsonObj.getJSONObject("states").getJSONObject("rect1").get("type");
	}

	public static void testGetValueFromJson() {
		String jsonStr = "{states:{rect1:{type:'start',text:{text:'开始'}, "
				+ "attr:{ x:448, y:105, width:50, height:50}, " + "props:{text:{value:'开始'},temp1:{value:''},"
				+ "temp2:{value:''}}},rect2:{type:'state',text:{text:'camel_element'}, "
				+ "attr:{ x:431, y:224, width:100, height:50}, props:{text:{value:'camel_element'},"
				+ "temp1:{value:'http://www/baidu.com'}}},rect3:{type:'end',text:{text:'结束'}, "
				+ "attr:{ x:454, y:365, width:50, height:50}, props:{text:{value:'结束'},"
				+ "temp1:{value:''},temp2:{value:''}}}},paths:{path4:{from:'rect1',to:'rect2', dots:[],"
				+ "text:{text:'TO camel_element'},textPos:{x:0,y:-10}, props:{text:{value:''}}},"
				+ "path5:{from:'rect2',to:'rect3', dots:[],text:{text:'TO 结束'},textPos:{x:0,y:-10}, "
				+ "props:{text:{value:''}}}},props:{props:{name:{value:'新建流程'},key:{value:''}," + "desc:{value:''}}}}";
		Object object = JsonTools.getValueFromJson(jsonStr);
		System.out.println(object.toString());
	}

	public static void main(String[] args) {
		testGetValueFromJson();
	}

}
