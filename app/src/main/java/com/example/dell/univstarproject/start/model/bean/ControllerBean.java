package com.example.dell.univstarproject.start.model.bean;

import com.google.gson.Gson;

import java.util.List;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class ControllerBean {

    /**
     * code : 0
     * message : 成功
     * data : {"giftList":[{"id":16,"page":1,"rows":20,"name":"玫瑰花","amount":6,"img":"http://qiniu.5roo.com/ce57678c-6cc7-4161-853f-10d54f0c803e.png"},{"id":17,"page":1,"rows":20,"name":"大拇哥","amount":18,"img":"http://qiniu.5roo.com/7cfc7b5a-92de-4c3b-a9f5-87dd9b3da3f9.png"},{"id":18,"page":1,"rows":20,"name":"心","amount":66,"img":"http://qiniu.5roo.com/18939fde-ad1a-4179-ae45-b19a451ac4cc.png"},{"id":19,"page":1,"rows":20,"name":"V5威武","amount":168,"img":"http://qiniu.5roo.com/8abefef2-a2e8-4ddf-a7d7-8ee806c75378.png"},{"id":20,"page":1,"rows":20,"name":"金话筒","amount":666,"img":"http://qiniu.5roo.com/f0277ce7-f0ec-452f-b556-8ac17e448025.png"},{"id":21,"page":1,"rows":20,"name":"皇冠","amount":6666,"img":"http://qiniu.5roo.com/7950c09c-14a4-4228-8d39-36ce84118ee7.png"},{"id":22,"page":1,"rows":20,"name":"星星","amount":12,"img":"http://qiniu.5roo.com/18e83505-b2d0-44d5-9a2b-6c77442eaa2b.png"},{"id":23,"page":1,"rows":20,"name":"气球","amount":36,"img":"http://qiniu.5roo.com/2c566c50-a3aa-4581-b42e-de440265443d.png"},{"id":24,"page":1,"rows":20,"name":"鼓掌","amount":66,"img":"http://qiniu.5roo.com/31be0a82-caa8-48ef-b7b9-a9cb20ed2b9e.png"},{"id":25,"page":1,"rows":20,"name":"音符","amount":258,"img":"http://qiniu.5roo.com/210e0642-d258-4f84-9c9b-6b0b52c9672a.png"}],"userBeanAmount":0}
     */

    private int code;
    private String message;
    private DataBean data;

    public static ControllerBean objectFromData(String str) {

        return new Gson().fromJson(str, ControllerBean.class);
    }

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
         * giftList : [{"id":16,"page":1,"rows":20,"name":"玫瑰花","amount":6,"img":"http://qiniu.5roo.com/ce57678c-6cc7-4161-853f-10d54f0c803e.png"},{"id":17,"page":1,"rows":20,"name":"大拇哥","amount":18,"img":"http://qiniu.5roo.com/7cfc7b5a-92de-4c3b-a9f5-87dd9b3da3f9.png"},{"id":18,"page":1,"rows":20,"name":"心","amount":66,"img":"http://qiniu.5roo.com/18939fde-ad1a-4179-ae45-b19a451ac4cc.png"},{"id":19,"page":1,"rows":20,"name":"V5威武","amount":168,"img":"http://qiniu.5roo.com/8abefef2-a2e8-4ddf-a7d7-8ee806c75378.png"},{"id":20,"page":1,"rows":20,"name":"金话筒","amount":666,"img":"http://qiniu.5roo.com/f0277ce7-f0ec-452f-b556-8ac17e448025.png"},{"id":21,"page":1,"rows":20,"name":"皇冠","amount":6666,"img":"http://qiniu.5roo.com/7950c09c-14a4-4228-8d39-36ce84118ee7.png"},{"id":22,"page":1,"rows":20,"name":"星星","amount":12,"img":"http://qiniu.5roo.com/18e83505-b2d0-44d5-9a2b-6c77442eaa2b.png"},{"id":23,"page":1,"rows":20,"name":"气球","amount":36,"img":"http://qiniu.5roo.com/2c566c50-a3aa-4581-b42e-de440265443d.png"},{"id":24,"page":1,"rows":20,"name":"鼓掌","amount":66,"img":"http://qiniu.5roo.com/31be0a82-caa8-48ef-b7b9-a9cb20ed2b9e.png"},{"id":25,"page":1,"rows":20,"name":"音符","amount":258,"img":"http://qiniu.5roo.com/210e0642-d258-4f84-9c9b-6b0b52c9672a.png"}]
         * userBeanAmount : 0
         */

        private int userBeanAmount;
        private List<GiftListBean> giftList;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public int getUserBeanAmount() {
            return userBeanAmount;
        }

        public void setUserBeanAmount(int userBeanAmount) {
            this.userBeanAmount = userBeanAmount;
        }

        public List<GiftListBean> getGiftList() {
            return giftList;
        }

        public void setGiftList(List<GiftListBean> giftList) {
            this.giftList = giftList;
        }

        public static class GiftListBean {
            /**
             * id : 16
             * page : 1
             * rows : 20
             * name : 玫瑰花
             * amount : 6
             * img : http://qiniu.5roo.com/ce57678c-6cc7-4161-853f-10d54f0c803e.png
             */

            private int id;
            private int page;
            private int rows;
            private String name;
            private int amount;
            private String img;

            public static GiftListBean objectFromData(String str) {

                return new Gson().fromJson(str, GiftListBean.class);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getPage() {
                return page;
            }

            public void setPage(int page) {
                this.page = page;
            }

            public int getRows() {
                return rows;
            }

            public void setRows(int rows) {
                this.rows = rows;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }
        }
    }
}
