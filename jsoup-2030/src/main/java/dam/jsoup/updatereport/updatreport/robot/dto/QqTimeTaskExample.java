package dam.jsoup.updatereport.updatreport.robot.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QqTimeTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QqTimeTaskExample() {
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

        public Criteria andMarkIsNull() {
            addCriterion("mark is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("mark is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(String value) {
            addCriterion("mark =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(String value) {
            addCriterion("mark <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(String value) {
            addCriterion("mark >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(String value) {
            addCriterion("mark >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(String value) {
            addCriterion("mark <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(String value) {
            addCriterion("mark <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLike(String value) {
            addCriterion("mark like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotLike(String value) {
            addCriterion("mark not like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<String> values) {
            addCriterion("mark in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<String> values) {
            addCriterion("mark not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(String value1, String value2) {
            addCriterion("mark between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(String value1, String value2) {
            addCriterion("mark not between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andTargetTypeIsNull() {
            addCriterion("target_type is null");
            return (Criteria) this;
        }

        public Criteria andTargetTypeIsNotNull() {
            addCriterion("target_type is not null");
            return (Criteria) this;
        }

        public Criteria andTargetTypeEqualTo(Integer value) {
            addCriterion("target_type =", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotEqualTo(Integer value) {
            addCriterion("target_type <>", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeGreaterThan(Integer value) {
            addCriterion("target_type >", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("target_type >=", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeLessThan(Integer value) {
            addCriterion("target_type <", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeLessThanOrEqualTo(Integer value) {
            addCriterion("target_type <=", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeIn(List<Integer> values) {
            addCriterion("target_type in", values, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotIn(List<Integer> values) {
            addCriterion("target_type not in", values, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeBetween(Integer value1, Integer value2) {
            addCriterion("target_type between", value1, value2, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("target_type not between", value1, value2, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetIdIsNull() {
            addCriterion("target_id is null");
            return (Criteria) this;
        }

        public Criteria andTargetIdIsNotNull() {
            addCriterion("target_id is not null");
            return (Criteria) this;
        }

        public Criteria andTargetIdEqualTo(String value) {
            addCriterion("target_id =", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotEqualTo(String value) {
            addCriterion("target_id <>", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdGreaterThan(String value) {
            addCriterion("target_id >", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdGreaterThanOrEqualTo(String value) {
            addCriterion("target_id >=", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdLessThan(String value) {
            addCriterion("target_id <", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdLessThanOrEqualTo(String value) {
            addCriterion("target_id <=", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdLike(String value) {
            addCriterion("target_id like", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotLike(String value) {
            addCriterion("target_id not like", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdIn(List<String> values) {
            addCriterion("target_id in", values, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotIn(List<String> values) {
            addCriterion("target_id not in", values, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdBetween(String value1, String value2) {
            addCriterion("target_id between", value1, value2, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotBetween(String value1, String value2) {
            addCriterion("target_id not between", value1, value2, "targetId");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andCronIsNull() {
            addCriterion("cron is null");
            return (Criteria) this;
        }

        public Criteria andCronIsNotNull() {
            addCriterion("cron is not null");
            return (Criteria) this;
        }

        public Criteria andCronEqualTo(String value) {
            addCriterion("cron =", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronNotEqualTo(String value) {
            addCriterion("cron <>", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronGreaterThan(String value) {
            addCriterion("cron >", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronGreaterThanOrEqualTo(String value) {
            addCriterion("cron >=", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronLessThan(String value) {
            addCriterion("cron <", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronLessThanOrEqualTo(String value) {
            addCriterion("cron <=", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronLike(String value) {
            addCriterion("cron like", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronNotLike(String value) {
            addCriterion("cron not like", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronIn(List<String> values) {
            addCriterion("cron in", values, "cron");
            return (Criteria) this;
        }

        public Criteria andCronNotIn(List<String> values) {
            addCriterion("cron not in", values, "cron");
            return (Criteria) this;
        }

        public Criteria andCronBetween(String value1, String value2) {
            addCriterion("cron between", value1, value2, "cron");
            return (Criteria) this;
        }

        public Criteria andCronNotBetween(String value1, String value2) {
            addCriterion("cron not between", value1, value2, "cron");
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

        public Criteria andCycleTypeIsNull() {
            addCriterion("cycle_type is null");
            return (Criteria) this;
        }

        public Criteria andCycleTypeIsNotNull() {
            addCriterion("cycle_type is not null");
            return (Criteria) this;
        }

        public Criteria andCycleTypeEqualTo(Integer value) {
            addCriterion("cycle_type =", value, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeNotEqualTo(Integer value) {
            addCriterion("cycle_type <>", value, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeGreaterThan(Integer value) {
            addCriterion("cycle_type >", value, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("cycle_type >=", value, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeLessThan(Integer value) {
            addCriterion("cycle_type <", value, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeLessThanOrEqualTo(Integer value) {
            addCriterion("cycle_type <=", value, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeIn(List<Integer> values) {
            addCriterion("cycle_type in", values, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeNotIn(List<Integer> values) {
            addCriterion("cycle_type not in", values, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeBetween(Integer value1, Integer value2) {
            addCriterion("cycle_type between", value1, value2, "cycleType");
            return (Criteria) this;
        }

        public Criteria andCycleTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("cycle_type not between", value1, value2, "cycleType");
            return (Criteria) this;
        }

        public Criteria andTimesIsNull() {
            addCriterion("times is null");
            return (Criteria) this;
        }

        public Criteria andTimesIsNotNull() {
            addCriterion("times is not null");
            return (Criteria) this;
        }

        public Criteria andTimesEqualTo(Integer value) {
            addCriterion("times =", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotEqualTo(Integer value) {
            addCriterion("times <>", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesGreaterThan(Integer value) {
            addCriterion("times >", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("times >=", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLessThan(Integer value) {
            addCriterion("times <", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLessThanOrEqualTo(Integer value) {
            addCriterion("times <=", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesIn(List<Integer> values) {
            addCriterion("times in", values, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotIn(List<Integer> values) {
            addCriterion("times not in", values, "times");
            return (Criteria) this;
        }

        public Criteria andTimesBetween(Integer value1, Integer value2) {
            addCriterion("times between", value1, value2, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("times not between", value1, value2, "times");
            return (Criteria) this;
        }

        public Criteria andCommandIsNull() {
            addCriterion("command is null");
            return (Criteria) this;
        }

        public Criteria andCommandIsNotNull() {
            addCriterion("command is not null");
            return (Criteria) this;
        }

        public Criteria andCommandEqualTo(String value) {
            addCriterion("command =", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandNotEqualTo(String value) {
            addCriterion("command <>", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandGreaterThan(String value) {
            addCriterion("command >", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandGreaterThanOrEqualTo(String value) {
            addCriterion("command >=", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandLessThan(String value) {
            addCriterion("command <", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandLessThanOrEqualTo(String value) {
            addCriterion("command <=", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandLike(String value) {
            addCriterion("command like", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandNotLike(String value) {
            addCriterion("command not like", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandIn(List<String> values) {
            addCriterion("command in", values, "command");
            return (Criteria) this;
        }

        public Criteria andCommandNotIn(List<String> values) {
            addCriterion("command not in", values, "command");
            return (Criteria) this;
        }

        public Criteria andCommandBetween(String value1, String value2) {
            addCriterion("command between", value1, value2, "command");
            return (Criteria) this;
        }

        public Criteria andCommandNotBetween(String value1, String value2) {
            addCriterion("command not between", value1, value2, "command");
            return (Criteria) this;
        }

        public Criteria andTargetGroupIdIsNull() {
            addCriterion("target_group_id is null");
            return (Criteria) this;
        }

        public Criteria andTargetGroupIdIsNotNull() {
            addCriterion("target_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andTargetGroupIdEqualTo(String value) {
            addCriterion("target_group_id =", value, "targetGroupId");
            return (Criteria) this;
        }

        public Criteria andTargetGroupIdNotEqualTo(String value) {
            addCriterion("target_group_id <>", value, "targetGroupId");
            return (Criteria) this;
        }

        public Criteria andTargetGroupIdGreaterThan(String value) {
            addCriterion("target_group_id >", value, "targetGroupId");
            return (Criteria) this;
        }

        public Criteria andTargetGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("target_group_id >=", value, "targetGroupId");
            return (Criteria) this;
        }

        public Criteria andTargetGroupIdLessThan(String value) {
            addCriterion("target_group_id <", value, "targetGroupId");
            return (Criteria) this;
        }

        public Criteria andTargetGroupIdLessThanOrEqualTo(String value) {
            addCriterion("target_group_id <=", value, "targetGroupId");
            return (Criteria) this;
        }

        public Criteria andTargetGroupIdLike(String value) {
            addCriterion("target_group_id like", value, "targetGroupId");
            return (Criteria) this;
        }

        public Criteria andTargetGroupIdNotLike(String value) {
            addCriterion("target_group_id not like", value, "targetGroupId");
            return (Criteria) this;
        }

        public Criteria andTargetGroupIdIn(List<String> values) {
            addCriterion("target_group_id in", values, "targetGroupId");
            return (Criteria) this;
        }

        public Criteria andTargetGroupIdNotIn(List<String> values) {
            addCriterion("target_group_id not in", values, "targetGroupId");
            return (Criteria) this;
        }

        public Criteria andTargetGroupIdBetween(String value1, String value2) {
            addCriterion("target_group_id between", value1, value2, "targetGroupId");
            return (Criteria) this;
        }

        public Criteria andTargetGroupIdNotBetween(String value1, String value2) {
            addCriterion("target_group_id not between", value1, value2, "targetGroupId");
            return (Criteria) this;
        }
    }

    /**
     */
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