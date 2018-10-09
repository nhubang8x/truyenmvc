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
import lombok.NoArgsConstructor;

/**
 *
 * @author Huy Thang
 */
@Entity
@Table(name = "_ufavorites", schema = "")
@Data
@NoArgsConstructor
public class Ufavorites implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ufID", unique = true, nullable = false)
	private Long ufID;
	@Column(name = "locationIP", nullable = false, length = 50)
	private String locationIP;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name = "dateView", length = 19)
	private Date dateView;
	@Column(name = "ufStatus")
	private Integer ufStatus;
	@JoinColumn(name = "chID", referencedColumnName = "chID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Chapter chapter;
	@JoinColumn(name = "uID", referencedColumnName = "uID")
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

}
