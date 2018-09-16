package org.dao;


import org.domain.MovieVO;

import java.util.ArrayList;
import java.util.List;


public class MovieDAO {

    public void updateView(final int mno){

        final String sql = "update tbl_movie_review \n" +
                "set views=views+1\n" +
                "where mno=?";

        new QueryExecutor() {
            @Override
            public void doJob() throws Exception {
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, mno);
                stmt.executeUpdate();
            }
        }.executeAll();
    }


    public int getLastPage(){
        final String sql = "select ceil(count(*)/10) from tbl_movie_review";
        final int[] lastPage = {0};
        new QueryExecutor() {
            public void doJob() throws Exception {
                stmt = con.prepareStatement(sql);

                rs = stmt.executeQuery();
                rs.next();
                lastPage[0] = rs.getInt(1);

            }
        }.executeAll();
        return lastPage[0];
    }

    public List<MovieVO> getList(final int page) {
        final List<MovieVO> list = new ArrayList<MovieVO>();
        final String sql = "select *\n" +
                "from\n" +
                "(select \n" +
                "/*+INDEX_DESC(tbl_movie_review pk_movie_review)*/\n" +
                "  rownum rn, mno,mtitle,cmt,mimg, regdate, userid, rtitle, views \n" +
                "  from tbl_movie_review\n" +
                "  where rownum <=(?*10)\n" +
                "  and tbl_movie_review.mno > 0 ) movie\n" +
                "where rn > (?*10)-10";          //sql문 뒤에 세미콜론 안됨

        new QueryExecutor() {
            public void doJob() throws Exception {
                stmt = con.prepareStatement(sql);
                stmt.setInt(1,page);
                stmt.setInt(2,page);

                rs = stmt.executeQuery();
                while (rs.next()) {
                    MovieVO vo = new MovieVO();
                    vo.setMno(rs.getInt("mno"));
                    vo.setMimg(rs.getString("mimg"));
                    vo.setCmt(rs.getString("cmt"));
                    vo.setMtitle(rs.getString("mtitle"));
                    vo.setUserid(rs.getString("userid"));
                    vo.setRtitle(rs.getString("rtitle"));
                    vo.setRegdate(rs.getDate("regdate"));
                    vo.setViews(rs.getInt("views"));
                    list.add(vo);
                }
            }
        }.executeAll();

        return list;
    }

    public MovieVO getReview(final int mno) {
        final MovieVO vo = new MovieVO();
        final String sql = "select * from tbl_movie_review where mno = ?";

        new QueryExecutor() {
            public void doJob() throws Exception {
                stmt = con.prepareStatement(sql);
                stmt.setInt(1,mno);
                rs = stmt.executeQuery();
                while(rs.next()){
                    vo.setMno(rs.getInt("mno"));
                    vo.setMimg(rs.getString("mimg"));
                    vo.setCmt(rs.getString("cmt"));
                    vo.setMtitle(rs.getString("mtitle"));
                    vo.setUserid(rs.getString("userid"));
                    vo.setRtitle(rs.getString("rtitle"));
                    vo.setRegdate(rs.getDate("regdate"));
                }
            }
        }.executeAll();

        //code
        return vo;
    }

    public void addReview(final MovieVO vo) {
        final String sql = "insert into tbl_movie_review (mno, mtitle, userid, rtitle, cmt, mimg)\n" +
                "values ( seq_movie_review.nextval, ?, ?, ?, ?, ?)";
        //mnum, score, cmt
        new QueryExecutor() {
            public void doJob() throws Exception {
                stmt = con.prepareStatement(sql);
                stmt.setString(1,vo.getMtitle());
                stmt.setString(2,vo.getUserid());
                stmt.setString(3,vo.getRtitle());
                stmt.setString(4,vo.getCmt());
                stmt.setString(5,vo.getMimg());
                stmt.executeUpdate();
            }
        }.executeAll();
    }

    public void deleteReview(final int mno) {
        final String sql = "delete from tbl_movie_review where mno = ?";

        new QueryExecutor() {
            public void doJob() throws Exception {
                stmt = con.prepareStatement(sql);
                stmt.setInt(1,mno);
                stmt.executeUpdate();
            }
        }.executeAll();
    }

    public void updateReview(final int mno,final MovieVO vo) {
        final String sql = "update tbl_movie_review set mtitle = ?,userid = ?,rtitle = ?, cmt = ?, mimg = ?, regdate = sysdate where mno= ?";

        new QueryExecutor() {
            public void doJob() throws Exception {
                stmt = con.prepareStatement(sql);
                stmt.setString(1,vo.getMtitle());
                stmt.setString(2,vo.getUserid());
                stmt.setString(3,vo.getRtitle());
                stmt.setString(4,vo.getCmt());
                stmt.setString(5,vo.getMimg());
                stmt.setInt(6,mno);
                stmt.executeUpdate();
            }
        }.executeAll();
    }


}
