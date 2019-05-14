package com.example.hz.demo.generated;

import java.util.ArrayList;
import java.util.List;

public class accountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria1> oredCriteria;

    public accountExample() {
        oredCriteria = new ArrayList<Criteria1>();
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

    public List<Criteria1> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria1 Criteria1) {
        oredCriteria.add(Criteria1);
    }

    public Criteria1 or() {
        Criteria1 Criteria1 = createCriteriaInternal();
        oredCriteria.add(Criteria1);
        return Criteria1;
    }

    public Criteria1 createCriteria() {
        Criteria1 Criteria1 = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(Criteria1);
        }
        return Criteria1;
    }

    protected Criteria1 createCriteriaInternal() {
        Criteria1 Criteria1 = new Criteria1();
        return Criteria1;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria1 {
        protected List<Criterion> Criteria1;

        protected GeneratedCriteria1() {
            super();
            Criteria1 = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return Criteria1.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return Criteria1;
        }

        public List<Criterion> getCriteria() {
            return Criteria1;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            Criteria1.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Criteria1.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            Criteria1.add(new Criterion(condition, value1, value2));
        }

        public Criteria1 andIdIsNull() {
            addCriterion("id is null");
            return (Criteria1) this;
        }

        public Criteria1 andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria1) this;
        }

        public Criteria1 andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria1) this;
        }

        public Criteria1 andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria1) this;
        }

        public Criteria1 andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria1) this;
        }

        public Criteria1 andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria1) this;
        }

        public Criteria1 andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria1) this;
        }

        public Criteria1 andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria1) this;
        }

        public Criteria1 andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria1) this;
        }

        public Criteria1 andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria1) this;
        }

        public Criteria1 andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria1) this;
        }

        public Criteria1 andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria1) this;
        }

        public Criteria1 andNameIsNull() {
            addCriterion("name is null");
            return (Criteria1) this;
        }

        public Criteria1 andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria1) this;
        }

        public Criteria1 andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria1) this;
        }

        public Criteria1 andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria1) this;
        }

        public Criteria1 andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria1) this;
        }

        public Criteria1 andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria1) this;
        }

        public Criteria1 andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria1) this;
        }

        public Criteria1 andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria1) this;
        }

        public Criteria1 andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria1) this;
        }

        public Criteria1 andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria1) this;
        }

        public Criteria1 andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria1) this;
        }

        public Criteria1 andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria1) this;
        }

        public Criteria1 andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria1) this;
        }

        public Criteria1 andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria1) this;
        }

        public Criteria1 andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria1) this;
        }

        public Criteria1 andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria1) this;
        }

        public Criteria1 andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria1) this;
        }

        public Criteria1 andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria1) this;
        }

        public Criteria1 andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria1) this;
        }

        public Criteria1 andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria1) this;
        }

        public Criteria1 andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria1) this;
        }

        public Criteria1 andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria1) this;
        }

        public Criteria1 andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria1) this;
        }

        public Criteria1 andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria1) this;
        }

        public Criteria1 andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria1) this;
        }

        public Criteria1 andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria1) this;
        }
    }

    public static class Criteria1 extends GeneratedCriteria1 {

        protected Criteria1() {
            super();
        }
    }

}