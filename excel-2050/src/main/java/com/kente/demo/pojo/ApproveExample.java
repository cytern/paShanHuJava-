package com.kente.demo.pojo;

import java.util.ArrayList;
import java.util.List;

public class ApproveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApproveExample() {
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

        public Criteria andKenteIdIsNull() {
            addCriterion("kente_id is null");
            return (Criteria) this;
        }

        public Criteria andKenteIdIsNotNull() {
            addCriterion("kente_id is not null");
            return (Criteria) this;
        }

        public Criteria andKenteIdEqualTo(Integer value) {
            addCriterion("kente_id =", value, "kenteId");
            return (Criteria) this;
        }

        public Criteria andKenteIdNotEqualTo(Integer value) {
            addCriterion("kente_id <>", value, "kenteId");
            return (Criteria) this;
        }

        public Criteria andKenteIdGreaterThan(Integer value) {
            addCriterion("kente_id >", value, "kenteId");
            return (Criteria) this;
        }

        public Criteria andKenteIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("kente_id >=", value, "kenteId");
            return (Criteria) this;
        }

        public Criteria andKenteIdLessThan(Integer value) {
            addCriterion("kente_id <", value, "kenteId");
            return (Criteria) this;
        }

        public Criteria andKenteIdLessThanOrEqualTo(Integer value) {
            addCriterion("kente_id <=", value, "kenteId");
            return (Criteria) this;
        }

        public Criteria andKenteIdIn(List<Integer> values) {
            addCriterion("kente_id in", values, "kenteId");
            return (Criteria) this;
        }

        public Criteria andKenteIdNotIn(List<Integer> values) {
            addCriterion("kente_id not in", values, "kenteId");
            return (Criteria) this;
        }

        public Criteria andKenteIdBetween(Integer value1, Integer value2) {
            addCriterion("kente_id between", value1, value2, "kenteId");
            return (Criteria) this;
        }

        public Criteria andKenteIdNotBetween(Integer value1, Integer value2) {
            addCriterion("kente_id not between", value1, value2, "kenteId");
            return (Criteria) this;
        }

        public Criteria andApproveOneIsNull() {
            addCriterion("approve_one is null");
            return (Criteria) this;
        }

        public Criteria andApproveOneIsNotNull() {
            addCriterion("approve_one is not null");
            return (Criteria) this;
        }

        public Criteria andApproveOneEqualTo(String value) {
            addCriterion("approve_one =", value, "approveOne");
            return (Criteria) this;
        }

        public Criteria andApproveOneNotEqualTo(String value) {
            addCriterion("approve_one <>", value, "approveOne");
            return (Criteria) this;
        }

        public Criteria andApproveOneGreaterThan(String value) {
            addCriterion("approve_one >", value, "approveOne");
            return (Criteria) this;
        }

        public Criteria andApproveOneGreaterThanOrEqualTo(String value) {
            addCriterion("approve_one >=", value, "approveOne");
            return (Criteria) this;
        }

        public Criteria andApproveOneLessThan(String value) {
            addCriterion("approve_one <", value, "approveOne");
            return (Criteria) this;
        }

        public Criteria andApproveOneLessThanOrEqualTo(String value) {
            addCriterion("approve_one <=", value, "approveOne");
            return (Criteria) this;
        }

        public Criteria andApproveOneLike(String value) {
            addCriterion("approve_one like", value, "approveOne");
            return (Criteria) this;
        }

        public Criteria andApproveOneNotLike(String value) {
            addCriterion("approve_one not like", value, "approveOne");
            return (Criteria) this;
        }

        public Criteria andApproveOneIn(List<String> values) {
            addCriterion("approve_one in", values, "approveOne");
            return (Criteria) this;
        }

        public Criteria andApproveOneNotIn(List<String> values) {
            addCriterion("approve_one not in", values, "approveOne");
            return (Criteria) this;
        }

        public Criteria andApproveOneBetween(String value1, String value2) {
            addCriterion("approve_one between", value1, value2, "approveOne");
            return (Criteria) this;
        }

        public Criteria andApproveOneNotBetween(String value1, String value2) {
            addCriterion("approve_one not between", value1, value2, "approveOne");
            return (Criteria) this;
        }

        public Criteria andApproveTwoIsNull() {
            addCriterion("approve_two is null");
            return (Criteria) this;
        }

        public Criteria andApproveTwoIsNotNull() {
            addCriterion("approve_two is not null");
            return (Criteria) this;
        }

        public Criteria andApproveTwoEqualTo(String value) {
            addCriterion("approve_two =", value, "approveTwo");
            return (Criteria) this;
        }

        public Criteria andApproveTwoNotEqualTo(String value) {
            addCriterion("approve_two <>", value, "approveTwo");
            return (Criteria) this;
        }

        public Criteria andApproveTwoGreaterThan(String value) {
            addCriterion("approve_two >", value, "approveTwo");
            return (Criteria) this;
        }

        public Criteria andApproveTwoGreaterThanOrEqualTo(String value) {
            addCriterion("approve_two >=", value, "approveTwo");
            return (Criteria) this;
        }

        public Criteria andApproveTwoLessThan(String value) {
            addCriterion("approve_two <", value, "approveTwo");
            return (Criteria) this;
        }

        public Criteria andApproveTwoLessThanOrEqualTo(String value) {
            addCriterion("approve_two <=", value, "approveTwo");
            return (Criteria) this;
        }

        public Criteria andApproveTwoLike(String value) {
            addCriterion("approve_two like", value, "approveTwo");
            return (Criteria) this;
        }

        public Criteria andApproveTwoNotLike(String value) {
            addCriterion("approve_two not like", value, "approveTwo");
            return (Criteria) this;
        }

        public Criteria andApproveTwoIn(List<String> values) {
            addCriterion("approve_two in", values, "approveTwo");
            return (Criteria) this;
        }

        public Criteria andApproveTwoNotIn(List<String> values) {
            addCriterion("approve_two not in", values, "approveTwo");
            return (Criteria) this;
        }

        public Criteria andApproveTwoBetween(String value1, String value2) {
            addCriterion("approve_two between", value1, value2, "approveTwo");
            return (Criteria) this;
        }

        public Criteria andApproveTwoNotBetween(String value1, String value2) {
            addCriterion("approve_two not between", value1, value2, "approveTwo");
            return (Criteria) this;
        }

        public Criteria andApproveThreeIsNull() {
            addCriterion("approve_three is null");
            return (Criteria) this;
        }

        public Criteria andApproveThreeIsNotNull() {
            addCriterion("approve_three is not null");
            return (Criteria) this;
        }

        public Criteria andApproveThreeEqualTo(String value) {
            addCriterion("approve_three =", value, "approveThree");
            return (Criteria) this;
        }

        public Criteria andApproveThreeNotEqualTo(String value) {
            addCriterion("approve_three <>", value, "approveThree");
            return (Criteria) this;
        }

        public Criteria andApproveThreeGreaterThan(String value) {
            addCriterion("approve_three >", value, "approveThree");
            return (Criteria) this;
        }

        public Criteria andApproveThreeGreaterThanOrEqualTo(String value) {
            addCriterion("approve_three >=", value, "approveThree");
            return (Criteria) this;
        }

        public Criteria andApproveThreeLessThan(String value) {
            addCriterion("approve_three <", value, "approveThree");
            return (Criteria) this;
        }

        public Criteria andApproveThreeLessThanOrEqualTo(String value) {
            addCriterion("approve_three <=", value, "approveThree");
            return (Criteria) this;
        }

        public Criteria andApproveThreeLike(String value) {
            addCriterion("approve_three like", value, "approveThree");
            return (Criteria) this;
        }

        public Criteria andApproveThreeNotLike(String value) {
            addCriterion("approve_three not like", value, "approveThree");
            return (Criteria) this;
        }

        public Criteria andApproveThreeIn(List<String> values) {
            addCriterion("approve_three in", values, "approveThree");
            return (Criteria) this;
        }

        public Criteria andApproveThreeNotIn(List<String> values) {
            addCriterion("approve_three not in", values, "approveThree");
            return (Criteria) this;
        }

        public Criteria andApproveThreeBetween(String value1, String value2) {
            addCriterion("approve_three between", value1, value2, "approveThree");
            return (Criteria) this;
        }

        public Criteria andApproveThreeNotBetween(String value1, String value2) {
            addCriterion("approve_three not between", value1, value2, "approveThree");
            return (Criteria) this;
        }

        public Criteria andApproveFourIsNull() {
            addCriterion("approve_four is null");
            return (Criteria) this;
        }

        public Criteria andApproveFourIsNotNull() {
            addCriterion("approve_four is not null");
            return (Criteria) this;
        }

        public Criteria andApproveFourEqualTo(String value) {
            addCriterion("approve_four =", value, "approveFour");
            return (Criteria) this;
        }

        public Criteria andApproveFourNotEqualTo(String value) {
            addCriterion("approve_four <>", value, "approveFour");
            return (Criteria) this;
        }

        public Criteria andApproveFourGreaterThan(String value) {
            addCriterion("approve_four >", value, "approveFour");
            return (Criteria) this;
        }

        public Criteria andApproveFourGreaterThanOrEqualTo(String value) {
            addCriterion("approve_four >=", value, "approveFour");
            return (Criteria) this;
        }

        public Criteria andApproveFourLessThan(String value) {
            addCriterion("approve_four <", value, "approveFour");
            return (Criteria) this;
        }

        public Criteria andApproveFourLessThanOrEqualTo(String value) {
            addCriterion("approve_four <=", value, "approveFour");
            return (Criteria) this;
        }

        public Criteria andApproveFourLike(String value) {
            addCriterion("approve_four like", value, "approveFour");
            return (Criteria) this;
        }

        public Criteria andApproveFourNotLike(String value) {
            addCriterion("approve_four not like", value, "approveFour");
            return (Criteria) this;
        }

        public Criteria andApproveFourIn(List<String> values) {
            addCriterion("approve_four in", values, "approveFour");
            return (Criteria) this;
        }

        public Criteria andApproveFourNotIn(List<String> values) {
            addCriterion("approve_four not in", values, "approveFour");
            return (Criteria) this;
        }

        public Criteria andApproveFourBetween(String value1, String value2) {
            addCriterion("approve_four between", value1, value2, "approveFour");
            return (Criteria) this;
        }

        public Criteria andApproveFourNotBetween(String value1, String value2) {
            addCriterion("approve_four not between", value1, value2, "approveFour");
            return (Criteria) this;
        }

        public Criteria andApproveFiveIsNull() {
            addCriterion("approve_five is null");
            return (Criteria) this;
        }

        public Criteria andApproveFiveIsNotNull() {
            addCriterion("approve_five is not null");
            return (Criteria) this;
        }

        public Criteria andApproveFiveEqualTo(String value) {
            addCriterion("approve_five =", value, "approveFive");
            return (Criteria) this;
        }

        public Criteria andApproveFiveNotEqualTo(String value) {
            addCriterion("approve_five <>", value, "approveFive");
            return (Criteria) this;
        }

        public Criteria andApproveFiveGreaterThan(String value) {
            addCriterion("approve_five >", value, "approveFive");
            return (Criteria) this;
        }

        public Criteria andApproveFiveGreaterThanOrEqualTo(String value) {
            addCriterion("approve_five >=", value, "approveFive");
            return (Criteria) this;
        }

        public Criteria andApproveFiveLessThan(String value) {
            addCriterion("approve_five <", value, "approveFive");
            return (Criteria) this;
        }

        public Criteria andApproveFiveLessThanOrEqualTo(String value) {
            addCriterion("approve_five <=", value, "approveFive");
            return (Criteria) this;
        }

        public Criteria andApproveFiveLike(String value) {
            addCriterion("approve_five like", value, "approveFive");
            return (Criteria) this;
        }

        public Criteria andApproveFiveNotLike(String value) {
            addCriterion("approve_five not like", value, "approveFive");
            return (Criteria) this;
        }

        public Criteria andApproveFiveIn(List<String> values) {
            addCriterion("approve_five in", values, "approveFive");
            return (Criteria) this;
        }

        public Criteria andApproveFiveNotIn(List<String> values) {
            addCriterion("approve_five not in", values, "approveFive");
            return (Criteria) this;
        }

        public Criteria andApproveFiveBetween(String value1, String value2) {
            addCriterion("approve_five between", value1, value2, "approveFive");
            return (Criteria) this;
        }

        public Criteria andApproveFiveNotBetween(String value1, String value2) {
            addCriterion("approve_five not between", value1, value2, "approveFive");
            return (Criteria) this;
        }

        public Criteria andApproveSixIsNull() {
            addCriterion("approve_six is null");
            return (Criteria) this;
        }

        public Criteria andApproveSixIsNotNull() {
            addCriterion("approve_six is not null");
            return (Criteria) this;
        }

        public Criteria andApproveSixEqualTo(String value) {
            addCriterion("approve_six =", value, "approveSix");
            return (Criteria) this;
        }

        public Criteria andApproveSixNotEqualTo(String value) {
            addCriterion("approve_six <>", value, "approveSix");
            return (Criteria) this;
        }

        public Criteria andApproveSixGreaterThan(String value) {
            addCriterion("approve_six >", value, "approveSix");
            return (Criteria) this;
        }

        public Criteria andApproveSixGreaterThanOrEqualTo(String value) {
            addCriterion("approve_six >=", value, "approveSix");
            return (Criteria) this;
        }

        public Criteria andApproveSixLessThan(String value) {
            addCriterion("approve_six <", value, "approveSix");
            return (Criteria) this;
        }

        public Criteria andApproveSixLessThanOrEqualTo(String value) {
            addCriterion("approve_six <=", value, "approveSix");
            return (Criteria) this;
        }

        public Criteria andApproveSixLike(String value) {
            addCriterion("approve_six like", value, "approveSix");
            return (Criteria) this;
        }

        public Criteria andApproveSixNotLike(String value) {
            addCriterion("approve_six not like", value, "approveSix");
            return (Criteria) this;
        }

        public Criteria andApproveSixIn(List<String> values) {
            addCriterion("approve_six in", values, "approveSix");
            return (Criteria) this;
        }

        public Criteria andApproveSixNotIn(List<String> values) {
            addCriterion("approve_six not in", values, "approveSix");
            return (Criteria) this;
        }

        public Criteria andApproveSixBetween(String value1, String value2) {
            addCriterion("approve_six between", value1, value2, "approveSix");
            return (Criteria) this;
        }

        public Criteria andApproveSixNotBetween(String value1, String value2) {
            addCriterion("approve_six not between", value1, value2, "approveSix");
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