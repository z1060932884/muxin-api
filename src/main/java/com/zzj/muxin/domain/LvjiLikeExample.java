package com.zzj.muxin.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LvjiLikeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LvjiLikeExample() {
        oredCriteria = new ArrayList<Criteria>();
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNull() {
            addCriterion("create_at is null");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNotNull() {
            addCriterion("create_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAtEqualTo(Date value) {
            addCriterion("create_at =", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotEqualTo(Date value) {
            addCriterion("create_at <>", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThan(Date value) {
            addCriterion("create_at >", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("create_at >=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThan(Date value) {
            addCriterion("create_at <", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanOrEqualTo(Date value) {
            addCriterion("create_at <=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtIn(List<Date> values) {
            addCriterion("create_at in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotIn(List<Date> values) {
            addCriterion("create_at not in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtBetween(Date value1, Date value2) {
            addCriterion("create_at between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotBetween(Date value1, Date value2) {
            addCriterion("create_at not between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNull() {
            addCriterion("update_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNotNull() {
            addCriterion("update_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtEqualTo(Date value) {
            addCriterion("update_at =", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotEqualTo(Date value) {
            addCriterion("update_at <>", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThan(Date value) {
            addCriterion("update_at >", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("update_at >=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThan(Date value) {
            addCriterion("update_at <", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThanOrEqualTo(Date value) {
            addCriterion("update_at <=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIn(List<Date> values) {
            addCriterion("update_at in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotIn(List<Date> values) {
            addCriterion("update_at not in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtBetween(Date value1, Date value2) {
            addCriterion("update_at between", value1, value2, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotBetween(Date value1, Date value2) {
            addCriterion("update_at not between", value1, value2, "updateAt");
            return (Criteria) this;
        }

        public Criteria andFaceImageIsNull() {
            addCriterion("face_image is null");
            return (Criteria) this;
        }

        public Criteria andFaceImageIsNotNull() {
            addCriterion("face_image is not null");
            return (Criteria) this;
        }

        public Criteria andFaceImageEqualTo(String value) {
            addCriterion("face_image =", value, "faceImage");
            return (Criteria) this;
        }

        public Criteria andFaceImageNotEqualTo(String value) {
            addCriterion("face_image <>", value, "faceImage");
            return (Criteria) this;
        }

        public Criteria andFaceImageGreaterThan(String value) {
            addCriterion("face_image >", value, "faceImage");
            return (Criteria) this;
        }

        public Criteria andFaceImageGreaterThanOrEqualTo(String value) {
            addCriterion("face_image >=", value, "faceImage");
            return (Criteria) this;
        }

        public Criteria andFaceImageLessThan(String value) {
            addCriterion("face_image <", value, "faceImage");
            return (Criteria) this;
        }

        public Criteria andFaceImageLessThanOrEqualTo(String value) {
            addCriterion("face_image <=", value, "faceImage");
            return (Criteria) this;
        }

        public Criteria andFaceImageLike(String value) {
            addCriterion("face_image like", value, "faceImage");
            return (Criteria) this;
        }

        public Criteria andFaceImageNotLike(String value) {
            addCriterion("face_image not like", value, "faceImage");
            return (Criteria) this;
        }

        public Criteria andFaceImageIn(List<String> values) {
            addCriterion("face_image in", values, "faceImage");
            return (Criteria) this;
        }

        public Criteria andFaceImageNotIn(List<String> values) {
            addCriterion("face_image not in", values, "faceImage");
            return (Criteria) this;
        }

        public Criteria andFaceImageBetween(String value1, String value2) {
            addCriterion("face_image between", value1, value2, "faceImage");
            return (Criteria) this;
        }

        public Criteria andFaceImageNotBetween(String value1, String value2) {
            addCriterion("face_image not between", value1, value2, "faceImage");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdIsNull() {
            addCriterion("like_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdIsNotNull() {
            addCriterion("like_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdEqualTo(String value) {
            addCriterion("like_user_id =", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdNotEqualTo(String value) {
            addCriterion("like_user_id <>", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdGreaterThan(String value) {
            addCriterion("like_user_id >", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("like_user_id >=", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdLessThan(String value) {
            addCriterion("like_user_id <", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdLessThanOrEqualTo(String value) {
            addCriterion("like_user_id <=", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdLike(String value) {
            addCriterion("like_user_id like", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdNotLike(String value) {
            addCriterion("like_user_id not like", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdIn(List<String> values) {
            addCriterion("like_user_id in", values, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdNotIn(List<String> values) {
            addCriterion("like_user_id not in", values, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdBetween(String value1, String value2) {
            addCriterion("like_user_id between", value1, value2, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdNotBetween(String value1, String value2) {
            addCriterion("like_user_id not between", value1, value2, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andPublishIdIsNull() {
            addCriterion("publish_id is null");
            return (Criteria) this;
        }

        public Criteria andPublishIdIsNotNull() {
            addCriterion("publish_id is not null");
            return (Criteria) this;
        }

        public Criteria andPublishIdEqualTo(String value) {
            addCriterion("publish_id =", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdNotEqualTo(String value) {
            addCriterion("publish_id <>", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdGreaterThan(String value) {
            addCriterion("publish_id >", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdGreaterThanOrEqualTo(String value) {
            addCriterion("publish_id >=", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdLessThan(String value) {
            addCriterion("publish_id <", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdLessThanOrEqualTo(String value) {
            addCriterion("publish_id <=", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdLike(String value) {
            addCriterion("publish_id like", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdNotLike(String value) {
            addCriterion("publish_id not like", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdIn(List<String> values) {
            addCriterion("publish_id in", values, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdNotIn(List<String> values) {
            addCriterion("publish_id not in", values, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdBetween(String value1, String value2) {
            addCriterion("publish_id between", value1, value2, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdNotBetween(String value1, String value2) {
            addCriterion("publish_id not between", value1, value2, "publishId");
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