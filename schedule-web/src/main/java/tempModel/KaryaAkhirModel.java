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
public class KaryaAkhirModel {
	private String idKarya;
	private String judulKarya;
	private String namaMhs;
	private String pembimbing1;
	private String pembimbing2;
	private String penguji1;
	private String penguji2;
	private String ruangan;

	public String getIdKarya() {
		return idKarya;
	}

	public void setIdKarya(String idKarya) {
		this.idKarya = idKarya;
	}

	public String getJudulKarya() {
		return judulKarya;
	}

	public void setJudulKarya(String judulKarya) {
		this.judulKarya = judulKarya;
	}

	public String getNamaMhs() {
		return namaMhs;
	}

	public void setNamaMhs(String namaMhs) {
		this.namaMhs = namaMhs;
	}

	public String getPembimbing1() {
		return pembimbing1;
	}

	public void setPembimbing1(String pembimbing1) {
		this.pembimbing1 = pembimbing1;
	}

	public String getPembimbing2() {
		return pembimbing2;
	}

	public void setPembimbing2(String pembimbing2) {
		this.pembimbing2 = pembimbing2;
	}

	public String getPenguji1() {
		return penguji1;
	}

	public void setPenguji1(String penguji1) {
		this.penguji1 = penguji1;
	}

	public String getPenguji2() {
		return penguji2;
	}

	public void setPenguji2(String penguji2) {
		this.penguji2 = penguji2;
	}

	public String getRuangan() {
		return ruangan;
	}

	public void setRuangan(String ruangan) {
		this.ruangan = ruangan;
	}
	
	
}
