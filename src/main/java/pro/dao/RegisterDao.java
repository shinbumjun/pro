package pro.dao;

import org.apache.ibatis.annotations.Mapper;
import pro.dto.UserDto;

import java.util.HashMap;

@Mapper
public interface RegisterDao {

    int signup(UserDto userdto); // 회원가입
    int Logincheck(HashMap<String, String> map); // 아이디 체크
    int Emailcheck(HashMap<String, String> map); // 이메일 체크
}
