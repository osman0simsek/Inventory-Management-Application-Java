package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import controller.MainController;

@Entity
@Table(name = "kdvtype")
@Audited
public class KdvTypeModel {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "kdvkodu")
	private String kdvCode;
	@Column(name = "kdvadi")
	private String kdvName;
	@Column(name = "kdvorani")
	private String kdvRate;
	
	
	
	
	public KdvTypeModel(int id, String kdvCode, String kdvName, String kdvRate) {
		super();
		this.id = id;
		this.kdvCode = kdvCode;
		this.kdvName = kdvName;
		this.kdvRate = kdvRate;
	}



	public KdvTypeModel() {
		
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getKdvCode() {
		return kdvCode;
	}



	public void setKdvCode(String kdvCode) {
		this.kdvCode = kdvCode;
	}



	public String getKdvName() {
		return kdvName;
	}



	public void setKdvName(String kdvName) {
		this.kdvName = kdvName;
	}



	public String getKdvRate() {
		return kdvRate;
	}



	public void setKdvRate(String kdvRate) {
		this.kdvRate = kdvRate;
	}



	
	
	@Override
	public String toString() {
		return kdvRate;
	}

	



public Object[] getKdvData() {
		
		
		Object[] kdvdata = {kdvCode,kdvName,kdvRate};
		
		
		return kdvdata;
	}

	
}
