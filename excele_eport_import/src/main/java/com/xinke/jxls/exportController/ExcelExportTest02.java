package com.xinke.jxls.exportController;

import com.xinke.jxls.Utils.ExcelExportUtil;
import com.xinke.jxls.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: excele_eport_import
 * @description:ransformXLS方法Map beanParams参数里的元素为数组，这个类演示了数组里方User对象
 * @author: zhaoxinke
 * @create: 2019-08-16 10:45
 * @version: 1.0
 * @update: [1][2019-08-16] [zhaoxinke][新建]
 **/
@Controller
public class ExcelExportTest02 {

    @RequestMapping("/export")
    public void export(HttpServletRequest request,HttpServletResponse response) throws Exception {
        //response.setContentType("application/vnd.ms-excel");

        // xls模板全限定名
        URL url = this.getClass().getClassLoader().getResource("template_.xlsx");
        String templateFileName = url.getPath();
        //String templateFileName = "E:\\idea\\excele_eport_import\\src\\main\\resources\\template_.xlsx";
        System.out.println(templateFileName);
        // 生成的xls全限定名
        String destFileName = "C:\\Users\\Lenovo\\Desktop\\屌丝Map_.xlsx";
        response.setHeader("Content-Disposition", "attachment;filename=" + destFileName);
        List<User> list = new ArrayList<>();
        User user1 = new User("user1",1,"men","我是user1");
        User user2 = new User("user2",2,"men","我是user2");
        User user3 = new User("user3",3,"men","我是user3");
        User user4 = new User("user4",4,"men","我是user4");


        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        // 调用工具
        new ExcelExportUtil().createExcel(templateFileName, list, list, destFileName);
    }
}
