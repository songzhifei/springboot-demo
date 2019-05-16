package demo.springboot.dao;

import demo.springboot.domain.entity.City;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository extends PagingAndSortingRepository<City,Long> {
}
