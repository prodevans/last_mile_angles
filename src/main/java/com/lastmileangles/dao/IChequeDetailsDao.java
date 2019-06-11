package com.lastmileangles.dao;

import com.lastmileangles.entity.ChequeDetails;

public interface IChequeDetailsDao {
	ChequeDetails insertChequeDetails(ChequeDetails chequeDetails);

	ChequeDetails getChequeDetails(String chequeNumber);

	String sendChequeDetailsEmail(String chequeNumber);
}
