package tempModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RuanganModel {

	private String idRuangan;
	private String Ruangan;
	private String Gedung;

	public String getIdRuangan() {
		return idRuangan;
	}

	public void setIdRuangan(String idRuangan) {
		this.idRuangan = idRuangan;
	}

	public String getRuangan() {
		return Ruangan;
	}

	public void setRuangan(String Ruangan) {
		this.Ruangan = Ruangan;
	}

	public String getGedung() {
		return Gedung;
	}

	public void setGedung(String Gedung) {
		this.Gedung = Gedung;
	}
}
