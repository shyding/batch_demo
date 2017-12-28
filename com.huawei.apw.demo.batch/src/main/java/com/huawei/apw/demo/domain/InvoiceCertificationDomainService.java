/**
 * 
 */
package com.huawei.apw.demo.domain;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huawei.apw.demo.batch.beans.InvoiceCertification;
import com.huawei.apw.demo.batch.beans.SupplierInvoice;
import com.huawei.apw.demo.batch.orm.dao.InvoiceCertificationMapper;
import com.huawei.apw.demo.batch.orm.vo.InvoiceCertificationVO;

/**
 * @author Liquid
 *
 */
@Component
public class InvoiceCertificationDomainService {
	
	private static final Logger log = LoggerFactory.getLogger(InvoiceCertificationDomainService.class);

	@Autowired
	private InvoiceCertificationMapper invoiceCertificationMapper;
	
	/**
	 * 批量插入凭证数据
	 * @param list
	 */
	public void importInvoiceCertifications(List<InvoiceCertification> list){
		invoiceCertificationMapper.insertList(list);
	}
	
	public List<InvoiceCertification> findAll(){
		return invoiceCertificationMapper.selectByCondition(new InvoiceCertificationVO());
	}
	
	/**
	 * 查询最后插入的N条数据
	 * @param number 查询数量
	 * @return
	 */
	public List<InvoiceCertification> findLastCertifications(int number){
		InvoiceCertificationVO certifVO = new InvoiceCertificationVO();
		certifVO.setOrderType("desc");
		certifVO.set_pagesize(number);
		return invoiceCertificationMapper.selectByCondition(certifVO);
	}
	
	/**
	 * 批量生成凭证数据
	 * @param list
	 * @return
	 */
	public List<InvoiceCertification> transfromInvoiceCertification(List<SupplierInvoice> list){
		long startTime = System.currentTimeMillis();
		log.info("Liquid - CurrentTime : " + new Date(startTime));
		List<InvoiceCertification> result = new ArrayList<InvoiceCertification>(list.size());
		for(SupplierInvoice invoice : list){
			result.add(InvoiceBeanFactory.build(invoice));
		}
		long endTime = System.currentTimeMillis();
		log.info("Liquid - EndTime : " + new Date(endTime));
		log.info("Liquid - time consuming ： " + (endTime - startTime) + " millinseconds");
		return result;
	}
	
	
	public static class InvoiceBeanFactory{
		
		public static InvoiceCertification build(SupplierInvoice invoice){
			try {
				Thread.sleep(10); // for test
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			InvoiceCertification certif = new InvoiceCertification();
			Field[] fields = certif.getClass().getDeclaredFields();
			for(Field field : fields){
				field.setAccessible(true);
				Field valueField = null;
				try {
					if("id".equals(field.getName())) continue; 
					valueField = invoice.getClass().getDeclaredField(field.getName());
					if(valueField == null)continue;
					valueField.setAccessible(true);
					field.set(certif, valueField.get(invoice));
				} catch (Exception e) {
//					log.debug(e.getMessage());
//					e.printStackTrace();
					break;
				}
			}
			return certif;
		}
	}
	
	
}
