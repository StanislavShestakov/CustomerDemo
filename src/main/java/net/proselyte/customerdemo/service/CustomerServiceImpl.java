package net.proselyte.customerdemo.service;

import lombok.extern.slf4j.Slf4j;
import net.proselyte.customerdemo.model.Customer;
import net.proselyte.customerdemo.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    Logger log = LoggerFactory.getLogger("SampleLogger");

    @Autowired
    CustomerRepository customerRepository;

    @Override
     public Customer getById(Long id) {
        log.info("IN CustomerService getById {}",id);
        return customerRepository.getOne(id);
    }

    @Override
    public void save(Customer customer) {
        log.info("IN CustomerService save {}", customer);
        customerRepository.save(customer);
    }

    @Override
    public void delete(@PathVariable Long id) {
        log.info("IN CustomerService delete {}",id);
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAll() {
        log.info("IN CustomerService getAll{}");
        return customerRepository.findAll();
    }
}
