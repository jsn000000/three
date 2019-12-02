package TestProvince;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.dao.AreaDAO;
import com.baizhi.dao.CityDAO;
import com.baizhi.dao.ProvinceDAO;
import com.baizhi.entity.Area;
import com.baizhi.entity.City;
import com.baizhi.entity.Province;
import com.baizhi.service.ProvinceService;
import com.baizhi.service.ProvinceServiceImpl;
import com.baizhi.util.MybatisUtil;
import com.sun.deploy.panel.ITreeNode;
import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TestDemo {
    @Test
    public void test1() {
        ProvinceDAO pd = (ProvinceDAO) MybatisUtil.getMapper(ProvinceDAO.class);
        List<Province> provinces = pd.selectAll();
        for (Province province : provinces) {
            System.out.println(province);
        }

    }

    @Test
    public void test2() {
        CityDAO cd = (CityDAO) MybatisUtil.getMapper(CityDAO.class);
        List<City> cities = cd.selectByProvince("410000");
        for (City city : cities) {
            System.out.println(city);
        }
    }

    @Test
    public void test3() {
        AreaDAO ad = (AreaDAO) MybatisUtil.getMapper(AreaDAO.class);
        List<Area> areas = ad.selectByCity("410300");
        for (Area area : areas) {
            System.out.println(area);
        }
    }

}
