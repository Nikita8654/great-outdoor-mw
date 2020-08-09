package com.cg.goarm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.goarm.model.AdminRevenueReportModel;
import com.cg.goarm.service.AdminReportService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AdminReportController {

	@Autowired
	private AdminReportService adminService;
	
	@GetMapping("/revenue")
	public ResponseEntity<List<AdminRevenueReportModel>> getRevenueReport(){
		ResponseEntity<List<AdminRevenueReportModel>> response=null;
		List<AdminRevenueReportModel> revenueList=adminService.getRevenueReport();
		if(revenueList==null) {
			response=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			response=new ResponseEntity<>(revenueList,HttpStatus.OK);
		}
		return response;
	}
}
