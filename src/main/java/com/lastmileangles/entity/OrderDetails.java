package com.lastmileangles.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_details")
public class OrderDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "service_address")
	private String serviceAddress;

	@Column(name = "service_city")
	private String serviceCity;

	@Column(name = "service_area")
	private String serviceArea;

	@Column(name = "service_pincode")
	private String servicePincode;

	@Column(name = "billing_address")
	private String billingAddress;

	@Column(name = "billing_city")
	private String billingCity;

	@Column(name = "billing_area")
	private String billingArea;

	@Column(name = "billing_pincode")
	private String billingPincode;

	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "opted")
	private String opted;

	@Column(name = "duration_of_contract")
	private String durationOfContract;

	@Column(name = "type_of_contract")
	private String typeOfContract;

	@Column(name = "appliance_make")
	private String applianceMake;

	@Column(name = "serial_no")
	private String serialNo;

	@Column(name = "invoice_no")
	private String invoiceNo;

	@Column(name = "invoice_date")
	private String invoiceDate;

	@Column(name = "service_type")
	private String serviceType;

	@Column(name = "price")
	private String price;

	@Column(name = "payment_processed")
	private boolean paymentProcessed;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getServiceAddress() {
		return serviceAddress;
	}

	public void setServiceAddress(String serviceAddress) {
		this.serviceAddress = serviceAddress;
	}

	public String getServiceCity() {
		return serviceCity;
	}

	public void setServiceCity(String serviceCity) {
		this.serviceCity = serviceCity;
	}

	public String getServiceArea() {
		return serviceArea;
	}

	public void setServiceArea(String serviceArea) {
		this.serviceArea = serviceArea;
	}

	public String getServicePincode() {
		return servicePincode;
	}

	public void setServicePincode(String servicePincode) {
		this.servicePincode = servicePincode;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getBillingArea() {
		return billingArea;
	}

	public void setBillingArea(String billingArea) {
		this.billingArea = billingArea;
	}

	public String getBillingPincode() {
		return billingPincode;
	}

	public void setBillingPincode(String billingPincode) {
		this.billingPincode = billingPincode;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getOpted() {
		return opted;
	}

	public void setOpted(String opted) {
		this.opted = opted;
	}

	public String getDurationOfContract() {
		return durationOfContract;
	}

	public void setDurationOfContract(String durationOfContract) {
		this.durationOfContract = durationOfContract;
	}

	public String getTypeOfContract() {
		return typeOfContract;
	}

	public void setTypeOfContract(String typeOfContract) {
		this.typeOfContract = typeOfContract;
	}

	public String getApplianceMake() {
		return applianceMake;
	}

	public void setApplianceMake(String applianceMake) {
		this.applianceMake = applianceMake;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public boolean isPaymentProcessed() {
		return paymentProcessed;
	}

	public void setPaymentProcessed(boolean paymentProcessed) {
		this.paymentProcessed = paymentProcessed;
	}

}
