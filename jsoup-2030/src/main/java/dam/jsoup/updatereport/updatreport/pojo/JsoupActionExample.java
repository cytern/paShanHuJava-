package dam.jsoup.updatereport.updatreport.pojo;

import java.util.ArrayList;
import java.util.List;

public class JsoupActionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JsoupActionExample() {
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

        public Criteria andActionIdIsNull() {
            addCriterion("action_id is null");
            return (Criteria) this;
        }

        public Criteria andActionIdIsNotNull() {
            addCriterion("action_id is not null");
            return (Criteria) this;
        }

        public Criteria andActionIdEqualTo(Integer value) {
            addCriterion("action_id =", value, "actionId");
            return (Criteria) this;
        }

        public Criteria andActionIdNotEqualTo(Integer value) {
            addCriterion("action_id <>", value, "actionId");
            return (Criteria) this;
        }

        public Criteria andActionIdGreaterThan(Integer value) {
            addCriterion("action_id >", value, "actionId");
            return (Criteria) this;
        }

        public Criteria andActionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("action_id >=", value, "actionId");
            return (Criteria) this;
        }

        public Criteria andActionIdLessThan(Integer value) {
            addCriterion("action_id <", value, "actionId");
            return (Criteria) this;
        }

        public Criteria andActionIdLessThanOrEqualTo(Integer value) {
            addCriterion("action_id <=", value, "actionId");
            return (Criteria) this;
        }

        public Criteria andActionIdIn(List<Integer> values) {
            addCriterion("action_id in", values, "actionId");
            return (Criteria) this;
        }

        public Criteria andActionIdNotIn(List<Integer> values) {
            addCriterion("action_id not in", values, "actionId");
            return (Criteria) this;
        }

        public Criteria andActionIdBetween(Integer value1, Integer value2) {
            addCriterion("action_id between", value1, value2, "actionId");
            return (Criteria) this;
        }

        public Criteria andActionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("action_id not between", value1, value2, "actionId");
            return (Criteria) this;
        }

        public Criteria andActionEleTypeIsNull() {
            addCriterion("action_ele_type is null");
            return (Criteria) this;
        }

        public Criteria andActionEleTypeIsNotNull() {
            addCriterion("action_ele_type is not null");
            return (Criteria) this;
        }

        public Criteria andActionEleTypeEqualTo(String value) {
            addCriterion("action_ele_type =", value, "actionEleType");
            return (Criteria) this;
        }

        public Criteria andActionEleTypeNotEqualTo(String value) {
            addCriterion("action_ele_type <>", value, "actionEleType");
            return (Criteria) this;
        }

        public Criteria andActionEleTypeGreaterThan(String value) {
            addCriterion("action_ele_type >", value, "actionEleType");
            return (Criteria) this;
        }

        public Criteria andActionEleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("action_ele_type >=", value, "actionEleType");
            return (Criteria) this;
        }

        public Criteria andActionEleTypeLessThan(String value) {
            addCriterion("action_ele_type <", value, "actionEleType");
            return (Criteria) this;
        }

        public Criteria andActionEleTypeLessThanOrEqualTo(String value) {
            addCriterion("action_ele_type <=", value, "actionEleType");
            return (Criteria) this;
        }

        public Criteria andActionEleTypeLike(String value) {
            addCriterion("action_ele_type like", value, "actionEleType");
            return (Criteria) this;
        }

        public Criteria andActionEleTypeNotLike(String value) {
            addCriterion("action_ele_type not like", value, "actionEleType");
            return (Criteria) this;
        }

        public Criteria andActionEleTypeIn(List<String> values) {
            addCriterion("action_ele_type in", values, "actionEleType");
            return (Criteria) this;
        }

        public Criteria andActionEleTypeNotIn(List<String> values) {
            addCriterion("action_ele_type not in", values, "actionEleType");
            return (Criteria) this;
        }

        public Criteria andActionEleTypeBetween(String value1, String value2) {
            addCriterion("action_ele_type between", value1, value2, "actionEleType");
            return (Criteria) this;
        }

        public Criteria andActionEleTypeNotBetween(String value1, String value2) {
            addCriterion("action_ele_type not between", value1, value2, "actionEleType");
            return (Criteria) this;
        }

        public Criteria andActionDoTypeIsNull() {
            addCriterion("action_do_type is null");
            return (Criteria) this;
        }

        public Criteria andActionDoTypeIsNotNull() {
            addCriterion("action_do_type is not null");
            return (Criteria) this;
        }

        public Criteria andActionDoTypeEqualTo(String value) {
            addCriterion("action_do_type =", value, "actionDoType");
            return (Criteria) this;
        }

        public Criteria andActionDoTypeNotEqualTo(String value) {
            addCriterion("action_do_type <>", value, "actionDoType");
            return (Criteria) this;
        }

        public Criteria andActionDoTypeGreaterThan(String value) {
            addCriterion("action_do_type >", value, "actionDoType");
            return (Criteria) this;
        }

        public Criteria andActionDoTypeGreaterThanOrEqualTo(String value) {
            addCriterion("action_do_type >=", value, "actionDoType");
            return (Criteria) this;
        }

        public Criteria andActionDoTypeLessThan(String value) {
            addCriterion("action_do_type <", value, "actionDoType");
            return (Criteria) this;
        }

        public Criteria andActionDoTypeLessThanOrEqualTo(String value) {
            addCriterion("action_do_type <=", value, "actionDoType");
            return (Criteria) this;
        }

        public Criteria andActionDoTypeLike(String value) {
            addCriterion("action_do_type like", value, "actionDoType");
            return (Criteria) this;
        }

        public Criteria andActionDoTypeNotLike(String value) {
            addCriterion("action_do_type not like", value, "actionDoType");
            return (Criteria) this;
        }

        public Criteria andActionDoTypeIn(List<String> values) {
            addCriterion("action_do_type in", values, "actionDoType");
            return (Criteria) this;
        }

        public Criteria andActionDoTypeNotIn(List<String> values) {
            addCriterion("action_do_type not in", values, "actionDoType");
            return (Criteria) this;
        }

        public Criteria andActionDoTypeBetween(String value1, String value2) {
            addCriterion("action_do_type between", value1, value2, "actionDoType");
            return (Criteria) this;
        }

        public Criteria andActionDoTypeNotBetween(String value1, String value2) {
            addCriterion("action_do_type not between", value1, value2, "actionDoType");
            return (Criteria) this;
        }

        public Criteria andActionUrlIsNull() {
            addCriterion("action_url is null");
            return (Criteria) this;
        }

        public Criteria andActionUrlIsNotNull() {
            addCriterion("action_url is not null");
            return (Criteria) this;
        }

        public Criteria andActionUrlEqualTo(String value) {
            addCriterion("action_url =", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlNotEqualTo(String value) {
            addCriterion("action_url <>", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlGreaterThan(String value) {
            addCriterion("action_url >", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlGreaterThanOrEqualTo(String value) {
            addCriterion("action_url >=", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlLessThan(String value) {
            addCriterion("action_url <", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlLessThanOrEqualTo(String value) {
            addCriterion("action_url <=", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlLike(String value) {
            addCriterion("action_url like", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlNotLike(String value) {
            addCriterion("action_url not like", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlIn(List<String> values) {
            addCriterion("action_url in", values, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlNotIn(List<String> values) {
            addCriterion("action_url not in", values, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlBetween(String value1, String value2) {
            addCriterion("action_url between", value1, value2, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlNotBetween(String value1, String value2) {
            addCriterion("action_url not between", value1, value2, "actionUrl");
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

        public Criteria andActionEleValueIsNull() {
            addCriterion("action_ele_value is null");
            return (Criteria) this;
        }

        public Criteria andActionEleValueIsNotNull() {
            addCriterion("action_ele_value is not null");
            return (Criteria) this;
        }

        public Criteria andActionEleValueEqualTo(String value) {
            addCriterion("action_ele_value =", value, "actionEleValue");
            return (Criteria) this;
        }

        public Criteria andActionEleValueNotEqualTo(String value) {
            addCriterion("action_ele_value <>", value, "actionEleValue");
            return (Criteria) this;
        }

        public Criteria andActionEleValueGreaterThan(String value) {
            addCriterion("action_ele_value >", value, "actionEleValue");
            return (Criteria) this;
        }

        public Criteria andActionEleValueGreaterThanOrEqualTo(String value) {
            addCriterion("action_ele_value >=", value, "actionEleValue");
            return (Criteria) this;
        }

        public Criteria andActionEleValueLessThan(String value) {
            addCriterion("action_ele_value <", value, "actionEleValue");
            return (Criteria) this;
        }

        public Criteria andActionEleValueLessThanOrEqualTo(String value) {
            addCriterion("action_ele_value <=", value, "actionEleValue");
            return (Criteria) this;
        }

        public Criteria andActionEleValueLike(String value) {
            addCriterion("action_ele_value like", value, "actionEleValue");
            return (Criteria) this;
        }

        public Criteria andActionEleValueNotLike(String value) {
            addCriterion("action_ele_value not like", value, "actionEleValue");
            return (Criteria) this;
        }

        public Criteria andActionEleValueIn(List<String> values) {
            addCriterion("action_ele_value in", values, "actionEleValue");
            return (Criteria) this;
        }

        public Criteria andActionEleValueNotIn(List<String> values) {
            addCriterion("action_ele_value not in", values, "actionEleValue");
            return (Criteria) this;
        }

        public Criteria andActionEleValueBetween(String value1, String value2) {
            addCriterion("action_ele_value between", value1, value2, "actionEleValue");
            return (Criteria) this;
        }

        public Criteria andActionEleValueNotBetween(String value1, String value2) {
            addCriterion("action_ele_value not between", value1, value2, "actionEleValue");
            return (Criteria) this;
        }

        public Criteria andActionPreIdIsNull() {
            addCriterion("action_pre_id is null");
            return (Criteria) this;
        }

        public Criteria andActionPreIdIsNotNull() {
            addCriterion("action_pre_id is not null");
            return (Criteria) this;
        }

        public Criteria andActionPreIdEqualTo(Integer value) {
            addCriterion("action_pre_id =", value, "actionPreId");
            return (Criteria) this;
        }

        public Criteria andActionPreIdNotEqualTo(Integer value) {
            addCriterion("action_pre_id <>", value, "actionPreId");
            return (Criteria) this;
        }

        public Criteria andActionPreIdGreaterThan(Integer value) {
            addCriterion("action_pre_id >", value, "actionPreId");
            return (Criteria) this;
        }

        public Criteria andActionPreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("action_pre_id >=", value, "actionPreId");
            return (Criteria) this;
        }

        public Criteria andActionPreIdLessThan(Integer value) {
            addCriterion("action_pre_id <", value, "actionPreId");
            return (Criteria) this;
        }

        public Criteria andActionPreIdLessThanOrEqualTo(Integer value) {
            addCriterion("action_pre_id <=", value, "actionPreId");
            return (Criteria) this;
        }

        public Criteria andActionPreIdIn(List<Integer> values) {
            addCriterion("action_pre_id in", values, "actionPreId");
            return (Criteria) this;
        }

        public Criteria andActionPreIdNotIn(List<Integer> values) {
            addCriterion("action_pre_id not in", values, "actionPreId");
            return (Criteria) this;
        }

        public Criteria andActionPreIdBetween(Integer value1, Integer value2) {
            addCriterion("action_pre_id between", value1, value2, "actionPreId");
            return (Criteria) this;
        }

        public Criteria andActionPreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("action_pre_id not between", value1, value2, "actionPreId");
            return (Criteria) this;
        }

        public Criteria andActionAfterIdIsNull() {
            addCriterion("action_after_id is null");
            return (Criteria) this;
        }

        public Criteria andActionAfterIdIsNotNull() {
            addCriterion("action_after_id is not null");
            return (Criteria) this;
        }

        public Criteria andActionAfterIdEqualTo(Integer value) {
            addCriterion("action_after_id =", value, "actionAfterId");
            return (Criteria) this;
        }

        public Criteria andActionAfterIdNotEqualTo(Integer value) {
            addCriterion("action_after_id <>", value, "actionAfterId");
            return (Criteria) this;
        }

        public Criteria andActionAfterIdGreaterThan(Integer value) {
            addCriterion("action_after_id >", value, "actionAfterId");
            return (Criteria) this;
        }

        public Criteria andActionAfterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("action_after_id >=", value, "actionAfterId");
            return (Criteria) this;
        }

        public Criteria andActionAfterIdLessThan(Integer value) {
            addCriterion("action_after_id <", value, "actionAfterId");
            return (Criteria) this;
        }

        public Criteria andActionAfterIdLessThanOrEqualTo(Integer value) {
            addCriterion("action_after_id <=", value, "actionAfterId");
            return (Criteria) this;
        }

        public Criteria andActionAfterIdIn(List<Integer> values) {
            addCriterion("action_after_id in", values, "actionAfterId");
            return (Criteria) this;
        }

        public Criteria andActionAfterIdNotIn(List<Integer> values) {
            addCriterion("action_after_id not in", values, "actionAfterId");
            return (Criteria) this;
        }

        public Criteria andActionAfterIdBetween(Integer value1, Integer value2) {
            addCriterion("action_after_id between", value1, value2, "actionAfterId");
            return (Criteria) this;
        }

        public Criteria andActionAfterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("action_after_id not between", value1, value2, "actionAfterId");
            return (Criteria) this;
        }

        public Criteria andActionNameIsNull() {
            addCriterion("action_name is null");
            return (Criteria) this;
        }

        public Criteria andActionNameIsNotNull() {
            addCriterion("action_name is not null");
            return (Criteria) this;
        }

        public Criteria andActionNameEqualTo(String value) {
            addCriterion("action_name =", value, "actionName");
            return (Criteria) this;
        }

        public Criteria andActionNameNotEqualTo(String value) {
            addCriterion("action_name <>", value, "actionName");
            return (Criteria) this;
        }

        public Criteria andActionNameGreaterThan(String value) {
            addCriterion("action_name >", value, "actionName");
            return (Criteria) this;
        }

        public Criteria andActionNameGreaterThanOrEqualTo(String value) {
            addCriterion("action_name >=", value, "actionName");
            return (Criteria) this;
        }

        public Criteria andActionNameLessThan(String value) {
            addCriterion("action_name <", value, "actionName");
            return (Criteria) this;
        }

        public Criteria andActionNameLessThanOrEqualTo(String value) {
            addCriterion("action_name <=", value, "actionName");
            return (Criteria) this;
        }

        public Criteria andActionNameLike(String value) {
            addCriterion("action_name like", value, "actionName");
            return (Criteria) this;
        }

        public Criteria andActionNameNotLike(String value) {
            addCriterion("action_name not like", value, "actionName");
            return (Criteria) this;
        }

        public Criteria andActionNameIn(List<String> values) {
            addCriterion("action_name in", values, "actionName");
            return (Criteria) this;
        }

        public Criteria andActionNameNotIn(List<String> values) {
            addCriterion("action_name not in", values, "actionName");
            return (Criteria) this;
        }

        public Criteria andActionNameBetween(String value1, String value2) {
            addCriterion("action_name between", value1, value2, "actionName");
            return (Criteria) this;
        }

        public Criteria andActionNameNotBetween(String value1, String value2) {
            addCriterion("action_name not between", value1, value2, "actionName");
            return (Criteria) this;
        }

        public Criteria andActionPragramIdIsNull() {
            addCriterion("action_pragram_id is null");
            return (Criteria) this;
        }

        public Criteria andActionPragramIdIsNotNull() {
            addCriterion("action_pragram_id is not null");
            return (Criteria) this;
        }

        public Criteria andActionPragramIdEqualTo(Integer value) {
            addCriterion("action_pragram_id =", value, "actionPragramId");
            return (Criteria) this;
        }

        public Criteria andActionPragramIdNotEqualTo(Integer value) {
            addCriterion("action_pragram_id <>", value, "actionPragramId");
            return (Criteria) this;
        }

        public Criteria andActionPragramIdGreaterThan(Integer value) {
            addCriterion("action_pragram_id >", value, "actionPragramId");
            return (Criteria) this;
        }

        public Criteria andActionPragramIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("action_pragram_id >=", value, "actionPragramId");
            return (Criteria) this;
        }

        public Criteria andActionPragramIdLessThan(Integer value) {
            addCriterion("action_pragram_id <", value, "actionPragramId");
            return (Criteria) this;
        }

        public Criteria andActionPragramIdLessThanOrEqualTo(Integer value) {
            addCriterion("action_pragram_id <=", value, "actionPragramId");
            return (Criteria) this;
        }

        public Criteria andActionPragramIdIn(List<Integer> values) {
            addCriterion("action_pragram_id in", values, "actionPragramId");
            return (Criteria) this;
        }

        public Criteria andActionPragramIdNotIn(List<Integer> values) {
            addCriterion("action_pragram_id not in", values, "actionPragramId");
            return (Criteria) this;
        }

        public Criteria andActionPragramIdBetween(Integer value1, Integer value2) {
            addCriterion("action_pragram_id between", value1, value2, "actionPragramId");
            return (Criteria) this;
        }

        public Criteria andActionPragramIdNotBetween(Integer value1, Integer value2) {
            addCriterion("action_pragram_id not between", value1, value2, "actionPragramId");
            return (Criteria) this;
        }

        public Criteria andActionElePragramIdIsNull() {
            addCriterion("action_ele_pragram_id is null");
            return (Criteria) this;
        }

        public Criteria andActionElePragramIdIsNotNull() {
            addCriterion("action_ele_pragram_id is not null");
            return (Criteria) this;
        }

        public Criteria andActionElePragramIdEqualTo(Integer value) {
            addCriterion("action_ele_pragram_id =", value, "actionElePragramId");
            return (Criteria) this;
        }

        public Criteria andActionElePragramIdNotEqualTo(Integer value) {
            addCriterion("action_ele_pragram_id <>", value, "actionElePragramId");
            return (Criteria) this;
        }

        public Criteria andActionElePragramIdGreaterThan(Integer value) {
            addCriterion("action_ele_pragram_id >", value, "actionElePragramId");
            return (Criteria) this;
        }

        public Criteria andActionElePragramIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("action_ele_pragram_id >=", value, "actionElePragramId");
            return (Criteria) this;
        }

        public Criteria andActionElePragramIdLessThan(Integer value) {
            addCriterion("action_ele_pragram_id <", value, "actionElePragramId");
            return (Criteria) this;
        }

        public Criteria andActionElePragramIdLessThanOrEqualTo(Integer value) {
            addCriterion("action_ele_pragram_id <=", value, "actionElePragramId");
            return (Criteria) this;
        }

        public Criteria andActionElePragramIdIn(List<Integer> values) {
            addCriterion("action_ele_pragram_id in", values, "actionElePragramId");
            return (Criteria) this;
        }

        public Criteria andActionElePragramIdNotIn(List<Integer> values) {
            addCriterion("action_ele_pragram_id not in", values, "actionElePragramId");
            return (Criteria) this;
        }

        public Criteria andActionElePragramIdBetween(Integer value1, Integer value2) {
            addCriterion("action_ele_pragram_id between", value1, value2, "actionElePragramId");
            return (Criteria) this;
        }

        public Criteria andActionElePragramIdNotBetween(Integer value1, Integer value2) {
            addCriterion("action_ele_pragram_id not between", value1, value2, "actionElePragramId");
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