package com.xinke.excel_export_import_poi.Controller;


import com.xinke.excel_export_import_poi.entity.User;
import com.xinke.excel_export_import_poi.excelUtil.importUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: excele_eport_import
 * @description:
 * @author: zhaoxinke
 * @create: 2019-08-16 17:22
 * @version: 1.0
 * @update: [1][2019-08-16] [zhaoxinke][新建]
 **/
@RestController
public class excelImportTest {

    @RequestMapping("/import1")
    public void import1(String path) throws Exception {
        //URL url = this.getClass().getClassLoader().getResource("importTest.xlsx");
        //String path = url.getPath();
        System.out.println(path);
        List<User> list = importUtil.importLoad(path);
        for (User user : list) {
            System.out.println(user);
        }
    }
}
