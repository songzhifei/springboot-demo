package demo.springboot.service.impl;

import demo.springboot.dao.UserRepository;
import demo.springboot.domain.entity.User;
import demo.springboot.service.UserService;
import org.apache.commons.collections.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return IteratorUtils.toList(userRepository.findAll().iterator());
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User delete(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
        return user;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User insertByUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Page<User> findByPage(Pageable pageable) {
        LOGGER.info(" \n 分页查询用户："
                + " PageNumber = " + pageable.getPageNumber()
                + " PageSize = " + pageable.getPageSize());
        return userRepository.findAll(pageable);
    }
}
