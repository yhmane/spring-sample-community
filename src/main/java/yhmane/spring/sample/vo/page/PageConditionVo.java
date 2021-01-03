package yhmane.spring.sample.vo.page;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageConditionVo {

    private Integer pageNumber;
    private Integer pageSize;
    private String sort;
    private String direction;
}
