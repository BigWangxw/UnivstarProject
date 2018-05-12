package com.example.dell.univstarproject.sign.entry;

/**
 * Created by Administrator on 2018/5/8 0008.
 */

public class Change {

    /**
     * code : 1
     * message : cid为空
     * data : {"nickname":"旧梦 Toxicant°","mobile":"17330263005","photo":"http://qiniu.5roo.com/74dd477313a64905a41814b35ee8c535.jpg","id":662,"token":"eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiJyNDJydm4iLCJzdWIiOiI2NjIiLCJleHAiOjE1MjYzNzE0ODMsImlhdCI6MTUyNTc2NjY4M30.ZTGoUmBuoclHe2ygTZos2yYdGRGiuWTP0Ggr0WsOW_n36i5DM8a8BFBb6i7t0CSX4ez8IuRhTGAzMGGoPwlWLA"}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * nickname : 旧梦 Toxicant°
         * mobile : 17330263005
         * photo : http://qiniu.5roo.com/74dd477313a64905a41814b35ee8c535.jpg
         * id : 662
         * token : eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiJyNDJydm4iLCJzdWIiOiI2NjIiLCJleHAiOjE1MjYzNzE0ODMsImlhdCI6MTUyNTc2NjY4M30.ZTGoUmBuoclHe2ygTZos2yYdGRGiuWTP0Ggr0WsOW_n36i5DM8a8BFBb6i7t0CSX4ez8IuRhTGAzMGGoPwlWLA
         */

        private String nickname;
        private String mobile;
        private String photo;
        private int id;
        private String token;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
