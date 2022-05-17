package org.linuy.blog.entity.user;

import java.util.Date;

/**
 * @author LongTeng
 * @date 2022/05/10
 **/
public class PassengerUser extends BaseUser{
    private Long sessionId;
    private Date lastLoginTime;
    private String lastLoginIPAddress;

}
