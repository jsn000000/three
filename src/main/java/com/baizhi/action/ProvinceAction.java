package com.baizhi.action;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Area;
import com.baizhi.entity.City;
import com.baizhi.entity.Province;
import com.baizhi.service.ProvinceService;
import com.baizhi.service.ProvinceServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ProvinceAction {
    private String provinceCode;
    private String cityCode;

    public String queryAll() throws IOException {
        System.out.println();
        ProvinceService ps = new ProvinceServiceImpl();
        List<Province> provinces = ps.queryAll();
        //将对象转换为json响应ajax
        String json = JSONObject.toJSONString(provinces);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(json);
        return null;
    }

    public String queryByProvince() throws IOException {
        ProvinceService ps = new ProvinceServiceImpl();
        List<City> cities = ps.queryByProvince(provinceCode);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String jsonString = JSONObject.toJSONString(cities);
        writer.print(jsonString);
        return null;
    }
    public String queryByCity() throws IOException {
        ProvinceService ps = new ProvinceServiceImpl();
        System.out.println(cityCode);
        List<Area> areas = ps.queryByCity(cityCode);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String string = JSONObject.toJSONString(areas);
        writer.print(string);
        return null;
    }



    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
}
