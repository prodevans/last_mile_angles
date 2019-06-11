package com.lastmileangles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lastmileangles.entity.ChequeDetails;
import com.lastmileangles.entity.EmailResponse;
import com.lastmileangles.entity.OrderDetails;
import com.lastmileangles.services.IChequeDetailsService;
import com.lastmileangles.services.IOrderDetailsService;

@Controller
@CrossOrigin
@RequestMapping("order")
public class OrderDetailsController {

	@Autowired
	private IOrderDetailsService service;

	@Autowired
	private IChequeDetailsService chequeService;

	@CrossOrigin
	@GetMapping("orderDetails")
	public ResponseEntity<List<OrderDetails>> getOrderDetails() {
		List<OrderDetails> orderDetails = service.getOrderDetails();
		return new ResponseEntity<List<OrderDetails>>(orderDetails, HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("orderDetails/{id}")
	public ResponseEntity<OrderDetails> getOrderDetail(@PathVariable("id") Integer id) {
		OrderDetails orderDetails = service.getOrderDetail(id);
		return new ResponseEntity<OrderDetails>(orderDetails, HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("sendMail/{id}")
	public ResponseEntity<EmailResponse> sendMail(@PathVariable("id") int id) {
		EmailResponse email = new EmailResponse();
		email.setMessage(service.sendMail(id));
		return new ResponseEntity<EmailResponse>(email, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("sendChequeDetailsEmail/{chequeNumber}")
	public ResponseEntity<EmailResponse> sendChequeDetailsEmail(@PathVariable("chequeNumber") String chequeNumber) {
		EmailResponse email = new EmailResponse();
		email.setMessage(chequeService.sendChequeDetailsEmail(chequeNumber));
		return new ResponseEntity<EmailResponse>(email, HttpStatus.OK);

	}

	@CrossOrigin
	@PostMapping("orderDetails")
	public ResponseEntity<OrderDetails> createOrderDetails(@RequestBody OrderDetails orderDetails) {
		OrderDetails orderDetailsResponse = service.createOrderDetails(orderDetails);
		return new ResponseEntity<OrderDetails>(orderDetailsResponse, HttpStatus.OK);

	}

	@CrossOrigin
	@PutMapping("orderDetails/{id}")
	public ResponseEntity<OrderDetails> updateOrderDetails(@PathVariable("id") int id,
			@RequestBody OrderDetails orderDetails) {
		OrderDetails orderDetailsResponse = service.updateOrderDetails(id, orderDetails);
		return new ResponseEntity<OrderDetails>(orderDetailsResponse, HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping("chequeDetails")
	public ResponseEntity<ChequeDetails> insertChequeDetails(@RequestBody ChequeDetails chequeDetails) {
		ChequeDetails chequeDetailsResponse = chequeService.insertChequeDetails(chequeDetails);
		return new ResponseEntity<ChequeDetails>(chequeDetailsResponse, HttpStatus.OK);
	}

}
