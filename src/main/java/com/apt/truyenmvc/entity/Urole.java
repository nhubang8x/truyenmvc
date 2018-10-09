package com.apt.truyenmvc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 *
 * @author Huy Thang
 */
@Entity
@Table(name = "_urole", schema = "")
@Data
public class Urole implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "uid", column = @Column(name = "uID", nullable = false)),
			@AttributeOverride(name = "rid", column = @Column(name = "rID", nullable = false)) })
	protected UrolePK urolePK;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name = "createData", nullable = false, length = 19)
	private Date createData;
	@Column(name = "createBy", length = 150)
	private String createBy;
	@JoinColumn(name = "rID", referencedColumnName = "rID", nullable = false, insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Role role;
	@JoinColumn(name = "uID", referencedColumnName = "uID", nullable = false, insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private User user;

}
