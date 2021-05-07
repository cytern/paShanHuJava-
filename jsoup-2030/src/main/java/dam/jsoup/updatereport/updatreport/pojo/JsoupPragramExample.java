package dam.jsoup.updatereport.updatreport.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * @description :
 * @author : dam
 * @create :2021-05-06 14:32:00
 */
public class JsoupPragramExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JsoupPragramExample() {
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

        public Criteria andPragramIdIsNull() {
            addCriterion("pragram_id is null");
            return (Criteria) this;
        }

        public Criteria andPragramIdIsNotNull() {
            addCriterion("pragram_id is not null");
            return (Criteria) this;
        }

        public Criteria andPragramIdEqualTo(Integer value) {
            addCriterion("pragram_id =", value, "pragramId");
            return (Criteria) this;
        }

        public Criteria andPragramIdNotEqualTo(Integer value) {
            addCriterion("pragram_id <>", value, "pragramId");
            return (Criteria) this;
        }

        public Criteria andPragramIdGreaterThan(Integer value) {
            addCriterion("pragram_id >", value, "pragramId");
            return (Criteria) this;
        }

        public Criteria andPragramIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pragram_id >=", value, "pragramId");
            return (Criteria) this;
        }

        public Criteria andPragramIdLessThan(Integer value) {
            addCriterion("pragram_id <", value, "pragramId");
            return (Criteria) this;
        }

        public Criteria andPragramIdLessThanOrEqualTo(Integer value) {
            addCriterion("pragram_id <=", value, "pragramId");
            return (Criteria) this;
        }

        public Criteria andPragramIdIn(List<Integer> values) {
            addCriterion("pragram_id in", values, "pragramId");
            return (Criteria) this;
        }

        public Criteria andPragramIdNotIn(List<Integer> values) {
            addCriterion("pragram_id not in", values, "pragramId");
            return (Criteria) this;
        }

        public Criteria andPragramIdBetween(Integer value1, Integer value2) {
            addCriterion("pragram_id between", value1, value2, "pragramId");
            return (Criteria) this;
        }

        public Criteria andPragramIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pragram_id not between", value1, value2, "pragramId");
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

        public Criteria andPragramTypeIsNull() {
            addCriterion("pragram_type is null");
            return (Criteria) this;
        }

        public Criteria andPragramTypeIsNotNull() {
            addCriterion("pragram_type is not null");
            return (Criteria) this;
        }

        public Criteria andPragramTypeEqualTo(String value) {
            addCriterion("pragram_type =", value, "pragramType");
            return (Criteria) this;
        }

        public Criteria andPragramTypeNotEqualTo(String value) {
            addCriterion("pragram_type <>", value, "pragramType");
            return (Criteria) this;
        }

        public Criteria andPragramTypeGreaterThan(String value) {
            addCriterion("pragram_type >", value, "pragramType");
            return (Criteria) this;
        }

        public Criteria andPragramTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pragram_type >=", value, "pragramType");
            return (Criteria) this;
        }

        public Criteria andPragramTypeLessThan(String value) {
            addCriterion("pragram_type <", value, "pragramType");
            return (Criteria) this;
        }

        public Criteria andPragramTypeLessThanOrEqualTo(String value) {
            addCriterion("pragram_type <=", value, "pragramType");
            return (Criteria) this;
        }

        public Criteria andPragramTypeLike(String value) {
            addCriterion("pragram_type like", value, "pragramType");
            return (Criteria) this;
        }

        public Criteria andPragramTypeNotLike(String value) {
            addCriterion("pragram_type not like", value, "pragramType");
            return (Criteria) this;
        }

        public Criteria andPragramTypeIn(List<String> values) {
            addCriterion("pragram_type in", values, "pragramType");
            return (Criteria) this;
        }

        public Criteria andPragramTypeNotIn(List<String> values) {
            addCriterion("pragram_type not in", values, "pragramType");
            return (Criteria) this;
        }

        public Criteria andPragramTypeBetween(String value1, String value2) {
            addCriterion("pragram_type between", value1, value2, "pragramType");
            return (Criteria) this;
        }

        public Criteria andPragramTypeNotBetween(String value1, String value2) {
            addCriterion("pragram_type not between", value1, value2, "pragramType");
            return (Criteria) this;
        }

        public Criteria andPragramAccuracyIsNull() {
            addCriterion("pragram_accuracy is null");
            return (Criteria) this;
        }

        public Criteria andPragramAccuracyIsNotNull() {
            addCriterion("pragram_accuracy is not null");
            return (Criteria) this;
        }

        public Criteria andPragramAccuracyEqualTo(Integer value) {
            addCriterion("pragram_accuracy =", value, "pragramAccuracy");
            return (Criteria) this;
        }

        public Criteria andPragramAccuracyNotEqualTo(Integer value) {
            addCriterion("pragram_accuracy <>", value, "pragramAccuracy");
            return (Criteria) this;
        }

        public Criteria andPragramAccuracyGreaterThan(Integer value) {
            addCriterion("pragram_accuracy >", value, "pragramAccuracy");
            return (Criteria) this;
        }

        public Criteria andPragramAccuracyGreaterThanOrEqualTo(Integer value) {
            addCriterion("pragram_accuracy >=", value, "pragramAccuracy");
            return (Criteria) this;
        }

        public Criteria andPragramAccuracyLessThan(Integer value) {
            addCriterion("pragram_accuracy <", value, "pragramAccuracy");
            return (Criteria) this;
        }

        public Criteria andPragramAccuracyLessThanOrEqualTo(Integer value) {
            addCriterion("pragram_accuracy <=", value, "pragramAccuracy");
            return (Criteria) this;
        }

        public Criteria andPragramAccuracyIn(List<Integer> values) {
            addCriterion("pragram_accuracy in", values, "pragramAccuracy");
            return (Criteria) this;
        }

        public Criteria andPragramAccuracyNotIn(List<Integer> values) {
            addCriterion("pragram_accuracy not in", values, "pragramAccuracy");
            return (Criteria) this;
        }

        public Criteria andPragramAccuracyBetween(Integer value1, Integer value2) {
            addCriterion("pragram_accuracy between", value1, value2, "pragramAccuracy");
            return (Criteria) this;
        }

        public Criteria andPragramAccuracyNotBetween(Integer value1, Integer value2) {
            addCriterion("pragram_accuracy not between", value1, value2, "pragramAccuracy");
            return (Criteria) this;
        }

        public Criteria andIsRamdomIsNull() {
            addCriterion("is_ramdom is null");
            return (Criteria) this;
        }

        public Criteria andIsRamdomIsNotNull() {
            addCriterion("is_ramdom is not null");
            return (Criteria) this;
        }

        public Criteria andIsRamdomEqualTo(Integer value) {
            addCriterion("is_ramdom =", value, "isRamdom");
            return (Criteria) this;
        }

        public Criteria andIsRamdomNotEqualTo(Integer value) {
            addCriterion("is_ramdom <>", value, "isRamdom");
            return (Criteria) this;
        }

        public Criteria andIsRamdomGreaterThan(Integer value) {
            addCriterion("is_ramdom >", value, "isRamdom");
            return (Criteria) this;
        }

        public Criteria andIsRamdomGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_ramdom >=", value, "isRamdom");
            return (Criteria) this;
        }

        public Criteria andIsRamdomLessThan(Integer value) {
            addCriterion("is_ramdom <", value, "isRamdom");
            return (Criteria) this;
        }

        public Criteria andIsRamdomLessThanOrEqualTo(Integer value) {
            addCriterion("is_ramdom <=", value, "isRamdom");
            return (Criteria) this;
        }

        public Criteria andIsRamdomIn(List<Integer> values) {
            addCriterion("is_ramdom in", values, "isRamdom");
            return (Criteria) this;
        }

        public Criteria andIsRamdomNotIn(List<Integer> values) {
            addCriterion("is_ramdom not in", values, "isRamdom");
            return (Criteria) this;
        }

        public Criteria andIsRamdomBetween(Integer value1, Integer value2) {
            addCriterion("is_ramdom between", value1, value2, "isRamdom");
            return (Criteria) this;
        }

        public Criteria andIsRamdomNotBetween(Integer value1, Integer value2) {
            addCriterion("is_ramdom not between", value1, value2, "isRamdom");
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

        public Criteria andUpNumEqualTo(BigDecimal value) {
            addCriterion("up_num =", value, "upNum");
            return (Criteria) this;
        }

        public Criteria andUpNumNotEqualTo(BigDecimal value) {
            addCriterion("up_num <>", value, "upNum");
            return (Criteria) this;
        }

        public Criteria andUpNumGreaterThan(BigDecimal value) {
            addCriterion("up_num >", value, "upNum");
            return (Criteria) this;
        }

        public Criteria andUpNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("up_num >=", value, "upNum");
            return (Criteria) this;
        }

        public Criteria andUpNumLessThan(BigDecimal value) {
            addCriterion("up_num <", value, "upNum");
            return (Criteria) this;
        }

        public Criteria andUpNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("up_num <=", value, "upNum");
            return (Criteria) this;
        }

        public Criteria andUpNumIn(List<BigDecimal> values) {
            addCriterion("up_num in", values, "upNum");
            return (Criteria) this;
        }

        public Criteria andUpNumNotIn(List<BigDecimal> values) {
            addCriterion("up_num not in", values, "upNum");
            return (Criteria) this;
        }

        public Criteria andUpNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("up_num between", value1, value2, "upNum");
            return (Criteria) this;
        }

        public Criteria andUpNumNotBetween(BigDecimal value1, BigDecimal value2) {
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

        public Criteria andDownNumEqualTo(BigDecimal value) {
            addCriterion("down_num =", value, "downNum");
            return (Criteria) this;
        }

        public Criteria andDownNumNotEqualTo(BigDecimal value) {
            addCriterion("down_num <>", value, "downNum");
            return (Criteria) this;
        }

        public Criteria andDownNumGreaterThan(BigDecimal value) {
            addCriterion("down_num >", value, "downNum");
            return (Criteria) this;
        }

        public Criteria andDownNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("down_num >=", value, "downNum");
            return (Criteria) this;
        }

        public Criteria andDownNumLessThan(BigDecimal value) {
            addCriterion("down_num <", value, "downNum");
            return (Criteria) this;
        }

        public Criteria andDownNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("down_num <=", value, "downNum");
            return (Criteria) this;
        }

        public Criteria andDownNumIn(List<BigDecimal> values) {
            addCriterion("down_num in", values, "downNum");
            return (Criteria) this;
        }

        public Criteria andDownNumNotIn(List<BigDecimal> values) {
            addCriterion("down_num not in", values, "downNum");
            return (Criteria) this;
        }

        public Criteria andDownNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("down_num between", value1, value2, "downNum");
            return (Criteria) this;
        }

        public Criteria andDownNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("down_num not between", value1, value2, "downNum");
            return (Criteria) this;
        }

        public Criteria andPragramValueIsNull() {
            addCriterion("pragram_value is null");
            return (Criteria) this;
        }

        public Criteria andPragramValueIsNotNull() {
            addCriterion("pragram_value is not null");
            return (Criteria) this;
        }

        public Criteria andPragramValueEqualTo(String value) {
            addCriterion("pragram_value =", value, "pragramValue");
            return (Criteria) this;
        }

        public Criteria andPragramValueNotEqualTo(String value) {
            addCriterion("pragram_value <>", value, "pragramValue");
            return (Criteria) this;
        }

        public Criteria andPragramValueGreaterThan(String value) {
            addCriterion("pragram_value >", value, "pragramValue");
            return (Criteria) this;
        }

        public Criteria andPragramValueGreaterThanOrEqualTo(String value) {
            addCriterion("pragram_value >=", value, "pragramValue");
            return (Criteria) this;
        }

        public Criteria andPragramValueLessThan(String value) {
            addCriterion("pragram_value <", value, "pragramValue");
            return (Criteria) this;
        }

        public Criteria andPragramValueLessThanOrEqualTo(String value) {
            addCriterion("pragram_value <=", value, "pragramValue");
            return (Criteria) this;
        }

        public Criteria andPragramValueLike(String value) {
            addCriterion("pragram_value like", value, "pragramValue");
            return (Criteria) this;
        }

        public Criteria andPragramValueNotLike(String value) {
            addCriterion("pragram_value not like", value, "pragramValue");
            return (Criteria) this;
        }

        public Criteria andPragramValueIn(List<String> values) {
            addCriterion("pragram_value in", values, "pragramValue");
            return (Criteria) this;
        }

        public Criteria andPragramValueNotIn(List<String> values) {
            addCriterion("pragram_value not in", values, "pragramValue");
            return (Criteria) this;
        }

        public Criteria andPragramValueBetween(String value1, String value2) {
            addCriterion("pragram_value between", value1, value2, "pragramValue");
            return (Criteria) this;
        }

        public Criteria andPragramValueNotBetween(String value1, String value2) {
            addCriterion("pragram_value not between", value1, value2, "pragramValue");
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

        public Criteria andProgramContentIsNull() {
            addCriterion("program_content is null");
            return (Criteria) this;
        }

        public Criteria andProgramContentIsNotNull() {
            addCriterion("program_content is not null");
            return (Criteria) this;
        }

        public Criteria andProgramContentEqualTo(String value) {
            addCriterion("program_content =", value, "programContent");
            return (Criteria) this;
        }

        public Criteria andProgramContentNotEqualTo(String value) {
            addCriterion("program_content <>", value, "programContent");
            return (Criteria) this;
        }

        public Criteria andProgramContentGreaterThan(String value) {
            addCriterion("program_content >", value, "programContent");
            return (Criteria) this;
        }

        public Criteria andProgramContentGreaterThanOrEqualTo(String value) {
            addCriterion("program_content >=", value, "programContent");
            return (Criteria) this;
        }

        public Criteria andProgramContentLessThan(String value) {
            addCriterion("program_content <", value, "programContent");
            return (Criteria) this;
        }

        public Criteria andProgramContentLessThanOrEqualTo(String value) {
            addCriterion("program_content <=", value, "programContent");
            return (Criteria) this;
        }

        public Criteria andProgramContentLike(String value) {
            addCriterion("program_content like", value, "programContent");
            return (Criteria) this;
        }

        public Criteria andProgramContentNotLike(String value) {
            addCriterion("program_content not like", value, "programContent");
            return (Criteria) this;
        }

        public Criteria andProgramContentIn(List<String> values) {
            addCriterion("program_content in", values, "programContent");
            return (Criteria) this;
        }

        public Criteria andProgramContentNotIn(List<String> values) {
            addCriterion("program_content not in", values, "programContent");
            return (Criteria) this;
        }

        public Criteria andProgramContentBetween(String value1, String value2) {
            addCriterion("program_content between", value1, value2, "programContent");
            return (Criteria) this;
        }

        public Criteria andProgramContentNotBetween(String value1, String value2) {
            addCriterion("program_content not between", value1, value2, "programContent");
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

        public Criteria andDeepIsNull() {
            addCriterion("deep is null");
            return (Criteria) this;
        }

        public Criteria andDeepIsNotNull() {
            addCriterion("deep is not null");
            return (Criteria) this;
        }

        public Criteria andDeepEqualTo(Integer value) {
            addCriterion("deep =", value, "deep");
            return (Criteria) this;
        }

        public Criteria andDeepNotEqualTo(Integer value) {
            addCriterion("deep <>", value, "deep");
            return (Criteria) this;
        }

        public Criteria andDeepGreaterThan(Integer value) {
            addCriterion("deep >", value, "deep");
            return (Criteria) this;
        }

        public Criteria andDeepGreaterThanOrEqualTo(Integer value) {
            addCriterion("deep >=", value, "deep");
            return (Criteria) this;
        }

        public Criteria andDeepLessThan(Integer value) {
            addCriterion("deep <", value, "deep");
            return (Criteria) this;
        }

        public Criteria andDeepLessThanOrEqualTo(Integer value) {
            addCriterion("deep <=", value, "deep");
            return (Criteria) this;
        }

        public Criteria andDeepIn(List<Integer> values) {
            addCriterion("deep in", values, "deep");
            return (Criteria) this;
        }

        public Criteria andDeepNotIn(List<Integer> values) {
            addCriterion("deep not in", values, "deep");
            return (Criteria) this;
        }

        public Criteria andDeepBetween(Integer value1, Integer value2) {
            addCriterion("deep between", value1, value2, "deep");
            return (Criteria) this;
        }

        public Criteria andDeepNotBetween(Integer value1, Integer value2) {
            addCriterion("deep not between", value1, value2, "deep");
            return (Criteria) this;
        }

        public Criteria andFatherIdIsNull() {
            addCriterion("father_id is null");
            return (Criteria) this;
        }

        public Criteria andFatherIdIsNotNull() {
            addCriterion("father_id is not null");
            return (Criteria) this;
        }

        public Criteria andFatherIdEqualTo(Integer value) {
            addCriterion("father_id =", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdNotEqualTo(Integer value) {
            addCriterion("father_id <>", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdGreaterThan(Integer value) {
            addCriterion("father_id >", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("father_id >=", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdLessThan(Integer value) {
            addCriterion("father_id <", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdLessThanOrEqualTo(Integer value) {
            addCriterion("father_id <=", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdIn(List<Integer> values) {
            addCriterion("father_id in", values, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdNotIn(List<Integer> values) {
            addCriterion("father_id not in", values, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdBetween(Integer value1, Integer value2) {
            addCriterion("father_id between", value1, value2, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("father_id not between", value1, value2, "fatherId");
            return (Criteria) this;
        }

        public Criteria andNeedAddIsNull() {
            addCriterion("need_add is null");
            return (Criteria) this;
        }

        public Criteria andNeedAddIsNotNull() {
            addCriterion("need_add is not null");
            return (Criteria) this;
        }

        public Criteria andNeedAddEqualTo(Integer value) {
            addCriterion("need_add =", value, "needAdd");
            return (Criteria) this;
        }

        public Criteria andNeedAddNotEqualTo(Integer value) {
            addCriterion("need_add <>", value, "needAdd");
            return (Criteria) this;
        }

        public Criteria andNeedAddGreaterThan(Integer value) {
            addCriterion("need_add >", value, "needAdd");
            return (Criteria) this;
        }

        public Criteria andNeedAddGreaterThanOrEqualTo(Integer value) {
            addCriterion("need_add >=", value, "needAdd");
            return (Criteria) this;
        }

        public Criteria andNeedAddLessThan(Integer value) {
            addCriterion("need_add <", value, "needAdd");
            return (Criteria) this;
        }

        public Criteria andNeedAddLessThanOrEqualTo(Integer value) {
            addCriterion("need_add <=", value, "needAdd");
            return (Criteria) this;
        }

        public Criteria andNeedAddIn(List<Integer> values) {
            addCriterion("need_add in", values, "needAdd");
            return (Criteria) this;
        }

        public Criteria andNeedAddNotIn(List<Integer> values) {
            addCriterion("need_add not in", values, "needAdd");
            return (Criteria) this;
        }

        public Criteria andNeedAddBetween(Integer value1, Integer value2) {
            addCriterion("need_add between", value1, value2, "needAdd");
            return (Criteria) this;
        }

        public Criteria andNeedAddNotBetween(Integer value1, Integer value2) {
            addCriterion("need_add not between", value1, value2, "needAdd");
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