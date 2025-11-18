package com.axonproject.axon.common.query;

/**
 * Query 서비스에서 Order를 조회하는 요청 메시지
 */
public record FindOrderQuery(String orderId) {}
