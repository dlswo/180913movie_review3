package org.dao;

import org.domain.MemberVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberDAO {

    public List<MemberVO> checkLogin(){

       final List<MemberVO> list = new ArrayList<MemberVO>();
       final String sql ="select * from tbl_member";

        new QueryExecutor() {
            @Override
            public void doJob() throws Exception {

                stmt=con.prepareStatement(sql);
                rs = stmt.executeQuery();

                while (rs.next()){
                    MemberVO vo = new MemberVO();
                    vo.setId(rs.getString("id"));
                    vo.setPw(rs.getString("pw"));
                    vo.setName(rs.getString("name"));
                    vo.setAddr(rs.getString("addr"));
                    list.add(vo);
                }
            }
        }.executeAll();


        return list;
    }

    public List<MemberVO> getList() {
        final List<MemberVO> list = new ArrayList<MemberVO>();
        final String sql = "select * from tbl_member";


        new QueryExecutor() {
            @Override
            public void doJob() throws Exception {
                stmt = con.prepareStatement(sql);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    MemberVO vo = new MemberVO();
                    vo.setId(rs.getString("id"));
                    vo.setPw(rs.getString("pw"));
                    vo.setName(rs.getString("name"));
                    vo.setAddr(rs.getString("addr"));
                    list.add(vo);
                }
            }
        }.executeAll();
        return  list;
    }
}