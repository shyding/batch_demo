/**
 * 
 */
package com.huawei.apw.demo.application;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huawei.apw.demo.batch.InvoiceCertificationBatchConfiguration;
import com.huawei.apw.demo.batch.beans.InvoiceCertification;
import com.huawei.apw.demo.batch.beans.SupplierInvoice;
import com.huawei.apw.demo.batch.listener.InvoiceCertificationItemWriterListener;
import com.huawei.apw.demo.batch.orm.vo.SupplierInvoiceVO;
import com.huawei.apw.demo.domain.InvoiceCertificationDomainService;
import com.huawei.apw.demo.domain.SupplierInvoiceDomainService;

/**
 * @author Liquid
 *
 */
@RestController
@RequestMapping("/apw")
public class InvoiceCertificationApplication {
	
	private static final Logger log = LoggerFactory.getLogger(InvoiceCertificationApplication.class);
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private SupplierInvoiceDomainService supplierInvoiceDomainService;
	
	@Autowired
	private InvoiceCertificationDomainService invoiceCertificationDomainService;
	
	@Autowired
	private InvoiceCertificationBatchConfiguration batchConfig;
	
	@Autowired
	private InvoiceCertificationItemWriterListener itemListener;
	
	@RequestMapping("/invoice2certif")
	public List<InvoiceCertification> batchProcessInvoiceCertification(@RequestParam("number") int number){
		long startTime = System.currentTimeMillis();
		log.info("Liquid - CurrentTime : " + new Date(startTime));
		// 查询供应商发票
		List<SupplierInvoice> invoiceList = supplierInvoiceDomainService.findSupplierInvoice(new SupplierInvoiceVO());
		// 处理供应商发票
		List<InvoiceCertification> certifList = invoiceCertificationDomainService.transfromInvoiceCertification(invoiceList);
		// 存储预凭证
		invoiceCertificationDomainService.importInvoiceCertifications(certifList);
		long endTime = System.currentTimeMillis();
		log.info("Liquid - EndTime : " + new Date(endTime));
		log.info("Liquid - time consuming ： " + (endTime - startTime) + " millinseconds");
		return invoiceCertificationDomainService.findLastCertifications(certifList.size());
	}
	
	@RequestMapping("/invoice2certif/batch")
	public List<InvoiceCertification> batchProcessInvoiceCertificationByBatch(@RequestParam("number") int number){
		long startTime = System.currentTimeMillis();
		log.info("Liquid - CurrentTime : " + new Date(startTime));
		JobExecution jobExecution = null;
		try {
			jobExecution = jobLauncher.run(batchConfig.invoiceCertificationJob(), new JobParameters());
		} catch (Exception e) {
			log.debug(e.getMessage());
			e.printStackTrace();
		} // 启动job
		long endTime = System.currentTimeMillis();
		log.info("Liquid - EndTime : " + new Date(endTime));
		log.info("Liquid - time consuming ： " + (endTime - startTime) + " millinseconds");
//		Map<String, Object> result = new HashMap<String, Object>();
//		result.put("jobExecutor", jobExecution);
//		result.put("list", invoiceCertificationDomainService.findLastCertifications(itemListener.popupItemCount()));
		return invoiceCertificationDomainService.findLastCertifications(itemListener.popupItemCount());
	}

}
