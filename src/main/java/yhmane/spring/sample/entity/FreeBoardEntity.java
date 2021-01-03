package yhmane.spring.sample.entity;

import lombok.Getter;
import lombok.Setter;
import yhmane.spring.sample.entity.common.BaseTimeEntity;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "free_board")
public class FreeBoardEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String writer;
}
