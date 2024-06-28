package pro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import pro.dao.LoginDao;
import pro.dto.UserDto;
import pro.service.LoginService;
import pro.utill.Sha512Encoder;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginDao ld;

    /**
     * @param userDto
     * @return 신범준
     * username, password
     * 사용자가 입력한 비밀번호와 DB에 저장된 비밀번호 (암호화와 복호화) 비교
     */
    @Override
    public boolean Loginchick(UserDto userDto) {

        // 1. id비교
        String username = userDto.getUsername(); // 브라우저에서 입력한 ID
        System.out.println("id비교 : " + username); // s123s123s
        // tip : select시에 값이 없으면 null인데 JDBC는 tye-catch문으로 했었는데 mybatis에서는 if문으로 처리 가능하다
        UserDto user = ld.Loginchick(username); // 동일한 id가 없을 경우 null, 동일한 id가 있을경우 UserDto 반환
        System.out.println("동일한 id가 없을 경우 null : " + user);

        // if(ObjectUtils.isEmpty(user.getUsername())) null을 못잡아서 수정
        if(user == null || StringUtils.isEmpty(user.getUsername())) {
            return false;
        }

        // 2. 비밀번호 비교
        String userpasswd = userDto.getPassword(); // 사용자가 입력한 비밀번호
        System.out.println("사용자가 입력한 비밀번호 : " + userpasswd); // 123

        String dbpassword = user.getPassword(); // DB에 저장되어 있는 암호화 된 비밀번호
        System.out.println("DB에 저장되어 있는 암호화 된 비밀번호  : " + dbpassword); // 3c9909afec25354...

        Sha512Encoder encoder = Sha512Encoder.getInstance();
        System.out.println("encoder  : " + encoder); // com.lhs.util.Sha...

        String encodeTxt = encoder.getSecurePassword(userpasswd); // 사용자가 입력한 값을 암호화한 거다
        System.out.println("사용자가 입력한 값을 암호화한 거다  : " + encodeTxt);	 // 3c9909afec25354...

        return StringUtils.pathEquals(dbpassword, encodeTxt); // 비교해서 틀리면 false반환
    }

}
