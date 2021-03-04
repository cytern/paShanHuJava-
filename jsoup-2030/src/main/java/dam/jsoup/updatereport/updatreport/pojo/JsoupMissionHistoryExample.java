package dam.jsoup.updatereport.updatreport.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JsoupMissionHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JsoupMissionHistoryExample() {
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

        public Criteria andMissionStateIdIsNull() {
            addCriterion("mission_state_id is null");
            return (Criteria) this;
        }

        public Criteria andMissionStateIdIsNotNull() {
            addCriterion("mission_state_id is not null");
            return (Criteria) this;
        }

        public Criteria andMissionStateIdEqualTo(Integer value) {
            addCriterion("mission_state_id =", value, "missionStateId");
            return (Criteria) this;
        }

        public Criteria andMissionStateIdNotEqualTo(Integer value) {
            addCriterion("mission_state_id <>", value, "missionStateId");
            return (Criteria) this;
        }

        public Criteria andMissionStateIdGreaterThan(Integer value) {
            addCriterion("mission_state_id >", value, "missionStateId");
            return (Criteria) this;
        }

        public Criteria andMissionStateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mission_state_id >=", value, "missionStateId");
            return (Criteria) this;
        }

        public Criteria andMissionStateIdLessThan(Integer value) {
            addCriterion("mission_state_id <", value, "missionStateId");
            return (Criteria) this;
        }

        public Criteria andMissionStateIdLessThanOrEqualTo(Integer value) {
            addCriterion("mission_state_id <=", value, "missionStateId");
            return (Criteria) this;
        }

        public Criteria andMissionStateIdIn(List<Integer> values) {
            addCriterion("mission_state_id in", values, "missionStateId");
            return (Criteria) this;
        }

        public Criteria andMissionStateIdNotIn(List<Integer> values) {
            addCriterion("mission_state_id not in", values, "missionStateId");
            return (Criteria) this;
        }

        public Criteria andMissionStateIdBetween(Integer value1, Integer value2) {
            addCriterion("mission_state_id between", value1, value2, "missionStateId");
            return (Criteria) this;
        }

        public Criteria andMissionStateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mission_state_id not between", value1, value2, "missionStateId");
            return (Criteria) this;
        }

        public Criteria andMissionIdIsNull() {
            addCriterion("mission_id is null");
            return (Criteria) this;
        }

        public Criteria andMissionIdIsNotNull() {
            addCriterion("mission_id is not null");
            return (Criteria) this;
        }

        public Criteria andMissionIdEqualTo(Integer value) {
            addCriterion("mission_id =", value, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdNotEqualTo(Integer value) {
            addCriterion("mission_id <>", value, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdGreaterThan(Integer value) {
            addCriterion("mission_id >", value, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mission_id >=", value, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdLessThan(Integer value) {
            addCriterion("mission_id <", value, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdLessThanOrEqualTo(Integer value) {
            addCriterion("mission_id <=", value, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdIn(List<Integer> values) {
            addCriterion("mission_id in", values, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdNotIn(List<Integer> values) {
            addCriterion("mission_id not in", values, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdBetween(Integer value1, Integer value2) {
            addCriterion("mission_id between", value1, value2, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mission_id not between", value1, value2, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionTimeIsNull() {
            addCriterion("mission_time is null");
            return (Criteria) this;
        }

        public Criteria andMissionTimeIsNotNull() {
            addCriterion("mission_time is not null");
            return (Criteria) this;
        }

        public Criteria andMissionTimeEqualTo(Date value) {
            addCriterion("mission_time =", value, "missionTime");
            return (Criteria) this;
        }

        public Criteria andMissionTimeNotEqualTo(Date value) {
            addCriterion("mission_time <>", value, "missionTime");
            return (Criteria) this;
        }

        public Criteria andMissionTimeGreaterThan(Date value) {
            addCriterion("mission_time >", value, "missionTime");
            return (Criteria) this;
        }

        public Criteria andMissionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("mission_time >=", value, "missionTime");
            return (Criteria) this;
        }

        public Criteria andMissionTimeLessThan(Date value) {
            addCriterion("mission_time <", value, "missionTime");
            return (Criteria) this;
        }

        public Criteria andMissionTimeLessThanOrEqualTo(Date value) {
            addCriterion("mission_time <=", value, "missionTime");
            return (Criteria) this;
        }

        public Criteria andMissionTimeIn(List<Date> values) {
            addCriterion("mission_time in", values, "missionTime");
            return (Criteria) this;
        }

        public Criteria andMissionTimeNotIn(List<Date> values) {
            addCriterion("mission_time not in", values, "missionTime");
            return (Criteria) this;
        }

        public Criteria andMissionTimeBetween(Date value1, Date value2) {
            addCriterion("mission_time between", value1, value2, "missionTime");
            return (Criteria) this;
        }

        public Criteria andMissionTimeNotBetween(Date value1, Date value2) {
            addCriterion("mission_time not between", value1, value2, "missionTime");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andMissionAllIdIsNull() {
            addCriterion("mission_all_id is null");
            return (Criteria) this;
        }

        public Criteria andMissionAllIdIsNotNull() {
            addCriterion("mission_all_id is not null");
            return (Criteria) this;
        }

        public Criteria andMissionAllIdEqualTo(Integer value) {
            addCriterion("mission_all_id =", value, "missionAllId");
            return (Criteria) this;
        }

        public Criteria andMissionAllIdNotEqualTo(Integer value) {
            addCriterion("mission_all_id <>", value, "missionAllId");
            return (Criteria) this;
        }

        public Criteria andMissionAllIdGreaterThan(Integer value) {
            addCriterion("mission_all_id >", value, "missionAllId");
            return (Criteria) this;
        }

        public Criteria andMissionAllIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mission_all_id >=", value, "missionAllId");
            return (Criteria) this;
        }

        public Criteria andMissionAllIdLessThan(Integer value) {
            addCriterion("mission_all_id <", value, "missionAllId");
            return (Criteria) this;
        }

        public Criteria andMissionAllIdLessThanOrEqualTo(Integer value) {
            addCriterion("mission_all_id <=", value, "missionAllId");
            return (Criteria) this;
        }

        public Criteria andMissionAllIdIn(List<Integer> values) {
            addCriterion("mission_all_id in", values, "missionAllId");
            return (Criteria) this;
        }

        public Criteria andMissionAllIdNotIn(List<Integer> values) {
            addCriterion("mission_all_id not in", values, "missionAllId");
            return (Criteria) this;
        }

        public Criteria andMissionAllIdBetween(Integer value1, Integer value2) {
            addCriterion("mission_all_id between", value1, value2, "missionAllId");
            return (Criteria) this;
        }

        public Criteria andMissionAllIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mission_all_id not between", value1, value2, "missionAllId");
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