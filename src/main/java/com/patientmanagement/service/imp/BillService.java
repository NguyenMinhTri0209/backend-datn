package com.patientmanagement.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.patientmanagement.controller.ServiceBillDtlController;
import com.patientmanagement.dto.BillAndPatient;
import com.patientmanagement.dto.TienWrapper;
import com.patientmanagement.model.Bill;
import com.patientmanagement.model.Insurance;
import com.patientmanagement.model.Medicine;
import com.patientmanagement.model.Patient;
import com.patientmanagement.model.Prescription;
import com.patientmanagement.model.Prescriptiondtl;
import com.patientmanagement.model.Service;
import com.patientmanagement.model.ServiceDtlBill;
import com.patientmanagement.model.Staff;
import com.patientmanagement.model.Test;
import com.patientmanagement.model.TestDtl;
import com.patientmanagement.model.TofInsurance;
import com.patientmanagement.model.TofService;
import com.patientmanagement.repository.BillRepository;
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
import com.patientmanagement.service.IBillService;

@org.springframework.stereotype.Service
public class BillService implements IBillService{

	@Autowired
	private BillRepository billRepository;
	
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
	private TestDtlRepository testDtlRepository;
	
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	@Autowired
	private PrescriptionDtlRepository prescriptionDtlRepository;
	
	@Autowired
	private MedicineRepository medicineRepository;
	
	@Override
	public List<Bill> getAllBill() {
		List<Bill> Bill = billRepository.findAll();
		if(Bill.size() == 0)
			return null;
		else
			return Bill;
	}

	@Override
	public Bill getById(String id) {
		Optional<Bill> Bill = billRepository.findById(id);
		if(Bill.isPresent())
			return Bill.get();
		else
			return null;
	}

	@Override
	public Bill save(Bill Bill) {
		if(Bill != null) {
			return billRepository.save(Bill);
		}
		return null;
	}

	@Override
	public Bill updateBill(String id, Bill Bill) {
		if(Bill != null) {
			Optional<Bill> billTemp = billRepository.findById(id);
			if(billTemp.isPresent()) {
				billTemp.get().setManv(Bill.getManv());
				billTemp.get().setMabn(Bill.getMabn());
				billTemp.get().setNgaythanhtoan(Bill.getNgaythanhtoan());
				billTemp.get().setGiamgia(Bill.getGiamgia());
				billTemp.get().setHinhthuctt(Bill.getHinhthuctt());
				billTemp.get().setTinhtrang(Bill.isTinhtrang());
				return billRepository.save(billTemp.get());
			}
		}
		return null;
	}

	@Override
	public boolean deleteBill(String id) {
		Optional<Bill> Bill = billRepository.findById(id);
		if(Bill.isPresent()) {
			billRepository.delete(Bill.get());
			return true;
		}
		return false;
	}

	@Override
	public List<BillAndPatient> findAllBAP() {
		List<BillAndPatient> result = new ArrayList();
		List<Bill> Bill = billRepository.findAll();
		List<Patient> Paients = patientRepository.findAll();
		List<Staff> Staff = repository.findAll();
		
		for(Bill b : Bill) {
			if(b.isTinhtrang() == false) {
				BillAndPatient temp = new BillAndPatient();
				temp.setMabienlai(b.getMabienlai());
				temp.setManv(b.getManv());
				temp.setMabn(b.getMabn());
				temp.setNgaythanhtoan(b.getNgaythanhtoan());
				temp.setGiamgia(b.getGiamgia());
				temp.setHinhthuctt(b.getHinhthuctt());
				temp.setTinhtrang(b.isTinhtrang());
				result.add(temp);
			}
		}
		
		for(BillAndPatient b : result) {
			for(Patient p : Paients) {
				if(b.getMabn().compareTo(p.getMabn())==0) {
					b.setTenbn(p.getTen());
					b.setMabh(p.getMabh());
				}
					
			}
		}
		
		for(BillAndPatient b : result) {
			for(Staff p : Staff) {
				if(b.getManv().compareTo(p.getManv())==0)
					b.setTennv(p.getTen());
			}
		}
		
		return result;
	}

	
	@Override
	public TienWrapper checkBill(String id) {
		
//		Optional<Service> listService = serviceRepository.findById(id);
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
		long tiendvcg = 0;
		long tienbh = 0;
		
		for(ServiceDtlBill sr : serviceCustom) {
			for(TofService tof : listTofCustor) {
				if(sr.getMadv().compareTo(tof.getMadv())==0) {
					if(tof.isApdungmh() == true) {
						tienbh = tienbh + (long)(tof.getDongia() * mabh.getMuchuong() / 100);
						tiendv = tiendv + tienbh*sr.getSoluong();
					}
					else
					{
						tiendv = tiendv + tof.getDongia();
					}
					tiendvcg = tiendvcg + tof.getDongia();
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
		
//		//dv bn su dung
//		result.add(listService);
//		result.add(serviceCustom);
//		result.add(listTofCustor);
//		
//		//lay ma loai bh
//		result.add(optionalIn);
//		result.add(mabh);
		
		//in tien
		TienWrapper tiendvWrapper = new TienWrapper(tiendv, tienxn, tienThuoc, tiendvcg, tienbh);
		
//		//xn
//		result.add(textcs);
//		result.add(listDtlcs);
//		
//		//thuoc
//		result.add(listPreCs);
//		result.add(listPreDtlcs);
		
		return tiendvWrapper;
		
	}

	@Override
	public Bill xacnhan(String id) {
		Optional<Bill> b = billRepository.findById(id);
		if(b.isPresent()) {
			b.get().setTinhtrang(true);
			billRepository.save(b.get());
		}
		return b.get();
	}

	@Override
	public List<BillAndPatient> findAllBAPCN() {
		List<BillAndPatient> result = new ArrayList();
		List<Bill> Bill = billRepository.findAll();
		List<Patient> Paients = patientRepository.findAll();
		List<Staff> Staff = repository.findAll();
		
		for(Bill b : Bill) {
			if(b.isTinhtrang() == true) {
				BillAndPatient temp = new BillAndPatient();
				temp.setMabienlai(b.getMabienlai());
				temp.setManv(b.getManv());
				temp.setMabn(b.getMabn());
				temp.setNgaythanhtoan(b.getNgaythanhtoan());
				temp.setGiamgia(b.getGiamgia());
				temp.setHinhthuctt(b.getHinhthuctt());
				temp.setTinhtrang(b.isTinhtrang());
				result.add(temp);
			}
		}
		
		for(BillAndPatient b : result) {
			for(Patient p : Paients) {
				if(b.getMabn().compareTo(p.getMabn())==0) {
					b.setTenbn(p.getTen());
					b.setMabh(p.getMabh());
				}
					
			}
		}
		
		for(BillAndPatient b : result) {
			for(Staff p : Staff) {
				if(b.getManv().compareTo(p.getManv())==0)
					b.setTennv(p.getTen());
			}
		}
		
		return result;
	}
	
	
}
