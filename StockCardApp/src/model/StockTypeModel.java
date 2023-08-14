	package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.envers.Audited;


@Entity
@Table(name = "stocktype")
@Audited
public class StockTypeModel {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "tipkodu")
	private String stockTypeCode;
	@Column(name = "tipadi")
	private String stockTypeName;
	@Column(name = "tipaciklama")
	private String stockTypeExplanation;
	
	
	
	

	


	public StockTypeModel(int id, String stockTypeCode, String stockTypeName, String stockTypeExplanation) {
		super();
		this.id = id;
		this.stockTypeCode = stockTypeCode;
		this.stockTypeName = stockTypeName;
		this.stockTypeExplanation = stockTypeExplanation;
	}




	public StockTypeModel() {
		
	}




	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}




	public String getStockTypeCode() {
		return stockTypeCode;
	}




	public void setStockTypeCode(String stokTipKodu) {
		this.stockTypeCode = stokTipKodu;
	}




	public String getStockTypeName() {
		return stockTypeName;
	}




	public void setStockTypeName(String stokTipAdi) {
		this.stockTypeCode = stokTipAdi;
	}




	public String getStockTypeExplanation() {
		return stockTypeExplanation;
	}




	public void setStockTypeExplanation(String stokTipAciklama) {
		this.stockTypeExplanation = stokTipAciklama;
	}




	@Override
	public String toString() {
		return stockTypeName;
				 
	}




	@Override
	public int hashCode() {
		return Objects.hash(id, stockTypeExplanation, stockTypeName, stockTypeCode);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockTypeModel other = (StockTypeModel) obj;
		return id == other.id && Objects.equals(stockTypeExplanation, other.stockTypeExplanation)
				&& Objects.equals(stockTypeName, other.stockTypeName) && Objects.equals(stockTypeCode, other.stockTypeCode);
	}
	
	

}
