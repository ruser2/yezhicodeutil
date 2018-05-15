package com.yllt.mapper;

import java.util.List;
import java.util.Map;

import com.yllt.domain.test.Test;

/**
 * 
 * <p><b>类名称：</b>BaseMapper </p>
 * <p><b>类描述：</b>mapper基础方法</p>
 * <p><b>日期：</b>2015-4-11 上午11:03:04</p>
 * @author yaozq
 */
public interface BaseMapper<T> {

	public int deleteByPrimaryKey(long id);

	public int insert(T record);

	public T selectByPrimaryKey(long id);

	public int updateByPrimaryKeySelective(T record);

	public int updateByPrimaryKey(T record);
	
	public List<T> query(Map<String, Object> paramMap);

}
