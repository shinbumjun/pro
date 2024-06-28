package pro.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /**
     * 홈 화면
     * @param model
     * @return 신범준
     */
    @GetMapping("home.do")
    public String home(Model model) {
        // 홈화면에 도서목록 정보들 가져오기
        model.addAttribute("message", "Welcome to the Index Page!");
        return "home";
    }

    @GetMapping("index.do")
    public String index(Model model) {

        return "index";
    }
}
