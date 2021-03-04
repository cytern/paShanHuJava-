package com.kente.demo.pojo;

import java.util.ArrayList;
import java.util.List;

public class KenteotherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KenteotherExample() {
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

        public Criteria andMouthIsNull() {
            addCriterion("mouth is null");
            return (Criteria) this;
        }

        public Criteria andMouthIsNotNull() {
            addCriterion("mouth is not null");
            return (Criteria) this;
        }

        public Criteria andMouthEqualTo(String value) {
            addCriterion("mouth =", value, "mouth");
            return (Criteria) this;
        }

        public Criteria andMouthNotEqualTo(String value) {
            addCriterion("mouth <>", value, "mouth");
            return (Criteria) this;
        }

        public Criteria andMouthGreaterThan(String value) {
            addCriterion("mouth >", value, "mouth");
            return (Criteria) this;
        }

        public Criteria andMouthGreaterThanOrEqualTo(String value) {
            addCriterion("mouth >=", value, "mouth");
            return (Criteria) this;
        }

        public Criteria andMouthLessThan(String value) {
            addCriterion("mouth <", value, "mouth");
            return (Criteria) this;
        }

        public Criteria andMouthLessThanOrEqualTo(String value) {
            addCriterion("mouth <=", value, "mouth");
            return (Criteria) this;
        }

        public Criteria andMouthLike(String value) {
            addCriterion("mouth like", value, "mouth");
            return (Criteria) this;
        }

        public Criteria andMouthNotLike(String value) {
            addCriterion("mouth not like", value, "mouth");
            return (Criteria) this;
        }

        public Criteria andMouthIn(List<String> values) {
            addCriterion("mouth in", values, "mouth");
            return (Criteria) this;
        }

        public Criteria andMouthNotIn(List<String> values) {
            addCriterion("mouth not in", values, "mouth");
            return (Criteria) this;
        }

        public Criteria andMouthBetween(String value1, String value2) {
            addCriterion("mouth between", value1, value2, "mouth");
            return (Criteria) this;
        }

        public Criteria andMouthNotBetween(String value1, String value2) {
            addCriterion("mouth not between", value1, value2, "mouth");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(String value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(String value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(String value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(String value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(String value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLike(String value) {
            addCriterion("start_time like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotLike(String value) {
            addCriterion("start_time not like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<String> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<String> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(String value1, String value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(String value1, String value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
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

        public Criteria andLvIsNull() {
            addCriterion("lv is null");
            return (Criteria) this;
        }

        public Criteria andLvIsNotNull() {
            addCriterion("lv is not null");
            return (Criteria) this;
        }

        public Criteria andLvEqualTo(String value) {
            addCriterion("lv =", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvNotEqualTo(String value) {
            addCriterion("lv <>", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvGreaterThan(String value) {
            addCriterion("lv >", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvGreaterThanOrEqualTo(String value) {
            addCriterion("lv >=", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvLessThan(String value) {
            addCriterion("lv <", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvLessThanOrEqualTo(String value) {
            addCriterion("lv <=", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvLike(String value) {
            addCriterion("lv like", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvNotLike(String value) {
            addCriterion("lv not like", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvIn(List<String> values) {
            addCriterion("lv in", values, "lv");
            return (Criteria) this;
        }

        public Criteria andLvNotIn(List<String> values) {
            addCriterion("lv not in", values, "lv");
            return (Criteria) this;
        }

        public Criteria andLvBetween(String value1, String value2) {
            addCriterion("lv between", value1, value2, "lv");
            return (Criteria) this;
        }

        public Criteria andLvNotBetween(String value1, String value2) {
            addCriterion("lv not between", value1, value2, "lv");
            return (Criteria) this;
        }

        public Criteria andObjTypeIsNull() {
            addCriterion("obj_type is null");
            return (Criteria) this;
        }

        public Criteria andObjTypeIsNotNull() {
            addCriterion("obj_type is not null");
            return (Criteria) this;
        }

        public Criteria andObjTypeEqualTo(String value) {
            addCriterion("obj_type =", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeNotEqualTo(String value) {
            addCriterion("obj_type <>", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeGreaterThan(String value) {
            addCriterion("obj_type >", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeGreaterThanOrEqualTo(String value) {
            addCriterion("obj_type >=", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeLessThan(String value) {
            addCriterion("obj_type <", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeLessThanOrEqualTo(String value) {
            addCriterion("obj_type <=", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeLike(String value) {
            addCriterion("obj_type like", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeNotLike(String value) {
            addCriterion("obj_type not like", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeIn(List<String> values) {
            addCriterion("obj_type in", values, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeNotIn(List<String> values) {
            addCriterion("obj_type not in", values, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeBetween(String value1, String value2) {
            addCriterion("obj_type between", value1, value2, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeNotBetween(String value1, String value2) {
            addCriterion("obj_type not between", value1, value2, "objType");
            return (Criteria) this;
        }

        public Criteria andProTypeIsNull() {
            addCriterion("pro_type is null");
            return (Criteria) this;
        }

        public Criteria andProTypeIsNotNull() {
            addCriterion("pro_type is not null");
            return (Criteria) this;
        }

        public Criteria andProTypeEqualTo(String value) {
            addCriterion("pro_type =", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotEqualTo(String value) {
            addCriterion("pro_type <>", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeGreaterThan(String value) {
            addCriterion("pro_type >", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pro_type >=", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeLessThan(String value) {
            addCriterion("pro_type <", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeLessThanOrEqualTo(String value) {
            addCriterion("pro_type <=", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeLike(String value) {
            addCriterion("pro_type like", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotLike(String value) {
            addCriterion("pro_type not like", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeIn(List<String> values) {
            addCriterion("pro_type in", values, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotIn(List<String> values) {
            addCriterion("pro_type not in", values, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeBetween(String value1, String value2) {
            addCriterion("pro_type between", value1, value2, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotBetween(String value1, String value2) {
            addCriterion("pro_type not between", value1, value2, "proType");
            return (Criteria) this;
        }

        public Criteria andOtherNameIsNull() {
            addCriterion("other_name is null");
            return (Criteria) this;
        }

        public Criteria andOtherNameIsNotNull() {
            addCriterion("other_name is not null");
            return (Criteria) this;
        }

        public Criteria andOtherNameEqualTo(String value) {
            addCriterion("other_name =", value, "otherName");
            return (Criteria) this;
        }

        public Criteria andOtherNameNotEqualTo(String value) {
            addCriterion("other_name <>", value, "otherName");
            return (Criteria) this;
        }

        public Criteria andOtherNameGreaterThan(String value) {
            addCriterion("other_name >", value, "otherName");
            return (Criteria) this;
        }

        public Criteria andOtherNameGreaterThanOrEqualTo(String value) {
            addCriterion("other_name >=", value, "otherName");
            return (Criteria) this;
        }

        public Criteria andOtherNameLessThan(String value) {
            addCriterion("other_name <", value, "otherName");
            return (Criteria) this;
        }

        public Criteria andOtherNameLessThanOrEqualTo(String value) {
            addCriterion("other_name <=", value, "otherName");
            return (Criteria) this;
        }

        public Criteria andOtherNameLike(String value) {
            addCriterion("other_name like", value, "otherName");
            return (Criteria) this;
        }

        public Criteria andOtherNameNotLike(String value) {
            addCriterion("other_name not like", value, "otherName");
            return (Criteria) this;
        }

        public Criteria andOtherNameIn(List<String> values) {
            addCriterion("other_name in", values, "otherName");
            return (Criteria) this;
        }

        public Criteria andOtherNameNotIn(List<String> values) {
            addCriterion("other_name not in", values, "otherName");
            return (Criteria) this;
        }

        public Criteria andOtherNameBetween(String value1, String value2) {
            addCriterion("other_name between", value1, value2, "otherName");
            return (Criteria) this;
        }

        public Criteria andOtherNameNotBetween(String value1, String value2) {
            addCriterion("other_name not between", value1, value2, "otherName");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("project_id like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("project_id not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andFinalUserNameIsNull() {
            addCriterion("final_user_name is null");
            return (Criteria) this;
        }

        public Criteria andFinalUserNameIsNotNull() {
            addCriterion("final_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andFinalUserNameEqualTo(String value) {
            addCriterion("final_user_name =", value, "finalUserName");
            return (Criteria) this;
        }

        public Criteria andFinalUserNameNotEqualTo(String value) {
            addCriterion("final_user_name <>", value, "finalUserName");
            return (Criteria) this;
        }

        public Criteria andFinalUserNameGreaterThan(String value) {
            addCriterion("final_user_name >", value, "finalUserName");
            return (Criteria) this;
        }

        public Criteria andFinalUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("final_user_name >=", value, "finalUserName");
            return (Criteria) this;
        }

        public Criteria andFinalUserNameLessThan(String value) {
            addCriterion("final_user_name <", value, "finalUserName");
            return (Criteria) this;
        }

        public Criteria andFinalUserNameLessThanOrEqualTo(String value) {
            addCriterion("final_user_name <=", value, "finalUserName");
            return (Criteria) this;
        }

        public Criteria andFinalUserNameLike(String value) {
            addCriterion("final_user_name like", value, "finalUserName");
            return (Criteria) this;
        }

        public Criteria andFinalUserNameNotLike(String value) {
            addCriterion("final_user_name not like", value, "finalUserName");
            return (Criteria) this;
        }

        public Criteria andFinalUserNameIn(List<String> values) {
            addCriterion("final_user_name in", values, "finalUserName");
            return (Criteria) this;
        }

        public Criteria andFinalUserNameNotIn(List<String> values) {
            addCriterion("final_user_name not in", values, "finalUserName");
            return (Criteria) this;
        }

        public Criteria andFinalUserNameBetween(String value1, String value2) {
            addCriterion("final_user_name between", value1, value2, "finalUserName");
            return (Criteria) this;
        }

        public Criteria andFinalUserNameNotBetween(String value1, String value2) {
            addCriterion("final_user_name not between", value1, value2, "finalUserName");
            return (Criteria) this;
        }

        public Criteria andNeedNumIsNull() {
            addCriterion("need_num is null");
            return (Criteria) this;
        }

        public Criteria andNeedNumIsNotNull() {
            addCriterion("need_num is not null");
            return (Criteria) this;
        }

        public Criteria andNeedNumEqualTo(Integer value) {
            addCriterion("need_num =", value, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumNotEqualTo(Integer value) {
            addCriterion("need_num <>", value, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumGreaterThan(Integer value) {
            addCriterion("need_num >", value, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("need_num >=", value, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumLessThan(Integer value) {
            addCriterion("need_num <", value, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumLessThanOrEqualTo(Integer value) {
            addCriterion("need_num <=", value, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumIn(List<Integer> values) {
            addCriterion("need_num in", values, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumNotIn(List<Integer> values) {
            addCriterion("need_num not in", values, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumBetween(Integer value1, Integer value2) {
            addCriterion("need_num between", value1, value2, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumNotBetween(Integer value1, Integer value2) {
            addCriterion("need_num not between", value1, value2, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedPriceIsNull() {
            addCriterion("need_price is null");
            return (Criteria) this;
        }

        public Criteria andNeedPriceIsNotNull() {
            addCriterion("need_price is not null");
            return (Criteria) this;
        }

        public Criteria andNeedPriceEqualTo(String value) {
            addCriterion("need_price =", value, "needPrice");
            return (Criteria) this;
        }

        public Criteria andNeedPriceNotEqualTo(String value) {
            addCriterion("need_price <>", value, "needPrice");
            return (Criteria) this;
        }

        public Criteria andNeedPriceGreaterThan(String value) {
            addCriterion("need_price >", value, "needPrice");
            return (Criteria) this;
        }

        public Criteria andNeedPriceGreaterThanOrEqualTo(String value) {
            addCriterion("need_price >=", value, "needPrice");
            return (Criteria) this;
        }

        public Criteria andNeedPriceLessThan(String value) {
            addCriterion("need_price <", value, "needPrice");
            return (Criteria) this;
        }

        public Criteria andNeedPriceLessThanOrEqualTo(String value) {
            addCriterion("need_price <=", value, "needPrice");
            return (Criteria) this;
        }

        public Criteria andNeedPriceLike(String value) {
            addCriterion("need_price like", value, "needPrice");
            return (Criteria) this;
        }

        public Criteria andNeedPriceNotLike(String value) {
            addCriterion("need_price not like", value, "needPrice");
            return (Criteria) this;
        }

        public Criteria andNeedPriceIn(List<String> values) {
            addCriterion("need_price in", values, "needPrice");
            return (Criteria) this;
        }

        public Criteria andNeedPriceNotIn(List<String> values) {
            addCriterion("need_price not in", values, "needPrice");
            return (Criteria) this;
        }

        public Criteria andNeedPriceBetween(String value1, String value2) {
            addCriterion("need_price between", value1, value2, "needPrice");
            return (Criteria) this;
        }

        public Criteria andNeedPriceNotBetween(String value1, String value2) {
            addCriterion("need_price not between", value1, value2, "needPrice");
            return (Criteria) this;
        }

        public Criteria andNeedResIsNull() {
            addCriterion("need_res is null");
            return (Criteria) this;
        }

        public Criteria andNeedResIsNotNull() {
            addCriterion("need_res is not null");
            return (Criteria) this;
        }

        public Criteria andNeedResEqualTo(String value) {
            addCriterion("need_res =", value, "needRes");
            return (Criteria) this;
        }

        public Criteria andNeedResNotEqualTo(String value) {
            addCriterion("need_res <>", value, "needRes");
            return (Criteria) this;
        }

        public Criteria andNeedResGreaterThan(String value) {
            addCriterion("need_res >", value, "needRes");
            return (Criteria) this;
        }

        public Criteria andNeedResGreaterThanOrEqualTo(String value) {
            addCriterion("need_res >=", value, "needRes");
            return (Criteria) this;
        }

        public Criteria andNeedResLessThan(String value) {
            addCriterion("need_res <", value, "needRes");
            return (Criteria) this;
        }

        public Criteria andNeedResLessThanOrEqualTo(String value) {
            addCriterion("need_res <=", value, "needRes");
            return (Criteria) this;
        }

        public Criteria andNeedResLike(String value) {
            addCriterion("need_res like", value, "needRes");
            return (Criteria) this;
        }

        public Criteria andNeedResNotLike(String value) {
            addCriterion("need_res not like", value, "needRes");
            return (Criteria) this;
        }

        public Criteria andNeedResIn(List<String> values) {
            addCriterion("need_res in", values, "needRes");
            return (Criteria) this;
        }

        public Criteria andNeedResNotIn(List<String> values) {
            addCriterion("need_res not in", values, "needRes");
            return (Criteria) this;
        }

        public Criteria andNeedResBetween(String value1, String value2) {
            addCriterion("need_res between", value1, value2, "needRes");
            return (Criteria) this;
        }

        public Criteria andNeedResNotBetween(String value1, String value2) {
            addCriterion("need_res not between", value1, value2, "needRes");
            return (Criteria) this;
        }

        public Criteria andFinalWinIsNull() {
            addCriterion("final_win is null");
            return (Criteria) this;
        }

        public Criteria andFinalWinIsNotNull() {
            addCriterion("final_win is not null");
            return (Criteria) this;
        }

        public Criteria andFinalWinEqualTo(String value) {
            addCriterion("final_win =", value, "finalWin");
            return (Criteria) this;
        }

        public Criteria andFinalWinNotEqualTo(String value) {
            addCriterion("final_win <>", value, "finalWin");
            return (Criteria) this;
        }

        public Criteria andFinalWinGreaterThan(String value) {
            addCriterion("final_win >", value, "finalWin");
            return (Criteria) this;
        }

        public Criteria andFinalWinGreaterThanOrEqualTo(String value) {
            addCriterion("final_win >=", value, "finalWin");
            return (Criteria) this;
        }

        public Criteria andFinalWinLessThan(String value) {
            addCriterion("final_win <", value, "finalWin");
            return (Criteria) this;
        }

        public Criteria andFinalWinLessThanOrEqualTo(String value) {
            addCriterion("final_win <=", value, "finalWin");
            return (Criteria) this;
        }

        public Criteria andFinalWinLike(String value) {
            addCriterion("final_win like", value, "finalWin");
            return (Criteria) this;
        }

        public Criteria andFinalWinNotLike(String value) {
            addCriterion("final_win not like", value, "finalWin");
            return (Criteria) this;
        }

        public Criteria andFinalWinIn(List<String> values) {
            addCriterion("final_win in", values, "finalWin");
            return (Criteria) this;
        }

        public Criteria andFinalWinNotIn(List<String> values) {
            addCriterion("final_win not in", values, "finalWin");
            return (Criteria) this;
        }

        public Criteria andFinalWinBetween(String value1, String value2) {
            addCriterion("final_win between", value1, value2, "finalWin");
            return (Criteria) this;
        }

        public Criteria andFinalWinNotBetween(String value1, String value2) {
            addCriterion("final_win not between", value1, value2, "finalWin");
            return (Criteria) this;
        }

        public Criteria andNotReasonIsNull() {
            addCriterion("not_reason is null");
            return (Criteria) this;
        }

        public Criteria andNotReasonIsNotNull() {
            addCriterion("not_reason is not null");
            return (Criteria) this;
        }

        public Criteria andNotReasonEqualTo(String value) {
            addCriterion("not_reason =", value, "notReason");
            return (Criteria) this;
        }

        public Criteria andNotReasonNotEqualTo(String value) {
            addCriterion("not_reason <>", value, "notReason");
            return (Criteria) this;
        }

        public Criteria andNotReasonGreaterThan(String value) {
            addCriterion("not_reason >", value, "notReason");
            return (Criteria) this;
        }

        public Criteria andNotReasonGreaterThanOrEqualTo(String value) {
            addCriterion("not_reason >=", value, "notReason");
            return (Criteria) this;
        }

        public Criteria andNotReasonLessThan(String value) {
            addCriterion("not_reason <", value, "notReason");
            return (Criteria) this;
        }

        public Criteria andNotReasonLessThanOrEqualTo(String value) {
            addCriterion("not_reason <=", value, "notReason");
            return (Criteria) this;
        }

        public Criteria andNotReasonLike(String value) {
            addCriterion("not_reason like", value, "notReason");
            return (Criteria) this;
        }

        public Criteria andNotReasonNotLike(String value) {
            addCriterion("not_reason not like", value, "notReason");
            return (Criteria) this;
        }

        public Criteria andNotReasonIn(List<String> values) {
            addCriterion("not_reason in", values, "notReason");
            return (Criteria) this;
        }

        public Criteria andNotReasonNotIn(List<String> values) {
            addCriterion("not_reason not in", values, "notReason");
            return (Criteria) this;
        }

        public Criteria andNotReasonBetween(String value1, String value2) {
            addCriterion("not_reason between", value1, value2, "notReason");
            return (Criteria) this;
        }

        public Criteria andNotReasonNotBetween(String value1, String value2) {
            addCriterion("not_reason not between", value1, value2, "notReason");
            return (Criteria) this;
        }

        public Criteria andFinalPriceIsNull() {
            addCriterion("final_price is null");
            return (Criteria) this;
        }

        public Criteria andFinalPriceIsNotNull() {
            addCriterion("final_price is not null");
            return (Criteria) this;
        }

        public Criteria andFinalPriceEqualTo(String value) {
            addCriterion("final_price =", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceNotEqualTo(String value) {
            addCriterion("final_price <>", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceGreaterThan(String value) {
            addCriterion("final_price >", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceGreaterThanOrEqualTo(String value) {
            addCriterion("final_price >=", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceLessThan(String value) {
            addCriterion("final_price <", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceLessThanOrEqualTo(String value) {
            addCriterion("final_price <=", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceLike(String value) {
            addCriterion("final_price like", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceNotLike(String value) {
            addCriterion("final_price not like", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceIn(List<String> values) {
            addCriterion("final_price in", values, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceNotIn(List<String> values) {
            addCriterion("final_price not in", values, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceBetween(String value1, String value2) {
            addCriterion("final_price between", value1, value2, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceNotBetween(String value1, String value2) {
            addCriterion("final_price not between", value1, value2, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andNotReasonDetailIsNull() {
            addCriterion("not_reason_detail is null");
            return (Criteria) this;
        }

        public Criteria andNotReasonDetailIsNotNull() {
            addCriterion("not_reason_detail is not null");
            return (Criteria) this;
        }

        public Criteria andNotReasonDetailEqualTo(String value) {
            addCriterion("not_reason_detail =", value, "notReasonDetail");
            return (Criteria) this;
        }

        public Criteria andNotReasonDetailNotEqualTo(String value) {
            addCriterion("not_reason_detail <>", value, "notReasonDetail");
            return (Criteria) this;
        }

        public Criteria andNotReasonDetailGreaterThan(String value) {
            addCriterion("not_reason_detail >", value, "notReasonDetail");
            return (Criteria) this;
        }

        public Criteria andNotReasonDetailGreaterThanOrEqualTo(String value) {
            addCriterion("not_reason_detail >=", value, "notReasonDetail");
            return (Criteria) this;
        }

        public Criteria andNotReasonDetailLessThan(String value) {
            addCriterion("not_reason_detail <", value, "notReasonDetail");
            return (Criteria) this;
        }

        public Criteria andNotReasonDetailLessThanOrEqualTo(String value) {
            addCriterion("not_reason_detail <=", value, "notReasonDetail");
            return (Criteria) this;
        }

        public Criteria andNotReasonDetailLike(String value) {
            addCriterion("not_reason_detail like", value, "notReasonDetail");
            return (Criteria) this;
        }

        public Criteria andNotReasonDetailNotLike(String value) {
            addCriterion("not_reason_detail not like", value, "notReasonDetail");
            return (Criteria) this;
        }

        public Criteria andNotReasonDetailIn(List<String> values) {
            addCriterion("not_reason_detail in", values, "notReasonDetail");
            return (Criteria) this;
        }

        public Criteria andNotReasonDetailNotIn(List<String> values) {
            addCriterion("not_reason_detail not in", values, "notReasonDetail");
            return (Criteria) this;
        }

        public Criteria andNotReasonDetailBetween(String value1, String value2) {
            addCriterion("not_reason_detail between", value1, value2, "notReasonDetail");
            return (Criteria) this;
        }

        public Criteria andNotReasonDetailNotBetween(String value1, String value2) {
            addCriterion("not_reason_detail not between", value1, value2, "notReasonDetail");
            return (Criteria) this;
        }

        public Criteria andHaveContractIsNull() {
            addCriterion("have_contract is null");
            return (Criteria) this;
        }

        public Criteria andHaveContractIsNotNull() {
            addCriterion("have_contract is not null");
            return (Criteria) this;
        }

        public Criteria andHaveContractEqualTo(String value) {
            addCriterion("have_contract =", value, "haveContract");
            return (Criteria) this;
        }

        public Criteria andHaveContractNotEqualTo(String value) {
            addCriterion("have_contract <>", value, "haveContract");
            return (Criteria) this;
        }

        public Criteria andHaveContractGreaterThan(String value) {
            addCriterion("have_contract >", value, "haveContract");
            return (Criteria) this;
        }

        public Criteria andHaveContractGreaterThanOrEqualTo(String value) {
            addCriterion("have_contract >=", value, "haveContract");
            return (Criteria) this;
        }

        public Criteria andHaveContractLessThan(String value) {
            addCriterion("have_contract <", value, "haveContract");
            return (Criteria) this;
        }

        public Criteria andHaveContractLessThanOrEqualTo(String value) {
            addCriterion("have_contract <=", value, "haveContract");
            return (Criteria) this;
        }

        public Criteria andHaveContractLike(String value) {
            addCriterion("have_contract like", value, "haveContract");
            return (Criteria) this;
        }

        public Criteria andHaveContractNotLike(String value) {
            addCriterion("have_contract not like", value, "haveContract");
            return (Criteria) this;
        }

        public Criteria andHaveContractIn(List<String> values) {
            addCriterion("have_contract in", values, "haveContract");
            return (Criteria) this;
        }

        public Criteria andHaveContractNotIn(List<String> values) {
            addCriterion("have_contract not in", values, "haveContract");
            return (Criteria) this;
        }

        public Criteria andHaveContractBetween(String value1, String value2) {
            addCriterion("have_contract between", value1, value2, "haveContract");
            return (Criteria) this;
        }

        public Criteria andHaveContractNotBetween(String value1, String value2) {
            addCriterion("have_contract not between", value1, value2, "haveContract");
            return (Criteria) this;
        }

        public Criteria andContractPriceIsNull() {
            addCriterion("contract_price is null");
            return (Criteria) this;
        }

        public Criteria andContractPriceIsNotNull() {
            addCriterion("contract_price is not null");
            return (Criteria) this;
        }

        public Criteria andContractPriceEqualTo(String value) {
            addCriterion("contract_price =", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceNotEqualTo(String value) {
            addCriterion("contract_price <>", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceGreaterThan(String value) {
            addCriterion("contract_price >", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceGreaterThanOrEqualTo(String value) {
            addCriterion("contract_price >=", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceLessThan(String value) {
            addCriterion("contract_price <", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceLessThanOrEqualTo(String value) {
            addCriterion("contract_price <=", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceLike(String value) {
            addCriterion("contract_price like", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceNotLike(String value) {
            addCriterion("contract_price not like", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceIn(List<String> values) {
            addCriterion("contract_price in", values, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceNotIn(List<String> values) {
            addCriterion("contract_price not in", values, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceBetween(String value1, String value2) {
            addCriterion("contract_price between", value1, value2, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceNotBetween(String value1, String value2) {
            addCriterion("contract_price not between", value1, value2, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andSaleAreaIsNull() {
            addCriterion("sale_area is null");
            return (Criteria) this;
        }

        public Criteria andSaleAreaIsNotNull() {
            addCriterion("sale_area is not null");
            return (Criteria) this;
        }

        public Criteria andSaleAreaEqualTo(String value) {
            addCriterion("sale_area =", value, "saleArea");
            return (Criteria) this;
        }

        public Criteria andSaleAreaNotEqualTo(String value) {
            addCriterion("sale_area <>", value, "saleArea");
            return (Criteria) this;
        }

        public Criteria andSaleAreaGreaterThan(String value) {
            addCriterion("sale_area >", value, "saleArea");
            return (Criteria) this;
        }

        public Criteria andSaleAreaGreaterThanOrEqualTo(String value) {
            addCriterion("sale_area >=", value, "saleArea");
            return (Criteria) this;
        }

        public Criteria andSaleAreaLessThan(String value) {
            addCriterion("sale_area <", value, "saleArea");
            return (Criteria) this;
        }

        public Criteria andSaleAreaLessThanOrEqualTo(String value) {
            addCriterion("sale_area <=", value, "saleArea");
            return (Criteria) this;
        }

        public Criteria andSaleAreaLike(String value) {
            addCriterion("sale_area like", value, "saleArea");
            return (Criteria) this;
        }

        public Criteria andSaleAreaNotLike(String value) {
            addCriterion("sale_area not like", value, "saleArea");
            return (Criteria) this;
        }

        public Criteria andSaleAreaIn(List<String> values) {
            addCriterion("sale_area in", values, "saleArea");
            return (Criteria) this;
        }

        public Criteria andSaleAreaNotIn(List<String> values) {
            addCriterion("sale_area not in", values, "saleArea");
            return (Criteria) this;
        }

        public Criteria andSaleAreaBetween(String value1, String value2) {
            addCriterion("sale_area between", value1, value2, "saleArea");
            return (Criteria) this;
        }

        public Criteria andSaleAreaNotBetween(String value1, String value2) {
            addCriterion("sale_area not between", value1, value2, "saleArea");
            return (Criteria) this;
        }

        public Criteria andSaleManIsNull() {
            addCriterion("sale_man is null");
            return (Criteria) this;
        }

        public Criteria andSaleManIsNotNull() {
            addCriterion("sale_man is not null");
            return (Criteria) this;
        }

        public Criteria andSaleManEqualTo(String value) {
            addCriterion("sale_man =", value, "saleMan");
            return (Criteria) this;
        }

        public Criteria andSaleManNotEqualTo(String value) {
            addCriterion("sale_man <>", value, "saleMan");
            return (Criteria) this;
        }

        public Criteria andSaleManGreaterThan(String value) {
            addCriterion("sale_man >", value, "saleMan");
            return (Criteria) this;
        }

        public Criteria andSaleManGreaterThanOrEqualTo(String value) {
            addCriterion("sale_man >=", value, "saleMan");
            return (Criteria) this;
        }

        public Criteria andSaleManLessThan(String value) {
            addCriterion("sale_man <", value, "saleMan");
            return (Criteria) this;
        }

        public Criteria andSaleManLessThanOrEqualTo(String value) {
            addCriterion("sale_man <=", value, "saleMan");
            return (Criteria) this;
        }

        public Criteria andSaleManLike(String value) {
            addCriterion("sale_man like", value, "saleMan");
            return (Criteria) this;
        }

        public Criteria andSaleManNotLike(String value) {
            addCriterion("sale_man not like", value, "saleMan");
            return (Criteria) this;
        }

        public Criteria andSaleManIn(List<String> values) {
            addCriterion("sale_man in", values, "saleMan");
            return (Criteria) this;
        }

        public Criteria andSaleManNotIn(List<String> values) {
            addCriterion("sale_man not in", values, "saleMan");
            return (Criteria) this;
        }

        public Criteria andSaleManBetween(String value1, String value2) {
            addCriterion("sale_man between", value1, value2, "saleMan");
            return (Criteria) this;
        }

        public Criteria andSaleManNotBetween(String value1, String value2) {
            addCriterion("sale_man not between", value1, value2, "saleMan");
            return (Criteria) this;
        }

        public Criteria andUnTractNumIsNull() {
            addCriterion("un_tract_num is null");
            return (Criteria) this;
        }

        public Criteria andUnTractNumIsNotNull() {
            addCriterion("un_tract_num is not null");
            return (Criteria) this;
        }

        public Criteria andUnTractNumEqualTo(Integer value) {
            addCriterion("un_tract_num =", value, "unTractNum");
            return (Criteria) this;
        }

        public Criteria andUnTractNumNotEqualTo(Integer value) {
            addCriterion("un_tract_num <>", value, "unTractNum");
            return (Criteria) this;
        }

        public Criteria andUnTractNumGreaterThan(Integer value) {
            addCriterion("un_tract_num >", value, "unTractNum");
            return (Criteria) this;
        }

        public Criteria andUnTractNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("un_tract_num >=", value, "unTractNum");
            return (Criteria) this;
        }

        public Criteria andUnTractNumLessThan(Integer value) {
            addCriterion("un_tract_num <", value, "unTractNum");
            return (Criteria) this;
        }

        public Criteria andUnTractNumLessThanOrEqualTo(Integer value) {
            addCriterion("un_tract_num <=", value, "unTractNum");
            return (Criteria) this;
        }

        public Criteria andUnTractNumIn(List<Integer> values) {
            addCriterion("un_tract_num in", values, "unTractNum");
            return (Criteria) this;
        }

        public Criteria andUnTractNumNotIn(List<Integer> values) {
            addCriterion("un_tract_num not in", values, "unTractNum");
            return (Criteria) this;
        }

        public Criteria andUnTractNumBetween(Integer value1, Integer value2) {
            addCriterion("un_tract_num between", value1, value2, "unTractNum");
            return (Criteria) this;
        }

        public Criteria andUnTractNumNotBetween(Integer value1, Integer value2) {
            addCriterion("un_tract_num not between", value1, value2, "unTractNum");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Integer value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Integer value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Integer value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Integer value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Integer> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Integer> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Integer value1, Integer value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
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