package cote.hccare.service;

import cote.hccare.domain.ChartResponse;
import cote.hccare.domain.PostResponse;
import cote.hccare.domain.ToastUiResponse;
import cote.hccare.mapper.ChartMapper;
import cote.hccare.mapper.PostMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Transactional
@Service
public class ChartService {
    private ChartMapper chartMapper;

    public ChartService(ChartMapper chartMapper) {
        this.chartMapper = chartMapper;
    }

    public ToastUiResponse getPieChartData() {
        List<ChartResponse> posts = chartMapper.findData();
        // 게시판 데이터를 가져와서 Thymeleaf 템플릿으로 전달
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("series", posts);
        resultMap.put("categories", "");

        return ToastUiResponse.builder().result(true).data(resultMap).build();
    }
}
