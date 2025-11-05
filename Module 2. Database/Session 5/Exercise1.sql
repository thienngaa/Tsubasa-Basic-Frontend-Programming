SELECT 
    Orders.orderId,
    Orders.orderDate,
    Orders.totalAmount,
    Customers.customerName,
    Customers.contactEmail
FROM 
    Orders
JOIN 
    Customers ON Orders.customerId = Customers.customerId;
