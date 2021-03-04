package dam.jsoup.updatereport.updatreport.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JsoupMissionAllHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JsoupMissionAllHistoryExample() {
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

        public Criteria andMissionAllHistoryIdIsNull() {
            addCriterion("mission_all_history_id is null");
            return (Criteria) this;
        }

        public Criteria andMissionAllHistoryIdIsNotNull() {
            addCriterion("mission_all_history_id is not null");
            return (Criteria) this;
        }

        public Criteria andMissionAllHistoryIdEqualTo(Integer value) {
            addCriterion("mission_all_history_id =", value, "missionAllHistoryId");
            return (Criteria) this;
        }

        public Criteria andMissionAllHistoryIdNotEqualTo(Integer value) {
            addCriterion("mission_all_history_id <>", value, "missionAllHistoryId");
            return (Criteria) this;
        }

        public Criteria andMissionAllHistoryIdGreaterThan(Integer value) {
            addCriterion("mission_all_history_id >", value, "missionAllHistoryId");
            return (Criteria) this;
        }

        public Criteria andMissionAllHistoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mission_all_history_id >=", value, "missionAllHistoryId");
            return (Criteria) this;
        }

        public Criteria andMissionAllHistoryIdLessThan(Integer value) {
            addCriterion("mission_all_history_id <", value, "missionAllHistoryId");
            return (Criteria) this;
        }

        public Criteria andMissionAllHistoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("mission_all_history_id <=", value, "missionAllHistoryId");
            return (Criteria) this;
        }

        public Criteria andMissionAllHistoryIdIn(List<Integer> values) {
            addCriterion("mission_all_history_id in", values, "missionAllHistoryId");
            return (Criteria) this;
        }

        public Criteria andMissionAllHistoryIdNotIn(List<Integer> values) {
            addCriterion("mission_all_history_id not in", values, "missionAllHistoryId");
            return (Criteria) this;
        }

        public Criteria andMissionAllHistoryIdBetween(Integer value1, Integer value2) {
            addCriterion("mission_all_history_id between", value1, value2, "missionAllHistoryId");
            return (Criteria) this;
        }

        public Criteria andMissionAllHistoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mission_all_history_id not between", value1, value2, "missionAllHistoryId");
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

        public Criteria andMissionStateIsNull() {
            addCriterion("mission_state is null");
            return (Criteria) this;
        }

        public Criteria andMissionStateIsNotNull() {
            addCriterion("mission_state is not null");
            return (Criteria) this;
        }

        public Criteria andMissionStateEqualTo(String value) {
            addCriterion("mission_state =", value, "missionState");
            return (Criteria) this;
        }

        public Criteria andMissionStateNotEqualTo(String value) {
            addCriterion("mission_state <>", value, "missionState");
            return (Criteria) this;
        }

        public Criteria andMissionStateGreaterThan(String value) {
            addCriterion("mission_state >", value, "missionState");
            return (Criteria) this;
        }

        public Criteria andMissionStateGreaterThanOrEqualTo(String value) {
            addCriterion("mission_state >=", value, "missionState");
            return (Criteria) this;
        }

        public Criteria andMissionStateLessThan(String value) {
            addCriterion("mission_state <", value, "missionState");
            return (Criteria) this;
        }

        public Criteria andMissionStateLessThanOrEqualTo(String value) {
            addCriterion("mission_state <=", value, "missionState");
            return (Criteria) this;
        }

        public Criteria andMissionStateLike(String value) {
            addCriterion("mission_state like", value, "missionState");
            return (Criteria) this;
        }

        public Criteria andMissionStateNotLike(String value) {
            addCriterion("mission_state not like", value, "missionState");
            return (Criteria) this;
        }

        public Criteria andMissionStateIn(List<String> values) {
            addCriterion("mission_state in", values, "missionState");
            return (Criteria) this;
        }

        public Criteria andMissionStateNotIn(List<String> values) {
            addCriterion("mission_state not in", values, "missionState");
            return (Criteria) this;
        }

        public Criteria andMissionStateBetween(String value1, String value2) {
            addCriterion("mission_state between", value1, value2, "missionState");
            return (Criteria) this;
        }

        public Criteria andMissionStateNotBetween(String value1, String value2) {
            addCriterion("mission_state not between", value1, value2, "missionState");
            return (Criteria) this;
        }

        public Criteria andMissionResultUrlIsNull() {
            addCriterion("mission_result_url is null");
            return (Criteria) this;
        }

        public Criteria andMissionResultUrlIsNotNull() {
            addCriterion("mission_result_url is not null");
            return (Criteria) this;
        }

        public Criteria andMissionResultUrlEqualTo(String value) {
            addCriterion("mission_result_url =", value, "missionResultUrl");
            return (Criteria) this;
        }

        public Criteria andMissionResultUrlNotEqualTo(String value) {
            addCriterion("mission_result_url <>", value, "missionResultUrl");
            return (Criteria) this;
        }

        public Criteria andMissionResultUrlGreaterThan(String value) {
            addCriterion("mission_result_url >", value, "missionResultUrl");
            return (Criteria) this;
        }

        public Criteria andMissionResultUrlGreaterThanOrEqualTo(String value) {
            addCriterion("mission_result_url >=", value, "missionResultUrl");
            return (Criteria) this;
        }

        public Criteria andMissionResultUrlLessThan(String value) {
            addCriterion("mission_result_url <", value, "missionResultUrl");
            return (Criteria) this;
        }

        public Criteria andMissionResultUrlLessThanOrEqualTo(String value) {
            addCriterion("mission_result_url <=", value, "missionResultUrl");
            return (Criteria) this;
        }

        public Criteria andMissionResultUrlLike(String value) {
            addCriterion("mission_result_url like", value, "missionResultUrl");
            return (Criteria) this;
        }

        public Criteria andMissionResultUrlNotLike(String value) {
            addCriterion("mission_result_url not like", value, "missionResultUrl");
            return (Criteria) this;
        }

        public Criteria andMissionResultUrlIn(List<String> values) {
            addCriterion("mission_result_url in", values, "missionResultUrl");
            return (Criteria) this;
        }

        public Criteria andMissionResultUrlNotIn(List<String> values) {
            addCriterion("mission_result_url not in", values, "missionResultUrl");
            return (Criteria) this;
        }

        public Criteria andMissionResultUrlBetween(String value1, String value2) {
            addCriterion("mission_result_url between", value1, value2, "missionResultUrl");
            return (Criteria) this;
        }

        public Criteria andMissionResultUrlNotBetween(String value1, String value2) {
            addCriterion("mission_result_url not between", value1, value2, "missionResultUrl");
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

        public Criteria andMissionFailReasonIsNull() {
            addCriterion("mission_fail_reason is null");
            return (Criteria) this;
        }

        public Criteria andMissionFailReasonIsNotNull() {
            addCriterion("mission_fail_reason is not null");
            return (Criteria) this;
        }

        public Criteria andMissionFailReasonEqualTo(String value) {
            addCriterion("mission_fail_reason =", value, "missionFailReason");
            return (Criteria) this;
        }

        public Criteria andMissionFailReasonNotEqualTo(String value) {
            addCriterion("mission_fail_reason <>", value, "missionFailReason");
            return (Criteria) this;
        }

        public Criteria andMissionFailReasonGreaterThan(String value) {
            addCriterion("mission_fail_reason >", value, "missionFailReason");
            return (Criteria) this;
        }

        public Criteria andMissionFailReasonGreaterThanOrEqualTo(String value) {
            addCriterion("mission_fail_reason >=", value, "missionFailReason");
            return (Criteria) this;
        }

        public Criteria andMissionFailReasonLessThan(String value) {
            addCriterion("mission_fail_reason <", value, "missionFailReason");
            return (Criteria) this;
        }

        public Criteria andMissionFailReasonLessThanOrEqualTo(String value) {
            addCriterion("mission_fail_reason <=", value, "missionFailReason");
            return (Criteria) this;
        }

        public Criteria andMissionFailReasonLike(String value) {
            addCriterion("mission_fail_reason like", value, "missionFailReason");
            return (Criteria) this;
        }

        public Criteria andMissionFailReasonNotLike(String value) {
            addCriterion("mission_fail_reason not like", value, "missionFailReason");
            return (Criteria) this;
        }

        public Criteria andMissionFailReasonIn(List<String> values) {
            addCriterion("mission_fail_reason in", values, "missionFailReason");
            return (Criteria) this;
        }

        public Criteria andMissionFailReasonNotIn(List<String> values) {
            addCriterion("mission_fail_reason not in", values, "missionFailReason");
            return (Criteria) this;
        }

        public Criteria andMissionFailReasonBetween(String value1, String value2) {
            addCriterion("mission_fail_reason between", value1, value2, "missionFailReason");
            return (Criteria) this;
        }

        public Criteria andMissionFailReasonNotBetween(String value1, String value2) {
            addCriterion("mission_fail_reason not between", value1, value2, "missionFailReason");
            return (Criteria) this;
        }

        public Criteria andSentTimeIsNull() {
            addCriterion("sent_time is null");
            return (Criteria) this;
        }

        public Criteria andSentTimeIsNotNull() {
            addCriterion("sent_time is not null");
            return (Criteria) this;
        }

        public Criteria andSentTimeEqualTo(Date value) {
            addCriterion("sent_time =", value, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeNotEqualTo(Date value) {
            addCriterion("sent_time <>", value, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeGreaterThan(Date value) {
            addCriterion("sent_time >", value, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sent_time >=", value, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeLessThan(Date value) {
            addCriterion("sent_time <", value, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeLessThanOrEqualTo(Date value) {
            addCriterion("sent_time <=", value, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeIn(List<Date> values) {
            addCriterion("sent_time in", values, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeNotIn(List<Date> values) {
            addCriterion("sent_time not in", values, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeBetween(Date value1, Date value2) {
            addCriterion("sent_time between", value1, value2, "sentTime");
            return (Criteria) this;
        }

        public Criteria andSentTimeNotBetween(Date value1, Date value2) {
            addCriterion("sent_time not between", value1, value2, "sentTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNull() {
            addCriterion("finish_time is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(Date value) {
            addCriterion("finish_time =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(Date value) {
            addCriterion("finish_time <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(Date value) {
            addCriterion("finish_time >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finish_time >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(Date value) {
            addCriterion("finish_time <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("finish_time <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<Date> values) {
            addCriterion("finish_time in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<Date> values) {
            addCriterion("finish_time not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(Date value1, Date value2) {
            addCriterion("finish_time between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("finish_time not between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andMissionAllNameIsNull() {
            addCriterion("mission_all_name is null");
            return (Criteria) this;
        }

        public Criteria andMissionAllNameIsNotNull() {
            addCriterion("mission_all_name is not null");
            return (Criteria) this;
        }

        public Criteria andMissionAllNameEqualTo(String value) {
            addCriterion("mission_all_name =", value, "missionAllName");
            return (Criteria) this;
        }

        public Criteria andMissionAllNameNotEqualTo(String value) {
            addCriterion("mission_all_name <>", value, "missionAllName");
            return (Criteria) this;
        }

        public Criteria andMissionAllNameGreaterThan(String value) {
            addCriterion("mission_all_name >", value, "missionAllName");
            return (Criteria) this;
        }

        public Criteria andMissionAllNameGreaterThanOrEqualTo(String value) {
            addCriterion("mission_all_name >=", value, "missionAllName");
            return (Criteria) this;
        }

        public Criteria andMissionAllNameLessThan(String value) {
            addCriterion("mission_all_name <", value, "missionAllName");
            return (Criteria) this;
        }

        public Criteria andMissionAllNameLessThanOrEqualTo(String value) {
            addCriterion("mission_all_name <=", value, "missionAllName");
            return (Criteria) this;
        }

        public Criteria andMissionAllNameLike(String value) {
            addCriterion("mission_all_name like", value, "missionAllName");
            return (Criteria) this;
        }

        public Criteria andMissionAllNameNotLike(String value) {
            addCriterion("mission_all_name not like", value, "missionAllName");
            return (Criteria) this;
        }

        public Criteria andMissionAllNameIn(List<String> values) {
            addCriterion("mission_all_name in", values, "missionAllName");
            return (Criteria) this;
        }

        public Criteria andMissionAllNameNotIn(List<String> values) {
            addCriterion("mission_all_name not in", values, "missionAllName");
            return (Criteria) this;
        }

        public Criteria andMissionAllNameBetween(String value1, String value2) {
            addCriterion("mission_all_name between", value1, value2, "missionAllName");
            return (Criteria) this;
        }

        public Criteria andMissionAllNameNotBetween(String value1, String value2) {
            addCriterion("mission_all_name not between", value1, value2, "missionAllName");
            return (Criteria) this;
        }

        public Criteria andMissionAllDisIsNull() {
            addCriterion("mission_all_dis is null");
            return (Criteria) this;
        }

        public Criteria andMissionAllDisIsNotNull() {
            addCriterion("mission_all_dis is not null");
            return (Criteria) this;
        }

        public Criteria andMissionAllDisEqualTo(String value) {
            addCriterion("mission_all_dis =", value, "missionAllDis");
            return (Criteria) this;
        }

        public Criteria andMissionAllDisNotEqualTo(String value) {
            addCriterion("mission_all_dis <>", value, "missionAllDis");
            return (Criteria) this;
        }

        public Criteria andMissionAllDisGreaterThan(String value) {
            addCriterion("mission_all_dis >", value, "missionAllDis");
            return (Criteria) this;
        }

        public Criteria andMissionAllDisGreaterThanOrEqualTo(String value) {
            addCriterion("mission_all_dis >=", value, "missionAllDis");
            return (Criteria) this;
        }

        public Criteria andMissionAllDisLessThan(String value) {
            addCriterion("mission_all_dis <", value, "missionAllDis");
            return (Criteria) this;
        }

        public Criteria andMissionAllDisLessThanOrEqualTo(String value) {
            addCriterion("mission_all_dis <=", value, "missionAllDis");
            return (Criteria) this;
        }

        public Criteria andMissionAllDisLike(String value) {
            addCriterion("mission_all_dis like", value, "missionAllDis");
            return (Criteria) this;
        }

        public Criteria andMissionAllDisNotLike(String value) {
            addCriterion("mission_all_dis not like", value, "missionAllDis");
            return (Criteria) this;
        }

        public Criteria andMissionAllDisIn(List<String> values) {
            addCriterion("mission_all_dis in", values, "missionAllDis");
            return (Criteria) this;
        }

        public Criteria andMissionAllDisNotIn(List<String> values) {
            addCriterion("mission_all_dis not in", values, "missionAllDis");
            return (Criteria) this;
        }

        public Criteria andMissionAllDisBetween(String value1, String value2) {
            addCriterion("mission_all_dis between", value1, value2, "missionAllDis");
            return (Criteria) this;
        }

        public Criteria andMissionAllDisNotBetween(String value1, String value2) {
            addCriterion("mission_all_dis not between", value1, value2, "missionAllDis");
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