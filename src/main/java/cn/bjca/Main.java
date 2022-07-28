package cn.bjca;

import java.sql.*;

public class Main {
  public static void main(String[] args) throws Exception {
    String jdbcURL = "jdbc:p6spy:sqlite:b6spydemo.db"; // "jdbc:sqlite:b6spydemo.db";
    Connection c = DriverManager.getConnection(jdbcURL);
    String s = "CREATE TABLE if NOT EXISTS customers(id INT PRIMARY KEY, name VARCHAR NOT NULL)";

    Statement st = c.createStatement();
    st.execute(s);
    st.close();

    PreparedStatement p1 = c.prepareStatement("insert into customers(name,id) values (?, ?)");
    p1.setObject(2, 10);
    p1.setObject(1, "我爱北京天安门天安门上太阳升");
    p1.execute();
    p1.close();

    PreparedStatement p2 = c.prepareStatement("insert into customers(id,name) values (?, ?)");
    p2.setObject(1, 20);
    p2.setObject(2, "伟大领袖毛主席指引我们向前进");
    p2.execute();
    p2.close();

    c.close();
  }
}
