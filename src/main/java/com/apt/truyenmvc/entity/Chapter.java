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
@Table(name = "chapter", schema = "")
@Data
public class Chapter implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chID", unique = true, nullable = false)
	private Long chID;
	@Column(name = "chNumber", nullable = false)
	private int chNumber;
	@Column(name = "chSerial", nullable = false, precision = 12, scale = 0)
	private float chSerial;
	@Column(name = "chName", nullable = false)
	private String chName;
	@Column(name = "chView")
	private Integer chView;
	@Column(name = "content", columnDefinition = "TEXT")
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createDate", length = 19)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private Date createDate;
	@Column(name = "wordNumber")
	private Integer wordNumber;
	@Column(name = "price")
	private Integer price;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dealine", length = 19)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dealine;
	@Column(name = "chStatus")
	private Integer chStatus;
	@JoinColumn(name = "sID", referencedColumnName = "sID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Story story;
	@JoinColumn(name = "uID", referencedColumnName = "uID")
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

}
