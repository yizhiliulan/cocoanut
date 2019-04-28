package com.blueprint.common.base;

import java.io.Serializable;

public abstract class BaseModel implements Serializable {

    private String operator;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
