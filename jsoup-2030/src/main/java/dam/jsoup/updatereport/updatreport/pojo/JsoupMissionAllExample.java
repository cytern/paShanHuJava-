package dam.jsoup.updatereport.updatreport.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JsoupMissionAllExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JsoupMissionAllExample() {
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

        public Criteria andMaIdIsNull() {
            addCriterion("ma_id is null");
            return (Criteria) this;
        }

        public Criteria andMaIdIsNotNull() {
            addCriterion("ma_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaIdEqualTo(Integer value) {
            addCriterion("ma_id =", value, "maId");
            return (Criteria) this;
        }

        public Criteria andMaIdNotEqualTo(Integer value) {
            addCriterion("ma_id <>", value, "maId");
            return (Criteria) this;
        }

        public Criteria andMaIdGreaterThan(Integer value) {
            addCriterion("ma_id >", value, "maId");
            return (Criteria) this;
        }

        public Criteria andMaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ma_id >=", value, "maId");
            return (Criteria) this;
        }

        public Criteria andMaIdLessThan(Integer value) {
            addCriterion("ma_id <", value, "maId");
            return (Criteria) this;
        }

        public Criteria andMaIdLessThanOrEqualTo(Integer value) {
            addCriterion("ma_id <=", value, "maId");
            return (Criteria) this;
        }

        public Criteria andMaIdIn(List<Integer> values) {
            addCriterion("ma_id in", values, "maId");
            return (Criteria) this;
        }

        public Criteria andMaIdNotIn(List<Integer> values) {
            addCriterion("ma_id not in", values, "maId");
            return (Criteria) this;
        }

        public Criteria andMaIdBetween(Integer value1, Integer value2) {
            addCriterion("ma_id between", value1, value2, "maId");
            return (Criteria) this;
        }

        public Criteria andMaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ma_id not between", value1, value2, "maId");
            return (Criteria) this;
        }

        public Criteria andMaNameIsNull() {
            addCriterion("ma_name is null");
            return (Criteria) this;
        }

        public Criteria andMaNameIsNotNull() {
            addCriterion("ma_name is not null");
            return (Criteria) this;
        }

        public Criteria andMaNameEqualTo(String value) {
            addCriterion("ma_name =", value, "maName");
            return (Criteria) this;
        }

        public Criteria andMaNameNotEqualTo(String value) {
            addCriterion("ma_name <>", value, "maName");
            return (Criteria) this;
        }

        public Criteria andMaNameGreaterThan(String value) {
            addCriterion("ma_name >", value, "maName");
            return (Criteria) this;
        }

        public Criteria andMaNameGreaterThanOrEqualTo(String value) {
            addCriterion("ma_name >=", value, "maName");
            return (Criteria) this;
        }

        public Criteria andMaNameLessThan(String value) {
            addCriterion("ma_name <", value, "maName");
            return (Criteria) this;
        }

        public Criteria andMaNameLessThanOrEqualTo(String value) {
            addCriterion("ma_name <=", value, "maName");
            return (Criteria) this;
        }

        public Criteria andMaNameLike(String value) {
            addCriterion("ma_name like", value, "maName");
            return (Criteria) this;
        }

        public Criteria andMaNameNotLike(String value) {
            addCriterion("ma_name not like", value, "maName");
            return (Criteria) this;
        }

        public Criteria andMaNameIn(List<String> values) {
            addCriterion("ma_name in", values, "maName");
            return (Criteria) this;
        }

        public Criteria andMaNameNotIn(List<String> values) {
            addCriterion("ma_name not in", values, "maName");
            return (Criteria) this;
        }

        public Criteria andMaNameBetween(String value1, String value2) {
            addCriterion("ma_name between", value1, value2, "maName");
            return (Criteria) this;
        }

        public Criteria andMaNameNotBetween(String value1, String value2) {
            addCriterion("ma_name not between", value1, value2, "maName");
            return (Criteria) this;
        }

        public Criteria andMaTipIsNull() {
            addCriterion("ma_tip is null");
            return (Criteria) this;
        }

        public Criteria andMaTipIsNotNull() {
            addCriterion("ma_tip is not null");
            return (Criteria) this;
        }

        public Criteria andMaTipEqualTo(String value) {
            addCriterion("ma_tip =", value, "maTip");
            return (Criteria) this;
        }

        public Criteria andMaTipNotEqualTo(String value) {
            addCriterion("ma_tip <>", value, "maTip");
            return (Criteria) this;
        }

        public Criteria andMaTipGreaterThan(String value) {
            addCriterion("ma_tip >", value, "maTip");
            return (Criteria) this;
        }

        public Criteria andMaTipGreaterThanOrEqualTo(String value) {
            addCriterion("ma_tip >=", value, "maTip");
            return (Criteria) this;
        }

        public Criteria andMaTipLessThan(String value) {
            addCriterion("ma_tip <", value, "maTip");
            return (Criteria) this;
        }

        public Criteria andMaTipLessThanOrEqualTo(String value) {
            addCriterion("ma_tip <=", value, "maTip");
            return (Criteria) this;
        }

        public Criteria andMaTipLike(String value) {
            addCriterion("ma_tip like", value, "maTip");
            return (Criteria) this;
        }

        public Criteria andMaTipNotLike(String value) {
            addCriterion("ma_tip not like", value, "maTip");
            return (Criteria) this;
        }

        public Criteria andMaTipIn(List<String> values) {
            addCriterion("ma_tip in", values, "maTip");
            return (Criteria) this;
        }

        public Criteria andMaTipNotIn(List<String> values) {
            addCriterion("ma_tip not in", values, "maTip");
            return (Criteria) this;
        }

        public Criteria andMaTipBetween(String value1, String value2) {
            addCriterion("ma_tip between", value1, value2, "maTip");
            return (Criteria) this;
        }

        public Criteria andMaTipNotBetween(String value1, String value2) {
            addCriterion("ma_tip not between", value1, value2, "maTip");
            return (Criteria) this;
        }

        public Criteria andMalStartUrlIsNull() {
            addCriterion("mal_start_url is null");
            return (Criteria) this;
        }

        public Criteria andMalStartUrlIsNotNull() {
            addCriterion("mal_start_url is not null");
            return (Criteria) this;
        }

        public Criteria andMalStartUrlEqualTo(String value) {
            addCriterion("mal_start_url =", value, "malStartUrl");
            return (Criteria) this;
        }

        public Criteria andMalStartUrlNotEqualTo(String value) {
            addCriterion("mal_start_url <>", value, "malStartUrl");
            return (Criteria) this;
        }

        public Criteria andMalStartUrlGreaterThan(String value) {
            addCriterion("mal_start_url >", value, "malStartUrl");
            return (Criteria) this;
        }

        public Criteria andMalStartUrlGreaterThanOrEqualTo(String value) {
            addCriterion("mal_start_url >=", value, "malStartUrl");
            return (Criteria) this;
        }

        public Criteria andMalStartUrlLessThan(String value) {
            addCriterion("mal_start_url <", value, "malStartUrl");
            return (Criteria) this;
        }

        public Criteria andMalStartUrlLessThanOrEqualTo(String value) {
            addCriterion("mal_start_url <=", value, "malStartUrl");
            return (Criteria) this;
        }

        public Criteria andMalStartUrlLike(String value) {
            addCriterion("mal_start_url like", value, "malStartUrl");
            return (Criteria) this;
        }

        public Criteria andMalStartUrlNotLike(String value) {
            addCriterion("mal_start_url not like", value, "malStartUrl");
            return (Criteria) this;
        }

        public Criteria andMalStartUrlIn(List<String> values) {
            addCriterion("mal_start_url in", values, "malStartUrl");
            return (Criteria) this;
        }

        public Criteria andMalStartUrlNotIn(List<String> values) {
            addCriterion("mal_start_url not in", values, "malStartUrl");
            return (Criteria) this;
        }

        public Criteria andMalStartUrlBetween(String value1, String value2) {
            addCriterion("mal_start_url between", value1, value2, "malStartUrl");
            return (Criteria) this;
        }

        public Criteria andMalStartUrlNotBetween(String value1, String value2) {
            addCriterion("mal_start_url not between", value1, value2, "malStartUrl");
            return (Criteria) this;
        }

        public Criteria andMaSuccessFileNameIsNull() {
            addCriterion("ma_success_file_name is null");
            return (Criteria) this;
        }

        public Criteria andMaSuccessFileNameIsNotNull() {
            addCriterion("ma_success_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andMaSuccessFileNameEqualTo(String value) {
            addCriterion("ma_success_file_name =", value, "maSuccessFileName");
            return (Criteria) this;
        }

        public Criteria andMaSuccessFileNameNotEqualTo(String value) {
            addCriterion("ma_success_file_name <>", value, "maSuccessFileName");
            return (Criteria) this;
        }

        public Criteria andMaSuccessFileNameGreaterThan(String value) {
            addCriterion("ma_success_file_name >", value, "maSuccessFileName");
            return (Criteria) this;
        }

        public Criteria andMaSuccessFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("ma_success_file_name >=", value, "maSuccessFileName");
            return (Criteria) this;
        }

        public Criteria andMaSuccessFileNameLessThan(String value) {
            addCriterion("ma_success_file_name <", value, "maSuccessFileName");
            return (Criteria) this;
        }

        public Criteria andMaSuccessFileNameLessThanOrEqualTo(String value) {
            addCriterion("ma_success_file_name <=", value, "maSuccessFileName");
            return (Criteria) this;
        }

        public Criteria andMaSuccessFileNameLike(String value) {
            addCriterion("ma_success_file_name like", value, "maSuccessFileName");
            return (Criteria) this;
        }

        public Criteria andMaSuccessFileNameNotLike(String value) {
            addCriterion("ma_success_file_name not like", value, "maSuccessFileName");
            return (Criteria) this;
        }

        public Criteria andMaSuccessFileNameIn(List<String> values) {
            addCriterion("ma_success_file_name in", values, "maSuccessFileName");
            return (Criteria) this;
        }

        public Criteria andMaSuccessFileNameNotIn(List<String> values) {
            addCriterion("ma_success_file_name not in", values, "maSuccessFileName");
            return (Criteria) this;
        }

        public Criteria andMaSuccessFileNameBetween(String value1, String value2) {
            addCriterion("ma_success_file_name between", value1, value2, "maSuccessFileName");
            return (Criteria) this;
        }

        public Criteria andMaSuccessFileNameNotBetween(String value1, String value2) {
            addCriterion("ma_success_file_name not between", value1, value2, "maSuccessFileName");
            return (Criteria) this;
        }

        public Criteria andMaUserIdIsNull() {
            addCriterion("ma_user_id is null");
            return (Criteria) this;
        }

        public Criteria andMaUserIdIsNotNull() {
            addCriterion("ma_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaUserIdEqualTo(Integer value) {
            addCriterion("ma_user_id =", value, "maUserId");
            return (Criteria) this;
        }

        public Criteria andMaUserIdNotEqualTo(Integer value) {
            addCriterion("ma_user_id <>", value, "maUserId");
            return (Criteria) this;
        }

        public Criteria andMaUserIdGreaterThan(Integer value) {
            addCriterion("ma_user_id >", value, "maUserId");
            return (Criteria) this;
        }

        public Criteria andMaUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ma_user_id >=", value, "maUserId");
            return (Criteria) this;
        }

        public Criteria andMaUserIdLessThan(Integer value) {
            addCriterion("ma_user_id <", value, "maUserId");
            return (Criteria) this;
        }

        public Criteria andMaUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("ma_user_id <=", value, "maUserId");
            return (Criteria) this;
        }

        public Criteria andMaUserIdIn(List<Integer> values) {
            addCriterion("ma_user_id in", values, "maUserId");
            return (Criteria) this;
        }

        public Criteria andMaUserIdNotIn(List<Integer> values) {
            addCriterion("ma_user_id not in", values, "maUserId");
            return (Criteria) this;
        }

        public Criteria andMaUserIdBetween(Integer value1, Integer value2) {
            addCriterion("ma_user_id between", value1, value2, "maUserId");
            return (Criteria) this;
        }

        public Criteria andMaUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ma_user_id not between", value1, value2, "maUserId");
            return (Criteria) this;
        }

        public Criteria andMaNoticeEmailIsNull() {
            addCriterion("ma_notice_email is null");
            return (Criteria) this;
        }

        public Criteria andMaNoticeEmailIsNotNull() {
            addCriterion("ma_notice_email is not null");
            return (Criteria) this;
        }

        public Criteria andMaNoticeEmailEqualTo(String value) {
            addCriterion("ma_notice_email =", value, "maNoticeEmail");
            return (Criteria) this;
        }

        public Criteria andMaNoticeEmailNotEqualTo(String value) {
            addCriterion("ma_notice_email <>", value, "maNoticeEmail");
            return (Criteria) this;
        }

        public Criteria andMaNoticeEmailGreaterThan(String value) {
            addCriterion("ma_notice_email >", value, "maNoticeEmail");
            return (Criteria) this;
        }

        public Criteria andMaNoticeEmailGreaterThanOrEqualTo(String value) {
            addCriterion("ma_notice_email >=", value, "maNoticeEmail");
            return (Criteria) this;
        }

        public Criteria andMaNoticeEmailLessThan(String value) {
            addCriterion("ma_notice_email <", value, "maNoticeEmail");
            return (Criteria) this;
        }

        public Criteria andMaNoticeEmailLessThanOrEqualTo(String value) {
            addCriterion("ma_notice_email <=", value, "maNoticeEmail");
            return (Criteria) this;
        }

        public Criteria andMaNoticeEmailLike(String value) {
            addCriterion("ma_notice_email like", value, "maNoticeEmail");
            return (Criteria) this;
        }

        public Criteria andMaNoticeEmailNotLike(String value) {
            addCriterion("ma_notice_email not like", value, "maNoticeEmail");
            return (Criteria) this;
        }

        public Criteria andMaNoticeEmailIn(List<String> values) {
            addCriterion("ma_notice_email in", values, "maNoticeEmail");
            return (Criteria) this;
        }

        public Criteria andMaNoticeEmailNotIn(List<String> values) {
            addCriterion("ma_notice_email not in", values, "maNoticeEmail");
            return (Criteria) this;
        }

        public Criteria andMaNoticeEmailBetween(String value1, String value2) {
            addCriterion("ma_notice_email between", value1, value2, "maNoticeEmail");
            return (Criteria) this;
        }

        public Criteria andMaNoticeEmailNotBetween(String value1, String value2) {
            addCriterion("ma_notice_email not between", value1, value2, "maNoticeEmail");
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

        public Criteria andMaStateIsNull() {
            addCriterion("ma_state is null");
            return (Criteria) this;
        }

        public Criteria andMaStateIsNotNull() {
            addCriterion("ma_state is not null");
            return (Criteria) this;
        }

        public Criteria andMaStateEqualTo(Integer value) {
            addCriterion("ma_state =", value, "maState");
            return (Criteria) this;
        }

        public Criteria andMaStateNotEqualTo(Integer value) {
            addCriterion("ma_state <>", value, "maState");
            return (Criteria) this;
        }

        public Criteria andMaStateGreaterThan(Integer value) {
            addCriterion("ma_state >", value, "maState");
            return (Criteria) this;
        }

        public Criteria andMaStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("ma_state >=", value, "maState");
            return (Criteria) this;
        }

        public Criteria andMaStateLessThan(Integer value) {
            addCriterion("ma_state <", value, "maState");
            return (Criteria) this;
        }

        public Criteria andMaStateLessThanOrEqualTo(Integer value) {
            addCriterion("ma_state <=", value, "maState");
            return (Criteria) this;
        }

        public Criteria andMaStateIn(List<Integer> values) {
            addCriterion("ma_state in", values, "maState");
            return (Criteria) this;
        }

        public Criteria andMaStateNotIn(List<Integer> values) {
            addCriterion("ma_state not in", values, "maState");
            return (Criteria) this;
        }

        public Criteria andMaStateBetween(Integer value1, Integer value2) {
            addCriterion("ma_state between", value1, value2, "maState");
            return (Criteria) this;
        }

        public Criteria andMaStateNotBetween(Integer value1, Integer value2) {
            addCriterion("ma_state not between", value1, value2, "maState");
            return (Criteria) this;
        }

        public Criteria andMaPriceIsNull() {
            addCriterion("ma_price is null");
            return (Criteria) this;
        }

        public Criteria andMaPriceIsNotNull() {
            addCriterion("ma_price is not null");
            return (Criteria) this;
        }

        public Criteria andMaPriceEqualTo(BigDecimal value) {
            addCriterion("ma_price =", value, "maPrice");
            return (Criteria) this;
        }

        public Criteria andMaPriceNotEqualTo(BigDecimal value) {
            addCriterion("ma_price <>", value, "maPrice");
            return (Criteria) this;
        }

        public Criteria andMaPriceGreaterThan(BigDecimal value) {
            addCriterion("ma_price >", value, "maPrice");
            return (Criteria) this;
        }

        public Criteria andMaPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ma_price >=", value, "maPrice");
            return (Criteria) this;
        }

        public Criteria andMaPriceLessThan(BigDecimal value) {
            addCriterion("ma_price <", value, "maPrice");
            return (Criteria) this;
        }

        public Criteria andMaPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ma_price <=", value, "maPrice");
            return (Criteria) this;
        }

        public Criteria andMaPriceIn(List<BigDecimal> values) {
            addCriterion("ma_price in", values, "maPrice");
            return (Criteria) this;
        }

        public Criteria andMaPriceNotIn(List<BigDecimal> values) {
            addCriterion("ma_price not in", values, "maPrice");
            return (Criteria) this;
        }

        public Criteria andMaPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ma_price between", value1, value2, "maPrice");
            return (Criteria) this;
        }

        public Criteria andMaPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ma_price not between", value1, value2, "maPrice");
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

        public Criteria andMaRateIsNull() {
            addCriterion("ma_rate is null");
            return (Criteria) this;
        }

        public Criteria andMaRateIsNotNull() {
            addCriterion("ma_rate is not null");
            return (Criteria) this;
        }

        public Criteria andMaRateEqualTo(String value) {
            addCriterion("ma_rate =", value, "maRate");
            return (Criteria) this;
        }

        public Criteria andMaRateNotEqualTo(String value) {
            addCriterion("ma_rate <>", value, "maRate");
            return (Criteria) this;
        }

        public Criteria andMaRateGreaterThan(String value) {
            addCriterion("ma_rate >", value, "maRate");
            return (Criteria) this;
        }

        public Criteria andMaRateGreaterThanOrEqualTo(String value) {
            addCriterion("ma_rate >=", value, "maRate");
            return (Criteria) this;
        }

        public Criteria andMaRateLessThan(String value) {
            addCriterion("ma_rate <", value, "maRate");
            return (Criteria) this;
        }

        public Criteria andMaRateLessThanOrEqualTo(String value) {
            addCriterion("ma_rate <=", value, "maRate");
            return (Criteria) this;
        }

        public Criteria andMaRateLike(String value) {
            addCriterion("ma_rate like", value, "maRate");
            return (Criteria) this;
        }

        public Criteria andMaRateNotLike(String value) {
            addCriterion("ma_rate not like", value, "maRate");
            return (Criteria) this;
        }

        public Criteria andMaRateIn(List<String> values) {
            addCriterion("ma_rate in", values, "maRate");
            return (Criteria) this;
        }

        public Criteria andMaRateNotIn(List<String> values) {
            addCriterion("ma_rate not in", values, "maRate");
            return (Criteria) this;
        }

        public Criteria andMaRateBetween(String value1, String value2) {
            addCriterion("ma_rate between", value1, value2, "maRate");
            return (Criteria) this;
        }

        public Criteria andMaRateNotBetween(String value1, String value2) {
            addCriterion("ma_rate not between", value1, value2, "maRate");
            return (Criteria) this;
        }

        public Criteria andMaSaleNumIsNull() {
            addCriterion("ma_sale_num is null");
            return (Criteria) this;
        }

        public Criteria andMaSaleNumIsNotNull() {
            addCriterion("ma_sale_num is not null");
            return (Criteria) this;
        }

        public Criteria andMaSaleNumEqualTo(Integer value) {
            addCriterion("ma_sale_num =", value, "maSaleNum");
            return (Criteria) this;
        }

        public Criteria andMaSaleNumNotEqualTo(Integer value) {
            addCriterion("ma_sale_num <>", value, "maSaleNum");
            return (Criteria) this;
        }

        public Criteria andMaSaleNumGreaterThan(Integer value) {
            addCriterion("ma_sale_num >", value, "maSaleNum");
            return (Criteria) this;
        }

        public Criteria andMaSaleNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("ma_sale_num >=", value, "maSaleNum");
            return (Criteria) this;
        }

        public Criteria andMaSaleNumLessThan(Integer value) {
            addCriterion("ma_sale_num <", value, "maSaleNum");
            return (Criteria) this;
        }

        public Criteria andMaSaleNumLessThanOrEqualTo(Integer value) {
            addCriterion("ma_sale_num <=", value, "maSaleNum");
            return (Criteria) this;
        }

        public Criteria andMaSaleNumIn(List<Integer> values) {
            addCriterion("ma_sale_num in", values, "maSaleNum");
            return (Criteria) this;
        }

        public Criteria andMaSaleNumNotIn(List<Integer> values) {
            addCriterion("ma_sale_num not in", values, "maSaleNum");
            return (Criteria) this;
        }

        public Criteria andMaSaleNumBetween(Integer value1, Integer value2) {
            addCriterion("ma_sale_num between", value1, value2, "maSaleNum");
            return (Criteria) this;
        }

        public Criteria andMaSaleNumNotBetween(Integer value1, Integer value2) {
            addCriterion("ma_sale_num not between", value1, value2, "maSaleNum");
            return (Criteria) this;
        }

        public Criteria andTipsIsNull() {
            addCriterion("tips is null");
            return (Criteria) this;
        }

        public Criteria andTipsIsNotNull() {
            addCriterion("tips is not null");
            return (Criteria) this;
        }

        public Criteria andTipsEqualTo(String value) {
            addCriterion("tips =", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsNotEqualTo(String value) {
            addCriterion("tips <>", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsGreaterThan(String value) {
            addCriterion("tips >", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsGreaterThanOrEqualTo(String value) {
            addCriterion("tips >=", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsLessThan(String value) {
            addCriterion("tips <", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsLessThanOrEqualTo(String value) {
            addCriterion("tips <=", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsLike(String value) {
            addCriterion("tips like", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsNotLike(String value) {
            addCriterion("tips not like", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsIn(List<String> values) {
            addCriterion("tips in", values, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsNotIn(List<String> values) {
            addCriterion("tips not in", values, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsBetween(String value1, String value2) {
            addCriterion("tips between", value1, value2, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsNotBetween(String value1, String value2) {
            addCriterion("tips not between", value1, value2, "tips");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andIsAutoIsNull() {
            addCriterion("is_auto is null");
            return (Criteria) this;
        }

        public Criteria andIsAutoIsNotNull() {
            addCriterion("is_auto is not null");
            return (Criteria) this;
        }

        public Criteria andIsAutoEqualTo(String value) {
            addCriterion("is_auto =", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoNotEqualTo(String value) {
            addCriterion("is_auto <>", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoGreaterThan(String value) {
            addCriterion("is_auto >", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoGreaterThanOrEqualTo(String value) {
            addCriterion("is_auto >=", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoLessThan(String value) {
            addCriterion("is_auto <", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoLessThanOrEqualTo(String value) {
            addCriterion("is_auto <=", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoLike(String value) {
            addCriterion("is_auto like", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoNotLike(String value) {
            addCriterion("is_auto not like", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoIn(List<String> values) {
            addCriterion("is_auto in", values, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoNotIn(List<String> values) {
            addCriterion("is_auto not in", values, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoBetween(String value1, String value2) {
            addCriterion("is_auto between", value1, value2, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoNotBetween(String value1, String value2) {
            addCriterion("is_auto not between", value1, value2, "isAuto");
            return (Criteria) this;
        }

        public Criteria andMaUrlIsNull() {
            addCriterion("ma_url is null");
            return (Criteria) this;
        }

        public Criteria andMaUrlIsNotNull() {
            addCriterion("ma_url is not null");
            return (Criteria) this;
        }

        public Criteria andMaUrlEqualTo(String value) {
            addCriterion("ma_url =", value, "maUrl");
            return (Criteria) this;
        }

        public Criteria andMaUrlNotEqualTo(String value) {
            addCriterion("ma_url <>", value, "maUrl");
            return (Criteria) this;
        }

        public Criteria andMaUrlGreaterThan(String value) {
            addCriterion("ma_url >", value, "maUrl");
            return (Criteria) this;
        }

        public Criteria andMaUrlGreaterThanOrEqualTo(String value) {
            addCriterion("ma_url >=", value, "maUrl");
            return (Criteria) this;
        }

        public Criteria andMaUrlLessThan(String value) {
            addCriterion("ma_url <", value, "maUrl");
            return (Criteria) this;
        }

        public Criteria andMaUrlLessThanOrEqualTo(String value) {
            addCriterion("ma_url <=", value, "maUrl");
            return (Criteria) this;
        }

        public Criteria andMaUrlLike(String value) {
            addCriterion("ma_url like", value, "maUrl");
            return (Criteria) this;
        }

        public Criteria andMaUrlNotLike(String value) {
            addCriterion("ma_url not like", value, "maUrl");
            return (Criteria) this;
        }

        public Criteria andMaUrlIn(List<String> values) {
            addCriterion("ma_url in", values, "maUrl");
            return (Criteria) this;
        }

        public Criteria andMaUrlNotIn(List<String> values) {
            addCriterion("ma_url not in", values, "maUrl");
            return (Criteria) this;
        }

        public Criteria andMaUrlBetween(String value1, String value2) {
            addCriterion("ma_url between", value1, value2, "maUrl");
            return (Criteria) this;
        }

        public Criteria andMaUrlNotBetween(String value1, String value2) {
            addCriterion("ma_url not between", value1, value2, "maUrl");
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