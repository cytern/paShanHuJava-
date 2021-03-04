package dam.jsoup.updatereport.updatreport.pojo;

import java.util.ArrayList;
import java.util.List;

public class SettingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SettingExample() {
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

        public Criteria andSettingIdIsNull() {
            addCriterion("setting_id is null");
            return (Criteria) this;
        }

        public Criteria andSettingIdIsNotNull() {
            addCriterion("setting_id is not null");
            return (Criteria) this;
        }

        public Criteria andSettingIdEqualTo(Integer value) {
            addCriterion("setting_id =", value, "settingId");
            return (Criteria) this;
        }

        public Criteria andSettingIdNotEqualTo(Integer value) {
            addCriterion("setting_id <>", value, "settingId");
            return (Criteria) this;
        }

        public Criteria andSettingIdGreaterThan(Integer value) {
            addCriterion("setting_id >", value, "settingId");
            return (Criteria) this;
        }

        public Criteria andSettingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("setting_id >=", value, "settingId");
            return (Criteria) this;
        }

        public Criteria andSettingIdLessThan(Integer value) {
            addCriterion("setting_id <", value, "settingId");
            return (Criteria) this;
        }

        public Criteria andSettingIdLessThanOrEqualTo(Integer value) {
            addCriterion("setting_id <=", value, "settingId");
            return (Criteria) this;
        }

        public Criteria andSettingIdIn(List<Integer> values) {
            addCriterion("setting_id in", values, "settingId");
            return (Criteria) this;
        }

        public Criteria andSettingIdNotIn(List<Integer> values) {
            addCriterion("setting_id not in", values, "settingId");
            return (Criteria) this;
        }

        public Criteria andSettingIdBetween(Integer value1, Integer value2) {
            addCriterion("setting_id between", value1, value2, "settingId");
            return (Criteria) this;
        }

        public Criteria andSettingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("setting_id not between", value1, value2, "settingId");
            return (Criteria) this;
        }

        public Criteria andSettingValueIsNull() {
            addCriterion("setting_value is null");
            return (Criteria) this;
        }

        public Criteria andSettingValueIsNotNull() {
            addCriterion("setting_value is not null");
            return (Criteria) this;
        }

        public Criteria andSettingValueEqualTo(String value) {
            addCriterion("setting_value =", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueNotEqualTo(String value) {
            addCriterion("setting_value <>", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueGreaterThan(String value) {
            addCriterion("setting_value >", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueGreaterThanOrEqualTo(String value) {
            addCriterion("setting_value >=", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueLessThan(String value) {
            addCriterion("setting_value <", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueLessThanOrEqualTo(String value) {
            addCriterion("setting_value <=", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueLike(String value) {
            addCriterion("setting_value like", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueNotLike(String value) {
            addCriterion("setting_value not like", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueIn(List<String> values) {
            addCriterion("setting_value in", values, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueNotIn(List<String> values) {
            addCriterion("setting_value not in", values, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueBetween(String value1, String value2) {
            addCriterion("setting_value between", value1, value2, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueNotBetween(String value1, String value2) {
            addCriterion("setting_value not between", value1, value2, "settingValue");
            return (Criteria) this;
        }

        public Criteria andBiosIdIsNull() {
            addCriterion("bios_id is null");
            return (Criteria) this;
        }

        public Criteria andBiosIdIsNotNull() {
            addCriterion("bios_id is not null");
            return (Criteria) this;
        }

        public Criteria andBiosIdEqualTo(String value) {
            addCriterion("bios_id =", value, "biosId");
            return (Criteria) this;
        }

        public Criteria andBiosIdNotEqualTo(String value) {
            addCriterion("bios_id <>", value, "biosId");
            return (Criteria) this;
        }

        public Criteria andBiosIdGreaterThan(String value) {
            addCriterion("bios_id >", value, "biosId");
            return (Criteria) this;
        }

        public Criteria andBiosIdGreaterThanOrEqualTo(String value) {
            addCriterion("bios_id >=", value, "biosId");
            return (Criteria) this;
        }

        public Criteria andBiosIdLessThan(String value) {
            addCriterion("bios_id <", value, "biosId");
            return (Criteria) this;
        }

        public Criteria andBiosIdLessThanOrEqualTo(String value) {
            addCriterion("bios_id <=", value, "biosId");
            return (Criteria) this;
        }

        public Criteria andBiosIdLike(String value) {
            addCriterion("bios_id like", value, "biosId");
            return (Criteria) this;
        }

        public Criteria andBiosIdNotLike(String value) {
            addCriterion("bios_id not like", value, "biosId");
            return (Criteria) this;
        }

        public Criteria andBiosIdIn(List<String> values) {
            addCriterion("bios_id in", values, "biosId");
            return (Criteria) this;
        }

        public Criteria andBiosIdNotIn(List<String> values) {
            addCriterion("bios_id not in", values, "biosId");
            return (Criteria) this;
        }

        public Criteria andBiosIdBetween(String value1, String value2) {
            addCriterion("bios_id between", value1, value2, "biosId");
            return (Criteria) this;
        }

        public Criteria andBiosIdNotBetween(String value1, String value2) {
            addCriterion("bios_id not between", value1, value2, "biosId");
            return (Criteria) this;
        }

        public Criteria andSettingTypeIsNull() {
            addCriterion("setting_type is null");
            return (Criteria) this;
        }

        public Criteria andSettingTypeIsNotNull() {
            addCriterion("setting_type is not null");
            return (Criteria) this;
        }

        public Criteria andSettingTypeEqualTo(String value) {
            addCriterion("setting_type =", value, "settingType");
            return (Criteria) this;
        }

        public Criteria andSettingTypeNotEqualTo(String value) {
            addCriterion("setting_type <>", value, "settingType");
            return (Criteria) this;
        }

        public Criteria andSettingTypeGreaterThan(String value) {
            addCriterion("setting_type >", value, "settingType");
            return (Criteria) this;
        }

        public Criteria andSettingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("setting_type >=", value, "settingType");
            return (Criteria) this;
        }

        public Criteria andSettingTypeLessThan(String value) {
            addCriterion("setting_type <", value, "settingType");
            return (Criteria) this;
        }

        public Criteria andSettingTypeLessThanOrEqualTo(String value) {
            addCriterion("setting_type <=", value, "settingType");
            return (Criteria) this;
        }

        public Criteria andSettingTypeLike(String value) {
            addCriterion("setting_type like", value, "settingType");
            return (Criteria) this;
        }

        public Criteria andSettingTypeNotLike(String value) {
            addCriterion("setting_type not like", value, "settingType");
            return (Criteria) this;
        }

        public Criteria andSettingTypeIn(List<String> values) {
            addCriterion("setting_type in", values, "settingType");
            return (Criteria) this;
        }

        public Criteria andSettingTypeNotIn(List<String> values) {
            addCriterion("setting_type not in", values, "settingType");
            return (Criteria) this;
        }

        public Criteria andSettingTypeBetween(String value1, String value2) {
            addCriterion("setting_type between", value1, value2, "settingType");
            return (Criteria) this;
        }

        public Criteria andSettingTypeNotBetween(String value1, String value2) {
            addCriterion("setting_type not between", value1, value2, "settingType");
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