package com.liquid.apw.demo.batch.orm.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.liquid.apw.demo.batch.beans.InvoiceCertification;

public class InvoiceCertificationSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apw_invoice_certification
     *
     * @mbggenerated
     */
    public String insertSelective(InvoiceCertification record) {
        BEGIN();
        INSERT_INTO("apw_invoice_certification");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getSupplierCompany() != null) {
            VALUES("supplier_company", "#{supplierCompany,jdbcType=VARCHAR}");
        }
        
        if (record.getSupplierSite() != null) {
            VALUES("supplier_site", "#{supplierSite,jdbcType=VARCHAR}");
        }
        
        if (record.getSupplierBankCode() != null) {
            VALUES("supplier_bank_code", "#{supplierBankCode,jdbcType=VARCHAR}");
        }
        
        if (record.getSupplierBankName() != null) {
            VALUES("supplier_bank_name", "#{supplierBankName,jdbcType=VARCHAR}");
        }
        
        if (record.getSupplierExtend1() != null) {
            VALUES("supplier_extend_1", "#{supplierExtend1,jdbcType=VARCHAR}");
        }
        
        if (record.getSupplierExtend2() != null) {
            VALUES("supplier_extend_2", "#{supplierExtend2,jdbcType=VARCHAR}");
        }
        
        if (record.getSupplierExtend3() != null) {
            VALUES("supplier_extend_3", "#{supplierExtend3,jdbcType=VARCHAR}");
        }
        
        if (record.getSupplierExtend4() != null) {
            VALUES("supplier_extend_4", "#{supplierExtend4,jdbcType=VARCHAR}");
        }
        
        if (record.getSupplierExtend5() != null) {
            VALUES("supplier_extend_5", "#{supplierExtend5,jdbcType=VARCHAR}");
        }
        
        if (record.getPoNumber() != null) {
            VALUES("po_number", "#{poNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getPoCompany() != null) {
            VALUES("po_company", "#{poCompany,jdbcType=VARCHAR}");
        }
        
        if (record.getPoDepartment() != null) {
            VALUES("po_department", "#{poDepartment,jdbcType=VARCHAR}");
        }
        
        if (record.getPoPrepaymentPoNumber() != null) {
            VALUES("po_prepayment_po_number", "#{poPrepaymentPoNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getPoExtend1() != null) {
            VALUES("po_extend_1", "#{poExtend1,jdbcType=VARCHAR}");
        }
        
        if (record.getPoExtend2() != null) {
            VALUES("po_extend_2", "#{poExtend2,jdbcType=VARCHAR}");
        }
        
        if (record.getPoExtend3() != null) {
            VALUES("po_extend_3", "#{poExtend3,jdbcType=VARCHAR}");
        }
        
        if (record.getPoExtend4() != null) {
            VALUES("po_extend_4", "#{poExtend4,jdbcType=VARCHAR}");
        }
        
        if (record.getPoExtend5() != null) {
            VALUES("po_extend_5", "#{poExtend5,jdbcType=VARCHAR}");
        }
        
        if (record.getPoExtend6() != null) {
            VALUES("po_extend_6", "#{poExtend6,jdbcType=VARCHAR}");
        }
        
        if (record.getPoExtend7() != null) {
            VALUES("po_extend_7", "#{poExtend7,jdbcType=VARCHAR}");
        }
        
        if (record.getPoExtend8() != null) {
            VALUES("po_extend_8", "#{poExtend8,jdbcType=VARCHAR}");
        }
        
        if (record.getPoExtend9() != null) {
            VALUES("po_extend_9", "#{poExtend9,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceNumber() != null) {
            VALUES("invoice_number", "#{invoiceNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceType() != null) {
            VALUES("invoice_type", "#{invoiceType,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceAmount() != null) {
            VALUES("invoice_amount", "#{invoiceAmount,jdbcType=DOUBLE}");
        }
        
        if (record.getInvoideDateReceived() != null) {
            VALUES("invoide_date_received", "#{invoideDateReceived,jdbcType=DATE}");
        }
        
        if (record.getInvoiceDateExpense() != null) {
            VALUES("invoice_date_expense", "#{invoiceDateExpense,jdbcType=DATE}");
        }
        
        if (record.getInvoiceDateExpenseStart() != null) {
            VALUES("invoice_date_expense_start", "#{invoiceDateExpenseStart,jdbcType=DATE}");
        }
        
        if (record.getInvoiceDateExpensePeriod() != null) {
            VALUES("invoice_date_expense_period", "#{invoiceDateExpensePeriod,jdbcType=DATE}");
        }
        
        if (record.getInvoiceExpenseType() != null) {
            VALUES("invoice_expense_type", "#{invoiceExpenseType,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceFinLocation() != null) {
            VALUES("invoice_fin_location", "#{invoiceFinLocation,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceFinCurrency() != null) {
            VALUES("invoice_fin_currency", "#{invoiceFinCurrency,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceFinCurrencyPayment() != null) {
            VALUES("invoice_fin_currency_payment", "#{invoiceFinCurrencyPayment,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceBasic1() != null) {
            VALUES("invoice_basic_1", "#{invoiceBasic1,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceBasic2() != null) {
            VALUES("invoice_basic_2", "#{invoiceBasic2,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceBasic3() != null) {
            VALUES("invoice_basic_3", "#{invoiceBasic3,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceBasic4() != null) {
            VALUES("invoice_basic_4", "#{invoiceBasic4,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceBasic5() != null) {
            VALUES("invoice_basic_5", "#{invoiceBasic5,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceBasic6() != null) {
            VALUES("invoice_basic_6", "#{invoiceBasic6,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceBasic7() != null) {
            VALUES("invoice_basic_7", "#{invoiceBasic7,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceBasic8() != null) {
            VALUES("invoice_basic_8", "#{invoiceBasic8,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceBasic9() != null) {
            VALUES("invoice_basic_9", "#{invoiceBasic9,jdbcType=VARCHAR}");
        }
        
        if (record.getTaxCode() != null) {
            VALUES("tax_code", "#{taxCode,jdbcType=VARCHAR}");
        }
        
        if (record.getTaxPlace() != null) {
            VALUES("tax_place", "#{taxPlace,jdbcType=VARCHAR}");
        }
        
        if (record.getTaxParty() != null) {
            VALUES("tax_party", "#{taxParty,jdbcType=VARCHAR}");
        }
        
        if (record.getTaxProduct() != null) {
            VALUES("tax_product", "#{taxProduct,jdbcType=VARCHAR}");
        }
        
        if (record.getTaxProcess() != null) {
            VALUES("tax_process", "#{taxProcess,jdbcType=VARCHAR}");
        }
        
        if (record.getTaxAmount() != null) {
            VALUES("tax_amount", "#{taxAmount,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apw_invoice_certification
     *
     * @mbggenerated
     */
    public String updateByPrimaryKeySelective(InvoiceCertification record) {
        BEGIN();
        UPDATE("apw_invoice_certification");
        
        if (record.getSupplierCompany() != null) {
            SET("supplier_company = #{supplierCompany,jdbcType=VARCHAR}");
        }
        
        if (record.getSupplierSite() != null) {
            SET("supplier_site = #{supplierSite,jdbcType=VARCHAR}");
        }
        
        if (record.getSupplierBankCode() != null) {
            SET("supplier_bank_code = #{supplierBankCode,jdbcType=VARCHAR}");
        }
        
        if (record.getSupplierBankName() != null) {
            SET("supplier_bank_name = #{supplierBankName,jdbcType=VARCHAR}");
        }
        
        if (record.getSupplierExtend1() != null) {
            SET("supplier_extend_1 = #{supplierExtend1,jdbcType=VARCHAR}");
        }
        
        if (record.getSupplierExtend2() != null) {
            SET("supplier_extend_2 = #{supplierExtend2,jdbcType=VARCHAR}");
        }
        
        if (record.getSupplierExtend3() != null) {
            SET("supplier_extend_3 = #{supplierExtend3,jdbcType=VARCHAR}");
        }
        
        if (record.getSupplierExtend4() != null) {
            SET("supplier_extend_4 = #{supplierExtend4,jdbcType=VARCHAR}");
        }
        
        if (record.getSupplierExtend5() != null) {
            SET("supplier_extend_5 = #{supplierExtend5,jdbcType=VARCHAR}");
        }
        
        if (record.getPoNumber() != null) {
            SET("po_number = #{poNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getPoCompany() != null) {
            SET("po_company = #{poCompany,jdbcType=VARCHAR}");
        }
        
        if (record.getPoDepartment() != null) {
            SET("po_department = #{poDepartment,jdbcType=VARCHAR}");
        }
        
        if (record.getPoPrepaymentPoNumber() != null) {
            SET("po_prepayment_po_number = #{poPrepaymentPoNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getPoExtend1() != null) {
            SET("po_extend_1 = #{poExtend1,jdbcType=VARCHAR}");
        }
        
        if (record.getPoExtend2() != null) {
            SET("po_extend_2 = #{poExtend2,jdbcType=VARCHAR}");
        }
        
        if (record.getPoExtend3() != null) {
            SET("po_extend_3 = #{poExtend3,jdbcType=VARCHAR}");
        }
        
        if (record.getPoExtend4() != null) {
            SET("po_extend_4 = #{poExtend4,jdbcType=VARCHAR}");
        }
        
        if (record.getPoExtend5() != null) {
            SET("po_extend_5 = #{poExtend5,jdbcType=VARCHAR}");
        }
        
        if (record.getPoExtend6() != null) {
            SET("po_extend_6 = #{poExtend6,jdbcType=VARCHAR}");
        }
        
        if (record.getPoExtend7() != null) {
            SET("po_extend_7 = #{poExtend7,jdbcType=VARCHAR}");
        }
        
        if (record.getPoExtend8() != null) {
            SET("po_extend_8 = #{poExtend8,jdbcType=VARCHAR}");
        }
        
        if (record.getPoExtend9() != null) {
            SET("po_extend_9 = #{poExtend9,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceNumber() != null) {
            SET("invoice_number = #{invoiceNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceType() != null) {
            SET("invoice_type = #{invoiceType,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceAmount() != null) {
            SET("invoice_amount = #{invoiceAmount,jdbcType=DOUBLE}");
        }
        
        if (record.getInvoideDateReceived() != null) {
            SET("invoide_date_received = #{invoideDateReceived,jdbcType=DATE}");
        }
        
        if (record.getInvoiceDateExpense() != null) {
            SET("invoice_date_expense = #{invoiceDateExpense,jdbcType=DATE}");
        }
        
        if (record.getInvoiceDateExpenseStart() != null) {
            SET("invoice_date_expense_start = #{invoiceDateExpenseStart,jdbcType=DATE}");
        }
        
        if (record.getInvoiceDateExpensePeriod() != null) {
            SET("invoice_date_expense_period = #{invoiceDateExpensePeriod,jdbcType=DATE}");
        }
        
        if (record.getInvoiceExpenseType() != null) {
            SET("invoice_expense_type = #{invoiceExpenseType,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceFinLocation() != null) {
            SET("invoice_fin_location = #{invoiceFinLocation,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceFinCurrency() != null) {
            SET("invoice_fin_currency = #{invoiceFinCurrency,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceFinCurrencyPayment() != null) {
            SET("invoice_fin_currency_payment = #{invoiceFinCurrencyPayment,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceBasic1() != null) {
            SET("invoice_basic_1 = #{invoiceBasic1,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceBasic2() != null) {
            SET("invoice_basic_2 = #{invoiceBasic2,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceBasic3() != null) {
            SET("invoice_basic_3 = #{invoiceBasic3,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceBasic4() != null) {
            SET("invoice_basic_4 = #{invoiceBasic4,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceBasic5() != null) {
            SET("invoice_basic_5 = #{invoiceBasic5,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceBasic6() != null) {
            SET("invoice_basic_6 = #{invoiceBasic6,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceBasic7() != null) {
            SET("invoice_basic_7 = #{invoiceBasic7,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceBasic8() != null) {
            SET("invoice_basic_8 = #{invoiceBasic8,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceBasic9() != null) {
            SET("invoice_basic_9 = #{invoiceBasic9,jdbcType=VARCHAR}");
        }
        
        if (record.getTaxCode() != null) {
            SET("tax_code = #{taxCode,jdbcType=VARCHAR}");
        }
        
        if (record.getTaxPlace() != null) {
            SET("tax_place = #{taxPlace,jdbcType=VARCHAR}");
        }
        
        if (record.getTaxParty() != null) {
            SET("tax_party = #{taxParty,jdbcType=VARCHAR}");
        }
        
        if (record.getTaxProduct() != null) {
            SET("tax_product = #{taxProduct,jdbcType=VARCHAR}");
        }
        
        if (record.getTaxProcess() != null) {
            SET("tax_process = #{taxProcess,jdbcType=VARCHAR}");
        }
        
        if (record.getTaxAmount() != null) {
            SET("tax_amount = #{taxAmount,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}