package com.stubhub.codegen.generator;

public class MemberPair {
	public String name;
	public ValueType type;
	public Object value;
	
	public MemberPair(String name, Object value, ValueType type){
		this.name = name;
		this.type = type;
		this.value = value;
	}
	
	public static enum ValueType{
		STRING,
		ARRAY,
		VALUE
	}
}
