package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Mentor;
import com.example.demo.model.Payment;
import com.example.demo.model.Role;
import com.example.demo.model.Technology;
import com.example.demo.model.User;
import com.example.demo.model.UserBlock;
import com.example.demo.model.UserDetails;
import com.example.demo.repository.MentorRepository;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.TechnologyRepository;
import com.example.demo.repository.UserBlockRepository;
import com.example.demo.repository.UserDetailsRepository;
import com.example.demo.repository.UserRepository;


@Service
public class AdminServices {
	@Autowired
	private MentorRepository mentorRepository;
	@Autowired
    private PaymentRepository paymentRepository;
	@Autowired
   private RoleRepository roleRepository;
	@Autowired
private TechnologyRepository technologyRepository;
	@Autowired
private UserDetailsRepository userDetailsRepository;
	@Autowired
private UserRepository userRepository;
	@Autowired
	private UserBlockRepository userBlockRepository;
	 public List<Technology> findTechnology(){
		 return (List<Technology>) technologyRepository.findAll();
		 
	 }
	 public List<Payment> findPayment(){
		 return (List<Payment>) paymentRepository.findAll();
		 
	 }
	 public List<UserDetails> findUser(){
		 return (List<UserDetails>) userDetailsRepository.findAll();
		 
	 }
	 public List<Mentor> findMentor(){
		 return (List<Mentor>) mentorRepository.findAll();
		 
	 }
	public void savetechnology(Technology t) {
	technologyRepository.save(t);
	}
	@Transactional
	public void userBlock(String username) {
		User u=userRepository.findByUsername(username);
		UserBlock ub=new UserBlock();
		ub.setUsername(u.getUsername());
		ub.setPassword(u.getPassword());
		ub.setRole(u.getRole());
		userBlockRepository.save(ub);
		userRepository.deleteByUsername(username);
		
		
	}
	
	
	@Transactional
	public void userUnBlock(String username) {
		
		UserBlock u=userBlockRepository.findByUsername(username);
		User ub=new User();
		ub.setUsername(u.getUsername());
		ub.setPassword(u.getPassword());
		ub.setRole(u.getRole());
		userRepository.save(ub);
		userBlockRepository.deleteByUsername(username);
		
	}


}
