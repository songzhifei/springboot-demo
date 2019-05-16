package demo.springboot.dao;

import demo.springboot.domain.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User,Long> {

}
