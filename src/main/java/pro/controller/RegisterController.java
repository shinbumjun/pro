package pro.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pro.dto.UserDto;
import pro.service.RegisterService;

import static javax.print.PrintServiceLookup.registerService;

@Slf4j
@Controller
public class RegisterController {

    @Autowired
    RegisterService rs;

    /**
     * 회원가입 화면
     * @param
     * @return 신범준
     */
    @GetMapping("register.do")
    public String register() {

        return "register";
    }

    /**
     * 회원가입
     * @param userdto
     * @return 신범준
     * username, password, email
     */
    @PostMapping("/signup-process.do")
    public String signup(UserDto userdto, Model model) {
        // ModelAndView mv = new ModelAndView();

        int sc = rs.signup(userdto);
        System.out.println("회원가입 성공 여부 : " + sc);

        if(sc == -1){
            model.addAttribute("success", "-1"); // 아이디 중복
            model.addAttribute("msg", "아이디가 중복입니다");
            return "register";
        } else if (sc == -2) {
            model.addAttribute("success", "-2"); // 이메일 중복
            model.addAttribute("msg", "이메일이 중복입니다");
            return "register";
        }
        model.addAttribute("success", "0");
        model.addAttribute("msg", "회원가입 성공하였습니다");
        return "login";
    }
}
