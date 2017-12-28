/**
 * 
 */
package com.huawei.apw.demo.batch.orm.vo;

import com.huawei.apw.demo.batch.beans.SupplierInvoice;

/**
 * @author Liquid
 *
 */
public class SupplierInvoiceVO extends SupplierInvoice {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1747461720191659423L;

	private Integer _skiprows;
	
	private Integer _pagesize;

	public Integer get_skiprows() {
		return _skiprows;
	}

	public void set_skiprows(Integer _skiprows) {
		this._skiprows = _skiprows;
	}

	public Integer get_pagesize() {
		return _pagesize;
	}

	public void set_pagesize(Integer _pagesize) {
		this._pagesize = _pagesize;
	}
	
}
