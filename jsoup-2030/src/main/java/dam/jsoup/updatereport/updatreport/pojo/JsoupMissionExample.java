package dam.jsoup.updatereport.updatreport.pojo;

import java.util.ArrayList;
import java.util.List;

public class JsoupMissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JsoupMissionExample() {
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

        public Criteria andMissionNameIsNull() {
            addCriterion("mission_name is null");
            return (Criteria) this;
        }

        public Criteria andMissionNameIsNotNull() {
            addCriterion("mission_name is not null");
            return (Criteria) this;
        }

        public Criteria andMissionNameEqualTo(String value) {
            addCriterion("mission_name =", value, "missionName");
            return (Criteria) this;
        }

        public Criteria andMissionNameNotEqualTo(String value) {
            addCriterion("mission_name <>", value, "missionName");
            return (Criteria) this;
        }

        public Criteria andMissionNameGreaterThan(String value) {
            addCriterion("mission_name >", value, "missionName");
            return (Criteria) this;
        }

        public Criteria andMissionNameGreaterThanOrEqualTo(String value) {
            addCriterion("mission_name >=", value, "missionName");
            return (Criteria) this;
        }

        public Criteria andMissionNameLessThan(String value) {
            addCriterion("mission_name <", value, "missionName");
            return (Criteria) this;
        }

        public Criteria andMissionNameLessThanOrEqualTo(String value) {
            addCriterion("mission_name <=", value, "missionName");
            return (Criteria) this;
        }

        public Criteria andMissionNameLike(String value) {
            addCriterion("mission_name like", value, "missionName");
            return (Criteria) this;
        }

        public Criteria andMissionNameNotLike(String value) {
            addCriterion("mission_name not like", value, "missionName");
            return (Criteria) this;
        }

        public Criteria andMissionNameIn(List<String> values) {
            addCriterion("mission_name in", values, "missionName");
            return (Criteria) this;
        }

        public Criteria andMissionNameNotIn(List<String> values) {
            addCriterion("mission_name not in", values, "missionName");
            return (Criteria) this;
        }

        public Criteria andMissionNameBetween(String value1, String value2) {
            addCriterion("mission_name between", value1, value2, "missionName");
            return (Criteria) this;
        }

        public Criteria andMissionNameNotBetween(String value1, String value2) {
            addCriterion("mission_name not between", value1, value2, "missionName");
            return (Criteria) this;
        }

        public Criteria andStartActionIdIsNull() {
            addCriterion("start_action_id is null");
            return (Criteria) this;
        }

        public Criteria andStartActionIdIsNotNull() {
            addCriterion("start_action_id is not null");
            return (Criteria) this;
        }

        public Criteria andStartActionIdEqualTo(Integer value) {
            addCriterion("start_action_id =", value, "startActionId");
            return (Criteria) this;
        }

        public Criteria andStartActionIdNotEqualTo(Integer value) {
            addCriterion("start_action_id <>", value, "startActionId");
            return (Criteria) this;
        }

        public Criteria andStartActionIdGreaterThan(Integer value) {
            addCriterion("start_action_id >", value, "startActionId");
            return (Criteria) this;
        }

        public Criteria andStartActionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_action_id >=", value, "startActionId");
            return (Criteria) this;
        }

        public Criteria andStartActionIdLessThan(Integer value) {
            addCriterion("start_action_id <", value, "startActionId");
            return (Criteria) this;
        }

        public Criteria andStartActionIdLessThanOrEqualTo(Integer value) {
            addCriterion("start_action_id <=", value, "startActionId");
            return (Criteria) this;
        }

        public Criteria andStartActionIdIn(List<Integer> values) {
            addCriterion("start_action_id in", values, "startActionId");
            return (Criteria) this;
        }

        public Criteria andStartActionIdNotIn(List<Integer> values) {
            addCriterion("start_action_id not in", values, "startActionId");
            return (Criteria) this;
        }

        public Criteria andStartActionIdBetween(Integer value1, Integer value2) {
            addCriterion("start_action_id between", value1, value2, "startActionId");
            return (Criteria) this;
        }

        public Criteria andStartActionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("start_action_id not between", value1, value2, "startActionId");
            return (Criteria) this;
        }

        public Criteria andNoticeEmailIsNull() {
            addCriterion("notice_email is null");
            return (Criteria) this;
        }

        public Criteria andNoticeEmailIsNotNull() {
            addCriterion("notice_email is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeEmailEqualTo(String value) {
            addCriterion("notice_email =", value, "noticeEmail");
            return (Criteria) this;
        }

        public Criteria andNoticeEmailNotEqualTo(String value) {
            addCriterion("notice_email <>", value, "noticeEmail");
            return (Criteria) this;
        }

        public Criteria andNoticeEmailGreaterThan(String value) {
            addCriterion("notice_email >", value, "noticeEmail");
            return (Criteria) this;
        }

        public Criteria andNoticeEmailGreaterThanOrEqualTo(String value) {
            addCriterion("notice_email >=", value, "noticeEmail");
            return (Criteria) this;
        }

        public Criteria andNoticeEmailLessThan(String value) {
            addCriterion("notice_email <", value, "noticeEmail");
            return (Criteria) this;
        }

        public Criteria andNoticeEmailLessThanOrEqualTo(String value) {
            addCriterion("notice_email <=", value, "noticeEmail");
            return (Criteria) this;
        }

        public Criteria andNoticeEmailLike(String value) {
            addCriterion("notice_email like", value, "noticeEmail");
            return (Criteria) this;
        }

        public Criteria andNoticeEmailNotLike(String value) {
            addCriterion("notice_email not like", value, "noticeEmail");
            return (Criteria) this;
        }

        public Criteria andNoticeEmailIn(List<String> values) {
            addCriterion("notice_email in", values, "noticeEmail");
            return (Criteria) this;
        }

        public Criteria andNoticeEmailNotIn(List<String> values) {
            addCriterion("notice_email not in", values, "noticeEmail");
            return (Criteria) this;
        }

        public Criteria andNoticeEmailBetween(String value1, String value2) {
            addCriterion("notice_email between", value1, value2, "noticeEmail");
            return (Criteria) this;
        }

        public Criteria andNoticeEmailNotBetween(String value1, String value2) {
            addCriterion("notice_email not between", value1, value2, "noticeEmail");
            return (Criteria) this;
        }

        public Criteria andEndTagContainsIsNull() {
            addCriterion("end_tag_contains is null");
            return (Criteria) this;
        }

        public Criteria andEndTagContainsIsNotNull() {
            addCriterion("end_tag_contains is not null");
            return (Criteria) this;
        }

        public Criteria andEndTagContainsEqualTo(String value) {
            addCriterion("end_tag_contains =", value, "endTagContains");
            return (Criteria) this;
        }

        public Criteria andEndTagContainsNotEqualTo(String value) {
            addCriterion("end_tag_contains <>", value, "endTagContains");
            return (Criteria) this;
        }

        public Criteria andEndTagContainsGreaterThan(String value) {
            addCriterion("end_tag_contains >", value, "endTagContains");
            return (Criteria) this;
        }

        public Criteria andEndTagContainsGreaterThanOrEqualTo(String value) {
            addCriterion("end_tag_contains >=", value, "endTagContains");
            return (Criteria) this;
        }

        public Criteria andEndTagContainsLessThan(String value) {
            addCriterion("end_tag_contains <", value, "endTagContains");
            return (Criteria) this;
        }

        public Criteria andEndTagContainsLessThanOrEqualTo(String value) {
            addCriterion("end_tag_contains <=", value, "endTagContains");
            return (Criteria) this;
        }

        public Criteria andEndTagContainsLike(String value) {
            addCriterion("end_tag_contains like", value, "endTagContains");
            return (Criteria) this;
        }

        public Criteria andEndTagContainsNotLike(String value) {
            addCriterion("end_tag_contains not like", value, "endTagContains");
            return (Criteria) this;
        }

        public Criteria andEndTagContainsIn(List<String> values) {
            addCriterion("end_tag_contains in", values, "endTagContains");
            return (Criteria) this;
        }

        public Criteria andEndTagContainsNotIn(List<String> values) {
            addCriterion("end_tag_contains not in", values, "endTagContains");
            return (Criteria) this;
        }

        public Criteria andEndTagContainsBetween(String value1, String value2) {
            addCriterion("end_tag_contains between", value1, value2, "endTagContains");
            return (Criteria) this;
        }

        public Criteria andEndTagContainsNotBetween(String value1, String value2) {
            addCriterion("end_tag_contains not between", value1, value2, "endTagContains");
            return (Criteria) this;
        }

        public Criteria andMissionStartUrlIsNull() {
            addCriterion("mission_start_url is null");
            return (Criteria) this;
        }

        public Criteria andMissionStartUrlIsNotNull() {
            addCriterion("mission_start_url is not null");
            return (Criteria) this;
        }

        public Criteria andMissionStartUrlEqualTo(String value) {
            addCriterion("mission_start_url =", value, "missionStartUrl");
            return (Criteria) this;
        }

        public Criteria andMissionStartUrlNotEqualTo(String value) {
            addCriterion("mission_start_url <>", value, "missionStartUrl");
            return (Criteria) this;
        }

        public Criteria andMissionStartUrlGreaterThan(String value) {
            addCriterion("mission_start_url >", value, "missionStartUrl");
            return (Criteria) this;
        }

        public Criteria andMissionStartUrlGreaterThanOrEqualTo(String value) {
            addCriterion("mission_start_url >=", value, "missionStartUrl");
            return (Criteria) this;
        }

        public Criteria andMissionStartUrlLessThan(String value) {
            addCriterion("mission_start_url <", value, "missionStartUrl");
            return (Criteria) this;
        }

        public Criteria andMissionStartUrlLessThanOrEqualTo(String value) {
            addCriterion("mission_start_url <=", value, "missionStartUrl");
            return (Criteria) this;
        }

        public Criteria andMissionStartUrlLike(String value) {
            addCriterion("mission_start_url like", value, "missionStartUrl");
            return (Criteria) this;
        }

        public Criteria andMissionStartUrlNotLike(String value) {
            addCriterion("mission_start_url not like", value, "missionStartUrl");
            return (Criteria) this;
        }

        public Criteria andMissionStartUrlIn(List<String> values) {
            addCriterion("mission_start_url in", values, "missionStartUrl");
            return (Criteria) this;
        }

        public Criteria andMissionStartUrlNotIn(List<String> values) {
            addCriterion("mission_start_url not in", values, "missionStartUrl");
            return (Criteria) this;
        }

        public Criteria andMissionStartUrlBetween(String value1, String value2) {
            addCriterion("mission_start_url between", value1, value2, "missionStartUrl");
            return (Criteria) this;
        }

        public Criteria andMissionStartUrlNotBetween(String value1, String value2) {
            addCriterion("mission_start_url not between", value1, value2, "missionStartUrl");
            return (Criteria) this;
        }

        public Criteria andMissionSuccessExcelNameIsNull() {
            addCriterion("mission_success_excel_name is null");
            return (Criteria) this;
        }

        public Criteria andMissionSuccessExcelNameIsNotNull() {
            addCriterion("mission_success_excel_name is not null");
            return (Criteria) this;
        }

        public Criteria andMissionSuccessExcelNameEqualTo(String value) {
            addCriterion("mission_success_excel_name =", value, "missionSuccessExcelName");
            return (Criteria) this;
        }

        public Criteria andMissionSuccessExcelNameNotEqualTo(String value) {
            addCriterion("mission_success_excel_name <>", value, "missionSuccessExcelName");
            return (Criteria) this;
        }

        public Criteria andMissionSuccessExcelNameGreaterThan(String value) {
            addCriterion("mission_success_excel_name >", value, "missionSuccessExcelName");
            return (Criteria) this;
        }

        public Criteria andMissionSuccessExcelNameGreaterThanOrEqualTo(String value) {
            addCriterion("mission_success_excel_name >=", value, "missionSuccessExcelName");
            return (Criteria) this;
        }

        public Criteria andMissionSuccessExcelNameLessThan(String value) {
            addCriterion("mission_success_excel_name <", value, "missionSuccessExcelName");
            return (Criteria) this;
        }

        public Criteria andMissionSuccessExcelNameLessThanOrEqualTo(String value) {
            addCriterion("mission_success_excel_name <=", value, "missionSuccessExcelName");
            return (Criteria) this;
        }

        public Criteria andMissionSuccessExcelNameLike(String value) {
            addCriterion("mission_success_excel_name like", value, "missionSuccessExcelName");
            return (Criteria) this;
        }

        public Criteria andMissionSuccessExcelNameNotLike(String value) {
            addCriterion("mission_success_excel_name not like", value, "missionSuccessExcelName");
            return (Criteria) this;
        }

        public Criteria andMissionSuccessExcelNameIn(List<String> values) {
            addCriterion("mission_success_excel_name in", values, "missionSuccessExcelName");
            return (Criteria) this;
        }

        public Criteria andMissionSuccessExcelNameNotIn(List<String> values) {
            addCriterion("mission_success_excel_name not in", values, "missionSuccessExcelName");
            return (Criteria) this;
        }

        public Criteria andMissionSuccessExcelNameBetween(String value1, String value2) {
            addCriterion("mission_success_excel_name between", value1, value2, "missionSuccessExcelName");
            return (Criteria) this;
        }

        public Criteria andMissionSuccessExcelNameNotBetween(String value1, String value2) {
            addCriterion("mission_success_excel_name not between", value1, value2, "missionSuccessExcelName");
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