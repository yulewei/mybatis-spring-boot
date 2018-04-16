package com.example.entity.criteria;

import java.util.ArrayList;
import java.util.List;

public class DeviceInfoExample {
    /**
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated
     */
    public DeviceInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(String value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(String value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(String value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(String value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLike(String value) {
            addCriterion("device_id like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotLike(String value) {
            addCriterion("device_id not like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<String> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<String> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(String value1, String value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(String value1, String value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceTokenIsNull() {
            addCriterion("device_token is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTokenIsNotNull() {
            addCriterion("device_token is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTokenEqualTo(String value) {
            addCriterion("device_token =", value, "deviceToken");
            return (Criteria) this;
        }

        public Criteria andDeviceTokenNotEqualTo(String value) {
            addCriterion("device_token <>", value, "deviceToken");
            return (Criteria) this;
        }

        public Criteria andDeviceTokenGreaterThan(String value) {
            addCriterion("device_token >", value, "deviceToken");
            return (Criteria) this;
        }

        public Criteria andDeviceTokenGreaterThanOrEqualTo(String value) {
            addCriterion("device_token >=", value, "deviceToken");
            return (Criteria) this;
        }

        public Criteria andDeviceTokenLessThan(String value) {
            addCriterion("device_token <", value, "deviceToken");
            return (Criteria) this;
        }

        public Criteria andDeviceTokenLessThanOrEqualTo(String value) {
            addCriterion("device_token <=", value, "deviceToken");
            return (Criteria) this;
        }

        public Criteria andDeviceTokenLike(String value) {
            addCriterion("device_token like", value, "deviceToken");
            return (Criteria) this;
        }

        public Criteria andDeviceTokenNotLike(String value) {
            addCriterion("device_token not like", value, "deviceToken");
            return (Criteria) this;
        }

        public Criteria andDeviceTokenIn(List<String> values) {
            addCriterion("device_token in", values, "deviceToken");
            return (Criteria) this;
        }

        public Criteria andDeviceTokenNotIn(List<String> values) {
            addCriterion("device_token not in", values, "deviceToken");
            return (Criteria) this;
        }

        public Criteria andDeviceTokenBetween(String value1, String value2) {
            addCriterion("device_token between", value1, value2, "deviceToken");
            return (Criteria) this;
        }

        public Criteria andDeviceTokenNotBetween(String value1, String value2) {
            addCriterion("device_token not between", value1, value2, "deviceToken");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Long value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Long value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Long value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Long value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Long value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Long value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Long> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Long> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Long value1, Long value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Long value1, Long value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andCreatetmIsNull() {
            addCriterion("createtm is null");
            return (Criteria) this;
        }

        public Criteria andCreatetmIsNotNull() {
            addCriterion("createtm is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetmEqualTo(Long value) {
            addCriterion("createtm =", value, "createtm");
            return (Criteria) this;
        }

        public Criteria andCreatetmNotEqualTo(Long value) {
            addCriterion("createtm <>", value, "createtm");
            return (Criteria) this;
        }

        public Criteria andCreatetmGreaterThan(Long value) {
            addCriterion("createtm >", value, "createtm");
            return (Criteria) this;
        }

        public Criteria andCreatetmGreaterThanOrEqualTo(Long value) {
            addCriterion("createtm >=", value, "createtm");
            return (Criteria) this;
        }

        public Criteria andCreatetmLessThan(Long value) {
            addCriterion("createtm <", value, "createtm");
            return (Criteria) this;
        }

        public Criteria andCreatetmLessThanOrEqualTo(Long value) {
            addCriterion("createtm <=", value, "createtm");
            return (Criteria) this;
        }

        public Criteria andCreatetmIn(List<Long> values) {
            addCriterion("createtm in", values, "createtm");
            return (Criteria) this;
        }

        public Criteria andCreatetmNotIn(List<Long> values) {
            addCriterion("createtm not in", values, "createtm");
            return (Criteria) this;
        }

        public Criteria andCreatetmBetween(Long value1, Long value2) {
            addCriterion("createtm between", value1, value2, "createtm");
            return (Criteria) this;
        }

        public Criteria andCreatetmNotBetween(Long value1, Long value2) {
            addCriterion("createtm not between", value1, value2, "createtm");
            return (Criteria) this;
        }

        public Criteria andUpdatetmIsNull() {
            addCriterion("updatetm is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetmIsNotNull() {
            addCriterion("updatetm is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetmEqualTo(Long value) {
            addCriterion("updatetm =", value, "updatetm");
            return (Criteria) this;
        }

        public Criteria andUpdatetmNotEqualTo(Long value) {
            addCriterion("updatetm <>", value, "updatetm");
            return (Criteria) this;
        }

        public Criteria andUpdatetmGreaterThan(Long value) {
            addCriterion("updatetm >", value, "updatetm");
            return (Criteria) this;
        }

        public Criteria andUpdatetmGreaterThanOrEqualTo(Long value) {
            addCriterion("updatetm >=", value, "updatetm");
            return (Criteria) this;
        }

        public Criteria andUpdatetmLessThan(Long value) {
            addCriterion("updatetm <", value, "updatetm");
            return (Criteria) this;
        }

        public Criteria andUpdatetmLessThanOrEqualTo(Long value) {
            addCriterion("updatetm <=", value, "updatetm");
            return (Criteria) this;
        }

        public Criteria andUpdatetmIn(List<Long> values) {
            addCriterion("updatetm in", values, "updatetm");
            return (Criteria) this;
        }

        public Criteria andUpdatetmNotIn(List<Long> values) {
            addCriterion("updatetm not in", values, "updatetm");
            return (Criteria) this;
        }

        public Criteria andUpdatetmBetween(Long value1, Long value2) {
            addCriterion("updatetm between", value1, value2, "updatetm");
            return (Criteria) this;
        }

        public Criteria andUpdatetmNotBetween(Long value1, Long value2) {
            addCriterion("updatetm not between", value1, value2, "updatetm");
            return (Criteria) this;
        }

        public Criteria andLogoutIsNull() {
            addCriterion("logout is null");
            return (Criteria) this;
        }

        public Criteria andLogoutIsNotNull() {
            addCriterion("logout is not null");
            return (Criteria) this;
        }

        public Criteria andLogoutEqualTo(Byte value) {
            addCriterion("logout =", value, "logout");
            return (Criteria) this;
        }

        public Criteria andLogoutNotEqualTo(Byte value) {
            addCriterion("logout <>", value, "logout");
            return (Criteria) this;
        }

        public Criteria andLogoutGreaterThan(Byte value) {
            addCriterion("logout >", value, "logout");
            return (Criteria) this;
        }

        public Criteria andLogoutGreaterThanOrEqualTo(Byte value) {
            addCriterion("logout >=", value, "logout");
            return (Criteria) this;
        }

        public Criteria andLogoutLessThan(Byte value) {
            addCriterion("logout <", value, "logout");
            return (Criteria) this;
        }

        public Criteria andLogoutLessThanOrEqualTo(Byte value) {
            addCriterion("logout <=", value, "logout");
            return (Criteria) this;
        }

        public Criteria andLogoutIn(List<Byte> values) {
            addCriterion("logout in", values, "logout");
            return (Criteria) this;
        }

        public Criteria andLogoutNotIn(List<Byte> values) {
            addCriterion("logout not in", values, "logout");
            return (Criteria) this;
        }

        public Criteria andLogoutBetween(Byte value1, Byte value2) {
            addCriterion("logout between", value1, value2, "logout");
            return (Criteria) this;
        }

        public Criteria andLogoutNotBetween(Byte value1, Byte value2) {
            addCriterion("logout not between", value1, value2, "logout");
            return (Criteria) this;
        }
    }

    /**
     * @mbg.generated
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * @mbg.generated
     */
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