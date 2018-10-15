package com.apt.truyenmvc.entity;

import com.apt.truyenmvc.utils.ConstantsUtils;
import com.apt.truyenmvc.utils.DateUtils;
import com.apt.truyenmvc.validator.EqualFields;
import com.apt.truyenmvc.validator.UniqueEmail;
import com.apt.truyenmvc.validator.UniqueUserName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Huy Thang
 */
@Entity
@Table(schema = "", uniqueConstraints = {@UniqueConstraint(columnNames = {"uEmail"}),
        @UniqueConstraint(columnNames = {"uDname"}), @UniqueConstraint(columnNames = {"uName"})})
@Data
@NoArgsConstructor
@EqualFields(baseField = "passwordRegister", matchField = "passwordRegisterConfirm")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uID", unique = true, nullable = false)
    private Long uID;
    @NotEmpty(message = "{hthang.truyenmvc.uName.empty.message}")
    @UniqueUserName
    @Column(name = "uName", unique = true, nullable = false, length = 30)
    private String uName;
    @Column(name = "uPass", nullable = false, length = 60)
    private String uPass;
    @Column(name = "uDname", unique = true)
    private String uDname;
    @NotEmpty(message = "{hthang.truyenmvc.uEmail.empty.message}")
    @Email(message = "{hthang.truyenmvc.uEmail.email.message}")
//    @UniqueEmail
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

    @Transient
    @Size(min = 6, max = 13, message = "{hthang.truyenmvc.passwordRegister.size.message}")
    private String passwordRegister;

    @Transient
    @Size(min = 6, max = 13, message = "{hthang.truyenmvc.passwordRegisterConfirm.size.message}")
    private String passwordRegisterConfirm;

    @Transient
    @Size(min = 6, max = 13, message = "{hthang.truyenmvc.passwordRegisterConfirm.size.message}")
    private String passwordRegisterConfirm3;

    @PrePersist
    public void prePersist() {
        if (createDate == null) {
            createDate = DateUtils.getCurrentDate();
        }
        if (uAvatar == null){
            uAvatar = ConstantsUtils.AVATAR_DEFAULT;
        }
        if (uStatus == null) {
            uStatus = ConstantsUtils.STATUS_ACTIVED;
        }
        if (gold == null) {
            gold = (double) 0;
        }
    }

    @PreUpdate
    public void preUpdate() {
        if (modifiedDate == null) {
            modifiedDate = DateUtils .getCurrentDate();
        }
    }
}
