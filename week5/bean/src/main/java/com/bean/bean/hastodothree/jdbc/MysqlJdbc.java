package com.bean.bean.hastodothree.jdbc;

import java.sql.*;

/**
 * <h3>bean</h3>
 *
 * @classname:MysqlJdbc
 * @author:xiaodong
 * @date:2021-06-06 23:08:48
 * @description:  原生jdbc的方式和PrepareStatement 批处理方式
 */
public class MysqlJdbc {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/test";
    private static final String USERNAME = "root";
    private static final String UPASSWORD = "123456";
    private static final String UDRIVER = "com.mysql.jdbc.Driver";

    private static  PreparedStatement ps=null;
    private static  Connection conn =null;

    public static void main(String[] args){
        ResultSet resultSet = null;
         /*
          * 编写sql语句
          */
         String sql ="SELECT id,uname FROM test WHERE id > ?";
         try {
            //加载驱动
            Class.forName(UDRIVER);
            //获取链接
            conn = DriverManager.getConnection(URL, USERNAME, UPASSWORD);
            //获取链接执行对象
             ps = conn.prepareStatement(sql);
            /*
             * 将参数传入
             * 此处根据参数类型的不同选用不同的方法传入
             */
             ps.setInt(1, 3);
            //执行Sql语句
            resultSet = ps.executeQuery();
            //遍历结果集
            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String uname = resultSet.getString("uname");
                System.out.println("用户ID为 : "+id+",用户名为: "+uname);
            }
         } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } finally {
            //逆序关闭资源
            try {
                if(resultSet!=null){
                    resultSet.close();
                }
                if(ps!=null){
                    ps.close();
                }
                if(conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
         }

        prepareStatementBanch();
     }

    public static void prepareStatementBanch() {


        try {

            //定义sql语句

            String sql = "insert into me (id,name,age ) values(?,?,?)";

            //创建语句对象

            ps = conn.prepareStatement(sql);

            for (int i = 0; i <= 10; i++) {

                //为字段赋值

                ps.setInt(1, i + 1);
                ps.setString(2, "name" + i);

                ps.setInt(3, 10 + i);

                //添加进批

                ps.addBatch();
                //设置条件当i对10取余为0时，先执行一次批语句，然后将批清除

                if (i % 10 == 0) {
                    ps.executeBatch();

                    ps.clearBatch();

                }

            }

            //将批中剩余的语句执行完毕
            ps.executeBatch();


        } catch (SQLException e) {
            // TODO Auto-generatedcatch block

            e.printStackTrace();

        }
    }
}
