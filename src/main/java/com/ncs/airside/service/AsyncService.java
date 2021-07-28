package com.ncs.airside.service;

import com.ncs.airside.model.database.Transponder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

	private static Logger log = LoggerFactory.getLogger(AsyncService.class);

	@Value("${hostnameUrl}")
	private String hostnameUrl;

	@Async("asyncExecutor")
	public void startAsyncAntennaRead() throws InterruptedException
	{
		log.info("Async Antenna Start Reading");
		new RestTemplate().getForEntity("http://"+hostnameUrl+":8080/AntennaRead", null);

	}
}
