package dev.sternschnuppe.thirdbasic;

import dev.sternschnuppe.thirdbasic.entity.PostEntity;

import java.util.ArrayList;
import java.util.List;

public class UserDto {
    private int id;
    private String userId;
    private String userPw;
    private List<PostEntity> postEntityList = new ArrayList<>();

    public UserDto() {
    }

    public UserDto(int id, String userId, String userPw, List<PostEntity> postEntityList) {
        this.id = id;
        this.userId = userId;
        this.userPw = userPw;
        this.postEntityList = postEntityList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public List<PostEntity> getPostEntityList() {
        return postEntityList;
    }

    public void setPostEntityList(List<PostEntity> postEntityList) {
        this.postEntityList = postEntityList;
    }
}
