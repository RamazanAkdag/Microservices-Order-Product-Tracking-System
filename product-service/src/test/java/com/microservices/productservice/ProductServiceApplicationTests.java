package com.microservices.productservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.productservice.dataAccess.ProductRepository;
import com.microservices.productservice.dto.ProductRequest;
import com.microservices.productservice.dto.ProductResponse;
import com.microservices.productservice.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.core.type.TypeReference;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.6");
			//.withEnv("MONGO_INITDB_ROOT_USERNAME", "root")
			//.withEnv("MONGO_INITDB_ROOT_PASSWORD", "example");
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ProductRepository productRepository;

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dymDynamicPropertyRegistry){
		dymDynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}

	@Test
	void shouldCreateProduct() throws Exception {
		var productRequest = getProductRequest();
		String productRequestString = objectMapper.writeValueAsString(productRequest);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
				.contentType(MediaType.APPLICATION_JSON)
				.content(productRequestString)
		).andExpect(status().isCreated());

        Assertions.assertEquals(1, productRepository.findAll().size());

	}

	/*@Test
	void shouldGetProducts() throws Exception {
		shouldCreateProduct();
		MvcResult result =  mockMvc.perform(MockMvcRequestBuilders.get("/api/product"))
				.andExpect(status().isOk())
				.andReturn();
		String contentAsString = result.getResponse().getContentAsString();
		//System.out.println(contentAsString);
		ProductResponse[] productArray = objectMapper.readValue(contentAsString, ProductResponse[].class);

		// Java objesini bir liste haline getir
		List<ProductResponse> productList = Arrays.asList(productArray);



		// Listede beklenen eleman sayısını kontrol et
		Assertions.assertEquals(productRepository.findAll().size(), productList.size());

	}*/

	private ProductRequest getProductRequest() {
		return ProductRequest.builder().name("iphone 13")
				.description("iphone 13")
				.price(BigDecimal.valueOf(1200)).build();

	}

}
