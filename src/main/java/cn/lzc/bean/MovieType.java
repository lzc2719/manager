package cn.lzc.bean;

public class MovieType {
    private int movieTypeId;//电影类型的id
    private String movieTypeName;//电影类型的名字
    private String movieTypeList;//这种类型的电影清单

    public MovieType(){}

    public int getMovieTypeId() {
        return movieTypeId;
    }

    public MovieType(String movieTypeName, String movieTypeList) {
        this.movieTypeName = movieTypeName;
        this.movieTypeList = movieTypeList;
    }

    public void setMovieTypeId(int movieTypeId) {
        this.movieTypeId = movieTypeId;
    }

    public String getMovieTypeName() {
        return movieTypeName;
    }

    public void setMovieTypeName(String movieTypeName) {
        this.movieTypeName = movieTypeName;
    }

    public String getMovieTypeList() {
        return movieTypeList;
    }

    public void setMovieTypeList(String movieTypeList) {
        this.movieTypeList = movieTypeList;
    }
}
