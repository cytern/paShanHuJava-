package dam.jsoup.updatereport.updatreport.robot.pojo;




public class AgeSearchData {
    private Integer count;
    private String matchType;
    private Integer page;
    /**
     * 地区
     */
    private String region;

    private String searchPlayer;
    private String teamSize;
    private String versus;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSearchPlayer() {
        return searchPlayer;
    }

    public void setSearchPlayer(String searchPlayer) {
        this.searchPlayer = searchPlayer;
    }

    public String getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(String teamSize) {
        this.teamSize = teamSize;
    }

    public String getVersus() {
        return versus;
    }

    public void setVersus(String versus) {
        this.versus = versus;
    }
}
