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
@Table(name = "story", schema = "")
@Data
public class Story implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sID", unique = true, nullable = false)
	private Long sID;
	@Column(name = "vnName", nullable = false)
	private String vnName;
	@Column(name = "sMetaTitle", nullable = false)
	private String sMetaTitle;
	@Column(name = "cnName")
	private String cnName;
	@Column(name = "cnLink")
	private String cnLink;
	@Column(name = "sImages", nullable = false, length = 150)
	private String sImages;
	@Column(name = "sAuthor", nullable = false)
	private String sAuthor;
	@Column(name = "sInfo", columnDefinition = "TEXT")
	private String sInfo;
	@Column(name = "sView")
	private Integer sView;
	@Column(name = "sRating", precision = 12, scale = 0)
	private Float sRating;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name = "createDate", length = 19)
	private Date createDate;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name = "modifiedBy", length = 19)
	private Date modifiedBy;
	@Column(name = "sPrice")
	private Integer sPrice;
	@Column(name = "sTimeDeal")
	private Integer sTimeDeal;
	@Column(name = "sDealStatus")
	private Integer sDealStatus;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name = "sUpdate", length = 19)
	private Date sUpdate;
	@Column(name = "sStatus")
	private Integer sStatus;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sConverter", referencedColumnName="uID", nullable = false)
	private User sConverter;
	
	
}
