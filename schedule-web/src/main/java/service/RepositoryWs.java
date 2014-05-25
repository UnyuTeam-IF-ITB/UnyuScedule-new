package service;

import com.kel6.schedule.entities.Dosen;
import com.kel6.schedule.entities.KaryaAkhir;
import com.kel6.schedule.entities.Mahasiswa;
import com.kel6.schedule.entities.Ruangan;
import com.kel6.schedule.entities.Topik;
import java.io.Serializable;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Ginan
 */
public class RepositoryWs implements Serializable {
	public final static String DEFAULT_URL = "http://localhost/ws-server/index.php";
	
	protected WebTarget createTarget() {
		Client client = ClientBuilder.newClient();		
		return client.target(DEFAULT_URL);
	}
	
	public <T> T find(GenericType<T> genericType, int ret, String par) {
		if (par == null) {
			par = "";
		}
		return createTarget()
				.queryParam("ret", ret)
				.queryParam("par", par)
				.request()
				.get(genericType);
	}
	
	public <T> T find(Class<T> type, int ret, String par) {
		if (par == null) {
			par = "";
		}
		return createTarget()
				.queryParam("ret", ret)
				.queryParam("par", par)
				.request()
				.get(type);
	}
	
	public List<Dosen> findAllDosen() {
		return find(new GenericType<List<Dosen>>(){}, 11, null);
	}
	
	public List<Mahasiswa> findAllMahasiswa() {
		return find(new GenericType<List<Mahasiswa>>(){}, 14, null);
	}
	
//	public List<GedungModel> findAllGedung() {
//		return find(new GenericType<List<GedungModel>>(){}, 17, null);
//	}
	
	public List<Topik> findAllTopik() {
		return find(new GenericType<List<Topik>>(){}, 20, null);
	}
	
	public List<Ruangan> findAllRuangan() {
		return find(new GenericType<List<Ruangan>>(){}, 23, null);
	}
	
	public List<KaryaAkhir> findAllKaryaAkhir() {
		return find(new GenericType<List<KaryaAkhir>>(){}, 26, null);
	}
}
