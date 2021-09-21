package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.services.ElementTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration
public class ElementTypeServiceTest {

    @Autowired
    private ElementTypeService elementTypeService;

    @Test
    public void elementTypeServiceSaveTest() {
        ElementType elementType = new ElementType("ServiceTest");

        // save element, verify it has an ID after save
        assertNull(elementType.getElementTypeId());
        elementTypeService.saveElementType(elementType);
        assertNotNull(elementType.getElementTypeId());

        // fetch
        ElementType fetchedElementType = elementTypeService.getElementTypeById(elementType.getElementTypeId());
        assertNotNull(fetchedElementType);
        assertEquals(elementType.getElementTypeId(), fetchedElementType.getElementTypeId());

        // update
        fetchedElementType.setElementType("Test");
        elementTypeService.saveElementType(fetchedElementType);

        ElementType updatedElementType = elementTypeService.getElementTypeById(fetchedElementType.getElementTypeId());
        assertEquals(updatedElementType.getElementType(), "Test");
    }
}
