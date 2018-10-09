package com.apt.truyenmvc.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Huy Thang
 *
 */
@Entity
@Table(name = "_scategory")
@Data
public class Scategory implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "sid", column = @Column(name = "sID", nullable = false)),
			@AttributeOverride(name = "cid", column = @Column(name = "cID", nullable = false)) })
	private ScategoryPK scategoryPK;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sID", nullable = false, insertable = false, updatable = false)
	private Story story;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cID", nullable = false, insertable = false, updatable = false)
	private Category category;

}
