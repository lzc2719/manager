package cn.lzc.dao;


import cn.lzc.bean.Movie;
import cn.lzc.bean.MovieType;
import cn.lzc.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class MovieDao {


    //增加电影评论操作
    public void increaseMovieComment(String movieId,String commentUser,String commentTime,String commentText) throws Exception {
        Connection conn = DBUtils.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql = "insert into comment(movie_id,comment_user,comment_time,comment_content) value(?,?,?,?)";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,movieId);
            pstmt.setString(2,commentUser);
            pstmt.setString(3,commentTime);
            pstmt.setString(4,commentText);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeJDBC(conn);
        }
    }




    //更新movieName电影的评分
    public void updateMovieScoreByMovieName(String movieName,String movieScore) throws Exception {
        Connection conn = DBUtils.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql = "update movie set movie_score=? where movie_name=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,movieScore);
            pstmt.setString(2,movieName);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeJDBC(conn);
        }
    }



    //获得搜索的内容
    public List<Movie> getMovieListBySearchContent(String searchContent) throws Exception {
        Connection conn = DBUtils.getConnection();
        PreparedStatement pstmt = null;
        List<Movie> movieList=new ArrayList<Movie>();

        try {
            String sql = "select * from movie";
            pstmt=conn.prepareStatement(sql);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next()){
                if(rs.getString("movie_name").contains(searchContent)
                ||rs.getString("movie_name").equals(searchContent)){
                    Movie movie=new Movie();
                    movie.setMovieId(rs.getInt(1));
                    movie.setMovieName(rs.getString(2));
                    String s1=rs.getString("movie_name");
                    movie.setMovieYear(rs.getString(3));
                    movie.setMovieNation(rs.getString(4));
                    movie.setMovieDirector(rs.getString(5));
                    movie.setMovieActor(rs.getString(6));
                    movie.setMovieType(rs.getString(7));
                    movie.setMovieBrief(rs.getString(8));
                    movie.setMovieScore(rs.getString(9));
                    movie.setMoviePicture(rs.getString(10));
                    movie.setMovieLink(rs.getString(11));
                    movie.setMovieTime(rs.getString(12));
                    movieList.add(movie);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeJDBC(conn);
        }
        return movieList;
    }



    //通过电影类型名字查找对应电影类型清单，并返回
    public String getMovieTypeListByMovieTypeName(String movieTypeName) throws Exception {
        Connection conn = DBUtils.getConnection();
        PreparedStatement pstmt = null;
        String movieTypeList=null;
        try {
            String sql = "select movie_type_list from movie_type where movie_type_name=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,movieTypeName);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next()){
                movieTypeList=rs.getString("movie_type_list");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeJDBC(conn);
        }
        String s1=movieTypeList;
        return movieTypeList;
    }



    //通过电影类型列表的电影字符串，获得对应的电影集合
    public List<Movie> getMoviesByMovieTypeList(String[] movieTypeList) throws Exception {
        Connection conn = DBUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs=null;
        List<Movie> movieList=new ArrayList<Movie>();

        try {
            int num=movieTypeList.length;
            for(int i=0;i<movieTypeList.length;i++){
                String sql = "select movie_id,movie_name,movie_year,movie_nation,movie_director,\n" +
                        "movie_actor,movie_type,movie_brief,movie_score,movie_picture,\n" +
                        "movie_link,movie_time from movie where movie_name=?";
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1,movieTypeList[i]);
                rs=pstmt.executeQuery();
                while (rs.next()){
                    Movie movie=new Movie();
                    movie.setMovieId(rs.getInt(1));
                    movie.setMovieName(rs.getString(2));
                    movie.setMovieYear(rs.getString(3));
                    movie.setMovieNation(rs.getString(4));
                    movie.setMovieDirector(rs.getString(5));
                    movie.setMovieActor(rs.getString(6));
                    movie.setMovieType(rs.getString(7));
                    movie.setMovieBrief(rs.getString(8));
                    movie.setMovieScore(rs.getString(9));
                    movie.setMoviePicture(rs.getString(10));
                    movie.setMovieLink(rs.getString(11));
                    movie.setMovieTime(rs.getString(12));
                    movieList.add(movie);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeJDBC(conn);
        }
        for(Movie movie:movieList){
            String s1=movie.getMovieName();
            String s2=movie.getMovieActor();
            String s3=movie.getMovieDirector();
        }
        return movieList;
    }



    //根据电影名，存放它对应的电影图片名
    public void addMoviePicture(String movieName,String pictureFileName) throws Exception {
        Connection conn = DBUtils.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql = "update movie set movie_picture=? where movie_name=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,pictureFileName);
            pstmt.setString(2,movieName);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeJDBC(conn);
        }
    }




    //添加电影类型，movieTypeName：要添加的电影类型名
    public void addMovieType(String movieTypeName) throws Exception {
        Connection conn = DBUtils.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql = "insert into movie_type(movie_type_name) value(?)";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,movieTypeName);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeJDBC(conn);
        }
    }



    //获取数据库中所有的电影类型记录
    public List<MovieType> getAllMovieType() throws Exception {
        List<MovieType> arrayList = new ArrayList<MovieType>();
        Connection conn = DBUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "select movie_type_id,movie_type_name,movie_type_list from movie_type\n";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                MovieType movieType = new MovieType();
                movieType.setMovieTypeId(rs.getInt(1));
                movieType.setMovieTypeName(rs.getString(2));
                movieType.setMovieTypeList(rs.getString(3));
                String str=rs.getString("movie_type_name");
                arrayList.add(movieType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeJDBC(conn);
        }
        return arrayList;
    }




    //删除电影，movieName：要删除的电影名
    public void deleteMovie(String movieName) throws Exception {
        Connection conn = DBUtils.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql = "delete from movie where movie_name=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,movieName);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeJDBC(conn);
        }
    }



    //删除电影类型，movieTypeName：要删除的电影类型名
    public void deleteMovieType(String movieTypeName) throws Exception {
        Connection conn = DBUtils.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql = "delete from movie_type where movie_type_name=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,movieTypeName);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeJDBC(conn);
        }
    }



    //根据updateType，获取相应的sql语句
    public String selectSql(String updateType){
        String sql = null;
        if(updateType.equals("movie_year")){
            sql = "update movie set movie_year=? where movie_name=?";
        }else if(updateType.equals("movie_nation")){
            sql = "update movie set movie_nation=? where movie_name=?";
        }else if(updateType.equals("movie_director")){
            sql = sql = "update movie set movie_director=? where movie_name=?";
        }else if(updateType.equals("movie_actor")){
            sql = "update movie set movie_actor=? where movie_name=?";
        }else if(updateType.equals("movie_type")){
            sql = "update movie set movie_type=? where movie_name=?";
        }else if(updateType.equals("movie_brief")){
            sql = "update movie set movie_brief=? where movie_name=?";
        }else if(updateType.equals("movie_link")){
            sql = "update movie set movie_link=? where movie_name=?";
        }else if(updateType.equals("movie_time")){
            sql = "update movie set movie_time=? where movie_name=?";
        }
        return sql;
    }





    //更新电影信息，movieName：要修改的电影名，updateType：修改类型，updateContent：修改内容
    public void updateMovie(String movieName,String updateType,String updateContent) throws Exception {
        Connection conn = DBUtils.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql = selectSql(updateType);
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,updateContent);
            pstmt.setString(2,movieName);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeJDBC(conn);
        }
    }





    //保存电影，movie：电影对象
    public void addMovie(Movie movie) throws Exception {
        Connection conn = DBUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "insert into movie(movie_name,movie_year,movie_nation,movie_director,movie_actor,movie_type,movie_brief,movie_link,movie_time) value(?,?,?,?,?,?,?,?,?)";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,movie.getMovieName());
            pstmt.setString(2,movie.getMovieYear());
            pstmt.setString(3,movie.getMovieNation());
            pstmt.setString(4,movie.getMovieDirector());
            pstmt.setString(5,movie.getMovieActor());
            pstmt.setString(6,movie.getMovieType());
            pstmt.setString(7,movie.getMovieBrief());
            pstmt.setString(8,movie.getMovieLink());
            pstmt.setString(9,movie.getMovieTime());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeJDBC(conn);
        }
    }




    //获取数据库中所有的电影记录
    public List<Movie> getAllMovies() throws Exception {
        List<Movie> arrayList = new ArrayList<Movie>();
        Connection conn = DBUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT \n" +
                    "movie_id,\n" +
                    "movie_name,\n" +
                    "movie_year,\n" +
                    "movie_nation,\n" +
                    "movie_director,\n" +
                    "movie_actor,\n" +
                    "movie_type,\n" +
                    "movie_brief,\n" +
                    "movie_score,\n" +
                    "movie_picture,\n" +
                    "movie_link,\n" +
                    "movie_time \n" +
                    "FROM \n" +
                    "movie\n";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setMovieId(rs.getInt(1));
                movie.setMovieName(rs.getString(2));
                movie.setMovieYear(rs.getString(3));
                movie.setMovieNation(rs.getString(4));
                movie.setMovieDirector(rs.getString(5));
                movie.setMovieActor(rs.getString(6));
                movie.setMovieType(rs.getString(7));
                movie.setMovieBrief(rs.getString(8));
                movie.setMovieScore(rs.getString(9));
                movie.setMoviePicture(rs.getString(10));
                movie.setMovieLink(rs.getString(11));
                movie.setMovieTime(rs.getString(12));
                arrayList.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeJDBC(conn);
        }
        return arrayList;
    }



    //将要添加的电影添加进对应的电影类型里面来
    public void increaseMovieTypeList(String movieName,String[] movieTypeList) throws Exception {
        Connection conn = DBUtils.getConnection();
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs = null;

        try {
            for(int i=0;i<movieTypeList.length;i++){
                String sql = "select movie_type_list from movie_type where movie_type_name=?";
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1,movieTypeList[i]);
                rs= pstmt.executeQuery();
                String str = null;
                if(rs.next()){
                    str=(String)rs.getString("movie_type_list");
                }
                if(str.lastIndexOf("、")==str.length()-1)
                    str+=movieName;
                else
                    str+="、"+movieName;

                String sql2="update movie_type set movie_type_list=? where movie_type_name=?";
                pstmt2=conn.prepareStatement(sql2);
                pstmt2.setString(1,str);
                pstmt2.setString(2,movieTypeList[i]);
                pstmt2.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeJDBC(conn);
        }
    }



    //将当前电影类型清单里面要删除的电影删除掉
    public void reduceMovieTypeList(String movieName) throws Exception {
        Connection conn = DBUtils.getConnection();
        String sql=null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        PreparedStatement pstmt3 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;

        try {
            //1.查找所有的电影类型，挑选出电影类型清单里面包含了要被删除的电影名的电影类型集合
            int n=0;
            String[] str=new String[100];
            sql="select * from movie_type";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next())
                if(rs.getString(3).contains(movieName))
                    str[n++]=rs.getString(2);






            for(int i=0;i<n;i++){
                //2.找出当前电影类型里面的电影类型清单
                String sql2=null;
                sql2="select movie_type_list from movie_type where movie_type_name=?";
                pstmt2=conn.prepareStatement(sql2);
                pstmt2.setString(1,str[i]);
                rs2=pstmt2.executeQuery();


                //3.把当前挑选出来的电影类型清单字符串进行分离，剔除掉要被删除的电影名再重组成字符串
                String[] str2=new String[100];
                while(rs2.next()){
                    String movieTypeList=(String)rs2.getString("movie_type_list");
                    str2=movieTypeList.split("、");
                }
                StringBuffer stringBuffer=new StringBuffer();
                for(int j=0;j<str2.length;j++)
                    if(!(movieName.equals(str2[j]))){
                        if(j==str2.length-1){
                            stringBuffer.append(str2[j]);
                            break;
                        }
                        stringBuffer.append(str2[j]).append("、");
                    }



                //4.将剔除掉电影名的当前电影类型清单，重新插入到当前电影类型里去
                String sql3=null;
                sql3="update movie_type set movie_type_list=? where movie_type_name=?";
                pstmt3=conn.prepareStatement(sql3);
                pstmt3.setString(1,stringBuffer.toString());
                pstmt3.setString(2,str[i]);
                pstmt3.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeJDBC(conn);
        }
    }

}











