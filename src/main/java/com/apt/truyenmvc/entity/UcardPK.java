package com.apt.truyenmvc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 *
 * @author Huy Thang
 */
@Embeddable
@Data
public class UcardPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "cdID", nullable = false)
	private long cdID;
	@Column(name = "uID", nullable = false)
	private long uID;

}
