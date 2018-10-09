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
@Table(name = "_ucard", schema = "")
@Data
public class Ucard implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "cdId", column = @Column(name = "cdID", nullable = false)),
			@AttributeOverride(name = "uid", column = @Column(name = "uID", nullable = false)) })
	protected UcardPK ucardPK;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name = "creaateDate", length = 19)
	private Date creaateDate;
	@JoinColumn(name = "cdID", referencedColumnName = "cdID", nullable = false, insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Card card;
	@JoinColumn(name = "uID", referencedColumnName = "uID", nullable = false, insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private User user;

}
