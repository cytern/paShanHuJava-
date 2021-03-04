package dam.jsoup.updatereport.updatreport.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JsoupActionHisExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JsoupActionHisExample() {
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

        public Criteria andActionHisIdIsNull() {
            addCriterion("action_his_id is null");
            return (Criteria) this;
        }

        public Criteria andActionHisIdIsNotNull() {
            addCriterion("action_his_id is not null");
            return (Criteria) this;
        }

        public Criteria andActionHisIdEqualTo(Integer value) {
            addCriterion("action_his_id =", value, "actionHisId");
            return (Criteria) this;
        }

        public Criteria andActionHisIdNotEqualTo(Integer value) {
            addCriterion("action_his_id <>", value, "actionHisId");
            return (Criteria) this;
        }

        public Criteria andActionHisIdGreaterThan(Integer value) {
            addCriterion("action_his_id >", value, "actionHisId");
            return (Criteria) this;
        }

        public Criteria andActionHisIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("action_his_id >=", value, "actionHisId");
            return (Criteria) this;
        }

        public Criteria andActionHisIdLessThan(Integer value) {
            addCriterion("action_his_id <", value, "actionHisId");
            return (Criteria) this;
        }

        public Criteria andActionHisIdLessThanOrEqualTo(Integer value) {
            addCriterion("action_his_id <=", value, "actionHisId");
            return (Criteria) this;
        }

        public Criteria andActionHisIdIn(List<Integer> values) {
            addCriterion("action_his_id in", values, "actionHisId");
            return (Criteria) this;
        }

        public Criteria andActionHisIdNotIn(List<Integer> values) {
            addCriterion("action_his_id not in", values, "actionHisId");
            return (Criteria) this;
        }

        public Criteria andActionHisIdBetween(Integer value1, Integer value2) {
            addCriterion("action_his_id between", value1, value2, "actionHisId");
            return (Criteria) this;
        }

        public Criteria andActionHisIdNotBetween(Integer value1, Integer value2) {
            addCriterion("action_his_id not between", value1, value2, "actionHisId");
            return (Criteria) this;
        }

        public Criteria andActionHisEleValueIsNull() {
            addCriterion("action_his_ele_value is null");
            return (Criteria) this;
        }

        public Criteria andActionHisEleValueIsNotNull() {
            addCriterion("action_his_ele_value is not null");
            return (Criteria) this;
        }

        public Criteria andActionHisEleValueEqualTo(String value) {
            addCriterion("action_his_ele_value =", value, "actionHisEleValue");
            return (Criteria) this;
        }

        public Criteria andActionHisEleValueNotEqualTo(String value) {
            addCriterion("action_his_ele_value <>", value, "actionHisEleValue");
            return (Criteria) this;
        }

        public Criteria andActionHisEleValueGreaterThan(String value) {
            addCriterion("action_his_ele_value >", value, "actionHisEleValue");
            return (Criteria) this;
        }

        public Criteria andActionHisEleValueGreaterThanOrEqualTo(String value) {
            addCriterion("action_his_ele_value >=", value, "actionHisEleValue");
            return (Criteria) this;
        }

        public Criteria andActionHisEleValueLessThan(String value) {
            addCriterion("action_his_ele_value <", value, "actionHisEleValue");
            return (Criteria) this;
        }

        public Criteria andActionHisEleValueLessThanOrEqualTo(String value) {
            addCriterion("action_his_ele_value <=", value, "actionHisEleValue");
            return (Criteria) this;
        }

        public Criteria andActionHisEleValueLike(String value) {
            addCriterion("action_his_ele_value like", value, "actionHisEleValue");
            return (Criteria) this;
        }

        public Criteria andActionHisEleValueNotLike(String value) {
            addCriterion("action_his_ele_value not like", value, "actionHisEleValue");
            return (Criteria) this;
        }

        public Criteria andActionHisEleValueIn(List<String> values) {
            addCriterion("action_his_ele_value in", values, "actionHisEleValue");
            return (Criteria) this;
        }

        public Criteria andActionHisEleValueNotIn(List<String> values) {
            addCriterion("action_his_ele_value not in", values, "actionHisEleValue");
            return (Criteria) this;
        }

        public Criteria andActionHisEleValueBetween(String value1, String value2) {
            addCriterion("action_his_ele_value between", value1, value2, "actionHisEleValue");
            return (Criteria) this;
        }

        public Criteria andActionHisEleValueNotBetween(String value1, String value2) {
            addCriterion("action_his_ele_value not between", value1, value2, "actionHisEleValue");
            return (Criteria) this;
        }

        public Criteria andActionHisDateIsNull() {
            addCriterion("action_his_date is null");
            return (Criteria) this;
        }

        public Criteria andActionHisDateIsNotNull() {
            addCriterion("action_his_date is not null");
            return (Criteria) this;
        }

        public Criteria andActionHisDateEqualTo(Date value) {
            addCriterion("action_his_date =", value, "actionHisDate");
            return (Criteria) this;
        }

        public Criteria andActionHisDateNotEqualTo(Date value) {
            addCriterion("action_his_date <>", value, "actionHisDate");
            return (Criteria) this;
        }

        public Criteria andActionHisDateGreaterThan(Date value) {
            addCriterion("action_his_date >", value, "actionHisDate");
            return (Criteria) this;
        }

        public Criteria andActionHisDateGreaterThanOrEqualTo(Date value) {
            addCriterion("action_his_date >=", value, "actionHisDate");
            return (Criteria) this;
        }

        public Criteria andActionHisDateLessThan(Date value) {
            addCriterion("action_his_date <", value, "actionHisDate");
            return (Criteria) this;
        }

        public Criteria andActionHisDateLessThanOrEqualTo(Date value) {
            addCriterion("action_his_date <=", value, "actionHisDate");
            return (Criteria) this;
        }

        public Criteria andActionHisDateIn(List<Date> values) {
            addCriterion("action_his_date in", values, "actionHisDate");
            return (Criteria) this;
        }

        public Criteria andActionHisDateNotIn(List<Date> values) {
            addCriterion("action_his_date not in", values, "actionHisDate");
            return (Criteria) this;
        }

        public Criteria andActionHisDateBetween(Date value1, Date value2) {
            addCriterion("action_his_date between", value1, value2, "actionHisDate");
            return (Criteria) this;
        }

        public Criteria andActionHisDateNotBetween(Date value1, Date value2) {
            addCriterion("action_his_date not between", value1, value2, "actionHisDate");
            return (Criteria) this;
        }

        public Criteria andActionHisMissionIdIsNull() {
            addCriterion("action_his_mission_id is null");
            return (Criteria) this;
        }

        public Criteria andActionHisMissionIdIsNotNull() {
            addCriterion("action_his_mission_id is not null");
            return (Criteria) this;
        }

        public Criteria andActionHisMissionIdEqualTo(Integer value) {
            addCriterion("action_his_mission_id =", value, "actionHisMissionId");
            return (Criteria) this;
        }

        public Criteria andActionHisMissionIdNotEqualTo(Integer value) {
            addCriterion("action_his_mission_id <>", value, "actionHisMissionId");
            return (Criteria) this;
        }

        public Criteria andActionHisMissionIdGreaterThan(Integer value) {
            addCriterion("action_his_mission_id >", value, "actionHisMissionId");
            return (Criteria) this;
        }

        public Criteria andActionHisMissionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("action_his_mission_id >=", value, "actionHisMissionId");
            return (Criteria) this;
        }

        public Criteria andActionHisMissionIdLessThan(Integer value) {
            addCriterion("action_his_mission_id <", value, "actionHisMissionId");
            return (Criteria) this;
        }

        public Criteria andActionHisMissionIdLessThanOrEqualTo(Integer value) {
            addCriterion("action_his_mission_id <=", value, "actionHisMissionId");
            return (Criteria) this;
        }

        public Criteria andActionHisMissionIdIn(List<Integer> values) {
            addCriterion("action_his_mission_id in", values, "actionHisMissionId");
            return (Criteria) this;
        }

        public Criteria andActionHisMissionIdNotIn(List<Integer> values) {
            addCriterion("action_his_mission_id not in", values, "actionHisMissionId");
            return (Criteria) this;
        }

        public Criteria andActionHisMissionIdBetween(Integer value1, Integer value2) {
            addCriterion("action_his_mission_id between", value1, value2, "actionHisMissionId");
            return (Criteria) this;
        }

        public Criteria andActionHisMissionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("action_his_mission_id not between", value1, value2, "actionHisMissionId");
            return (Criteria) this;
        }

        public Criteria andActionHisActionIdIsNull() {
            addCriterion("action_his_action_id is null");
            return (Criteria) this;
        }

        public Criteria andActionHisActionIdIsNotNull() {
            addCriterion("action_his_action_id is not null");
            return (Criteria) this;
        }

        public Criteria andActionHisActionIdEqualTo(Integer value) {
            addCriterion("action_his_action_id =", value, "actionHisActionId");
            return (Criteria) this;
        }

        public Criteria andActionHisActionIdNotEqualTo(Integer value) {
            addCriterion("action_his_action_id <>", value, "actionHisActionId");
            return (Criteria) this;
        }

        public Criteria andActionHisActionIdGreaterThan(Integer value) {
            addCriterion("action_his_action_id >", value, "actionHisActionId");
            return (Criteria) this;
        }

        public Criteria andActionHisActionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("action_his_action_id >=", value, "actionHisActionId");
            return (Criteria) this;
        }

        public Criteria andActionHisActionIdLessThan(Integer value) {
            addCriterion("action_his_action_id <", value, "actionHisActionId");
            return (Criteria) this;
        }

        public Criteria andActionHisActionIdLessThanOrEqualTo(Integer value) {
            addCriterion("action_his_action_id <=", value, "actionHisActionId");
            return (Criteria) this;
        }

        public Criteria andActionHisActionIdIn(List<Integer> values) {
            addCriterion("action_his_action_id in", values, "actionHisActionId");
            return (Criteria) this;
        }

        public Criteria andActionHisActionIdNotIn(List<Integer> values) {
            addCriterion("action_his_action_id not in", values, "actionHisActionId");
            return (Criteria) this;
        }

        public Criteria andActionHisActionIdBetween(Integer value1, Integer value2) {
            addCriterion("action_his_action_id between", value1, value2, "actionHisActionId");
            return (Criteria) this;
        }

        public Criteria andActionHisActionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("action_his_action_id not between", value1, value2, "actionHisActionId");
            return (Criteria) this;
        }

        public Criteria andAhMaIdIsNull() {
            addCriterion("ah_ma_id is null");
            return (Criteria) this;
        }

        public Criteria andAhMaIdIsNotNull() {
            addCriterion("ah_ma_id is not null");
            return (Criteria) this;
        }

        public Criteria andAhMaIdEqualTo(Integer value) {
            addCriterion("ah_ma_id =", value, "ahMaId");
            return (Criteria) this;
        }

        public Criteria andAhMaIdNotEqualTo(Integer value) {
            addCriterion("ah_ma_id <>", value, "ahMaId");
            return (Criteria) this;
        }

        public Criteria andAhMaIdGreaterThan(Integer value) {
            addCriterion("ah_ma_id >", value, "ahMaId");
            return (Criteria) this;
        }

        public Criteria andAhMaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ah_ma_id >=", value, "ahMaId");
            return (Criteria) this;
        }

        public Criteria andAhMaIdLessThan(Integer value) {
            addCriterion("ah_ma_id <", value, "ahMaId");
            return (Criteria) this;
        }

        public Criteria andAhMaIdLessThanOrEqualTo(Integer value) {
            addCriterion("ah_ma_id <=", value, "ahMaId");
            return (Criteria) this;
        }

        public Criteria andAhMaIdIn(List<Integer> values) {
            addCriterion("ah_ma_id in", values, "ahMaId");
            return (Criteria) this;
        }

        public Criteria andAhMaIdNotIn(List<Integer> values) {
            addCriterion("ah_ma_id not in", values, "ahMaId");
            return (Criteria) this;
        }

        public Criteria andAhMaIdBetween(Integer value1, Integer value2) {
            addCriterion("ah_ma_id between", value1, value2, "ahMaId");
            return (Criteria) this;
        }

        public Criteria andAhMaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ah_ma_id not between", value1, value2, "ahMaId");
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