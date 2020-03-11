package com.futurice.date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getDifference_whenValidInput_returnsSuccessResponseWithDifference() throws Exception {
        mockMvc.perform(get("/difference?date1=2016-01-23&date2=2010-10-20"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("{\"result\":3,\"error\":false}"));
    }

    @Test
    void getDifference_whenIncorrectDateFormat_returnsErrorResponse() throws Exception {
        mockMvc.perform(get("/difference?date1=2016-01-23&date2=2010-10-2011111111"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("{\"error\":true,\"message\":\"Please provide date as YYYY-MM-DD\"}"));
    }

    @Test
    void getDifference_whenTextInDate_returnsErrorResponse() throws Exception {
        mockMvc.perform(get("/difference?date1=xxxxxx&date2=2010-10-2011111111"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("{\"error\":true,\"message\":\"Please provide date as YYYY-MM-DD\"}"));
    }

    @Test
    void getDifference_whenMissingField_returnsErrorResponse() throws Exception {
        mockMvc.perform(get("/difference?date2=2010-10-2011"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("{\"error\":true,\"message\":\"Required LocalDate parameter 'date1' is not present\"}"));
    }

    @Test
    void getDifference_whenAnyOtherEndpoint_returnsErrorResponse() throws Exception {
        mockMvc.perform(get("/anyother"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("{\"error\":true,\"message\":\"No handler found for GET /anyother\"}"));
    }

    @Test
    void getDifference_whenRootEndpoint_returnsErrorResponse() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("{\"error\":true,\"message\":\"No handler found for GET /\"}"));
    }
}