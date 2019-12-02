package com.baizhi.service;

import com.baizhi.dao.AreaDAO;
import com.baizhi.dao.CityDAO;
import com.baizhi.dao.ProvinceDAO;
import com.baizhi.entity.Area;
import com.baizhi.entity.City;
import com.baizhi.entity.Province;
import com.baizhi.util.MybatisUtil;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    @Override
    public List<Province> queryAll() {
        ProvinceDAO pd= (ProvinceDAO) MybatisUtil.getMapper(ProvinceDAO.class);
        List<Province> provinces = pd.selectAll();
        MybatisUtil.close();
        return provinces;
    }

    @Override
    public List<City> queryByProvince(String provinceCode) {
        CityDAO cd = (CityDAO) MybatisUtil.getMapper(CityDAO.class);
        List<City> cities = cd.selectByProvince(provinceCode);
        MybatisUtil.close();
        return cities;
    }

    @Override
    public List<Area> queryByCity(String cityCode) {
        AreaDAO ad = (AreaDAO) MybatisUtil.getMapper(AreaDAO.class);
        List<Area> areas = ad.selectByCity(cityCode);
        MybatisUtil.close();
        return areas;
    }
}
