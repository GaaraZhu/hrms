package com.jisiben.hrms.controller.dto;

public class ResetPasswordDTO {
    private String currentPassword;
    private String newPassword;
    private String newPasswordAgain;

    public String getCurrentPassword() {
        return currentPassword;
    }

    public ResetPasswordDTO setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
        return this;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public ResetPasswordDTO setNewPassword(String newPassword) {
        this.newPassword = newPassword;
        return this;
    }

    public String getNewPasswordAgain() {
        return newPasswordAgain;
    }

    public ResetPasswordDTO setNewPasswordAgain(String newPasswordAgain) {
        this.newPasswordAgain = newPasswordAgain;
        return this;
    }
}
