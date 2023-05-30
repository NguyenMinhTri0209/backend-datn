package com.patientmanagement.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.patientmanagement.dto.TienWrapper;
import com.patientmanagement.model.Insurance;
import com.patientmanagement.model.Medicine;
import com.patientmanagement.model.Patient;
import com.patientmanagement.model.Prescription;
import com.patientmanagement.model.Prescriptiondtl;
import com.patientmanagement.model.Service;
import com.patientmanagement.model.ServiceDtlBill;
import com.patientmanagement.model.Test;
import com.patientmanagement.model.TestDtl;
import com.patientmanagement.model.TofInsurance;
import com.patientmanagement.model.TofService;
import com.patientmanagement.repository.InsuranceRepository;
import com.patientmanagement.repository.MedicineRepository;
import com.patientmanagement.repository.PatientRepository;
import com.patientmanagement.repository.PrescriptionDtlRepository;
import com.patientmanagement.repository.PrescriptionRepository;
import com.patientmanagement.repository.ServiceDtlBillRepository;
import com.patientmanagement.repository.ServiceRepository;
import com.patientmanagement.repository.StaffRepository;
import com.patientmanagement.repository.TestDtlRepository;
import com.patientmanagement.repository.TestRepository;
import com.patientmanagement.repository.TofInsuranceRepository;
import com.patientmanagement.repository.TofServiceRepository;
import com.patientmanagement.service.ITestDtlService;

@org.springframework.stereotype.Service
public class TestDtlService implements ITestDtlService{

	@Autowired
	private TestDtlRepository testDtlRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private StaffRepository repository;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
	private ServiceDtlBillRepository serviceDtlBillRepository;
	
	@Autowired
	private TofServiceRepository tofServiceRepository;
	
	@Autowired
	private InsuranceRepository insuranceRepository;
	
	@Autowired
	private TofInsuranceRepository tofInsuranceRepository;
	
	@Autowired
	private TestRepository testRepository;

	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	@Autowired
	private PrescriptionDtlRepository prescriptionDtlRepository;
	
	@Autowired
	private MedicineRepository medicineRepository;
	
	//get all
	@Override
	public List<TestDtl> getAllTestDtl() {
		List<TestDtl> TestDtl = testDtlRepository.findAll();
		if(TestDtl.size() == 0)
			return null;
		else
			return TestDtl;
	}

	//get by id
	@Override
	public TestDtl getById(String id) {
		Optional<TestDtl> TestDtl = testDtlRepository.findById(id);
		if(TestDtl.isPresent())
			return TestDtl.get();
		else
			return null;
	}

	//save
	@Override
	public TestDtl save(TestDtl TestDtl) {
		if(TestDtl != null) {
			return testDtlRepository.save(TestDtl);
		}
		return null;
	}

	//update
	@Override
	public TestDtl updateTestDtl(String id, TestDtl TestDtl) {
		if(TestDtl != null) {
			Optional<TestDtl> TestDtlTemp = testDtlRepository.findById(id);
			if(TestDtlTemp.isPresent()) {
				TestDtlTemp.get().setTenxn(TestDtl.getTenxn());
				TestDtlTemp.get().setDongia(TestDtl.getDongia());
				return testDtlRepository.save(TestDtlTemp.get());
			}
		}
		return null;
	}

	//delete
	@Override
	public boolean deleteTestDtl(String id) {
		Optional<TestDtl> TestDtl = testDtlRepository.findById(id);
		if(TestDtl.isPresent()) {
			testDtlRepository.delete(TestDtl.get());
			return true;
		}
		return false;
	}

	@Override
	public List<TestDtl> getalldvsd(String id) {
		
		List<ServiceDtlBill> serviceDtlBills = serviceDtlBillRepository.findAll();
		//lay ma bao hiem ma loai bao hiem
		
		Optional<Patient> optionalPTent = patientRepository.findById(id);
		
		Optional<Insurance> optionalIn = insuranceRepository.findById(optionalPTent.get().getMabh());
		
		
		List<TofInsurance> insurances = tofInsuranceRepository.findAll();
		TofInsurance mabh = new TofInsurance();
		
		for(TofInsurance tof : insurances) {
			if(optionalIn.get().getMaloaibh().compareTo(tof.getMaloaibh())==0) {
				mabh = tof;
				break;
			}
		}
		
		//list ds dich vu bn su ding
		
		List<Service> listService = serviceRepository.findAll();
		List<Service> dvbnsd = new ArrayList<>();
		for(Service s : listService) {
			if(s.getMabn().compareTo(id)==0) {
				dvbnsd.add(s);
			}
		}
		
		List<ServiceDtlBill> serviceCustom = new ArrayList();
		
		for(Service s : dvbnsd) {
			for(ServiceDtlBill sr : serviceDtlBills) {
				if(s.getMadvkham().compareTo(sr.getMadvkham()) == 0) {
					serviceCustom.add(sr);
				}
			}
		}
		
		// tinh tien dich vu benh nhan dang su dung
		
		List<TofService> listTofService = tofServiceRepository.findAll();
		List<TofService> listTofCustor = new ArrayList();
		
		for(ServiceDtlBill sr : serviceCustom) {
			for(TofService tof : listTofService) {
				if(sr.getMadv().compareTo(tof.getMadv())==0) {
					listTofCustor.add(tof);
				}
			}
		}
		
		long tiendv = 0;
		
		for(ServiceDtlBill sr : serviceCustom) {
			for(TofService tof : listTofCustor) {
				if(sr.getMadv().compareTo(tof.getMadv())==0) {
					if(tof.isApdungmh() == true) {
						tiendv = tiendv + ((tof.getDongia() - (long)( tof.getDongia() * mabh.getMuchuong() / 100 ))*sr.getSoluong());
					}
					else
					{
						tiendv = tiendv + tof.getDongia();
					}
				}
			}
		}
		
		//tính tiền phiếu xét nghiệm
		List<Test> optionalTes = testRepository.findAll();
		List<Test> textcs = new ArrayList();
		for(Test ts : optionalTes) {
			if(ts.getMabn().compareTo(id) == 0) {
				textcs.add(ts);
			}
		}
		
		List<TestDtl> listDtl = testDtlRepository.findAll();
		List<TestDtl> listDtlcs = new ArrayList();
		
		for(Test ts : textcs) {
			for(TestDtl tsd : listDtl) {
				if(ts.getMaloaixn().compareTo(tsd.getMaloaixn())==0) {
					listDtlcs.add(tsd);
				}
			}
		}
		
		long tienxn = 0;
		for(TestDtl tsd : listDtlcs) {
			tienxn += tsd.getDongia();
		}
		
		//tính tiền phiếu thuốc
		
		List<Prescription> listPre = prescriptionRepository.findAll();
		List<Prescription> listPreCs = new ArrayList<>();

		for(Prescription pr : listPre) {
			if(pr.getMabn().compareTo(id)==0) {
				listPreCs.add(pr);
			}
		}
		
		List<Prescriptiondtl> listPreDtl = prescriptionDtlRepository.findAll();
		List<Prescriptiondtl> listPreDtlcs = new ArrayList();
		
		for(Prescription pr : listPreCs) {
			for(Prescriptiondtl prdt : listPreDtl) {
				if(pr.getMaphieuthuoc().compareTo(prdt.getMaphieuthuoc())==0) {
					listPreDtlcs.add(prdt);
				}
			}
		}
		
		List<Medicine> listMe = medicineRepository.findAll();
		
		long tienThuoc = 0;
		for(Prescriptiondtl prdt : listPreDtlcs) {
			for(Medicine me : listMe) {
				if(prdt.getMathuoc().compareTo(me.getMathuoc())==0) {
					tienThuoc = tienThuoc + (me.getDongia() * prdt.getSoluong());
				}
			}
		}
	
		return listDtlcs;
	}

}
