package entities;

import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDateTime moment;
    private OrderStatus orderStatus;
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order(){}

    public Order(LocalDateTime moment, OrderStatus orderStatus){
        this.moment = moment;
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItem> getOrderItems(){
        return orderItems;
    }

    public void addItem(OrderItem orderItem){
        orderItems.add(orderItem);
    }

    public void remove(OrderItem orderItem){
        orderItems.remove(orderItem);
    }

    public Double getTotal(){
        double sum = 0;
        for(OrderItem orderItem : orderItems){
            sum += orderItem.subTotal();
        }
        return sum;
    }
}
