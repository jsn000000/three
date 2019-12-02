package com.baizhi.dao;

import com.baizhi.entity.Area;

import java.util.List;

public interface AreaDAO {
    public List<Area> selectByCity(String CityCode);
}
