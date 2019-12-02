package com.baizhi.dao;

import com.baizhi.entity.City;

import java.util.List;

public interface CityDAO {
    public List<City> selectByProvince(String provinceCode);
}
