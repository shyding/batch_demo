/**
 * 
 */
package com.liquid.apw.demo.batch.orm.vo;

import com.liquid.apw.demo.batch.beans.InvoiceCertification;

/**
 * @author Liquid
 *
 */
public class InvoiceCertificationVO extends InvoiceCertification {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8423694777161206408L;

	private Integer _skiprows;
	
	private Integer _pagesize;
	
	private String orderType;
	
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

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
}
