package m2i.srpingboot.fil.rouge.equipe.filrougeequipe.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.Reservation;

@SpringBootTest
class ReservationServiceTest {
	
	@Autowired
	private ReservationService rvService;
	@Autowired
	private TableResService trService;
	
	@Test
	@Sql("classpath:reservation_insertion.sql")
	void findByRestaurantId_reservationInsertion_ReturnDeuxReservations() {
		List<Reservation> reservations = rvService.findByRestaurantId(3);
		assertEquals(2, reservations.size());
	}
	
	
//	void getFilteredTableRes_reservationInsertion_Return() {
//		Reservation reservation = rvService.getById(1);
//		List<TableRes> tablesRes = trService.findByRestaurantId(3);
//		List<TableRes> tables = rvService.getFilteredTableRes(1);
//		assertEquals(2, tables.size());
//		assertIterableEquals(
//				Arrays.asList(new Integer[] {1, 2, 3, 4, 11, 12}), 
//				tables.stream().map(t -> t.getId()).collect(Collectors.toList())
//				);
//	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
