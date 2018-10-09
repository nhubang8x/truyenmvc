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
@Table(name = "category", schema = "", uniqueConstraints = { @UniqueConstraint(columnNames = { "cMetatitle" }),
		@UniqueConstraint(columnNames = { "cName" }) })
@Data
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cID", unique = true, nullable = false)
	private Integer cID;
	@Column(name = "cName", unique = true, nullable = false, length = 150)
	private String cName;
	@Column(name = "cMetatitle", unique = true, nullable = false, length = 150)
	private String cMetatitle;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name = "createDate", length = 19)
	private Date createDate;
	@Column(name = "createBy", length = 150)
	private String createBy;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name = "modifiedDate", length = 19)
	private Date modifiedDate;
	@Column(name = "modifiedBy", length = 150)
	private String modifiedBy;
	@Column(name = "cStatus")
	private Integer cStatus;

}
