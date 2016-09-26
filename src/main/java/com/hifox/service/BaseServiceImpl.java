package com.hifox.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hifox.model.common.Model;
import com.hifox.repositories.BaseRepository;
import com.hifox.utility.StringUtil;

/**
 * 
 * @Description: base serviceimpl
 *
 * @Date:2016年8月2日
 * @author:xzy
 */
public class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

	@Autowired
	private BaseRepository<T, ID> baseRepository;

	@Override
	public T save(T entity) throws Exception {
		((Model)entity).setId(StringUtil.randomUUID().replace("-", ""));
		System.out.println("entity>>>>>>>>"+entity);
		return baseRepository.save(entity);
	}

	@Override
	public T update(T entity) throws Exception {
		return baseRepository.save(entity);
	}

	@Override
	public void delete(T entity) throws Exception {
		baseRepository.delete(entity);

	}

	@Override
	public List<T> findAll() throws Exception {
		return baseRepository.findAll();
	}

	@Override
	public void delete(ID id) throws Exception {
		baseRepository.delete(id);
	}

	@Override
	public T findOne(ID id) throws Exception {
		return baseRepository.findOne(id);
	}

	@Override
	public void batchSave(List<T> list) throws Exception {
		for (T t : list) {

			save(t);
		}
	}

	@Override
	public void batchUpdate(List<T> list) throws Exception {
		for (T t : list) {
			update(t);
		}
	}

	@Override
	public Page<T> findAll(Pageable pageable) throws Exception {
		return baseRepository.findAll(pageable);
	}
}
