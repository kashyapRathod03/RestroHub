package com.restrohub.qrmenu.admin.dashboard.service;

import com.restrohub.qrmenu.admin.dashboard.dto.DashboardStatDTO;

import java.util.List;

public interface DashboardService {

    List<DashboardStatDTO> getDashboardStats();
}
