package com.liquid.apw.demo.batch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.listener.ChunkListenerSupport;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InvoiceCertificationChunkCompletionNotificationListener extends ChunkListenerSupport {

	private static final Logger log = LoggerFactory.getLogger(InvoiceCertificationChunkCompletionNotificationListener.class);

	@Autowired
	public InvoiceCertificationChunkCompletionNotificationListener() {
	}
	
	private long startMillisTime;
	
	@Override
	public void beforeChunk(ChunkContext chunkContext) {
		startMillisTime = System.currentTimeMillis();
	}

	@Override
	public void afterChunk(ChunkContext chunkContext) {
		long intervalTime = System.currentTimeMillis() - startMillisTime;
		log.info("Liquid : Chunk last time is " + intervalTime + " milliseconds");
		if(chunkContext.isComplete()) {
			log.info("!!! Chunck FINISHED! Time to verify the results");

//			List<InvoiceCertification> results = mapper.selectByCondition(new InvoiceCertification());
//
//			for (InvoiceCertification certification : results) {
//				log.info("Found <" + certification + "> in the database.");
//			}

		}
	}
}
