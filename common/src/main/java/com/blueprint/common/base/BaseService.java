package com.blueprint.common.base;

import java.util.UUID;

public abstract class BaseService {

    protected String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}
