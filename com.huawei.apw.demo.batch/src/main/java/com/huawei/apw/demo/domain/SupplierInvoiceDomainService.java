/**
 * 
 */
package com.huawei.apw.demo.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huawei.apw.demo.batch.beans.SupplierInvoice;
import com.huawei.apw.demo.batch.orm.dao.SupplierInvoiceMapper;
import com.huawei.apw.demo.batch.orm.vo.SupplierInvoiceVO;

/**
 * @author Liquid
 *
 */
@Component
public class SupplierInvoiceDomainService {

	@Autowired
	private SupplierInvoiceMapper supplierInvoiceMapper;
	
	public void importSupplierInvoice(List<SupplierInvoice> list){
		supplierInvoiceMapper.insertList(list);
	}
	
	
	public List<SupplierInvoice> findSupplierInvoice(SupplierInvoiceVO invoice){
		return supplierInvoiceMapper.selectByCondition(invoice);	
	}


	public int countAll() {
		return supplierInvoiceMapper.selectCountAll();
	}


	public int cleanSupplierInvoice() {
		return supplierInvoiceMapper.deleteAll();
	}
	
}
