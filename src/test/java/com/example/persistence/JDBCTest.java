package com.example.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import lombok.extern.log4j.Log4j;
import org.junit.Test;

@Log4j
public class JDBCTest {
  static {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testConnection() {
    try (Connection con = DriverManager.getConnection(
        "jdbc:oracle:thin:@localhost:1521:xe",
        "book_ex",
        "12345")) {

      log.info(con);
    } catch(Exception e) {
      fail(e.getMessage());
    }
    }

  }
