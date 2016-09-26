package com.hifox.model.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * 模型基类
 * Created by lihao on 2016/6/21.
 */
@MappedSuperclass
public class Model implements Serializable {

	private static final long serialVersionUID = 5939520677970801230L;

    private String id;

	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id",length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        Model model = (Model) that;

        return id.equals(model.id);

    }

    public int hashCode() {
        if (getId() == null) {
            return -1;
        }
        return getId().hashCode();
    }
}
