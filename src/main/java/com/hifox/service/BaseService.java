package com.hifox.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 
 * @Description: Base service
 *
 * @Date:2016年8月2日
 * @author:xzy
 */
public interface BaseService<T, ID extends Serializable> {

	/**
	 * 保存
	 * 
	 * @param entity
	 * @return
	 */
	T save(T entity) throws Exception;

	/**
	 * 修改
	 * 
	 * @param entity
	 * @return
	 */
	T update(T entity) throws Exception;

	/**
	 * 删除
	 * 
	 * @param entity
	 */
	void delete(T entity) throws Exception;

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<T> findAll() throws Exception;

	/***
	 * 通过ID 删除
	 * 
	 * @param id
	 */
	void delete(ID id) throws Exception;

	/**
	 * 查询单个
	 * 
	 * @param id
	 * @return
	 */
	T findOne(ID id) throws Exception;

	/**
	 * 批量保存
	 * 
	 * @param list
	 */
	void batchSave(List<T> list) throws Exception;

	/**
	 * 批量更新
	 * 
	 * @param list
	 */
	void batchUpdate(List<T> list) throws Exception;

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	Page<T> findAll(Pageable pageable) throws Exception;
}
