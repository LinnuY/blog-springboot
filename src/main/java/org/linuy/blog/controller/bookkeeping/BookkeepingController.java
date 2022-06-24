package org.linuy.blog.controller.bookkeeping;

import org.linuy.blog.entity.bookkeeping.Bookkeeping;
import org.linuy.blog.entity.user.BaseUser;
import org.linuy.blog.service.bookkeeping.BookkeepingService;
import org.linuy.common.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author LongTeng
 * @date 2022/06/07
 **/
@Controller
@ResponseBody
@RequestMapping(value = "bookkeeping", method = RequestMethod.POST)
public class BookkeepingController {

    @Autowired
    private BookkeepingService bookkeepingService;

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @RequestMapping(value = "getBookkeeping")
    public ResponseBean getBookkeeping(HttpServletRequest request) {
        List<Bookkeeping> bookkeepingList = bookkeepingService.findAll();
        return new ResponseBean().addSuccess(bookkeepingList);
    }

    @RequestMapping(value = "addRecord")
    public ResponseBean addRecord(HttpServletRequest request, @RequestBody Bookkeeping bookkeeping) {
        try {
            String consumeTimeString = request.getParameter("consumeTime");
            if (consumeTimeString != null) {
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date consumeTime = simpleDateFormat.parse(consumeTimeString);
                    bookkeeping.setConsumeTime(consumeTime);
                } catch (Exception e) {
                    return new ResponseBean().addError("请输入正确的时间格式!");
                }
            }
            String sessionId = request.getSession().getId();
            BaseUser user = (BaseUser) redisTemplate.opsForValue().get(sessionId);
            if (user != null) {
                bookkeeping.setUserId(user.getId());
            }
            if (bookkeepingService.save(bookkeeping)) {
                return new ResponseBean().addSuccess();
            } else {
                return new ResponseBean().addError();
            }
        } catch (Exception e) {
            return new ResponseBean().addError(e.toString());
        }
    }

}
