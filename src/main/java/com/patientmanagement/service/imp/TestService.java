package com.patientmanagement.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientmanagement.model.Test;
import com.patientmanagement.repository.TestRepository;
import com.patientmanagement.service.ITestService;

@Service
public class TestService implements ITestService{

	@Autowired
	private TestRepository testRepository; 
	
	@Override
	public List<Test> getAllTest() {
		List<Test> Test = testRepository.findAll();
		if(Test.size() == 0)
			return null;
		else
			return Test;
	}

	@Override
	public Test getById(String id) {
		Optional<Test> Test = testRepository.findById(id);
		if(Test.isPresent())
			return Test.get();
		else
			return null;
	}

	@Override
	public Test save(Test Test) {
		if(Test != null) {
			return testRepository.save(Test);
		}
		return null;
	}

	@Override
	public Test updateTest(String id, Test Test) {
		if(Test != null) {
			Optional<Test> TestTemp = testRepository.findById(id);
			if(TestTemp.isPresent()) {
				TestTemp.get().setMaloaixn(Test.getMaloaixn());
				TestTemp.get().setMabn(Test.getMabn());
				TestTemp.get().setNgayxn(Test.getNgayxn());
				TestTemp.get().setKquaxn(Test.getKquaxn());
				TestTemp.get().setLydoxn(Test.getLydoxn());
				return testRepository.save(TestTemp.get());
			}
		}
		return null;
	}

	@Override
	public boolean deleteTest(String id) {
		Optional<Test> Test = testRepository.findById(id);
		if(Test.isPresent()) {
			testRepository.delete(Test.get());
			return true;
		}
		return false;
	}
	
}
