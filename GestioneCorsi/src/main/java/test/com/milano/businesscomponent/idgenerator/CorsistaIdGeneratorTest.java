package test.com.milano.businesscomponent.idgenerator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.milano.architecture.dao.DAOException;
import com.milano.businesscomponent.idgenerator.CorsistaIdGenerator;

class CorsistaIdGeneratorTest {

	@Test
	void testGeneratoreId() {
		try {
			CorsistaIdGenerator idGen = CorsistaIdGenerator.getInstance();
			assertNotNull(idGen, "1.01: istanza non generata correttamente");
			long valore = idGen.getNextId();
			assertEquals(valore, idGen.getNextId() -1);
		} catch (DAOException | ClassNotFoundException | IOException e) {
			fail(e.getMessage());
		}
	}

	}
