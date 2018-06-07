package com.mohamedabdelaziz.dailyquran;

public class Model {
    public String email, message, date;

    public Model() {
    }

    public String getEmail() {
        if (email == null)
            return "private";
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        if (message == null)
            return "not available";
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        if (date == null)
            return "----";
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
