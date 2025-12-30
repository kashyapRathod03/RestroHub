package com.techOrcas.suchiMitra.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TableMasterRepository extends JpaRepository<TableMaster, Long> {

    List<TableMaster> findByBranch_BranchId(Long branchId);

    TableMaster findByTableNumber(Long tableNumber);
}
