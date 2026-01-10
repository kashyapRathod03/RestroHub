package com.restrohub.qrmenu.template.service;

import com.restrohub.qrmenu.template.dto.TemplateCreateRequest;
import com.restrohub.qrmenu.template.dto.TemplateDTO;
import com.restrohub.qrmenu.template.dto.TemplateUpdateRequest;

import java.util.List;

public interface TemplateService {

    TemplateDTO createTemplate(TemplateCreateRequest request);

    TemplateDTO getTemplateById(Long id);

    TemplateDTO getTemplateByKey(String key);

    List<TemplateDTO> getAllTemplates();

    List<TemplateDTO> getActiveTemplates();

    List<TemplateDTO> getTemplatesByCategory(String category);

    List<TemplateDTO> getTemplatesByFilters(String category, Boolean isPremium);

    TemplateDTO updateTemplate(Long id, TemplateUpdateRequest request);

    void deleteTemplate(Long id);

    boolean existsByTemplateKey(String key);
}