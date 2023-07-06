package com.br.consultapramim.domains.dtos;

import java.util.List;

public record PaginationResultResponseDTO<T>(List<T> content, int pageNo, int pageSize, int totalPages,
                                             long totalElements) {
}

