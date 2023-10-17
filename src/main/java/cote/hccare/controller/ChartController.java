package cote.hccare.controller;

import cote.hccare.domain.ToastUiResponse;
import cote.hccare.service.ChartService;
import cote.hccare.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chart")
@RequiredArgsConstructor
public class ChartController {

    @Autowired
    ChartService chartService;

    @GetMapping
    public String showChart() {
        return "/chart";
    }

    @GetMapping("/getPieChartData")
    public ResponseEntity<ToastUiResponse> getPieChartData() {
        return new ResponseEntity<>(chartService.getPieChartData(), HttpStatus.OK);
    }
}
