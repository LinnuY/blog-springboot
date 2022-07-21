package org.linuy.blog.entity.bookkeeping;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author LongTeng
 * @date 2022/06/06
 **/
@Entity
@Setter
@Getter
public class Bookkeeping {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String type;

    @Column
    private Double value;

    @Column
    private String remarks;

    @Column(name = "OUT_OR_IN")
    private Boolean outOrIn;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "CONSUME_TIME")
    private Date consumeTime;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    @Column
    private Integer year;

    @Column
    private Integer month;

    @Column
    private Integer day;
}
