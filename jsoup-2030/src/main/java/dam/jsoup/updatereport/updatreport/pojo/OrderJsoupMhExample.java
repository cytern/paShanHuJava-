package dam.jsoup.updatereport.updatreport.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderJsoupMhExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderJsoupMhExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIdIsNull() {
            addCriterion("owner_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIdIsNotNull() {
            addCriterion("owner_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIdEqualTo(Integer value) {
            addCriterion("owner_user_id =", value, "ownerUserId");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIdNotEqualTo(Integer value) {
            addCriterion("owner_user_id <>", value, "ownerUserId");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIdGreaterThan(Integer value) {
            addCriterion("owner_user_id >", value, "ownerUserId");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("owner_user_id >=", value, "ownerUserId");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIdLessThan(Integer value) {
            addCriterion("owner_user_id <", value, "ownerUserId");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("owner_user_id <=", value, "ownerUserId");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIdIn(List<Integer> values) {
            addCriterion("owner_user_id in", values, "ownerUserId");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIdNotIn(List<Integer> values) {
            addCriterion("owner_user_id not in", values, "ownerUserId");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIdBetween(Integer value1, Integer value2) {
            addCriterion("owner_user_id between", value1, value2, "ownerUserId");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("owner_user_id not between", value1, value2, "ownerUserId");
            return (Criteria) this;
        }

        public Criteria andMhIdIsNull() {
            addCriterion("mh_id is null");
            return (Criteria) this;
        }

        public Criteria andMhIdIsNotNull() {
            addCriterion("mh_id is not null");
            return (Criteria) this;
        }

        public Criteria andMhIdEqualTo(Integer value) {
            addCriterion("mh_id =", value, "mhId");
            return (Criteria) this;
        }

        public Criteria andMhIdNotEqualTo(Integer value) {
            addCriterion("mh_id <>", value, "mhId");
            return (Criteria) this;
        }

        public Criteria andMhIdGreaterThan(Integer value) {
            addCriterion("mh_id >", value, "mhId");
            return (Criteria) this;
        }

        public Criteria andMhIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mh_id >=", value, "mhId");
            return (Criteria) this;
        }

        public Criteria andMhIdLessThan(Integer value) {
            addCriterion("mh_id <", value, "mhId");
            return (Criteria) this;
        }

        public Criteria andMhIdLessThanOrEqualTo(Integer value) {
            addCriterion("mh_id <=", value, "mhId");
            return (Criteria) this;
        }

        public Criteria andMhIdIn(List<Integer> values) {
            addCriterion("mh_id in", values, "mhId");
            return (Criteria) this;
        }

        public Criteria andMhIdNotIn(List<Integer> values) {
            addCriterion("mh_id not in", values, "mhId");
            return (Criteria) this;
        }

        public Criteria andMhIdBetween(Integer value1, Integer value2) {
            addCriterion("mh_id between", value1, value2, "mhId");
            return (Criteria) this;
        }

        public Criteria andMhIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mh_id not between", value1, value2, "mhId");
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

        public Criteria andCustomerUserIdIsNull() {
            addCriterion("customer_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerUserIdIsNotNull() {
            addCriterion("customer_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerUserIdEqualTo(Integer value) {
            addCriterion("customer_user_id =", value, "customerUserId");
            return (Criteria) this;
        }

        public Criteria andCustomerUserIdNotEqualTo(Integer value) {
            addCriterion("customer_user_id <>", value, "customerUserId");
            return (Criteria) this;
        }

        public Criteria andCustomerUserIdGreaterThan(Integer value) {
            addCriterion("customer_user_id >", value, "customerUserId");
            return (Criteria) this;
        }

        public Criteria andCustomerUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_user_id >=", value, "customerUserId");
            return (Criteria) this;
        }

        public Criteria andCustomerUserIdLessThan(Integer value) {
            addCriterion("customer_user_id <", value, "customerUserId");
            return (Criteria) this;
        }

        public Criteria andCustomerUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("customer_user_id <=", value, "customerUserId");
            return (Criteria) this;
        }

        public Criteria andCustomerUserIdIn(List<Integer> values) {
            addCriterion("customer_user_id in", values, "customerUserId");
            return (Criteria) this;
        }

        public Criteria andCustomerUserIdNotIn(List<Integer> values) {
            addCriterion("customer_user_id not in", values, "customerUserId");
            return (Criteria) this;
        }

        public Criteria andCustomerUserIdBetween(Integer value1, Integer value2) {
            addCriterion("customer_user_id between", value1, value2, "customerUserId");
            return (Criteria) this;
        }

        public Criteria andCustomerUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_user_id not between", value1, value2, "customerUserId");
            return (Criteria) this;
        }

        public Criteria andFinishPriceIsNull() {
            addCriterion("finish_price is null");
            return (Criteria) this;
        }

        public Criteria andFinishPriceIsNotNull() {
            addCriterion("finish_price is not null");
            return (Criteria) this;
        }

        public Criteria andFinishPriceEqualTo(BigDecimal value) {
            addCriterion("finish_price =", value, "finishPrice");
            return (Criteria) this;
        }

        public Criteria andFinishPriceNotEqualTo(BigDecimal value) {
            addCriterion("finish_price <>", value, "finishPrice");
            return (Criteria) this;
        }

        public Criteria andFinishPriceGreaterThan(BigDecimal value) {
            addCriterion("finish_price >", value, "finishPrice");
            return (Criteria) this;
        }

        public Criteria andFinishPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("finish_price >=", value, "finishPrice");
            return (Criteria) this;
        }

        public Criteria andFinishPriceLessThan(BigDecimal value) {
            addCriterion("finish_price <", value, "finishPrice");
            return (Criteria) this;
        }

        public Criteria andFinishPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("finish_price <=", value, "finishPrice");
            return (Criteria) this;
        }

        public Criteria andFinishPriceIn(List<BigDecimal> values) {
            addCriterion("finish_price in", values, "finishPrice");
            return (Criteria) this;
        }

        public Criteria andFinishPriceNotIn(List<BigDecimal> values) {
            addCriterion("finish_price not in", values, "finishPrice");
            return (Criteria) this;
        }

        public Criteria andFinishPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("finish_price between", value1, value2, "finishPrice");
            return (Criteria) this;
        }

        public Criteria andFinishPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("finish_price not between", value1, value2, "finishPrice");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andDesIsNull() {
            addCriterion("des is null");
            return (Criteria) this;
        }

        public Criteria andDesIsNotNull() {
            addCriterion("des is not null");
            return (Criteria) this;
        }

        public Criteria andDesEqualTo(String value) {
            addCriterion("des =", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesNotEqualTo(String value) {
            addCriterion("des <>", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesGreaterThan(String value) {
            addCriterion("des >", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesGreaterThanOrEqualTo(String value) {
            addCriterion("des >=", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesLessThan(String value) {
            addCriterion("des <", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesLessThanOrEqualTo(String value) {
            addCriterion("des <=", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesLike(String value) {
            addCriterion("des like", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesNotLike(String value) {
            addCriterion("des not like", value, "des");
            return (Criteria) this;
        }

        public Criteria andDesIn(List<String> values) {
            addCriterion("des in", values, "des");
            return (Criteria) this;
        }

        public Criteria andDesNotIn(List<String> values) {
            addCriterion("des not in", values, "des");
            return (Criteria) this;
        }

        public Criteria andDesBetween(String value1, String value2) {
            addCriterion("des between", value1, value2, "des");
            return (Criteria) this;
        }

        public Criteria andDesNotBetween(String value1, String value2) {
            addCriterion("des not between", value1, value2, "des");
            return (Criteria) this;
        }

        public Criteria andUpNumIsNull() {
            addCriterion("up_num is null");
            return (Criteria) this;
        }

        public Criteria andUpNumIsNotNull() {
            addCriterion("up_num is not null");
            return (Criteria) this;
        }

        public Criteria andUpNumEqualTo(Integer value) {
            addCriterion("up_num =", value, "upNum");
            return (Criteria) this;
        }

        public Criteria andUpNumNotEqualTo(Integer value) {
            addCriterion("up_num <>", value, "upNum");
            return (Criteria) this;
        }

        public Criteria andUpNumGreaterThan(Integer value) {
            addCriterion("up_num >", value, "upNum");
            return (Criteria) this;
        }

        public Criteria andUpNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("up_num >=", value, "upNum");
            return (Criteria) this;
        }

        public Criteria andUpNumLessThan(Integer value) {
            addCriterion("up_num <", value, "upNum");
            return (Criteria) this;
        }

        public Criteria andUpNumLessThanOrEqualTo(Integer value) {
            addCriterion("up_num <=", value, "upNum");
            return (Criteria) this;
        }

        public Criteria andUpNumIn(List<Integer> values) {
            addCriterion("up_num in", values, "upNum");
            return (Criteria) this;
        }

        public Criteria andUpNumNotIn(List<Integer> values) {
            addCriterion("up_num not in", values, "upNum");
            return (Criteria) this;
        }

        public Criteria andUpNumBetween(Integer value1, Integer value2) {
            addCriterion("up_num between", value1, value2, "upNum");
            return (Criteria) this;
        }

        public Criteria andUpNumNotBetween(Integer value1, Integer value2) {
            addCriterion("up_num not between", value1, value2, "upNum");
            return (Criteria) this;
        }

        public Criteria andDownNumIsNull() {
            addCriterion("down_num is null");
            return (Criteria) this;
        }

        public Criteria andDownNumIsNotNull() {
            addCriterion("down_num is not null");
            return (Criteria) this;
        }

        public Criteria andDownNumEqualTo(Integer value) {
            addCriterion("down_num =", value, "downNum");
            return (Criteria) this;
        }

        public Criteria andDownNumNotEqualTo(Integer value) {
            addCriterion("down_num <>", value, "downNum");
            return (Criteria) this;
        }

        public Criteria andDownNumGreaterThan(Integer value) {
            addCriterion("down_num >", value, "downNum");
            return (Criteria) this;
        }

        public Criteria andDownNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("down_num >=", value, "downNum");
            return (Criteria) this;
        }

        public Criteria andDownNumLessThan(Integer value) {
            addCriterion("down_num <", value, "downNum");
            return (Criteria) this;
        }

        public Criteria andDownNumLessThanOrEqualTo(Integer value) {
            addCriterion("down_num <=", value, "downNum");
            return (Criteria) this;
        }

        public Criteria andDownNumIn(List<Integer> values) {
            addCriterion("down_num in", values, "downNum");
            return (Criteria) this;
        }

        public Criteria andDownNumNotIn(List<Integer> values) {
            addCriterion("down_num not in", values, "downNum");
            return (Criteria) this;
        }

        public Criteria andDownNumBetween(Integer value1, Integer value2) {
            addCriterion("down_num between", value1, value2, "downNum");
            return (Criteria) this;
        }

        public Criteria andDownNumNotBetween(Integer value1, Integer value2) {
            addCriterion("down_num not between", value1, value2, "downNum");
            return (Criteria) this;
        }

        public Criteria andMarkTimeIsNull() {
            addCriterion("mark_time is null");
            return (Criteria) this;
        }

        public Criteria andMarkTimeIsNotNull() {
            addCriterion("mark_time is not null");
            return (Criteria) this;
        }

        public Criteria andMarkTimeEqualTo(Date value) {
            addCriterion("mark_time =", value, "markTime");
            return (Criteria) this;
        }

        public Criteria andMarkTimeNotEqualTo(Date value) {
            addCriterion("mark_time <>", value, "markTime");
            return (Criteria) this;
        }

        public Criteria andMarkTimeGreaterThan(Date value) {
            addCriterion("mark_time >", value, "markTime");
            return (Criteria) this;
        }

        public Criteria andMarkTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("mark_time >=", value, "markTime");
            return (Criteria) this;
        }

        public Criteria andMarkTimeLessThan(Date value) {
            addCriterion("mark_time <", value, "markTime");
            return (Criteria) this;
        }

        public Criteria andMarkTimeLessThanOrEqualTo(Date value) {
            addCriterion("mark_time <=", value, "markTime");
            return (Criteria) this;
        }

        public Criteria andMarkTimeIn(List<Date> values) {
            addCriterion("mark_time in", values, "markTime");
            return (Criteria) this;
        }

        public Criteria andMarkTimeNotIn(List<Date> values) {
            addCriterion("mark_time not in", values, "markTime");
            return (Criteria) this;
        }

        public Criteria andMarkTimeBetween(Date value1, Date value2) {
            addCriterion("mark_time between", value1, value2, "markTime");
            return (Criteria) this;
        }

        public Criteria andMarkTimeNotBetween(Date value1, Date value2) {
            addCriterion("mark_time not between", value1, value2, "markTime");
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