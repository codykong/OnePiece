package com.xten.onepiece.springboot;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/2
 * Time: 上午11:33
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public ModelAndView index(Model model){
        model.addAttribute("httpapis", "a");
        return new ModelAndView("index");
    }
}
