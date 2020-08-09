package com.cg.goarm.service;

import java.util.List;

import com.cg.goarm.model.AdminGrowthReportModel;
import com.cg.goarm.model.AdminRevenueReportModel;

public interface AdminReportService {

	public List<AdminRevenueReportModel> getRevenueReport();
	public List<AdminGrowthReportModel> getYearlyGrowthReport();
	public List<AdminGrowthReportModel> getMonthlyGrowthReport();
	public List<AdminGrowthReportModel> getQuaterlyGrowthReport();
}
