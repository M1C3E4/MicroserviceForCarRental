package com.example.microserviceforcarrental.acceptanceTests;

import com.example.microserviceforcarrental.model.CarEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@NoArgsConstructor
public class AcceptanceTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("https://localhost:9090/findById/{id} -> 200")
    public void shouldReturnCarById() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/findById/1")
                        .contentType("application/json")
                        .param("id", "1"))
                .andDo(print())
                .andExpect(status().isOk());
        CarEntity expected = new CarEntity(1L, "bmw", "x5");
        String jsonAsString = resultActions.andReturn().getResponse().getContentAsString();
        CarEntity carEntity = objectMapper.readValue(jsonAsString, CarEntity.class);
        assertEquals(expected.getId(), carEntity.getId());
        assertEquals(expected.getMark(), carEntity.getMark());
        assertEquals(expected.getModel(), carEntity.getModel());
    }

    @Test
    void methodSecond() {
        fail();
    }

}