package com.xinke.jxls.exportController;

import com.xinke.jxls.Utils.ExcelExportUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: excele_eport_import
 * @description:transformXLS方法Map beanParams参数里的元素为数组，这个类演示了数组里方Map集合
 * @author: zhaoxinke
 * @create: 2019-08-15 20:49
 * @version: 1.0
 * @update: [1][2019-08-15] [zhaoxinke][新建]
 **/
@RestController
public class excelExportTest {

    @RequestMapping("/test")
    public void test(HttpServletRequest request,HttpServletResponse response) throws IOException {

        //response.setContentType("application/vnd.ms-excel");

        // xls模板全限定名
        URL url = this.getClass().getClassLoader().getResource("template.xls");
        String templateFileName = url.getPath();
        //String templateFileName = "E:\\idea\\excele_eport_import\\src\\main\\resources\\template.xlsx";
        System.out.println(templateFileName);
        // 生成的xls全限定名
        String destFileName = "C:\\Users\\Lenovo\\Desktop\\屌丝Map.xls";
        response.setHeader("Content-Disposition", "attachment;filename=" + destFileName);
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "u1");
        map1.put("age", 11);
        map1.put("gender", "男");
        map1.put("motto", "我是u1~");


        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "u2");
        map2.put("age", 12);
        map2.put("gender", "男");
        map2.put("motto", "我是u2~");


        Map<String, Object> map3 = new HashMap<>();
        map3.put("name", "u3");
        map3.put("age", 13);
        map3.put("gender", "男");
        map3.put("motto", "我是u3~");

        Map<String, Object> map4 = new HashMap<>();
        map4.put("name", "u4");
        map4.put("age", 14);
        map4.put("gender", "男");
        map4.put("motto", "我是u4~");

        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);

        // 调用工具
        new ExcelExportUtil().createExcel(templateFileName, list, list, destFileName);

    }

}
