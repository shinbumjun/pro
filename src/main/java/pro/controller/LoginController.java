package pro.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pro.dto.UserDto;
import pro.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    LoginService Ls;

    /**
     * 로그인 화면
     * @param
     * @return 신범준
     */
    @GetMapping("login.do")
    public String loginpage() {

        return "login";
    }

    /**
     * 로그아웃
     * @param
     * @return 신범준
     */
    @GetMapping("logout.do")
    public String logout(HttpSession session){
        session.invalidate(); // 셔션
        return "home";
    }

    /**
     * 로그인
     * @param model
     * @return 신범준
     * username, password
     */
    @PostMapping("login-process.do")
    public String login(UserDto userDto, Model model,
                        HttpServletRequest request,
                        HttpServletResponse response,
                        @RequestParam(name = "logCheck", required = false) String logCheck) {

        boolean sc = Ls.Loginchick(userDto);
        System.out.println("로그인 성공 여부 : " + sc);
        
        if(!(sc)){ // 로그인 실패
            model.addAttribute("success", "-3"); // 로그인 실패
            model.addAttribute("msg", "로그인에 실패하였습니다");
            return "login";
        }

        // 세션
        HttpSession session = request.getSession();
        session.setAttribute("username", userDto.getUsername()); // 예시로 username를 세션에 저장

        // 쿠키 생성 및 삭제 처리
        if (logCheck != null && "on".equals(logCheck)) {
            System.out.println("쿠키 저장");
            // 쿠키 생성
            Cookie cookie = new Cookie("username", userDto.getUsername());
            cookie.setMaxAge(7 * 24 * 60 * 60); // Set cookie age (7 days)
            cookie.setPath("/"); // Set cookie path
            response.addCookie(cookie);
        } else {
            System.out.println("쿠키 삭제");
            // 쿠키 삭제
            Cookie cookie = new Cookie("username", "");
            cookie.setMaxAge(0); // Remove cookie immediately
            cookie.setPath("/"); // Set cookie path
            response.addCookie(cookie);
        }

        model.addAttribute("success", "1"); // 로그인 성공
        model.addAttribute("msg", "로그인에 성공하였습니다");
        return "home";
    }
}