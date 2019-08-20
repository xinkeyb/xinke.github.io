package com.xinke.jxls.importController;

import com.xinke.jxls.Utils.ExcelImportUtil;
import com.xinke.jxls.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.List;

/**
 * @program: excele_eport_import
 * @description:
 * @author: zhaoxinke
 * @create: 2019-08-16 15:47
 * @version: 1.0
 * @update: [1][2019-08-16] [zhaoxinke][新建]
 **/
@RestController
public class ExcelImportTest {

    @RequestMapping("/import1")
    public void import_() throws Exception {
        URL url = this.getClass().getClassLoader().getResource("importTest.xlsx");
        String path = url.getPath();
        System.out.println(path);
        ExcelImportUtil excelImportUtil = new ExcelImportUtil();
        List<User> list =  excelImportUtil.getExcelDataForVideoInfo(path);
        for (User user : list) {
            System.out.println(user);
        }
    }
}
