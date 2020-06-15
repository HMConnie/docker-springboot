package com.sgcai.boot.criteria;

import java.io.Serializable;

public class UserCriteria implements Serializable {
    private static final long serialVersionUID = 1L;

    private String mobile;
    private String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
