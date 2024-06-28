package pro.dto;

import lombok.*;

import java.util.Objects;

// @AllArgsConstructor
// @ToString
// @Setter
// @Getter
@Data
public class UserDto {

    private int userId;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String sex; // 성별을 나타내는 문자열
    private String hobby; // 취미를 나타내는 문자열
    private String email;
    private String regDate;

    // Lombok의 @Data 어노테이션을 사용하면 Getter, Setter, toString() 등을 자동으로 생성해줍니다.
    // 롬복이 제대로 실행이 안되는거 같아서 직접 작성

    public UserDto(){}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return userId == userDto.userId && Objects.equals(username, userDto.username) && Objects.equals(password, userDto.password) && Objects.equals(name, userDto.name) && Objects.equals(phone, userDto.phone) && Objects.equals(sex, userDto.sex) && Objects.equals(hobby, userDto.hobby) && Objects.equals(email, userDto.email) && Objects.equals(regDate, userDto.regDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, name, phone, sex, hobby, email, regDate);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", hobby='" + hobby + '\'' +
                ", email='" + email + '\'' +
                ", regDate='" + regDate + '\'' +
                '}';
    }
}