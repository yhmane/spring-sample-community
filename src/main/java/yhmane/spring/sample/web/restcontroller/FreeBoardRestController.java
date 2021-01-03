package yhmane.spring.sample.web.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhmane.spring.sample.service.FreeBoardService;
import yhmane.spring.sample.utils.ResponseUtils;
import yhmane.spring.sample.vo.page.PageConditionVo;
import yhmane.spring.sample.vo.response.DefaultResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/freeboard")
public class FreeBoardRestController {

    private final FreeBoardService freeBoardService;

    @GetMapping("")
    public DefaultResponse<?> list(PageConditionVo pageConditionVo) {
        return ResponseUtils.data(freeBoardService.list(pageConditionVo));
    }
}
