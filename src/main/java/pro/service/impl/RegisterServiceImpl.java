package pro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.dao.RegisterDao;
import pro.dto.UserDto;
import pro.service.RegisterService;
import pro.utill.Sha512Encoder;

import java.util.HashMap;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    RegisterDao rd;

    /**
     * @param userdto
     * @return 신범준
     * password : 암호화
     * username, email : 유효성 검사 (나중에 Ajax 처리 가능)
     */
    @Override
    public int signup(UserDto userdto) {
        HashMap<String, String> map = new HashMap<>();
        map.put("username", userdto.getUsername());
        map.put("email", userdto.getEmail());
        System.out.println(map);

        int username = rd.Logincheck(map); // 아이디 체크
        int email = rd.Emailcheck(map); // 이메일 체크

        if(username > 0) { // 아이디 중복
            return -1;
        }
        if(email > 0) { // 이메일 중복
            return -2;
        }

        // *비밀번호 암호화
        Sha512Encoder encoder = Sha512Encoder.getInstance(); // 1. SHA-512 암호화를 위한 인스턴스를 얻는다
        System.out.println("encoder : " + encoder); // pro.utill.Sha512Encoder@701a0948

        String passwd = userdto.getPassword(); // 2. 브라우저에서 입력한 비밀번호
        System.out.println("userdto.getPassword() : " + userdto.getPassword()); // 1234

        String encodeTxt = encoder.getSecurePassword(passwd); // 3. 비밀번호 암호화
        System.out.println("userPw : " + encodeTxt); // d404559f602eab...

        userdto.setPassword(encodeTxt); // 4. 암호화한 패쓰워드로 저장

        return rd.signup(userdto);
    }

}
