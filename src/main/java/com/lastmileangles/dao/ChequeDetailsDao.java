package com.lastmileangles.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lastmileangles.entity.ChequeDetails;

@Transactional
@Repository
public class ChequeDetailsDao implements IChequeDetailsDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public ChequeDetails insertChequeDetails(ChequeDetails chequeDetails) {
		entityManager.persist(chequeDetails);
		return getLastInsertedCheque();
	}

	private ChequeDetails getLastInsertedCheque() {
		Query query = entityManager.createQuery("from ChequeDetails order by id DESC");
		query.setMaxResults(1);
		ChequeDetails chequeDetails = (ChequeDetails) query.getSingleResult();
		return chequeDetails;
	}
	
	@Override
	public ChequeDetails getChequeDetails(String chequeNumber) {
		return entityManager.find(ChequeDetails.class, chequeNumber);
	}
	
	private String getHTMLBodyMessage(ChequeDetails chequeDetail) {
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
				"<h2>Cheque details with cheque id: "+chequeDetail.getId()+"</h2>\r\n" + 
				"\r\n" + 
				"<table style=\"\">\r\n" + 
				"  <tr>\r\n" + 
				"    <th>Customer Name</th>\r\n" +
				"    <td>"+chequeDetail.getCustomerName()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Cheque number</th>\r\n" +
				"    <td>"+chequeDetail.getChequeNumber()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Date</th>\r\n" +
				"    <td>"+chequeDetail.getDate()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Bank</th>\r\n" +
				"    <td>"+chequeDetail.getBank()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Branch</th>\r\n" +
				"    <td>"+chequeDetail.getBranch()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Pick up date</th>\r\n" +
				"    <td>"+chequeDetail.getPickupDate()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Pick up time</th>\r\n" +
				"    <td>"+chequeDetail.getPickupTime()+"</td>\r\n" +
				"  </tr>\r\n" +
				"  <tr>\r\n" + 
				"    <th>Remarks</th>\r\n" +
				"    <td>"+chequeDetail.getRemarks()+"</td>\r\n" +
				"  </tr>\r\n" +
				"\r\n" + 
				"</table>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>";
	}

	@Override
	public String sendChequeDetailsEmail(String chequeNumber) {
		try {
			ChequeDetails chequeDetailsDB = getChequeDetails(chequeNumber);
			String emaildId = "";
			HtmlEmail email = new HtmlEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator(emaildId, ""));
			email.setSSLOnConnect(true);
			email.setFrom(emaildId);
			email.setSubject("cheque details :: " + chequeDetailsDB.getId());
			email.setHtmlMsg(getHTMLBodyMessage(chequeDetailsDB));
			email.addTo("");
			email.send();
			return "Email sent successfully";
		} catch (EmailException e) {
			e.printStackTrace();
			return "Email did not send message successfully";
		}
	}

}
