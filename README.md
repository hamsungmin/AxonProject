# 프로젝트 셋팅

- Command -> Spring Boot + Axon + 이벤트소싱 : Aggregate, Commands, EventSourcing
  - gradlew :order-command-service:bootRun
  - http://localhost:8081/orders
  - userId:kim
    productId:prod
    price:1000
    qty:2
- Query -> Spring Boot + Axon + JPA : Projection, Query, Read Model
  - gradlew :order-query-service:bootRun
  - http://localhost:8082/orders/{orderId}
- common-api -> JAVA 모듈 : Commands/Events DTO모듈
- Axon Server -> 외부 이벤트 저장소 : Docker-Compose 사용



**Command 서비스**

Aggregate 기반으로 Commands 처리 & Event 발행 성공

**Query 서비스**

Event 기반으로 ReadModel 생성 및 수신 성공

**AxonServer**

Event Store + Message Router 역할 수행

**정상 흐름**

주문 생성 → Event 발행

Query 서비스에서 Event 수신 → DB 저장

orderId 로 조회 → 정상 응답

**아키텍처 완성**

완전한 CQRS

Command / Query 완전 분리

Event Sourcing 기반 상태 저장

DDD Aggregate 모델 확립

MSA 스타일의 확장 가능한 구조 확보
