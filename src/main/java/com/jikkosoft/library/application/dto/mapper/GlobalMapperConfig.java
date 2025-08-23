package com.jikkosoft.library.application.dto.mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

/**
 * Global mapper configuration to ensure consistency across all mappers.
 * - componentModel = "spring": allows mappers to be injected as Spring beans.
 * - unmappedTargetPolicy = ERROR: ensures all fields must be mapped explicitly.
 */
@MapperConfig(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface GlobalMapperConfig {
}
