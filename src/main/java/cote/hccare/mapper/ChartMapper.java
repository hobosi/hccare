package cote.hccare.mapper;

import cote.hccare.domain.ChartResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChartMapper {

    List<ChartResponse> findData();

}
