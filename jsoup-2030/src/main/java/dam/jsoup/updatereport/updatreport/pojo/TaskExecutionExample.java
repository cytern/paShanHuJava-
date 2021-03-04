package dam.jsoup.updatereport.updatreport.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskExecutionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskExecutionExample() {
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

        public Criteria andTaskExecutionIdIsNull() {
            addCriterion("TASK_EXECUTION_ID is null");
            return (Criteria) this;
        }

        public Criteria andTaskExecutionIdIsNotNull() {
            addCriterion("TASK_EXECUTION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTaskExecutionIdEqualTo(Long value) {
            addCriterion("TASK_EXECUTION_ID =", value, "taskExecutionId");
            return (Criteria) this;
        }

        public Criteria andTaskExecutionIdNotEqualTo(Long value) {
            addCriterion("TASK_EXECUTION_ID <>", value, "taskExecutionId");
            return (Criteria) this;
        }

        public Criteria andTaskExecutionIdGreaterThan(Long value) {
            addCriterion("TASK_EXECUTION_ID >", value, "taskExecutionId");
            return (Criteria) this;
        }

        public Criteria andTaskExecutionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("TASK_EXECUTION_ID >=", value, "taskExecutionId");
            return (Criteria) this;
        }

        public Criteria andTaskExecutionIdLessThan(Long value) {
            addCriterion("TASK_EXECUTION_ID <", value, "taskExecutionId");
            return (Criteria) this;
        }

        public Criteria andTaskExecutionIdLessThanOrEqualTo(Long value) {
            addCriterion("TASK_EXECUTION_ID <=", value, "taskExecutionId");
            return (Criteria) this;
        }

        public Criteria andTaskExecutionIdIn(List<Long> values) {
            addCriterion("TASK_EXECUTION_ID in", values, "taskExecutionId");
            return (Criteria) this;
        }

        public Criteria andTaskExecutionIdNotIn(List<Long> values) {
            addCriterion("TASK_EXECUTION_ID not in", values, "taskExecutionId");
            return (Criteria) this;
        }

        public Criteria andTaskExecutionIdBetween(Long value1, Long value2) {
            addCriterion("TASK_EXECUTION_ID between", value1, value2, "taskExecutionId");
            return (Criteria) this;
        }

        public Criteria andTaskExecutionIdNotBetween(Long value1, Long value2) {
            addCriterion("TASK_EXECUTION_ID not between", value1, value2, "taskExecutionId");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNull() {
            addCriterion("TASK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("TASK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("TASK_NAME =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("TASK_NAME <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("TASK_NAME >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_NAME >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("TASK_NAME <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("TASK_NAME <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("TASK_NAME like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("TASK_NAME not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("TASK_NAME in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("TASK_NAME not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("TASK_NAME between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("TASK_NAME not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andExitCodeIsNull() {
            addCriterion("EXIT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andExitCodeIsNotNull() {
            addCriterion("EXIT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andExitCodeEqualTo(Integer value) {
            addCriterion("EXIT_CODE =", value, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeNotEqualTo(Integer value) {
            addCriterion("EXIT_CODE <>", value, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeGreaterThan(Integer value) {
            addCriterion("EXIT_CODE >", value, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXIT_CODE >=", value, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeLessThan(Integer value) {
            addCriterion("EXIT_CODE <", value, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeLessThanOrEqualTo(Integer value) {
            addCriterion("EXIT_CODE <=", value, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeIn(List<Integer> values) {
            addCriterion("EXIT_CODE in", values, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeNotIn(List<Integer> values) {
            addCriterion("EXIT_CODE not in", values, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeBetween(Integer value1, Integer value2) {
            addCriterion("EXIT_CODE between", value1, value2, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("EXIT_CODE not between", value1, value2, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitMessageIsNull() {
            addCriterion("EXIT_MESSAGE is null");
            return (Criteria) this;
        }

        public Criteria andExitMessageIsNotNull() {
            addCriterion("EXIT_MESSAGE is not null");
            return (Criteria) this;
        }

        public Criteria andExitMessageEqualTo(String value) {
            addCriterion("EXIT_MESSAGE =", value, "exitMessage");
            return (Criteria) this;
        }

        public Criteria andExitMessageNotEqualTo(String value) {
            addCriterion("EXIT_MESSAGE <>", value, "exitMessage");
            return (Criteria) this;
        }

        public Criteria andExitMessageGreaterThan(String value) {
            addCriterion("EXIT_MESSAGE >", value, "exitMessage");
            return (Criteria) this;
        }

        public Criteria andExitMessageGreaterThanOrEqualTo(String value) {
            addCriterion("EXIT_MESSAGE >=", value, "exitMessage");
            return (Criteria) this;
        }

        public Criteria andExitMessageLessThan(String value) {
            addCriterion("EXIT_MESSAGE <", value, "exitMessage");
            return (Criteria) this;
        }

        public Criteria andExitMessageLessThanOrEqualTo(String value) {
            addCriterion("EXIT_MESSAGE <=", value, "exitMessage");
            return (Criteria) this;
        }

        public Criteria andExitMessageLike(String value) {
            addCriterion("EXIT_MESSAGE like", value, "exitMessage");
            return (Criteria) this;
        }

        public Criteria andExitMessageNotLike(String value) {
            addCriterion("EXIT_MESSAGE not like", value, "exitMessage");
            return (Criteria) this;
        }

        public Criteria andExitMessageIn(List<String> values) {
            addCriterion("EXIT_MESSAGE in", values, "exitMessage");
            return (Criteria) this;
        }

        public Criteria andExitMessageNotIn(List<String> values) {
            addCriterion("EXIT_MESSAGE not in", values, "exitMessage");
            return (Criteria) this;
        }

        public Criteria andExitMessageBetween(String value1, String value2) {
            addCriterion("EXIT_MESSAGE between", value1, value2, "exitMessage");
            return (Criteria) this;
        }

        public Criteria andExitMessageNotBetween(String value1, String value2) {
            addCriterion("EXIT_MESSAGE not between", value1, value2, "exitMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageIsNull() {
            addCriterion("ERROR_MESSAGE is null");
            return (Criteria) this;
        }

        public Criteria andErrorMessageIsNotNull() {
            addCriterion("ERROR_MESSAGE is not null");
            return (Criteria) this;
        }

        public Criteria andErrorMessageEqualTo(String value) {
            addCriterion("ERROR_MESSAGE =", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageNotEqualTo(String value) {
            addCriterion("ERROR_MESSAGE <>", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageGreaterThan(String value) {
            addCriterion("ERROR_MESSAGE >", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageGreaterThanOrEqualTo(String value) {
            addCriterion("ERROR_MESSAGE >=", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageLessThan(String value) {
            addCriterion("ERROR_MESSAGE <", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageLessThanOrEqualTo(String value) {
            addCriterion("ERROR_MESSAGE <=", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageLike(String value) {
            addCriterion("ERROR_MESSAGE like", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageNotLike(String value) {
            addCriterion("ERROR_MESSAGE not like", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageIn(List<String> values) {
            addCriterion("ERROR_MESSAGE in", values, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageNotIn(List<String> values) {
            addCriterion("ERROR_MESSAGE not in", values, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageBetween(String value1, String value2) {
            addCriterion("ERROR_MESSAGE between", value1, value2, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageNotBetween(String value1, String value2) {
            addCriterion("ERROR_MESSAGE not between", value1, value2, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedIsNull() {
            addCriterion("LAST_UPDATED is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedIsNotNull() {
            addCriterion("LAST_UPDATED is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedEqualTo(Date value) {
            addCriterion("LAST_UPDATED =", value, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedNotEqualTo(Date value) {
            addCriterion("LAST_UPDATED <>", value, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedGreaterThan(Date value) {
            addCriterion("LAST_UPDATED >", value, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_UPDATED >=", value, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedLessThan(Date value) {
            addCriterion("LAST_UPDATED <", value, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("LAST_UPDATED <=", value, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedIn(List<Date> values) {
            addCriterion("LAST_UPDATED in", values, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedNotIn(List<Date> values) {
            addCriterion("LAST_UPDATED not in", values, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedBetween(Date value1, Date value2) {
            addCriterion("LAST_UPDATED between", value1, value2, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("LAST_UPDATED not between", value1, value2, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andExternalExecutionIdIsNull() {
            addCriterion("EXTERNAL_EXECUTION_ID is null");
            return (Criteria) this;
        }

        public Criteria andExternalExecutionIdIsNotNull() {
            addCriterion("EXTERNAL_EXECUTION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andExternalExecutionIdEqualTo(String value) {
            addCriterion("EXTERNAL_EXECUTION_ID =", value, "externalExecutionId");
            return (Criteria) this;
        }

        public Criteria andExternalExecutionIdNotEqualTo(String value) {
            addCriterion("EXTERNAL_EXECUTION_ID <>", value, "externalExecutionId");
            return (Criteria) this;
        }

        public Criteria andExternalExecutionIdGreaterThan(String value) {
            addCriterion("EXTERNAL_EXECUTION_ID >", value, "externalExecutionId");
            return (Criteria) this;
        }

        public Criteria andExternalExecutionIdGreaterThanOrEqualTo(String value) {
            addCriterion("EXTERNAL_EXECUTION_ID >=", value, "externalExecutionId");
            return (Criteria) this;
        }

        public Criteria andExternalExecutionIdLessThan(String value) {
            addCriterion("EXTERNAL_EXECUTION_ID <", value, "externalExecutionId");
            return (Criteria) this;
        }

        public Criteria andExternalExecutionIdLessThanOrEqualTo(String value) {
            addCriterion("EXTERNAL_EXECUTION_ID <=", value, "externalExecutionId");
            return (Criteria) this;
        }

        public Criteria andExternalExecutionIdLike(String value) {
            addCriterion("EXTERNAL_EXECUTION_ID like", value, "externalExecutionId");
            return (Criteria) this;
        }

        public Criteria andExternalExecutionIdNotLike(String value) {
            addCriterion("EXTERNAL_EXECUTION_ID not like", value, "externalExecutionId");
            return (Criteria) this;
        }

        public Criteria andExternalExecutionIdIn(List<String> values) {
            addCriterion("EXTERNAL_EXECUTION_ID in", values, "externalExecutionId");
            return (Criteria) this;
        }

        public Criteria andExternalExecutionIdNotIn(List<String> values) {
            addCriterion("EXTERNAL_EXECUTION_ID not in", values, "externalExecutionId");
            return (Criteria) this;
        }

        public Criteria andExternalExecutionIdBetween(String value1, String value2) {
            addCriterion("EXTERNAL_EXECUTION_ID between", value1, value2, "externalExecutionId");
            return (Criteria) this;
        }

        public Criteria andExternalExecutionIdNotBetween(String value1, String value2) {
            addCriterion("EXTERNAL_EXECUTION_ID not between", value1, value2, "externalExecutionId");
            return (Criteria) this;
        }

        public Criteria andParentExecutionIdIsNull() {
            addCriterion("PARENT_EXECUTION_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentExecutionIdIsNotNull() {
            addCriterion("PARENT_EXECUTION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentExecutionIdEqualTo(Long value) {
            addCriterion("PARENT_EXECUTION_ID =", value, "parentExecutionId");
            return (Criteria) this;
        }

        public Criteria andParentExecutionIdNotEqualTo(Long value) {
            addCriterion("PARENT_EXECUTION_ID <>", value, "parentExecutionId");
            return (Criteria) this;
        }

        public Criteria andParentExecutionIdGreaterThan(Long value) {
            addCriterion("PARENT_EXECUTION_ID >", value, "parentExecutionId");
            return (Criteria) this;
        }

        public Criteria andParentExecutionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PARENT_EXECUTION_ID >=", value, "parentExecutionId");
            return (Criteria) this;
        }

        public Criteria andParentExecutionIdLessThan(Long value) {
            addCriterion("PARENT_EXECUTION_ID <", value, "parentExecutionId");
            return (Criteria) this;
        }

        public Criteria andParentExecutionIdLessThanOrEqualTo(Long value) {
            addCriterion("PARENT_EXECUTION_ID <=", value, "parentExecutionId");
            return (Criteria) this;
        }

        public Criteria andParentExecutionIdIn(List<Long> values) {
            addCriterion("PARENT_EXECUTION_ID in", values, "parentExecutionId");
            return (Criteria) this;
        }

        public Criteria andParentExecutionIdNotIn(List<Long> values) {
            addCriterion("PARENT_EXECUTION_ID not in", values, "parentExecutionId");
            return (Criteria) this;
        }

        public Criteria andParentExecutionIdBetween(Long value1, Long value2) {
            addCriterion("PARENT_EXECUTION_ID between", value1, value2, "parentExecutionId");
            return (Criteria) this;
        }

        public Criteria andParentExecutionIdNotBetween(Long value1, Long value2) {
            addCriterion("PARENT_EXECUTION_ID not between", value1, value2, "parentExecutionId");
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