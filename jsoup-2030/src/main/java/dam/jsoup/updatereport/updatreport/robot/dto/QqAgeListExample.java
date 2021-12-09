package dam.jsoup.updatereport.updatreport.robot.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QqAgeListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QqAgeListExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andQqIdIsNull() {
            addCriterion("qq_id is null");
            return (Criteria) this;
        }

        public Criteria andQqIdIsNotNull() {
            addCriterion("qq_id is not null");
            return (Criteria) this;
        }

        public Criteria andQqIdEqualTo(String value) {
            addCriterion("qq_id =", value, "qqId");
            return (Criteria) this;
        }

        public Criteria andQqIdNotEqualTo(String value) {
            addCriterion("qq_id <>", value, "qqId");
            return (Criteria) this;
        }

        public Criteria andQqIdGreaterThan(String value) {
            addCriterion("qq_id >", value, "qqId");
            return (Criteria) this;
        }

        public Criteria andQqIdGreaterThanOrEqualTo(String value) {
            addCriterion("qq_id >=", value, "qqId");
            return (Criteria) this;
        }

        public Criteria andQqIdLessThan(String value) {
            addCriterion("qq_id <", value, "qqId");
            return (Criteria) this;
        }

        public Criteria andQqIdLessThanOrEqualTo(String value) {
            addCriterion("qq_id <=", value, "qqId");
            return (Criteria) this;
        }

        public Criteria andQqIdLike(String value) {
            addCriterion("qq_id like", value, "qqId");
            return (Criteria) this;
        }

        public Criteria andQqIdNotLike(String value) {
            addCriterion("qq_id not like", value, "qqId");
            return (Criteria) this;
        }

        public Criteria andQqIdIn(List<String> values) {
            addCriterion("qq_id in", values, "qqId");
            return (Criteria) this;
        }

        public Criteria andQqIdNotIn(List<String> values) {
            addCriterion("qq_id not in", values, "qqId");
            return (Criteria) this;
        }

        public Criteria andQqIdBetween(String value1, String value2) {
            addCriterion("qq_id between", value1, value2, "qqId");
            return (Criteria) this;
        }

        public Criteria andQqIdNotBetween(String value1, String value2) {
            addCriterion("qq_id not between", value1, value2, "qqId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(String value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(String value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(String value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(String value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(String value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLike(String value) {
            addCriterion("group_id like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotLike(String value) {
            addCriterion("group_id not like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<String> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<String> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(String value1, String value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(String value1, String value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("`type` like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("`type` not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andRankIsNull() {
            addCriterion("`rank` is null");
            return (Criteria) this;
        }

        public Criteria andRankIsNotNull() {
            addCriterion("`rank` is not null");
            return (Criteria) this;
        }

        public Criteria andRankEqualTo(Integer value) {
            addCriterion("`rank` =", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotEqualTo(Integer value) {
            addCriterion("`rank` <>", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThan(Integer value) {
            addCriterion("`rank` >", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThanOrEqualTo(Integer value) {
            addCriterion("`rank` >=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThan(Integer value) {
            addCriterion("`rank` <", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThanOrEqualTo(Integer value) {
            addCriterion("`rank` <=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankIn(List<Integer> values) {
            addCriterion("`rank` in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotIn(List<Integer> values) {
            addCriterion("`rank` not in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankBetween(Integer value1, Integer value2) {
            addCriterion("`rank` between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotBetween(Integer value1, Integer value2) {
            addCriterion("`rank` not between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andEloIsNull() {
            addCriterion("elo is null");
            return (Criteria) this;
        }

        public Criteria andEloIsNotNull() {
            addCriterion("elo is not null");
            return (Criteria) this;
        }

        public Criteria andEloEqualTo(Integer value) {
            addCriterion("elo =", value, "elo");
            return (Criteria) this;
        }

        public Criteria andEloNotEqualTo(Integer value) {
            addCriterion("elo <>", value, "elo");
            return (Criteria) this;
        }

        public Criteria andEloGreaterThan(Integer value) {
            addCriterion("elo >", value, "elo");
            return (Criteria) this;
        }

        public Criteria andEloGreaterThanOrEqualTo(Integer value) {
            addCriterion("elo >=", value, "elo");
            return (Criteria) this;
        }

        public Criteria andEloLessThan(Integer value) {
            addCriterion("elo <", value, "elo");
            return (Criteria) this;
        }

        public Criteria andEloLessThanOrEqualTo(Integer value) {
            addCriterion("elo <=", value, "elo");
            return (Criteria) this;
        }

        public Criteria andEloIn(List<Integer> values) {
            addCriterion("elo in", values, "elo");
            return (Criteria) this;
        }

        public Criteria andEloNotIn(List<Integer> values) {
            addCriterion("elo not in", values, "elo");
            return (Criteria) this;
        }

        public Criteria andEloBetween(Integer value1, Integer value2) {
            addCriterion("elo between", value1, value2, "elo");
            return (Criteria) this;
        }

        public Criteria andEloNotBetween(Integer value1, Integer value2) {
            addCriterion("elo not between", value1, value2, "elo");
            return (Criteria) this;
        }

        public Criteria andMatchTimesIsNull() {
            addCriterion("match_times is null");
            return (Criteria) this;
        }

        public Criteria andMatchTimesIsNotNull() {
            addCriterion("match_times is not null");
            return (Criteria) this;
        }

        public Criteria andMatchTimesEqualTo(Integer value) {
            addCriterion("match_times =", value, "matchTimes");
            return (Criteria) this;
        }

        public Criteria andMatchTimesNotEqualTo(Integer value) {
            addCriterion("match_times <>", value, "matchTimes");
            return (Criteria) this;
        }

        public Criteria andMatchTimesGreaterThan(Integer value) {
            addCriterion("match_times >", value, "matchTimes");
            return (Criteria) this;
        }

        public Criteria andMatchTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("match_times >=", value, "matchTimes");
            return (Criteria) this;
        }

        public Criteria andMatchTimesLessThan(Integer value) {
            addCriterion("match_times <", value, "matchTimes");
            return (Criteria) this;
        }

        public Criteria andMatchTimesLessThanOrEqualTo(Integer value) {
            addCriterion("match_times <=", value, "matchTimes");
            return (Criteria) this;
        }

        public Criteria andMatchTimesIn(List<Integer> values) {
            addCriterion("match_times in", values, "matchTimes");
            return (Criteria) this;
        }

        public Criteria andMatchTimesNotIn(List<Integer> values) {
            addCriterion("match_times not in", values, "matchTimes");
            return (Criteria) this;
        }

        public Criteria andMatchTimesBetween(Integer value1, Integer value2) {
            addCriterion("match_times between", value1, value2, "matchTimes");
            return (Criteria) this;
        }

        public Criteria andMatchTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("match_times not between", value1, value2, "matchTimes");
            return (Criteria) this;
        }

        public Criteria andWinRateIsNull() {
            addCriterion("win_rate is null");
            return (Criteria) this;
        }

        public Criteria andWinRateIsNotNull() {
            addCriterion("win_rate is not null");
            return (Criteria) this;
        }

        public Criteria andWinRateEqualTo(String value) {
            addCriterion("win_rate =", value, "winRate");
            return (Criteria) this;
        }

        public Criteria andWinRateNotEqualTo(String value) {
            addCriterion("win_rate <>", value, "winRate");
            return (Criteria) this;
        }

        public Criteria andWinRateGreaterThan(String value) {
            addCriterion("win_rate >", value, "winRate");
            return (Criteria) this;
        }

        public Criteria andWinRateGreaterThanOrEqualTo(String value) {
            addCriterion("win_rate >=", value, "winRate");
            return (Criteria) this;
        }

        public Criteria andWinRateLessThan(String value) {
            addCriterion("win_rate <", value, "winRate");
            return (Criteria) this;
        }

        public Criteria andWinRateLessThanOrEqualTo(String value) {
            addCriterion("win_rate <=", value, "winRate");
            return (Criteria) this;
        }

        public Criteria andWinRateLike(String value) {
            addCriterion("win_rate like", value, "winRate");
            return (Criteria) this;
        }

        public Criteria andWinRateNotLike(String value) {
            addCriterion("win_rate not like", value, "winRate");
            return (Criteria) this;
        }

        public Criteria andWinRateIn(List<String> values) {
            addCriterion("win_rate in", values, "winRate");
            return (Criteria) this;
        }

        public Criteria andWinRateNotIn(List<String> values) {
            addCriterion("win_rate not in", values, "winRate");
            return (Criteria) this;
        }

        public Criteria andWinRateBetween(String value1, String value2) {
            addCriterion("win_rate between", value1, value2, "winRate");
            return (Criteria) this;
        }

        public Criteria andWinRateNotBetween(String value1, String value2) {
            addCriterion("win_rate not between", value1, value2, "winRate");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andDefultIsNull() {
            addCriterion("defult is null");
            return (Criteria) this;
        }

        public Criteria andDefultIsNotNull() {
            addCriterion("defult is not null");
            return (Criteria) this;
        }

        public Criteria andDefultEqualTo(Integer value) {
            addCriterion("defult =", value, "defult");
            return (Criteria) this;
        }

        public Criteria andDefultNotEqualTo(Integer value) {
            addCriterion("defult <>", value, "defult");
            return (Criteria) this;
        }

        public Criteria andDefultGreaterThan(Integer value) {
            addCriterion("defult >", value, "defult");
            return (Criteria) this;
        }

        public Criteria andDefultGreaterThanOrEqualTo(Integer value) {
            addCriterion("defult >=", value, "defult");
            return (Criteria) this;
        }

        public Criteria andDefultLessThan(Integer value) {
            addCriterion("defult <", value, "defult");
            return (Criteria) this;
        }

        public Criteria andDefultLessThanOrEqualTo(Integer value) {
            addCriterion("defult <=", value, "defult");
            return (Criteria) this;
        }

        public Criteria andDefultIn(List<Integer> values) {
            addCriterion("defult in", values, "defult");
            return (Criteria) this;
        }

        public Criteria andDefultNotIn(List<Integer> values) {
            addCriterion("defult not in", values, "defult");
            return (Criteria) this;
        }

        public Criteria andDefultBetween(Integer value1, Integer value2) {
            addCriterion("defult between", value1, value2, "defult");
            return (Criteria) this;
        }

        public Criteria andDefultNotBetween(Integer value1, Integer value2) {
            addCriterion("defult not between", value1, value2, "defult");
            return (Criteria) this;
        }

        public Criteria andAgeNameIsNull() {
            addCriterion("age_name is null");
            return (Criteria) this;
        }

        public Criteria andAgeNameIsNotNull() {
            addCriterion("age_name is not null");
            return (Criteria) this;
        }

        public Criteria andAgeNameEqualTo(String value) {
            addCriterion("age_name =", value, "ageName");
            return (Criteria) this;
        }

        public Criteria andAgeNameNotEqualTo(String value) {
            addCriterion("age_name <>", value, "ageName");
            return (Criteria) this;
        }

        public Criteria andAgeNameGreaterThan(String value) {
            addCriterion("age_name >", value, "ageName");
            return (Criteria) this;
        }

        public Criteria andAgeNameGreaterThanOrEqualTo(String value) {
            addCriterion("age_name >=", value, "ageName");
            return (Criteria) this;
        }

        public Criteria andAgeNameLessThan(String value) {
            addCriterion("age_name <", value, "ageName");
            return (Criteria) this;
        }

        public Criteria andAgeNameLessThanOrEqualTo(String value) {
            addCriterion("age_name <=", value, "ageName");
            return (Criteria) this;
        }

        public Criteria andAgeNameLike(String value) {
            addCriterion("age_name like", value, "ageName");
            return (Criteria) this;
        }

        public Criteria andAgeNameNotLike(String value) {
            addCriterion("age_name not like", value, "ageName");
            return (Criteria) this;
        }

        public Criteria andAgeNameIn(List<String> values) {
            addCriterion("age_name in", values, "ageName");
            return (Criteria) this;
        }

        public Criteria andAgeNameNotIn(List<String> values) {
            addCriterion("age_name not in", values, "ageName");
            return (Criteria) this;
        }

        public Criteria andAgeNameBetween(String value1, String value2) {
            addCriterion("age_name between", value1, value2, "ageName");
            return (Criteria) this;
        }

        public Criteria andAgeNameNotBetween(String value1, String value2) {
            addCriterion("age_name not between", value1, value2, "ageName");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private final String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private final String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}