package com.zzj.muxin.domain;

import java.util.ArrayList;
import java.util.List;

public class ChatUsersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChatUsersExample() {
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
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

        public Criteria andFaceImageBigIsNull() {
            addCriterion("face_image_big is null");
            return (Criteria) this;
        }

        public Criteria andFaceImageBigIsNotNull() {
            addCriterion("face_image_big is not null");
            return (Criteria) this;
        }

        public Criteria andFaceImageBigEqualTo(String value) {
            addCriterion("face_image_big =", value, "faceImageBig");
            return (Criteria) this;
        }

        public Criteria andFaceImageBigNotEqualTo(String value) {
            addCriterion("face_image_big <>", value, "faceImageBig");
            return (Criteria) this;
        }

        public Criteria andFaceImageBigGreaterThan(String value) {
            addCriterion("face_image_big >", value, "faceImageBig");
            return (Criteria) this;
        }

        public Criteria andFaceImageBigGreaterThanOrEqualTo(String value) {
            addCriterion("face_image_big >=", value, "faceImageBig");
            return (Criteria) this;
        }

        public Criteria andFaceImageBigLessThan(String value) {
            addCriterion("face_image_big <", value, "faceImageBig");
            return (Criteria) this;
        }

        public Criteria andFaceImageBigLessThanOrEqualTo(String value) {
            addCriterion("face_image_big <=", value, "faceImageBig");
            return (Criteria) this;
        }

        public Criteria andFaceImageBigLike(String value) {
            addCriterion("face_image_big like", value, "faceImageBig");
            return (Criteria) this;
        }

        public Criteria andFaceImageBigNotLike(String value) {
            addCriterion("face_image_big not like", value, "faceImageBig");
            return (Criteria) this;
        }

        public Criteria andFaceImageBigIn(List<String> values) {
            addCriterion("face_image_big in", values, "faceImageBig");
            return (Criteria) this;
        }

        public Criteria andFaceImageBigNotIn(List<String> values) {
            addCriterion("face_image_big not in", values, "faceImageBig");
            return (Criteria) this;
        }

        public Criteria andFaceImageBigBetween(String value1, String value2) {
            addCriterion("face_image_big between", value1, value2, "faceImageBig");
            return (Criteria) this;
        }

        public Criteria andFaceImageBigNotBetween(String value1, String value2) {
            addCriterion("face_image_big not between", value1, value2, "faceImageBig");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andQrcodeIsNull() {
            addCriterion("qrcode is null");
            return (Criteria) this;
        }

        public Criteria andQrcodeIsNotNull() {
            addCriterion("qrcode is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodeEqualTo(String value) {
            addCriterion("qrcode =", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeNotEqualTo(String value) {
            addCriterion("qrcode <>", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeGreaterThan(String value) {
            addCriterion("qrcode >", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("qrcode >=", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeLessThan(String value) {
            addCriterion("qrcode <", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeLessThanOrEqualTo(String value) {
            addCriterion("qrcode <=", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeLike(String value) {
            addCriterion("qrcode like", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeNotLike(String value) {
            addCriterion("qrcode not like", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeIn(List<String> values) {
            addCriterion("qrcode in", values, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeNotIn(List<String> values) {
            addCriterion("qrcode not in", values, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeBetween(String value1, String value2) {
            addCriterion("qrcode between", value1, value2, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeNotBetween(String value1, String value2) {
            addCriterion("qrcode not between", value1, value2, "qrcode");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(String value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(String value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(String value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(String value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(String value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(String value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLike(String value) {
            addCriterion("cid like", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotLike(String value) {
            addCriterion("cid not like", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<String> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<String> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(String value1, String value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(String value1, String value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andChatSexIsNull() {
            addCriterion("chat_sex is null");
            return (Criteria) this;
        }

        public Criteria andChatSexIsNotNull() {
            addCriterion("chat_sex is not null");
            return (Criteria) this;
        }

        public Criteria andChatSexEqualTo(Integer value) {
            addCriterion("chat_sex =", value, "chatSex");
            return (Criteria) this;
        }

        public Criteria andChatSexNotEqualTo(Integer value) {
            addCriterion("chat_sex <>", value, "chatSex");
            return (Criteria) this;
        }

        public Criteria andChatSexGreaterThan(Integer value) {
            addCriterion("chat_sex >", value, "chatSex");
            return (Criteria) this;
        }

        public Criteria andChatSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("chat_sex >=", value, "chatSex");
            return (Criteria) this;
        }

        public Criteria andChatSexLessThan(Integer value) {
            addCriterion("chat_sex <", value, "chatSex");
            return (Criteria) this;
        }

        public Criteria andChatSexLessThanOrEqualTo(Integer value) {
            addCriterion("chat_sex <=", value, "chatSex");
            return (Criteria) this;
        }

        public Criteria andChatSexIn(List<Integer> values) {
            addCriterion("chat_sex in", values, "chatSex");
            return (Criteria) this;
        }

        public Criteria andChatSexNotIn(List<Integer> values) {
            addCriterion("chat_sex not in", values, "chatSex");
            return (Criteria) this;
        }

        public Criteria andChatSexBetween(Integer value1, Integer value2) {
            addCriterion("chat_sex between", value1, value2, "chatSex");
            return (Criteria) this;
        }

        public Criteria andChatSexNotBetween(Integer value1, Integer value2) {
            addCriterion("chat_sex not between", value1, value2, "chatSex");
            return (Criteria) this;
        }

        public Criteria andProfessionalIsNull() {
            addCriterion("professional is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalIsNotNull() {
            addCriterion("professional is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalEqualTo(String value) {
            addCriterion("professional =", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotEqualTo(String value) {
            addCriterion("professional <>", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalGreaterThan(String value) {
            addCriterion("professional >", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalGreaterThanOrEqualTo(String value) {
            addCriterion("professional >=", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalLessThan(String value) {
            addCriterion("professional <", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalLessThanOrEqualTo(String value) {
            addCriterion("professional <=", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalLike(String value) {
            addCriterion("professional like", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotLike(String value) {
            addCriterion("professional not like", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalIn(List<String> values) {
            addCriterion("professional in", values, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotIn(List<String> values) {
            addCriterion("professional not in", values, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalBetween(String value1, String value2) {
            addCriterion("professional between", value1, value2, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotBetween(String value1, String value2) {
            addCriterion("professional not between", value1, value2, "professional");
            return (Criteria) this;
        }

        public Criteria andBswAgeIsNull() {
            addCriterion("bsw_age is null");
            return (Criteria) this;
        }

        public Criteria andBswAgeIsNotNull() {
            addCriterion("bsw_age is not null");
            return (Criteria) this;
        }

        public Criteria andBswAgeEqualTo(Integer value) {
            addCriterion("bsw_age =", value, "bswAge");
            return (Criteria) this;
        }

        public Criteria andBswAgeNotEqualTo(Integer value) {
            addCriterion("bsw_age <>", value, "bswAge");
            return (Criteria) this;
        }

        public Criteria andBswAgeGreaterThan(Integer value) {
            addCriterion("bsw_age >", value, "bswAge");
            return (Criteria) this;
        }

        public Criteria andBswAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("bsw_age >=", value, "bswAge");
            return (Criteria) this;
        }

        public Criteria andBswAgeLessThan(Integer value) {
            addCriterion("bsw_age <", value, "bswAge");
            return (Criteria) this;
        }

        public Criteria andBswAgeLessThanOrEqualTo(Integer value) {
            addCriterion("bsw_age <=", value, "bswAge");
            return (Criteria) this;
        }

        public Criteria andBswAgeIn(List<Integer> values) {
            addCriterion("bsw_age in", values, "bswAge");
            return (Criteria) this;
        }

        public Criteria andBswAgeNotIn(List<Integer> values) {
            addCriterion("bsw_age not in", values, "bswAge");
            return (Criteria) this;
        }

        public Criteria andBswAgeBetween(Integer value1, Integer value2) {
            addCriterion("bsw_age between", value1, value2, "bswAge");
            return (Criteria) this;
        }

        public Criteria andBswAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("bsw_age not between", value1, value2, "bswAge");
            return (Criteria) this;
        }

        public Criteria andPictureNumIsNull() {
            addCriterion("picture_num is null");
            return (Criteria) this;
        }

        public Criteria andPictureNumIsNotNull() {
            addCriterion("picture_num is not null");
            return (Criteria) this;
        }

        public Criteria andPictureNumEqualTo(Integer value) {
            addCriterion("picture_num =", value, "pictureNum");
            return (Criteria) this;
        }

        public Criteria andPictureNumNotEqualTo(Integer value) {
            addCriterion("picture_num <>", value, "pictureNum");
            return (Criteria) this;
        }

        public Criteria andPictureNumGreaterThan(Integer value) {
            addCriterion("picture_num >", value, "pictureNum");
            return (Criteria) this;
        }

        public Criteria andPictureNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("picture_num >=", value, "pictureNum");
            return (Criteria) this;
        }

        public Criteria andPictureNumLessThan(Integer value) {
            addCriterion("picture_num <", value, "pictureNum");
            return (Criteria) this;
        }

        public Criteria andPictureNumLessThanOrEqualTo(Integer value) {
            addCriterion("picture_num <=", value, "pictureNum");
            return (Criteria) this;
        }

        public Criteria andPictureNumIn(List<Integer> values) {
            addCriterion("picture_num in", values, "pictureNum");
            return (Criteria) this;
        }

        public Criteria andPictureNumNotIn(List<Integer> values) {
            addCriterion("picture_num not in", values, "pictureNum");
            return (Criteria) this;
        }

        public Criteria andPictureNumBetween(Integer value1, Integer value2) {
            addCriterion("picture_num between", value1, value2, "pictureNum");
            return (Criteria) this;
        }

        public Criteria andPictureNumNotBetween(Integer value1, Integer value2) {
            addCriterion("picture_num not between", value1, value2, "pictureNum");
            return (Criteria) this;
        }

        public Criteria andBswConstellationIsNull() {
            addCriterion("bsw_constellation is null");
            return (Criteria) this;
        }

        public Criteria andBswConstellationIsNotNull() {
            addCriterion("bsw_constellation is not null");
            return (Criteria) this;
        }

        public Criteria andBswConstellationEqualTo(String value) {
            addCriterion("bsw_constellation =", value, "bswConstellation");
            return (Criteria) this;
        }

        public Criteria andBswConstellationNotEqualTo(String value) {
            addCriterion("bsw_constellation <>", value, "bswConstellation");
            return (Criteria) this;
        }

        public Criteria andBswConstellationGreaterThan(String value) {
            addCriterion("bsw_constellation >", value, "bswConstellation");
            return (Criteria) this;
        }

        public Criteria andBswConstellationGreaterThanOrEqualTo(String value) {
            addCriterion("bsw_constellation >=", value, "bswConstellation");
            return (Criteria) this;
        }

        public Criteria andBswConstellationLessThan(String value) {
            addCriterion("bsw_constellation <", value, "bswConstellation");
            return (Criteria) this;
        }

        public Criteria andBswConstellationLessThanOrEqualTo(String value) {
            addCriterion("bsw_constellation <=", value, "bswConstellation");
            return (Criteria) this;
        }

        public Criteria andBswConstellationLike(String value) {
            addCriterion("bsw_constellation like", value, "bswConstellation");
            return (Criteria) this;
        }

        public Criteria andBswConstellationNotLike(String value) {
            addCriterion("bsw_constellation not like", value, "bswConstellation");
            return (Criteria) this;
        }

        public Criteria andBswConstellationIn(List<String> values) {
            addCriterion("bsw_constellation in", values, "bswConstellation");
            return (Criteria) this;
        }

        public Criteria andBswConstellationNotIn(List<String> values) {
            addCriterion("bsw_constellation not in", values, "bswConstellation");
            return (Criteria) this;
        }

        public Criteria andBswConstellationBetween(String value1, String value2) {
            addCriterion("bsw_constellation between", value1, value2, "bswConstellation");
            return (Criteria) this;
        }

        public Criteria andBswConstellationNotBetween(String value1, String value2) {
            addCriterion("bsw_constellation not between", value1, value2, "bswConstellation");
            return (Criteria) this;
        }

        public Criteria andBswAddressIsNull() {
            addCriterion("bsw_address is null");
            return (Criteria) this;
        }

        public Criteria andBswAddressIsNotNull() {
            addCriterion("bsw_address is not null");
            return (Criteria) this;
        }

        public Criteria andBswAddressEqualTo(String value) {
            addCriterion("bsw_address =", value, "bswAddress");
            return (Criteria) this;
        }

        public Criteria andBswAddressNotEqualTo(String value) {
            addCriterion("bsw_address <>", value, "bswAddress");
            return (Criteria) this;
        }

        public Criteria andBswAddressGreaterThan(String value) {
            addCriterion("bsw_address >", value, "bswAddress");
            return (Criteria) this;
        }

        public Criteria andBswAddressGreaterThanOrEqualTo(String value) {
            addCriterion("bsw_address >=", value, "bswAddress");
            return (Criteria) this;
        }

        public Criteria andBswAddressLessThan(String value) {
            addCriterion("bsw_address <", value, "bswAddress");
            return (Criteria) this;
        }

        public Criteria andBswAddressLessThanOrEqualTo(String value) {
            addCriterion("bsw_address <=", value, "bswAddress");
            return (Criteria) this;
        }

        public Criteria andBswAddressLike(String value) {
            addCriterion("bsw_address like", value, "bswAddress");
            return (Criteria) this;
        }

        public Criteria andBswAddressNotLike(String value) {
            addCriterion("bsw_address not like", value, "bswAddress");
            return (Criteria) this;
        }

        public Criteria andBswAddressIn(List<String> values) {
            addCriterion("bsw_address in", values, "bswAddress");
            return (Criteria) this;
        }

        public Criteria andBswAddressNotIn(List<String> values) {
            addCriterion("bsw_address not in", values, "bswAddress");
            return (Criteria) this;
        }

        public Criteria andBswAddressBetween(String value1, String value2) {
            addCriterion("bsw_address between", value1, value2, "bswAddress");
            return (Criteria) this;
        }

        public Criteria andBswAddressNotBetween(String value1, String value2) {
            addCriterion("bsw_address not between", value1, value2, "bswAddress");
            return (Criteria) this;
        }

        public Criteria andBswLongitudeIsNull() {
            addCriterion("bsw_longitude is null");
            return (Criteria) this;
        }

        public Criteria andBswLongitudeIsNotNull() {
            addCriterion("bsw_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andBswLongitudeEqualTo(Double value) {
            addCriterion("bsw_longitude =", value, "bswLongitude");
            return (Criteria) this;
        }

        public Criteria andBswLongitudeNotEqualTo(Double value) {
            addCriterion("bsw_longitude <>", value, "bswLongitude");
            return (Criteria) this;
        }

        public Criteria andBswLongitudeGreaterThan(Double value) {
            addCriterion("bsw_longitude >", value, "bswLongitude");
            return (Criteria) this;
        }

        public Criteria andBswLongitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("bsw_longitude >=", value, "bswLongitude");
            return (Criteria) this;
        }

        public Criteria andBswLongitudeLessThan(Double value) {
            addCriterion("bsw_longitude <", value, "bswLongitude");
            return (Criteria) this;
        }

        public Criteria andBswLongitudeLessThanOrEqualTo(Double value) {
            addCriterion("bsw_longitude <=", value, "bswLongitude");
            return (Criteria) this;
        }

        public Criteria andBswLongitudeIn(List<Double> values) {
            addCriterion("bsw_longitude in", values, "bswLongitude");
            return (Criteria) this;
        }

        public Criteria andBswLongitudeNotIn(List<Double> values) {
            addCriterion("bsw_longitude not in", values, "bswLongitude");
            return (Criteria) this;
        }

        public Criteria andBswLongitudeBetween(Double value1, Double value2) {
            addCriterion("bsw_longitude between", value1, value2, "bswLongitude");
            return (Criteria) this;
        }

        public Criteria andBswLongitudeNotBetween(Double value1, Double value2) {
            addCriterion("bsw_longitude not between", value1, value2, "bswLongitude");
            return (Criteria) this;
        }

        public Criteria andBswLatitudeIsNull() {
            addCriterion("bsw_latitude is null");
            return (Criteria) this;
        }

        public Criteria andBswLatitudeIsNotNull() {
            addCriterion("bsw_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andBswLatitudeEqualTo(Double value) {
            addCriterion("bsw_latitude =", value, "bswLatitude");
            return (Criteria) this;
        }

        public Criteria andBswLatitudeNotEqualTo(Double value) {
            addCriterion("bsw_latitude <>", value, "bswLatitude");
            return (Criteria) this;
        }

        public Criteria andBswLatitudeGreaterThan(Double value) {
            addCriterion("bsw_latitude >", value, "bswLatitude");
            return (Criteria) this;
        }

        public Criteria andBswLatitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("bsw_latitude >=", value, "bswLatitude");
            return (Criteria) this;
        }

        public Criteria andBswLatitudeLessThan(Double value) {
            addCriterion("bsw_latitude <", value, "bswLatitude");
            return (Criteria) this;
        }

        public Criteria andBswLatitudeLessThanOrEqualTo(Double value) {
            addCriterion("bsw_latitude <=", value, "bswLatitude");
            return (Criteria) this;
        }

        public Criteria andBswLatitudeIn(List<Double> values) {
            addCriterion("bsw_latitude in", values, "bswLatitude");
            return (Criteria) this;
        }

        public Criteria andBswLatitudeNotIn(List<Double> values) {
            addCriterion("bsw_latitude not in", values, "bswLatitude");
            return (Criteria) this;
        }

        public Criteria andBswLatitudeBetween(Double value1, Double value2) {
            addCriterion("bsw_latitude between", value1, value2, "bswLatitude");
            return (Criteria) this;
        }

        public Criteria andBswLatitudeNotBetween(Double value1, Double value2) {
            addCriterion("bsw_latitude not between", value1, value2, "bswLatitude");
            return (Criteria) this;
        }

        public Criteria andBswCityIsNull() {
            addCriterion("bsw_city is null");
            return (Criteria) this;
        }

        public Criteria andBswCityIsNotNull() {
            addCriterion("bsw_city is not null");
            return (Criteria) this;
        }

        public Criteria andBswCityEqualTo(String value) {
            addCriterion("bsw_city =", value, "bswCity");
            return (Criteria) this;
        }

        public Criteria andBswCityNotEqualTo(String value) {
            addCriterion("bsw_city <>", value, "bswCity");
            return (Criteria) this;
        }

        public Criteria andBswCityGreaterThan(String value) {
            addCriterion("bsw_city >", value, "bswCity");
            return (Criteria) this;
        }

        public Criteria andBswCityGreaterThanOrEqualTo(String value) {
            addCriterion("bsw_city >=", value, "bswCity");
            return (Criteria) this;
        }

        public Criteria andBswCityLessThan(String value) {
            addCriterion("bsw_city <", value, "bswCity");
            return (Criteria) this;
        }

        public Criteria andBswCityLessThanOrEqualTo(String value) {
            addCriterion("bsw_city <=", value, "bswCity");
            return (Criteria) this;
        }

        public Criteria andBswCityLike(String value) {
            addCriterion("bsw_city like", value, "bswCity");
            return (Criteria) this;
        }

        public Criteria andBswCityNotLike(String value) {
            addCriterion("bsw_city not like", value, "bswCity");
            return (Criteria) this;
        }

        public Criteria andBswCityIn(List<String> values) {
            addCriterion("bsw_city in", values, "bswCity");
            return (Criteria) this;
        }

        public Criteria andBswCityNotIn(List<String> values) {
            addCriterion("bsw_city not in", values, "bswCity");
            return (Criteria) this;
        }

        public Criteria andBswCityBetween(String value1, String value2) {
            addCriterion("bsw_city between", value1, value2, "bswCity");
            return (Criteria) this;
        }

        public Criteria andBswCityNotBetween(String value1, String value2) {
            addCriterion("bsw_city not between", value1, value2, "bswCity");
            return (Criteria) this;
        }

        public Criteria andBswLikeIsNull() {
            addCriterion("bsw_like is null");
            return (Criteria) this;
        }

        public Criteria andBswLikeIsNotNull() {
            addCriterion("bsw_like is not null");
            return (Criteria) this;
        }

        public Criteria andBswLikeEqualTo(Integer value) {
            addCriterion("bsw_like =", value, "bswLike");
            return (Criteria) this;
        }

        public Criteria andBswLikeNotEqualTo(Integer value) {
            addCriterion("bsw_like <>", value, "bswLike");
            return (Criteria) this;
        }

        public Criteria andBswLikeGreaterThan(Integer value) {
            addCriterion("bsw_like >", value, "bswLike");
            return (Criteria) this;
        }

        public Criteria andBswLikeGreaterThanOrEqualTo(Integer value) {
            addCriterion("bsw_like >=", value, "bswLike");
            return (Criteria) this;
        }

        public Criteria andBswLikeLessThan(Integer value) {
            addCriterion("bsw_like <", value, "bswLike");
            return (Criteria) this;
        }

        public Criteria andBswLikeLessThanOrEqualTo(Integer value) {
            addCriterion("bsw_like <=", value, "bswLike");
            return (Criteria) this;
        }

        public Criteria andBswLikeIn(List<Integer> values) {
            addCriterion("bsw_like in", values, "bswLike");
            return (Criteria) this;
        }

        public Criteria andBswLikeNotIn(List<Integer> values) {
            addCriterion("bsw_like not in", values, "bswLike");
            return (Criteria) this;
        }

        public Criteria andBswLikeBetween(Integer value1, Integer value2) {
            addCriterion("bsw_like between", value1, value2, "bswLike");
            return (Criteria) this;
        }

        public Criteria andBswLikeNotBetween(Integer value1, Integer value2) {
            addCriterion("bsw_like not between", value1, value2, "bswLike");
            return (Criteria) this;
        }

        public Criteria andBswFollowIsNull() {
            addCriterion("bsw_follow is null");
            return (Criteria) this;
        }

        public Criteria andBswFollowIsNotNull() {
            addCriterion("bsw_follow is not null");
            return (Criteria) this;
        }

        public Criteria andBswFollowEqualTo(Integer value) {
            addCriterion("bsw_follow =", value, "bswFollow");
            return (Criteria) this;
        }

        public Criteria andBswFollowNotEqualTo(Integer value) {
            addCriterion("bsw_follow <>", value, "bswFollow");
            return (Criteria) this;
        }

        public Criteria andBswFollowGreaterThan(Integer value) {
            addCriterion("bsw_follow >", value, "bswFollow");
            return (Criteria) this;
        }

        public Criteria andBswFollowGreaterThanOrEqualTo(Integer value) {
            addCriterion("bsw_follow >=", value, "bswFollow");
            return (Criteria) this;
        }

        public Criteria andBswFollowLessThan(Integer value) {
            addCriterion("bsw_follow <", value, "bswFollow");
            return (Criteria) this;
        }

        public Criteria andBswFollowLessThanOrEqualTo(Integer value) {
            addCriterion("bsw_follow <=", value, "bswFollow");
            return (Criteria) this;
        }

        public Criteria andBswFollowIn(List<Integer> values) {
            addCriterion("bsw_follow in", values, "bswFollow");
            return (Criteria) this;
        }

        public Criteria andBswFollowNotIn(List<Integer> values) {
            addCriterion("bsw_follow not in", values, "bswFollow");
            return (Criteria) this;
        }

        public Criteria andBswFollowBetween(Integer value1, Integer value2) {
            addCriterion("bsw_follow between", value1, value2, "bswFollow");
            return (Criteria) this;
        }

        public Criteria andBswFollowNotBetween(Integer value1, Integer value2) {
            addCriterion("bsw_follow not between", value1, value2, "bswFollow");
            return (Criteria) this;
        }

        public Criteria andBswFansIsNull() {
            addCriterion("bsw_fans is null");
            return (Criteria) this;
        }

        public Criteria andBswFansIsNotNull() {
            addCriterion("bsw_fans is not null");
            return (Criteria) this;
        }

        public Criteria andBswFansEqualTo(Integer value) {
            addCriterion("bsw_fans =", value, "bswFans");
            return (Criteria) this;
        }

        public Criteria andBswFansNotEqualTo(Integer value) {
            addCriterion("bsw_fans <>", value, "bswFans");
            return (Criteria) this;
        }

        public Criteria andBswFansGreaterThan(Integer value) {
            addCriterion("bsw_fans >", value, "bswFans");
            return (Criteria) this;
        }

        public Criteria andBswFansGreaterThanOrEqualTo(Integer value) {
            addCriterion("bsw_fans >=", value, "bswFans");
            return (Criteria) this;
        }

        public Criteria andBswFansLessThan(Integer value) {
            addCriterion("bsw_fans <", value, "bswFans");
            return (Criteria) this;
        }

        public Criteria andBswFansLessThanOrEqualTo(Integer value) {
            addCriterion("bsw_fans <=", value, "bswFans");
            return (Criteria) this;
        }

        public Criteria andBswFansIn(List<Integer> values) {
            addCriterion("bsw_fans in", values, "bswFans");
            return (Criteria) this;
        }

        public Criteria andBswFansNotIn(List<Integer> values) {
            addCriterion("bsw_fans not in", values, "bswFans");
            return (Criteria) this;
        }

        public Criteria andBswFansBetween(Integer value1, Integer value2) {
            addCriterion("bsw_fans between", value1, value2, "bswFans");
            return (Criteria) this;
        }

        public Criteria andBswFansNotBetween(Integer value1, Integer value2) {
            addCriterion("bsw_fans not between", value1, value2, "bswFans");
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