package cn.lzc.bean;


//电影JavaBean类
public class Movie {
    private int movieId;//电影id
    private String movieName;//电影名
    private String movieYear;//上映时间
    private String movieNation;//产自国
    private String movieDirector;//导演
    private String movieActor;//演员
    private String movieType;//电影类型
    private String movieBrief;//电影简介
    private String movieScore;//电影评分
    private String moviePicture;//电影图片
    private String movieLink;//电影链接
    private String movieTime;//电影时长



    public Movie(){}

    public Movie(String movieName, String movieYear, String movieNation, String movieDirector, String movieActor, String movieType, String movieBrief, String movieLink, String movieTime) {
        this.movieName = movieName;
        this.movieYear = movieYear;
        this.movieNation = movieNation;
        this.movieDirector = movieDirector;
        this.movieActor = movieActor;
        this.movieType = movieType;
        this.movieBrief = movieBrief;
        this.movieLink = movieLink;
        this.movieTime = movieTime;
    }

    public Movie(int movieId, String movieName, String movieYear, String movieNation, String movieDirector, String movieActor, String movieType, String movieBrief, String movieScore, String moviePicture, String movieLink, String movieTime) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieYear = movieYear;
        this.movieNation = movieNation;
        this.movieDirector = movieDirector;
        this.movieActor = movieActor;
        this.movieType = movieType;
        this.movieBrief = movieBrief;
        this.movieScore = movieScore;
        this.moviePicture = moviePicture;
        this.movieLink = movieLink;
        this.movieTime = movieTime;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public String getMovieNation() {
        return movieNation;
    }

    public void setMovieNation(String movieNation) {
        this.movieNation = movieNation;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public String getMovieActor() {
        return movieActor;
    }

    public void setMovieActor(String movieActor) {
        this.movieActor = movieActor;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getMovieBrief() {
        return movieBrief;
    }

    public void setMovieBrief(String movieBrief) {
        this.movieBrief = movieBrief;
    }

    public String getMovieScore() {
        return movieScore;
    }

    public void setMovieScore(String movieScore) {
        this.movieScore = movieScore;
    }

    public String getMoviePicture() {
        return moviePicture;
    }

    public void setMoviePicture(String moviePicture) {
        this.moviePicture = moviePicture;
    }

    public String getMovieLink() {
        return movieLink;
    }

    public void setMovieLink(String movieLink) {
        this.movieLink = movieLink;
    }

    public String getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }
}
