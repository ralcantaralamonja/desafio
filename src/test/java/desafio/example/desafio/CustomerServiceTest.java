package desafio.example.desafio;

import desafio.example.desafio.entity.Customer;
import desafio.example.desafio.repository.CustomerRepository;
import desafio.example.desafio.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer createdCustomer = customerService.createCustomer(customer);

        assertEquals(customer, createdCustomer);
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    public void testGetEveryone() {
        List<Customer> customers = new ArrayList<>();
        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> result = customerService.getEveryone();

        assertEquals(customers, result);
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    public void testGetCustomerById() {
        Long customerId = 1L;
        Customer customer = new Customer();
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

        Optional<Customer> result = customerService.getCustomerById(customerId);

        assertEquals(Optional.of(customer), result);
        verify(customerRepository, times(1)).findById(customerId);
    }

    // Add more test methods for other service methods

    @Test
    public void testDeleteCustomer() {
        Long customerId = 1L;

        customerService.deleteCustomer(customerId);

        verify(customerRepository, times(1)).deleteById(customerId);
    }
}
