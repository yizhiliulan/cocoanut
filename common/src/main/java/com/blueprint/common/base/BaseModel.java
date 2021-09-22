package com.blueprint.common.base;

import java.io.Serializable;

public abstract class BaseModel implements Serializable {

    private String operator;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
