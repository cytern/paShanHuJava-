package dam.jsoup.updatereport.updatreport.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JsoupMissionOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JsoupMissionOrderExample() {
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

        public Criteria andMissionOrderIdIsNull() {
            addCriterion("mission_order_id is null");
            return (Criteria) this;
        }

        public Criteria andMissionOrderIdIsNotNull() {
            addCriterion("mission_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andMissionOrderIdEqualTo(Integer value) {
            addCriterion("mission_order_id =", value, "missionOrderId");
            return (Criteria) this;
        }

        public Criteria andMissionOrderIdNotEqualTo(Integer value) {
            addCriterion("mission_order_id <>", value, "missionOrderId");
            return (Criteria) this;
        }

        public Criteria andMissionOrderIdGreaterThan(Integer value) {
            addCriterion("mission_order_id >", value, "missionOrderId");
            return (Criteria) this;
        }

        public Criteria andMissionOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mission_order_id >=", value, "missionOrderId");
            return (Criteria) this;
        }

        public Criteria andMissionOrderIdLessThan(Integer value) {
            addCriterion("mission_order_id <", value, "missionOrderId");
            return (Criteria) this;
        }

        public Criteria andMissionOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("mission_order_id <=", value, "missionOrderId");
            return (Criteria) this;
        }

        public Criteria andMissionOrderIdIn(List<Integer> values) {
            addCriterion("mission_order_id in", values, "missionOrderId");
            return (Criteria) this;
        }

        public Criteria andMissionOrderIdNotIn(List<Integer> values) {
            addCriterion("mission_order_id not in", values, "missionOrderId");
            return (Criteria) this;
        }

        public Criteria andMissionOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("mission_order_id between", value1, value2, "missionOrderId");
            return (Criteria) this;
        }

        public Criteria andMissionOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mission_order_id not between", value1, value2, "missionOrderId");
            return (Criteria) this;
        }

        public Criteria andMoMissionIdIsNull() {
            addCriterion("mo_mission_id is null");
            return (Criteria) this;
        }

        public Criteria andMoMissionIdIsNotNull() {
            addCriterion("mo_mission_id is not null");
            return (Criteria) this;
        }

        public Criteria andMoMissionIdEqualTo(Integer value) {
            addCriterion("mo_mission_id =", value, "moMissionId");
            return (Criteria) this;
        }

        public Criteria andMoMissionIdNotEqualTo(Integer value) {
            addCriterion("mo_mission_id <>", value, "moMissionId");
            return (Criteria) this;
        }

        public Criteria andMoMissionIdGreaterThan(Integer value) {
            addCriterion("mo_mission_id >", value, "moMissionId");
            return (Criteria) this;
        }

        public Criteria andMoMissionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mo_mission_id >=", value, "moMissionId");
            return (Criteria) this;
        }

        public Criteria andMoMissionIdLessThan(Integer value) {
            addCriterion("mo_mission_id <", value, "moMissionId");
            return (Criteria) this;
        }

        public Criteria andMoMissionIdLessThanOrEqualTo(Integer value) {
            addCriterion("mo_mission_id <=", value, "moMissionId");
            return (Criteria) this;
        }

        public Criteria andMoMissionIdIn(List<Integer> values) {
            addCriterion("mo_mission_id in", values, "moMissionId");
            return (Criteria) this;
        }

        public Criteria andMoMissionIdNotIn(List<Integer> values) {
            addCriterion("mo_mission_id not in", values, "moMissionId");
            return (Criteria) this;
        }

        public Criteria andMoMissionIdBetween(Integer value1, Integer value2) {
            addCriterion("mo_mission_id between", value1, value2, "moMissionId");
            return (Criteria) this;
        }

        public Criteria andMoMissionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mo_mission_id not between", value1, value2, "moMissionId");
            return (Criteria) this;
        }

        public Criteria andMoMissionAllIdIsNull() {
            addCriterion("mo_mission_all_id is null");
            return (Criteria) this;
        }

        public Criteria andMoMissionAllIdIsNotNull() {
            addCriterion("mo_mission_all_id is not null");
            return (Criteria) this;
        }

        public Criteria andMoMissionAllIdEqualTo(Integer value) {
            addCriterion("mo_mission_all_id =", value, "moMissionAllId");
            return (Criteria) this;
        }

        public Criteria andMoMissionAllIdNotEqualTo(Integer value) {
            addCriterion("mo_mission_all_id <>", value, "moMissionAllId");
            return (Criteria) this;
        }

        public Criteria andMoMissionAllIdGreaterThan(Integer value) {
            addCriterion("mo_mission_all_id >", value, "moMissionAllId");
            return (Criteria) this;
        }

        public Criteria andMoMissionAllIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mo_mission_all_id >=", value, "moMissionAllId");
            return (Criteria) this;
        }

        public Criteria andMoMissionAllIdLessThan(Integer value) {
            addCriterion("mo_mission_all_id <", value, "moMissionAllId");
            return (Criteria) this;
        }

        public Criteria andMoMissionAllIdLessThanOrEqualTo(Integer value) {
            addCriterion("mo_mission_all_id <=", value, "moMissionAllId");
            return (Criteria) this;
        }

        public Criteria andMoMissionAllIdIn(List<Integer> values) {
            addCriterion("mo_mission_all_id in", values, "moMissionAllId");
            return (Criteria) this;
        }

        public Criteria andMoMissionAllIdNotIn(List<Integer> values) {
            addCriterion("mo_mission_all_id not in", values, "moMissionAllId");
            return (Criteria) this;
        }

        public Criteria andMoMissionAllIdBetween(Integer value1, Integer value2) {
            addCriterion("mo_mission_all_id between", value1, value2, "moMissionAllId");
            return (Criteria) this;
        }

        public Criteria andMoMissionAllIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mo_mission_all_id not between", value1, value2, "moMissionAllId");
            return (Criteria) this;
        }

        public Criteria andMoAddTimeIsNull() {
            addCriterion("mo_add_time is null");
            return (Criteria) this;
        }

        public Criteria andMoAddTimeIsNotNull() {
            addCriterion("mo_add_time is not null");
            return (Criteria) this;
        }

        public Criteria andMoAddTimeEqualTo(Date value) {
            addCriterion("mo_add_time =", value, "moAddTime");
            return (Criteria) this;
        }

        public Criteria andMoAddTimeNotEqualTo(Date value) {
            addCriterion("mo_add_time <>", value, "moAddTime");
            return (Criteria) this;
        }

        public Criteria andMoAddTimeGreaterThan(Date value) {
            addCriterion("mo_add_time >", value, "moAddTime");
            return (Criteria) this;
        }

        public Criteria andMoAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("mo_add_time >=", value, "moAddTime");
            return (Criteria) this;
        }

        public Criteria andMoAddTimeLessThan(Date value) {
            addCriterion("mo_add_time <", value, "moAddTime");
            return (Criteria) this;
        }

        public Criteria andMoAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("mo_add_time <=", value, "moAddTime");
            return (Criteria) this;
        }

        public Criteria andMoAddTimeIn(List<Date> values) {
            addCriterion("mo_add_time in", values, "moAddTime");
            return (Criteria) this;
        }

        public Criteria andMoAddTimeNotIn(List<Date> values) {
            addCriterion("mo_add_time not in", values, "moAddTime");
            return (Criteria) this;
        }

        public Criteria andMoAddTimeBetween(Date value1, Date value2) {
            addCriterion("mo_add_time between", value1, value2, "moAddTime");
            return (Criteria) this;
        }

        public Criteria andMoAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("mo_add_time not between", value1, value2, "moAddTime");
            return (Criteria) this;
        }

        public Criteria andMoRankIsNull() {
            addCriterion("mo_rank is null");
            return (Criteria) this;
        }

        public Criteria andMoRankIsNotNull() {
            addCriterion("mo_rank is not null");
            return (Criteria) this;
        }

        public Criteria andMoRankEqualTo(Integer value) {
            addCriterion("mo_rank =", value, "moRank");
            return (Criteria) this;
        }

        public Criteria andMoRankNotEqualTo(Integer value) {
            addCriterion("mo_rank <>", value, "moRank");
            return (Criteria) this;
        }

        public Criteria andMoRankGreaterThan(Integer value) {
            addCriterion("mo_rank >", value, "moRank");
            return (Criteria) this;
        }

        public Criteria andMoRankGreaterThanOrEqualTo(Integer value) {
            addCriterion("mo_rank >=", value, "moRank");
            return (Criteria) this;
        }

        public Criteria andMoRankLessThan(Integer value) {
            addCriterion("mo_rank <", value, "moRank");
            return (Criteria) this;
        }

        public Criteria andMoRankLessThanOrEqualTo(Integer value) {
            addCriterion("mo_rank <=", value, "moRank");
            return (Criteria) this;
        }

        public Criteria andMoRankIn(List<Integer> values) {
            addCriterion("mo_rank in", values, "moRank");
            return (Criteria) this;
        }

        public Criteria andMoRankNotIn(List<Integer> values) {
            addCriterion("mo_rank not in", values, "moRank");
            return (Criteria) this;
        }

        public Criteria andMoRankBetween(Integer value1, Integer value2) {
            addCriterion("mo_rank between", value1, value2, "moRank");
            return (Criteria) this;
        }

        public Criteria andMoRankNotBetween(Integer value1, Integer value2) {
            addCriterion("mo_rank not between", value1, value2, "moRank");
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