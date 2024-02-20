package org.zerock.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectTests {
  @Test
  public void test1() {
    int v1 = 10;
    int v2 = 10;

    Assertions.assertEquals(v1,v2);
  }

  @Test
  public void testConnection() throws Exception{
    Class.forName("org.mariadb.jdbc.Driver");

    // 설정 파일 로드
    Properties props = new Properties();
    props.load(new FileInputStream("application.properties"));
    // 프로퍼티 사용하여 연결
    String dbUrl = props.getProperty("db.url");
    String dbUser = props.getProperty("db.user");
    String dbPassword = props.getProperty("db.password");

    Connection connection = DriverManager.getConnection(
            dbUrl, dbUser, dbPassword
    );

    Assertions.assertNotNull(connection);

    connection.close();
  }
}
