package yhmane.spring.sample.utils;

import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import yhmane.spring.sample.vo.page.PageConditionVo;

public class PageUtils {

    public static PageRequest paging(PageConditionVo pageConditionVo) {
        if (Strings.isEmpty(pageConditionVo.getSort())) {
            return PageRequest.of(pageConditionVo.getPageNumber(), pageConditionVo.getPageSize());
        } else {
            return PageRequest.of(pageConditionVo.getPageNumber(), pageConditionVo.getPageSize(), "asc".equals(pageConditionVo.getDirection()) ?
                    Sort.by(pageConditionVo.getSort()).ascending() : Sort.by(pageConditionVo.getSort()).descending());
        }
    }
}
