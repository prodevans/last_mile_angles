package com.lastmileangles.services;

import com.lastmileangles.entity.ChequeDetails;

public interface IChequeDetailsService {
	ChequeDetails insertChequeDetails(ChequeDetails chequeDetails);
	String sendChequeDetailsEmail(String chequeNumber);
}
