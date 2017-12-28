/**
 * 
 */
package com.huawei.apw.demo.application;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huawei.apw.demo.batch.beans.SupplierInvoice;
import com.huawei.apw.demo.domain.SupplierInvoiceDomainService;
import com.huawei.apw.demo.utils.SupplierInvoiceInfosGenerator;

/**
 * @author Liquid
 *
 */
@RestController
@RequestMapping("/supplier")
public class SupplierInvoiceApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SupplierInvoiceApplication.class);
	
	@Autowired
	private SupplierInvoiceDomainService service;
	
	@RequestMapping("/generateImport")
	public List<SupplierInvoice> generateImportSupplierInvoice(@RequestParam("number") int number){
		long startTime = System.currentTimeMillis();
		log.info("Liquid - CurrentTime : " + new Date(startTime));
		List<SupplierInvoice> list = SupplierInvoiceInfosGenerator.generate(number);
		log.info("Liquid generate supplier invoice :");
//		for(SupplierInvoice invoice : list){
//			log.info(invoice.toString());
//		}
		service.importSupplierInvoice(list);
		long endTime = System.currentTimeMillis();
		log.info("Liquid - EndTime : " + new Date(endTime));
		log.info("Liquid - time consuming ： " + (endTime - startTime) + " millinseconds");
		return list;
	}
	
	@RequestMapping("/count")
	public int countSupplierInvoice(){
		return service.countAll();
	}
	
	@RequestMapping("/clean")
	public int cleanSupplierInvoice(){
		return service.cleanSupplierInvoice();
	}
	
}
