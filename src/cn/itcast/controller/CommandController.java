package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 从页面接受参数，封装成User对象
 * 底层使用命令模式
 * Created by liyu on 2018/1/27.
 */
public class CommandController extends AbstractCommandController {
    public CommandController() {
        this.setCommandClass(User.class);
    }

    @Override
    protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        User user = (User) command;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder){
        String str = request.getParameter("birthday");
        if(str.contains("/")){
            binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true));
        }else {
            binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
        }
    }
}
