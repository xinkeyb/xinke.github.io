package com.xine.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @program: jdbc
 * @description:
 * @author: zhaoxinke
 * @create: 2019-08-12 13:00
 * @version: 1.0
 * @update: [1][2019-08-12] [zhaoxinke][新建]
 **/
public class test {
    public static void main(String[] args) {
        try {
            //1.注册驱动(加载驱动)
            Class.forName("com.mysql.jdbc.Driver");
            // 驱动防二次注册
            //   	Driver 这个类里面有静态代码块，一上来就执行了，所以等同于我们注册了两次驱动。 其实没这个必要的。
            //   	//静态代码块 ---> 类加载了，就执行。 java.sql.DriverManager.registerDriver(new Driver());
            //DriverManager.registerDriver(new Driver());
            //2.建立连接
            Properties properties = new Properties();
            //InputStream inputStream = new FileInputStream("E:\\idea\\jdbc\\src\\jdbc.properties");
            InputStream inputStream = test.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            Connection connection = DriverManager.getConnection(url,user,password);
            //3.创建PreparedStatement对象
            String sql = "select * from student where username=? and password=? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user);
            preparedStatement.setString(2,password);

            //4.执行查询,得到一个结果集
            ResultSet resultSet = preparedStatement.executeQuery();
            //5.查询
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                System.out.println(id);
                System.out.println(name);
            }
            //释放资源
            connection.close();
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
