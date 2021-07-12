package com.source11.worknotes.dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2007-4-21
 * Time: 17:48:22
 * To change this template use File | Settings | File Templates.
 */
public class MysqlDS extends MysqlDataSource{
    //指定需要访问的数据库名称
	private final String url="jdbc:mysql://129.9.0.88:3306/worknotes";
	//数据库连接的用户名和密码
	private final String user="dev";
	private final String passwd="dev";

    public MysqlDS(){
        setUrl(url);
        setUser(user);
        setPassword(passwd);
    }

    public Connection getConnection() throws SQLException{
        Properties props = new Properties();
        String userID=user;
        String passWD=password;

        if (user == null) {
           userID="";
        }

        if (password == null) {
            passWD = "";
        }

        props.put("user", userID);
        props.put("password", passWD);
        props.put("useUnicode","true");
        props.put("characterEncoding","gb2312");
        props.put("profileSql", getProfileSql());

        return getConnection(props);

    }
}
