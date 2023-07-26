package com.test.project;

public class Member {
   private String id;
   private String pw;
   private String email;
   private String age;
   private String phoneNum;
   private String gender;
   private String name;
   private String address;
   private String nickname;
   private String point;
   
   //
   public Member(String id, String pw, String age, String phoneNum, String gender, String name,
         String address, String nickname, String point) {
      this.id = id;
      this.pw = pw;
      this.age = age;
      this.phoneNum = phoneNum;
      this.gender = gender;
      this.name = name;
      this.address = address;
      this.nickname = nickname;
      this.point = point;
   }
   
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getPw() {
      return pw;
   }
   public void setPw(String pw) {
      this.pw = pw;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public String getAge() {
      return age;
   }
   public void setAge(String age) {
      this.age = age;
   }
   public String getPhoneNum() {
      return phoneNum;
   }
   public void setPhoneNum(String phoneNum) {
      this.phoneNum = phoneNum;
   }
   public String getGender() {
      return gender;
   }
   public void setGender(String gender) {
      this.gender = gender;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getAddress() {
      return address;
   }
   public void setAddress(String address) {
      this.address = address;
   }
   public String getNickname() {
      return nickname;
   }
   public void setNickname(String nickname) {
      this.nickname = nickname;
   }

}