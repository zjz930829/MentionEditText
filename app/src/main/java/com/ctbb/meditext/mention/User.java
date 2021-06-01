package com.ctbb.meditext.mention;

import android.graphics.Color;

import com.ctbb.meditext.mention.edit.listener.InsertData;
import com.ctbb.meditext.mention.model.FormatRange;

import java.io.Serializable;

/**
 * Description: .
 * Created by ZJZ on 2021/6/1.
 */
public class User implements Serializable, InsertData {

    private final CharSequence userId;
    private final CharSequence userName;
    private CharSequence userSex;

    public User(CharSequence userId, CharSequence userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public CharSequence getUserId() {
        return userId;
    }

    public CharSequence getUserName() {
        return userName;
    }

    public CharSequence getUserSex() {
        return userSex;
    }

    public void setUserSex(CharSequence userSex) {
        this.userSex = userSex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null)
            return false;
        return userSex != null ? userSex.equals(user.userSex) : user.userSex == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userSex != null ? userSex.hashCode() : 0);
        return result;
    }

    @Override
    public CharSequence charSequence() {
        return "@" + userName;
    }

    @Override
    public FormatRange.FormatData formatData() {
        return new UserConvert(this);
    }

    @Override
    public int color() {
        return Color.parseColor("#FC980C");
    }

    private class UserConvert implements FormatRange.FormatData {

        public static final String USER_FORMART = "<user id=\"%s\" >%s</user>";
        private final User user;

        public UserConvert(User user) {
            this.user = user;
        }

        @Override
        public CharSequence formatCharSequence() {
            return String.format(USER_FORMART, user.getUserId(), user.getUserName());
        }
    }
}
