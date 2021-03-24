//package com.cg.trg.service;
//
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
//
//
//@ExtendWith(SpringExtension.class)
//class IFeedbackServiceImpTest {
//
//	@TestConfiguration
//	static class IFeedbackServiceImpTestContextConfiguration {
//		@Bean
//		public IFeedbackService feedbackService() {
//			return new IFeedbackServiceImp();
//		}
//	}
//
//	@Autowired
//	private IFeedbackServicee feedbackService;
//	@MockBean
//	private IFeedbackRepositoryDao feedbackRepositoryDao;
//
//	@BeforeEach
//	public void setUp() {
//		Feedback feedback1= new Feedback(2,maan@abc,3,good);
//		feedback1.setBookingId(11L);
//
//		Feedback feedback2= new Feedback(5,manan@abc,4,good);
//		Feedback feedback3= new Feedback(2,pavan@abc,5,v.good);
//
//
//		List<Feedback> allFeedback = Arrays.asList(feedback1,feedback2,feedback3);
//
//		Mockito.when(feedbackRepositoryDao.getFeedback(feedback1.getRating()))
//		.thenReturn(allFeedback);
//
//		Mockito.when(feedbackRepositoryDao.getFeedback("wrong_bookingId")).thenReturn(null);
//		Mockito.when(feedbackRepositoryDao.getFeedback(feedback1.getFeedbackNumber())).thenReturn(Optional.of(feedback1));
//		Mockito.when(feedbackRepositoryDao.getAllFeedback()).thenReturn(allfeedback);
//		Mockito.when(feedbackRepositoryDao.getFeedback(-99L)).thenReturn(Optional.empty());
//	}
//
//
//	@Test
//	public void whenValidFeedbackNumber_thenFeedbackShouldBeFound() {
//		Feedback fromDb;
//		try {
//			fromDb = feedbackService.getFeedback(11L);
//			assertThat(fromDb.getRating()).isEqualTo("4");
//			verifyFindByFeedbackNumberIsCalledOnce();
//		} catch (FeedbackException e) {			
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void whenInValidFeedbackNumbe_thenFeedbacShouldNotBeFound() {
//		Feedback fromDb;
//		try {
//			fromDb = feedbackService.getFeedback(-99L);
//			verifyFindByFeedbackNumberIsCalledOnce();
//			assertThat(fromDb).isNull();
//		} catch (FeedbackException e) {			
//			e.printStackTrace();
//		}
//		
//	}
//	
//
//	private void verifyFindByFeedbackNumberIsCalledOnce(){
//		Mockito.verify(feedbackRepositoryDao, VerificationModeFactory.times(1)).getFeedback(Mockito.anyLong());
//		Mockito.reset(feedbackRepository);
//	}
//
//	
//
//}
