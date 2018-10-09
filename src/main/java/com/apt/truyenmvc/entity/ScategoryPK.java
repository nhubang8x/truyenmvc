package com.apt.truyenmvc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 * @author Huy Thang
 *
 */
@Embeddable
@Data
public class ScategoryPK implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "sID", nullable = false)
	private long sid;
	@Column(name = "cID", nullable = false)
	private int cid;

}
