package com.managementsoftware;

import com.managementsoftware.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * This test class demonstrates an integration test
 * for the ItemController using Spring Boot's testing features.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ItemControllerTest {

    /**
     * MockMvc allows us to simulate HTTP requests
     * without needing a real network environment.
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Test creating a new item via POST and then retrieving it via GET.
     */
    @Test
    void testCreateAndGetItem() throws Exception {
        // JSON representation of a new item
        String newItemJson = "{\"name\":\"Test Item\",\"quantity\":5}";

        // Perform a POST request to create the item
        mockMvc.perform(post("/api/items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newItemJson))
                // Expect HTTP status 200 (OK) or 201 (Created), depending on your controller logic
                .andExpect(status().isOk());

        // Retrieve all items and expect to find the one we just created
        mockMvc.perform(get("/api/items"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                // Optionally, you can verify that the JSON response contains the name "Test Item"
                .andExpect(jsonPath("$[0].name").value("Test Item"));
    }
}