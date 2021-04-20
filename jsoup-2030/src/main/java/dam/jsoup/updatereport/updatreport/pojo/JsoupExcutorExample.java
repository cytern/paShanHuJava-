package dam.jsoup.updatereport.updatreport.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JsoupExcutorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JsoupExcutorExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andExcutorCodeIsNull() {
            addCriterion("excutor_code is null");
            return (Criteria) this;
        }

        public Criteria andExcutorCodeIsNotNull() {
            addCriterion("excutor_code is not null");
            return (Criteria) this;
        }

        public Criteria andExcutorCodeEqualTo(String value) {
            addCriterion("excutor_code =", value, "excutorCode");
            return (Criteria) this;
        }

        public Criteria andExcutorCodeNotEqualTo(String value) {
            addCriterion("excutor_code <>", value, "excutorCode");
            return (Criteria) this;
        }

        public Criteria andExcutorCodeGreaterThan(String value) {
            addCriterion("excutor_code >", value, "excutorCode");
            return (Criteria) this;
        }

        public Criteria andExcutorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("excutor_code >=", value, "excutorCode");
            return (Criteria) this;
        }

        public Criteria andExcutorCodeLessThan(String value) {
            addCriterion("excutor_code <", value, "excutorCode");
            return (Criteria) this;
        }

        public Criteria andExcutorCodeLessThanOrEqualTo(String value) {
            addCriterion("excutor_code <=", value, "excutorCode");
            return (Criteria) this;
        }

        public Criteria andExcutorCodeLike(String value) {
            addCriterion("excutor_code like", value, "excutorCode");
            return (Criteria) this;
        }

        public Criteria andExcutorCodeNotLike(String value) {
            addCriterion("excutor_code not like", value, "excutorCode");
            return (Criteria) this;
        }

        public Criteria andExcutorCodeIn(List<String> values) {
            addCriterion("excutor_code in", values, "excutorCode");
            return (Criteria) this;
        }

        public Criteria andExcutorCodeNotIn(List<String> values) {
            addCriterion("excutor_code not in", values, "excutorCode");
            return (Criteria) this;
        }

        public Criteria andExcutorCodeBetween(String value1, String value2) {
            addCriterion("excutor_code between", value1, value2, "excutorCode");
            return (Criteria) this;
        }

        public Criteria andExcutorCodeNotBetween(String value1, String value2) {
            addCriterion("excutor_code not between", value1, value2, "excutorCode");
            return (Criteria) this;
        }

        public Criteria andExcutorTokenIsNull() {
            addCriterion("excutor_token is null");
            return (Criteria) this;
        }

        public Criteria andExcutorTokenIsNotNull() {
            addCriterion("excutor_token is not null");
            return (Criteria) this;
        }

        public Criteria andExcutorTokenEqualTo(String value) {
            addCriterion("excutor_token =", value, "excutorToken");
            return (Criteria) this;
        }

        public Criteria andExcutorTokenNotEqualTo(String value) {
            addCriterion("excutor_token <>", value, "excutorToken");
            return (Criteria) this;
        }

        public Criteria andExcutorTokenGreaterThan(String value) {
            addCriterion("excutor_token >", value, "excutorToken");
            return (Criteria) this;
        }

        public Criteria andExcutorTokenGreaterThanOrEqualTo(String value) {
            addCriterion("excutor_token >=", value, "excutorToken");
            return (Criteria) this;
        }

        public Criteria andExcutorTokenLessThan(String value) {
            addCriterion("excutor_token <", value, "excutorToken");
            return (Criteria) this;
        }

        public Criteria andExcutorTokenLessThanOrEqualTo(String value) {
            addCriterion("excutor_token <=", value, "excutorToken");
            return (Criteria) this;
        }

        public Criteria andExcutorTokenLike(String value) {
            addCriterion("excutor_token like", value, "excutorToken");
            return (Criteria) this;
        }

        public Criteria andExcutorTokenNotLike(String value) {
            addCriterion("excutor_token not like", value, "excutorToken");
            return (Criteria) this;
        }

        public Criteria andExcutorTokenIn(List<String> values) {
            addCriterion("excutor_token in", values, "excutorToken");
            return (Criteria) this;
        }

        public Criteria andExcutorTokenNotIn(List<String> values) {
            addCriterion("excutor_token not in", values, "excutorToken");
            return (Criteria) this;
        }

        public Criteria andExcutorTokenBetween(String value1, String value2) {
            addCriterion("excutor_token between", value1, value2, "excutorToken");
            return (Criteria) this;
        }

        public Criteria andExcutorTokenNotBetween(String value1, String value2) {
            addCriterion("excutor_token not between", value1, value2, "excutorToken");
            return (Criteria) this;
        }

        public Criteria andExcutorTimesIsNull() {
            addCriterion("excutor_times is null");
            return (Criteria) this;
        }

        public Criteria andExcutorTimesIsNotNull() {
            addCriterion("excutor_times is not null");
            return (Criteria) this;
        }

        public Criteria andExcutorTimesEqualTo(Integer value) {
            addCriterion("excutor_times =", value, "excutorTimes");
            return (Criteria) this;
        }

        public Criteria andExcutorTimesNotEqualTo(Integer value) {
            addCriterion("excutor_times <>", value, "excutorTimes");
            return (Criteria) this;
        }

        public Criteria andExcutorTimesGreaterThan(Integer value) {
            addCriterion("excutor_times >", value, "excutorTimes");
            return (Criteria) this;
        }

        public Criteria andExcutorTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("excutor_times >=", value, "excutorTimes");
            return (Criteria) this;
        }

        public Criteria andExcutorTimesLessThan(Integer value) {
            addCriterion("excutor_times <", value, "excutorTimes");
            return (Criteria) this;
        }

        public Criteria andExcutorTimesLessThanOrEqualTo(Integer value) {
            addCriterion("excutor_times <=", value, "excutorTimes");
            return (Criteria) this;
        }

        public Criteria andExcutorTimesIn(List<Integer> values) {
            addCriterion("excutor_times in", values, "excutorTimes");
            return (Criteria) this;
        }

        public Criteria andExcutorTimesNotIn(List<Integer> values) {
            addCriterion("excutor_times not in", values, "excutorTimes");
            return (Criteria) this;
        }

        public Criteria andExcutorTimesBetween(Integer value1, Integer value2) {
            addCriterion("excutor_times between", value1, value2, "excutorTimes");
            return (Criteria) this;
        }

        public Criteria andExcutorTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("excutor_times not between", value1, value2, "excutorTimes");
            return (Criteria) this;
        }

        public Criteria andSuccessTimesIsNull() {
            addCriterion("success_times is null");
            return (Criteria) this;
        }

        public Criteria andSuccessTimesIsNotNull() {
            addCriterion("success_times is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessTimesEqualTo(Integer value) {
            addCriterion("success_times =", value, "successTimes");
            return (Criteria) this;
        }

        public Criteria andSuccessTimesNotEqualTo(Integer value) {
            addCriterion("success_times <>", value, "successTimes");
            return (Criteria) this;
        }

        public Criteria andSuccessTimesGreaterThan(Integer value) {
            addCriterion("success_times >", value, "successTimes");
            return (Criteria) this;
        }

        public Criteria andSuccessTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("success_times >=", value, "successTimes");
            return (Criteria) this;
        }

        public Criteria andSuccessTimesLessThan(Integer value) {
            addCriterion("success_times <", value, "successTimes");
            return (Criteria) this;
        }

        public Criteria andSuccessTimesLessThanOrEqualTo(Integer value) {
            addCriterion("success_times <=", value, "successTimes");
            return (Criteria) this;
        }

        public Criteria andSuccessTimesIn(List<Integer> values) {
            addCriterion("success_times in", values, "successTimes");
            return (Criteria) this;
        }

        public Criteria andSuccessTimesNotIn(List<Integer> values) {
            addCriterion("success_times not in", values, "successTimes");
            return (Criteria) this;
        }

        public Criteria andSuccessTimesBetween(Integer value1, Integer value2) {
            addCriterion("success_times between", value1, value2, "successTimes");
            return (Criteria) this;
        }

        public Criteria andSuccessTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("success_times not between", value1, value2, "successTimes");
            return (Criteria) this;
        }

        public Criteria andLiveUpdateTimeIsNull() {
            addCriterion("live_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLiveUpdateTimeIsNotNull() {
            addCriterion("live_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLiveUpdateTimeEqualTo(Date value) {
            addCriterion("live_update_time =", value, "liveUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLiveUpdateTimeNotEqualTo(Date value) {
            addCriterion("live_update_time <>", value, "liveUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLiveUpdateTimeGreaterThan(Date value) {
            addCriterion("live_update_time >", value, "liveUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLiveUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("live_update_time >=", value, "liveUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLiveUpdateTimeLessThan(Date value) {
            addCriterion("live_update_time <", value, "liveUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLiveUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("live_update_time <=", value, "liveUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLiveUpdateTimeIn(List<Date> values) {
            addCriterion("live_update_time in", values, "liveUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLiveUpdateTimeNotIn(List<Date> values) {
            addCriterion("live_update_time not in", values, "liveUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLiveUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("live_update_time between", value1, value2, "liveUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLiveUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("live_update_time not between", value1, value2, "liveUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("`status` like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("`status` not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("`status` not between", value1, value2, "status");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

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