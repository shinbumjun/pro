package pro.service;

import pro.dto.UserDto;

public interface RegisterService {

    // 회원가입
    int signup(UserDto userdto);
    
}
