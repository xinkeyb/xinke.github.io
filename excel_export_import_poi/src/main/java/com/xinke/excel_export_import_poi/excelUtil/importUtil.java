package com.xinke.excel_export_import_poi.excelUtil;

import com.xinke.excel_export_import_poi.entity.User;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: excele_eport_import
 * @description:
 * @author: zhaoxinke
 * @create: 2019-08-16 17:27
 * @version: 1.0
 * @update: [1][2019-08-16] [zhaoxinke][新建]
 **/
public class importUtil {

    public static List<User> importLoad(String xlsPath) throws Exception {
        List temp = new ArrayList();
        FileInputStream fileIn = new FileInputStream(xlsPath);
        System.out.println(xlsPath);
        //根据指定的文件输入流导入Excel从而产生Workbook对象
        Workbook wb0 = getWorkbook(fileIn,xlsPath);
        //获取Excel文档中的第一个表单
        Sheet sht0 = wb0.getSheetAt(0);
        //对Sheet中的每一行进行迭代
        for (Row r : sht0) {
            //如果当前行的行号（从0开始）未达到2（第三行）则从新循环
            if( r.getRowNum() < 1){
                continue;
            }
            //创建实体类
            User user=new User();
            //取出当前行第1个单元格数据，并封装在info实体stuName属性上
            user.setName(r.getCell(0).getStringCellValue());
            user.setAge((int) r.getCell(1).getNumericCellValue());
            user.setGender(r.getCell(2).getStringCellValue());
            user.setMotto(r.getCell(3).getStringCellValue());

            temp.add(user);
        }
        fileIn.close();
        return temp;
    }


    /**
     * 描述：根据文件后缀，自适应上传文件的版本
     * @param inStr,fileName
     * @return
     * @throws Exception
     */
    private final static String excel2003L =".xls";    //2003- 版本的excel
    private final static String excel2007U =".xlsx";   //2007+ 版本的excel

    private static Workbook getWorkbook(InputStream inStr, String fileName) throws Exception{
        Workbook wb = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if(excel2003L.equals(fileType)){
            wb = new HSSFWorkbook(inStr);  //2003-
        }else if(excel2007U.equals(fileType)){
            wb = new XSSFWorkbook(inStr);  //2007+
        }else{
            throw new Exception("解析的文件格式有误！");
        }
        return wb;
    }
}
