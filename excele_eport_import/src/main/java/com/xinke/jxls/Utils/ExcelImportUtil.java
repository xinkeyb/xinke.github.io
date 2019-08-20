package com.xinke.jxls.Utils;

import com.xinke.jxls.entity.User;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.XLSReadStatus;
import org.jxls.reader.XLSReader;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: excele_eport_import
 * @description:
 * @author: zhaoxinke
 * @create: 2019-08-16 15:11
 * @version: 1.0
 * @update: [1][2019-08-16] [zhaoxinke][新建]
 **/
public class ExcelImportUtil {

    /**
     * 使用jxls解析导入的Excel
     * @param path 导入文件路径
     * @return List<User> 导入对象集合
     */
    public  List<User> getExcelDataForVideoInfo(String path) throws Exception {
        List<User> userList = new ArrayList<>();

        InputStream inputXML = new BufferedInputStream(getClass().getClassLoader().getResourceAsStream("videoConfig.xml"));
        XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
        InputStream inputXLS = new BufferedInputStream(new FileInputStream(new File(path)));
        System.out.println(inputXML);
        System.out.println(inputXLS);
        User user = new User();
        Map<String, Object> beans = new HashMap<>();
        beans.put("user", user);
        beans.put("userList", userList);
        XLSReadStatus readStatus = mainReader.read(inputXLS, beans);
        if (readStatus.isStatusOK()) {
            System.out.println("jxls读取Excel成功！");
        }
        return userList;
    }
}
