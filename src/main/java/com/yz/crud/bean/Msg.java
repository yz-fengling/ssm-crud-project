package com.yz.crud.bean;

/**
 * 通用的返回的类
 * 
 * @author lfy
 * 
 */

import java.util.HashMap;
import java.util.Map;

public class Msg {
	//状态码   100-成功    200-失败
	private int code;
	//提示信息
	private String msg;
	//用户要返回给浏览器的数据
	private Map<String, Object> exMap=new HashMap<String, Object>();
	
	public static Msg success() {
		Msg msg=new Msg();
		msg.setCode(100);
		msg.setMsg("处理成功");
		return msg;
	}
	
	public static Msg fail() {
		Msg msg=new Msg();
		msg.setCode(200);
		msg.setMsg("处理失败");
		return msg;
	}
	
	public Msg add(String key,Object value) {
		this.getExMap().put(key, value);
		return this;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExMap() {
		return exMap;
	}

	public void setExMap(Map<String, Object> exMap) {
		this.exMap = exMap;
	}
	

}
