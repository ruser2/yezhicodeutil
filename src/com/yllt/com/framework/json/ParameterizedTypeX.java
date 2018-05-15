package com.yllt.com.framework.json;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ParameterizedTypeX implements java.lang.reflect.ParameterizedType
{
	public ParameterizedTypeX( Type rawType )
	{
		this.rawType = rawType;
	}

	private Type rawType = null;

	private ArrayList< Type > paramTypes = null;

	public void addParameterizedTypeX( Type item )
	{
		if ( paramTypes == null )
		{
			paramTypes = new ArrayList< Type >();
		}
		paramTypes.add( item );
	}

	@Override
	public Type[] getActualTypeArguments()
	{
		Type[] types = null;

		if ( paramTypes != null && paramTypes.size() > 0 )
		{
			types = new Type[paramTypes.size()];
			for ( int i = 0; i < types.length; i++ )
			{
				types[i] = paramTypes.get( i );
			}
		}

		return types;
	}

	@Override
	public Type getRawType()
	{
		return rawType;
	}

	@Override
	public Type getOwnerType()
	{
		return null;
	}

}