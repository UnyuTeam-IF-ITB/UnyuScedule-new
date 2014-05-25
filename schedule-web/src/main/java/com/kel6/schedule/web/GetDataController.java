/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.schedule.web;

import com.kel6.schedule.entities.Dosen;
import com.kel6.schedule.entities.KaryaAkhir;
import com.kel6.schedule.entities.Mahasiswa;
import com.kel6.schedule.entities.Periode;
import com.kel6.schedule.entities.Ruangan;
import com.kel6.schedule.entities.Topik;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import service.RepositoryWs;
import tempModel.DosenModel;
import tempModel.KaryaAkhirModel;
import tempModel.MahasiswaModel;
import tempModel.RuanganModel;
import tempModel.TopikModel;

/**
 *
 * @author Esa_Lucu
 */
@Named(value = "getDataController")
@Dependent
public class GetDataController implements Serializable{
    @EJB
    private com.kel6.schedule.session.DosenFacade ejbDosen;
    @EJB
    private com.kel6.schedule.session.MahasiswaFacade ejbMahasiswa;
    @EJB
    private com.kel6.schedule.session.RuanganFacade ejbRuang;
    @EJB
    private com.kel6.schedule.session.KaryaAkhirFacade ejbKA;
    @EJB
    private com.kel6.schedule.session.TopikFacade ejbTopik;
    RepositoryWs repo;
    List<Dosen> listDosenSave = new ArrayList<>();
    List<Mahasiswa> listMhsSave = new ArrayList<>();
    List<KaryaAkhir> listKASave = new ArrayList<>(); 
    List<Ruangan> listRuanganSave = new ArrayList<>();
    List<Topik> listTopikSave = new ArrayList<>();
    List<DosenModel> listDosen;
    List<MahasiswaModel> listMhs;
    List<KaryaAkhirModel> listKA; 
    List<RuanganModel> listRuangan;
    List<TopikModel> listTopik;
    public final static String DEFAULT_URL = "http://localhost/ws-server/index.php";

    	
	protected WebTarget createTarget() {
		Client client = ClientBuilder.newClient().register(repo);		
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
	
	public List<DosenModel> findAllDosen() {
		return find(new GenericType<List<DosenModel>>(){}, 11, null);
        
	}
	
	public List<MahasiswaModel> findAllMahasiswa() {
		return find(new GenericType<List<MahasiswaModel>>(){}, 14, null);
	}
	
//	public List<GedungModel> findAllGedung() {
//		return find(new GenericType<List<GedungModel>>(){}, 17, null);
//	}
	
	public List<TopikModel> findAllTopik() {
		return find(new GenericType<List<TopikModel>>(){}, 20, null);
	}
	
	public List<RuanganModel> findAllRuangan() {
		return find(new GenericType<List<RuanganModel>>(){}, 23, null);
	}
	
	public List<KaryaAkhirModel> findAllKaryaAkhir() {
		return find(new GenericType<List<KaryaAkhirModel>>(){}, 26, null);
	}
    /**
     * Creates a new instance of GetDataSource
     */
    public GetDataController() {
    }
    
    public String insertDataFromServer(){
       // repo = new RepositoryWs();
//        WebResource resource = client.resource(url); 
//        Builder builder = resource.accept(MediaType.APPLICATION_JSON); 
//        GenericType<List<Dosen>> genericType = 
//        new GenericType<List<Dosen>>() {};
        
        
//
//        List<Dosen> response = builder.get(genericType); 
        listDosen = findAllDosen();
        listMhs = findAllMahasiswa();
        listKA = findAllKaryaAkhir();
        listRuangan= findAllRuangan();
        listTopik = findAllTopik();
        return null;
    }
    
    public void save(){
        for(int i=0;i<listDosen.size(); i++){
            Dosen dosen = new Dosen();
            dosen.setNikDosen(listDosen.get(i).getNIP());
            dosen.setNmDosen(listDosen.get(i).getNamaDosen());
            ejbDosen.create(dosen);
        }
        for(int i=0;i<listKA.size();i++){
            KaryaAkhir ka = new KaryaAkhir();
            ka.setIdKa(Long.valueOf(listKA.get(i).getIdKarya()));
            ka.setJudulKa(listKA.get(i).getJudulKarya());
            ejbKA.create(ka);
        }
        for(int i=0; i<listMhs.size(); i++){
            Mahasiswa mhs = new Mahasiswa();
            mhs.setNim(listMhs.get(i).getNIM());
            mhs.setNmMhs(listMhs.get(i).getNamaMhs());
            ejbMahasiswa.create(mhs);
        }
        for(int i=0; i<listRuangan.size(); i++){
            Ruangan ruang = new Ruangan();
            ruang.setIdRuangan(listRuangan.get(i).getIdRuangan());
            ruang.setNmRuangan(listRuangan.get(i).getRuangan());
            ejbRuang.create(ruang);
        }
        for(int i=0; i<listTopik.size(); i++){
            Topik topik = new Topik();
            topik.setIdTopik(Integer.valueOf(listTopik.get(i).getTopik()));
            topik.setNmTopik(listTopik.get(i).getTopik());
            ejbTopik.create(topik);
        }
        
        
    }
    
    
    public List<DosenModel> getListDosen() {
        return listDosen;
    }

    public void setListDosen(List<DosenModel> listDosen) {
        this.listDosen = listDosen;
    }

    public List<MahasiswaModel> getListMhs() {
        return listMhs;
    }

    public void setListMhs(List<MahasiswaModel> listMhs) {
        this.listMhs = listMhs;
    }

    public List<KaryaAkhirModel> getListKA() {
        return listKA;
    }

    public void setListKA(List<KaryaAkhirModel> listKA) {
        this.listKA = listKA;
    }

    public List<RuanganModel> getListRuangan() {
        return listRuangan;
    }

    public void setListRuangan(List<RuanganModel> listRuangan) {
        this.listRuangan = listRuangan;
    }

    public List<TopikModel> getListTopik() {
        return listTopik;
    }

    public void setListTopik(List<TopikModel> listTopik) {
        this.listTopik = listTopik;
    }

    
    
}
