package com.techOrcas.suchiMitra.order;

import com.techOrcas.suchiMitra.restaurant.Branch;

import jakarta.persistence.*;

@Entity
@Table(name = "t_table_master")
public class TableMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id")
    private long tableId;

    @Column(name = "table_number", nullable = false, unique = true)
    private long tableNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    @Column(name = "qr_code_url")
    private String qrCodeUrl;

	public long getTableId() {
		return tableId;
	}

	public void setTableId(long tableId) {
		this.tableId = tableId;
	}

	public long getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(long tableNumber) {
		this.tableNumber = tableNumber;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public String getQrCodeUrl() {
		return qrCodeUrl;
	}

	public void setQrCodeUrl(String qrCodeUrl) {
		this.qrCodeUrl = qrCodeUrl;
	}
}
