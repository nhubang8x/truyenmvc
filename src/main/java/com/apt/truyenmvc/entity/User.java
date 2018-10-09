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
@Table(schema = "", uniqueConstraints = { @UniqueConstraint(columnNames = { "uEmail" }),
		@UniqueConstraint(columnNames = { "uDname" }), @UniqueConstraint(columnNames = { "uName" }) })
@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uID", unique = true, nullable = false)
	private Long uID;
	@Column(name = "uName", unique = true, nullable = false, length = 30)
	private String uName;
	@Column(name = "uPass", nullable = false, length = 60)
	private String uPass;
	@Column(name = "uDname", unique = true)
	private String uDname;
	@Column(name = "uEmail", unique = true, nullable = false, length = 150)
	private String uEmail;
	@Column(name = "gold", precision = 22, scale = 0)
	private Double gold;
	@Column(name = "uAvatar")
	private String uAvatar;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name = "modifiedDate", length = 19)
	private Date modifiedDate;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name = "createDate", length = 19)
	private Date createDate;
	@Column(name = "uStatus")
	private Integer uStatus;

}
