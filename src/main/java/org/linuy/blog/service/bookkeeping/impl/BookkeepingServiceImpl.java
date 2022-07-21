package org.linuy.blog.service.bookkeeping.impl;

import org.linuy.blog.entity.bookkeeping.Bookkeeping;
import org.linuy.blog.repository.BookkeepingRepository;
import org.linuy.blog.service.bookkeeping.BookkeepingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author LongTeng
 * @date 2022/06/07
 **/
@Service
public class BookkeepingServiceImpl implements BookkeepingService {

    @Autowired
    private BookkeepingRepository bookkeepingRepository;

    @Override
    public List<Bookkeeping> findAll() {
        return bookkeepingRepository.findAll();
    }

    @Override
    public Boolean save(Bookkeeping bookkeeping) {
        try {
            Date date = new Date();
            if (bookkeeping.getConsumeTime() == null) {
                bookkeeping.setConsumeTime(date);
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(bookkeeping.getConsumeTime());
            bookkeeping.setCreateTime(date);
            bookkeeping.setUpdateTime(date);
            bookkeeping.setYear(calendar.get(Calendar.YEAR));
            bookkeeping.setMonth(calendar.get(Calendar.MONTH) + 1);
            bookkeeping.setDay(calendar.get(Calendar.DATE));
            bookkeepingRepository.save(bookkeeping);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
