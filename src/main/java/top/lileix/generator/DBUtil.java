package top.lileix.generator;

import top.lileix.generator.model.db.DBFieldModel;
import top.lileix.generator.model.db.TableModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lilei on 2017/2/25.
 */
public class DBUtil {


    static String driverName = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://172.16.8.111:3306/db_order";
    static String username = "root";
    static String password = "root-mysql-yo";

    private static Connection connection;

    public  Connection getConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                return connection;
            }
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取所有的表名
     *
     * @param conn
     * @return
     * @throws SQLException
     */
    public List<TableModel> getAllTables(Connection conn) throws SQLException {
        ArrayList<TableModel> tables = new ArrayList();
        //mysql版本
        PreparedStatement pstate = conn.prepareStatement("show table status");
        ResultSet results = pstate.executeQuery();
        while (results.next()) {
            TableModel tableModel = new TableModel();
            tableModel.setName(results.getString(1));
            tableModel.setComment(results.getString("COMMENT"));
            tables.add(tableModel);
        }
        return tables;
    }


    public List<DBFieldModel> getFields(Connection conn, TableModel tableModel) throws SQLException {
        List<DBFieldModel> fieldModels = new ArrayList();
        ResultSet results = conn.prepareStatement("show full fields from " + tableModel.getName()).executeQuery();
        while (results.next()) {
            DBFieldModel fieldModel = new DBFieldModel();
            fieldModel.setField(results.getString("FIELD"));
            fieldModel.setType(results.getString("TYPE"));
            fieldModel.setAllowNull(results.getString("NULL"));
            fieldModel.setKey(results.getString("KEY"));
            fieldModel.setExtra(results.getString("EXTRA"));
            fieldModel.setComment(results.getString("COMMENT"));
            fieldModels.add(fieldModel);
        }
        return fieldModels;
    }


}
