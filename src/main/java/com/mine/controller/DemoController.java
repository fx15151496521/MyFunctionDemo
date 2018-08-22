package com.mine.controller;

import com.mine.annotation.SystemLogAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <简述>
 *
 * @Auther: feixiang
 * @Date: 2018/8/22 19:35
 * @Description:
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/demo")
    @SystemLogAnnotation(description = "测试方法日志监控")
    public ModelAndView demo() {
        ModelAndView mav = new ModelAndView();
        return mav;
    }
}
