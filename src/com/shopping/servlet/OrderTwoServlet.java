package com.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.dao.Page;
import com.shopping.entity.Categorys;
import com.shopping.entity.Customers;
import com.shopping.entity.Employ;
import com.shopping.entity.Order_detail;
import com.shopping.entity.Orders;
import com.shopping.entity.Products;
import com.shopping.entity.Providers;
import com.shopping.serviceimpl.CategoryServiceImpl;
import com.shopping.serviceimpl.CustomerServiceImpl;
import com.shopping.serviceimpl.EmployServiceImpl;
import com.shopping.serviceimpl.OrderServiceImpl;
import com.shopping.serviceimpl.Order_DetailsServiceImpl;
import com.shopping.serviceimpl.ProductServiceImpl;
import com.shopping.serviceimpl.ProviderServiceImpl;

public class OrderTwoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		OrderServiceImpl order1 = new OrderServiceImpl();
		String p = request.getParameter("p");
		if ("doadd".equals(p)) {
			doadd(request, response);
		} else if ("doma".equals(p)) {
			doma(request, response);
		} else if ("doma1".equals(p)) {
			doma1(request, response);
		}else if ("doma2".equals(p)) {
			doma2(request, response);
		}else if ("doma3".equals(p)) {
			doma3(request, response);
		}
		
		else if ("dosede".equals(p)) {
			dosede(request, response);
		} 
		else if ("doadd1".equals(p)) {
			doadd1(request, response);
		}
		 else if ("doadds1".equals(p)) {
				doadds1(request, response);
			}
		 else if ("doadds2".equals(p)) {   
				doadds2(request, response);
			}
		else if ("dodel1".equals(p)) {
			dodel1(request, response);
		} 
		else if ("dodel".equals(p)) {
			dodel(request, response);
		}else if ("dodel2".equals(p)) {
			dodel2(request, response);
		}  
		else if ("dodelmany".equals(p)) {
			dodelmany(request, response);

		}else if("doup1".equals(p)){
			doup1(request, response);
		}else if("doup2".equals(p)){
			doup2(request, response);
		}else if("doupdetail".equals(p)){
			doupdetail(request, response);
		}else if("doupdetails".equals(p)){
			doupdetails(request, response);
		}else if ("dodelmany1".equals(p)) {
			dodelmany1(request, response);

		}else if ("dodelmany2".equals(p)) {
			dodelmany2(request, response);

		}else if("search".equals(p)){
			search(request, response);
		}else if("search1".equals(p)){
			search1(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

	
	public void doupdetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Order_DetailsServiceImpl order=new Order_DetailsServiceImpl();
		Order_detail orders=new Order_detail();
		String id=request.getParameter("id1");
		orders=order.selectByOrder(id);	
		System.out.println(orders+"xfcghj----------------------");
		
		ProductServiceImpl products=new ProductServiceImpl();
		ArrayList<Products> product=products.selectAllProduct();
		
		request.setAttribute("product", product);
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/Admin/orders/order_DetailUp.jsp").forward(request, response);


	}
	public void doupdetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Order_DetailsServiceImpl orderde=new Order_DetailsServiceImpl();
		Order_detail orders=new Order_detail();
		
		int id=Integer.parseInt(request.getParameter("id"));
		String orderID=request.getParameter("orderID");
		
		int productID=Integer.parseInt(request.getParameter("product_name"));	
		Products products=new Products();
		ProductServiceImpl product=new ProductServiceImpl();
		products=product.selectByID(productID);
		orders.setProducts(products);
		
		
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		int discount=Integer.parseInt(request.getParameter("discount"));
		

		int t=orderde.updateOrderde(id, orderID, products, quantity, discount);
		if(t>0){
			response.getWriter().print("<script>alert('修改成功');location.href='OrderTwoServlet?p=doma1&currentPage=1&PageSize=10'</script>");
		}
		else{
			response.getWriter().print("<script>alert('修改失败');location.href='OrderTwoServlet?p=doma1&currentPage=1&PageSize=10'</script>");
		}

	}
	public void doup1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderServiceImpl order=new OrderServiceImpl();
		Orders orders=new Orders();
		String orderID=request.getParameter("id");
		orders=order.selectOrderByID(orderID);	
		System.out.println(orderID+"555555555");
		CustomerServiceImpl customer1=new CustomerServiceImpl();
		ArrayList<Customers> customers=customer1.selectAllCate();
		
		EmployServiceImpl employ1=new EmployServiceImpl();
		ArrayList<Employ> employs=employ1.selectEmploy();
		
		request.setAttribute("orders", orders);
		request.setAttribute("customers", customers);
		request.setAttribute("employs", employs);
		
		request.getRequestDispatcher("/Admin/orders/orderup.jsp").forward(request, response);

	}

	public void doup2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderServiceImpl order=new OrderServiceImpl();
		Orders orders=new Orders();
		
		String orderID=request.getParameter("orderID");
		
		String order_date=request.getParameter("order_date");
		
		Customers customerss=new Customers();
		CustomerServiceImpl customer=new CustomerServiceImpl();	
		int customerID=Integer.parseInt(request.getParameter("customers"));
		customerss=customer.selectByID(customerID);
		
		orders.setCustomers(customerss);
		
		Employ employ=new Employ();
		int empID=Integer.parseInt(request.getParameter("employees"));
		EmployServiceImpl employss=new EmployServiceImpl();
		employ=employss.selectByID(empID);
	
		orders.setEmploy(employ);
		 //修改
		int t=order.updateOrder(orderID,order_date,customerss,employ);
		if(t>0){
		response.getWriter().print("<script>alert('修改成功');location.href='OrderTwoServlet?p=doma&currentPage=1&PageSize=10'</script>");
		}
	
		
	}

	public void dodelmany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		// int productID=Integer.parseInt(request.getParameter("id"));
		//接收productmanager.jsp 中显示产品的语句中<input name="nn" type="checkbox" value="${product.productID}">的name="nn"中的nn
		String[] ids = request.getParameterValues("nn");// request.getParameterValues("nn");可以接收多条，可以说是一个数组。
		OrderServiceImpl service = new OrderServiceImpl();
		int result = 0;
		// 单条循环删除
		if (ids != null) {
			//for循环将选中的所有记录遍历一下
			for (int i = 0; i < ids.length; i++) {
				String orderID = ids[i];
				//单条循环删除所选的多条信息。循环 单条删除的方法
				result = service.deleteOrderByID(orderID);//相当于删除一条记录。
			}
		} else {
			out.print("<script>alert('删除失败');location.href='OrderTwoServlet?p=doma&currentPage=1&PageSize=10';</script>");
		}
		if (result > 0) {
			out.print("<script>alert('删除成功');location.href='OrderTwoServlet?p=doma&currentPage=1&PageSize=10';</script>");
			
		}else{
			out.print("<script>alert('删除失败,还有订单信息存在');location.href='OrderTwoServlet?p=doma&currentPage=1&PageSize=10';</script>");
		}

	}

	public void dodelmany1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		// int productID=Integer.parseInt(request.getParameter("id"));
		String[] ids = request.getParameterValues("nn1");
		Order_DetailsServiceImpl service = new Order_DetailsServiceImpl();
		int result = 0;
		// 单条循环删除
		if (ids != null) {
			for (int i = 0; i < ids.length; i++) {
				String orderID = ids[i];

				result = service.deleteByOrderID(orderID);
			}
		} else {
			out.print("<script>alert('删除失败');location.href='OrderTwoServlet?p=doma1&currentPage=1&PageSize=10';</script>");
		}
		if (result ==0) {
			out.print("<script>alert('删除成功！');location.href='OrderTwoServlet?p=doma1&currentPage=1&PageSize=10';</script>");
			
		}

	}
	public void dodelmany2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		// int productID=Integer.parseInt(request.getParameter("id"));
		String[] ids = request.getParameterValues("nn1");
		Order_DetailsServiceImpl service = new Order_DetailsServiceImpl();
		int result = 0;
		// 单条循环删除
		if (ids != null) {
			for (int i = 0; i < ids.length; i++) {
				String orderID = ids[i];

				result = service.deleteByOrderID(orderID);
			}
		} else {
			out.print("<script>alert('删除失败');location.href='OrderTwoServlet?p=doma1&currentPage=1&PageSize=10';</script>");
		}
		if (result ==0) {
			out.print("<script>alert('删除成功！');location.href='OrderTwoServlet?p=doma1&currentPage=1&PageSize=10';</script>");
			
		}

	}

	public void dodel1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		OrderServiceImpl order = new OrderServiceImpl();
		int t = order.deleteOrderByID(id);
		if (t > 0) {
			response.getWriter().print("<script>alert('删除成功');location.href='OrderTwoServlet?p=doma&currentPage=1&PageSize=10'</script>");
		} else if (t < 0) {
			response.getWriter().print(
					"<script>alert('还有订单信息存在，删除失败');location.href='OrderTwoServlet?p=doma&currentPage=1&PageSize=10'</script>");
		} else {
			response.getWriter().print("<script>alert('删除失败');location.href='OrderTwoServlet?p=doma&currentPage=1&PageSize=10'</script>");
		}

}
	
	public void dodel2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Order_DetailsServiceImpl order = new Order_DetailsServiceImpl();
		int t = order.deleteByid(id);
		if (t > 0) {
			response.getWriter().print(
					"<script>alert('删除成功');location.href='OrderTwoServlet?p=doma&currentPage=1&PageSize=10'</script>");
		} else {
			response.getWriter().print(
					"<script>alert('删除失败');location.href='OrderTwoServlet?p=doma&currentPage=1&PageSize=10'</script>");
		}

}
	public void dodel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		Order_DetailsServiceImpl order = new Order_DetailsServiceImpl();
		int t = order.deleteByOrderID(id);
		if (t > 0) {
			response.getWriter().print(
					"<script>alert('删除成功');location.href='OrderTwoServlet?p=doma1&currentPage=1&PageSize=10'</script>");
		} else {
			response.getWriter().print(
					"<script>alert('删除失败');location.href='OrderTwoServlet?p=doma1&currentPage=1&PageSize=10'</script>");
		}

	}
	
	public void doma(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderServiceImpl order3 = new OrderServiceImpl();
		ArrayList<Orders> list=order3.selectAll();
		request.setAttribute("list", list);
		
		Order_DetailsServiceImpl order = new Order_DetailsServiceImpl();

		OrderServiceImpl order1 = new OrderServiceImpl();
		
		if (request.getParameter("currentPage") != null && request.getParameter("PageSize") != null) {
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));
			int PageSize = Integer.parseInt(request.getParameter("PageSize"));
			Page<Orders> proPage1 = order1.selectAll(currentPage, PageSize);
			request.setAttribute("proPage1", proPage1);
			Page<Order_detail> proPage = order.selectAllCate(currentPage, PageSize);
			request.setAttribute("proPage", proPage);
		} else {
			Page<Orders> proPage1 = order1.selectAll(1, 10);
			request.setAttribute("proPage1", proPage1);
			Page<Order_detail> proPage = order.selectAllCate(1, 10);
			request.setAttribute("proPage", proPage);
		}
		// 订单编号生成
		String orderID = request.getParameter("orderID");
		Date date = new Date();
		orderID = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
		double one = Math.random();
		int a = (int) (one * 100);
		orderID = orderID + a;
		System.out.print(orderID);
		// 得到所有客户
		CustomerServiceImpl customer1 = new CustomerServiceImpl();
		ArrayList<Customers> customers = customer1.selectAllCate();
		System.out.print(customers + "fdghjkl;0-===============");
		// 得到所有员工
		EmployServiceImpl employ = new EmployServiceImpl();
		ArrayList<Employ> employees = employ.selectEmploy();
		System.out.println(employees + "hjkl------------------");
		// 得到所有产品
		ProductServiceImpl product1 = new ProductServiceImpl();
		ArrayList<Products> products = product1.selectAllProduct();

		System.out.println(products + "fghnjm-------------------------");
		// 把值带到新增页面
		request.setAttribute("orderID", orderID);
		request.setAttribute("customers", customers);
		request.setAttribute("employees", employees);
		request.setAttribute("products", products);
		request.getRequestDispatcher("/Admin/orders/ordermanager.jsp").forward(request, response);
		
		
		
		
	}

	public void doma3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		//先把三个条件，做成产品搜索对象
		OrderServiceImpl service =new OrderServiceImpl();
		ArrayList<Orders> list=service.selectAll();
		
		Orders p1=new Orders();
		String orderID = request.getParameter("orderID");
		p1.setOrderID(orderID);
		
		int currentPage=0;
		int PageSize=0;
		
		currentPage=Integer.parseInt(request.getParameter("currentPage"));
		System.out.println(currentPage);
		PageSize=Integer.parseInt(request.getParameter("PageSize"));
		System.out.println(PageSize);
		
		if (request.getParameter("currentPage") != null && request.getParameter("PageSize") != null) {
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		
			PageSize=Integer.parseInt(request.getParameter("PageSize"));
		
			Page<Orders> proPage=service.selectAllCate(p1, currentPage, PageSize);
		
			
			request.setAttribute("proPage1", proPage);
		} else {
			Page<Orders> proPage1=service.selectAllCate(p1, 1, 10);
		
			
			request.setAttribute("proPage1", proPage1);
		}
	
		request.setAttribute("list", list);
		request.setAttribute("p1", p1);
	
		request.getRequestDispatcher("/Admin/orders/ordermanager3.jsp").forward(request, response);
		
	}

	public void doma1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		OrderServiceImpl order3 = new OrderServiceImpl();
		ArrayList<Orders> list=order3.selectAll();
		request.setAttribute("list", list);
		Order_DetailsServiceImpl order = new Order_DetailsServiceImpl();

		OrderServiceImpl order1 = new OrderServiceImpl();

		if (request.getParameter("currentPage") != null && request.getParameter("PageSize") != null) {
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));
			int PageSize = Integer.parseInt(request.getParameter("PageSize"));
			Page<Orders> proPage1 = order1.selectAll(currentPage, PageSize);
			request.setAttribute("proPage1", proPage1);
			Page<Order_detail> proPage = order.selectAllCate(currentPage, PageSize);
			request.setAttribute("proPage", proPage);
		} else {
			Page<Orders> proPage1 = order1.selectAll(1, 10);
			request.setAttribute("proPage1", proPage1);
			Page<Order_detail> proPage = order.selectAllCate(1, 10);
			request.setAttribute("proPage", proPage);
		}
		// 订单编号生成
		String orderID = request.getParameter("orderID");
		Date date = new Date();
		orderID = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
		double one = Math.random();
		int a = (int) (one * 100);
		orderID = orderID + a;
		System.out.print(orderID);
		// 得到所有客户
		CustomerServiceImpl customer1 = new CustomerServiceImpl();
		ArrayList<Customers> customers = customer1.selectAllCate();
		System.out.print(customers + "fdghjkl;0-===============");
		// 得到所有员工
		EmployServiceImpl employ = new EmployServiceImpl();
		ArrayList<Employ> employees = employ.selectEmploy();
		System.out.println(employees + "hjkl------------------");
		// 得到所有产品
		ProductServiceImpl product1 = new ProductServiceImpl();
		ArrayList<Products> products = product1.selectAllProduct();

		System.out.println(products + "fghnjm-------------------------");
		// 把值带到新增页面
		request.setAttribute("orderID", orderID);
		request.setAttribute("customers", customers);
		request.setAttribute("employees", employees);
		request.setAttribute("products", products);
		request.getRequestDispatcher("/Admin/orders/order_detailmanager.jsp").forward(request, response);	
	}

	public void doma2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		OrderServiceImpl order3 = new OrderServiceImpl();
		ArrayList<Orders> list=order3.selectAll();
		request.setAttribute("list", list);
		Order_DetailsServiceImpl order = new Order_DetailsServiceImpl();

		OrderServiceImpl order1 = new OrderServiceImpl();

		if (request.getParameter("currentPage") != null && request.getParameter("PageSize") != null) {
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));
			int PageSize = Integer.parseInt(request.getParameter("PageSize"));
			Page<Orders> proPage1 = order1.selectAll(currentPage, PageSize);
			request.setAttribute("proPage1", proPage1);
			Page<Order_detail> proPage = order.selectAllCate(currentPage, PageSize);
			request.setAttribute("proPage", proPage);
		} else {
			Page<Orders> proPage1 = order1.selectAll(1, 10);
			request.setAttribute("proPage1", proPage1);
			Page<Order_detail> proPage = order.selectAllCate(1, 10);
			request.setAttribute("proPage", proPage);
		}
		// 订单编号生成
		String orderID = request.getParameter("orderID");
		Date date = new Date();
		orderID = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
		double one = Math.random();
		int a = (int) (one * 100);
		orderID = orderID + a;
		System.out.print(orderID);
		// 得到所有客户
		CustomerServiceImpl customer1 = new CustomerServiceImpl();
		ArrayList<Customers> customers = customer1.selectAllCate();
		System.out.print(customers + "fdghjkl;0-===============");
		// 得到所有员工
		EmployServiceImpl employ = new EmployServiceImpl();
		ArrayList<Employ> employees = employ.selectEmploy();
		System.out.println(employees + "hjkl------------------");
		// 得到所有产品
		ProductServiceImpl product1 = new ProductServiceImpl();
		ArrayList<Products> products = product1.selectAllProduct();

		System.out.println(products + "fghnjm-------------------------");
		// 把值带到新增页面
		request.setAttribute("orderID", orderID);
		request.setAttribute("customers", customers);
		request.setAttribute("employees", employees);
		request.setAttribute("products", products);
		request.getRequestDispatcher("/Admin/orders/order_detailmanager2.jsp").forward(request, response);

		
		
		
	}

	public void doadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out = response.getWriter();
		// 订单信息
		// 编号
		String orderID = request.getParameter("orderID");
		// 下单日期
		String order_date = request.getParameter("order_date");
		// 客户
		int t = 0;
		if (request.getParameter("customers") != null && request.getParameter("employees") != null) {
			int customerID = Integer.parseInt(request.getParameter("customers"));
			// CustomerServiceImpl customer = new CustomerServiceImpl();
			Customers customers = new Customers();
			// customers = customer.selectByID(customerID);
			customers.setCustomerID(customerID);
			Orders order2 = new Orders();
			order2.setCustomers(customers);

			// 业务员
			int empID = Integer.parseInt(request.getParameter("employees"));
			// EmployServiceImpl employ = new EmployServiceImpl();
			Employ employs = new Employ();
			// employs = employ.selectByID(empID);
			employs.setEmpID(empID);
			order2.setEmploy(employs);

			OrderServiceImpl order = new OrderServiceImpl();
			Orders order1 = new Orders(orderID, order_date, customers, employs);
			if (order1 != null) {
				t = order.addorder(order1);
			}
		}
		System.out.print(t);
		if (t > 0) {

			String[] arr = request.getParameterValues("products");
			String[] arr1 = request.getParameterValues("quantity");
			String[] arr2 = request.getParameterValues("discount");
			int productID = 0;
			int quantity = 0;
			int discount = 0;
			//Order_DetailsServiceImpl order2 = new Order_DetailsServiceImpl();
			Order_detail order_detail = new Order_detail();
			Order_detail[] list = new Order_detail[arr.length];
			for (int j = 0; j < arr.length; j++) {

				productID = Integer.parseInt(arr[j]);

				// ProductServiceImpl product = new ProductServiceImpl();
				Products products = new Products();
				products.setProductID(productID);
				order_detail.setProducts(products);

				quantity = Integer.parseInt(arr1[j]);
				discount = Integer.parseInt(arr2[j]);
				list[j] = new Order_detail(orderID, products, quantity, discount);

			}

			Order_DetailsServiceImpl ord = new Order_DetailsServiceImpl();
			int a = ord.addorderde(list);
			if (a > 0) {
				response.getWriter().print(
						"<script>alert('--下单成功--');location.href='OrderTwoServlet?p=doma&currentPage=1&PageSize=10';</script>");
			} else {
				response.getWriter().print("<script>alert('下单失败')</script>");
				request.getRequestDispatcher("/Admin/orders/ordermanager.jsp").forward(request, response);
			}
		}

	}

	public void doadd1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 订单编号生成
		String orderID = request.getParameter("orderID");
		Date date = new Date();
		orderID = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(date);
		double one = Math.random();
		int a = (int) (one * 100);
		orderID = orderID + a;
	
		System.out.print(orderID);

		CustomerServiceImpl customer1 = new CustomerServiceImpl();
		ArrayList<Customers> customers = customer1.selectAllCate();
		System.out.print(customers + "dfghjk-----------");

		EmployServiceImpl employ = new EmployServiceImpl();
		ArrayList<Employ> employees = employ.selectEmploy();
		System.out.print(employees + "sdfghj---------------");

		ProductServiceImpl product1 = new ProductServiceImpl();
		ArrayList<Products> products = product1.selectAllProduct();
		// 把值带到新增页面
		request.setAttribute("orderID", orderID);
		request.setAttribute("customers", customers);
		request.setAttribute("employees", employees);
		request.setAttribute("products", products);
		request.getRequestDispatcher("/Admin/orders/ordermanager.jsp").forward(request, response);

	}

	public void doadds2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
				OrderServiceImpl order=new OrderServiceImpl();
				Orders orders=new Orders();
				String orderID=request.getParameter("id");
				orders=order.selectOrderByID(orderID);	

				CustomerServiceImpl customer1 = new CustomerServiceImpl();
				ArrayList<Customers> customers = customer1.selectAllCate();
				System.out.print(customers + "dfghjk-----------");

				EmployServiceImpl employ = new EmployServiceImpl();
				ArrayList<Employ> employees = employ.selectEmploy();
				System.out.print(employees + "sdfghj---------------");

				ProductServiceImpl product1 = new ProductServiceImpl();
				ArrayList<Products> products = product1.selectAllProduct();
				// 把值带到新增页面
				request.setAttribute("orders", orders);
				request.setAttribute("customers", customers);
				request.setAttribute("employees", employees);
				request.setAttribute("products", products);
				request.getRequestDispatcher("/Admin/orders/orderadd.jsp").forward(request, response);
	} 
	public void doadds1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String orderID = request.getParameter("orderID");
			String[] arr = request.getParameterValues("products");
			String[] arr1 = request.getParameterValues("quantity");
			String[] arr2 = request.getParameterValues("discount");
			int productID = 0;
			int quantity = 0;
			int discount = 0;
			Order_DetailsServiceImpl order2 = new Order_DetailsServiceImpl();
			Order_detail order_detail = new Order_detail();
			Order_detail[] list = new Order_detail[arr.length];
			for (int j = 0; j < arr.length; j++) {

				productID = Integer.parseInt(arr[j]);

				// ProductServiceImpl product = new ProductServiceImpl();
				Products products = new Products();
				products.setProductID(productID);
				order_detail.setProducts(products);

				quantity = Integer.parseInt(arr1[j]);
				discount = Integer.parseInt(arr2[j]);
				list[j] = new Order_detail(orderID, products, quantity, discount);

			}

			Order_DetailsServiceImpl ord = new Order_DetailsServiceImpl();
			int a = ord.addorderde(list);
			if (a > 0) {
				response.getWriter().print("<script>alert('--下单成功--');location.href='OrderTwoServlet?p=doma&currentPage=1&PageSize=10';</script>");
			} else {
				response.getWriter().print("<script>alert('下单失败')</script>");
				request.getRequestDispatcher("/Admin/orders/order_detailmanager.jsp").forward(request, response);
			}
		

	}

	
	
	public void dosede(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String orderID=request.getParameter("id");
		Order_DetailsServiceImpl order=new Order_DetailsServiceImpl();
		List<Order_detail> orders=order.selectByOrderID(orderID);
		
		ProductServiceImpl service = new ProductServiceImpl();
		ArrayList<Products> products = new ArrayList<Products>();
		products = service.selectAllProduct();

		request.setAttribute("products", products);

		if(orders==null){
			response.getWriter().print("<script>alert('无订单详情'); location.href='OrderTwoServlet?p=doma&currentPage=1&PageSize=10';</script>");
		}else{
			request.setAttribute("orders", orders);
		}
		request.getRequestDispatcher("/Admin/orders/order_detailmanager2.jsp").forward(request, response);

	}
	
public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//先把三个条件，做成产品搜索对象
		OrderServiceImpl service =new OrderServiceImpl();
		ArrayList<Orders> list=service.selectAll();
		
		
		
		request.setAttribute("list", list);
		OrderServiceImpl order3 = new OrderServiceImpl();
		ArrayList<Orders> list1=order3.selectAll();
		request.setAttribute("list1", list1);
		
		Order_DetailsServiceImpl order = new Order_DetailsServiceImpl();
		OrderServiceImpl order1 = new OrderServiceImpl();

		if (request.getParameter("currentPage") != null && request.getParameter("PageSize") != null) {
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));
			int PageSize = Integer.parseInt(request.getParameter("PageSize"));
			Page<Orders> proPage1 = order1.selectAll(currentPage, PageSize);
			request.setAttribute("proPage1", proPage1);
			Page<Order_detail> proPage = order.selectAllCate(currentPage, PageSize);
			request.setAttribute("proPage", proPage);
		} else {
			Page<Orders> proPage1 = order1.selectAll(1, 10);
			request.setAttribute("proPage1", proPage1);
			Page<Order_detail> proPage = order.selectAllCate(1, 10);
			request.setAttribute("proPage", proPage);
		}
		// 订单编号生成
		String orderID = request.getParameter("orderID");
		Orders li=service.selectOrderByID(orderID);
		request.setAttribute("li", li);
		
		
		Date date = new Date();
		orderID = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
		double one = Math.random();
		int a = (int) (one * 100);
		orderID = orderID + a;
		System.out.print(orderID);
		// 得到所有客户
		CustomerServiceImpl customer1 = new CustomerServiceImpl();
		ArrayList<Customers> customers = customer1.selectAllCate();
		System.out.print(customers + "fdghjkl;0-===============");
		// 得到所有员工
		EmployServiceImpl employ = new EmployServiceImpl();
		ArrayList<Employ> employees = employ.selectEmploy();
		System.out.println(employees + "hjkl------------------");
		// 得到所有产品
		ProductServiceImpl product1 = new ProductServiceImpl();
		ArrayList<Products> products = product1.selectAllProduct();

		System.out.println(products + "fghnjm-------------------------");
		// 把值带到新增页面
		request.setAttribute("orderID", orderID);
		request.setAttribute("customers", customers);
		request.setAttribute("employees", employees);
		request.setAttribute("products", products);
		request.getRequestDispatcher("/Admin/orders/ordermanager.jsp").forward(request, response);
	
	}
	
	
public void search1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//先把三个条件，做成产品搜索对象
	OrderServiceImpl service =new OrderServiceImpl();
	ArrayList<Orders> list=service.selectAll();
	
	Orders p1=new Orders();
	String orderID = request.getParameter("orderID");
	p1.setOrderID(orderID);
	
	int currentPage=0;
	int PageSize=0;
	
	currentPage=Integer.parseInt(request.getParameter("currentPage"));
	System.out.println(currentPage);
	PageSize=Integer.parseInt(request.getParameter("PageSize"));
	System.out.println(PageSize);
	
	request.setAttribute("list", list);
	Page<Orders> proPage1=service.selectAllCate(p1, currentPage, PageSize);
	System.out.print(proPage1);
	request.setAttribute("p1", p1);
	request.setAttribute("proPage1", proPage1);
	request.getRequestDispatcher("/Admin/orders/ordermanager3.jsp").forward(request, response);
	
}


}
