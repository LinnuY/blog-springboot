package org.linuy.blog.entity.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @author LongTeng
 * @date 2022/05/10
 **/
@Entity
@Getter
@Setter
public class PassengerUser extends BaseUser {

    @Column
    private Long sessionId;
    @Column
    private Date lastLoginTime;
    @Column
    private String lastLoginIpAddress;

}
