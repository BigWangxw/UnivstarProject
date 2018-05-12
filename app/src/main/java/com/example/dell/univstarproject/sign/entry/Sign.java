package com.example.dell.univstarproject.sign.entry;

/**
 * Created by Administrator on 2018/5/5 0005.
 */

public class Sign {

    /**
     * code : 1
     * message : cid为空
     * data : {"nickname":"zqd","mobile":"15110018873","photo":null,"id":758,"token":"eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiIxeGMwOXMiLCJzdWIiOiI3NTgiLCJleHAiOjE1MjYwOTU3ODcsImlhdCI6MTUyNTQ5MDk4N30.XngHeLJHlEPrcgQbBXCwFVDttUm14YUuF40sp5gMRdn2jYrqJ5S72O7JF9GUwsD3x2o3FDFOajpr_nTXbtLBxQ"}
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
         * nickname : zqd
         * mobile : 15110018873
         * photo : null
         * id : 758
         * token : eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiIxeGMwOXMiLCJzdWIiOiI3NTgiLCJleHAiOjE1MjYwOTU3ODcsImlhdCI6MTUyNTQ5MDk4N30.XngHeLJHlEPrcgQbBXCwFVDttUm14YUuF40sp5gMRdn2jYrqJ5S72O7JF9GUwsD3x2o3FDFOajpr_nTXbtLBxQ
         */

        private String nickname;
        private String mobile;
        private Object photo;
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

        public Object getPhoto() {
            return photo;
        }

        public void setPhoto(Object photo) {
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
