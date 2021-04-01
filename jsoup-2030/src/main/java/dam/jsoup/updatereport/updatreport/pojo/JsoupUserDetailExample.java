package dam.jsoup.updatereport.updatreport.pojo;

import java.util.ArrayList;
import java.util.List;

public class JsoupUserDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JsoupUserDetailExample() {
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

        public Criteria andUserDetailIdIsNull() {
            addCriterion("user_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andUserDetailIdIsNotNull() {
            addCriterion("user_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserDetailIdEqualTo(Integer value) {
            addCriterion("user_detail_id =", value, "userDetailId");
            return (Criteria) this;
        }

        public Criteria andUserDetailIdNotEqualTo(Integer value) {
            addCriterion("user_detail_id <>", value, "userDetailId");
            return (Criteria) this;
        }

        public Criteria andUserDetailIdGreaterThan(Integer value) {
            addCriterion("user_detail_id >", value, "userDetailId");
            return (Criteria) this;
        }

        public Criteria andUserDetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_detail_id >=", value, "userDetailId");
            return (Criteria) this;
        }

        public Criteria andUserDetailIdLessThan(Integer value) {
            addCriterion("user_detail_id <", value, "userDetailId");
            return (Criteria) this;
        }

        public Criteria andUserDetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_detail_id <=", value, "userDetailId");
            return (Criteria) this;
        }

        public Criteria andUserDetailIdIn(List<Integer> values) {
            addCriterion("user_detail_id in", values, "userDetailId");
            return (Criteria) this;
        }

        public Criteria andUserDetailIdNotIn(List<Integer> values) {
            addCriterion("user_detail_id not in", values, "userDetailId");
            return (Criteria) this;
        }

        public Criteria andUserDetailIdBetween(Integer value1, Integer value2) {
            addCriterion("user_detail_id between", value1, value2, "userDetailId");
            return (Criteria) this;
        }

        public Criteria andUserDetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_detail_id not between", value1, value2, "userDetailId");
            return (Criteria) this;
        }

        public Criteria andUserRealNameIsNull() {
            addCriterion("user_real_name is null");
            return (Criteria) this;
        }

        public Criteria andUserRealNameIsNotNull() {
            addCriterion("user_real_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserRealNameEqualTo(String value) {
            addCriterion("user_real_name =", value, "userRealName");
            return (Criteria) this;
        }

        public Criteria andUserRealNameNotEqualTo(String value) {
            addCriterion("user_real_name <>", value, "userRealName");
            return (Criteria) this;
        }

        public Criteria andUserRealNameGreaterThan(String value) {
            addCriterion("user_real_name >", value, "userRealName");
            return (Criteria) this;
        }

        public Criteria andUserRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_real_name >=", value, "userRealName");
            return (Criteria) this;
        }

        public Criteria andUserRealNameLessThan(String value) {
            addCriterion("user_real_name <", value, "userRealName");
            return (Criteria) this;
        }

        public Criteria andUserRealNameLessThanOrEqualTo(String value) {
            addCriterion("user_real_name <=", value, "userRealName");
            return (Criteria) this;
        }

        public Criteria andUserRealNameLike(String value) {
            addCriterion("user_real_name like", value, "userRealName");
            return (Criteria) this;
        }

        public Criteria andUserRealNameNotLike(String value) {
            addCriterion("user_real_name not like", value, "userRealName");
            return (Criteria) this;
        }

        public Criteria andUserRealNameIn(List<String> values) {
            addCriterion("user_real_name in", values, "userRealName");
            return (Criteria) this;
        }

        public Criteria andUserRealNameNotIn(List<String> values) {
            addCriterion("user_real_name not in", values, "userRealName");
            return (Criteria) this;
        }

        public Criteria andUserRealNameBetween(String value1, String value2) {
            addCriterion("user_real_name between", value1, value2, "userRealName");
            return (Criteria) this;
        }

        public Criteria andUserRealNameNotBetween(String value1, String value2) {
            addCriterion("user_real_name not between", value1, value2, "userRealName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameIsNull() {
            addCriterion("user_nick_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNickNameIsNotNull() {
            addCriterion("user_nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNickNameEqualTo(String value) {
            addCriterion("user_nick_name =", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameNotEqualTo(String value) {
            addCriterion("user_nick_name <>", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameGreaterThan(String value) {
            addCriterion("user_nick_name >", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_nick_name >=", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameLessThan(String value) {
            addCriterion("user_nick_name <", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameLessThanOrEqualTo(String value) {
            addCriterion("user_nick_name <=", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameLike(String value) {
            addCriterion("user_nick_name like", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameNotLike(String value) {
            addCriterion("user_nick_name not like", value, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameIn(List<String> values) {
            addCriterion("user_nick_name in", values, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameNotIn(List<String> values) {
            addCriterion("user_nick_name not in", values, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameBetween(String value1, String value2) {
            addCriterion("user_nick_name between", value1, value2, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserNickNameNotBetween(String value1, String value2) {
            addCriterion("user_nick_name not between", value1, value2, "userNickName");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlIsNull() {
            addCriterion("user_image_url is null");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlIsNotNull() {
            addCriterion("user_image_url is not null");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlEqualTo(String value) {
            addCriterion("user_image_url =", value, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlNotEqualTo(String value) {
            addCriterion("user_image_url <>", value, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlGreaterThan(String value) {
            addCriterion("user_image_url >", value, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("user_image_url >=", value, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlLessThan(String value) {
            addCriterion("user_image_url <", value, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlLessThanOrEqualTo(String value) {
            addCriterion("user_image_url <=", value, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlLike(String value) {
            addCriterion("user_image_url like", value, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlNotLike(String value) {
            addCriterion("user_image_url not like", value, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlIn(List<String> values) {
            addCriterion("user_image_url in", values, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlNotIn(List<String> values) {
            addCriterion("user_image_url not in", values, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlBetween(String value1, String value2) {
            addCriterion("user_image_url between", value1, value2, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlNotBetween(String value1, String value2) {
            addCriterion("user_image_url not between", value1, value2, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserDesIsNull() {
            addCriterion("user_des is null");
            return (Criteria) this;
        }

        public Criteria andUserDesIsNotNull() {
            addCriterion("user_des is not null");
            return (Criteria) this;
        }

        public Criteria andUserDesEqualTo(String value) {
            addCriterion("user_des =", value, "userDes");
            return (Criteria) this;
        }

        public Criteria andUserDesNotEqualTo(String value) {
            addCriterion("user_des <>", value, "userDes");
            return (Criteria) this;
        }

        public Criteria andUserDesGreaterThan(String value) {
            addCriterion("user_des >", value, "userDes");
            return (Criteria) this;
        }

        public Criteria andUserDesGreaterThanOrEqualTo(String value) {
            addCriterion("user_des >=", value, "userDes");
            return (Criteria) this;
        }

        public Criteria andUserDesLessThan(String value) {
            addCriterion("user_des <", value, "userDes");
            return (Criteria) this;
        }

        public Criteria andUserDesLessThanOrEqualTo(String value) {
            addCriterion("user_des <=", value, "userDes");
            return (Criteria) this;
        }

        public Criteria andUserDesLike(String value) {
            addCriterion("user_des like", value, "userDes");
            return (Criteria) this;
        }

        public Criteria andUserDesNotLike(String value) {
            addCriterion("user_des not like", value, "userDes");
            return (Criteria) this;
        }

        public Criteria andUserDesIn(List<String> values) {
            addCriterion("user_des in", values, "userDes");
            return (Criteria) this;
        }

        public Criteria andUserDesNotIn(List<String> values) {
            addCriterion("user_des not in", values, "userDes");
            return (Criteria) this;
        }

        public Criteria andUserDesBetween(String value1, String value2) {
            addCriterion("user_des between", value1, value2, "userDes");
            return (Criteria) this;
        }

        public Criteria andUserDesNotBetween(String value1, String value2) {
            addCriterion("user_des not between", value1, value2, "userDes");
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

        public Criteria andUserEmailIsNull() {
            addCriterion("user_email is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("user_email is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("user_email =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("user_email <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("user_email >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("user_email >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("user_email <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("user_email <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("user_email like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("user_email not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("user_email in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("user_email not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("user_email between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("user_email not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserSalenumIsNull() {
            addCriterion("user_saleNum is null");
            return (Criteria) this;
        }

        public Criteria andUserSalenumIsNotNull() {
            addCriterion("user_saleNum is not null");
            return (Criteria) this;
        }

        public Criteria andUserSalenumEqualTo(Integer value) {
            addCriterion("user_saleNum =", value, "userSalenum");
            return (Criteria) this;
        }

        public Criteria andUserSalenumNotEqualTo(Integer value) {
            addCriterion("user_saleNum <>", value, "userSalenum");
            return (Criteria) this;
        }

        public Criteria andUserSalenumGreaterThan(Integer value) {
            addCriterion("user_saleNum >", value, "userSalenum");
            return (Criteria) this;
        }

        public Criteria andUserSalenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_saleNum >=", value, "userSalenum");
            return (Criteria) this;
        }

        public Criteria andUserSalenumLessThan(Integer value) {
            addCriterion("user_saleNum <", value, "userSalenum");
            return (Criteria) this;
        }

        public Criteria andUserSalenumLessThanOrEqualTo(Integer value) {
            addCriterion("user_saleNum <=", value, "userSalenum");
            return (Criteria) this;
        }

        public Criteria andUserSalenumIn(List<Integer> values) {
            addCriterion("user_saleNum in", values, "userSalenum");
            return (Criteria) this;
        }

        public Criteria andUserSalenumNotIn(List<Integer> values) {
            addCriterion("user_saleNum not in", values, "userSalenum");
            return (Criteria) this;
        }

        public Criteria andUserSalenumBetween(Integer value1, Integer value2) {
            addCriterion("user_saleNum between", value1, value2, "userSalenum");
            return (Criteria) this;
        }

        public Criteria andUserSalenumNotBetween(Integer value1, Integer value2) {
            addCriterion("user_saleNum not between", value1, value2, "userSalenum");
            return (Criteria) this;
        }

        public Criteria andUserGoodrateIsNull() {
            addCriterion("user_goodRate is null");
            return (Criteria) this;
        }

        public Criteria andUserGoodrateIsNotNull() {
            addCriterion("user_goodRate is not null");
            return (Criteria) this;
        }

        public Criteria andUserGoodrateEqualTo(String value) {
            addCriterion("user_goodRate =", value, "userGoodrate");
            return (Criteria) this;
        }

        public Criteria andUserGoodrateNotEqualTo(String value) {
            addCriterion("user_goodRate <>", value, "userGoodrate");
            return (Criteria) this;
        }

        public Criteria andUserGoodrateGreaterThan(String value) {
            addCriterion("user_goodRate >", value, "userGoodrate");
            return (Criteria) this;
        }

        public Criteria andUserGoodrateGreaterThanOrEqualTo(String value) {
            addCriterion("user_goodRate >=", value, "userGoodrate");
            return (Criteria) this;
        }

        public Criteria andUserGoodrateLessThan(String value) {
            addCriterion("user_goodRate <", value, "userGoodrate");
            return (Criteria) this;
        }

        public Criteria andUserGoodrateLessThanOrEqualTo(String value) {
            addCriterion("user_goodRate <=", value, "userGoodrate");
            return (Criteria) this;
        }

        public Criteria andUserGoodrateLike(String value) {
            addCriterion("user_goodRate like", value, "userGoodrate");
            return (Criteria) this;
        }

        public Criteria andUserGoodrateNotLike(String value) {
            addCriterion("user_goodRate not like", value, "userGoodrate");
            return (Criteria) this;
        }

        public Criteria andUserGoodrateIn(List<String> values) {
            addCriterion("user_goodRate in", values, "userGoodrate");
            return (Criteria) this;
        }

        public Criteria andUserGoodrateNotIn(List<String> values) {
            addCriterion("user_goodRate not in", values, "userGoodrate");
            return (Criteria) this;
        }

        public Criteria andUserGoodrateBetween(String value1, String value2) {
            addCriterion("user_goodRate between", value1, value2, "userGoodrate");
            return (Criteria) this;
        }

        public Criteria andUserGoodrateNotBetween(String value1, String value2) {
            addCriterion("user_goodRate not between", value1, value2, "userGoodrate");
            return (Criteria) this;
        }

        public Criteria andUserLeverIsNull() {
            addCriterion("user_lever is null");
            return (Criteria) this;
        }

        public Criteria andUserLeverIsNotNull() {
            addCriterion("user_lever is not null");
            return (Criteria) this;
        }

        public Criteria andUserLeverEqualTo(String value) {
            addCriterion("user_lever =", value, "userLever");
            return (Criteria) this;
        }

        public Criteria andUserLeverNotEqualTo(String value) {
            addCriterion("user_lever <>", value, "userLever");
            return (Criteria) this;
        }

        public Criteria andUserLeverGreaterThan(String value) {
            addCriterion("user_lever >", value, "userLever");
            return (Criteria) this;
        }

        public Criteria andUserLeverGreaterThanOrEqualTo(String value) {
            addCriterion("user_lever >=", value, "userLever");
            return (Criteria) this;
        }

        public Criteria andUserLeverLessThan(String value) {
            addCriterion("user_lever <", value, "userLever");
            return (Criteria) this;
        }

        public Criteria andUserLeverLessThanOrEqualTo(String value) {
            addCriterion("user_lever <=", value, "userLever");
            return (Criteria) this;
        }

        public Criteria andUserLeverLike(String value) {
            addCriterion("user_lever like", value, "userLever");
            return (Criteria) this;
        }

        public Criteria andUserLeverNotLike(String value) {
            addCriterion("user_lever not like", value, "userLever");
            return (Criteria) this;
        }

        public Criteria andUserLeverIn(List<String> values) {
            addCriterion("user_lever in", values, "userLever");
            return (Criteria) this;
        }

        public Criteria andUserLeverNotIn(List<String> values) {
            addCriterion("user_lever not in", values, "userLever");
            return (Criteria) this;
        }

        public Criteria andUserLeverBetween(String value1, String value2) {
            addCriterion("user_lever between", value1, value2, "userLever");
            return (Criteria) this;
        }

        public Criteria andUserLeverNotBetween(String value1, String value2) {
            addCriterion("user_lever not between", value1, value2, "userLever");
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