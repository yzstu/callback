package cn.yzstu.callback.controller;

import cn.yzstu.callback.service.SendInfo;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * \* User: Baldwin
 * \* E_Mail: baldwin@chancellorhk.com || DikeyWang@163.com
 * \* Date: 2020/3/10
 * \* Time: 15:56
 * \* Description:
 * \
 */
@Controller
public class controller {

    @Autowired
    private SendInfo sendInfo;

    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forward:/index");
        return mv;
    }

    @RequestMapping("sendInfo")
    public ModelAndView sendInfo(HttpServletRequest request){

        ModelAndView mv = new ModelAndView();

        String ret = sendInfo.sendInfo(request);

        request.setAttribute("msg",ret);
        mv.setViewName("forward:index");

        return mv;
    }
}