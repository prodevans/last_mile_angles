package com.lastmileangles.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lastmileangles.entity.OrderDetails;

@Transactional
@Repository
public class OrderDetailsDAO implements IOrderDetailsDAO {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get order details available in database and
	 * return it as List<OrderDetails>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetails> getOrderDetails() {
		String hql = "FROM OrderDetails as atcl ORDER BY atcl.id";
		return (List<OrderDetails>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * This method is responsible to get a particular order detail by given order id
	 */
	@Override
	public OrderDetails getOrderDetail(int orderId) {
		return entityManager.find(OrderDetails.class, orderId);
	}

	/**
	 * This method is responsible to create new order in database
	 */
	@Override
	public OrderDetails createOrderDetails(OrderDetails orderDetails) {
		entityManager.persist(orderDetails);
        return getLastInsertedOrder();
	}

	/**
	 * This method is responsible to update order detail in database
	 */
	@Override
	public OrderDetails updateOrderDetails(int orderId, OrderDetails orderDetails) {

		// First We are taking OrderDetails detail from database by given order id and
		// then updating detail with provided order object
		OrderDetails orderDetailsDB = getOrderDetail(orderId);
		
		orderDetailsDB.setBillingAddress(orderDetails.getBillingAddress());
		orderDetailsDB.setServiceAddress(orderDetails.getServiceAddress());
		orderDetailsDB.setApplianceMake(orderDetails.getApplianceMake());
		orderDetailsDB.setServiceArea(orderDetails.getServiceArea());
		orderDetailsDB.setBillingArea(orderDetails.getBillingArea());
		orderDetailsDB.setServiceCity(orderDetails.getServiceCity());
		orderDetailsDB.setBillingCity(orderDetails.getBillingCity());
		orderDetailsDB.setCustomerName(orderDetails.getCustomerName());
		orderDetailsDB.setDurationOfContract(orderDetails.getDurationOfContract());
		orderDetailsDB.setEmailId(orderDetails.getEmailId());
		orderDetailsDB.setInvoiceDate(orderDetails.getInvoiceDate());
		orderDetailsDB.setInvoiceNo(orderDetails.getInvoiceNo());
		orderDetailsDB.setMobileNo(orderDetails.getMobileNo());
		orderDetailsDB.setOpted(orderDetails.getOpted());
		orderDetailsDB.setPaymentProcessed(orderDetails.isPaymentProcessed());
		orderDetailsDB.setServicePincode(orderDetails.getServicePincode());
		orderDetailsDB.setBillingPincode(orderDetails.getBillingPincode());
		orderDetailsDB.setSerialNo(orderDetails.getSerialNo());
		orderDetailsDB.setServiceType(orderDetails.getServiceType());
		orderDetailsDB.setPrice(orderDetails.getPrice());
		orderDetailsDB.setTypeOfContract(orderDetails.getTypeOfContract());

		entityManager.flush();
		// again taking updated result of orderDetails and returning the orderDetails
		// object
		OrderDetails updatedOrderDetails = getOrderDetail(orderId);

		return updatedOrderDetails;
	}

	/**
	 * This method will get the latest inserted record from the database and return
	 * the object of OrderDetails class
	 * 
	 * @return orderDetails
	 */
	private OrderDetails getLastInsertedOrder() {
		Query query = entityManager.createQuery("from OrderDetails order by id DESC");
		query.setMaxResults(1);
		OrderDetails orderDetails = (OrderDetails) query.getSingleResult();
		return orderDetails;
	}
	
	private String getHTMLBodyMessage(OrderDetails orderDetail) {
		return  "<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<style>\r\n" + 
				"table {\r\n" + 
				"    font-family: arial, sans-serif;\r\n" + 
				"    border-collapse: collapse;\r\n" + 
				"    width: 100%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"td, th {\r\n" + 
				"    border: 1px solid #dddddd;\r\n" + 
				"    text-align: left;\r\n" + 
				"    padding: 8px;\r\n" + 
				"}\r\n" + 
				"td {\r\n" + 
				"    background-color: #eee;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"\r\n" + 
				"<h2>Order details with order id: "+orderDetail.getId()+"</h2>\r\n" + 
				"\r\n" + 
				"<table style=\"\">\r\n" + 
				"  <tr>\r\n" + 
				"    <th>Customer Name</th>\r\n" +
				"    <td>"+orderDetail.getCustomerName()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Service Address</th>\r\n" +
				"    <td>"+orderDetail.getServiceAddress()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Service City</th>\r\n" +
				"    <td>"+orderDetail.getServiceCity()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Service Area</th>\r\n" +
				"    <td>"+orderDetail.getServiceArea()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Service Pin code</th>\r\n" +
				"    <td>"+orderDetail.getServicePincode()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Billing Address</th>\r\n" +
				"    <td>"+orderDetail.getBillingAddress()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Billing City</th>\r\n" +
				"    <td>"+orderDetail.getBillingCity()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Billing Area</th>\r\n" +
				"    <td>"+orderDetail.getBillingArea()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Billing Pin code</th>\r\n" +
				"    <td>"+orderDetail.getBillingPincode()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Mobile Number</th>\r\n" +
				"    <td>"+orderDetail.getMobileNo()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Email Id</th>\r\n" +
				"    <td>"+orderDetail.getEmailId()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Opted</th>\r\n" +
				"    <td>"+orderDetail.getOpted()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Duration of contract</th>\r\n" +
				"    <td>"+orderDetail.getDurationOfContract()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 					
				"    <th>Type of contract</th>\r\n" +
				"    <td>"+orderDetail.getTypeOfContract()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Appliance Make</th>\r\n" +
				"    <td>"+orderDetail.getApplianceMake()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Serial Number</th>\r\n" +
				"    <td>"+orderDetail.getSerialNo()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Invoice Number</th>\r\n" +
				"    <td>"+orderDetail.getInvoiceNo()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Service Type</th>\r\n" +
				"    <td>"+orderDetail.getServiceType()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Price for service</th>\r\n" +
				"    <td>"+orderDetail.getPrice()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Invoice Date</th>\r\n" +
				"    <td>"+orderDetail.getInvoiceDate()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Payment Porcessed</th>\r\n" +
				"    <td>"+orderDetail.isPaymentProcessed()+"</td>\r\n" +
				"  </tr>\r\n" +
				"\r\n" + 
				"</table>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>";
	}

	@Override
	public String sendMail(int orderId) {
		try {
			OrderDetails orderDetailsDB = getOrderDetail(orderId);
			String emaildId = "";
			HtmlEmail email = new HtmlEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator(emaildId, ""));
			email.setSSLOnConnect(true);
			email.setFrom(emaildId);
			email.setSubject("new order id::" + orderDetailsDB.getId());
			email.setHtmlMsg(getHTMLBodyMessage(orderDetailsDB));
			email.addTo("");
			email.send();
			return "Email sent successfully";
		} catch (EmailException e) {
			e.printStackTrace();
			return "Email did not send message successfully";
		}
	}

}
