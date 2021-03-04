package com.kente.demo.pojo;

import java.util.ArrayList;
import java.util.List;

public class KentecomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KentecomExample() {
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

        public Criteria andDateIsNull() {
            addCriterion("`date` is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("`date` is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(String value) {
            addCriterion("`date` =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(String value) {
            addCriterion("`date` <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(String value) {
            addCriterion("`date` >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(String value) {
            addCriterion("`date` >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(String value) {
            addCriterion("`date` <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(String value) {
            addCriterion("`date` <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLike(String value) {
            addCriterion("`date` like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotLike(String value) {
            addCriterion("`date` not like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<String> values) {
            addCriterion("`date` in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<String> values) {
            addCriterion("`date` not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(String value1, String value2) {
            addCriterion("`date` between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(String value1, String value2) {
            addCriterion("`date` not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andBusinessCreaterIsNull() {
            addCriterion("business_creater is null");
            return (Criteria) this;
        }

        public Criteria andBusinessCreaterIsNotNull() {
            addCriterion("business_creater is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessCreaterEqualTo(String value) {
            addCriterion("business_creater =", value, "businessCreater");
            return (Criteria) this;
        }

        public Criteria andBusinessCreaterNotEqualTo(String value) {
            addCriterion("business_creater <>", value, "businessCreater");
            return (Criteria) this;
        }

        public Criteria andBusinessCreaterGreaterThan(String value) {
            addCriterion("business_creater >", value, "businessCreater");
            return (Criteria) this;
        }

        public Criteria andBusinessCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("business_creater >=", value, "businessCreater");
            return (Criteria) this;
        }

        public Criteria andBusinessCreaterLessThan(String value) {
            addCriterion("business_creater <", value, "businessCreater");
            return (Criteria) this;
        }

        public Criteria andBusinessCreaterLessThanOrEqualTo(String value) {
            addCriterion("business_creater <=", value, "businessCreater");
            return (Criteria) this;
        }

        public Criteria andBusinessCreaterLike(String value) {
            addCriterion("business_creater like", value, "businessCreater");
            return (Criteria) this;
        }

        public Criteria andBusinessCreaterNotLike(String value) {
            addCriterion("business_creater not like", value, "businessCreater");
            return (Criteria) this;
        }

        public Criteria andBusinessCreaterIn(List<String> values) {
            addCriterion("business_creater in", values, "businessCreater");
            return (Criteria) this;
        }

        public Criteria andBusinessCreaterNotIn(List<String> values) {
            addCriterion("business_creater not in", values, "businessCreater");
            return (Criteria) this;
        }

        public Criteria andBusinessCreaterBetween(String value1, String value2) {
            addCriterion("business_creater between", value1, value2, "businessCreater");
            return (Criteria) this;
        }

        public Criteria andBusinessCreaterNotBetween(String value1, String value2) {
            addCriterion("business_creater not between", value1, value2, "businessCreater");
            return (Criteria) this;
        }

        public Criteria andTechCreaterIsNull() {
            addCriterion("tech_creater is null");
            return (Criteria) this;
        }

        public Criteria andTechCreaterIsNotNull() {
            addCriterion("tech_creater is not null");
            return (Criteria) this;
        }

        public Criteria andTechCreaterEqualTo(String value) {
            addCriterion("tech_creater =", value, "techCreater");
            return (Criteria) this;
        }

        public Criteria andTechCreaterNotEqualTo(String value) {
            addCriterion("tech_creater <>", value, "techCreater");
            return (Criteria) this;
        }

        public Criteria andTechCreaterGreaterThan(String value) {
            addCriterion("tech_creater >", value, "techCreater");
            return (Criteria) this;
        }

        public Criteria andTechCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("tech_creater >=", value, "techCreater");
            return (Criteria) this;
        }

        public Criteria andTechCreaterLessThan(String value) {
            addCriterion("tech_creater <", value, "techCreater");
            return (Criteria) this;
        }

        public Criteria andTechCreaterLessThanOrEqualTo(String value) {
            addCriterion("tech_creater <=", value, "techCreater");
            return (Criteria) this;
        }

        public Criteria andTechCreaterLike(String value) {
            addCriterion("tech_creater like", value, "techCreater");
            return (Criteria) this;
        }

        public Criteria andTechCreaterNotLike(String value) {
            addCriterion("tech_creater not like", value, "techCreater");
            return (Criteria) this;
        }

        public Criteria andTechCreaterIn(List<String> values) {
            addCriterion("tech_creater in", values, "techCreater");
            return (Criteria) this;
        }

        public Criteria andTechCreaterNotIn(List<String> values) {
            addCriterion("tech_creater not in", values, "techCreater");
            return (Criteria) this;
        }

        public Criteria andTechCreaterBetween(String value1, String value2) {
            addCriterion("tech_creater between", value1, value2, "techCreater");
            return (Criteria) this;
        }

        public Criteria andTechCreaterNotBetween(String value1, String value2) {
            addCriterion("tech_creater not between", value1, value2, "techCreater");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNull() {
            addCriterion("industry is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNotNull() {
            addCriterion("industry is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryEqualTo(String value) {
            addCriterion("industry =", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotEqualTo(String value) {
            addCriterion("industry <>", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThan(String value) {
            addCriterion("industry >", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("industry >=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThan(String value) {
            addCriterion("industry <", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThanOrEqualTo(String value) {
            addCriterion("industry <=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLike(String value) {
            addCriterion("industry like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotLike(String value) {
            addCriterion("industry not like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryIn(List<String> values) {
            addCriterion("industry in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotIn(List<String> values) {
            addCriterion("industry not in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryBetween(String value1, String value2) {
            addCriterion("industry between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotBetween(String value1, String value2) {
            addCriterion("industry not between", value1, value2, "industry");
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

        public Criteria andProNameIsNull() {
            addCriterion("pro_name is null");
            return (Criteria) this;
        }

        public Criteria andProNameIsNotNull() {
            addCriterion("pro_name is not null");
            return (Criteria) this;
        }

        public Criteria andProNameEqualTo(String value) {
            addCriterion("pro_name =", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotEqualTo(String value) {
            addCriterion("pro_name <>", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThan(String value) {
            addCriterion("pro_name >", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThanOrEqualTo(String value) {
            addCriterion("pro_name >=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThan(String value) {
            addCriterion("pro_name <", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThanOrEqualTo(String value) {
            addCriterion("pro_name <=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLike(String value) {
            addCriterion("pro_name like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotLike(String value) {
            addCriterion("pro_name not like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameIn(List<String> values) {
            addCriterion("pro_name in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotIn(List<String> values) {
            addCriterion("pro_name not in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameBetween(String value1, String value2) {
            addCriterion("pro_name between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotBetween(String value1, String value2) {
            addCriterion("pro_name not between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCustomerIsNull() {
            addCriterion("customer is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIsNotNull() {
            addCriterion("customer is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerEqualTo(String value) {
            addCriterion("customer =", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerNotEqualTo(String value) {
            addCriterion("customer <>", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerGreaterThan(String value) {
            addCriterion("customer >", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerGreaterThanOrEqualTo(String value) {
            addCriterion("customer >=", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerLessThan(String value) {
            addCriterion("customer <", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerLessThanOrEqualTo(String value) {
            addCriterion("customer <=", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerLike(String value) {
            addCriterion("customer like", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerNotLike(String value) {
            addCriterion("customer not like", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerIn(List<String> values) {
            addCriterion("customer in", values, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerNotIn(List<String> values) {
            addCriterion("customer not in", values, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerBetween(String value1, String value2) {
            addCriterion("customer between", value1, value2, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerNotBetween(String value1, String value2) {
            addCriterion("customer not between", value1, value2, "customer");
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

        public Criteria andNeedNumEqualTo(String value) {
            addCriterion("need_num =", value, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumNotEqualTo(String value) {
            addCriterion("need_num <>", value, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumGreaterThan(String value) {
            addCriterion("need_num >", value, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumGreaterThanOrEqualTo(String value) {
            addCriterion("need_num >=", value, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumLessThan(String value) {
            addCriterion("need_num <", value, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumLessThanOrEqualTo(String value) {
            addCriterion("need_num <=", value, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumLike(String value) {
            addCriterion("need_num like", value, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumNotLike(String value) {
            addCriterion("need_num not like", value, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumIn(List<String> values) {
            addCriterion("need_num in", values, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumNotIn(List<String> values) {
            addCriterion("need_num not in", values, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumBetween(String value1, String value2) {
            addCriterion("need_num between", value1, value2, "needNum");
            return (Criteria) this;
        }

        public Criteria andNeedNumNotBetween(String value1, String value2) {
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

        public Criteria andAfterResultIsNull() {
            addCriterion("after_result is null");
            return (Criteria) this;
        }

        public Criteria andAfterResultIsNotNull() {
            addCriterion("after_result is not null");
            return (Criteria) this;
        }

        public Criteria andAfterResultEqualTo(String value) {
            addCriterion("after_result =", value, "afterResult");
            return (Criteria) this;
        }

        public Criteria andAfterResultNotEqualTo(String value) {
            addCriterion("after_result <>", value, "afterResult");
            return (Criteria) this;
        }

        public Criteria andAfterResultGreaterThan(String value) {
            addCriterion("after_result >", value, "afterResult");
            return (Criteria) this;
        }

        public Criteria andAfterResultGreaterThanOrEqualTo(String value) {
            addCriterion("after_result >=", value, "afterResult");
            return (Criteria) this;
        }

        public Criteria andAfterResultLessThan(String value) {
            addCriterion("after_result <", value, "afterResult");
            return (Criteria) this;
        }

        public Criteria andAfterResultLessThanOrEqualTo(String value) {
            addCriterion("after_result <=", value, "afterResult");
            return (Criteria) this;
        }

        public Criteria andAfterResultLike(String value) {
            addCriterion("after_result like", value, "afterResult");
            return (Criteria) this;
        }

        public Criteria andAfterResultNotLike(String value) {
            addCriterion("after_result not like", value, "afterResult");
            return (Criteria) this;
        }

        public Criteria andAfterResultIn(List<String> values) {
            addCriterion("after_result in", values, "afterResult");
            return (Criteria) this;
        }

        public Criteria andAfterResultNotIn(List<String> values) {
            addCriterion("after_result not in", values, "afterResult");
            return (Criteria) this;
        }

        public Criteria andAfterResultBetween(String value1, String value2) {
            addCriterion("after_result between", value1, value2, "afterResult");
            return (Criteria) this;
        }

        public Criteria andAfterResultNotBetween(String value1, String value2) {
            addCriterion("after_result not between", value1, value2, "afterResult");
            return (Criteria) this;
        }

        public Criteria andAfterPriceIsNull() {
            addCriterion("after_price is null");
            return (Criteria) this;
        }

        public Criteria andAfterPriceIsNotNull() {
            addCriterion("after_price is not null");
            return (Criteria) this;
        }

        public Criteria andAfterPriceEqualTo(String value) {
            addCriterion("after_price =", value, "afterPrice");
            return (Criteria) this;
        }

        public Criteria andAfterPriceNotEqualTo(String value) {
            addCriterion("after_price <>", value, "afterPrice");
            return (Criteria) this;
        }

        public Criteria andAfterPriceGreaterThan(String value) {
            addCriterion("after_price >", value, "afterPrice");
            return (Criteria) this;
        }

        public Criteria andAfterPriceGreaterThanOrEqualTo(String value) {
            addCriterion("after_price >=", value, "afterPrice");
            return (Criteria) this;
        }

        public Criteria andAfterPriceLessThan(String value) {
            addCriterion("after_price <", value, "afterPrice");
            return (Criteria) this;
        }

        public Criteria andAfterPriceLessThanOrEqualTo(String value) {
            addCriterion("after_price <=", value, "afterPrice");
            return (Criteria) this;
        }

        public Criteria andAfterPriceLike(String value) {
            addCriterion("after_price like", value, "afterPrice");
            return (Criteria) this;
        }

        public Criteria andAfterPriceNotLike(String value) {
            addCriterion("after_price not like", value, "afterPrice");
            return (Criteria) this;
        }

        public Criteria andAfterPriceIn(List<String> values) {
            addCriterion("after_price in", values, "afterPrice");
            return (Criteria) this;
        }

        public Criteria andAfterPriceNotIn(List<String> values) {
            addCriterion("after_price not in", values, "afterPrice");
            return (Criteria) this;
        }

        public Criteria andAfterPriceBetween(String value1, String value2) {
            addCriterion("after_price between", value1, value2, "afterPrice");
            return (Criteria) this;
        }

        public Criteria andAfterPriceNotBetween(String value1, String value2) {
            addCriterion("after_price not between", value1, value2, "afterPrice");
            return (Criteria) this;
        }

        public Criteria andAfterReasonIsNull() {
            addCriterion("after_reason is null");
            return (Criteria) this;
        }

        public Criteria andAfterReasonIsNotNull() {
            addCriterion("after_reason is not null");
            return (Criteria) this;
        }

        public Criteria andAfterReasonEqualTo(String value) {
            addCriterion("after_reason =", value, "afterReason");
            return (Criteria) this;
        }

        public Criteria andAfterReasonNotEqualTo(String value) {
            addCriterion("after_reason <>", value, "afterReason");
            return (Criteria) this;
        }

        public Criteria andAfterReasonGreaterThan(String value) {
            addCriterion("after_reason >", value, "afterReason");
            return (Criteria) this;
        }

        public Criteria andAfterReasonGreaterThanOrEqualTo(String value) {
            addCriterion("after_reason >=", value, "afterReason");
            return (Criteria) this;
        }

        public Criteria andAfterReasonLessThan(String value) {
            addCriterion("after_reason <", value, "afterReason");
            return (Criteria) this;
        }

        public Criteria andAfterReasonLessThanOrEqualTo(String value) {
            addCriterion("after_reason <=", value, "afterReason");
            return (Criteria) this;
        }

        public Criteria andAfterReasonLike(String value) {
            addCriterion("after_reason like", value, "afterReason");
            return (Criteria) this;
        }

        public Criteria andAfterReasonNotLike(String value) {
            addCriterion("after_reason not like", value, "afterReason");
            return (Criteria) this;
        }

        public Criteria andAfterReasonIn(List<String> values) {
            addCriterion("after_reason in", values, "afterReason");
            return (Criteria) this;
        }

        public Criteria andAfterReasonNotIn(List<String> values) {
            addCriterion("after_reason not in", values, "afterReason");
            return (Criteria) this;
        }

        public Criteria andAfterReasonBetween(String value1, String value2) {
            addCriterion("after_reason between", value1, value2, "afterReason");
            return (Criteria) this;
        }

        public Criteria andAfterReasonNotBetween(String value1, String value2) {
            addCriterion("after_reason not between", value1, value2, "afterReason");
            return (Criteria) this;
        }

        public Criteria andAfterCompanyIsNull() {
            addCriterion("after_company is null");
            return (Criteria) this;
        }

        public Criteria andAfterCompanyIsNotNull() {
            addCriterion("after_company is not null");
            return (Criteria) this;
        }

        public Criteria andAfterCompanyEqualTo(String value) {
            addCriterion("after_company =", value, "afterCompany");
            return (Criteria) this;
        }

        public Criteria andAfterCompanyNotEqualTo(String value) {
            addCriterion("after_company <>", value, "afterCompany");
            return (Criteria) this;
        }

        public Criteria andAfterCompanyGreaterThan(String value) {
            addCriterion("after_company >", value, "afterCompany");
            return (Criteria) this;
        }

        public Criteria andAfterCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("after_company >=", value, "afterCompany");
            return (Criteria) this;
        }

        public Criteria andAfterCompanyLessThan(String value) {
            addCriterion("after_company <", value, "afterCompany");
            return (Criteria) this;
        }

        public Criteria andAfterCompanyLessThanOrEqualTo(String value) {
            addCriterion("after_company <=", value, "afterCompany");
            return (Criteria) this;
        }

        public Criteria andAfterCompanyLike(String value) {
            addCriterion("after_company like", value, "afterCompany");
            return (Criteria) this;
        }

        public Criteria andAfterCompanyNotLike(String value) {
            addCriterion("after_company not like", value, "afterCompany");
            return (Criteria) this;
        }

        public Criteria andAfterCompanyIn(List<String> values) {
            addCriterion("after_company in", values, "afterCompany");
            return (Criteria) this;
        }

        public Criteria andAfterCompanyNotIn(List<String> values) {
            addCriterion("after_company not in", values, "afterCompany");
            return (Criteria) this;
        }

        public Criteria andAfterCompanyBetween(String value1, String value2) {
            addCriterion("after_company between", value1, value2, "afterCompany");
            return (Criteria) this;
        }

        public Criteria andAfterCompanyNotBetween(String value1, String value2) {
            addCriterion("after_company not between", value1, value2, "afterCompany");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(String value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(String value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(String value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(String value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(String value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(String value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLike(String value) {
            addCriterion("price like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotLike(String value) {
            addCriterion("price not like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<String> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<String> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(String value1, String value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(String value1, String value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andCanNotReasonIsNull() {
            addCriterion("can_not_reason is null");
            return (Criteria) this;
        }

        public Criteria andCanNotReasonIsNotNull() {
            addCriterion("can_not_reason is not null");
            return (Criteria) this;
        }

        public Criteria andCanNotReasonEqualTo(String value) {
            addCriterion("can_not_reason =", value, "canNotReason");
            return (Criteria) this;
        }

        public Criteria andCanNotReasonNotEqualTo(String value) {
            addCriterion("can_not_reason <>", value, "canNotReason");
            return (Criteria) this;
        }

        public Criteria andCanNotReasonGreaterThan(String value) {
            addCriterion("can_not_reason >", value, "canNotReason");
            return (Criteria) this;
        }

        public Criteria andCanNotReasonGreaterThanOrEqualTo(String value) {
            addCriterion("can_not_reason >=", value, "canNotReason");
            return (Criteria) this;
        }

        public Criteria andCanNotReasonLessThan(String value) {
            addCriterion("can_not_reason <", value, "canNotReason");
            return (Criteria) this;
        }

        public Criteria andCanNotReasonLessThanOrEqualTo(String value) {
            addCriterion("can_not_reason <=", value, "canNotReason");
            return (Criteria) this;
        }

        public Criteria andCanNotReasonLike(String value) {
            addCriterion("can_not_reason like", value, "canNotReason");
            return (Criteria) this;
        }

        public Criteria andCanNotReasonNotLike(String value) {
            addCriterion("can_not_reason not like", value, "canNotReason");
            return (Criteria) this;
        }

        public Criteria andCanNotReasonIn(List<String> values) {
            addCriterion("can_not_reason in", values, "canNotReason");
            return (Criteria) this;
        }

        public Criteria andCanNotReasonNotIn(List<String> values) {
            addCriterion("can_not_reason not in", values, "canNotReason");
            return (Criteria) this;
        }

        public Criteria andCanNotReasonBetween(String value1, String value2) {
            addCriterion("can_not_reason between", value1, value2, "canNotReason");
            return (Criteria) this;
        }

        public Criteria andCanNotReasonNotBetween(String value1, String value2) {
            addCriterion("can_not_reason not between", value1, value2, "canNotReason");
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