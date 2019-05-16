package demo.springboot.web;

import demo.springboot.domain.entity.User;
import demo.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired(required = true)
    UserService userService;          // 用户服务层

    /**
     *  获取用户列表
     *    处理 "/users" 的GET请求，用来获取用户列表
     *    通过 @RequestParam 传递参数，进一步实现条件查询或者分页查询
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getUserList(ModelMap map) {
        map.addAttribute("userList", userService.findAll());
        return "userList";
    }
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createUserForm(ModelMap map){
        map.addAttribute("user", new User());
        map.addAttribute("action", "create");
        return "userForm";
    }
    /**
     *  创建用户
     *    处理 "/users" 的 POST 请求，用来获取用户列表
     *    通过 @ModelAttribute 绑定参数，也通过 @RequestParam 从页面中传递参数
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postUser(ModelMap map,
                           @ModelAttribute @Valid User user,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            map.addAttribute("action", "create");
            return "userForm";
        }
        userService.insertByUser(user);

        return "redirect:/users/index";
    }
    /**
     *  获取用户分页列表
     *    处理 "/users" 的 GET 请求，用来获取用户分页列表
     *    通过 @RequestParam 传递参数，进一步实现条件查询或者分页查询
     *
     *    Pageable 支持的分页参数如下
     *    page - 当前页 从 0 开始
     *    size - 每页大小 默认值在 application.properties 配置
     */
    @RequestMapping(value = "/getUserPage",method = RequestMethod.GET)
    public Page<User> getUserPage(Pageable pageable) {
        Page<User> users = userService.findByPage(pageable);
        return users;
    }
}
