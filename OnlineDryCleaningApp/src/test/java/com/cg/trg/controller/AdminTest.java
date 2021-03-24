//package com.sapient.training.app;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.cg.trg.Enum.ServiceType;
//import com.cg.trg.dao.IItemChargesRepositoryDao;
//import com.cg.trg.entity.ItemCharges;
//import com.cg.trg.service.IItemChargesService;
//
//@SpringBootTest
//public class AdminTest {
//
//	@Mock
//	IItemChargesService itemChargesService;
//    
//    @Mock
//    IItemChargesRepositoryDao iChargesDAO;
//    
//
//@Test
//	void testAddItemCharges()  {
//	ItemCharges icharges=new ItemCharges(100.0,"shirts",ServiceType.PRESS);
//	itemChargesService.addItemCharges(icharges);
//		
//		verify(itemChargesService, times(1)).addItemCharges(icharges);
//	}
//	
//
//  @Test
//    void testRemoveItemCharges() {
//    	ItemCharges icharges=new ItemCharges(100,"shirts","WASHING");
//    	itemChargesService.addItemCharges(icharges);
//    	
//    	itemChargesService.deleteById(2L);
//    	
//    	verify(itemChargesService, times(1)).addItemCharges(icharges);
//    	verify(itemChargesService, times(1)).deleteItemCharges(2L);)
//    }
//    
//	}
//    
//    @Test
//    void testUpdateItemCharges() {
//    	ItemCharges icharges=new ItemCharges(100,"pants","WASHING");
//    	itemChargesService.updateItemCategory(icharges);
// 
//  		
//    	itemChargesService.updateItemCharges(150,"pants","WASHING");
//		
//		verify(itemChargesService, times(1)).updateItemCharges(icharges);
//	}
//    }
//
//
//
//
//
//}
// 
// 
// 
// 
