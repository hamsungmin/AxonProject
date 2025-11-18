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
