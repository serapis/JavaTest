package javaExam130903.one.liguanfu;

import exam.one.IFruit;

/**
 * TODO:请完成此类的编写
 */
public class Fruit implements IFruit {

    Integer id = 0;
    String name = "";
    double unitPrice = 0;
    double inventory = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;

    }


    public Double getInventory() {
        return inventory;
    }

    @Override
    public void setInventory(Double inventory) {
        this.inventory = inventory;
    }
    /**
    Fruit(Integer id, String name, double price, double inventory) {

        setId(id);


        setName(name);

        if (inventory >= 0) {
            setInventory(inventory);
        }
        if (price >= 0) {
            setUnitPrice(price);
        }
    }
**/
    Fruit(){}
}
