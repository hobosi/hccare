package cote.hccare.mapper;

import cote.hccare.domain.ChartResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChartMapper {

    /**
     * 데이터 조회
     *
     * @return 차트 데이터
     */
    List<ChartResponse> findData();

}
