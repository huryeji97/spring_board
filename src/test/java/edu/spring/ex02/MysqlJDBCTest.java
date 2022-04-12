package edu.spring.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class MysqlJDBCTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(MysqlJDBCTest.class);
	private static final String URL = "jdbc:mysql://yeji.ce2oedmgczyv.ap-northeast-2.rds.amazonaws.com:3306/yeji?serverTimezone=Asia/Seoul&useSSL=false";
	private static final String USER = "yeji";
	private static final String PASSWORD = "yeji1562!";
	
	@Test
	public void testMysqlConnect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			LOGGER.info("mysql 연결 성공");
		} catch (SQLException e) {
			LOGGER.error("mysql 연결 실패 : " + e.getMessage());
		} finally {
			try {				
				LOGGER.info("mysql 연결 해제 성공");
				conn.close();
			} catch (SQLException e) {
				LOGGER.error("mysql 연결 해제 실패 : " + e.getMessage());
			}
		}
		
	}
}
 