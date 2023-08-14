package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "stockcard1")
public class StockCard {
	
	
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(insertable = false, updatable = false)
	private int stokTipi;
	@Column(insertable = false, updatable = false)
	private int kdvTipi;
	
	@Column(name = "stokKodu")
	private String stokKodu;
	@Column(name = "stokAdi")
	private String stokAdi;;
	@Column(name = "birimi")
	private String birimi;
	@Column(name = "barkodu")
	private String barkodu;
	@Column(name = "aciklama")
	private String aciklama;
	@Column(name = "olusturmaTarihi")
	private String olusturmaTarihi;
	
	@OneToOne
	@JoinColumn(name = "kdvkodu")
	private KdvTypeModel kdvtypemodel;
	
	@OneToOne
	@JoinColumn(name = "tipkodu")
	private StockTypeModel stocktypemodel;
	
	
	
	public StockCard() {
		
	}
	

	public StockCard(int id, String stokKodu, String stokAdi, int stokTipiId, String birimi, String barkodu,
			int kdvTipiId, String aciklama, String olusturmaTarihi) {
		super();
		this.id = id;
		this.stokKodu = stokKodu;
		this.stokAdi = stokAdi;
		this.stokTipi = stokTipiId;
		this.birimi = birimi;
		this.barkodu = barkodu;
		this.kdvTipi = kdvTipiId;
		this.aciklama = aciklama;
		this.olusturmaTarihi = olusturmaTarihi;
	}







	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStokKodu() {
		return stokKodu;
	}

	public void setStokKodu(String stokKodu) {
		this.stokKodu = stokKodu;
	}

	public String getStokAdi() {
		return stokAdi;
	}

	public void setStokAdi(String stokAdi) {
		this.stokAdi = stokAdi;
	}

	

	public String getBirimi() {
		return birimi;
	}

	public void setBirimi(String birimi) {
		this.birimi = birimi;
	}

	public String getBarkodu() {
		return barkodu;
	}

	public void setBarkodu(String barkodu) {
		this.barkodu = barkodu;
	}

	

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public String getOlusturmaTarihi() {
		return olusturmaTarihi;
	}

	public void setOlusturmaTarihi(String olusturmaTarihi) {
		this.olusturmaTarihi = olusturmaTarihi;
	}
	
	
	
	public int getStokTipiId() {
		return stokTipi;
	}



	public void setStokTipiId(int stokTipiId) {
		this.stokTipi = stokTipiId;
	}


	public int getKdvTipiId() {
		return kdvTipi;
	}


	public void setKdvTipiId(int kdvTipiId) {
		this.kdvTipi = kdvTipiId;
	}
	

	public KdvTypeModel getKdvTypeModel() {
		return kdvtypemodel;
	}


	public void setKdvTypeModel(KdvTypeModel kdvtype) {
		this.kdvtypemodel = kdvtype;
	}
	
	

	public StockTypeModel getStokTip() {
		return stocktypemodel;
	}


	public void setStokTip(StockTypeModel stocktype) {
		this.stocktypemodel = stocktype;
	}







	public Object[] getVeriler() {
		

		Object[] veriler = {id,stokKodu,stokAdi,stokTipi,birimi,barkodu,kdvTipi,aciklama,kdvtypemodel.getKdvCode(), kdvtypemodel.getKdvName(), kdvtypemodel.getKdvRate(),stocktypemodel.getStockTypeCode(),stocktypemodel.getStockTypeName(),stocktypemodel.getStockTypeExplanation() };

		return veriler;
	}
/*olusturmaTarihi,
 * 
 * kdvtypemodel.getKdvCode(), kdvtypemodel.getKdvName(), kdvtypemodel.getKdvRate(),stocktypemodel.getStockTypeCode(),stocktypemodel.getStockTypeName(),stocktypemodel.getStockTypeExplanation()
 * 
 * */

	@Override
	public String toString() {
		return "StockCard [id=" + id + ", stokKodu=" + stokKodu + ", stokAdi=" + stokAdi + ", stokTipi=" + stokTipi
				+ ", birimi=" + birimi + ", barkodu=" + barkodu + ", kdvTipi=" + kdvTipi + ", aciklama=" + aciklama
				+ ", olusturmaTarihi=" + olusturmaTarihi + "]";
	}
	
	
	

}
