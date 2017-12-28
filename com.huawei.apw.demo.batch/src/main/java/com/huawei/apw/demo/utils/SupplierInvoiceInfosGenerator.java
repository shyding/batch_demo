/**
 * 
 */
package com.huawei.apw.demo.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.huawei.apw.demo.batch.beans.SupplierInvoice;

/**
 * @author Liquid
 *
 */
@Component
public class SupplierInvoiceInfosGenerator {
	
	private static final Logger log = LoggerFactory.getLogger(SupplierInvoiceInfosGenerator.class);

	public static List<SupplierInvoice> generate(int invoiceNumbers) {
		int mInvoiceNumber = invoiceNumbers;
		List<SupplierInvoice> result = new ArrayList<SupplierInvoice>();
		while(mInvoiceNumber > 0){
			result.add(generate());
			mInvoiceNumber--;
		}
		return result;
	}

	public static SupplierInvoice generate() {
		SupplierInvoice genObj = new SupplierInvoice();
		Field[] fields = genObj.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			String fieldTypeString = field.getType().getName();
			if (String.class.getName().equals(fieldTypeString)) {
				try {
					field.set(genObj, StringUtils.generateRandomString(15,true));
				} catch (IllegalArgumentException e) {
					log.debug(e.getMessage());
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					log.debug(e.getMessage());
					e.printStackTrace();
				}
			}else if(Date.class.getName().equals(fieldTypeString)){
				try {
					field.set(genObj, new Date());
				} catch (IllegalArgumentException | IllegalAccessException e) {
					log.debug(e.getMessage());
					e.printStackTrace();
				}
			}else if(Double.class.getName().equals(fieldTypeString)){
				try {
					field.set(genObj, Double.valueOf(StringUtils.generateDoubleString()));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					log.debug(e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return genObj;
	}


}
