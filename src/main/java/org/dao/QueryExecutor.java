package org.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class QueryExecutor implements Executor {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;
    protected Connection con = null;
    protected PreparedStatement stmt = null;
    protected ResultSet rs = null;


    public void executeAll(){

        try {
            makeConnection();
            doJob();
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally{
            closeAll();
        }//end finally
    }//end executeAll

    private void  makeConnection() throws Exception{
        con = DataSource.getConnection();
    }//end makeConnection

    private void closeAll(){
        System.out.println("close All...." + con);
        if(rs != null) {
            try { rs.close(); }catch(Exception e){}
        }
        if(stmt != null) {
            try { stmt.close(); }catch(Exception e){}
        }
        if(con != null) {
            try { con.close(); }catch(Exception e){}
        }
    }//end closeAll

}//end class