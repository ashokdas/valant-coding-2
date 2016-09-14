# valant-coding-2

- The services are available under a single interface (InventoryManagementSystem.java)
      - AddItem - adds a new item to inventory
      - TakeItem - removes an item from inventory, returns a notification
      - ExpiryNotification - returns notification with expired items

- The AddItem service expects the expirydate in mm/dd/yyyy format, won't process otherwise
- A few test cases are added under Junit framework
