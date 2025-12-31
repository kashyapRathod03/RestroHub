Got it 👍
Below is a **complete, ready-to-use section** you can directly add to your README, plus a **Swagger / OpenAPI 3.0 spec**.

---

# 📬 API Request & Response Examples

## 1️⃣ Create New Order

**POST** `/api/v1/orders`

### Request Body

```json
{
  "branchId": "branch_123",
  "customerName": "John Doe",
  "items": [
    {
      "itemId": "item_101",
      "name": "Margherita Pizza",
      "quantity": 2,
      "price": 8.99
    },
    {
      "itemId": "item_205",
      "name": "Pasta Alfredo",
      "quantity": 1,
      "price": 10.99
    }
  ]
}
```

### Response – 201 Created

```json
{
  "orderId": "order_789",
  "branchId": "branch_123",
  "status": "PENDING",
  "totalAmount": 28.97,
  "createdAt": "2025-01-10T12:30:45Z"
}
```

---

## 2️⃣ Get Order by ID

**GET** `/api/v1/orders/{id}`

### Response – 200 OK

```json
{
  "orderId": "order_789",
  "branchId": "branch_123",
  "status": "PREPARING",
  "items": [
    {
      "name": "Margherita Pizza",
      "quantity": 2,
      "price": 8.99
    }
  ],
  "totalAmount": 17.98
}
```

---

## 3️⃣ Get Orders by Branch

**GET** `/api/v1/orders/branch/{branchId}`

### Response – 200 OK

```json
[
  {
    "orderId": "order_001",
    "status": "COMPLETED",
    "totalAmount": 15.99
  },
  {
    "orderId": "order_002",
    "status": "PENDING",
    "totalAmount": 22.50
  }
]
```

---

## 4️⃣ Get Active Orders by Branch

**GET** `/api/v1/orders/branch/{branchId}/active`

### Response – 200 OK

```json
[
  {
    "orderId": "order_002",
    "status": "PREPARING",
    "totalAmount": 22.50
  }
]
```

---

## 5️⃣ Update Order Status

**PATCH** `/api/v1/orders/{id}/status`

### Request Body

```json
{
  "status": "COMPLETED"
}
```

### Response – 200 OK

```json
{
  "orderId": "order_789",
  "status": "COMPLETED"
}
```

---

## 6️⃣ Cancel Order

**POST** `/api/v1/orders/{id}/cancel`

### Response – 200 OK

```json
{
  "orderId": "order_789",
  "status": "CANCELLED"
}
```

---

# 📘 Swagger / OpenAPI 3.0 Documentation

You can save this as **`openapi.yaml`** and import it into **Swagger UI / Postman**.

```yaml
openapi: 3.0.3
info:
  title: RestroHub Order API
  description: API for managing restaurant orders using Builder Pattern
  version: 1.0.0

servers:
  - url: http://localhost:8080

paths:
  /api/v1/orders:
    post:
      summary: Create a new order
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/CreateOrderRequest'
      responses:
        '201':
          description: Order created successfully
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Order'

  /api/v1/orders/{id}:
    get:
      summary: Get order by ID
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: string
      responses:
        '200':
          description: Order details
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Order'

  /api/v1/orders/branch/{branchId}:
    get:
      summary: Get all orders for a branch
      parameters:
        - name: branchId
          in: path
          required: true
          schema:
            type: string
      responses:
        '200':
          description: List of orders
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Order'

  /api/v1/orders/branch/{branchId}/active:
    get:
      summary: Get active orders for a branch
      parameters:
        - name: branchId
          in: path
          required: true
          schema:
            type: string
      responses:
        '200':
          description: Active orders
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Order'

  /api/v1/orders/{id}/status:
    patch:
      summary: Update order status
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: string
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/UpdateStatusRequest'
      responses:
        '200':
          description: Status updated

  /api/v1/orders/{id}/cancel:
    post:
      summary: Cancel an order
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: string
      responses:
        '200':
          description: Order cancelled

components:
  schemas:
    CreateOrderRequest:
      type: object
      required:
        - branchId
        - items
      properties:
        branchId:
          type: string
        customerName:
          type: string
        items:
          type: array
          items:
            $ref: '#/components/schemas/OrderItem'

    OrderItem:
      type: object
      properties:
        itemId:
          type: string
        name:
          type: string
        quantity:
          type: integer
        price:
          type: number
          format: float

    Order:
      type: object
      properties:
        orderId:
          type: string
        branchId:
          type: string
        status:
          type: string
          example: PENDING
        totalAmount:
          type: number
        createdAt:
          type: string
          format: date-time

    UpdateStatusRequest:
      type: object
      properties:
        status:
          type: string
          example: COMPLETED
```

---
