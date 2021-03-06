package com.investor.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DepositRequest {

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("plan_id")
    @Expose
    private String planId;

    /**
     * No args constructor for use in serialization
     *
     */
    public DepositRequest() {
    }

    /**
     *
     * @param amount
     * @param userId
     * @param planId
     */
    public DepositRequest(String userId, String amount, String planId) {
        super();
        this.userId = userId;
        this.amount = amount;
        this.planId = planId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

}