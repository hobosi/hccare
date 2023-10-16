package cote.hccare.mapper;

import cote.hccare.domain.PostRequest;
import cote.hccare.domain.PostResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

    /**
     * 게시글 저장
     *
     * @param params - 게시글 정보
     */
    void save(PostRequest params);

    /**
     * 게시글 수정
     *
     * @param params - 게시글 정보
     */
    void update(PostRequest params);

    /**
     * 게시글 삭제
     *
     * @param id - PK
     */
    void deleteById(Long id);

    /**
     * 게시글 리스트 조회
     *
     * @return 게시글 리스트
     */
    List<PostResponse> findAll();

}