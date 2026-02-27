package com.restroly.qrmenu.admin.dashboard.service;


import com.restroly.qrmenu.admin.dashboard.dto.DashboardStatDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Override
    public List<DashboardStatDTO> getDashboardStats() {

        // 🔥 Later → Replace with DB queries / analytics logic

        return List.of(
                new DashboardStatDTO(
                        "Today's Revenue",
                        "₹45,230",
                        "-24%",
                        false,
                        null,
                        "revenue",
                        "green",
                        null,
                        null
                ),
                new DashboardStatDTO(
                        "Live Orders",
                        "12",
                        null,
                        null,
                        "active",
                        "orders",
                        "orange",
                        true,
                        null
                ),
                new DashboardStatDTO(
                        "WhatsApp Messages",
                        "156/1000",
                        null,
                        null,
                        null,
                        "messages",
                        "emerald",
                        null,
                        15.6
                ),
                new DashboardStatDTO(
                        "UPI Success",
                        "89%",
                        null,
                        null,
                        "(78/89)",
                        "payments",
                        "purple",
                        null,
                        null
                )
        );
    }
}
