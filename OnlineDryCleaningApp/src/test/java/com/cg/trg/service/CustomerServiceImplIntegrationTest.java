//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.mockito.internal.verification.VerificationModeFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@ExtendWith(SpringExtension.class)
//class CustomerServiceImplIntegrationTest {
//
//	@TestConfiguration
//	static class CustomerServiceImplTestContextConfiguration {
//		@Bean
//		public CustomerService customerService() {
//			return new CustomerServiceImpl();
//		}
//	}
//
//@Autowired
//	private CustomerService customerService;
//	
//@MockBean
//	private ICustomerRepositoryDao customerDao;
//
//@BeforeEach
//	public void setUp() {
//		Customer customer1= new Customer("Mann","mann@gmail.com,845721459L);
//		note1.setCustomerId(11L);
//
//		Customer customer2= new Customer("Manan","manan@gmail.com,84511459L);
//		Customer customer3= new Customer("Mani","mani@gmail.com,84572000012L);
//
//
//		List<Customer> customerList = Arrays.asList(customer1,customer2,customer3);
//
//		Mockito.when(customerDao.findByCustomerName(customer1.getCustomerName()))
//		.thenReturn((customer1);
//
//		Mockito.when(customerDao.findByEmailId("wrong_email")).thenReturn(null);
//		Mockito.when(customerDao.findByEmailId(customer1.getEmailId())).thenReturn(Optional.of((customer1));
//		Mockito.when(customerDao.findAll()).thenReturn(customerList);
//		Mockito.when(customerDao.findByCustomerId(-99L)).thenReturn(Optional.empty());
//	}
//
//
//
//@Test
//	public void whenValidId_thenCustomerShouldBeFound() {
//		Customer fromDb;
//		try {
//			fromDb = customerService.findByCustomerId(11L);
//			assertThat(fromDb.getCustomerName()).isEqualTo("param");
//			verifyFindByIdIsCalledOnce();
//		} catch (CustomerException e) {			
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void whenInValidId_thenCustomerShouldNotBeFound() {
//		Customer fromDb;
//		try {
//			fromDb = customerServicee.findByCustomerId(-99L);
//			verifyFindByIdIsCalledOnce();
//			assertThat(fromDb).isNull();
//		} catch (CustomerException e) {			
//			e.printStackTrace();
//		}
//		
//	}
//	
//
//	private void verifyFindByIdIsCalledOnce() {
//		Mockito.verify(customerDaoy, VerificationModeFactory.times(1)).findByCustomerId(Mockito.anyLong());
//		Mockito.reset(CustomereRepository);
//	}
//
//	
//
//}
