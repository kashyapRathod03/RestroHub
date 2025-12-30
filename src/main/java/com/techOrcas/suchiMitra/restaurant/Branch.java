package com.techOrcas.suchiMitra.restaurant;

import java.util.List;

import com.techOrcas.suchiMitra.menu.Menu;
import com.techOrcas.suchiMitra.order.TableMaster;

import jakarta.persistence.*;

@Entity
@Table(name = "t_branch_master")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private long branchId;

    @Column(name = "branch_name", nullable = false)
    private String branchName;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    private Address branchAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rest_id", nullable = false)
    private Restaurant restaurant;
    
    @OneToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
    
    @OneToMany(mappedBy = "branch", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TableMaster> tables;

	public long getBranchId() {
		return branchId;
	}

	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Address getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(Address branchAddress) {
		this.branchAddress = branchAddress;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<TableMaster> getTables() {
		return tables;
	}

	public void setTables(List<TableMaster> tables) {
		this.tables = tables;
	}
}
