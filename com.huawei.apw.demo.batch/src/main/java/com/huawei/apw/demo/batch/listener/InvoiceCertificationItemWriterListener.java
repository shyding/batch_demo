package com.huawei.apw.demo.batch.listener;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

import com.huawei.apw.demo.batch.beans.InvoiceCertification;

@Component
public class InvoiceCertificationItemWriterListener implements ItemWriteListener<InvoiceCertification>{

	private int itemCount = 0;
	
	@Override
	public void beforeWrite(List<? extends InvoiceCertification> items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterWrite(List<? extends InvoiceCertification> items) {
		itemCount+=items.size();
		
	}

	@Override
	public void onWriteError(Exception exception, List<? extends InvoiceCertification> items) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the itemCount
	 */
	public int getItemCount() {
		return itemCount;
	}

	/**
	 * @param itemCount the itemCount to set
	 */
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	
	public int popupItemCount(){
		int count = itemCount;
		itemCount = 0;
		return count;
	}

}
