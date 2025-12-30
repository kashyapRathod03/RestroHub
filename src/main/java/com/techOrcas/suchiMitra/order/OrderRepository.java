package com.techOrcas.suchiMitra.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByTable_TableId(Long tableId);

    List<Order> findByBranch_BranchId(Long branchId);

    List<Order> findByStatus(boolean status);
}
