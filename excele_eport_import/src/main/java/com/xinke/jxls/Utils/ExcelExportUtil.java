package com.xinke.jxls.Utils;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: excele_eport_import
 * @description:导出excel的工具类
 * @author: zhaoxinke
 * @create: 2019-08-15 18:13
 * @version: 1.0
 * @update: [1][2019-08-15] [zhaoxinke][新建]
 **/
public class ExcelExportUtil {

    /**
     * excel导出实现方法
     *
     * @param srcFilePath
     *            模板xls或xlsx文件路径
     * @param list1
     *            模板xls中对应要用到的集合;
     * @param list2
     *            模板xls中对应要用到的集合;
     * @param destFilePath
     *            生成的xls或xlsx文件路径;
     * @date 2018年7月24日 下午6:29:14
     */

    public void createExcel(String srcFilePath, List<?> list1, List<?> list2, String destFilePath) {
        /* ********我们也可以使用相对路径来定位 读取模板文件,或放置生成的文件******** */
        // 根据类加载器,获取URL
        // URL url = this.getClass().getClassLoader().getResource("");
        // 获取到项目的classes目录(如:'D:/java/Abc_ExportExcelByTemplate/target/classes/')
        // String srcPath = url.getPath();
        /* ********************************************************* */

        // 创建XLSTransformer对象
        XLSTransformer transformer = new XLSTransformer();
        Map<String, Object> beanParams = new HashMap<String, Object>();

        // 将要用到的list集合,按对应模板中的名字,放入map中
        beanParams.put("list1", list1);
        beanParams.put("list2", list2);
        try {
            // 生成Excel文件
            transformer.transformXLS(srcFilePath, beanParams, destFilePath);
        } catch (ParsePropertyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }
}
