package com.lc.mybatis.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.lc.mybatis.Mybatis;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class MybatisImpl implements Mybatis{
     public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String URL="jdbc:mysql://localhost:3306/mybatis?";
		Connection connection=(Connection) DriverManager.getConnection(URL,"root","080808");
		File image=new File("E:\\1\\1.jpg");
          //获取图片的文件输入流
        InputStream is=new FileInputStream(image);
	    String sql="insert into gallery(name,picture) values(?,?)";
	    PreparedStatement preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
	    preparedStatement.setString(1, "xjj");
	    preparedStatement.setBinaryStream(2, is, (int)image.length());
	    int i=preparedStatement.executeUpdate();
	    System.out.println(i);
	    preparedStatement.close();
	    connection.close();
	}

}
