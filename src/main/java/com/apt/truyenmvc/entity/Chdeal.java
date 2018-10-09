package com.apt.truyenmvc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "_chdeal", schema = "")
@Data
public class Chdeal implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chDealID", unique = true, nullable = false)
	private Long chDealID;
	@Column(name = "price", precision = 12, scale = 0)
	private Float price;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createDate", length = 19)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private Date createDate;
	@JoinColumn(name = "chID", referencedColumnName = "chID", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Chapter chapter;
	@JoinColumn(name = "uID", referencedColumnName = "uID", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	@Column(name = "locationIP", length = 50, nullable = false)
	private String locationIP;

}
