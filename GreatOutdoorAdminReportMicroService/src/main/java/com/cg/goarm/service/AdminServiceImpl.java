package com.cg.goarm.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.goarm.model.AdminGrowthReportModel;
import com.cg.goarm.model.AdminRevenueReportModel;
import com.cg.goarm.model.OrderModel;
import com.cg.goarm.model.ProductModel;

@Service
public class AdminServiceImpl implements AdminReportService{
	
	@Autowired
	private ProductProxyService productProxyService;
	@Autowired
	private OrderProxyService orderProxyService;
	
	private List<ProductModel> getAllProducts(){
		return productProxyService.getAllProducts();
	}
	private List<OrderModel> getAllOrders(){
		return orderProxyService.getAllOrders();
	}
	private AdminRevenueReportModel getRevenueReport(OrderModel order) {
		AdminRevenueReportModel revenue=null;
		if(order!=null) {
			revenue=new AdminRevenueReportModel();
			revenue.setUserId(order.getUserId());
			revenue.setOrderId(order.getOrderId());
			revenue.setDate(order.getOrderInitiateTime());
			if(order.getDispatchStatus()==1) {
				revenue.setDispatchStatus("ORDERED");
			}
			if(order.getDispatchStatus()==2) {
				revenue.setDispatchStatus("CANCELLED");
			}
			
			
			ProductModel model=productProxyService.getProduct(order.getProductId());
			if(model!=null) {
				revenue.setProductId(model.getProductId());
				revenue.setProductCategory(model.getProductCategory());
				revenue.setProductPrice(model.getProductPrice());
				revenue.setProductName(model.getProductName());
			}
		}
		return revenue;
	}

	@Override
	public List<AdminRevenueReportModel> getRevenueReport() {
		List<OrderModel> orderList=getAllOrders();
		List<AdminRevenueReportModel> revenueList=null;
		if(orderList!=null) {
			revenueList= orderList.stream().map((order)->getRevenueReport(order)).collect(Collectors.toList());
		}
		return revenueList;
		
	}
	@Override
	public List<AdminGrowthReportModel> getYearlyGrowthReport() {

		return null;
	}
	@Override
	public List<AdminGrowthReportModel> getMonthlyGrowthReport() {
	
		return null;
	}
	@Override
	public List<AdminGrowthReportModel> getQuaterlyGrowthReport() {
	
		return null;
	}

}
