package com.techOrcas.suchiMitra.order;

import jakarta.persistence.*;
import java.sql.Date;

import com.techOrcas.suchiMitra.restaurant.Branch;

@Entity
@Table(name = "t_order_master")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long orderId;

    // Unidirectional OneToOne
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    // Many orders → One table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id", nullable = false)
    private TableMaster table;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "total_amount")
    private long totalAmount;

    @Column(name = "status")
    private boolean status; // true = paid, false = unpaid

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public TableMaster getTable() {
		return table;
	}

	public void setTable(TableMaster table) {
		this.table = table;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
