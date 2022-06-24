package org.linuy.blog.service.bookkeeping;

import org.linuy.blog.entity.bookkeeping.Bookkeeping;

import java.util.List;

/**
 * @author LongTeng
 * @date 2022/06/07
 **/
public interface BookkeepingService {

    List<Bookkeeping> findAll();

    Boolean save(Bookkeeping bookkeeping);
}
