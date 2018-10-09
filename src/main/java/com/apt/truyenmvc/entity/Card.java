package com.apt.truyenmvc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 *
 * @author Huy Thang
 */
@Entity
@Table(name = "card", schema = "", uniqueConstraints = { @UniqueConstraint(columnNames = { "cdNumber" }) })
@Data
public class Card implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cdID", unique = true, nullable = false)
	private Long cdID;
	@Column(name = "cdNumber", unique = true, nullable = false, length = 60)
	private String cdNumber;
	@Column(name = "cdSerial", nullable = false, length = 60)
	private String cdSerial;
	@Column(name = "gold", nullable = false)
	private int gold;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name = "createData", length = 19)
	private Date createData;
	@Column(name = "cdStatus")
	private Integer cdStatus;

}
