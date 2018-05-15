package com.yllt.service;

import java.util.List;
import java.util.Map;

import com.ffcs.icity.common.mybatis.Page;
import com.yllt.mapper.BaseMapper;

public abstract class BaseService<T> implements IBaseService<T>{
	
	public abstract BaseMapper<T> getMapper();

	
	/**
	 * 
	 * <p><b>作用：</b>根据主键删除</p>
	 * <p><b>日期：</b>2015-4-11 上午10:18:53</p>
	 * <p><b>作者：</b>yaozq</p>
	 * @param id
	 * @return
	 * @exception  无.
	 */
	public int deleteByPrimaryKey(int id){
		return getMapper().deleteByPrimaryKey(id);
	}

	/**
	 * 
	 * <p><b>作用：</b>插入数据</p>
	 * <p><b>日期：</b>2015-4-11 上午10:19:10</p>
	 * <p><b>作者：</b>yaozq</p>
	 * @param record
	 * @return
	 * @exception  无.
	 */
	public abstract Integer insert(T record);


	/**
	 * 
	 * <p><b>作用：</b>根据主键查询</p>
	 * <p><b>日期：</b>2015-4-11 上午10:19:41</p>
	 * <p><b>作者：</b>yaozq</p>
	 * @param uuid
	 * @return
	 * @exception  无.
	 */
	public T selectByPrimaryKey(int id){
		return getMapper().selectByPrimaryKey(id);
	}

	/**
	 * 
	 * <p><b>作用：</b>根据主键部分更新</p>
	 * <p><b>日期：</b>2015-4-11 上午10:20:00</p>
	 * <p><b>作者：</b>yaozq</p>
	 * @param record
	 * @return
	 * @exception  无.
	 */
	public int updateByPrimaryKeySelective(T record){
		return getMapper().updateByPrimaryKeySelective(record);
	}

	/**
	 * 
	 * <p><b>作用：</b>根据主键全部更新</p>
	 * <p><b>日期：</b>2015-4-11 上午10:20:04</p>
	 * <p><b>作者：</b>yaozq</p>
	 * @param record
	 * @return
	 * @exception  无.
	 */
	public int updateByPrimaryKey(T record){
		return getMapper().updateByPrimaryKey(record);
	}
	
	/**
	 * 
	 * <p><b>作用：</b>不分页查询</p>
	 * <p><b>日期：</b>2015-4-11 上午10:20:11</p>
	 * <p><b>作者：</b>yaozq</p>
	 * @param paramMap
	 * @return
	 * @exception  无.
	 */
	public List<T> queryList(Map<String, Object> paramMap){
		return getMapper().query(paramMap);
	}
	
	/**
	 * 
	 * <p><b>作用：</b>分页查询</p>
	 * <p><b>日期：</b>2015-4-11 上午10:20:15</p>
	 * <p><b>作者：</b>yaozq</p>
	 * @param paramMap
	 * @param page
	 * @return
	 * @exception  无.
	 */
	public Page<T> queryPage(Map<String, Object> paramMap, Page<T> page){
		paramMap.put("page", page);
		getMapper().query(paramMap);
		return page;
	}
}
