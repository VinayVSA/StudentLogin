package com.cg.in.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.in.Repository.UserRepository;
import com.cg.in.entity.User;

import java.util.ArrayList;

@Service
@Primary
public class StudentUserDetailsService implements UserDetailsService {

	 @Autowired
	    private UserRepository userRepository;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        User user = userRepository.findByUsername(username)
	            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
	        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
	    }
}

