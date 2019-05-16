package demo.springboot.service;

import demo.springboot.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    /**
     * 获取所有 User
     */
    List<User> findAll();

    /**
     * 更新 User
     *
     * @param user {@link User}
     */
    User update(User user);

    /**
     * 删除 User
     *
     * @param id 编号
     */
    User delete(Long id);

    /**
     * 获取 User
     *
     * @param id 编号
     */
    User findById(Long id);
    /**
     * 插入用户
     */
    User insertByUser(User user);
    /**
     * 获取用户分页列表
     *
     * @param pageable
     * @return
     */
    Page<User> findByPage(Pageable pageable);
}
