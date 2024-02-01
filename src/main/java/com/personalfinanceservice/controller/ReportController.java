package com.personalfinanceservice.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personalfinanceservice.model.AllSummaryReport;
import com.personalfinanceservice.service.ReportService;

@RestController
public class ReportController {

	@Autowired
	ReportService reportService;

	@GetMapping("getSummaryReport")
	public ResponseEntity<AllSummaryReport> getAllSummaryReport(@RequestParam(name = "trandate") Date trandate) {

		return new ResponseEntity<AllSummaryReport>(reportService.getAllSummaryReport(trandate), HttpStatus.OK);

	}

}
