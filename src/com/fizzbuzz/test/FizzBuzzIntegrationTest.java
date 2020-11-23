package com.fizzbuzz.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fizzbuzz.config.AppConfig;
import com.fizzbuzz.controller.FizzBuzzController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@WebMvcTest(FizzBuzzController.class)
@ContextConfiguration(classes = {AppConfig.class})
public class FizzBuzzIntegrationTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void fizzbuzzEndpointTest_success() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
    String requestJson = ow
        .writeValueAsString(new String[]{"1", "2", "3", "5", "15", "76", "434", "9"});

    MvcResult result = mvc.perform(post("/api/fizzbuzz")
        .contentType(MediaType.APPLICATION_JSON)
        .content(requestJson))
        .andExpect(status().isOk()).andReturn();

    Assert.assertEquals("1 2 alfresco buzz fizzbuzz 76 alfresco fizz",
        result.getResponse().getContentAsString());
  }

  @Test
  public void fizzbuzzEndpointTest_fail() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
    String requestJson = ow
        .writeValueAsString(new String[]{"1", "2", "3", "String", "434", "9"});

    mvc.perform(post("/api/fizzbuzz")
        .contentType(MediaType.APPLICATION_JSON)
        .content(requestJson))
        .andExpect(status().isUnprocessableEntity());
  }
}
