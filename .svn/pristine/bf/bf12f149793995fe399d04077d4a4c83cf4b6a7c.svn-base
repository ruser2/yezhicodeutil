package ${bussPackage}.service.${entityPackage}.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${bussPackage}.domain.${entityPackage}.${className};
import ${bussPackage}.service.BaseService;
import ${bussPackage}.mapper.${entityPackage}.${className}Mapper;
import ${bussPackage}.service.${entityPackage}.I${className}Service;

/**
 * 
 * <br>
 * <b>功能：</b>${className}ServiceImpl<br>
 * <b>作者：</b>${user}<br>
 * <b>日期：</b> ${time} <br>
 * <b>版权所有： ${organization}<br>
 */ 
@Service
@Transactional
public class ${className}ServiceImpl extends BaseService<${className}> implements I${className}Service{
	private final static Logger log= LoggerFactory.getLogger(${className}ServiceImpl.class);

	@Autowired
    private ${className}Mapper mapper;

		
	public ${className}Mapper getMapper() {
		return mapper;
	}
	
	@Override
	public Integer insert(${className} record) {
		mapper.insert(record);
		return record.getId();
	}
	

}
