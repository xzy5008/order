package com.hifox.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 
 * @Description: Base DAO
 *
 * @Date:2016年8月2日
 * @author:xzy
 */
@NoRepositoryBean
public interface BaseRepository <T, ID extends Serializable> extends JpaRepository<T, ID>,JpaSpecificationExecutor<T> {

	
}
