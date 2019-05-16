package demo.springboot.service.impl;

import demo.springboot.dao.CityRepository;
import demo.springboot.domain.entity.City;
import demo.springboot.service.CityService;
import org.apache.commons.collections.IteratorUtils;
import org.hibernate.type.LongType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityRepository cityRepository;

    @Override
    public List<City> findAllCity() {
        return IteratorUtils.toList(cityRepository.findAll().iterator());
    }

    @Override
    public City findCityById(Long id) {
        return cityRepository.findById(id).get();
    }


    @Override
    public Long deleteCity(Long id) {
        return null;
    }
}
