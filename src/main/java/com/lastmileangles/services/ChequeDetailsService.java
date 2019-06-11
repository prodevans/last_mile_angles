package com.lastmileangles.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lastmileangles.dao.IChequeDetailsDao;
import com.lastmileangles.entity.ChequeDetails;

@Service
public class ChequeDetailsService implements IChequeDetailsService {
	
	@Autowired
	private IChequeDetailsDao dao;

	@Override
	public ChequeDetails insertChequeDetails(ChequeDetails chequeDetails) {
		return dao.insertChequeDetails(chequeDetails);
	}

	@Override
	public String sendChequeDetailsEmail(String chequeNumber) {
		return dao.sendChequeDetailsEmail(chequeNumber);
	}

}
