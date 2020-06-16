package com.selenium.kibana.kibanaproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;

public class ResultToElasticSearch {

	
	private static final ObjectMapper OBJMAP = new ObjectMapper();
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_TYPE_VALUE = "application/json";
    private static final String ELASTICSEARCH_URL = "http://localhost:9200/app/suite"; 
    
    public static void sendTestResultDetailed(final PojoClass testStatus){
        try {
            Unirest.post(ELASTICSEARCH_URL)
                    .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
                    .body(OBJMAP.writeValueAsString(testStatus)).asJson();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void sendTestSummary(final PojoClass testStatus){
        try {
            Unirest.post(ELASTICSEARCH_URL)
                    .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
                    .body(OBJMAP.writeValueAsString(testStatus)).asJson();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
