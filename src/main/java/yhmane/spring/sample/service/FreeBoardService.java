package yhmane.spring.sample.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import yhmane.spring.sample.entity.FreeBoardEntity;
import yhmane.spring.sample.exception.BadException;
import yhmane.spring.sample.repository.FreeBoardRepository;
import yhmane.spring.sample.utils.PageUtils;
import yhmane.spring.sample.vo.FreeBoardResponseVo;
import yhmane.spring.sample.vo.page.PageConditionVo;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FreeBoardService {

    private final FreeBoardRepository freeBoardRepository;

    public Page<FreeBoardResponseVo> list(final PageConditionVo pageConditionVo) {
        PageRequest pageRequest = PageUtils.paging(pageConditionVo);
        return freeBoardRepository.findAll(pageRequest).map(FreeBoardResponseVo::new);
    }

    public FreeBoardEntity findOne(Long id) {
        Optional<FreeBoardEntity> freeBoardOptional = freeBoardRepository.findById(id);
        return freeBoardOptional.orElseThrow(() -> new BadException(HttpStatus.NOT_FOUND, id + ", 해당 게시물을 찾을 수 없습니다"));
    }
}

