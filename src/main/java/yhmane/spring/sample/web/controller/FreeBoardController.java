package yhmane.spring.sample.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FreeBoardController {

    @GetMapping("/freeBoard")
    public String home() {
        return "layouts/board/freeBoard";
    }
}
