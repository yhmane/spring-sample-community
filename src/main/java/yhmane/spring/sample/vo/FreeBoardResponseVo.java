package yhmane.spring.sample.vo;

import lombok.Getter;
import yhmane.spring.sample.entity.FreeBoardEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class FreeBoardResponseVo {

    private Long id;
    private String title;
    private String content;
    private String writer;
    private String updatedAt;

    public FreeBoardResponseVo(FreeBoardEntity entity) {
        id = entity.getId();
        title = entity.getTitle();
        content = entity.getContent();
        writer = entity.getWriter();
        updatedAt = toStringDateTime(entity.getUpdatedAt());
    }

    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
}
