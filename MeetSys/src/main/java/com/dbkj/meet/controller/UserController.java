package com.dbkj.meet.controller;

import com.dbkj.meet.dic.Constant;
import com.dbkj.meet.dto.ChangePwd;
import com.dbkj.meet.dto.Result;
import com.dbkj.meet.dto.UserData;
import com.dbkj.meet.interceptors.UserInterceptor;
import com.dbkj.meet.model.Department;
import com.dbkj.meet.model.User;
import com.dbkj.meet.services.inter.IUserService;
import com.dbkj.meet.services.UserService;
import com.dbkj.meet.validator.UserDataValidator;
import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.kit.StrKit;

import java.util.List;
import java.util.Map;

/**
 * Created by MrQin on 2016/11/8.
 */
@Before({UserInterceptor.class})
public class UserController extends Controller{

    private IUserService userService=new UserService();

    private User user;

    private User getUser(){
        if(user==null){
            user=getSessionAttr(Constant.USER_KEY);
        }
        return user;
    }

    public void index(){
        Map<String,Object> map=userService.getUserPageData(this);
        setAttrs(map);
        render("index.html");
    }


    @Clear({UserInterceptor.class})
    @Before({POST.class})
    public void isExist(){
        String username=getPara("username");
        boolean result=userService.isExistUser(username);
        renderJson("{\"result\":"+result+"}");
    }

    public void showAdd(){
        User user=getSessionAttr(Constant.USER_KEY);
        userService.setPageData(getRequest());
        List<Department> departmentList=userService.getDepartments(user.getCid());
        setAttr("dlist",departmentList);
        String queryString=getRequest().getQueryString();
        setAttr("queryString", StrKit.isBlank(queryString)?"":"?"+queryString);
        render("add.html");
    }

    @Before({POST.class, UserDataValidator.class})
    public void add(){//保存
        userService.setPageData(getRequest());
        add("/user");
    }

    private void add(String path){
        UserData userData=getAttr("user");
        User user=getSessionAttr(Constant.USER_KEY);
        userService.addUserData(userData,user.getCid(),getRequest());
        String queryString=getPara("queryString");
        String contextPath=getRequest().getContextPath();
        redirect(contextPath.concat(path).concat(queryString));
    }

    @Before({POST.class, UserDataValidator.class})
    public void addAndContinue(){//保存后继续添加
       add("/user/showAdd");
    }

    public void showUpdate(){
        Long uid=getParaToLong();
        userService.setPageData(getRequest());
        UserData userData=userService.getUserData(uid);
        setAttr("user",userData);
        User user=getSessionAttr(Constant.USER_KEY);
        //获取部门信息
        List<Department> departmentList = userService.getDepartments(user.getCid());
        setAttr("dlist",departmentList);
        //获取上一个页面的查询条件
        String queryString=getRequest().getQueryString();
        setAttr("queryString", StrKit.isBlank(queryString)?"":"?"+queryString);
        render("add.html");
    }

    @Before({POST.class,UserDataValidator.class})
    public void update(){
        UserData userData=getBean(UserData.class,"user");
        userService.updateUserData(userData,getRequest());
        String queryString=getPara("queryString");
        redirect(getRequest().getContextPath().concat("/user").concat(queryString));
    }

    public void delete(){
        String idStr=getPara();
        String queryString=getRequest().getQueryString();
        userService.deleteUsers(idStr);
        redirect(getRequest().getContextPath().concat("/user").concat(StrKit.isBlank(queryString)?"":"?"+queryString));
    }

    public void showChangePwd(){
        userService.setPageData(getRequest());
        render("changePwd.html");
    }

    @Before({POST.class})
    public void changePwd(){
        ChangePwd changePwd=getBean(ChangePwd.class,"p");
        Result result=userService.changePwd(changePwd,getUser().getUsername(),getRequest());
        renderJson(result);
    }
}
