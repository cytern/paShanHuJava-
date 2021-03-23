package dam.jsoup.updatereport.updatreport.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JsoupUserAssetsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JsoupUserAssetsExample() {
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

        public Criteria andUserAssetsIdIsNull() {
            addCriterion("user_assets_id is null");
            return (Criteria) this;
        }

        public Criteria andUserAssetsIdIsNotNull() {
            addCriterion("user_assets_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserAssetsIdEqualTo(Integer value) {
            addCriterion("user_assets_id =", value, "userAssetsId");
            return (Criteria) this;
        }

        public Criteria andUserAssetsIdNotEqualTo(Integer value) {
            addCriterion("user_assets_id <>", value, "userAssetsId");
            return (Criteria) this;
        }

        public Criteria andUserAssetsIdGreaterThan(Integer value) {
            addCriterion("user_assets_id >", value, "userAssetsId");
            return (Criteria) this;
        }

        public Criteria andUserAssetsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_assets_id >=", value, "userAssetsId");
            return (Criteria) this;
        }

        public Criteria andUserAssetsIdLessThan(Integer value) {
            addCriterion("user_assets_id <", value, "userAssetsId");
            return (Criteria) this;
        }

        public Criteria andUserAssetsIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_assets_id <=", value, "userAssetsId");
            return (Criteria) this;
        }

        public Criteria andUserAssetsIdIn(List<Integer> values) {
            addCriterion("user_assets_id in", values, "userAssetsId");
            return (Criteria) this;
        }

        public Criteria andUserAssetsIdNotIn(List<Integer> values) {
            addCriterion("user_assets_id not in", values, "userAssetsId");
            return (Criteria) this;
        }

        public Criteria andUserAssetsIdBetween(Integer value1, Integer value2) {
            addCriterion("user_assets_id between", value1, value2, "userAssetsId");
            return (Criteria) this;
        }

        public Criteria andUserAssetsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_assets_id not between", value1, value2, "userAssetsId");
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

        public Criteria andCornNumIsNull() {
            addCriterion("corn_num is null");
            return (Criteria) this;
        }

        public Criteria andCornNumIsNotNull() {
            addCriterion("corn_num is not null");
            return (Criteria) this;
        }

        public Criteria andCornNumEqualTo(BigDecimal value) {
            addCriterion("corn_num =", value, "cornNum");
            return (Criteria) this;
        }

        public Criteria andCornNumNotEqualTo(BigDecimal value) {
            addCriterion("corn_num <>", value, "cornNum");
            return (Criteria) this;
        }

        public Criteria andCornNumGreaterThan(BigDecimal value) {
            addCriterion("corn_num >", value, "cornNum");
            return (Criteria) this;
        }

        public Criteria andCornNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("corn_num >=", value, "cornNum");
            return (Criteria) this;
        }

        public Criteria andCornNumLessThan(BigDecimal value) {
            addCriterion("corn_num <", value, "cornNum");
            return (Criteria) this;
        }

        public Criteria andCornNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("corn_num <=", value, "cornNum");
            return (Criteria) this;
        }

        public Criteria andCornNumIn(List<BigDecimal> values) {
            addCriterion("corn_num in", values, "cornNum");
            return (Criteria) this;
        }

        public Criteria andCornNumNotIn(List<BigDecimal> values) {
            addCriterion("corn_num not in", values, "cornNum");
            return (Criteria) this;
        }

        public Criteria andCornNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("corn_num between", value1, value2, "cornNum");
            return (Criteria) this;
        }

        public Criteria andCornNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("corn_num not between", value1, value2, "cornNum");
            return (Criteria) this;
        }

        public Criteria andGoldNumIsNull() {
            addCriterion("gold_num is null");
            return (Criteria) this;
        }

        public Criteria andGoldNumIsNotNull() {
            addCriterion("gold_num is not null");
            return (Criteria) this;
        }

        public Criteria andGoldNumEqualTo(BigDecimal value) {
            addCriterion("gold_num =", value, "goldNum");
            return (Criteria) this;
        }

        public Criteria andGoldNumNotEqualTo(BigDecimal value) {
            addCriterion("gold_num <>", value, "goldNum");
            return (Criteria) this;
        }

        public Criteria andGoldNumGreaterThan(BigDecimal value) {
            addCriterion("gold_num >", value, "goldNum");
            return (Criteria) this;
        }

        public Criteria andGoldNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gold_num >=", value, "goldNum");
            return (Criteria) this;
        }

        public Criteria andGoldNumLessThan(BigDecimal value) {
            addCriterion("gold_num <", value, "goldNum");
            return (Criteria) this;
        }

        public Criteria andGoldNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gold_num <=", value, "goldNum");
            return (Criteria) this;
        }

        public Criteria andGoldNumIn(List<BigDecimal> values) {
            addCriterion("gold_num in", values, "goldNum");
            return (Criteria) this;
        }

        public Criteria andGoldNumNotIn(List<BigDecimal> values) {
            addCriterion("gold_num not in", values, "goldNum");
            return (Criteria) this;
        }

        public Criteria andGoldNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gold_num between", value1, value2, "goldNum");
            return (Criteria) this;
        }

        public Criteria andGoldNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gold_num not between", value1, value2, "goldNum");
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