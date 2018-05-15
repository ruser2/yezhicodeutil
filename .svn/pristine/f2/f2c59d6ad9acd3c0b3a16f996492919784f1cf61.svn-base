package com.yllt.com.framework.json;

import java.lang.reflect.Type;

public class TypeReferenceX extends com.alibaba.fastjson.TypeReference< String >
{
	private Type paramType = null;

	public TypeReferenceX( Type paramType )
	{
		this.paramType = paramType;
	}

	@Override
	public Type getType()
	{
		return paramType;
	}
}